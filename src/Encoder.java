import com.sun.source.tree.CompilationUnitTree;
import org.jfugue.midi.MidiDictionary;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class Encoder implements IEncoder {



    public static String encode (String input) {
        String output = "";

        char[] parsed = parse(input).toCharArray();

        int cur_volume = JFugueConstants.DEFAULT_VOLUME;
        int cur_octave = JFugueConstants.MIN_OCTAVE;
        int cur_instrument = JFugueConstants.DEFAULT_INSTRUMENT;

        for(int i = 0; i < parsed.length; i++){
            if(parsed[i] == '+'){
                i++;
                if(parsed[i] == 'v'){
                    cur_volume = (cur_volume * 2) % JFugueConstants.MAX_VOLUME;
                    output += ":CON(7," + Integer.toString(cur_volume) + ")";
                    if(cur_volume == 0) cur_volume = JFugueConstants.DEFAULT_VOLUME;
                }
                if(parsed[i] == 'o'){
                    cur_octave = (cur_octave + 1) % JFugueConstants.MAX_OCTAVE;
                    if(cur_octave == 0) cur_octave = JFugueConstants.MIN_OCTAVE;
                }
            }
            else if(parsed[i] == 'I') {
                String number = "";
                i++;
                while(parsed[i] != ' ') {
                    number += parsed[i];
                    i++;
                }
                i--;
                cur_instrument = Integer.parseInt(number);
                output += "I" + Integer.toString(cur_instrument);
            }
            else if(parsed[i] >= '0' && parsed[i] <= '9'){
                int offset = (int)(parsed[i] - '0');
                cur_instrument = (cur_instrument + offset) % JFugueConstants.MAX_INSTRUMENT;
                if(cur_instrument == 0) cur_instrument = JFugueConstants.DEFAULT_INSTRUMENT;
                output += "I" + Integer.toString(cur_instrument);
            }
            else{
                output += parsed[i];
                if(parsed[i] != ' ') output += Integer.toString(cur_octave);
            }
        }
        JOptionPane.showMessageDialog(null,output);
        return output;
    }
    // SOBRE O PARSE
    // Já tira todos os caracteres inválidos
    // Exceto pelos que fazem parte das palavras válidas (BPM+, T-, etc.)
    // Precisa de alguma maneira de retirar esses caracteres isolados (regex?)

    private static String parse(String input){
        String output = input;

        output = output.replaceAll("[" + "abcdefghjklmnpqrstvwxyzHJKLMNPQRSTVWXYZ" + "]","R");
        output = output.replaceAll("[^" + "ABCDEFGIOUiou !1234567890?\n;," + "]","R");

        char[] temp = output.toCharArray();

        for(int i = output.length()-1; i >= 1; i--) {
            if (temp[i] == 'R' && temp[i-1] >= 'A' && temp[i-1] <= 'G') {
                temp[i] = temp[i - 1];
            }
        }

        output = String.valueOf(temp);

        output = output.replaceAll("[ ]","+v");
        output = output.replaceAll("(?<=.)(?!v)(?!$)"," ");
        output = output.replaceAll("["+"OUIoui"+"]","I6");
        output = output.replaceAll("["+"?"+"]","+o");
        output = output.replaceAll("["+"!"+"]","I113");
        output = output.replaceAll("["+"\n"+"]","I14 ");
        output = output.replaceAll("["+";"+"]","I75");
        output = output.replaceAll("["+","+"]","I19");

        return output;
    }
//    private static String parse (String input) {
//
//        StringBuilder temp = new StringBuilder();
//        String inputNotes = input.toUpperCase();
//
//        //Substituindo vogais que não são notas por código para facilitar iteração futura (substituir por nota anterior da string)
//        inputNotes = inputNotes.replaceAll("[OUIui]", "o");
//        inputNotes = inputNotes.replaceAll(" ", "R");
//        inputNotes = inputNotes.replaceAll("[Ss]", "");     ///////// should not be needed
//        inputNotes = removeUselessCharacters(inputNotes);
//        String finalInputNotes = inputNotes;
//        Instructions.validInstructions.stream().forEach(
//                word -> temp.append(replaceWordWithCode(finalInputNotes, word.toString(), String.valueOf(word.ordinal()))  )
//        );
//
//        for (int i = 0; i < inputNotes.length(); i++) {
//            if (Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G').contains(inputNotes.charAt(i))) {
//                temp.append(inputNotes.charAt(i));
//            }
//            else if (inputNotes.charAt(i) == 'o') {
//                if (i < temp.length()) {
//                    if (Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G').contains(temp.charAt(i-1))){
//                        temp.append(temp.charAt(i-1));
//                    }
//                }
//                else {
//                    temp.append('R');
//                }
//            }
//            else if (inputNotes.charAt(i) == '?' || inputNotes.charAt(i) == '.') {
//                temp.append((char) (65 + new Random().nextInt(7)));
//            }
//        }
//        return temp.toString().replaceAll(".", "$0 ");
//    }

    private static String removeUselessCharacters (String input){
        String validCharactersComplement = "[^"+Instructions.getValidCharsAsString()+"]";
        return (input.replaceAll(validCharactersComplement,""));
    }
    //SÓ CHAMAR COM TUDO TOUPPER JÁ
    private static String replaceWordWithCode (String input, String word, String code) {
        return input.replace(word, code);
    }
}



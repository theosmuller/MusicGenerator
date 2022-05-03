import com.sun.source.tree.CompilationUnitTree;
import org.jfugue.midi.MidiDictionary;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class Encoder implements IEncoder {

    public static List<String> encode (String input) {
        List<String> output = new ArrayList<>();

        char[] parsed = parse(input).toCharArray();

        int cur_volume = 0;
        int cur_octave = 0;
        int cur_instrument = 0;

        for(int i = 0; i < parsed.length; i++){
            if(parsed[i] == '+'){
                if(parsed[i+1] == 'v'){

                }
                if(parsed[i+1] == 'i'){
                    cur_instrument = cur_instrument +
                }
                if(parsed[i+1] == 'o'){

                }
            }
            if(parsed[i] == 'I'){
            }
        }

        return output;
    }
    // SOBRE O PARSE
    // Já tira todos os caracteres inválidos
    // Exceto pelos que fazem parte das palavras válidas (BPM+, T-, etc.)
    // Precisa de alguma maneira de retirar esses caracteres isolados (regex?)

    private static String parse(String input){
        String output = input;

        output = output.replaceAll("[" + Instructions.validInstructions.REPEAT_SILENCE + "]","R ");
        output = output.replaceAll("[^" + Instructions.validInstructions.VALID_COMMAND + "]","R ");

        char[] temp = output.toCharArray();

        for(int i = output.length()-1; i >= 1; i--) {
            if (temp[i] == 'R' && temp[i-1] >= 'A' && temp[i-1] <= 'G') {
                temp[i] = temp[i - 1];
            }
            if(temp[i] >= '0' && temp[i] <= '9'){
                
            }
        }

        output = String.valueOf(temp);

        output = output.replaceAll("[ ]","+v ");
        output = output.replaceAll("["+Instructions.validInstructions.OCTAVEUP+"]","+o ");
        output = output.replaceAll("["+Instructions.validInstructions.AGOGO+"]","I113 ");
        output = output.replaceAll("["+Instructions.validInstructions.HARPSICHORD+"]","I6 ");
        output = output.replaceAll("["+Instructions.validInstructions.TUBULARBELLS+"]","I14 ");
        output = output.replaceAll("["+Instructions.validInstructions.PANFLUTE+"]","I75 ");
        output = output.replaceAll("["+Instructions.validInstructions.CHURCHORGAN+"]","I19 ");

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



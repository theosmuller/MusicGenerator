import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class Encoder implements IEncoder {
    // SOBRE O PARSE
    // Já tira todos os caracteres inválidos
    // Exceto pelos que fazem parte das palavras válidas (BPM+, T-, etc.)
    // Precisa de alguma maneira de retirar esses caracteres isolados (regex?)
    private static String parse (String input){
        StringBuilder temp = new StringBuilder();
        String validCharactersComplement = "[^"+Instructions.getValidCharsAsString()+"]";
        String inputNotes = input.toUpperCase();
        //Substituindo vogais que não são notas por código para facilitar iteração futura (substituir por nota anterior da string)
        inputNotes = inputNotes.replaceAll("[OUIui]", "o");
        inputNotes = inputNotes.replaceAll(" ", "R");
        inputNotes = inputNotes.replaceAll("[Ss]", "");     ///////// should not be needed
        inputNotes = inputNotes.replaceAll(validCharactersComplement,"");
//        CharacterIterator it = new StringCharacterIterator(input);
//        while (it.current() != CharacterIterator.DONE){
//            if (it.current() == 'o'){
//                if (it.previous() == 'A'){
//                    //it.current()
//                }
//            }
//            it.next();
//        }
        for (int i = 0; i < inputNotes.length(); i++){
            if (Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G').contains(inputNotes.charAt(i))){
                temp.append(inputNotes.charAt(i));
            }
            else if (inputNotes.charAt(i) == 'o') {
                if (i < temp.length()) {
                    if (Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G').contains(temp.charAt(i-1))){
                        temp.append(temp.charAt(i-1));
                    }
                }
                else {
                    temp.append('R');
                }
            }
            else if (inputNotes.charAt(i) == '?' || inputNotes.charAt(i) == '.') {
                temp.append((char) (65 + new Random().nextInt(7)));
            }
        }
        return temp.toString().replaceAll(".", "$0 ");


//        inputNotes = inputNotes.replaceAll(".", "$0 ");
//        System.out.println(inputNotes);
//        return inputNotes;
    }
    public static List<String> encode (String input){
        List<String> output = new ArrayList<>();
        output.add(parse(input));
        return output;
    }
}


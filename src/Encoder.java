import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class Encoder implements IEncoder {
    // SOBRE O PARSE
    // Já tira todos os caracteres inválidos
    // Exceto pelos que fazem parte das palavras válidas (BPM+, T-, etc.)
    // Precisa de alguma maneira de retirar esses caracteres isolados (regex?)
    private static String parse (String input){
        String validCharactersComplement = "[^"+Instructions.getValidCharsAsString()+"]";
        String inputNotes = input.toUpperCase();
        //Substituindo vogais que não são notas por código para facilitar iteração futura (substituir por nota anterior da string)
        inputNotes = inputNotes.replaceAll("[OUIui]", "o");
        inputNotes = inputNotes.replaceAll(" ", "R");
        inputNotes = inputNotes.replaceAll(validCharactersComplement,"");
        CharacterIterator it = new StringCharacterIterator(input);
        while (it.current() != CharacterIterator.DONE){
            if (it.current() == 'o'){
                if (it.previous() == 'A'){
                    //it.current()
                }
            }
            it.next();
        }
        inputNotes = inputNotes.replaceAll(".", "$0 ");
        return inputNotes;
    }
    public static List<String> encode (String input){
        List<String> output = new ArrayList<>();
        output.add(parse(input));
        return output;
    }
}


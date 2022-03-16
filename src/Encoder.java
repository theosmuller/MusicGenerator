import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class Encoder implements IEncoder {

//    private List<String> validInstructions = null;
//
//    public Encoder (List<String> vi){
//        validInstructions = vi;
//    }
//
//    private List<String> complexValidInstructions = null;
//
//    public void parseAndEncode(String input, List<String> validInstructions) {
//        createComplexValidInstructionsList(validInstructions, complexValidInstructions);
//        CharacterIterator it = new StringCharacterIterator(input);
//        while (it.current() != CharacterIterator.DONE){
//            if (validInstructions.contains(it.current())) {
//
//            }
//            else{
//                for (String s : this.complexValidInstructions)  {
//                    if(s.startsWith(it.current())){
//
//                    }
//                }
//            }
//
//        }
//    }
//    private void createComplexValidInstructionsList (List<String> vi, List<String> cvi){
//        for (String s : vi) {
//            if (s.length()>1){
//                cvi.add(s);
//                vi.remove(s);
//            }
//        };
//    }
    public static String parse (String input){
        List<String> parsedList = new ArrayList<String>();
        CharacterIterator it = new StringCharacterIterator(input);
        String inputNotes = input.replaceAll("[^a-gA-G]", " ");
//        while (it.current() != CharacterIterator.DONE){
//            //TODA A PARTE DE TRATAR BPM+ E -
//
//            if (it.current() == 'b'|| it.current() =='B'){
//                if (it.next() == 'p' || it.next() == 'P'){
//                    if (it.next() == 'm' || it.next() == 'M'){
//                        if (it.next() == '+'){
//                            parsedList.add("BPM+");
//                        }
//                        else{
//                            if(it.current() == '-'){
//                                parsedList.add("BPM-");
//                        }
//                    }
//                }
//            }
//        }
//
//            //TODA A PARTE DE TRATAR T+ E -
//            if ((it.current() == 't'|| it.current() =='T')&& (it.next() == '+')) {
//                parsedList.add("T+");
//            }
//            if ((it.current() == 't'|| it.current() =='T')&& (it.next() == '-')) {
//                parsedList.add("T-");
//            }
//            else{
//                parsedList.add(Character.toString(it.current()));
//                it.next();
//            }
//        }
//        return parsedList;
        return inputNotes;
    }
}


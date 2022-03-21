import java.util.*;

public class Instructions {
    private static final String NOTES = "ABCDEFGabcdefg";
    private static final String BPM_INCREASE = "BPM+";
    private static final String BPM_DECREASE = "BPM-";
    private static final String TEMPO_INCREASE = "T+";
    private static final String TEMPO_DECREASE = "T-";
    private static final String VOLUME_INCREASE = "+";
    private static final String VOLUME_DECREASE = "-";
    private static final String RANDOMNOTE = ".?";
    private static final String NEWLINE = "\n";
    private static final String REST = "R";
    private static final String VOWELREPLACE = "o";


    public static List<String> getValidCharsAsList(){
        return new ArrayList<>(Arrays.asList(
                Instructions.NOTES,
                Instructions.BPM_INCREASE,
                Instructions.BPM_DECREASE,
                Instructions.TEMPO_DECREASE,
                Instructions.TEMPO_INCREASE,
                Instructions.VOLUME_DECREASE,
                Instructions.VOLUME_INCREASE,
                Instructions.RANDOMNOTE,
                Instructions.NEWLINE,
                Instructions.REST,
                Instructions.VOWELREPLACE
        ));
    }
    public static String getValidCharsAsString(){
        List<String> vcList = getValidCharsAsList();
        return String.join("",vcList);
    }
}

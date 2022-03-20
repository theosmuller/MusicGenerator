import java.util.*;

public class Instructions {
    public static final String NOTES = "ABCDEFGabcdefg";
    public static final String BPM_INCREASE = "BPM+";
    public static final String BPM_DECREASE = "BPM-";
    public static final String TEMPO_INCREASE = "T+";
    public static final String TEMPO_DECREASE = "T-";
    public static final String VOLUME_INCREASE = "+";
    public static final String VOLUME_DECREASE = "-";
    public static final String RANDOMNOTE = ".?";
    public static final String NEWLINE = "\n";
    public static final String REST = "R";
    public static final String VOWELREPLACE = "o";


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

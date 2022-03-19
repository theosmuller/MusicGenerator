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
        List<String> validChars = new ArrayList<>();
        validChars.addAll(Arrays.asList(
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
                )
        );
        return validChars;
    }
    public static String getValidCharsAsString(){
        List<String> vcList = getValidCharsAsList();
        String vcString = String.join("",vcList);
        return vcString;
    }
}

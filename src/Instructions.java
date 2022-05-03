import java.util.*;
import java.util.stream.Stream;

public class Instructions {


    public enum validInstructions {
        NOTES ("ABCDEFG"),

        REPEAT_SILENCE ("abcdefghjklmnpqrstvwxyzHJKLMNPQRSTVWXYZ"),

        DIGIT ("!"),
        AGOGO ("!"),
        HARPSICHORD ("OUIoui"),
        OCTAVEUP ("?"),
        TUBULARBELLS ("\n"),
        PANFLUTE (";"),
        CHURCHORGAN (","),

        VALID_COMMAND ("ABCDEFGIOUiou !1234567890?\n;,"),
        BPM_INCREASE ("BPM+"),
        BPM_DECREASE ("BPM-"),
        TEMPO_INCREASE ("T+"),
        TEMPO_DECREASE ("T-"),
        VOLUME_INCREASE ("+"),
        VOLUME_DECREASE ("-"),
        RANDOMNOTE (".?"),
        NEWLINE ("\n"),
        REST ("R"),
        VOWELREPLACE ("o");

        private final String instructionValue;
        validInstructions(final String iv){
            this.instructionValue = iv;
        }

        static Stream<validInstructions> stream(){
            return Stream.of(validInstructions.values());
        }
    }

    public static String getValidCharsAsString() {
        return (Arrays.toString(validInstructions.class.getEnumConstants()));
        }

    public static List<validInstructions> getValidCharsAsList() {
        return (validInstructions.stream().toList());
    }
}

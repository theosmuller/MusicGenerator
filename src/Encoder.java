import javax.swing.*;

public class Encoder implements IEncoder {
    public static String encode(String input) {
        String output = "";

        char[] parsed = parse(input).toCharArray();

        int cur_volume = JFugueConstants.DEFAULT_VOLUME;
        int cur_octave = JFugueConstants.MIN_OCTAVE;
        int cur_instrument = JFugueConstants.DEFAULT_INSTRUMENT;

        for (int i = 0; i < parsed.length; i++) {
            if (parsed[i] == '+') {
                i++;
                if (parsed[i] == 'v') {
                    cur_volume = (cur_volume * 2) % JFugueConstants.MAX_VOLUME;
                    output += ":CON(7," + cur_volume + ")";
                    if (cur_volume == 0) cur_volume = JFugueConstants.DEFAULT_VOLUME;
                }
                if (parsed[i] == 'o') {
                    cur_octave = (cur_octave + 1) % JFugueConstants.MAX_OCTAVE;
                    if (cur_octave == 0) cur_octave = JFugueConstants.MIN_OCTAVE;
                }
            } else if (parsed[i] == 'I') {
                String number = "";
                i++;
                while (parsed[i] != ' ') {
                    number += parsed[i];
                    i++;
                }
                i--;
                cur_instrument = Integer.parseInt(number);
                output += "I" + cur_instrument;
            } else if (parsed[i] >= '0' && parsed[i] <= '9') {
                int offset = parsed[i] - '0';
                cur_instrument = (cur_instrument + offset) % JFugueConstants.MAX_INSTRUMENT;
                if (cur_instrument == 0) cur_instrument = JFugueConstants.DEFAULT_INSTRUMENT;
                output += "I" + cur_instrument;
            } else {
                output += parsed[i];
                if (parsed[i] != ' ') output += Integer.toString(cur_octave);
            }
        }
        if (JFugueConstants.IS_DEBUG_ON) {
            JOptionPane.showMessageDialog(null, output);
        }
        return output;
    }

    private static String parse(String input) {
        String output = input;

        output = output.replaceAll("[abcdefghjklmnpqrstvwxyzHJKLMNPQRSTVWXYZ]", "R");
        output = output.replaceAll("[^ABCDEFGIOUiou !1234567890?\n;,]", "R");

        char[] temp = output.toCharArray();

        for (int i = output.length() - 1; i >= 1; i--) {
            if (temp[i] == 'R' && temp[i - 1] >= 'A' && temp[i - 1] <= 'G') {
                temp[i] = temp[i - 1];
            }
        }
        output = String.valueOf(temp);
        output = replaceSymbolWithInstruction(output);

        return output;
    }

    private static String replaceSymbolWithInstruction(String s) {
        s = s.replaceAll("[ ]", "+v");
        s = s.replaceAll("(?<=.)(?!v)(?!$)", " ");
        s = s.replaceAll("[OUIoui]", "I6");
        s = s.replaceAll("[?]", "+o");
        s = s.replaceAll("[!]", "I113");
        s = s.replaceAll("[\n]", "I14 ");
        s = s.replaceAll("[;]", "I75");
        s = s.replaceAll("[,]", "I19");
        return s;
    }
}

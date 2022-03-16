import java.util.List;

public class MainProgram {
    public static void main(String args[]){
        String input = UserInterface.getInput();
        List<String> parsedString = Encoder.parse(input);
        String delim = "";
        String pstostring = String.join(delim, parsedString);
        UserInterface.displayParsedString(pstostring);
    }
}

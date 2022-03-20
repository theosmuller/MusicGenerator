import java.util.List;

public class MainProgram {
    public static void main(String[] args){
        String input = UserInterface.getInput();
        List<String> parsedString = Encoder.encode(input);
        Interpreter.play(parsedString);
        UserInterface.displayParsedString(parsedString.toString());
    }
}

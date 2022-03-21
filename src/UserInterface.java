import javax.swing.*;
import java.util.List;

public class UserInterface implements IUserInterface {

    public ProgramState programState = new ProgramState();
    public void start(){
        String input = UserInterface.getInput();
        programState.setMusicVector(Encoder.encode(input));
        programState.interpreter.play(programState.musicVector);
        UserInterface.displayParsedString(programState.musicText);
    }

    public static String getInput(){
        return (JOptionPane.showInputDialog("Insert music string: "));
    }
    public static void displayParsedString(String s){
        JOptionPane.showMessageDialog(null, "Playing the following string: "+s);
    }

    private void onPauseButtonClicked(){
        if (programState.isPaused) {
            programState.pause();
        }
        else{
            programState.unpause();
        }
    }
}

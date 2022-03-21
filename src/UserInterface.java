import javax.swing.*;
import java.util.List;

public class UserInterface implements IUserInterface {

    private final ProgramState programState = new ProgramState();
    public void start(){
        String input = UserInterface.getInput();
        programState.setMusicVector(Encoder.encode(input));
        programState.playInterpreter();
        UserInterface.displayParsedString(programState.getMusicText());
    }

    public static String getInput(){
        return (JOptionPane.showInputDialog("Insert music string: "));
    }
    public static void displayParsedString(String s){
        JOptionPane.showMessageDialog(null, "Playing the following string: "+s);
    }

    private void onPauseButtonClicked(){
        if (programState.getPaused()) {
            programState.pause();
        }
        else{
            programState.unpause();
        }
    }
}

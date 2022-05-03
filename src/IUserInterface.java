import javax.swing.*;

public interface IUserInterface {

    ProgramState programState = null;
    JFrame mainWindow = null;
    JButton helpButtonWidget = null;
    JButton playButtonWidget = null;
    JTextArea userInputWidget = null;
    JButton stopButtonWidget = null;

    private void setUpButtonListeners(){}
    void start();

    private void startPlay(){}
    private String getInput(){
        return null;
    }

    private void displayParsedString(String s) {  }

    private void onPauseButtonClicked() {  }
}

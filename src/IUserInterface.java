import javax.swing.*;

public interface IUserInterface {
    ProgramState programState = null;
    JFrame mainWindow = null;
    JButton helpButtonWidget = null;
    JButton playButtonWidget = null;
    JTextArea userInputWidget = null;
    JButton stopButtonWidget = null;

    public void setButtonBounds(JButton button, JFugueConstants.BoxInfo boxInfo);

    public void start();

    private void setUpButtonListeners() { }

    private void onHelpButtonPressed() { }

    private void onLoadButtonPressed() { }

    private void onPlayButtonPressed() { }

    private void onStopButtonPressed() { }

    private void onSaveButtonPressed() { }

    private void startPlay() { }

    public void playEnded();
}

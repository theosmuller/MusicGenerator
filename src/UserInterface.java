import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class UserInterface implements IUserInterface {

    private final ProgramState programState = new ProgramState();
    public final JFrame mainWindow = new JFrame("Music Generator");
    private final JButton helpButtonWidget = new JButton("Help");
    private final JButton playButtonWidget = new JButton("Play");
    private final JButton stopButtonWidget = new JButton("Stop");
    private final JButton saveButtonWidget = new JButton("Save");
    private final JTextArea userInputWidget = new JTextArea();

    public void start(){
        // setup da area de texto pro usuario
        userInputWidget.setBounds(10,10,270,200);
        mainWindow.setSize(300,300);
        mainWindow.setLayout(null);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
        mainWindow.add(userInputWidget);
        // play, stop and help button setup
        helpButtonWidget.setBounds(10, 220, 130, 30);
        playButtonWidget.setBounds(150, 220, 130, 30);
        stopButtonWidget.setBounds(150, 220, 130, 30);
        saveButtonWidget.setBounds(10, 220, 130, 30);
        mainWindow.add(helpButtonWidget);
        mainWindow.add(playButtonWidget);
        mainWindow.add(stopButtonWidget);
        mainWindow.add(saveButtonWidget);
        setUpButtonListeners();
    }

    private void setUpButtonListeners(){
        ActionListener helpButtonListener = e -> JOptionPane.showMessageDialog(null, "help");
        ActionListener playButtonListener = e -> {
            playButtonWidget.setVisible(false);
            stopButtonWidget.setVisible(true);
            helpButtonWidget.setVisible(false);
            saveButtonWidget.setVisible(true);
            startPlay();
        };
        ActionListener stopButtonListener = e -> {
            stopButtonWidget.setVisible(false);
            playButtonWidget.setVisible(true);
            helpButtonWidget.setVisible(false);
            saveButtonWidget.setVisible(true);
            programState.pause();
        };
        ActionListener saveButtonListener = e -> onSaveButtonPressed();

        helpButtonWidget.addActionListener(helpButtonListener);
        playButtonWidget.addActionListener(playButtonListener);
        stopButtonWidget.addActionListener(stopButtonListener);
        saveButtonWidget.addActionListener((saveButtonListener));
    }

    private void startPlay(){
        programState.setMusicText(Encoder.encode(userInputWidget.getText()));
        programState.playInterpreter(this);
    }
    public static String getInput() {
        return (JOptionPane.showInputDialog("Insert music string: "));
    }

    public static void displayParsedString(String s) {
        JOptionPane.showMessageDialog(null, "Playing the following string: "+s);
    }

    public void playEnded(){
        this.stopButtonWidget.setVisible(false);
        this.playButtonWidget.setVisible(true);
        helpButtonWidget.setVisible(true);
        saveButtonWidget.setVisible(false);
    }
    private void onPauseButtonClicked() {
        if (programState.getPaused()) {
            programState.pause();
        }
        else{
            programState.unpause();
        }
    }

    private void onSaveButtonPressed() {
        // Our patterns…
        try {
            File filePath = new File("./MIDI/track.midi");
            MidiFileManager.savePatternToMidi(new Pattern(programState.getMusicText()), filePath);
            JOptionPane.showMessageDialog(null, "Saved song to MIDI");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

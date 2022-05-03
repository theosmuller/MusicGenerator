import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface implements IUserInterface {
    private final ProgramState programState = new ProgramState();
    public final JFrame mainWindow = new JFrame("Music Generator");
    private final JButton helpButtonWidget = new JButton("Help");
    private final JButton loadButtonWidget = new JButton("Load");
    private final JButton playButtonWidget = new JButton("Play");
    private final JButton stopButtonWidget = new JButton("Stop");
    private final JButton saveButtonWidget = new JButton("Save");
    private final JTextArea userInputWidget = new JTextArea();

    public void setButtonBounds(JButton button, JFugueConstants.BoxInfo boxInfo) {
        button.setBounds(boxInfo.getX(), boxInfo.getY(), boxInfo.getWidth(), boxInfo.getHeight());
    }

    public void start() {
        mainWindow.setSize(JFugueConstants.WINDOW_WIDTH, JFugueConstants.WINDOW_HEIGHT);
        mainWindow.setLayout(null);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);

        userInputWidget.setBounds(10, 10, 270, 200);
        userInputWidget.setBounds(JFugueConstants.inputWidget.getX(), JFugueConstants.inputWidget.getY(),
                JFugueConstants.inputWidget.getWidth(), JFugueConstants.inputWidget.getHeight());
        mainWindow.add(userInputWidget);

        setButtonBounds(helpButtonWidget, JFugueConstants.helpButton);
        setButtonBounds(loadButtonWidget, JFugueConstants.loadButton);
        setButtonBounds(saveButtonWidget, JFugueConstants.saveButton);
        setButtonBounds(playButtonWidget, JFugueConstants.playButton);
        setButtonBounds(stopButtonWidget, JFugueConstants.stopButton);

        mainWindow.add(helpButtonWidget);
        mainWindow.add(loadButtonWidget);
        mainWindow.add(playButtonWidget);
        mainWindow.add(stopButtonWidget);
        mainWindow.add(saveButtonWidget);
        setUpButtonListeners();
    }

    private void setUpButtonListeners() {
        ActionListener helpButtonListener = e -> onHelpButtonPressed();
        ActionListener loadButtonListener = e -> onLoadButtonPressed();
        ActionListener playButtonListener = e -> onPlayButtonPressed();
        ActionListener stopButtonListener = e -> onStopButtonPressed();
        ActionListener saveButtonListener = e -> onSaveButtonPressed();

        helpButtonWidget.addActionListener(helpButtonListener);
        loadButtonWidget.addActionListener(loadButtonListener);
        playButtonWidget.addActionListener(playButtonListener);
        stopButtonWidget.addActionListener(stopButtonListener);
        saveButtonWidget.addActionListener(saveButtonListener);
    }

    private void onHelpButtonPressed() {
        JOptionPane.showMessageDialog(null, JFugueConstants.HELP_MESSAGE);
    }

    private void onLoadButtonPressed() {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("C:\\"));

        int response = fc.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fc.getSelectedFile().getAbsolutePath());

            Scanner scan;
            try {
                scan = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            String musicText = "";
            while (scan.hasNextLine()) {
                musicText = musicText.concat(scan.nextLine() + '\n');
            }
            userInputWidget.setText(musicText);
        }
    }

    private void onPlayButtonPressed() {
        helpButtonWidget.setVisible(true);
        saveButtonWidget.setVisible(true);
        stopButtonWidget.setVisible(true);
        playButtonWidget.setVisible(false);
        loadButtonWidget.setVisible(false);
        startPlay();
    }

    private void onStopButtonPressed() {
        helpButtonWidget.setVisible(true);
        loadButtonWidget.setVisible(true);
        playButtonWidget.setVisible(true);
        stopButtonWidget.setVisible(false);
        saveButtonWidget.setVisible(false);
        programState.stop();
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

    private void startPlay() {
        String encodedMusicText = Encoder.encode(userInputWidget.getText());
        programState.setMusicText(encodedMusicText);
        programState.playInterpreter(this);
    }

    public void playEnded() {
        this.playButtonWidget.setVisible(true);
        this.loadButtonWidget.setVisible(true);
        this.stopButtonWidget.setVisible(false);
        helpButtonWidget.setVisible(true);
        saveButtonWidget.setVisible(false);
    }
}

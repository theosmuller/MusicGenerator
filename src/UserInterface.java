import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

import javax.swing.*;
import java.awt.event.ActionEvent;
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
    private final String helpText =
            "Instruções - Mapeamento de Caracteres:\n" +
            "A => Nota Lá    B => Nota Si    C => Nota Dó    D => Nota Ré\n" +
            "E => Nota Mi    F => Nota Fá    G => Nota Sol\n" +
            "a,b,c,d,e,f,g => Repete nota (se char anterior era nota) ou Silêncio\n" +
            "Espaço => Dobra volume ou volume = default (se impossível dobrar)\n" +
            "! => Instrumento = Agogo\n" +
            "i,I,o,O,u,U => Instrumento = Harpsichord\n" +
            "Outras consoantes => Repete nota (se char anterior era nota) ou Silêncio\n" +
            "Número => Instrumento MIDI = atual + número\n" +
            "? => Aumenta uma oitava ou oitava = default (se impossível aumentar)\n" +
            "NL => Instrumento = tubular bells\n" +
            "; => Instrumento = pan flute\n" +
            ", => Instrumento = church organ\n" +
            "ELSE => Repete nota (se char anterior era nota) ou Silêncio";

    public void start() {
        // setup da area de texto pro usuario
        userInputWidget.setBounds(10,10,270,200);
        mainWindow.setSize(305,340);
        mainWindow.setLayout(null);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
        mainWindow.add(userInputWidget);
        // play, stop and help button setup
        helpButtonWidget.setBounds(10, 220, 130, 30);
        loadButtonWidget.setBounds(150, 220, 130, 30);
        playButtonWidget.setBounds(10, 260, 270, 30);
        saveButtonWidget.setBounds(150, 220, 130, 30);
        stopButtonWidget.setBounds(10, 260, 270, 30);

        mainWindow.add(helpButtonWidget);
        mainWindow.add(loadButtonWidget);
        mainWindow.add(playButtonWidget);
        mainWindow.add(stopButtonWidget);
        mainWindow.add(saveButtonWidget);
        setUpButtonListeners();
    }

    private void setUpButtonListeners() {
        ActionListener helpButtonListener = e -> JOptionPane.showMessageDialog(null, helpText);

        ActionListener loadButtonListener = e -> onLoadButtonPressed();

        ActionListener playButtonListener = e -> {
            helpButtonWidget.setVisible(true);
            saveButtonWidget.setVisible(true);
            stopButtonWidget.setVisible(true);
            playButtonWidget.setVisible(false);
            loadButtonWidget.setVisible(false);
            startPlay();
        };

        ActionListener stopButtonListener = e -> {
            helpButtonWidget.setVisible(true);
            loadButtonWidget.setVisible(true);
            playButtonWidget.setVisible(true);
            stopButtonWidget.setVisible(false);
            saveButtonWidget.setVisible(false);
            programState.pause();
        };

        ActionListener saveButtonListener = e -> onSaveButtonPressed();

        helpButtonWidget.addActionListener(helpButtonListener);
        loadButtonWidget.addActionListener(loadButtonListener);
        playButtonWidget.addActionListener(playButtonListener);
        stopButtonWidget.addActionListener(stopButtonListener);
        saveButtonWidget.addActionListener(saveButtonListener);
    }

    private void startPlay() {
        programState.setMusicText(Encoder.encode(userInputWidget.getText()));
        programState.playInterpreter(this);
    }

    public static String getInput() {
        return (JOptionPane.showInputDialog("Insert music string: "));
    }

    public static void displayParsedString(String s) {
        JOptionPane.showMessageDialog(null, "Playing the following string: " + s);
    }

    public void playEnded(){
        this.playButtonWidget.setVisible(true);
        this.loadButtonWidget.setVisible(true);
        this.stopButtonWidget.setVisible(false);
        helpButtonWidget.setVisible(true);
        saveButtonWidget.setVisible(false);
    }

    private void onPauseButtonClicked() {
        if (programState.getPaused()) {
            programState.pause();
        }
        else {
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

    private void onLoadButtonPressed() {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("C:\\"));

        int response = fc.showOpenDialog(null);

        if (response == fc.APPROVE_OPTION) {
            File file = new File(fc.getSelectedFile().getAbsolutePath());
            Scanner scan = null;
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
}

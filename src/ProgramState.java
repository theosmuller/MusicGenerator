import java.util.List;

public class ProgramState implements IProgramState{

    private String musicText = null;
    private Boolean isPaused = false;
    private final Interpreter interpreter;

    public ProgramState(){
        interpreter = new Interpreter();
    }

    void pause() {
        interpreter.pause();
        isPaused = true;
    }
    void unpause() {
        interpreter.resume();
        isPaused = false;
    }
    public void setMusicText (String input) {
        musicText = input;
    }

    public String getMusicText() {
        return musicText;
    }

    public Boolean getPaused() {
        return isPaused;
    }

    public Interpreter getInterpreter() {
        return interpreter;
    }

    public void playInterpreter(UserInterface window) {
        this.interpreter.play(this.musicText, window);
    }
}

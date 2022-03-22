import java.util.List;

public class ProgramState implements IProgramState{

    private String musicText = null;
    private List<String> musicVector = null;
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

    void setMusicVector(List<String> newMusicVector) {
        musicVector = newMusicVector;
        setMusicText();
    }

    private void setMusicText () {
        musicText = musicVector.toString();
    }

    public String getMusicText() {
        return musicText;
    }

    public List<String> getMusicVector() {
        return musicVector;
    }

    public Boolean getPaused() {
        return isPaused;
    }

    public Interpreter getInterpreter() {
        return interpreter;
    }

    public void playInterpreter() {
        this.interpreter.play(this.getMusicVector());
    }
}

import java.util.List;

public class ProgramState implements IProgramState{

    String musicText = null;
    List<String> musicVector = null;
    Boolean isPaused = false;
    Interpreter interpreter;

    public ProgramState(){
        interpreter = new Interpreter();
    }

    void pause() {
        interpreter.currentPlayer.getManagedPlayer().pause();
        isPaused = true;
    }
    void unpause() {
        interpreter.currentPlayer.getManagedPlayer().resume();
        isPaused = false;
    }

    void setMusicVector(List<String> newMusicVector) {
        musicVector = newMusicVector;
        setMusicText();
    }

    private void setMusicText () {
        musicText = musicVector.toString();
    }

}

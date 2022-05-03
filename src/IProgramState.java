import java.util.List;

public interface IProgramState {

    String musicText = null;
    Boolean isPaused = false;
    Interpreter interpreter = null;

    static void pause() { }

    static void unpause() { }

    static void setMusicText(String newMusicText) { }
}

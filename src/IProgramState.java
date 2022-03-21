import java.util.List;

public interface IProgramState {
    String musicText = null;
    List<String> musicVector = null;
    Boolean isPaused = false;
    Interpreter interpreter = null;

    static void pause() {

    }

    static void unpause() {

    }

    static void setMusicVector(List<String> newMusicVector){

    }

    static void setMusicText(String newMusicText) {

    }
}

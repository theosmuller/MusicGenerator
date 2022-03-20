import java.util.List;

public interface ProgramState {

    String musicText = null;
    List<String> musicVector = null;
    Boolean isPaused = false;

    void setMusicText();

}

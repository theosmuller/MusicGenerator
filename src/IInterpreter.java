import org.jfugue.player.Player;

public interface IInterpreter {

    default void play(String musicString, UserInterface window) {
        new Thread(createThread(musicString, window));
    }

    private Runnable createThread(String musicString, UserInterface window) {
        return null;
    }

    public void stop();

}

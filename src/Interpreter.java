import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class Interpreter implements IInterpreter {
    private Player currentPlayer;

    public void play(String musicString, UserInterface window) {
        new Thread(createThread(musicString, window)).start();
    }

    private Runnable createThread(String musicString, UserInterface window) {
        return () -> {
            currentPlayer = new Player();
            Pattern pattern = new Pattern(musicString);
            currentPlayer.play(pattern);
            window.playEnded();
        };
    }

    public void stop() {
        currentPlayer.getManagedPlayer().pause();
    }
}



import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import java.util.List;

public class Interpreter implements IInterpreter {

    private Player currentPlayer;

    public void play(List<String> musicString) {
        new Thread(createThread(musicString)).start();
    }

    private Runnable createThread(List<String> musicStrings) {
        return () -> {
            currentPlayer = new Player();
            for (String s : musicStrings) {
                Pattern pattern = new Pattern(s);
                currentPlayer.play(pattern);
                //isso aqui vai dar problema, tem que garantir q a thread n vai ignorar os pause
                //do programstate e que esse for só vai pra proxima string qnd acabar de tocar o pattern
            }
        };
    }

    public void pause() {
        currentPlayer.getManagedPlayer().pause();
    }

    public void resume() {
        currentPlayer.getManagedPlayer().resume();
    }
}



import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import java.io.File;
import java.io.IOException;

public class Maestro implements IMaestro {
    public static void play(String musicString){
        new Thread(createThread(musicString)).start();
    }

    private static Runnable createThread(String musicString) {
        return () -> {
            Player player = new Player();
            Pattern pattern = new Pattern(musicString);
            player.play(pattern);
        };
    }
}
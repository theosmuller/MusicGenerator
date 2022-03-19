import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import java.io.File;
import java.io.IOException;

public class Interpreter implements IInterpreter {
    public static void play(List<String> musicString){
        new Thread(createThread(musicString)).start();
    }

    private static Runnable createThread(List<String> musicStrings) {
        return () -> {
            Player player = new Player();
            for (String s : musicStrings){
                Pattern pattern = new Pattern(s);
                player.play(pattern);
            }
        };
    }
}
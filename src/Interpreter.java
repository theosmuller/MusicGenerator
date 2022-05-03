import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

// Classe que define o interpretador da string recebida e seus comportamentos
public class Interpreter implements IInterpreter {
    private Player currentPlayer;

    @Override   // cria a thread que ira efetivamente executar a musica
    public void play(String musicString, UserInterface window) {
        new Thread(createThread(musicString, window)).start();
    }

    // cria uma thread para tornar possivel a execucao da musica em paralelo com a execucao do programa
    private Runnable createThread(String musicString, UserInterface window) {
        return () -> {
            currentPlayer = new Player();
            Pattern pattern = new Pattern(musicString);
            currentPlayer.play(pattern);
            window.playEnded();
        };
    }

    // metodo que pausa a execucao do programa
    public void stop() {
        currentPlayer.getManagedPlayer().pause();
    }
}

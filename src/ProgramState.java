public class ProgramState implements IProgramState {

    private String musicText = null;
    private final Interpreter interpreter;

    // construtor da classe
    public ProgramState() {
        interpreter = new Interpreter();
    }

    // funcao para parar o interpreter que esta executando a musica
    public void stop() {
        interpreter.stop();
    }

    // funcao para a armazenar string fornecida pelo usuário
    public void setMusicText(String input) {
        musicText = input;
    }

    // retornar a string fornecida pelo usuario
    public String getMusicText() {
        return musicText;
    }

    // funcao para iniciar o interpreter que executara a musica
    public void playInterpreter(UserInterface window) {
        this.interpreter.play(this.musicText, window);
    }
}

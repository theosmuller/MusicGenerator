public class ProgramState implements IProgramState {

    private String musicText = null;
    private final Interpreter interpreter;

    public ProgramState() {
        interpreter = new Interpreter();
    }

    public void stop() {
        interpreter.stop();
    }

    public void setMusicText(String input) {
        musicText = input;
    }

    public String getMusicText() {
        return musicText;
    }

    public void playInterpreter(UserInterface window) {
        this.interpreter.play(this.musicText, window);
    }
}

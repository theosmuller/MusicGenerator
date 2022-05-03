public interface IProgramState {
    String musicText = null;
    Interpreter interpreter = null;


    public void stop();

    public void setMusicText(String input);

    public String getMusicText();

    public void playInterpreter(UserInterface window);

}

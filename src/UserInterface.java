import javax.swing.*;

public class UserInterface {

    public static String getInput(){

        String input = JOptionPane.showInputDialog("Insert music string: ");
        return (input);
    }
    public static void displayParsedString(String s){
        JOptionPane.showMessageDialog(null, "Playing the following string: "+s);
    }
}

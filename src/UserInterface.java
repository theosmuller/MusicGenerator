import javax.swing.*;

public class UserInterface {

    public static String getInput(){
        return (JOptionPane.showInputDialog("Insert music string: "));
    }
    public static void displayParsedString(String s){
        JOptionPane.showMessageDialog(null, "Playing the following string: "+s);
    }
}

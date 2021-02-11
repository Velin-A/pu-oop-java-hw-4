import javax.swing.*;

public class Modal extends JDialog {

    /*
        Constructor for the Modal window, giving feedback to the user
     */

    public Modal( JFrame parent, String title, String message){
        super(parent, title, true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);


        panel.add(label);
        getContentPane().add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);

    }
    /*
        Method rendering the Modal window
     */
    public static void render(JFrame parent, String title, String message) {
        new Modal(parent, title,message);
    }

}

import javax.swing.*;
import java.awt.*;

public class Login_Page extends JFrame{
    private JTextField username;
    private JPasswordField password;
    private JPanel panel;
    private JButton loginbutton;
    private JPanel panel1;
    private JLabel lblform;
    private JButton EXITButton;
    private JFrame frame;

    public Login_Page(){
        frame = new JFrame("LOGIN PAGE");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,300));
        frame.setResizable(false);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JButton EXITButton;




    }
}

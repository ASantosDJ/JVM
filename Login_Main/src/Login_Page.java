import Login_GUI.Main_Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.SystemColor.window;
import static javax.swing.JOptionPane.showMessageDialog;

public class Login_Page extends JFrame{
    private JTextField username;
    private JPasswordField password;
    private JPanel panel;
    private JButton loginbutton;
    private JPanel panel1;
    private JLabel lblform;
    private JFrame frame;

    public Login_Page(){
        frame = new JFrame("PAGE");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,300));
        frame.setResizable(false);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String user = username.getText();
                String pw = String.valueOf(password.getPassword());
                if (user.equals("user") && pw.equals("pass")) {
                    String name1 = "Login Successful";
                    JOptionPane.showMessageDialog(null, name1);

                    Main_Page form = new Main_Page();
                    frame.setContentPane(form.main_panel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }
                else if (user.equals("") && pw.equals("")){
                    String name = "Invalid Username or Password";
                    JOptionPane.showMessageDialog(null, name);
                }
                else if (!user.equals("user") && !pw.equals("pass")){
                    String name3 = "Incorrect Username and Password";
                    JOptionPane.showMessageDialog(null, name3);
                }


                }





        });
    }
}

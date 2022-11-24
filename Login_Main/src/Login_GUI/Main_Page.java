package Login_GUI;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main_Page {
    private JButton addButton;
    private JButton addButton1;
    private JButton addButton4;
    private JButton editButton;
    private JButton editButton1;
    private JButton editButton2;
    private JButton deleteButton;
    private JButton deleteButton1;
    private JButton deleteButton2;
    public JPanel main_panel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("PAGE");
        frame.setContentPane(new Main_Page().main_panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,300));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

}

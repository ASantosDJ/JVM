
//import com.ddbb.LECTURER;

import com.ddbb.LECTURER;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CSVGUI {
    private JPanel mainPanel;
    private JTable lecturerTable;
    private JScrollPane scrollPane;
    private JTextField pathEntryField;
    private JRadioButton selectionSortRadioButton;
    private JRadioButton otherRadioButton;
    private JButton sortButton;
    private JTextField ticksTextField;
    private JButton pathButton;


    public CSVGUI() {
        System.out.println("Constructor");
        pathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser((String) "src/main/resources");
                if (fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
                    String path = String.valueOf(fc.getSelectedFile());
                    pathEntryField.setText(path);
                }
            }
        });
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   final List<LECTURER> lecturerList = DDBB.Companion.lectures_from_dbb(pathEntryField.getText());
                int ticks=0;
                if (selectionSortRadioButton.isSelected())
                {
                    ticks=Selection.sort(lecturerList);
                    JOptionPane.showMessageDialog(null,"Selection Sort not yet implemented");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Bubble Sort not yet implemented");
                }
                ticksTextField.setText(Integer.toString(ticks));
                populate_LecturerList(lecturerList);
            }
        });
    }

    private void populate_LecturerList(List<LECTURER> lecturerList) {

            ((DefaultTableModel) lecturerTable.getModel()).setRowCount(0);
            for (int i = 0; i < lecturerList.size(); i++) {
                Object[] par = new Object[]{
                        lecturerList.get(i).getId(),
                        lecturerList.get(i).getNAME(),
                        lecturerList.get(i).getAGE(),
                        lecturerList.get(i).getSTATUS(),
                        lecturerList.get(i).getGENDER()
                };
                ((DefaultTableModel) lecturerTable.getModel()).addRow(par);
            }
        }


    private void createUIComponents() {
        System.out.println("Create UI");
        Object[] cols = {"id", "name", "age" ,"status", "gender"};
        lecturerTable = new JTable(new DefaultTableModel(cols, 0));
        scrollPane = new JScrollPane(lecturerTable);
        selectionSortRadioButton = new JRadioButton("", true);
        otherRadioButton = new JRadioButton("", false);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DDBBGUI");
        frame.setContentPane(new CSVGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


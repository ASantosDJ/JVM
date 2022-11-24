import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
//creating Gui using Jframe
public class AddBook {
    private JPanel Addbook;
    private JPanel Main;
    private JPanel Employee;
    private JTextField txtname;
    private JTextField txtfirstn;
    private JTextField txtyr;
    private JButton addBookButton;
    private JTable table1;
    private JButton deleteButton;
    private JButton updateRecordButton;
    private JButton searchButton;
    private JTextField txtidd;
    private JLabel tittle;
    private JLabel firstn;
    private JLabel lastn;
    private JLabel year;
    private JLabel publisher;
    private JLabel subject;
    private JTextField txtlastn;
    private JTextField txtpub;
    private JTextField txtsubb;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AddBook");
        frame.setContentPane(new AddBook().Addbook);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

//connecting the table to mysql database
    Connection con;
    PreparedStatement pst;

    public void connectt()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //table name=bookscollection provided for connection
            con = DriverManager.getConnection("jdbc:mysql://localhost/bookscollection", "root","");
            System.out.println("Successs");
        }

// shows null if  record not found
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    // loads the table and adds data
    void books_table_load()
    {
        try
        {
            pst = con.prepareStatement("select * from books");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //Add book Button
    public AddBook() {
        connectt();
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String Tittle, AuthorFirstName, AuthorLastName, YearofPublication, Publisher, Subject;
                Tittle = txtname.getText();
                AuthorFirstName = txtfirstn.getText();
                AuthorLastName = txtlastn.getText();
                YearofPublication = txtyr.getText();
                Publisher = txtpub.getText();
                Subject = txtsubb.getText();
                try {
                    pst = con.prepareStatement("insert into books(Tittle, AuthorFirstName, AuthorLastName, YearofPublication, Publisher, Subject)values(?,?,?,?,?,?)");
                    pst.setString(1, Tittle);
                    pst.setString(2, AuthorFirstName);
                    pst.setString(3, AuthorLastName);
                    pst.setString(4, YearofPublication);
                    pst.setString(5, Publisher);
                    pst.setString(6, Subject);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "New Book added!!!!!");
                    //books_table_load();
                    txtname.setText("");
                    txtfirstn.setText("");
                    txtlastn.setText("");
                    txtyr.setText("");
                    txtpub.setText("");
                    txtsubb.setText("");
                    txtname.requestFocus();
                }
                catch (SQLException e1)
                {

                    e1.printStackTrace();
                }
            }
        });
        //Update button
        updateRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Tittle, AuthorFirstName, AuthorLastName, YearofPublication, Publisher, Subject,Bookid;
                Tittle = txtname.getText();
                AuthorFirstName = txtfirstn.getText();
                AuthorLastName = txtlastn.getText();
                YearofPublication = txtyr.getText();
                Publisher = txtpub.getText();
                Subject = txtsubb.getText();
                Bookid= txtidd.getText();
                try {
                    pst = con.prepareStatement("update books set Tittle = ?,AuthorFirstName=?, AuthorLastName=?, YearofPublication=?, Publisher=?, Subject = ? where Bookid = ?");
                    pst.setString(1, Tittle);
                    pst.setString(2, AuthorFirstName);
                    pst.setString(3, AuthorLastName);
                    pst.setString(4, YearofPublication);
                    pst.setString(5, Publisher);
                    pst.setString(6, Subject);
                    pst.setString(7, Bookid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "New book colletion Updateeed!!!!!");
                    books_table_load();
                    txtname.setText("");
                    txtfirstn.setText("");
                    txtlastn.setText("");
                    txtyr.setText("");
                    txtpub.setText("");
                    txtsubb.setText("");
                    txtname.requestFocus();

                }

                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }

            }
        });
        //Delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Bookid;
                Bookid = txtidd.getText();
                try {
                    pst = con.prepareStatement("delete from books  where Bookid = ?");

                    pst.setString(1, Bookid);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleteeeeeed!!!!!");
                    books_table_load();
                    txtname.setText("");
                    txtfirstn.setText("");
                    txtlastn.setText("");
                    txtyr.setText("");
                    txtpub.setText("");
                    txtsubb.setText("");
                    txtname.requestFocus();
                }

                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
    }
}

//references-Geek for geeks
// references-tutussfunny.com
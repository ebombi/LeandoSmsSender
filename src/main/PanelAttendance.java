package main;

import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class PanelAttendance extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    /**
     * Create the panel.
     */
    public PanelAttendance() {
        setBorder(null);
        setSize(643,534);
        setLayout(null);

        JLabel lblAddTeacherInformation = new JLabel("Student Attendance");
        lblAddTeacherInformation.setHorizontalAlignment(SwingConstants.LEFT);
        lblAddTeacherInformation.setFont(new Font("Arial", Font.BOLD, 25));
        lblAddTeacherInformation.setBounds(10, 11, 308, 30);
        add(lblAddTeacherInformation);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(10, 65, 623, 335);
        add(panel);

        JScrollPane scrollPane = new JScrollPane();


        scrollPane.setBounds(10, 11, 603, 313);
        panel.add(scrollPane);

        table = new JTable() {
        	@Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // Make all cells uneditable
		    }
        };
        
        model = new DefaultTableModel(new String[]{"ID", "First Name", "MI", "Last Name", "Section", "Teacher", "Mobile Number", "Date"}, 0);
        table.setModel(model);
        scrollPane.setViewportView(table);

        Connection connection = getConnection(); 

        String query = "SELECT id, fname, mi, lname, section, teacher, mobilenumber, date FROM tbl_student";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String fname = resultSet.getString("fname");
                String mi = resultSet.getString("mi");
                String lname = resultSet.getString("lname");
                String section = resultSet.getString("section");
                String teacher = resultSet.getString("teacher");
                String mobilenumber = resultSet.getString("mobilenumber");
                Date date = resultSet.getDate("date");
                model.addRow(new Object[]{id, fname, mi, lname, section, teacher, mobilenumber, date});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JButton btnAdd = new JButton("Add to Sms Sender");
        boolean exitConfirmed = false;
        btnAdd.addActionListener(new ActionListener() {
            private JFrame frame; // Declare the JFrame as an instance variable

            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                if (selectedRows.length > 0) {
                    if (frame == null) {
                        frame = new JFrame();
                        frame.setUndecorated(true);
                        frame.setSize(643, 538);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    }

                    PanelSender sender = new PanelSender();
                    for (int row : selectedRows) {
                        String fname = (String) model.getValueAt(row, 1); // Assuming fname is at column 1
                        String lname = (String) model.getValueAt(row, 3); // Assuming lname is at column 3
                        String mobilenumber = (String) model.getValueAt(row, 6); // Assuming mobile number is at column 6
                        sender.addRow(fname, lname, mobilenumber);
                    }

                    frame.getContentPane().removeAll(); // Clear the frame
                    frame.getContentPane().add(sender); // Add PanelSender to the frame
                    frame.setVisible(true); // Make the frame visible
                }
            }
        });
        btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
        btnAdd.setFocusable(false);
        btnAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnAdd.setBackground(SystemColor.menu);
        btnAdd.setBounds(10, 434, 155, 51);
        add(btnAdd);
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            // Replace with your actual connection string.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/leandroproject", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

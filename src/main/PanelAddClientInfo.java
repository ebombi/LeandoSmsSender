package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.ScrollPane;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelAddClientInfo extends JPanel {
	private JTextField txtFirstName;
	private JTextField txtMiddleName;
	private JTextField txtLastName;
	private JTextField textMobileNumber;

	/**
	 * Create the panel.
	 */
	public PanelAddClientInfo() {
		setBorder(null);
		setSize(643,534);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Add Student Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 22, 308, 30);
		add(lblNewLabel);
		
		txtFirstName = new JTextField();
		txtFirstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtFirstName.getText().equals("First Name")) {
					txtFirstName.setText("");
				} else {
					txtFirstName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtFirstName.getText().equals(""))
					txtFirstName.setText("First Name");
			}
		});
		txtFirstName.setText("First Name");
		txtFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirstName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtFirstName.setColumns(10);
		txtFirstName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtFirstName.setBackground(SystemColor.menu);
		txtFirstName.setBounds(43, 63, 140, 45);
		add(txtFirstName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtMiddleName.getText().equals("Middle Name")) {
					txtMiddleName.setText("");
				} else {
					txtMiddleName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtMiddleName.getText().equals(""))
					txtMiddleName.setText("Middle Name");
			}
		});
		txtMiddleName.setText("Middle Name");
		txtMiddleName.setHorizontalAlignment(SwingConstants.CENTER);
		txtMiddleName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMiddleName.setColumns(10);
		txtMiddleName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMiddleName.setBackground(SystemColor.menu);
		txtMiddleName.setBounds(226, 63, 140, 45);
		add(txtMiddleName);
		
		txtLastName = new JTextField();
		txtLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtLastName.getText().equals("Last Name")) {
					txtLastName.setText("");
				} else {
					txtLastName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtLastName.getText().equals(""))
					txtLastName.setText("Last Name");
			}
		});
		txtLastName.setText("Last Name");
		txtLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtLastName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLastName.setColumns(10);
		txtLastName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtLastName.setBackground(SystemColor.menu);
		txtLastName.setBounds(414, 63, 140, 45);
		add(txtLastName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox.setBackground(new Color(240, 240, 240));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Section", "ABM", "ICT", "HUMMS", "ATBP"}));
		comboBox.setBounds(123, 126, 140, 45);
		add(comboBox);
		
		
		JPanel panel_2_1_2_1 = new JPanel();
		panel_2_1_2_1.setLayout(null);
		panel_2_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_2_1.setBackground(SystemColor.menu);
		panel_2_1_2_1.setBounds(43, 195, 186, 45);
		add(panel_2_1_2_1);
		
		textMobileNumber = new JTextField();
		textMobileNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textMobileNumber.getText().equals("Mobile Number")) {
					textMobileNumber.setText("");
				} else {
					textMobileNumber.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textMobileNumber.getText().equals(""))
					textMobileNumber.setText("Mobile Number");
			}
		});
		textMobileNumber.setText("Mobile Number");
		textMobileNumber.setHorizontalAlignment(SwingConstants.LEFT);
		textMobileNumber.setFont(new Font("Arial", Font.PLAIN, 15));
		textMobileNumber.setColumns(10);
		textMobileNumber.setBorder(null);
		textMobileNumber.setBackground(SystemColor.menu);
		textMobileNumber.setBounds(56, 11, 120, 23);
		panel_2_1_2_1.add(textMobileNumber);
		
		JLabel lblNewLabel_1 = new JLabel("+63");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(26, 11, 164, 23);
		panel_2_1_2_1.add(lblNewLabel_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(414, 195, 140, 45);
		add(dateChooser);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select Teacher", "-", "-", "-", "-"}));
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox_1.setBackground(SystemColor.menu);
		comboBox_1.setBounds(315, 126, 140, 45);
		add(comboBox_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 313, 623, 210);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ALL STUDENT OUTPUT");
		lblNewLabel_2.setBounds(46, 23, 424, 105);
		panel.add(lblNewLabel_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
		btnAdd.setFocusable(false);
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdd.setBackground(SystemColor.menu);
		btnAdd.setBounds(43, 266, 140, 32);
		add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Arial", Font.BOLD, 15));
		btnEdit.setFocusable(false);
		btnEdit.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEdit.setBackground(SystemColor.menu);
		btnEdit.setBounds(236, 266, 140, 32);
		add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDelete.setBackground(SystemColor.menu);
		btnDelete.setBounds(426, 266, 140, 32);
		add(btnDelete);
		
		JLabel lblNewLabel_3 = new JLabel("Parents Contact No.");
		lblNewLabel_3.setBounds(43, 182, 186, 14);
		add(lblNewLabel_3);
	}
}

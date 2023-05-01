package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelAddTeacher extends JPanel {
	private JTextField txtTeacherId;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JTextField txtTeacherName;
	private JTextField txtTeacherLastName;

	/**
	 * Create the panel.
	 */
	public PanelAddTeacher() {
		setBorder(null);
		setSize(643,534);
		setLayout(null);
		
		JLabel lblAddTeacherInformation = new JLabel("Add Teacher Information");
		lblAddTeacherInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddTeacherInformation.setFont(new Font("Arial", Font.BOLD, 25));
		lblAddTeacherInformation.setBounds(10, 22, 308, 30);
		add(lblAddTeacherInformation);
		
		txtTeacherId = new JTextField();
		txtTeacherId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtTeacherId.getText().equals("Teacher ID")) {
					txtTeacherId.setText("");
				} else {
					txtTeacherId.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTeacherId.getText().equals(""))
					txtTeacherId.setText("Teacher ID");
			}
		});
		txtTeacherId.setText("Teacher ID");
		txtTeacherId.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeacherId.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTeacherId.setColumns(10);
		txtTeacherId.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTeacherId.setBackground(SystemColor.menu);
		txtTeacherId.setBounds(422, 162, 140, 45);
		add(txtTeacherId);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(422, 76, 140, 45);
		add(dateChooser);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 313, 623, 210);
		add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("ALL TEACHER OUTPUT");
		lblNewLabel_2.setBounds(46, 23, 424, 105);
		panel.add(lblNewLabel_2);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals(""))
					txtUsername.setText("Username");
			}
		});
		txtUsername.setText("Username");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		txtUsername.setColumns(10);
		txtUsername.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtUsername.setBackground(SystemColor.menu);
		txtUsername.setBounds(39, 162, 140, 45);
		add(txtUsername);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(232, 162, 140, 45);
		add(panel_1);
		
		pwdPassword = new JPasswordField();
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdPassword.getText().equals("Password")) {
					pwdPassword.setEchoChar('●');
					pwdPassword.setText("");
				} else {
					pwdPassword.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdPassword.getText().equals("")){
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar((char)0);
				}
			}
		});
		pwdPassword.setText("Password");
		pwdPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		pwdPassword.setBorder(null);
		pwdPassword.setBackground(SystemColor.menu);
		pwdPassword.setBounds(10, 11, 120, 23);
		panel_1.add(pwdPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(232, 130, 140, 30);
		add(lblNewLabel_1_1);
		
		Label label = new Label("Date");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(422, 48, 140, 22);
		add(label);
		
		txtTeacherName = new JTextField();
		txtTeacherName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtTeacherName.getText().equals("Teacher Name")) {
					txtTeacherName.setText("");
				} else {
					txtTeacherName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTeacherName.getText().equals(""))
					txtTeacherName.setText("Teacher Name");
			}
		});
		txtTeacherName.setText("Teacher Name");
		txtTeacherName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeacherName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTeacherName.setColumns(10);
		txtTeacherName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTeacherName.setBackground(SystemColor.menu);
		txtTeacherName.setBounds(39, 76, 140, 45);
		add(txtTeacherName);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
		btnAdd.setFocusable(false);
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdd.setBackground(SystemColor.menu);
		btnAdd.setBounds(39, 249, 140, 32);
		add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Arial", Font.BOLD, 15));
		btnEdit.setFocusable(false);
		btnEdit.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEdit.setBackground(SystemColor.menu);
		btnEdit.setBounds(232, 249, 140, 32);
		add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDelete.setBackground(SystemColor.menu);
		btnDelete.setBounds(422, 249, 140, 32);
		add(btnDelete);
		
		txtTeacherLastName = new JTextField();
		txtTeacherLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtTeacherLastName.getText().equals("Teacher Last Name")) {
					txtTeacherLastName.setText("");
				} else {
					txtTeacherLastName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTeacherLastName.getText().equals(""))
					txtTeacherLastName.setText("Teacher Last Name");
			}
		});
		txtTeacherLastName.setText("Teacher Last Name");
		txtTeacherLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeacherLastName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTeacherLastName.setColumns(10);
		txtTeacherLastName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTeacherLastName.setBackground(SystemColor.menu);
		txtTeacherLastName.setBounds(232, 76, 140, 45);
		add(txtTeacherLastName);
	}
}

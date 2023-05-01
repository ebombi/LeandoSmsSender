package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;

public class PanelSettings extends JPanel {
	private JTextField txtusername;
	private JButton btnResetPassword;
	private JButton btnEditAllUser;
	private JPasswordField pwdCurrent;
	private JPasswordField pwdNew;
	private JPasswordField pwdConfirm;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnAddUser;

	/**
	 * Create the panel.
	 */
	public PanelSettings() {
		setBorder(null);
		setSize(643,534);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Settings");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 77, 194, 30);
		add(lblNewLabel);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(240, 240, 240));
		panel_2_1.setBounds(69, 286, 200, 45);
		add(panel_2_1);
		
		pwdNew = new JPasswordField();
		pwdNew.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdNew.getText().equals("New Password")) {
					pwdNew.setEchoChar('●');
					pwdNew.setText("");
				} else {
					pwdNew.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdNew.getText().equals("")){
					pwdNew.setText("New Password");
					pwdNew.setEchoChar((char)0);
				}
			}
		});
		pwdNew.setText("New Password");
		pwdNew.setFont(new Font("Arial", Font.PLAIN, 15));
		pwdNew.setBorder(null);
		pwdNew.setBackground(new Color(240, 240, 240));
		pwdNew.setBounds(10, 11, 180, 23);
		panel_2_1.add(pwdNew);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(240, 240, 240));
		panel_2_1_1.setBounds(345, 286, 200, 45);
		add(panel_2_1_1);
		
		pwdConfirm = new JPasswordField();
		pwdConfirm.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdConfirm.getText().equals("Confirm Password")) {
					pwdConfirm.setEchoChar('●');
					pwdConfirm.setText("");
				} else {
					pwdConfirm.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdConfirm.getText().equals("")){
					pwdConfirm.setText("Confirm Password");
					pwdConfirm.setEchoChar((char)0);
				}
			}
		});
		pwdConfirm.setText("Confirm Password");
		pwdConfirm.setFont(new Font("Arial", Font.PLAIN, 15));
		pwdConfirm.setBorder(null);
		pwdConfirm.setBackground(new Color(240, 240, 240));
		pwdConfirm.setBounds(10, 11, 180, 23);
		panel_2_1_1.add(pwdConfirm);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBackground(new Color(240, 240, 240));
		panel_2_1_2.setBounds(69, 171, 200, 45);
		add(panel_2_1_2);
		
		txtusername = new JTextField();
		txtusername.setEnabled(false);
		txtusername.setHorizontalAlignment(SwingConstants.CENTER);
		txtusername.setText("##USERNAME##");
		txtusername.setFont(new Font("Arial", Font.PLAIN, 15));
		txtusername.setColumns(10);
		txtusername.setBorder(null);
		txtusername.setBackground(new Color(240, 240, 240));
		txtusername.setBounds(10, 11, 180, 23);
		panel_2_1_2.add(txtusername);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(345, 171, 200, 45);
		add(panel_1);
		
		pwdCurrent = new JPasswordField();
		pwdCurrent.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdCurrent.getText().equals("Current Password")) {
					pwdCurrent.setEchoChar('●');
					pwdCurrent.setText("");
				} else {
					pwdCurrent.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdCurrent.getText().equals("")){
					pwdCurrent.setText("Current Password");
					pwdCurrent.setEchoChar((char)0);
				}
			}
		});
		pwdCurrent.setText("Current Password");
		pwdCurrent.setFont(new Font("Arial", Font.PLAIN, 15));
		pwdCurrent.setBorder(null);
		pwdCurrent.setBackground(new Color(240, 240, 240));
		pwdCurrent.setBounds(10, 11, 180, 23);
		panel_1.add(pwdCurrent);
		
		btnEditAllUser = new JButton("Edit All User");
		btnEditAllUser.setFont(new Font("Arial", Font.BOLD, 15));
		btnEditAllUser.setFocusable(false);
		btnEditAllUser.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEditAllUser.setBackground(new Color(240, 240, 240));
		btnEditAllUser.setBounds(511, 493, 122, 30);
		add(btnEditAllUser);
		
		lblNewLabel_1 = new JLabel("Current Password");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(345, 131, 200, 30);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(69, 247, 200, 30);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Confirm Password");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(345, 247, 200, 30);
		add(lblNewLabel_3);
		
		btnAddUser = new JButton("Add User");
		btnAddUser.setFont(new Font("Arial", Font.BOLD, 15));
		btnAddUser.setFocusable(false);
		btnAddUser.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAddUser.setBackground(SystemColor.menu);
		btnAddUser.setBounds(0, 493, 122, 30);
		add(btnAddUser);
		
		btnResetPassword = new JButton("Reset Password");
		btnResetPassword.setBounds(202, 406, 180, 32);
		add(btnResetPassword);
		btnResetPassword.setFont(new Font("Arial", Font.BOLD, 15));
		btnResetPassword.setFocusable(false);
		btnResetPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnResetPassword.setBackground(new Color(240, 240, 240));
	}
}

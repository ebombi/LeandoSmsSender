package main;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class FrameRegistration extends JFrame {
	Connection conn;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JPanel panel_2;
	private JTextField textId;
	private JLabel idcon;
	private JPanel panel;
	private JPasswordField pwdPassword;
	private JLabel passIcon;
	private JPanel panel_1;
	private JTextField textLname;
	private JLabel idcon_1;
	private JPanel panel_2_1;
	private JTextField textFname;
	private JLabel idcon_1_1;
	private JPanel panel_3;
	private JTextField textUsername;
	private JLabel userIcon;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRegistration frame = new FrameRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameRegistration() {
	
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:data/database.db");
		}catch(SQLException connectionError) {
			connectionError.printStackTrace();
		}
	
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblX_1 = new JLabel("X");
		lblX_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX_1.setForeground(Color.RED);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back?", "Confirm", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
				        new LoginFrame().setVisible(true); // Redirect to LoginFrame
				        FrameRegistration.this.dispose(); // Close the current frame
				    }
					FrameRegistration.this.dispose();
			}
			public void mouseExited(MouseEvent e) {
				lblX_1.setForeground(Color.BLACK);
			}
		});
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblX_1.setBounds(new Rectangle(428, 11, 12, 21));
		contentPane.add(lblX_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameRegistration.class.getResource("/images/Icon__4_-removebg-preview.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 11, 318, 84);
		contentPane.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(123, 251, 200, 54);
		contentPane.add(panel_2);
		
		textId = new JTextField();
		textId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textId.getText().equals("ID")) {
					textId.setText("");
				} else {
					textFname.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textId.getText().equals(""))
					textId.setText("ID");
			}
		});
		textId.setText("ID");
		textId.setFont(new Font("Arial", Font.PLAIN, 15));
		textId.setColumns(10);
		textId.setBorder(null);
		textId.setBackground(SystemColor.menu);
		textId.setBounds(60, 11, 130, 32);
		panel_2.add(textId);
		
		idcon = new JLabel("ID");
		idcon.setFont(new Font("Arial", Font.PLAIN, 40));
		idcon.setBounds(10, 0, 48, 60);
		panel_2.add(idcon);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(240, 183, 200, 54);
		contentPane.add(panel);
		
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
		pwdPassword.setBounds(10, 11, 180, 32);
		panel.add(pwdPassword);
		
		passIcon = new JLabel("");
		passIcon.setBounds(0, 0, 61, 60);
		panel.add(passIcon);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(240, 106, 200, 54);
		contentPane.add(panel_1);
		
		textLname = new JTextField();
		textLname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textLname.getText().equals("Last Name")) {
					textLname.setText("");
				} else {
					textLname.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textLname.getText().equals(""))
					textLname.setText("Last Name");
			}
		});
		textLname.setText("Last Name");
		textLname.setFont(new Font("Arial", Font.PLAIN, 15));
		textLname.setColumns(10);
		textLname.setBorder(null);
		textLname.setBackground(SystemColor.menu);
		textLname.setBounds(10, 11, 180, 32);
		panel_1.add(textLname);
		
		idcon_1 = new JLabel("");
		idcon_1.setFont(new Font("Arial", Font.PLAIN, 40));
		idcon_1.setBounds(10, 11, 42, 32);
		panel_1.add(idcon_1);
		
		panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBackground(SystemColor.menu);
		panel_2_1.setBounds(10, 106, 200, 54);
		contentPane.add(panel_2_1);
		
		textFname = new JTextField();
		textFname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textFname.getText().equals("First Name")) {
					textFname.setText("");
				} else {
					textFname.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textFname.getText().equals(""))
					textFname.setText("First Name");
			}
		});
		textFname.setText("First Name");
		textFname.setFont(new Font("Arial", Font.PLAIN, 15));
		textFname.setColumns(10);
		textFname.setBorder(null);
		textFname.setBackground(SystemColor.menu);
		textFname.setBounds(20, 11, 170, 32);
		panel_2_1.add(textFname);
		
		idcon_1_1 = new JLabel("");
		idcon_1_1.setFont(new Font("Arial", Font.PLAIN, 40));
		idcon_1_1.setBounds(10, 11, 42, 32);
		panel_2_1.add(idcon_1_1);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(10, 183, 200, 54);
		contentPane.add(panel_3);
		
		textUsername = new JTextField();
		textUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textUsername.getText().equals("Username")) {
					textUsername.setText("");
				} else {
					textFname.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textUsername.getText().equals(""))
					textUsername.setText("Username");
			}
		});
		textUsername.setText("Username");
		textUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		textUsername.setColumns(10);
		textUsername.setBorder(null);
		textUsername.setBackground(SystemColor.menu);
		textUsername.setBounds(20, 11, 170, 35);
		panel_3.add(textUsername);
		
		userIcon = new JLabel("");
		userIcon.setBounds(0, 0, 61, 60);
		panel_3.add(userIcon);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "INSERT INTO tbl_registration (fname, lname, username, password, id) VALUES (?,?,?,?,?)";
					conn = DriverManager.getConnection("jdbc:sqlite:data/database.db");
					pst=conn.prepareStatement(query);
					pst.setString(1, textFname.getText());
					pst.setString(2, textLname.getText());
					pst.setString(3, textUsername.getText());
					char[] passwordChars = pwdPassword.getPassword();
					String password = new String(passwordChars);
					pst.setString(4, password);
					pst.setString(5, textId.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Register Successfull!");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnRegister.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegister.setFocusable(false);
		btnRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRegister.setBackground(SystemColor.menu);
		btnRegister.setBounds(159, 327, 117, 51);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(10, 90, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(240, 90, 60, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Username");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_1_2.setBounds(10, 171, 60, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_1_3.setBounds(240, 171, 60, 14);
		contentPane.add(lblNewLabel_1_3);
		
	}
}

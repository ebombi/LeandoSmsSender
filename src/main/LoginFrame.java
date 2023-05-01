package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LoginFrame extends JFrame {

	Connection conn;
	private JPanel contentPane;
	private JTextField textUsername;
	private JLabel lblLoginMessage = new JLabel("");
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginFrame() {
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:data/database.db");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelUser = new JPanel();
		panelUser.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUser.setBounds(69, 106, 318, 60);
		panelUser.setBackground(new Color(240, 240, 240));
		contentPane.add(panelUser);
		panelUser.setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setToolTipText("");
		textUsername.setText("Username");
		textUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		textUsername.setAutoscrolls(false);

		textUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textUsername.getText().equals("Username")) {
					textUsername.setText("");
				} else {
					textUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textUsername.getText().equals(""))
					textUsername.setText("Username");
			}
		});
		textUsername.setBorder(null);
		textUsername.setBackground(new Color(240, 240, 240));
		textUsername.setBounds(63, 11, 245, 38);
		panelUser.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel userIcon = new JLabel("New label");
		userIcon.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/user (1).png")));
		userIcon.setBounds(0, 0, 61, 60);
		panelUser.add(userIcon);
		
		JPanel panelPass = new JPanel();
		panelPass.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPass.setBounds(69, 193, 318, 60);
		panelPass.setBackground(new Color(240, 240, 240));
		contentPane.add(panelPass);
		panelPass.setLayout(null);
		
		JLabel passIcon = new JLabel("New label");
		passIcon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passIcon.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/pass (1).png")));
		passIcon.setBounds(0, 0, 61, 60);
		panelPass.add(passIcon);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBackground(new Color(240, 240, 240));
		pwdPassword.setBorder(null);
		pwdPassword.setFont(new Font("Arial", Font.PLAIN, 15));
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
		pwdPassword.setBounds(63, 11, 245, 38);
		pwdPassword.setEchoChar((char)0);
		panelPass.add(pwdPassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 11, 318, 84);
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/Icon__4_-removebg-preview.png")));
		contentPane.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textUsername.getText();
				String pass = String.valueOf(pwdPassword.getPassword());
				Statement statment = null;
				String query = "SELECT * FROM tbl_user WHERE username='"+user+"' AND password='"+pass+"'";
				try {
					statment = conn.createStatement();
					ResultSet resultSet = statment.executeQuery(query);
					if (resultSet.next()) {
					    // Success
					    handleSuccessfulLogin();
					} else {
					    // Failed
					    handleFailedLogin();
					}
				}catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Something Wrong!");
				}
			}

			private void handleSuccessfulLogin() {
			    new MainFrame().setVisible(true);
			    LoginFrame.this.dispose();
			}

			private void handleFailedLogin() {
			    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
			}
			
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textUsername.getText().equals("admin") && pwdPassword.getText().equals("***a***")) {
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "Login Successfull");
				} else if(textUsername.getText().equals("") || textUsername.getText().equals("Username") || 
						pwdPassword.getText().equals("")|| pwdPassword.getText().equals("Password")) {
					lblLoginMessage.setText("Something's not right?");
				} else {
					lblLoginMessage.setText("Invaid Username or Password");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(218, 218, 218));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(240, 240, 240));
			}
		});
		btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
		btnLogin.setBackground(new Color(240, 240, 240));
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLogin.setBounds(69, 297, 117, 51);
		btnLogin.setFocusable(false);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegister.setBackground(new Color(218, 218, 218));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegister.setBackground(new Color(240, 240, 240));
			}
		});
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame n = new RegisterFrame();
				n.setVisible(true);
				LoginFrame.this.dispose();
			}
		});
		btnRegister.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegister.setBackground(new Color(240, 240, 240));
		btnRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRegister.setBounds(270, 297, 117, 51);
		btnRegister.setFocusable(false);
		contentPane.add(btnRegister);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this program?","Confirm",JOptionPane.YES_NO_OPTION) == 0)
					LoginFrame.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.BLACK);
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(new Rectangle(0, 0, 20, 20));
		lblX.setBounds(394, 11, 46, 21);
		contentPane.add(lblX);
		
		lblLoginMessage.setForeground(new Color(255, 0, 0));
		lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 13));
		lblLoginMessage.setBounds(69, 272, 318, 14);
		contentPane.add(lblLoginMessage);
	}
}

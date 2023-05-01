package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtLast;
	private JPasswordField pwdPassword;
	private JTextField txtName;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/Icon__4_-removebg-preview.png")));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(134, 12, 179, 84);
		contentPane.add(lblIcon);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(-18, 107, 482, 25);
		contentPane.add(lblRegistration);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this program?","Confirm",JOptionPane.YES_NO_OPTION) == 0)
					RegisterFrame.this.dispose();
			}
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.BLACK);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblX.setBounds(new Rectangle(0, 0, 20, 20));
		lblX.setBounds(394, 11, 46, 21);
		contentPane.add(lblX);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(10, 227, 200, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(240, 240, 240));
		txtUsername.setText("Username");
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 15));
		txtUsername.setBounds(60, 11, 130, 35);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel userIcon = new JLabel("");
		userIcon.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/user (1).png")));
		userIcon.setBounds(0, 0, 61, 60);
		panel.add(userIcon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(240, 227, 200, 54);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
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
		pwdPassword.setBorder(null);
		pwdPassword.setBackground(new Color(240, 240, 240));
		pwdPassword.setText("Password");
		pwdPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		pwdPassword.setBounds(60, 11, 130, 32);
		panel_1.add(pwdPassword);
		
		JLabel passIcon = new JLabel("");
		passIcon.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/pass (1).png")));
		passIcon.setBounds(0, 0, 61, 60);
		panel_1.add(passIcon);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(240, 240, 240));
		panel_2.setBounds(240, 150, 200, 54);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtLast = new JTextField();
		txtLast.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtLast.getText().equals("Last Name")) {
					txtLast.setText("");
				} else {
					txtLast.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtLast.getText().equals(""))
					txtLast.setText("Last Name");
			}
		});
		txtLast.setBorder(null);
		txtLast.setBackground(new Color(240, 240, 240));
		txtLast.setText("Last Name");
		txtLast.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLast.setColumns(10);
		txtLast.setBounds(60, 11, 130, 32);
		panel_2.add(txtLast);
		
		JLabel idcon_1_1 = new JLabel("");
		idcon_1_1.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/lname.png")));
		idcon_1_1.setFont(new Font("Arial", Font.PLAIN, 40));
		idcon_1_1.setBounds(10, 11, 42, 32);
		panel_2.add(idcon_1_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/image (1).png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame n = new LoginFrame();
				n.setVisible(true);
				RegisterFrame.this.dispose();
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(371, 12, 26, 19);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegister.setFocusable(false);
		btnRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRegister.setBackground(new Color(240, 240, 240));
		btnRegister.setBounds(159, 371, 117, 51);
		contentPane.add(btnRegister);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(240, 240, 240));
		panel_2_1.setBounds(10, 150, 200, 54);
		contentPane.add(panel_2_1);
		
		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(txtName.getText().equals("First Name")) {
					txtName.setText("");
				} else {
					txtName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtName.getText().equals(""))
					txtName.setText("First Name");
			}
		});
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		txtName.setText("First Name");
		txtName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBorder(null);
		txtName.setBackground(new Color(240, 240, 240));
		txtName.setBounds(60, 11, 130, 32);
		panel_2_1.add(txtName);
		
		JLabel idcon_1_1_1 = new JLabel("");
		idcon_1_1_1.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/lname.png")));
		idcon_1_1_1.setFont(new Font("Arial", Font.PLAIN, 40));
		idcon_1_1_1.setBounds(10, 11, 42, 32);
		panel_2_1.add(idcon_1_1_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(new Color(240, 240, 240));
		panel_2_2.setBounds(123, 295, 200, 54);
		contentPane.add(panel_2_2);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals("ID")) {
					textField.setText("");
				} else {
					textField.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals(""))
					textField.setText("ID");
			}
		});
		textField.setText("ID");
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(240, 240, 240));
		textField.setBounds(60, 11, 130, 32);
		panel_2_2.add(textField);
		
		JLabel idcon_2 = new JLabel("ID");
		idcon_2.setFont(new Font("Arial", Font.PLAIN, 40));
		idcon_2.setBounds(10, 0, 48, 60);
		panel_2_2.add(idcon_2);
		
	}
}

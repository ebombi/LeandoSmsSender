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
	private JButton btnRegister;
	private JLabel lblNewLabel_3;
	private JTextField txtFname;
	private JLabel lblNewLabel_3_1;
	private JTextField txtLname;
	private JTextField txtTeachersId;
	private JLabel lblNewLabel_3_1_1;
	private JLabel lblNewLabel_1;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblNewLabel_2;

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
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/leandroproject","root","");
		}catch(SQLException connectionError) {
			connectionError.printStackTrace();
		}
	
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 459, 357);
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
		lblNewLabel.setBounds(0, 11, 459, 84);
		contentPane.add(lblNewLabel);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String fname = txtFname.getText();
		        String lname = txtLname.getText();
		        String teachersId = txtTeachersId.getText();
		        String username = txtUsername.getText();
		        String password = new String(txtPassword.getPassword());
		        String checkTeacherQuery = "SELECT * FROM tbl_teachers WHERE fname = ? AND lname = ? AND teachers_id = ?";
		        String registerQuery = "INSERT INTO tbl_registration (fname, lname, teachers_id, username, password) VALUES (?, ?, ?, ?, ?)";

		        if (fname.isEmpty() || fname.equals("First Name")) {
		            JOptionPane.showMessageDialog(null, "Please input First Name");
		        } else if (lname.isEmpty() || lname.equals("Last Name")) {
		            JOptionPane.showMessageDialog(null, "Please input Last Name");
		        } else if (teachersId.isEmpty() || teachersId.equals("Teachers ID")) {
		            JOptionPane.showMessageDialog(null, "Please input Teacher's ID");
		        } else if (username.isEmpty() || username.equals("Username")) {
		            JOptionPane.showMessageDialog(null, "Please input Username");
		        } else if (password.isEmpty() || password.equals("Password")) {
		            JOptionPane.showMessageDialog(null, "Please input Password");
		        } else {
		            try (PreparedStatement checkTeacherStatement = conn.prepareStatement(checkTeacherQuery);
		                 PreparedStatement registerStatement = conn.prepareStatement(registerQuery)) {

		                checkTeacherStatement.setString(1, fname);
		                checkTeacherStatement.setString(2, lname);
		                checkTeacherStatement.setString(3, teachersId);

		                ResultSet teacherResult = checkTeacherStatement.executeQuery();

		                if (teacherResult.next()) {
		                    // Teacher exists in tbl_teachers
		                    registerStatement.setString(1, fname);
		                    registerStatement.setString(2, lname);
		                    registerStatement.setString(3, teachersId);
		                    registerStatement.setString(4, username);
		                    registerStatement.setString(5, password);

		                    int affectedRows = registerStatement.executeUpdate();

		                    if (affectedRows > 0) {
		                        JOptionPane.showMessageDialog(null, "Registration successful!");
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Failed to register. Please try again.");
		                    }
		                } else {
		                    // Teacher does not exist in tbl_teachers
		                    JOptionPane.showMessageDialog(null, "Teacher not found!");
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		});
		btnRegister.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegister.setFocusable(false);
		btnRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRegister.setBackground(SystemColor.menu);
		btnRegister.setBounds(159, 272, 117, 51);
		contentPane.add(btnRegister);
		
		lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setBounds(10, 106, 140, 14);
		contentPane.add(lblNewLabel_3);
		
		txtFname = new JTextField();
		txtFname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtFname.getText().equals("First Name")) {
					txtFname.setText("");
				} else {
					txtFname.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtFname.getText().equals(""))
					txtFname.setText("First Name");
			}
		});
		txtFname.setText("First Name");
		txtFname.setHorizontalAlignment(SwingConstants.CENTER);
		txtFname.setFont(new Font("Arial", Font.PLAIN, 15));
		txtFname.setColumns(10);
		txtFname.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtFname.setBackground(SystemColor.menu);
		txtFname.setBounds(10, 120, 140, 45);
		contentPane.add(txtFname);
		
		lblNewLabel_3_1 = new JLabel("Last Name");
		lblNewLabel_3_1.setBounds(159, 106, 140, 14);
		contentPane.add(lblNewLabel_3_1);
		
		txtLname = new JTextField();
		txtLname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtLname.getText().equals("Last Name")) {
					txtLname.setText("");
				} else {
					txtFname.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtLname.getText().equals(""))
					txtLname.setText("Last Name");
			}
		});
		txtLname.setText("Last Name");
		txtLname.setHorizontalAlignment(SwingConstants.CENTER);
		txtLname.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLname.setColumns(10);
		txtLname.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtLname.setBackground(SystemColor.menu);
		txtLname.setBounds(159, 120, 140, 45);
		contentPane.add(txtLname);
		
		txtTeachersId = new JTextField();
		txtTeachersId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtTeachersId.getText().equals("Teachers ID")) {
					txtTeachersId.setText("");
				} else {
					txtTeachersId.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTeachersId.getText().equals(""))
					txtTeachersId.setText("Teachers ID");
			}
		});
		txtTeachersId.setText("Teachers ID");
		txtTeachersId.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeachersId.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTeachersId.setColumns(10);
		txtTeachersId.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTeachersId.setBackground(SystemColor.menu);
		txtTeachersId.setBounds(309, 120, 140, 45);
		contentPane.add(txtTeachersId);
		
		lblNewLabel_3_1_1 = new JLabel("Teachers ID");
		lblNewLabel_3_1_1.setBounds(309, 106, 140, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(61, 186, 140, 14);
		contentPane.add(lblNewLabel_1);
		
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
		txtUsername.setBounds(61, 200, 140, 45);
		contentPane.add(txtUsername);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				} else {
					txtPassword.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")){
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setText("Password");
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		txtPassword.setEchoChar(' ');
		txtPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPassword.setBackground(SystemColor.menu);
		txtPassword.setBounds(232, 200, 140, 45);
		contentPane.add(txtPassword);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(232, 186, 140, 14);
		contentPane.add(lblNewLabel_2);
		
	}
}

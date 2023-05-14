package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	private PanelAddClientInfo panelStudentClientInfo;
	private PanelSettings panelSettings;

	private PanelAttendance panelAttendance;
	private PanelAddTeacher panelAddTeacher;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 909, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelStudentClientInfo = new PanelAddClientInfo();
		panelStudentClientInfo.setBounds(0, 0, 643, 538);
		panelStudentClientInfo.setBorder(null);
		panelSettings = new PanelSettings();
		panelSettings.setBounds(0, 0, 643, 538);

		panelAttendance = new PanelAttendance();
		panelAttendance.setBounds(0, 0, 636, 538);
		panelAddTeacher = new PanelAddTeacher();
		panelAddTeacher.setBounds(0, 0, 636, 538);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(0, 0, 246, 556);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(31, 11, 179, 108);
		panel.add(lblIcon);
		lblIcon.setIcon(new ImageIcon(MainFrame.class.getResource("/images/Icon__4_-removebg-preview.png")));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel paneAddClient = new JPanel();
		paneAddClient.addMouseListener(new PanelButtonMouseAdapter(paneAddClient) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelStudentClientInfo);
			}
		});
		paneAddClient.setBackground(new Color(240, 240, 240));
		paneAddClient.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneAddClient.setBounds(10, 173, 226, 51);
		panel.add(paneAddClient);
		paneAddClient.setLayout(null);
		
		JLabel lblAddClientInformation = new JLabel("Add Student");
		lblAddClientInformation.setFont(new Font("Arial", Font.BOLD, 17));
		lblAddClientInformation.setBounds(56, 11, 160, 29);
		paneAddClient.add(lblAddClientInformation);
		
		JPanel paneSettings = new JPanel();
		paneSettings.addMouseListener(new PanelButtonMouseAdapter(paneSettings) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelSettings);
			}
		});
		paneSettings.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneSettings.setBounds(10, 359, 226, 51);
		panel.add(paneSettings);
		paneSettings.setLayout(null);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Arial", Font.BOLD, 17));
		lblSettings.setBounds(56, 11, 160, 29);
		paneSettings.add(lblSettings);
		
		JLabel lblNewLabel = new JLabel("Leandro Locsin ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 111, 226, 39);
		panel.add(lblNewLabel);
		
		
		
		JPanel paneAttendance = new JPanel();
		paneAttendance.addMouseListener(new PanelButtonMouseAdapter(paneAttendance){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelAttendance);
			}
		});
		paneAttendance.setLayout(null);
		paneAttendance.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneAttendance.setBounds(10, 297, 226, 51);
		panel.add(paneAttendance);
		
		JLabel lblSender_1 = new JLabel("Attendance");
		lblSender_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblSender_1.setBounds(56, 11, 160, 29);
		paneAttendance.add(lblSender_1);
		
		JPanel paneLogout = new JPanel();
		paneLogout.addMouseListener(new PanelButtonMouseAdapter(paneLogout) {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure to Signout?")== 0) {
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.show();
					loginFrame.setVisible(true);				
					MainFrame.this.dispose();
				}
			}
			
		});
		paneLogout.setLayout(null);
		paneLogout.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneLogout.setBounds(10, 421, 226, 51);
		panel.add(paneLogout);
		
		JLabel Logout = new JLabel("Sign Out");
		Logout.setFont(new Font("Arial", Font.BOLD, 17));
		Logout.setBounds(56, 11, 160, 29);
		paneLogout.add(Logout);
		
		JPanel paneAddTeacher = new JPanel();
		paneAddTeacher.addMouseListener(new PanelButtonMouseAdapter(paneAddTeacher) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelAddTeacher);
			}
		});
		paneAddTeacher.setLayout(null);
		paneAddTeacher.setBorder(new LineBorder(new Color(0, 0, 0)));
		paneAddTeacher.setBounds(10, 235, 226, 51);
		panel.add(paneAddTeacher);
		
		JLabel lblSender_1_1 = new JLabel("Add Teacher");
		lblSender_1_1.setFont(new Font("Arial", Font.BOLD, 17));
		lblSender_1_1.setBounds(56, 11, 160, 29);
		paneAddTeacher.add(lblSender_1_1);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBorder(null);
		paneMainContent.setBounds(256, 11, 643, 534);
		contentPane.add(paneMainContent);
		paneMainContent.setLayout(null);
		paneMainContent.add(panelStudentClientInfo);
		paneMainContent.add(panelSettings);
		paneMainContent.add(panelAttendance);
		paneMainContent.add(panelAddTeacher);

		menuClicked(panelStudentClientInfo);
	}
	
/*	public void menuClicked(JPanel panel) {
		panelAddClient.setVisible(false);
		panelSettings.setVisible(false);
		panelSender.setVisible(false);
		
		panel.setVisible(true);
	}
	*/
	
	/*private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(192,192,192));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240,240,240));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(173,173,173));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(240,240,240));
		}
	}*/
	
	
	public void menuClicked(JPanel panel) {
		panelStudentClientInfo.setVisible(false);
		panelSettings.setVisible(false);

		panelAttendance.setVisible(false);
		panelAddTeacher.setVisible(false);
		
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		 @Override
		 public void mouseEntered(MouseEvent e) {
			 panel.setBackground(new Color(212,212,212));
		 }
		 public void mouseExited(MouseEvent e) {
			 panel.setBackground(new Color(240,240,240));
		 }
		 public void mousePressed(MouseEvent e) {
			 panel.setBackground(new Color(226,226,226));
		 }
	}
}

package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class TestApi extends JFrame {

	private JPanel contentPane;
	private JTextField textApiKey;
	private JTextField txtSender;
	private JTextField txtNumber;
	private JTextField txtMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestApi frame = new TestApi();
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
	public TestApi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 462);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(411, 11, 12, 21);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this program?","Confirm",JOptionPane.YES_NO_OPTION) == 0)
					TestApi.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.BLACK);
			}
		});
		contentPane.setLayout(null);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblX);
		
		textApiKey = new JTextField();
		textApiKey.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textApiKey.getText().equals("API Key")) {
					textApiKey.setText("");
				} else {
					textApiKey.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textApiKey.getText().equals(""))
					textApiKey.setText("API Key");
			}
		});
		textApiKey.setText("API Key");
		textApiKey.setHorizontalAlignment(SwingConstants.CENTER);
		textApiKey.setFont(new Font("Arial", Font.PLAIN, 15));
		textApiKey.setColumns(10);
		textApiKey.setBorder(new LineBorder(new Color(0, 0, 0)));
		textApiKey.setBackground(SystemColor.menu);
		textApiKey.setBounds(36, 48, 347, 45);
		contentPane.add(textApiKey);
		
		txtSender = new JTextField();
		txtSender.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSender.getText().equals("Sender")) {
					txtSender.setText("");
				} else {
					txtSender.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSender.getText().equals(""))
					txtSender.setText("Sender");
			}
		});
		txtSender.setText("Sender");
		txtSender.setHorizontalAlignment(SwingConstants.CENTER);
		txtSender.setFont(new Font("Arial", Font.PLAIN, 15));
		txtSender.setColumns(10);
		txtSender.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSender.setBackground(SystemColor.menu);
		txtSender.setBounds(36, 120, 347, 45);
		contentPane.add(txtSender);
		
		txtNumber = new JTextField();
		txtNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtNumber.getText().equals("Number")) {
					txtNumber.setText("");
				} else {
					txtNumber.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNumber.getText().equals(""))
					txtNumber.setText("Number");
			}
		});
		txtNumber.setText("Number");
		txtNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumber.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNumber.setColumns(10);
		txtNumber.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtNumber.setBackground(SystemColor.menu);
		txtNumber.setBounds(36, 189, 347, 45);
		contentPane.add(txtNumber);
		
		txtMessage = new JTextField();
		txtMessage.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtMessage.getText().equals("Message")) {
					txtMessage.setText("");
				} else {
					txtMessage.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtMessage.getText().equals(""))
					txtMessage.setText("Message");
			}
		});
		txtMessage.setText("Message");
		txtMessage.setHorizontalAlignment(SwingConstants.CENTER);
		txtMessage.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMessage.setColumns(10);
		txtMessage.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMessage.setBackground(SystemColor.menu);
		txtMessage.setBounds(36, 254, 347, 121);
		contentPane.add(txtMessage);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Construct data
					String apiKey = "apikey=" + textApiKey.getText();
					String message = "&message=" + txtMessage.getText();
					String sender = "&sender=" + txtSender.getText();
					String numbers = "&numbers=" + txtNumber.getText();
					
					// Send data
					HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
					String data = apiKey + numbers + message + sender;
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
					conn.getOutputStream().write(data.getBytes("UTF-8"));
					final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					final StringBuffer stringBuffer = new StringBuffer();
					String line;
					while ((line = rd.readLine()) != null) {
						//stringBuffer.append(line);
						JOptionPane.showMessageDialog(null, "message"+line);
					}
					rd.close();
					
					//return stringBuffer.toString();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
					//System.out.println("Error SMS "+e);
					//return "Error "+e;
				}
			}
		});
		btnSend.setFont(new Font("Arial", Font.BOLD, 15));
		btnSend.setFocusable(false);
		btnSend.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSend.setBackground(SystemColor.menu);
		btnSend.setBounds(36, 399, 347, 32);
		contentPane.add(btnSend);
	}
}

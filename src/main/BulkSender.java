package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;

public class BulkSender extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BulkSender frame = new BulkSender();
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
	public BulkSender() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 61, 561, 462);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSections = new JLabel("Sections");
		lblSections.setBounds(258, 220, 114, 30);
		lblSections.setHorizontalAlignment(SwingConstants.CENTER);
		lblSections.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(lblSections);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 116, 440);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSelected = new JLabel("Selected");
		lblSelected.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelected.setFont(new Font("Arial", Font.BOLD, 17));
		lblSelected.setBounds(0, 0, 114, 28);
		panel_1.add(lblSelected);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(10, 24, 17, 405);
		panel_1.add(scrollBar);
		
		JPanel panel_2_1_2_1_1 = new JPanel();
		panel_2_1_2_1_1.setLayout(null);
		panel_2_1_2_1_1.setBackground(new Color(218, 218, 218));
		panel_2_1_2_1_1.setBounds(308, 534, 263, 54);
		contentPane.add(panel_2_1_2_1_1);
		
		JButton btnSendSelected = new JButton("Send Selected");
		btnSendSelected.setFont(new Font("Arial", Font.BOLD, 15));
		btnSendSelected.setFocusable(false);
		btnSendSelected.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSendSelected.setBackground(new Color(240, 240, 240));
		btnSendSelected.setBounds(10, 11, 243, 32);
		panel_2_1_2_1_1.add(btnSendSelected);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(539, 11, 32, 21);
		contentPane.add(lblX);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this program?","Confirm",JOptionPane.YES_NO_OPTION) == 0)
					BulkSender.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.BLACK);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBackground(new Color(218, 218, 218));
		panel_2_1_2.setBounds(10, 11, 519, 39);
		contentPane.add(panel_2_1_2);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals("Api Key")) {
					textField.setText("");
				} else {
					textField.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals(""))
					textField.setText("Api Key");
			}
		});
		textField.setText("Api Key");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setBackground(SystemColor.menu);
		textField.setBounds(10, 11, 499, 20);
		panel_2_1_2.add(textField);
	}

}

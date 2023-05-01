package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class PanelSender extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelSender() {
		setBorder(null);
		setSize(643,534);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SMS Sender");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 24, 165, 30);
		add(lblNewLabel);
		
		JButton btnTestApi_1 = new JButton("Test API");
		btnTestApi_1.setBounds(10, 491, 89, 32);
		add(btnTestApi_1);
		btnTestApi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestApi n = new TestApi();
				n.setVisible(true);
				}
		});
		btnTestApi_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnTestApi_1.setFocusable(false);
		btnTestApi_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnTestApi_1.setBackground(new Color(240, 240, 240));
		
		JLabel lblNewLabel_2 = new JLabel("Test your API before using it");
		lblNewLabel_2.setBounds(10, 475, 180, 14);
		add(lblNewLabel_2);
	}
}

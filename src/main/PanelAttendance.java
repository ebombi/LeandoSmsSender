package main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelAttendance extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAttendance() {
		setBorder(null);
		setSize(643,534);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Students Attendance");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 11, 257, 56);
		add(lblNewLabel);
	}

}

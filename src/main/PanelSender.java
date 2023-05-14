package main;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class PanelSender extends JPanel {
    private JTable table;
    private DefaultTableModel model;

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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 161, 623, 214);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 603, 192);
		panel.add(scrollPane);
		
		table = new JTable() {
        	@Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // Make all cells uneditable
		    }
        };
        
        model = new DefaultTableModel(new String[]{"First Name", "Last Name", "Mobile Number"}, 0);
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        
		scrollPane.setViewportView(table);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Confirm Close", JOptionPane.YES_NO_OPTION);
		        if (result == JOptionPane.YES_OPTION) {
		            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelSender.this);
		            frame.dispose();
		        }
		    }
		    @Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.BLACK);
			}
		});
		lblX.setBounds(539, 11, 32, 21);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblX.setBounds(601, 11, 32, 21);
		add(lblX);

		
	}

	public void addRow(String fname, String lname, String mobilenumber) {
	    model.addRow(new Object[]{fname, lname, mobilenumber});
	}
}

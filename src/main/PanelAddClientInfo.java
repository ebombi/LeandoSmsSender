package main;

import javax.swing.JPanel;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import java.awt.ScrollPane;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;

public class PanelAddClientInfo extends JPanel {
	
	Connection conn;
	private JTextField txtFname;
	private JTextField txtMi;
	private JTextField txtLname;
	private JTextField txtCnum;
	private JTable table;
	DefaultTableModel model;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public PanelAddClientInfo() {
	 try {
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/leandroproject","root","");
		}catch(SQLException connectionError) {
			connectionError.printStackTrace();
		}
		
		setBorder(null);
		setSize(643,534);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Add Student Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 22, 308, 30);
		add(lblNewLabel);
		
		txtFname = new JTextField();
		txtFname.setEnabled(false);
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
		txtFname.setBounds(20, 70, 140, 45);
		add(txtFname);
		
		txtMi = new JTextField();
		txtMi.setEnabled(false);
		txtMi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtMi.getText().equals("Middle Name")) {
					txtMi.setText("");
				} else {
					txtMi.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtMi.getText().equals(""))
					txtMi.setText("Middle Name");
			}
		});
		txtMi.setText("Middle Name");
		txtMi.setHorizontalAlignment(SwingConstants.CENTER);
		txtMi.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMi.setColumns(10);
		txtMi.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMi.setBackground(SystemColor.menu);
		txtMi.setBounds(170, 70, 140, 45);
		add(txtMi);
		
		txtLname = new JTextField();
		txtLname.setEnabled(false);
		txtLname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtLname.getText().equals("Last Name")) {
					txtLname.setText("");
				} else {
					txtLname.selectAll();
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
		txtLname.setBounds(320, 70, 140, 45);
		add(txtLname);
		
		JComboBox cbSection = new JComboBox();
		cbSection.setEnabled(false);
		cbSection.setFont(new Font("Arial", Font.PLAIN, 15));
		cbSection.setBackground(new Color(240, 240, 240));
		cbSection.setModel(new DefaultComboBoxModel(new String[] {"Select Section", "ABM", "ICT", "HUMMS", "ATBP"}));
		cbSection.setBounds(481, 139, 140, 45);
		add(cbSection);
		
		
		JPanel panel_2_1_2_1 = new JPanel();
		panel_2_1_2_1.setLayout(null);
		panel_2_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_2_1.setBackground(SystemColor.menu);
		panel_2_1_2_1.setBounds(20, 139, 186, 45);
		add(panel_2_1_2_1);
		
		txtCnum = new JTextField();
		txtCnum.setEnabled(false);
		txtCnum.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCnum.getText().equals("Mobile Number")) {
					txtCnum.setText("");
				} else {
					txtCnum.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCnum.getText().equals(""))
					txtCnum.setText("Mobile Number");
			}
		});
		txtCnum.setText("Mobile Number");
		txtCnum.setHorizontalAlignment(SwingConstants.LEFT);
		txtCnum.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCnum.setColumns(10);
		txtCnum.setBorder(null);
		txtCnum.setBackground(SystemColor.menu);
		txtCnum.setBounds(56, 11, 120, 23);
		panel_2_1_2_1.add(txtCnum);
		
		JLabel lblNewLabel_1 = new JLabel("+63");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(26, 11, 164, 23);
		panel_2_1_2_1.add(lblNewLabel_1);
		
		JDateChooser dateC = new JDateChooser();
		dateC.setEnabled(false);
		dateC.setBounds(267, 139, 140, 45);
		add(dateC);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Date");
		dateC.add(lblNewLabel_3_1_2, BorderLayout.NORTH);
		
		JComboBox cbTeacher = new JComboBox();
		cbTeacher.setEnabled(false);
		cbTeacher.setFont(new Font("Arial", Font.PLAIN, 15));
		cbTeacher.setBackground(SystemColor.menu);
		cbTeacher.setBounds(481, 70, 140, 45);
		add(cbTeacher);
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leandroproject", "root", "");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT lname FROM tbl_teachers");
			
            cbTeacher.removeAllItems();
            cbTeacher.addItem("Select Teacher");
            while (rs.next()) {
                cbTeacher.addItem(rs.getString("lname"));
            }

            conn.close();
		}catch(Exception e) {
            e.printStackTrace();

		}

		JLabel lblNewLabel_3 = new JLabel("Parents Contact No.");
		lblNewLabel_3.setBounds(20, 126, 186, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("First Name");
		lblNewLabel_3_1.setBounds(20, 56, 186, 14);
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Middle Name");
		lblNewLabel_3_2.setBounds(170, 56, 140, 14);
		add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Last Name");
		lblNewLabel_3_3.setBounds(320, 56, 143, 14);
		add(lblNewLabel_3_3);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 309, 611, 214);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 591, 192);
		panel.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel() {
			  @Override
			    public boolean isCellEditable(int row, int column) {
			        // Make all cells uneditable
			        return false;
			    }
		};
		model.addColumn("ID");
		model.addColumn("First Name");
		model.addColumn("Middle Name");
		model.addColumn("Last Name");
		model.addColumn("Section");
		model.addColumn("Teacher");
		model.addColumn("Contact No.");
		model.addColumn("Date");
		
		String query = "SELECT id, fname, mi, lname, section, teacher, mobilenumber, date FROM tbl_student";
		try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
		    ResultSet rs = preparedStatement.executeQuery();
		    while (rs.next()) {
		        Object[] row = new Object[]{
		            rs.getInt("id"),
		            rs.getString("fname"),
		            rs.getString("mi"),
		            rs.getString("lname"),
		            rs.getString("section"),
		            rs.getString("teacher"),
		            rs.getString("mobilenumber"),
		            rs.getDate("date")
		        };
		        model.addRow(row);
		    }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		JTable tblStudents = new JTable(model);
		tblStudents.setEnabled(false);
		
		scrollPane.setViewportView(tblStudents);

		tblStudents.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        if (!event.getValueIsAdjusting() && tblStudents.getSelectedRow() != -1) {
		            int selectedRow = tblStudents.getSelectedRow();
		            DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();

		            // Retrieve the values from the selected row
		            String fname = (String) model.getValueAt(selectedRow, 1);
		            String mi = (String) model.getValueAt(selectedRow, 2);
		            String lname = (String) model.getValueAt(selectedRow, 3);
		            String section = (String) model.getValueAt(selectedRow, 4);
		            String teacher = (String) model.getValueAt(selectedRow, 5);
		            String mobilenumber = (String) model.getValueAt(selectedRow, 6);

		            // Set the values to the respective text fields and combo boxes
		            txtFname.setText(fname);
		            txtMi.setText(mi);
		            txtLname.setText(lname);
		            txtCnum.setText(mobilenumber);
		            cbSection.setSelectedItem(section);
		            cbTeacher.setSelectedItem(teacher);
		        }
		    }
		});
		
		JButton btnDelete = new JButton("Submit Delete");
		btnDelete.setEnabled(false);

		JButton btnRefreshData = new JButton("Refresh");
		JButton btnEdit = new JButton("Edit");
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(20, 206, 186, 92);
		add(panel_1);
		panel_1.setLayout(null);
		JButton btnCancel = new JButton("Cancel");
		JButton btnSubmitAdd = new JButton("Submit Add");
		JButton btnAdd = new JButton("Add");
		JButton btnDelete_1 = new JButton("Delete");
		btnSubmitAdd.setEnabled(false);
		btnSubmitAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	
		        // Check if any required field is empty
		    	if (txtFname.getText().isEmpty() || txtFname.getText().equals("First Name")) {
		    	    JOptionPane.showMessageDialog(null, "Please input the first name");
		    	    return;
		    	}
		        if (txtMi.getText().isEmpty()|| txtMi.getText().equals("Middle Name")) {
		            JOptionPane.showMessageDialog(null, "Please input the middle name");
		            return;
		        }
		        if (txtLname.getText().isEmpty()|| txtLname.getText().equals("Last Name")) {
		            JOptionPane.showMessageDialog(null, "Please input the last name");
		            return;
		        }
		        if (txtCnum.getText().isEmpty()|| txtCnum.getText().equals("Mobile Number")) {
		            JOptionPane.showMessageDialog(null, "Please input the contact number");
		            return;
		        }
		        if (cbSection.getSelectedItem() == null || cbSection.getSelectedItem().equals("Select Section")) {
		            JOptionPane.showMessageDialog(null, "Please select a section");
		            return;
		        }
		        if (cbTeacher.getSelectedItem() == null || cbTeacher.getSelectedItem().equals("Select Teacher")) {
		            JOptionPane.showMessageDialog(null, "Please select a teacher");
		            return;
		        }
		        
		        
		        if (dateC.getDate() == null) {
		            JOptionPane.showMessageDialog(null, "Please select a date");
		            return;
		        }
		        //dateC

		        // If all required fields are filled, proceed with insertion
		        btnDelete_1.setEnabled(true);
		        btnRefreshData.setEnabled(true);
		        dateC.setEnabled(false);
		        txtFname.setEnabled(false);
		        txtMi.setEnabled(false);
		        txtLname.setEnabled(false);
		        txtCnum.setEnabled(false);
		        cbSection.setEnabled(false);
		        cbTeacher.setEnabled(false);
		        btnEdit.setEnabled(true);
		        btnCancel.setEnabled(false);
		        btnSubmitAdd.setEnabled(false);
		        btnAdd.setEnabled(true);

		        String query = "INSERT INTO tbl_student (fname, mi, lname, section, teacher, mobilenumber, date) VALUES (?, ?, ?, ?, ?, ?, ?)";
		        String selectedSection = (String) cbSection.getSelectedItem();
		        String selectedTeacher = (String) cbTeacher.getSelectedItem();

		        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
		            preparedStatement.setString(1, txtFname.getText());
		            preparedStatement.setString(2, txtMi.getText());
		            preparedStatement.setString(3, txtLname.getText());
		            preparedStatement.setString(4, selectedSection);
		            preparedStatement.setString(5, selectedTeacher);
		            preparedStatement.setString(6, txtCnum.getText());
		            java.util.Date selectedDate = dateC.getDate();
		            java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
		            preparedStatement.setDate(7, sqlDate);
		            int affectedRows = preparedStatement.executeUpdate();
		            if (affectedRows > 0) {
		                JOptionPane.showMessageDialog(null, "Data Added Successfully!");
		            } else {
		                JOptionPane.showMessageDialog(null, "Something went wrong!");
		            }
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }		        
		    }

			
			
		});
		btnSubmitAdd.setBounds(10, 50, 166, 31);
		panel_1.add(btnSubmitAdd);
		btnSubmitAdd.setFont(new Font("Arial", Font.BOLD, 15));
		btnSubmitAdd.setFocusable(false);
		btnSubmitAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSubmitAdd.setBackground(SystemColor.menu);
		

		btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
		btnAdd.setFocusable(false);
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdd.setBackground(SystemColor.menu);
		btnAdd.setBounds(10, 11, 76, 31);
		panel_1.add(btnAdd);
		
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_1.setEnabled(true);
				btnEdit.setEnabled(true);
				txtFname.setEnabled(false);
				txtMi.setEnabled(false);
				txtLname.setEnabled(false);
				txtCnum.setEnabled(false);
				cbSection.setEnabled(false);
				cbTeacher.setEnabled(false);
				btnCancel.setEnabled(false);
				btnSubmitAdd.setEnabled(false);
				dateC.setEnabled(false);
				btnAdd.setEnabled(true);
				btnRefreshData.setEnabled(true);
				
				txtFname.setText("First Name");
				txtMi.setText("Middle Name");
				txtLname.setText("Last Name");
				txtCnum.setText("Mobile Number");
			}
		});
		btnCancel.setEnabled(false);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 15));
		btnCancel.setFocusable(false);
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCancel.setBackground(SystemColor.menu);
		btnCancel.setBounds(100, 11, 76, 31);
		panel_1.add(btnCancel);
		

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_1.setEnabled(false);
				
				btnEdit.setEnabled(false);
				txtFname.setEnabled(true);
				txtLname.setEnabled(true);
				txtMi.setEnabled(true);
				txtCnum.setEnabled(true);
				cbSection.setEnabled(true);
				cbTeacher.setEnabled(true);
				btnCancel.setEnabled(true);
				btnSubmitAdd.setEnabled(true);
				btnAdd.setEnabled(false);
				dateC.setEnabled(true);
				btnRefreshData.setEnabled(false);
				btnDelete.setEnabled(false);
				
				txtFname.setText("First Name");
				txtMi.setText("Middle Name");
				txtLname.setText("Last Name");
				txtCnum.setText("Mobile Number");
			}
		});
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(216, 206, 186, 92);
		add(panel_1_1);
		
		JButton btnCancel_1 = new JButton("Cancel");
		
		JButton btnSubmitEdit = new JButton("Submit Edit");
		btnSubmitEdit.setEnabled(false);
		btnSubmitEdit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	btnRefreshData.setEnabled(true);
		    	txtFname.setEnabled(false);
				txtLname.setEnabled(false);
				txtMi.setEnabled(false);
				txtCnum.setEnabled(false);
				cbSection.setEnabled(false);
				cbTeacher.setEnabled(false);
				btnCancel_1.setEnabled(false);
				dateC.setEnabled(false);
				tblStudents.setEnabled(false);
				btnDelete_1.setEnabled(true);
				btnAdd.setEnabled(true);
				btnSubmitEdit.setEnabled(false);
				btnEdit.setEnabled(true);
		    	
		        int selectedRow = tblStudents.getSelectedRow();
		        
		        if (selectedRow != -1) {
		            // Retrieve the updated values from the text fields
		            String updatedFname = txtFname.getText();
		            String updatedMi = txtMi.getText();
		            String updatedLname = txtLname.getText();
		            String updatedSection = (String) cbSection.getSelectedItem();
		            String updatedTeacher = (String) cbTeacher.getSelectedItem();
		            String updatedMobilenumber = txtCnum.getText();
		            // ...

		            // Update the corresponding row in the table model
		            DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
		            model.setValueAt(updatedFname, selectedRow, 1);
		            model.setValueAt(updatedMi, selectedRow, 2);
		            model.setValueAt(updatedLname, selectedRow, 3);
		            model.setValueAt(updatedSection, selectedRow, 4);
		            model.setValueAt(updatedTeacher, selectedRow, 5);
		            model.setValueAt(updatedMobilenumber, selectedRow, 6);
		            // ...

		            // Perform database update if needed
		            int id = (int) tblStudents.getValueAt(selectedRow, 0);
		            String query = "UPDATE tbl_student SET fname = ?, mi = ?, lname = ?, section = ?, teacher = ?, mobilenumber = ? WHERE id = ?";
		            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
		                preparedStatement.setString(1, updatedFname);
		                preparedStatement.setString(2, updatedMi);
		                preparedStatement.setString(3, updatedLname);
		                preparedStatement.setString(4, updatedSection);
		                preparedStatement.setString(5, updatedTeacher);
		                preparedStatement.setString(6, updatedMobilenumber);
		                preparedStatement.setInt(7, id);
		                int affectedRows = preparedStatement.executeUpdate();
		                if (affectedRows > 0) {
		                    JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(null, "Failed to Update Data!");
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a row to edit.");
		        }
		    }
		});
		btnSubmitEdit.setFont(new Font("Arial", Font.BOLD, 15));
		btnSubmitEdit.setFocusable(false);
		btnSubmitEdit.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSubmitEdit.setBackground(SystemColor.menu);
		btnSubmitEdit.setBounds(10, 53, 166, 31);
		panel_1_1.add(btnSubmitEdit);
		
		
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_1.setEnabled(true);
				txtFname.setEnabled(false);
				txtLname.setEnabled(false);
				txtMi.setEnabled(false);
				txtCnum.setEnabled(false);
				cbSection.setEnabled(false);
				cbTeacher.setEnabled(false);
				btnCancel_1.setEnabled(false);
				dateC.setEnabled(false);
				tblStudents.setEnabled(false);
				
				btnAdd.setEnabled(true);
				btnSubmitEdit.setEnabled(false);
				btnEdit.setEnabled(true);
				btnRefreshData.setEnabled(true);
				txtFname.setText("First Name");
				txtMi.setText("Middle Name");
				txtLname.setText("Last Name");
				txtCnum.setText("Mobile Number");
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_1.setEnabled(false);
				txtFname.setEnabled(true);
				txtLname.setEnabled(true);
				txtMi.setEnabled(true);
				txtCnum.setEnabled(true);
				cbSection.setEnabled(true);
				cbTeacher.setEnabled(true);
				btnCancel_1.setEnabled(true);
				dateC.setEnabled(true);
				btnSubmitEdit.setEnabled(true);
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(false);
				btnRefreshData.setEnabled(false);
				btnDelete.setEnabled(false);
				tblStudents.setEnabled(true);
				txtFname.setText("First Name");
				txtMi.setText("Middle Name");
				txtLname.setText("Last Name");
				txtCnum.setText("Mobile Number");
			}
		});
		btnEdit.setFont(new Font("Arial", Font.BOLD, 15));
		btnEdit.setFocusable(false);
		btnEdit.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEdit.setBackground(SystemColor.menu);
		btnEdit.setBounds(10, 11, 76, 31);
		panel_1_1.add(btnEdit);
		
		
		btnCancel_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnCancel_1.setFocusable(false);
		btnCancel_1.setEnabled(false);
		btnCancel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCancel_1.setBackground(SystemColor.menu);
		btnCancel_1.setBounds(100, 11, 76, 31);
		panel_1_1.add(btnCancel_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(412, 206, 201, 92);
		add(panel_1_1_1);
		

		btnRefreshData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT id, fname, mi, lname, section, teacher, mobilenumber, date FROM tbl_student";
		        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
		            ResultSet rs = preparedStatement.executeQuery();
		            
		            DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
		            model.setRowCount(0); // Clear the existing table data
		            
		            while (rs.next()) {
		                Object[] row = new Object[] {
		                    rs.getInt("id"),
		                    rs.getString("fname"),
		                    rs.getString("mi"),
		                    rs.getString("lname"),
		                    rs.getString("section"),
		                    rs.getString("teacher"),
		                    rs.getString("mobilenumber"),
		                    rs.getDate("date")
		                };
		                model.addRow(row);
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnRefreshData.setFont(new Font("Arial", Font.BOLD, 15));
		btnRefreshData.setFocusable(false);
		btnRefreshData.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRefreshData.setBackground(SystemColor.menu);
		btnRefreshData.setBounds(86, 11, 105, 31);
		panel_1_1_1.add(btnRefreshData);
		
		btnDelete.setBounds(10, 53, 181, 28);
		panel_1_1_1.add(btnDelete);

		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	tblStudents.setEnabled(false);
		    	btnDelete.setEnabled(false);
		    	btnAdd.setEnabled(true);
		    	btnEdit.setEnabled(true);
		    	btnDelete_1.setEnabled(true);
		    	btnRefreshData.setEnabled(true);
		    	
		    	
		        int[] selectedRows = tblStudents.getSelectedRows();
		        if (selectedRows.length > 0) {
		            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected data?", "Confirmation", JOptionPane.YES_NO_OPTION);
		            if (confirm == JOptionPane.YES_OPTION) {
		                // Perform the deletion for each selected row
		                DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
		                String query = "DELETE FROM tbl_student WHERE id = ?";
		                try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
		                    for (int i = selectedRows.length - 1; i >= 0; i--) {
		                        int selectedRow = selectedRows[i];
		                        int id = (int) model.getValueAt(selectedRow, 0);
		                        preparedStatement.setInt(1, id);
		                        int affectedRows = preparedStatement.executeUpdate();
		                        if (affectedRows > 0) {
		                            model.removeRow(selectedRow);
		                        } else {
		                            JOptionPane.showMessageDialog(null, "Failed to Delete Data!");
		                        }
		                    }
		                    JOptionPane.showMessageDialog(null, "Data Deleted Successfully!");
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select rows to delete.");
		        }
		    }
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDelete.setBackground(SystemColor.menu);
		

		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(false);
				btnDelete_1.setEnabled(false);
				btnRefreshData.setEnabled(false);
				btnDelete.setEnabled(true);
				
				tblStudents.setEnabled(true);
			}
		});
		btnDelete_1.setBounds(10, 11, 66, 31);
		panel_1_1_1.add(btnDelete_1);
		btnDelete_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnDelete_1.setFocusable(false);
		btnDelete_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDelete_1.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Add Buttons");
		lblNewLabel_3_1_1.setBounds(20, 192, 186, 14);
		add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Edit Buttons");
		lblNewLabel_3_1_1_1.setBounds(216, 192, 186, 14);
		add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Delete Buttons");
		lblNewLabel_3_1_1_1_1.setBounds(412, 192, 186, 14);
		add(lblNewLabel_3_1_1_1_1);
		table_1 = new JTable(new DefaultTableModel(){
		    @Override
	/*	    public boolean isCellEditable(int row, int column) {
		        // Make the "ID" (column index 0), "Name" (column index 1), and "Age" (column index 2) columns uneditable
		        return column != 0 && column != 1 && column != 2;
		    }*/
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		});
		

	}
}

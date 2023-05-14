package main;

import javax.swing.JPanel;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PanelAddTeacher extends JPanel {
	Connection conn;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtTeachersId;
	private JTable tblTeachers;

	/**
	 * Create the panel.
	 */
	public PanelAddTeacher() {
		 try {
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/leandroproject","root","");
			}catch(SQLException connectionError) {
				connectionError.printStackTrace();
			}
		setBorder(null);
		setSize(643,534);
		setLayout(null);
		
		JButton btnRefreshData = new JButton("Refresh Data");
		JButton btnDelete = new JButton("Delete");
		
		JLabel lblAddTeacherInformation = new JLabel("Add Teacher Information");
		lblAddTeacherInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddTeacherInformation.setFont(new Font("Arial", Font.BOLD, 25));
		lblAddTeacherInformation.setBounds(10, 11, 308, 30);
		add(lblAddTeacherInformation);
		
		
		
		JLabel lblNewLabel_3_1 = new JLabel("First Name");
		lblNewLabel_3_1.setBounds(20, 56, 140, 14);
		add(lblNewLabel_3_1);
		
		txtFname = new JTextField();
		txtFname.setEnabled(false);
		
		txtFname.setText("First Name");
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
		txtFname.setHorizontalAlignment(SwingConstants.CENTER);
		txtFname.setFont(new Font("Arial", Font.PLAIN, 15));
		txtFname.setColumns(10);
		txtFname.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtFname.setBackground(SystemColor.menu);
		txtFname.setBounds(20, 70, 140, 45);
		add(txtFname);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Last Name");
		lblNewLabel_3_1_2.setBounds(186, 56, 140, 14);
		add(lblNewLabel_3_1_2);
		
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
		txtLname.setBounds(186, 70, 140, 45);
		add(txtLname);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Teachers ID");
		lblNewLabel_3_1_1.setBounds(350, 56, 140, 14);
		add(lblNewLabel_3_1_1);
		
		txtTeachersId = new JTextField();
		txtTeachersId.setEnabled(false);
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
		txtTeachersId.setBounds(350, 70, 140, 45);
		add(txtTeachersId);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(20, 140, 186, 92);
		add(panel_1);
		JButton btnEdit = new JButton("Edit");
		JButton btnAdd = new JButton("Add");
		JButton btnSubmitAdd = new JButton("Submit Add");
		JButton btnCancel = new JButton("Cancel");
		btnSubmitAdd.setEnabled(false);
		btnSubmitAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btnRefreshData.setEnabled(true);
		        btnDelete.setEnabled(true);

		        String fname = txtFname.getText();
		        String lname = txtLname.getText();
		        String teachersId = txtTeachersId.getText();

		        // Check if the fields are empty or have default text
		        if (fname.isEmpty() || fname.equals("First Name")) {
		            JOptionPane.showMessageDialog(null, "Please input First Name!");
		            return;
		        }
		        if (lname.isEmpty() || lname.equals("Last Name")) {
		            JOptionPane.showMessageDialog(null, "Please input Last Name!");
		            return;
		        }
		        if (teachersId.isEmpty() || teachersId.equals("Teachers ID")) {
		            JOptionPane.showMessageDialog(null, "Please input Teachers ID!");
		            return;
		        }

		        String query = "INSERT INTO tbl_teachers (fname, lname, teachers_id) VALUES (?, ?, ?)";
		        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
		            preparedStatement.setString(1, fname);
		            preparedStatement.setString(2, lname);
		            preparedStatement.setString(3, teachersId);

		            int affectedRows = preparedStatement.executeUpdate();
		            if (affectedRows > 0) {
		                JOptionPane.showMessageDialog(null, "Teacher added successfully!");
		            } else {
		                JOptionPane.showMessageDialog(null, "Failed to add teacher!");
		            }
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }

		        txtFname.setEnabled(false);
		        txtLname.setEnabled(false);
		        txtTeachersId.setEnabled(false);

		        btnSubmitAdd.setEnabled(false);
		        btnCancel.setEnabled(false);
		        btnAdd.setEnabled(true);
		        btnEdit.setEnabled(true);
		    }
		});

		btnSubmitAdd.setFont(new Font("Arial", Font.BOLD, 15));
		btnSubmitAdd.setFocusable(false);
		btnSubmitAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSubmitAdd.setBackground(SystemColor.menu);
		btnSubmitAdd.setBounds(10, 50, 166, 31);
		panel_1.add(btnSubmitAdd);

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshData.setEnabled(true);
				btnDelete.setEnabled(true);
				
				txtFname.setEnabled(false);
				txtLname.setEnabled(false);
				txtTeachersId.setEnabled(false);
				
				btnSubmitAdd.setEnabled(false);
				btnCancel.setEnabled(false);
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(true);
			}
		});


		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnRefreshData.setEnabled(false);
				btnDelete.setEnabled(false);
				
				
				btnCancel.setEnabled(true);
				btnSubmitAdd.setEnabled(true);
				btnAdd.setEnabled(false);
				
				txtFname.setEnabled(true);
				txtLname.setEnabled(true);
				txtTeachersId.setEnabled(true);
				btnEdit.setEnabled(false);
				
				txtFname.setText("First Name");
				txtLname.setText("Last Name");
				txtTeachersId.setText("Teachers ID");
				
			}
		});
		btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
		btnAdd.setFocusable(false);
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdd.setBackground(SystemColor.menu);
		btnAdd.setBounds(10, 11, 76, 31);
		panel_1.add(btnAdd);
		
		
		btnCancel.setEnabled(false);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 15));
		btnCancel.setFocusable(false);
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCancel.setBackground(SystemColor.menu);
		btnCancel.setBounds(100, 11, 76, 31);
		panel_1.add(btnCancel);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Add Buttons");
		lblNewLabel_3_1_1_1.setBounds(20, 126, 186, 14);
		add(lblNewLabel_3_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(20, 243, 611, 280);
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 591, 258);
		panel.add(scrollPane);
		
		JTable tblTeachers = new JTable() {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // Make all cells uneditable
		    }
		};
		tblTeachers.getTableHeader().setReorderingAllowed(false); // Make the table unresizable

		// Rest of your code...

		tblTeachers.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        if (!event.getValueIsAdjusting()) {
		            int selectedRowIndex = tblTeachers.getSelectedRow();
		            if (selectedRowIndex >= 0) {
		                String fname = tblTeachers.getValueAt(selectedRowIndex, 1).toString();
		                String lname = tblTeachers.getValueAt(selectedRowIndex, 2).toString();
		                String teachersId = tblTeachers.getValueAt(selectedRowIndex, 3).toString();

		                txtFname.setText(fname);
		                txtLname.setText(lname);
		                txtTeachersId.setText(teachersId);
		            }
		        }
		    }
		});
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("First Name");
		model.addColumn("Last Name");
		model.addColumn("Teacher ID");
		scrollPane.setViewportView(tblTeachers);
		
		
		
		String query = "SELECT * FROM tbl_teachers";
		try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
			 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
			        String id = rs.getString("id");
			        String firstName = rs.getString("fname");
			        String lastName = rs.getString("lname");
			        String teacher_id = rs.getString("teachers_id");
			        model.addRow(new Object[]{id, firstName, lastName, teacher_id});
			    }
			 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tblTeachers.setModel(model);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1.setBounds(418, 194, 201, 38);
		add(panel_1_1_1);
		
		
		btnRefreshData.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Clear existing data from the table model
		            DefaultTableModel model = (DefaultTableModel) tblTeachers.getModel();
		            model.setRowCount(0);
		            
		            // Retrieve updated data from the database
		            String query = "SELECT id, fname, lname, teachers_id FROM tbl_teachers";
		            PreparedStatement preparedStatement = conn.prepareStatement(query);
		            ResultSet resultSet = preparedStatement.executeQuery();
		            
		            // Populate the table model with the retrieved data
		            while (resultSet.next()) {
		                Object[] row = new Object[]{
		                    resultSet.getInt("id"),
		                    resultSet.getString("fname"),
		                    resultSet.getString("lname"),
		                    resultSet.getString("teachers_id")
		                };
		                model.addRow(row);
		            }
		            
		            // Close the ResultSet and PreparedStatement
		            resultSet.close();
		            preparedStatement.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		btnRefreshData.setFont(new Font("Arial", Font.BOLD, 15));
		btnRefreshData.setFocusable(false);
		btnRefreshData.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRefreshData.setBackground(SystemColor.menu);
		btnRefreshData.setBounds(10, 11, 115, 20);
		panel_1_1_1.add(btnRefreshData);
		

		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRowIndex = tblTeachers.getSelectedRow();
		        if (selectedRowIndex >= 0) {
		            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this teacher?", "Confirmation", JOptionPane.YES_NO_OPTION);
		            if (confirmation == JOptionPane.YES_OPTION) {
		                String teacherId = tblTeachers.getValueAt(selectedRowIndex, 0).toString(); // Assuming the teacher ID is in the first column

		                String query = "DELETE FROM tbl_teachers WHERE id = ?";
		                try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
		                    preparedStatement.setString(1, teacherId);
		                    int affectedRows = preparedStatement.executeUpdate();
		                    if (affectedRows > 0) {
		                        DefaultTableModel model = (DefaultTableModel) tblTeachers.getModel();
		                        model.removeRow(selectedRowIndex);
		                        JOptionPane.showMessageDialog(null, "Teacher deleted successfully!");
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Failed to delete teacher!");
		                    }
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
		        }
		    }
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
		btnDelete.setFocusable(false);
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDelete.setBackground(SystemColor.menu);
		btnDelete.setBounds(131, 11, 60, 20);
		panel_1_1_1.add(btnDelete);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Edit Buttons");
		lblNewLabel_3_1_1_1_1.setBounds(216, 126, 186, 14);
		add(lblNewLabel_3_1_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBounds(216, 140, 186, 92);
		add(panel_1_1);
		JButton btnCancel_1 = new JButton("Cancel");
		JButton btnSubmitEdit = new JButton("Submit Edit");
		btnSubmitEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			    btnRefreshData.setEnabled(true);
			    btnDelete.setEnabled(true);

			    txtFname.setEnabled(false);
			    txtLname.setEnabled(false);
			    txtTeachersId.setEnabled(false);

			    btnAdd.setEnabled(true);
			    btnEdit.setEnabled(true);

			    btnCancel_1.setEnabled(false);
			    btnSubmitEdit.setEnabled(false);

			    int selectedRowIndex = tblTeachers.getSelectedRow();
			    if (selectedRowIndex >= 0) {
			        String teacherId = tblTeachers.getValueAt(selectedRowIndex, 0).toString(); // Assuming the teacher ID is in the first column
			        String fname = txtFname.getText();
			        String lname = txtLname.getText();
			        String teachersId = txtTeachersId.getText();

			        // Check if the fields are empty or have default text
			        if (fname.isEmpty() || fname.equals("First Name")) {
			            JOptionPane.showMessageDialog(null, "Please input First Name!");
			            return;
			        }
			        if (lname.isEmpty() || lname.equals("Last Name")) {
			            JOptionPane.showMessageDialog(null, "Please input Last Name!");
			            return;
			        }
			        if (teachersId.isEmpty() || teachersId.equals("Teachers ID")) {
			            JOptionPane.showMessageDialog(null, "Please input Teachers ID!");
			            return;
			        }

			        String query = "UPDATE tbl_teachers SET fname = ?, lname = ?, teachers_id = ? WHERE id = ?";
			        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			            preparedStatement.setString(1, fname);
			            preparedStatement.setString(2, lname);
			            preparedStatement.setString(3, teachersId);
			            preparedStatement.setString(4, teacherId);

			            int affectedRows = preparedStatement.executeUpdate();
			            if (affectedRows > 0) {
			                DefaultTableModel model = (DefaultTableModel) tblTeachers.getModel();
			                model.setValueAt(fname, selectedRowIndex, 1); // Assuming the first name is in the second column
			                model.setValueAt(lname, selectedRowIndex, 2); // Assuming the last name is in the third column
			                model.setValueAt(teachersId, selectedRowIndex, 3); // Assuming the teacher ID is in the fourth column
			                JOptionPane.showMessageDialog(null, "Teacher updated successfully!");
			            } else {
			                JOptionPane.showMessageDialog(null, "Failed to update teacher!");
			            }
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			        }
			    } else {
			        JOptionPane.showMessageDialog(null, "Please select a row to update.");
			    }
			}
		});
		btnSubmitEdit.setFont(new Font("Arial", Font.BOLD, 15));
		btnSubmitEdit.setFocusable(false);
		btnSubmitEdit.setEnabled(false);
		btnSubmitEdit.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSubmitEdit.setBackground(SystemColor.menu);
		btnSubmitEdit.setBounds(10, 53, 166, 31);
		panel_1_1.add(btnSubmitEdit);


		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnRefreshData.setEnabled(true);
				btnDelete.setEnabled(true);
				
				txtFname.setEnabled(false);
				txtLname.setEnabled(false);
				txtTeachersId.setEnabled(false);
				
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(true);
				
				btnCancel_1.setEnabled(false);
				btnSubmitEdit.setEnabled(false);
			}
		});

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshData.setEnabled(false);
				btnDelete.setEnabled(false);
				
				txtFname.setEnabled(true);
				txtLname.setEnabled(true);
				txtTeachersId.setEnabled(true);
				btnCancel_1.setEnabled(true);
				btnSubmitEdit.setEnabled(true);
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(false);
				
				txtFname.setText("First Name");
				txtLname.setText("Last Name");
				txtTeachersId.setText("Teachers ID");
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
		
		
		
	}
	
}

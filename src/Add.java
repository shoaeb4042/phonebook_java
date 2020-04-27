import java.awt.BorderLayout;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;

public class Add extends JFrame {

	protected static final Object Succesfully = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;

	/**
	 * Create the frame.
	 */
	public Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name                   : ");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setLabelFor(this);
		lblName.setToolTipText("");
		lblName.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		lblName.setBounds(26, 29, 127, 18);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(153, 22, 172, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number     :");
		lblPhoneNumber.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		lblPhoneNumber.setBounds(26, 63, 127, 18);
		contentPane.add(lblPhoneNumber);
		
		textField_1 = new JTextField();
		textField_1.setText("880");
		textField_1.setColumns(10);
		textField_1.setBounds(153, 63, 172, 25);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Email(optional)    :");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		lblNewLabel.setBounds(26, 102, 127, 18);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(153, 100, 172, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAdd = new JLabel("Address                : ");
		lblAdd.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		lblAdd.setBounds(26, 145, 127, 20);
		contentPane.add(lblAdd);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(153, 139, 172, 25);
		contentPane.add(textField_3);
		
		JLabel lblGroup = new JLabel("Group                   :");
		lblGroup.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		lblGroup.setBounds(25, 184, 128, 25);
		contentPane.add(lblGroup);
		
		textField_4 = new JTextField();
		textField_4.setBounds(153, 180, 172, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Contact a = new Contact();
				a.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		btnCancel.setBounds(63, 220, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					String query="insert into Information (Name,Phone,Email,Address,Group) values (?, ?, ?, ?, ?)";
					//Connection conn=sqliteConnection.dbConnector();
					
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textField.getText() );
					pst.setString(2, textField_1.getText() );
					pst.setString(3, textField_2.getText() );
					pst.setString(4, textField_3.getText() );
					pst.setString(5, textField_4.getText() );
					pst.execute();
					pst.close();
					connection.close();
					
			//		String query = "insert into Information(Name,Phone Number,Email,Address,Group) values(?,?,?,?,?)";
				//	PreparedStatement pst = connection.prepareStatement(query);
					
			/*		
					pst.setString(1, textField.getText() );
					pst.setString(2, textField_1.getText() );
					pst.setString(3, textField_2.getText() );
					pst.setString(4, textField_3.getText() );
					pst.setString(5, textField_4.getText() );
					pst.execute();
					//pst.execute();
					JOptionPane.showMessageDialog(null, "Saved");
					//pst.close();
					//rs.close();
				*/	
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Successfully  Saved");
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		btnNewButton.setBounds(324, 220, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Contact a = new Contact();
				a.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		btnBack.setBounds(0, 0, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					String query="Update Information set Name='"+textField.getText()+"',Phone='"+textField_1.getText()+",Email='"+textField_2.getText()+",Address='"+textField_3.getText()+"',Group='"+textField_4.getText()+"";
					//Connection conn=sqliteConnection.dbConnector();
					
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.execute(); 
					JOptionPane.showMessageDialog(null, "Data Updated");
					//connection.close();
					pst.close();
					}catch (Exception e1) {
						e1.printStackTrace();
					}

			}
		});
		btnUpdate.setBounds(324, 246, 89, 23);
		contentPane.add(btnUpdate);
	}
}

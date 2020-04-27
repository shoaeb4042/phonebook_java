import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Contact extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contact frame = new Contact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;

	/**
	 * Create the frame.
	 */
	public Contact() {
		connection=sqliteConnection.dbConnector();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblContactInformation = new JLabel("Contact Information");
		lblContactInformation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContactInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactInformation.setToolTipText("");
		lblContactInformation.setBackground(Color.GREEN);
		lblContactInformation.setBounds(144, 0, 151, 44);
		getContentPane().add(lblContactInformation);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Add a = new Add();
				a.setVisible(true);
			}
		});
		btnAdd.setBounds(23, 61, 89, 23);
		getContentPane().add(btnAdd);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				View a = new View();
				a.setVisible(true);
			}
		});
		btnView.setBounds(23, 95, 89, 23);
		getContentPane().add(btnView);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		btnUpdate.setBounds(23, 162, 89, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			//	Delete a = new Delete();
				//a.setVisible(true);
			}
		});
		btnDelete.setBounds(23, 196, 89, 23);
		getContentPane().add(btnDelete);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Search a = new Search();
				a.setVisible(true);
			}
		});
		btnSearch.setBounds(23, 129, 89, 23);
		getContentPane().add(btnSearch);

	}

}

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Contact a = new Contact();
				a.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		btnBack.setBounds(0, 0, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnShowContacts = new JButton("Show Contacts ");
		btnShowContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from Information";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pst.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnShowContacts.setFont(new Font("Segoe UI Emoji", Font.BOLD, 12));
		btnShowContacts.setBounds(249, 0, 143, 23);
		contentPane.add(btnShowContacts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 52, 573, 298);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}

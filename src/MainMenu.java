import java.awt.EventQueue;
import java.awt.Image;
import java.awt.*;
import java.sql.DriverManager;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {
	

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainMenu window = new MainMenu();
		//			setResizable(false);
			//		setTitle("User Menu");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void setTitle(String string) {
				// TODO Auto-generated method stub
				
			}

			private void setResizable(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	Connection connection=null;
	
	//Connection connection = null;
	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
		//connection=sqliteConnection.dbConnector();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//connection=Connection.dbConnector();
				connection=sqliteConnection.dbConnector();
			
			    //connection = Connection.dbConnector();	
				frame.dispose();
				Contact a = new Contact();
				a.setVisible(true);
			}
		});
		btnEnter.setFont(new Font("Castellar", Font.PLAIN, 16));
		btnEnter.setForeground(Color.RED);
		btnEnter.setBackground(Color.GREEN);
		btnEnter.setBounds(165, 96, 110, 34);
		frame.getContentPane().add(btnEnter);
	}
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}
	private void setResizable(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

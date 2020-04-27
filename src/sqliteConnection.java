import java.sql.*;
import javax.swing.*;
public class sqliteConnection {
	Connection conn= null;
	public static Connection dbConnector(){
		
		try{
			
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Public\\Info.sqlite");
			JOptionPane.showMessageDialog(null, "Succesfully Connect to DataBase");
			return conn;
			
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Failed");
			return null;
		}
		
	}
	

}

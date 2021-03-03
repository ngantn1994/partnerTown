package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	private static Connection connection = getSQLConnection();
	
	private static Connection getSQLConnection() {
		String classDriver = "net.sourceforge.jtds.jdbc.Driver";
		String url = "jdbc:jtds:sqlserver://localhost:1433/PartnerTown";
		String username = "sa";
		String password = "12345678";

		try {
			Class.forName(classDriver);
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Connection getInstance(){
		return connection;
	}	

}

package bai_tap_nop.connection;

import java.sql.*;

import static java.lang.Class.*;

public class MySQLConnection {
	// fields
	private static final String URL = "jdbc:mysql://localhost:3307/backendfoundation";

	// get mySQL connection
	public static Connection getConnection() {
		try {
			forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, "root", "admin");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

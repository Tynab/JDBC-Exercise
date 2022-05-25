package bai_tap_nop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.*;

public class MySQLConnection {
	// fields
	private static final String url = "jdbc:mysql://34.101.161.213:3306/backendfoundation";

	// get mySQL connection
	public static Connection getConnection() {
		try {
			forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

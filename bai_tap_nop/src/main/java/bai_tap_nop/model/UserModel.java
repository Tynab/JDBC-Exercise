package bai_tap_nop.model;

import bai_tap_nop.pojo.User;
import java.sql.SQLException;

import static bai_tap_nop.connection.MySQLConnection.*;

public class UserModel {
	// get user
	public User getUser(String userName, String password) {
		User user = null;
		var con = getConnection();
		var sql = "SELECT * FROM user WHERE username=? AND password=MD5(?)";
		try {
			var statement = con.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, password);
			var result = statement.executeQuery();
			while (result.next()) {
				user = new User();
				user.setUserName(result.getString("username"));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}

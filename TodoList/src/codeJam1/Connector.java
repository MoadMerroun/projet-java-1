package codeJam1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

	String dbUrl = "jdbc:mysql://localhost:3306/todolist";
	String dbUser = "root";
	String dbPasswd = "";

	Connection c = null;
	Properties cProperties = new Properties();

	public Connection connect() {
		cProperties.put("user", dbUser);
		cProperties.put("password", dbPasswd);
		try {
			c = DriverManager.getConnection(dbUrl, cProperties);
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

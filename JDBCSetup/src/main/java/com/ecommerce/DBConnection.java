package com.ecommerce;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {

	private Connection connection;
	
	public DBConnection(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException {
		
		// 1. Register Driver:
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(dbURL, user, pwd);

		
	}
	
	
	public Connection getConnection() {
		return this.connection;
	}
	
public void closeConnection() throws SQLException {
	if(this.connection != null)
		this.connection.close();
}
}

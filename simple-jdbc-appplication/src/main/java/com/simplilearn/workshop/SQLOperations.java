package com.simplilearn.workshop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.simplilearn.workshop.utils.MySQLDatabaseUtils;

public class SQLOperations {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		findthenumberofcustomers();
		displayallcustomernames();
	
	}
		
		// Find the number of customers:
		public static void findthenumberofcustomers() throws ClassNotFoundException, SQLException {
			Connection connection = MySQLDatabaseUtils.getConnection();
			System.out.println("Obtained a database connection");
		
			// Line below is business logic
			String sql = "SELECT count(*) FROM studentdb.customers";
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			
			// Line below is business logic
			System.out.println("The number of users in database is: "+rs.getInt(1));
			
			rs.close();
			stmt.close();
			connection.close();
		
		}
		
		// Display all customer names:
		public static void displayallcustomernames() throws ClassNotFoundException, SQLException {
			Connection connection = MySQLDatabaseUtils.getConnection();
			System.out.println("Obtained a database connection");
		
			// Line below is business logic
			String sql = "SELECT * FROM studentdb.customers";
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("The users are listed below:");
			
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			
			rs.close();
			stmt.close();
			connection.close();
		}

	}


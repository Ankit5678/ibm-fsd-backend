package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db_Services implements IDb_Services{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database credentials
	static final String USER = "training";
	static final String PASS = "training";
	static Connection conn = null;
	public Db_Services() {
		try {
			// STEP 2: Register JDBC driver with Driver Manager
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			//System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false); // enable transaction
			
			System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			//System.out.println("Creating statement...");
		}catch (Exception e) {
			
		}
	}
	
	Connection connect() {
		
		try {
			// STEP 2: Register JDBC driver with Driver Manager
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			//System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false); // enable transaction

			//System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			//System.out.println("Creating statement...");
		}catch (Exception e) {
			
		}
		return conn;
	}
	
	public ResultSet getAllEmployee() {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String selectQuery = "select * from employee";
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public void insertNewEmployee(int id, int age, String name, String department, String designation, String country) {
		String insertQuery = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(insertQuery);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, designation);
			ps.setString(4, department);
			ps.setString(5, country);
			int i = ps.executeUpdate();
			ps.close();
			System.out.println(i);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

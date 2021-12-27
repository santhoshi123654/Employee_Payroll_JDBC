package com.bridgelabz.Employee_Payroll_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Employee_Payroll_Service {
	
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost" + ":3306/bridgelabzDemo?useSSL=false";
		String userName = "root";
		String password = "Santhu@123";
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("connecting to database : " + jdbcURL);
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Connection is successfull...... " + connection);
		}
	}
}

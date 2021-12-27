package com.bridgelabz.Employee_Payroll_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Employee_Payroll_Service {
	
	public static List<EmployeePayroll> list = new ArrayList<EmployeePayroll>();

	public static void main(String[] args) throws PatternMatchException {
		String jdbcURL = "jdbc:mysql://localhost:3306/bridgelabzDemo";
		String userName = "root";
		String password = "Santhu@123";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		EmployeePayroll employeePayroll = new EmployeePayroll();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("connecting to database : " + jdbcURL);
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is successfull" + connection);
			statement = connection.createStatement();
			String query = "select * from employee_payroll;";
			resultSet = statement.executeQuery(query);
			try {
				while (resultSet.next()) {

					employeePayroll.setEmpId(resultSet.getInt("EmpId"));
					employeePayroll.setEmpName(resultSet.getString("EmpName"));
					employeePayroll.setPhone_Number(resultSet.getLong("Phone_Number"));
					employeePayroll.setAddress(resultSet.getString("Address"));
					employeePayroll.setDepartment(resultSet.getString("Department"));
					employeePayroll.setGender(resultSet.getString("gender"));
					employeePayroll.setBasicPay(resultSet.getDouble("BasicPay"));
					employeePayroll.setDeduction(resultSet.getString("Deduction"));
					employeePayroll.setTaxablePay(resultSet.getString("TaxablePay"));
					employeePayroll.setIncomeTax(resultSet.getString("IncomeTax"));
					employeePayroll.setNetPay(resultSet.getString("NetPay"));
					employeePayroll.setStartDate(resultSet.getDate("StartDate"));
					
					list.add(employeePayroll);
				}
			}
			catch (Exception e) {
				throw new PatternMatchException("Pattern is Mismatched The database should be checked ");
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				try {
					statement.close();
					System.out.println("statement closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
					System.out.println("connection closed");
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(list);
		
	}
}
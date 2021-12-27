package com.bridgelabz.Employee_Payroll_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Employee_Payroll_Service {
	
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;	
	ResultSet resultSet = null;

	public static List<EmployeePayroll> list = new ArrayList<EmployeePayroll>();
	EmployeePayroll employeePayroll = new EmployeePayroll();
	
	Scanner scanner = new Scanner(System.in);
	
	public Statement getConnection() {

		String jdbcURL = "jdbc:mysql://localhost:3306/bridgelabzDemo?useSSL=false";
		String userName = "root";
		String password = "Santhu@123";
		System.out.println("connecting to database : " + jdbcURL);
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is successfull " + connection);
			
			preparedStatement = connection.prepareStatement("select * from employee_payroll where EmpName='Santhoshi'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}
	
	public int updateData(Statement statement) {

		System.out.println("update query : ");
		String updateString = scanner.nextLine();
		int count = 0;
		try {
			count = statement.executeUpdate(updateString);
			System.out.println("successfully updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public ResultSet retrieveData(Statement statement) {

		System.out.println("enter Select query : ");
		String selectString = scanner.nextLine();
		try {
			resultSet = statement.executeQuery(selectString);
			System.out.println("retrived successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public Statement particularDataRange(PreparedStatement preparedStatement) throws SQLException{
		
		String jdbcURL = "jdbc:mysql://localhost:3306/bridgelabzDemo?useSSL=false";
		String userName = "root";
		String password = "Santhu@123";
		System.out.println("connecting to database : " + jdbcURL);
		try {
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is successfull " + connection);
			String Query=("Select * from employee_payroll where StartDate between Cast('2019-02-03' as date) and date(now())");
			preparedStatement = connection.prepareStatement(Query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	public void printRetrivedData(ResultSet resultSet) throws PatternMatchException {
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

			throw new PatternMatchException("Pattern is Mismatched -The database should be checked ");
		}
		System.out.println(list);
	}
}
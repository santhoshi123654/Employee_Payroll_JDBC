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
	public void employeesData() {

		try {
			preparedStatement = connection.prepareStatement("select EmpName from employee_payroll where startdate between "
					+ "cast('2019-02-03' as date) and date(now());");
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("EmpName");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			preparedStatement.close();
			connection.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void totalSalary() throws SQLException {
		System.out.println("1.sum\n2.avg\n3.count\n4.min\n5.max");
		Scanner sc = new Scanner(System.in);
		
		String query = "";
		int input = sc.nextInt();
		switch (input) {
		case 1:
			query = "SELECT sum(BasicPay)";
			break;
		case 2:
			query = "SELECT avg(BasicPay)";
			break;
		case 3:
			query = "SELECT count(*)";
			break;
		case 4:
			query = "SELECT min(BasicPay)";
			break;
		case 5:
			query = "SELECT max(BasicPay)";
			break;

		}
		String mysqlQuery = query + " FROM employee_payroll;";

		try {
			preparedStatement=connection.prepareStatement(""+mysqlQuery+"");
			resultSet = preparedStatement.executeQuery();
			System.out.println(mysqlQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while (resultSet.next()) {
			System.out.println(resultSet.getDouble(1));
		}
	}
}
package com.bridgelabz.Employee_Payroll_JDBC;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Employee_Payroll_Main {
	
	private static final int Num =5;
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Employee_Payroll_Service employeePayRollService = new Employee_Payroll_Service();
		Statement statement = null;
		ResultSet resultSet = null;
		int exit=0;
		Scanner scanner = new Scanner(System.in);
		while (Num != exit) {
			System.out.println("enter \n1.To create Connection \n2.To Retrive Data "
					+ "\n3.To Update Data \n4.Print Retrived Data \n"+Num+".to exit");
			int Number = scanner.nextInt();
			
			switch (Number) {
			case 1:
				statement = employeePayRollService.getConnection();
				break;
			case 2:
				resultSet = employeePayRollService.retrieveData(statement);
				break;
			case 3:
				employeePayRollService.updateData(statement);
				break;
			case 4:
				try {
					employeePayRollService.printRetrivedData(resultSet);
				} catch (PatternMatchException e) {
					e.printStackTrace();
				}
				break;
			case Num:
				exit=Num;
				break;
			default:
				System.out.println("Selection is Invalid");
				break;
			}
		}
	}
}

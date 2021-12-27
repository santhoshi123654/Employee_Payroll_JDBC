package com.bridgelabz.Employee_Payroll_JDBC;

public class EmployeePayroll {
	
	private int EmpId;
	private String EmpName;
	private long Phone_Number;
	private String Address;
	private String Department;
	private String gender;
	private double BasicPay;
	private String Deduction;
	private String TaxablePay;
	private String IncomeTax;
	private String NetPay;
	private java.sql.Date StartDate;
	
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public long getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(long phone_Number) {
		Phone_Number = phone_Number;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getBasicPay() {
		return BasicPay;
	}
	public void setBasicPay(double basicPay) {
		BasicPay = basicPay;
	}
	public String getDeduction() {
		return Deduction;
	}
	public void setDeduction(String deduction) {
		Deduction = deduction;
	}
	public String getTaxablePay() {
		return TaxablePay;
	}
	public void setTaxablePay(String taxablePay) {
		TaxablePay = taxablePay;
	}
	public String getIncomeTax() {
		return IncomeTax;
	}
	public void setIncomeTax(String incomeTax) {
		IncomeTax = incomeTax;
	}
	public String getNetPay() {
		return NetPay;
	}
	public void setNetPay(String netPay) {
		NetPay = netPay;
	}
	public java.sql.Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(java.sql.Date startDate) {
		StartDate = startDate;
	}
	@Override
	public String toString() {
		return "EmployeePayroll [EmpId=" + EmpId + ", EmpName=" + EmpName + ", Phone_Number=" + Phone_Number
				+ ", Address=" + Address + ", Department=" + Department + ", gender=" + gender + ", BasicPay="
				+ BasicPay + ", Deduction=" + Deduction + ", TaxablePay=" + TaxablePay + ", IncomeTax=" + IncomeTax
				+ ", NetPay=" + NetPay + ", StartDate=" + StartDate + "]";
	}
	
	
}

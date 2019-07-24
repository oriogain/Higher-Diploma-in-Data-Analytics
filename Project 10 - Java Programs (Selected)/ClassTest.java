/*
Author: Sean O'Riogain (18145426)
Date: 14/09/2018

Description: Define a class called Employee.

*/

public class ClassTest
{
	private int empNo;
	private String empFirstName;
	private String empLastName;
	private double annualSalary;
	private char taxClass;
	private double taxCutOff;
	private double taxCredit;
	private String prsiClass;
	
	public ClassTest(int num, String nam1, String nam2, double sal, char taxC, double taxCO, double taxCr, String prsiC)
	{
		empNo = num;
		empFirstName = nam1;
		empLastName = nam2;
		annualSalary = sal;
		taxClass = taxC;
		taxCutOff = taxCO;
		taxCredit = taxCr;
		prsiClass = prsiC;
	}
	
	public double calcMonthlyGross()
	{
		return(annualSalary/12);
	}

}
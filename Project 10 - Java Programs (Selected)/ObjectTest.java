/*
Author: Sean O'Riogain (18145426)
Date: 14/09/2018

Description: Define a class called Employee.

*/

public class ObjectTest
{
	public static void main(String args[])
	{
		ClassTest myObject = new ClassTest(1234, "Sean", "Murphy", 48000, 'S', 76.52, 152.06, "A1");
		
		System.out.println("The employee's monthly gross salary is " + myObject.calcMonthlyGross());
	}

}
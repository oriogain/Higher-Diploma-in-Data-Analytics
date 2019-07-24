/*
Author: Sean O'Riogain (18145426)
Date: 12/09/2018

Description: Display the product of two integer numbers passed in from the command line

*/


public class MethodTest
{
public static void main(String args[])
{
	int num1 = Integer.parseInt(args[0]);	// Declare and accept 2 integer numbers from the command line
	int num2 = Integer.parseInt(args[1]);
	
	System.out.println(num1 + " multiplied by " + num2 + " is " + mulTwoNumbers(num1, num2));
}

public static int mulTwoNumbers(int x, int y)
{
	return (x * y);
}

}
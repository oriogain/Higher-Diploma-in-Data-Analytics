/*
Author: Sean O'Riogain
Date: 17/09/2018

Program: Euler1
Description: Solve the Problem 1 on the projecteuler.net website by providing the sum of the multiples of 3 or 5 for the command-line-specified number (e.g. 1000)

*/

public class Euler1
{
	public static void main(String args[])
	{
		int num = Integer.parseInt(args[0]);
		
		int total = 0;		// Declare a variable for summing
		
		int i = 0; 			// Initialise a loop index
		
		for(i = 1; i < num; i++)
		{
			if(i%3 == 0 || i%5 == 0)
			{
				total += i;
			}
		}
		
		System.out.println("The sum of the multiples of " + num + " is " + total);
	}
	
}
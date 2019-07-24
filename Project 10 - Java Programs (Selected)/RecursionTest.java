/**
 * This program calculates and displays the result of raising a number (parameter 1) to a power (parameter 1) power, and the first 10 positive integers to the power 1, 2 and 3 using a recursive method	
 * 
 * @author Sean O'Riogain 
 * @author 18145426
 * @version 20/09/2018
 */

public class RecursionTest
{
	public static void main(String args[])
	{
		int num1 = Integer.parseInt(args[0]);			// Accept 2 integer parameter values from the command line
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println(num1 + " to the power of " + num2 + " = " + toPowerOf(num1, num2));	// Display the results of the method invocation
		
		int [][] results = new int[10][3];				// Create an array to store the results of the following loop
		
		int total = 0;									// Declare a variable for summing the contents of the array
		
		for(int i = 1; i <= 3; i++)						// Loop through the power values from 1 to 3
		{
			System.out.println("\n");					// Display a blank line
			
			for(int j = 1; j <= 10; j++)				// Loop though the integers from 1 to 10
			{
				results[j - 1][i - 1] = toPowerOf(j, i);	// Store the results of the method invocation
				
				System.out.println(j + " to the power of " + i + " = " + results[j - 1][i - 1]); // Display the results of the current method invocation
				
				total += results[j - 1][i - 1];			// Accumulate the sum of the array element values
			}
		}
		
		System.out.println("\nThe sum of the above results is " + total);	// Display the sum of the array element values
	}
	
/**
 * This method uses recursion to raise a specified integer number to the specified (integer) power> the result is returned as an integer number
 *	
 * @param x is the integer number 
 * @param y is the integr power value
 */
	
	public static int toPowerOf(int x, int y)			// Calculate x to the power of y
	{
		if (y <= 1)										// This is the base case
			return (x);
		else
			return (x * toPowerOf(x, y - 1));			// This is the recursive operation
	}
	
}
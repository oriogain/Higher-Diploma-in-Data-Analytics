/**
 * This program solves Problem 2 on the projecteuler.net website by providing the sum of the even elements in the Fibonacci sequence up to command-line-specified limit (e.g. 4,000,000).
 *
 * @author Sean O'Riogain 
 * @author 18145426
 * @version 18/09/2018
 */

public class Euler2
{
	public static void main(String args[])
	{
		int num = Integer.parseInt(args[0]);
		
		int total = 0;		// Declare a variable for summing
		
		int f = 1; 			// Initialise a variable to store the current value in the sequence
		
		int [] fs = {1, 0};	// Initialise an array to store the previous 2 values in the sequence
		
		int i = 1; 			// Initialise a loop index
					
		do					// Loop through the natural numbers up to the specified limit
		{
			if(f%2 == 0)			// If the sequence entry number is even
			{
				total += f;			// Accumulate its value
			}
			
			System.out.println("i = " + i + "; f = " + f + "; total = " + total);
			
			fs[1] = fs[0]; 			// Update the 2 previous sequence values
			fs[0] = f;
			
			f = fs[0] + fs[1];		// Calculate the next number in the series (element 0 is the most recent; element 1 is the one prior to that)
			
			i++;					// Increment the loop index
			
		} while(f <= num);
		
		System.out.println("The sum of the even Fibonacci numbers up to " + num + " is " + total);
	}
	
}
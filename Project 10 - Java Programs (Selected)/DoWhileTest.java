/*
Author: Sean O'Riogain (18145426)
Date: 14/09/2018

Description: Use a Do-While loop to display the messaage argument the number of times specified by the limit argument

Example call: java DoWhileTest "Mary had a little lamb" 12 (will display 'Mary had a little lamb' 12 times)

*/


public class DoWhileTest
{
	public static void main(String args[])
	{
		String msg = args[0];							// Accept and store the message string from the command line
		int limit = Integer.parseInt(args[1]); 			// Accept and store the looping limit
		
		int i = 1;										// Declare and initialise the loop index
		
		do {											// Perform this loop at least once
			System.out.println(msg + " (" + i + ")");	// Display the message
			i++;										// Increment the loop index
		} while(i <= limit);							// Repeat the requested number of times
		
	}
}
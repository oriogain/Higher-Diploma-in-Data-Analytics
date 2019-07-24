/**
 * This program uses the Ternary operator to set the value of a variable (y) depending on whether the value of another variable (x) is greater than 0 or not
 * 
 * @author Sean O'Riogain 
 * @author 18145426
 * @version 17/09/2018
 */

public class TernaryTest
{
	public static void main(String args[])
	{
		int x = -10;						// Declare and initialise the local variables
		int y = 0;
		
		y = (x > 0) ? 1 : -1;				// This is the test ternary operation
		
		System.out.println("y = " + y);		// Display the result of the ternary operation above
	}

}
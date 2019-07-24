/**
 * This program uses the round method of the Math class to round a randomly-generated number (of the double type, in the range 0 -100, by the Math.random method) to two decimal places
 *
 * @author Sean O'Riogain 
 * @author 18145426
 * @version 17/09/2018
 */

public class RoundTest
{
	public static void main(String args[])
	{
		double num = (double) Math.round((Math.random() * 100) *100) / 100;	// Generate the random number in the range 0 - 100
		
		System.out.println("num = " + num);			// Display the result of the ternary operation above
	}

}
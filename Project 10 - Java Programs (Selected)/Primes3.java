
/*  
Author : Sean O'Riogain
Date: 06/09/2018

Program Description: Display the prime numbers in the specified (on the command line) positive integer range
Name: Primes3





*/

public class Primes3 {

	public static void main (String args[]){
		
		int limit = Integer.parseInt(args[0]);  // Get the upper integer range limit (1 is assumed as the lower limit)
		
		int i;	// Declare the outer & inner loop indexes

		int primeCount = 0;	// Declare and initialise prime number counter
		
		i = 1;	// Initialise the outer loop index
		
		while (i <= limit)
		{
			if(isPrime(i) == true)	// A prime number has been found
			{
				System.out.println(i + " is a prime number.");	// Inform the user
				primeCount = primeCount + 1;
			}
			
			if (i > 2)			// Above, 2 only odd numbers can be a prime number
				i += 2;			// Inspect every other (i.e. odd) number only
			else i++;			// Otherwise , inspect every number (i.e. for numbers 1 and 2)
		}
		
		System.out.print("\n");												// Display a blank line
		System.out.println("Number of prime numbers found: " + primeCount); // Display the count of prime number count

		/******************************************************************************/
		
	} // End of main method.

	
	public static boolean isPrime(int num)
	{
		int j;						// Declare the loop index
		
		boolean isPrime = true; 	// Initialise prime flag (set on)
				
		// System.out.println("Break Point 1 - in outer loop - i = " + i);
					
		if (num > 2)
		{
			j = 2;			// Initialise the inner loop index
			
			while (j > 1 && j <= Math.sqrt(num))
			{
				// System.out.println("Break Point 2 - in inner loop - i = " + i  + " - j = " + j);
				
				if (num%j == 0)	// If i is evenly divisible by j
				{
					isPrime = false;	// Set prime flag off
					
					// System.out.println("Break Point 3 - breaking out of inner loop inner loop - i = " + i + " - j = " + j);
					
					break;				// Exit the inner loop
				}
				
				j++;			// Increment the loop index
			}
		}
		
		return(isPrime);
	}

}  // End of the Primes2 class
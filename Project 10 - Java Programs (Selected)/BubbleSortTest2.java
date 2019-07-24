/**
 * This program calculates and displays the result of raising a number (parameter 1) to a power (parameter 1) power, and the first 10 positive integers to the power 1, 2 and 3 using a recursive method	
 * 
 * @author Sean O'Riogain 
 * @author 18145426
 * @version 22/09/2018
 */

import java.util.Arrays;
 
public class BubbleSortTest2
{
	public static void main(String args[])
	{		
		int [] bubbles = new int[20];												// Create the array for sorting
		
		for(int i = 0; i < bubbles.length; i++)										// Load the array with random numbers in the range 0 to 100
		{
			bubbles[i] = (int) (Math.random() * 100);								// Generate and store a random integer number
		}

// For testing pusposes, comment out the preceding array declaration and loading (with random numbers) and uncomment one of the 2 next statements (to replace it). 
		
//DEBUG int [] bubbles = {24, 4, 13, 15, 73, 42, 22, 25, 7, 10, 9, 76, 52, 47};		// Load the array with a constant set of values
//DEBUG	int [] bubbles = {24, 4, 13, 15, 52, 42, 22, 25, 7, 10, 9, 47, 73, 76};		// Load the array with a constant set of values

		int [] counts = {0, 0, (bubbles.length - 1)};	// Counts array ([0] = Call Count; [1] = Loop Count; [2] = Upper limit element index for sort pass)
		
		displayArray(bubbles, "bubbles", "BEFORE bubble sort: ");					// Display the contents of the array before the bubble sort
			
		counts = bubbleSort(bubbles, counts);										// Perform the bubble sort
		
		displayArray(bubbles, "bubbles", " AFTER bubble sort: ");					// Display the contents of the array after the bubble sort
		
		System.out.println("\nCall Count = " + counts[0] + "; Loop Count = " + counts[1]);	// Display the call and loop counts for the current sort
	}

	public static void displayArray(int [] myArray, String name, String loc)		// Display the contents of the specified 1D integer array
	{
		if(loc.startsWith(" AFTER")) System.out.print("\n");						// Display a blank line before the ' AFTER' contents.
		
		System.out.println(loc + name + " = " + Arrays.toString(myArray));			// Display the contents of the array
		
		if(loc.startsWith("BEFORE")) System.out.print("\n");						// Display a blank line after the "BEFORE" contents
	}
		
/**
 * This method uses recursion to perform a bubble sort on the specified (1D, integer) array
 *	
 * @param x is the reference to the (1D, integer) array
 * @param y is the array of counts (call and loop) whose updated values are to be returned to method call location
 */
	
	public static int [] bubbleSort(int [] myArray, int [] myCounts)				// Perform a bubble sort (recursively)
	{
		int temp = 0;																// Declare a temporary variable for use during array element swap
		
		int swapCount = 0;															// Declare a counter for array element swapping
				
		getLoopLimit(myArray, myCounts);											// Get the upper limit (phyical element number) for array element swapping

//DEBUG	System.out.println("Call Count = " + myCounts[0] + "; Loop Count = " + myCounts[1] + "; Limit = " + myCounts[2]);
		
		int limit = myCounts[2];													// Set the upper limit
			
		if(limit == 0)																// This a base case (recursion completed)
			return myCounts;
		
		for(int i = 1; i <= limit; i++)												// Loop to the array as far as the upper-limit element
		{
			if(myArray[i] < myArray[i-1])											// If the current element value is less that the previous one, swap their values
			{
				temp = myArray[i-1];												// Perform the value swap
				myArray[i-1] = myArray[i];
				myArray[i] = temp;
				swapCount++;														// Increment the swapp count
			}
			
			myCounts[1]++;															// Increment the loop count
			
//DEBUG		displayArray(myArray, "myArray", "DURING bubble sort: ");
		}
		
		myCounts[0]++; 																// Increment the (bubbleSort method) call count
		
		if (swapCount > 0)															// The opposite of this condition is another base case
			myCounts = bubbleSort(myArray, myCounts);								// This is the recursive operation
			
		return myCounts;															// Return (and preserve) the key count values
	}
	
	public static void getLoopLimit(int [] myArray, int [] myCounts)				// Set the upper limit for array element swapping
	{
		for(int i = myCounts[2]; i > 0; i--) 										// Loop back through the array from the previous limit until the new limit is found
		{
			if(isLastMax(myArray, i, 0))											// If the current value is greater than its predecessors...
				myCounts[2] = i - 1;												// ...move the limit element for sorting back one position  
			else																	// Otherwise...
				break;																//...use the current element number as the limit																
		}
	}
	
	public static boolean isLastMax(int [] myArray, int last, int first)			// Check if the current (last) element in the array is lesd than all
	{																				//   all of its predecessors as far as the specified (first) element
		for(int i = last; i > first; i--)
		{
			if(myArray[last] < myArray[i - 1])										// If a predecessor with a smaller value is found, return the false value
				return false;
		}
			
		return true;																// Otherwise (no smaller predecessor value found), return the true value
	}	
}
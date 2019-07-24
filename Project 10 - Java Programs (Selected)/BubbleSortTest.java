/**
 * This program calculates and displays the result of raising a number (parameter 1) to a power (parameter 1) power, and the first 10 positive integers to the power 1, 2 and 3 using a recursive method	
 * 
 * @author Sean O'Riogain 
 * @author 18145426
 * @version 20/09/2018
 */

import java.util.Arrays;
 
public class BubbleSortTest
{
	public static void main(String args[])
	{	
		int [] bubbles = new int[20];					// Create the array for sorting
		
		for(int i = 0; i < bubbles.length; i++)			// Load the array with random numbers in the range 0 to 100
		{
			bubbles[i] = (int) (Math.random() * 100);
		}
		
		displayArray(bubbles, "bubbles", "BEFORE bubble sort: "); 
		
		bubbleSort(bubbles);
		
		displayArray(bubbles, "bubbles", " AFTER bubble sort: ");
	}
	
	public static void displayArray(int [] myArray, String name, String loc)
	{
		System.out.println(loc + name + " = " + Arrays.toString(myArray));
	}
		
/**
 * This method uses recursion to raise a specified integer number to the specified (integer) power> the result is returned as an integer number
 *	
 * @param x is the integer number 
 * @param y is the integr power value
 */
	
	public static void bubbleSort(int [] myArray)		// Calculate x to the power of y
	{
		int temp = 0;
		
		int swapCount = 0;
		
		for(int i = 1; i < myArray.length; i++)
		{
			if(myArray[i] < myArray[i-1])
			{
				temp = myArray[i-1];
				myArray[i-1] = myArray[i];
				myArray[i] = temp;
				swapCount++;
			}
		}
		
		if (swapCount > 0)							// This is the base case
			bubbleSort(myArray);					// This is the recursive operation
	}
	
}
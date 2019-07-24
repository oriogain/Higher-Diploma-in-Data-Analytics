/*
Author: Sean O'Riogain (18145426)
Date: 14/09/2018

Description: Creates a 2D integer array, loads it with data, displays its contents, sets the value of all of its elements to a single value, displays its contents, 
                checks if it contains a specified value (displaying a match or no-match message, accordingly), and displays the total value of its contents.

*/


public class ArrayTest2D
{
	public static void main(String args[])
	{
		int[][] myValues= { {23,38,14,7},		// Declare a 2-dimensional array and load it with data
                    {-3, 0,14,4},
                    { 9, 13,0,3}, 
                  };		
		
		displayArray(myValues, "Before change2D", "myValue");	// Display the contents of the array
		
		change2D(myValues);										// Set the value of all array elements to 42
		
		displayArray(myValues, "After change2D ", "myValue");	// Display the contents of the array
		
		change2DValue(myValues, 88);							// Set the value of all array elements to the specified value (88)
		
		displayArray(myValues, "After change2DValue", "myValue");	// Display the contents of the array
		
		int checkValue = 88;									
		
		if(check2DValue(myValues, checkValue))					// Check if any of the array elements contain the specified number
			System.out.println("\nmyValue[][] DOES contain the value " + checkValue);		// Display a 'match' message
		else
			System.out.println("\nmyValue[][] DOES NOT contain the value " + checkValue);	// Display a 'no match' message
		
		System.out.println("\nThe sum of of the values of all elements of myValues is " + sum2DArray(myValues)); // Display the total value of array contents
	}
	
	public static void displayArray(int[][] myArray, String loc, String name)
	{
		System.out.print("\n");										// Display a blank line
		
		for(int row = 0; row < myArray.length; row++)				// Loop through the rows of the array
		{
			for(int col = 0; col < myArray[0].length; col++)		// Loop through the columns of the array
			{
				System.out.println(loc + ": " + name + "[" + row + "][" + col + "] = " + myArray[row][col]); // Display the contents of the array
			}
		}
	}
	
	public static void change2D(int[][] myArray)
	{
		for(int row = 0; row < myArray.length; row++)				// Loop through the rows of the array
		{
			for(int col = 0; col < myArray[0].length; col++)		// Loop through the columns of the array
			{
				myArray[row][col] = 42;								// Set the value of the current array element to 42			
			}
		}
	}

	public static void change2DValue(int[][] myArray, int value)
	{
		for(int row = 0; row < myArray.length; row++)				// Loop through the rows of the array
		{
			for(int col = 0; col < myArray[0].length; col++)		// Loop through the columns of the array
			{
				myArray[row][col] = value;							// Set the value of the current array element to the specified value			
			}
		}
	}
	
	public static boolean check2DValue(int[][] myArray, int value)
	{
		boolean found = false;										// Declare and initialise the check flag
		
		for(int row = 0; row < myArray.length; row++)				// Loop through the rows of the array
		{
			for(int col = 0; col < myArray[0].length; col++)		// Loop through the columns of the array
			{
				if(myArray[row][col] == value)						// Check the current array element for a value match
				{
					found = true;									// Set the found flag one
					break;											// Exit the inner (column) loop
				}
			}
		
			if(found)												// If a match was found, exit the oute (row) loop
					break;
		}
		
		return found;
	}

	public static int sum2DArray(int[][] myArray)
	{
		int total = 0;												// Declare and initialise the variable used for summing
		
		for(int row = 0; row < myArray.length; row++)				// Loop through the rows of the array
		{
			for(int col = 0; col < myArray[0].length; col++)		// Loop through the columns of the array
			{
				total += myArray[row][col];					// Increment the total by the value of the current array element			
			}
		}
		
		return total;
	}
	
}
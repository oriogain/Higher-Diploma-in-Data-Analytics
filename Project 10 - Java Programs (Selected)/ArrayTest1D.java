/*
Author: Sean O'Riogain (18145426)
Date: 12/09/2018

Description: Creates two 1-D integer arrays, initialises the first one with data, copies its contents to the second array, and displays the contents of both arrays both before and after the copy

*/


public class ArrayTest1D
{
	public static void main(String args[])
	{
		int [] arr1 = {2, 5, 23, -7, 12};		// Declare 2 integer arrays and load the first one
		int [] arr2 = new int[arr1.length];
		
		displayArrays(arr1, arr2, "BEFORE: ", "arr1", "arr2");	// Display the 'before' contents of both arrays
		
		for(int i = 0; i < arr1.length; i++)	// Loop through the elements of both arrays
		{
			arr2[i] = arr1[i];					// Load an element of array arr2 with the contents of the equivalent element in array arr1
		}
		
		displayArrays(arr1, arr2, "AFTER:  ", "arr1", "arr2");	// Display the 'before' contents of both arrays
	}
	
	public static void displayArrays(int [] list1, int [] list2, String loc, String nam1, String nam2)
	{
		System.out.print("\n");					// Display a blank line
		
		for(int i = 0; i < list1.length; i++)	// Loop through the elements of both arrays (assumes both arrays are of equal length)
		{
			System.out.println(loc + nam1 + "[" + i + "] = " + list1[i] + "\t" + nam2 + "[" + i + "] = " + list2[i]); // Display the contents of the corresponding element of both arrays
		}
	}

}
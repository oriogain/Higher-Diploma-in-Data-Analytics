/*
Author: Sean O'Riogain (18145426)
Date: 14/09/2018

Description: Use a Do-While loop to display the messaage argument the number of times specified by the limit argument

Example call: java DoWhileTest "Mary had a little lamb" 12 (will display 'Mary had a little lamb' 12 times)

*/

import java.util.Scanner;

public class DoWhileTest2
{
	public static void main(String args[])
	{
		Scanner myScan = new Scanner(System.in);		// Instantiate the myScan object of the Scanner class
		
		int num = 0;
						
		do {											// Perform this loop at least once
			System.out.println("Please enter an integer number (or -1 to quit):");	// Prompt for input
			num = myScan.nextInt();						// Accept and store an integer number from the keyboard
			
			System.out.println("The entered number is:" + num + "\n");	// Display the entered number
		} while(num != -1);								// Repeat until -1 is entered
		
		System.out.println("Goodbye!");
	}
}
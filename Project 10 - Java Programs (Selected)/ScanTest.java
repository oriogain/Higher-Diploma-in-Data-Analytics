import java.util.Scanner;

public class ScanTest
{
public static void main(String args[])
{
	Scanner myScan = new Scanner(System.in);	// Instantiate a Scanner object (called myScan);
	
	System.out.println("Please enter an integer number: ");	// Prompt for the entry of an integer
	int num = myScan.nextInt();								// Get and store the entered integer
	
	System.out.println("The entered integer value is: " + num);
}

}
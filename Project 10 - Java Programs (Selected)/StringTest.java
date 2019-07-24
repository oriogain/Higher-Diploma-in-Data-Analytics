public class StringTest
{
public static void main(String args[])
{
	String str = args[0];	// Declare and accept the(string) argument/parameter from the command line
	
	System.out.println("This is the passed string: " + "\"" + str + "\"");
	
	System.out.println("The length of that string is " + str.length());
	
	System.out.println("This is the string's 3rd character: " + str.substring(2, 3));
}

}
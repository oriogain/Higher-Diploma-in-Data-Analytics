import java.util.Arrays;

public class StringMethodTest
{
	public static void main(String args[])
	{
		String str = args[0];	// Declare and accept the(string) argument/parameter from the command line
		
		System.out.println("\nThis is the passed string: " + "\"" + str + "\"");
		
		System.out.println("\nThe length of that string is: " + str.length());
		
		System.out.println("\nThe position of the (first) character y is: " + ((int) str.indexOf('y') + 1));
		
		System.out.println("\nThis is the string's 3rd character: " + str.charAt(2));
		
		System.out.println("\nThis is the string's 3rd and 4th characters: " + str.substring(2, 4));
		
		System.out.println("\nThis is the string from the third character onwards: " + str.substring(2));
		
		System.out.println("\nThis is the string in lower case: " + str.toLowerCase());
		
		System.out.println("\nThis is the string in upper case: " + str.toUpperCase());
		
		System.out.println("\nThis is the string with all a's replaced with X's: " + str.replace('a', 'X'));
			
		System.out.println("\nThis is the string split up using the character: " + Arrays.toString(str.split("a")));
		
		System.out.println("\nThis is the string split up using white space: " + Arrays.toString(str.split("\\s")));
	}

}
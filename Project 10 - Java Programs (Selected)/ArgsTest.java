public class ArgsTest
{
public static void main(String args[])
{
	String arg1 = args[0];	// Declare and accept the first (string) argument/parameter from the command line
	int arg2 = Integer.parseInt(args[1]);		// Do the same for the second (integer) argument
	double arg3 = Double.parseDouble(args[2]);	// Do the same for the third (double) argument
	
	System.out.println("arg1 = " + arg1 + "; arg2 = " + arg2 + "; arg3 = " + arg3);
}

}
import java.util.InputMismatchException;			
import java.util.Scanner;


/*
=============================================================================================================================

 	Data Structures 	
	Submission: Aaron Dykes
	
=============================================================================================================================
*/
/**

	Lab3BinarySearchTest = driver for 
	BinarySearch class.
	
	@author aarondykes
*/

public class Lab3BinarySearchTest {
	
	
/**
	main = driver for 
	BinarySearch class.
	
	@param args = arguments.
*/
	public static void main( String[] args ) {

		
		String integerPrompt = "Enter an integer value to be searched: ";
		Scanner input = new Scanner( System.in );
		boolean goodInput = true;
		
		BinarySearch search = new BinarySearch();
		
		int[] data = new int[20];
		int key = 0;
		
		
		while ( goodInput ) {
			
			try {
				printMenu();
				int option = input.nextInt();
				
				switch ( option ) {
				
					case 1: search.generateRandomIntegers( data,
									       0,
									       data.length - 1 );
						break;
					case 2: System.out.print( integerPrompt );
						key = input.nextInt();
						input.nextLine();
						search.recursiveBinarySearch( data, 
									      0, 
									      data.length - 1, 
									      key );
						break;
					case 3: System.out.print( integerPrompt );
						key = input.nextInt();
						input.nextLine();
						search.nonRecursiveBinarySearch( data, 
										 key );
						break;
					case 4: goodInput = false;
						System.out.println("System exiting.");
						break;
				
					default: System.out.printf( "%n%s%n%s%n",
								    "Sorry, that's an invalid input.",
								    "Please try again." );
				}
			} 
			catch( InputMismatchException ime ) {
			       System.out.printf( "%n%s%n%s%n",
						  "Sorry, that's an invalid data type.",
						  "Please try again." );
			       input.nextLine();
			}
		} input.close();
	}
	
	private static void printMenu() {
		System.out.printf( "%n%n%s%n%s%n%s%n%s%n%s",
				   "1. Initialize and populate an array of 20 random integers.",
				   "2. Perform a recursive binary search.",
				   "3. Perform a non-recursive binary search.",
				   "4. Exit.",
				   "Select your option in the menu below: ");
	}
}
/*
=============================================================================================================================

 	Data Structures 	
	Submission: Aaron Dykes
	
=============================================================================================================================
*/


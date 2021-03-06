
/**
 * Time Calculation I
Write a program (TimeCalc1) that reads three integers representing a time duration in hours, minutes, and seconds, and prints the equivalent time duration in seconds. Here is a typical run- time example of this program (the user's input is underlined; everything else is generated by the program):
Enter hours: 2
Enter minutes: 28
Enter seconds: 42
This time duration lasts 8922 seconds.
 */


import java.util.Scanner;

public class TimeCalc1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// Get the user's input
		System.out.print("Enter hours: ");
		int hours = scan.nextInt();
		System.out.print("Enter minutes: ");
		int minutes = scan.nextInt();
		System.out.print("Enter seconds: ");
		int seconds = scan.nextInt();
		int sumInSeconds = hours * 60 * 60 + minutes * 60 + seconds;
		System.out.println("This time duration lasts " + sumInSeconds +  " seconds.");
		
		scan.close();
	}
}
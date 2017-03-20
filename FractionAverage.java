/**
Fractions Average
Write a program (FractionAverage) that reads three pairs of numbers,
treats them as fractions, and prints their average, as a fraction.
Here is a sample run:
Enter a numerator: 1
Enter a denominator: 2
Enter a numerator: 3
Enter a denominator: 4
Enter a numerator: 2
Enter a denominator: 3
The average of 1/2, 3/4, and 2/3 is 23/36
Your program will make use of the services of the supplied Fraction class.
 * 
 * 
 */


import java.util.Scanner;

public class FractionAverage {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a numerator:");
		int n1 = scan.nextInt();
		System.out.print("Enter a denominator:");
		int d1 = scan.nextInt();
		System.out.print("Enter a numerator:");
		int n2 = scan.nextInt();
		System.out.print("Enter a denominator:");
		int d2 = scan.nextInt();
		System.out.print("Enter a numerator:");
		int n3 = scan.nextInt();
		System.out.print("Enter a denominator:");
		int d3 = scan.nextInt();
		Fraction f1 = new Fraction(n1,d1);
		Fraction f2 = new Fraction(n2,d2);
		Fraction f3 = new Fraction(n3,d3);
		Fraction f4 = new Fraction(3, 1);
		Fraction f5 = f1.add(f2.add(f3)).divide(f4);		
		System.out.println("Mult is: " + f5);
		scan.close();
	}

}


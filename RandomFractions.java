/**
 Random Fractions
Write a program (RandomFractions) that generates two random numbers x and y.
Next, the program constructs two Fraction objects representing x/y and y/x.
Next, the program computes the product x/y * y/x, and prints the result.
If everything works properly, the result should be 1. Here is the output
of a sample run:
(32667373/756) times (756/32667373) equals 1
 */


import java.util.Random;
public class RandomFractions {

	public static void main(String[] args) {
		Random rndGenerator = new Random();
		int x = rndGenerator.nextInt();
		int y = rndGenerator.nextInt();
		Fraction f1 = new Fraction(x,y);
		Fraction f2 = new Fraction(y,x);
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		Fraction mult = f1.multiply(f2);
		System.out.println("mult is " + mult);
	}
}

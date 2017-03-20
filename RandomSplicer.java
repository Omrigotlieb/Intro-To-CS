/**
 * Random String Splicer
Write a program (RandomSplicer) that reads a string of characters.
The program picks one character at random from the given string,
and then inserts after all the occurrences of this character throughout
the string a newline character. Next, the program prints the chosen letter 
and the new string. Here are two run-time examples of this program:
Enter a string: I THINK THEREFORE I EXIST Splicing letter: E
I THINK THE
RE
FORE IE XIST
      Enter a string: BARACK OBAMA
      Splicing letter: A
      BA
      RA
CK OBA MA
Assume that the input is a string consisting of one or more upper-case characters.
Your program must generate the required output using a single printing command.
 The trick is to build a string that includes all the necessary newline characters
  in the right places, and then print the string "in one shot".
Hints: (i) a system independent line separator can be obtained by calling the static 
method System.lineSeparator(). This method returns a string that contains the newline 
character of the host platform (Mac, Windows, Unix, and so on). 
 You may also want to consult the API of the String class.
 * 
 */



import java.util.Scanner;
import java.util.Random;

public class RandomSplicer {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		Random rnd = new Random();
		String ls = System.lineSeparator();
		System.out.println("Enter text");
		String text = scan.nextLine();
		int len = text.length();
		int rndNum = rnd.nextInt(len);
		String seperator = "" + text.charAt(rndNum);
		String sOut = (text.replaceAll(seperator, seperator + ls));
		System.out.println(sOut);
		scan.close();
	}
}
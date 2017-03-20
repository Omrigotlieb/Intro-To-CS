import java.util.Scanner;

public class ScannerTests {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		System.out.print("Enter your name: ");
//		String name = scan.nextLine();
//		System.out.print("Enter your age: ");
//		int age = scan.nextInt();
//		System.out.print("Enter your GPA: ");
//		double gpa = scan.nextDouble();
//		System.out.println("Your name is " + name + ". You are " + age + " and your GPA is " + gpa);
//	
		
		String text = "    1 2 red     blue";
		Scanner s = new Scanner(text);
		System.out.println(s.next());
		System.out.println(s.next());
		System.out.println(s.next());
		System.out.println(s.next());
		
		s.close();
		scan.close();
	}

}

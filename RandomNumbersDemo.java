import java.util.Random;
public class RandomNumbersDemo {
	public static void main(String[] args) {
		Random rndGenerator = new Random();
		int num = rndGenerator.nextInt();
		System.out.println("next random is: " + num);
		System.out.println("another random is: " + rndGenerator.nextInt());
	}

}

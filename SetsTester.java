/**
 * A simple tester for Sets class
 */
public class SetsTester {


	/*
	 * NOTE: In case you haven't implemented a certain 'Sets' method, 
	 * comment out the relevant test method in the main below.
	 * For example, if you only implemented the 'exist' method, comment out
	 * all method calls except 'testExists()' ( // testExists(), 
	 * // testUnion(), etc.).  
	 */
	public static void main(String[] args) {
		
		// Perform tests
		testPrintSet();
		testExists();
		testUnion();
		testIntersection();
	}
	
	/*
	 * Tests Sets.intersection(int[], int[]).
	 * 
	 * Expected output:
	 * { 7, 1 } 
	 */
	private static void testIntersection() {
		
		int[] a = new int[] { 5, 2, 1, 7 };
		int[] b = new int[] { 7, 3, 1 };

		Sets.printSet(Sets.intersection(a, b));		
	}

	/*
	 * Tests Sets.union(int[], int[]).
	 * 
	 * Expected output:
	 * { 5, 2, 1, 7, 3 }
	 */
	private static void testUnion() {

		int[] a = new int[] { 5, 2, 1, 7 };
		int[] b = new int[] { 7, 3, 1, 9, 7 };

		Sets.printSet(Sets.union(a, b));
	}

	/*
	 * Tests Sets.exists(int, int[]).
	 * 
	 * Expected output:
	 * false
	 * true
	 */
	private static void testExists() {

		int[] a = new int[] { 5, 2, 1, 7 };
		int[] b = new int[] { 7, 3, 1 };

		System.out.println(Sets.exists(3, a));
		System.out.println(Sets.exists(3, b));
	}

	/*
	 * Tests Sets.printSet(int[]).
	 * 
	 * Expected output:
	 * { 5, 2, 1, 7 }
	 * {} 
	 */
	private static void testPrintSet() {
		
		int[] s = new int[] { 5, 2, 1, 7 };
		int[] empty = new int[] {};
		
		Sets.printSet(s); 
		Sets.printSet(empty);
	}
}
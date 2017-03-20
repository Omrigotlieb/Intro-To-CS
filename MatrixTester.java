/**
 *  A simple tester for Matrix class
 */
public class MatrixTester {

	public static void main(String[] args) {

		// Perform tests
//		testGetters();
//		testToString();		
//		testEquals();
//		testToArray();
//		testAddition();
//		testScalarMultiplication();
//		testMatricesMultiplication();
//		testSubmatrix();
//		testTranspose();
	}


	/*
	 * Tests Matrix.getRowsNumber() and  Matrix.getColsNumber() 
	 * 
	 * Expected output:
	 * 2
	 * 3
	 */
	private static void testGetters() {

		int[][] arr = new int[][] {
				{ 1, 2, 3 },
				{ 3, 2, 1 }		
		};

		Matrix m = new Matrix(arr);

		System.out.println(m.getRowsNumber());
		System.out.println(m.getColsNumber());
		System.out.println();
	}

	/*
	 * Tests Matrix.toString() 
	 * 
	 * Expected output:
	 * [1, 2, 3]
	 * [3, 2, 1]
	 */
	private static void testToString() {

		int[][] arr = new int[][] {
				{ 1, 2, 3 },
				{ 3, 2, 1 }		
		};

		Matrix m = new Matrix(arr);

		System.out.println(m.toString());
		System.out.println("");
	}

	/*
	 * Tests Matrix.equals(Matrix) 
	 * 
	 * Expected output:
	 * true
	 * true
	 * false
	 */
	private static void testEquals() {

		int[][] arr1 = new int[][] {
				{ 1, 2, 3 },
				{ 3, 2, 1 }		
		};

		int[][] arr2 = new int[][] {
				{ 1, 2, 3 },
				{ 3, 2, 1 }		
		};

		int[][] arr3 = new int[][] {
				{ 1, 2, 3 },
				{ 3, 0, 1 }		
		};

		Matrix m1 = new Matrix(arr1);
		Matrix m2 = new Matrix(arr2);
		Matrix m3 = new Matrix(arr3);

		System.out.println(m1.equals(m2));
		System.out.println(m2.equals(m1));
		System.out.println(m1.equals(m3));
		System.out.println();
	}

	/*
	 * Tests Matrix.toArray() 
	 * 
	 * Expected output:
	 * 1 2 3
	 * 3 2 1
	 * true
	 */
	private static void testToArray() {

		int[][] arr = new int[][] {
				{ 1, 2, 3 },
				{ 3, 2, 1 }		
		};

		Matrix m = new Matrix(arr);
		int [][] res = m.toArray();

		// Test dimensions and value equality
		printArray(res);

		// Test encapsulation
		System.out.println(arr != res);
		System.out.println();
	}

	/*
	 * Tests Matrix.add(Matrix) 
	 * 
	 * NOTE: Depends on toArray()
	 * 
	 * Expected output:
	 * true
	 * 2 2 2
	 * 3 3 1
	 */
	private static void testAddition() {
		
		int[][] arr1 = new int[][] {
				{ 1, 2, 3 },
				{ 3, 2, 1 }		
		};

		int[][] arr2 = new int[][] {
				{ 1, 0, -1 },
				{ 0, 1, 0 }		
		};
		
		int[][] arr3 = new int[][] {
				{ 1, 2 },
				{ 3, 4 }
		};

		Matrix m1 = new Matrix(arr1);
		Matrix m2 = new Matrix(arr2);
		Matrix m3 = new Matrix(arr3);
		
		System.out.println(m2.add(m3) == null);
		printArray(m1.add(m2).toArray());
		System.out.println();
	}

	/*
	 * Tests Matrix.multiply(int) 
	 * 
	 * NOTE: Depends on toArray()
	 * 
	 * Expected output:
	 * -2 -4
	 * -6 2
	 * 
	 * 0 0
	 * 0 0
	 */
	private static void testScalarMultiplication() {
		
		int[][] arr = new int[][] {
				{ 1,  2 },
				{ 3, -1 }
		};

		Matrix m = new Matrix(arr);
		
		printArray(m.multiply(-2).toArray());
		System.out.println();
		printArray(m.multiply(0).toArray());
		System.out.println();
	}

	/*
	 * Tests Matrix.multiply(Matrix) 
	 * 
	 * NOTE: Depends on toArray()
	 * 
	 * Expected output:
	 * 0 1
	 * 0 3
	 * 
	 * 3 4
	 * 0 0
	 */
	private static void testMatricesMultiplication() {

		int[][] arr1 = new int[][] {
				{ 1, 2 },
				{ 3, 4 }
		};

		int[][] arr2 = new int[][] {
				{ 0, 1 },
				{ 0, 0 }
		};
	    
		Matrix m1 = new Matrix(arr1);
		Matrix m2 = new Matrix(arr2);
		
		printArray(m1.multiply(m2).toArray());
		System.out.println();
		printArray(m2.multiply(m1).toArray());
		System.out.println();
	}
	
	/*
	 * Tests Matrix.submatrix() 
	 * 
	 * NOTE: Depends on toArray()
	 * 
	 * Expected output:
	 * 1 2
	 * 7 8
	 */
	private static void testSubmatrix() {

		int[][] arr = new int[][] {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};

		Matrix m = new Matrix(arr);
		
		printArray(m.submatrix(1, 2).toArray());
		System.out.println();
	}
	
	/*
	 * Tests Matrix.ranspose() 
	 * 
	 * NOTE: Depends on toArray()
	 * 
	 * Expected output:
	 * 1 5 9
	 * 2 6 10
	 * 3 7 11
	 * 4 8 12
	 */
	private static void testTranspose() {

		int[][] arr = new int[][] {
				{ 1, 2,  3,  4 },
				{ 5, 6,  7,  8 },
				{ 9, 10, 11, 12}
		};

		Matrix m = new Matrix(arr);
		
		printArray(m.transpose().toArray());
		System.out.println();
	}

	/*
	 * Print a string representation of an int[][] to the standard output.
	 */
	private static void printArray(int[][] arr) {

		if (arr == null)
			return;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
			
			System.out.println();
		}
	}
}
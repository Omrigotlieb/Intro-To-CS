/**
 * This class is a library of static methods for set processing.
 */
public class Sets {

    /**
     * Prints a textual representation of the given array to the standard
     * output. <br>
     * <br>
     * The array is represented using the format: "{ e1, e2, e3, . . ., ei, . .
     * ., en }" where the ei's are the array's elements. <br>
     * <br>
     * If the array is empty, it prints "{}".
     * 
     * @param s
     *            a set represented as int[]
     */
    public static void printSet(int[] s) {
	if (s.length == 0) {
	    System.out.println("{}");
	    return;
	}
	System.out.print("{ ");
	for (int i = 0; i < s.length; i++) {
	    System.out.print(s[i]);
	    if (i != s.length - 1) {
		System.out.print(", ");
	    }
	}
	System.out.println(" }");
    }

    /**
     * Returns true if a given element e exists in a given set s (e &isin; s).
     * 
     * @param e
     *            an element
     * @param s
     *            a set
     * @return true if and only if e exists in s
     */
    public static boolean exists(int e, int[] s) {
	boolean exist = false;
	for (int num : s) {
	    if (num == e) {
		exist = true;
		break;
	    }
	}
	return exist;
    }

    /**
     * Returns a new int[] representing the union of a and b (a &cup; b). The
     * length of the returned array is exactly |a &cup; b|.
     * 
     * @param a
     *            a set represented as int[]
     * @param b
     *            a set represented as int[]
     * @return the union of a and b represented as int[]
     */
    public static int[] union(int[] a, int[] b) {
	// Construct temporary array
	int[] temp = new int[a.length + b.length]; 
	
	// Copy a's elements
	System.arraycopy(a, 0, temp, 0, a.length);
	int counter = 0;
	
	// Copy b's elements
	for (int i = 0; i < b.length; i++) {
	    if (!exists(b[i], a)) {
		temp[a.length + counter] = b[i]; 
		counter++;
	    }
	}

	// Construct result array (of reduced length)
	int[] union = new int[a.length + counter];
	System.arraycopy(temp, 0, union, 0, a.length + counter);
	return union;
    }

    /**
     * 
     * Returns a new int[] representing the intersection of a and b (a &cap; b).
     * The length of the returned array is exactly |a &cap; b|.
     * 
     * @param a
     *            a set represented as int[]
     * @param b
     *            a set represented as int[]
     * @return the intersection of a and b represented as int[]
     */
    public static int[] intersection(int[] a, int[] b) {
	// Find which set is longer
	int[] shorter = (a.length > b.length)? b : a;
	int[] longer = (a.length > b.length)? a : b;
	int[] tmp = new int[shorter.length];

	int index = 0;

	// Go through arrays and search for shared elements
	for (int i = 0; i < shorter.length; i++)
		if (exists(shorter[i], longer)) {
			tmp[index] = shorter[i];
			index++;
		}
	// Compose result array
	int[] result = new int[index];
	System.arraycopy(tmp, 0, result, 0, index);
	return result;

    }
}
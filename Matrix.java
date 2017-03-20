/**
 * Represents a matrix as an immutable object.
 */
public class Matrix {

    // Internal representation
    private int[][] data;


    /**
     * Constructs a Matrix from a given int[][] array. 
     * 
     * @param data an array containing the data of the constructed matrix.
     */
    public Matrix(int[][] data) {
	// Copy the matrix into this.data
	this.data = copy2DArray(data);
    }

    private int[][] copy2DArray (int[][] arr){
	int[][] temp = new int[arr.length][arr[0].length];
	for (int i = 0; i < temp.length; i++) {
	    System.arraycopy(arr, 0, temp, 0, temp.length);
	}
	return temp;
    }

    /**
     * Returns the number of rows in this matrix.
     * 
     * @return the number of rows in this matrix.
     */
    public int getRowsNumber() {
	return data.length;
    }

    /**
     * Returns the number of columns in this matrix.
     * 
     * @return the number of columns in this matrix.
     */
    public int getColsNumber() {
	return data[0].length;
    }

    /**
     * Returns an int[][] array containing the data of this matrix.
     * 
     * @return an int[][] array containing the data of this matrix.
     */
    public int[][] toArray() {
	return copy2DArray(data);
    }

    /**
     * Computes the matrix resulting from adding this matrix and the
     * given matrix, according to the rules of linear algebra.
     * <br><br>
     * The two matrices must be addition-compatible, i.e. they must contain
     * the same number of rows and the same number of columns.
     * 
     * @param other the matrix to be added to this matrix.
     * @return a new matrix resulting from the addition of this matrix and
     * the given matrix, or <code>null</code> if the matrices are not 
     * addition-compatible.
     */
    public Matrix add(Matrix other) {
	// Checks if the matrices are addition-compatible
	if (getRowsNumber() != other.getRowsNumber() ||
		getColsNumber() != other.getColsNumber()){
	    return null;
	}

	// adding this matrix and the given matrix
	int[][] resultMatrix = toArray();
	int[][] otherMatrix = other.toArray();
	for (int rows = 0; rows < resultMatrix.length; rows++) {
	    for (int columns = 0; columns < resultMatrix[rows].length; columns++) {
		resultMatrix[rows][columns] += otherMatrix[rows][columns]; 
	    }
	}

	return new Matrix(resultMatrix);
    }

    /**
     * Computes the multiplication of this matrix by the given scalar, 
     * according to the rules of linear algebra.
     * 
     * @param scalar the scalar to multiple this matrix by.
     * @return the new matrix resulting from multiplying this matrix 
     * by the given <code>scalar</code>.
     */
    public Matrix multiply(int scalar) {
	int numOfRows = getRowsNumber();
	int numOfColumns = getColsNumber();
	int[][] result = new int[numOfRows][numOfColumns];
	for (int row = 0; row < numOfRows; row++) {	    
	    for (int column = 0; column < numOfColumns; column++) {
		result[row][column] = data[row][column] * scalar;
	    }
	}
	return new Matrix(result);
    }

    /**
     * Computes the multiplication of this matrix by the given matrix,
     * according to the rules of linear algebra.
     * 
     * <br><br>
     * The two matrices must be product-compatible, i.e. the number of
     * columns of the other matrix must equal the number of rows of this matrix.
     * 
     * @param other the matrix to be multiply by this matrix.
     * @return a new matrix resulting from the multiplication of this matrix
     * and the given matrix, or <code>null</code> if the matrices are not 
     * product-compatible.
     */
    public Matrix multiply(Matrix other) {
	int numOfRows = getRowsNumber();
	int numOfColumns = getColsNumber();
	int numOfOtherColumns = other.getColsNumber();
	int[][] B = other.toArray();
	// New Matrix of A.rows X B.Columns
	int[][] C = new int[numOfRows][numOfOtherColumns];
	
	//Iterate over the Matrix and multiply
	for (int i = 0; i < numOfRows; i++) {
	    for (int j = 0; j < numOfOtherColumns; j++) {
		for (int k = 0; k < numOfColumns; k++) {
		    C[i][j] += data[i][k]*B[k][j];   
		}
	    }
	}
	return new Matrix(C);
    }

    /**
     * Returns a matrix obtained by deleting the specified row and column 
     * from this matrix.
     * <br><br>
     * For example, the matrix on the right is obtained by removing row 2
     * and column 1 from the left matrix:
     * 
     * <p><blockquote><pre>
     * [ 1  2  3  4]     [1 3 4]
     * [ 5  6  7  8] ==> [5 7 8]
     * [ 9 10 11 12]
     * </pre></blockquote><p>
     * <br><br>
     * The specified row and column must be non-negative and no greater than
     * the number of rows and columns, respectively, of this matrix.
     * 
     * @param row a zero-based index of the row to be deleted.
     * @param col a zero-based index of the column to be deleted.
     * @return a new matrix which is the sub-matrix of this matrix, obtained 
     * by deleting the specified row and column, or <code>null</code>
     * if the row or column are non-compatible.
     */
    public Matrix submatrix(int row, int col) {
	int numOfRows = getRowsNumber();
	int numOfColumns = getColsNumber();
	//Construct new array with less column and row
	int[][] arr = new int[numOfRows - 1][numOfColumns - 1];	

	//Iterate over the original Matrix
	// Keep counter of the new row
	int counterRow = 0;
	for (int i = 0; i < numOfRows; i++) {
	    // If the row is the "chosen" one. continue to the next row
	    if(i == row) {
		continue;
	    }
	    // Keep counter of the new column
	    int counterCol = 0;
	    for (int j = 0; j < numOfColumns; j++) {    
		// If the column is the "chosen" one. continue to the next column
		if( j == col) {
		    continue;
		}
		arr[counterRow][counterCol] = data[i][j];
		counterCol++;
	    }
	    counterRow++;
	}	
	return new Matrix(arr);
    }

    /**
     * Computes the transpose of this matrix, according to the rules of 
     * linear algebra.
     * <br><br>
     * The transpose is obtained by "rotating" this matrix. For example,
     * for the right matrix is the transpose of the left one:
     *              
     * <p><blockquote><pre>
     * [ 1  2  3  4]     [1 5  9]
     * [ 5  6  7  8] ==> [2 6 10]
     * [ 9 10 11 12]     [3 7 11]
     *                   [4 8 12]
     * </pre></blockquote><p>
     *                   
     * @return a new matrix which is the transpose of this matrix.
     */
    
    
    public Matrix transpose() {
	int numOfRows = getRowsNumber();
	int numOfColumns = getColsNumber();
	// construct result matrix and switch the Rows and Columns;
	int[][] result = new int[numOfColumns][numOfRows];
	for (int i = 0; i < numOfRows; i++) {
	    for (int j = 0; j < numOfColumns; j++) {
		// Assign the rows to the columns and vice versa   
		result[j][i] = data[i][j];
	    }
	}

	// return the result matrix.
	return new Matrix(result);	
    }

    /**
     * Compares this matrix to the specified matrix. Two matrices are 
     * said to be equal is they have the same dimensions and contain 
     * exactly the same data.
     * 
     * @param other the matrix to compare this matrix to.
     * @return <code>true</code> if this matrix has the same data as 
     * the other matrix, <code>false</code> otherwise.
     */
    public boolean equals(Matrix other) {
	//Get length and compare - if not equal return false.
	int numOfRows = getRowsNumber();
	int numOfColumns = getColsNumber();
	int numOfRowsOther = other.getRowsNumber();
	int numOfColumnsOther = other.getColsNumber();
	if ((numOfRows != numOfRowsOther) ||
		(numOfColumns != numOfColumnsOther)) {
	    return false;
	}
	//Check if equal by loop
	int[][] tempOther = other.toArray();
	for (int row = 0; row < numOfRows; row++) {
	    for (int column = 0; column < numOfColumns; column++) {
		if (data[row][column] != tempOther[row][column]){
		    return false;
		}
	    }
	}
	return true;
    }

    /**
     * Returns a String representation of this matrix.
     * <pre>
     * In the String representation:
     * 1. Every row starts with [
     * 2. Every row ends with ]
     * 3. All rows but the last finish with the newline char 
     * 		(System.lineSeparator())
     * 4. Elements are separated by a comma and a space (", ")
     * 
     * Example:
     * [-1, 0]\n[5, 3]\n[11, -5]
     * </pre>
     * 
     * @return String representation of this matrix.
     */
    public String toString() {
	StringBuilder strB = new StringBuilder(""); 
	int numOfRows = getRowsNumber();
	int numOfColumns = getColsNumber();
	for (int row = 0; row < numOfRows; row++) {
	    strB.append("[");
	    for (int column = 0; column < numOfColumns; column++) {
		if (column != numOfColumns -1) {
		    strB.append(data[row][column] + ", ");
		} else
		    strB.append(data[row][column] + "]\n");
	    }
	}
	return strB.toString();
    }
}
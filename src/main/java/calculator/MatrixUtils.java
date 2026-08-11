package calculator;

/**
 * This class holds methods to be used in the (main) Calculator class.
 * 
 */
public class MatrixUtils {

	/**
	 * Method to swap two rows of a given matrix
	 * 
	 * @param matrix
	 * @param rowX
	 * @param rowY
	 */
	public static void swapRows(Matrix m, int rowX, int rowY) {
		double[] rowA = m.getRow(rowX);
		double[] rowB = m.getRow(rowY);
		m.setRow(rowB, rowX);
		m.setRow(rowA, rowY);
	}

	/**
	 * Method to scale a row of a given matrix
	 * 
	 * @param matrix
	 * @param scalar
	 */
	public static void scaleRow(Matrix m, int row, double scalar) {
		double[] scaledRow = m.getRow(row);
		for (int i = 0; i < m.getRow(row).length; i++) {
			scaledRow[i] *= scalar;
		}
		m.setRow(scaledRow, row);
	}

	/**
	 * Method to add one row to another, can accept scalars
	 * 
	 * @param m         (the Matrix)
	 * @param rowXIndex (Row to be added to)
	 * @param rowYIndex (Row that is added)
	 * @param xScalar   (scalar that gets applied to the x row)
	 * @param yScalar   (scalar that gets applied to the y row)
	 */
	public static void addRows(Matrix m, int rowXIndex, int rowYIndex, double xScalar, double yScalar) {
		double[] rowX = m.getRow(rowXIndex);
		double[] rowY = m.getRow(rowYIndex);

		if (rowX.length != rowY.length) {
			throw new RuntimeException("Rows cannot be of different lengths");
		}

		for (int i = 0; i < rowX.length; i++) {
			rowX[i] = (rowX[i] * xScalar) + (rowY[i] * yScalar);
		}

		m.setRow(rowX, rowXIndex);
	}

	/**
	 * AddRows() helper method, where there is a scalar applied to the xRow
	 * 
	 * @param m
	 * @param rowXIndex
	 * @param xScalar
	 * @param rowYIndex
	 */
	public static void addRowsXScalar(Matrix m, int rowXIndex, int rowYIndex, double xScalar) {
		addRows(m, rowXIndex, rowYIndex, xScalar, 1);
	}

	/**
	 * AddRows() helper method, where there is a scalar applied to the yRow
	 * 
	 * @param m
	 * @param rowXIndex
	 * @param rowYIndex
	 * @param yScalar
	 */
	public static void addRowsYScalar(Matrix m, int rowXIndex, int rowYIndex, double yScalar) {
		addRows(m, rowXIndex, rowYIndex, 1, yScalar);
	}

	/**
	 * Default/Normal Call Overloaded addRows() method, where there is no scalars
	 * applied
	 * 
	 * @param m
	 * @param rowXIndex
	 * @param rowYIndex
	 */
	public static void addRows(Matrix m, int rowXIndex, int rowYIndex) {
		addRows(m, rowXIndex, rowYIndex, 1, 1);
	}

	/**
	 * Method to row reduce a matrix to RREF form
	 * 
	 * @param mat
	 * @return mat (in RREF)
	 */
	public static Matrix rowReduce(Matrix mat) {
		int m = mat.getNumRows();
		int n = mat.getNumCols();
		
		double epsilon = 1e-10;

		int targetRow = 0;

		for (int col = 0; col < n; col++) { // Iterate through all of the columns
			double maxMagnitude = -1;
			int p = targetRow; // 'p' stores the best row, i.e., the best pivot row
			for (int i = targetRow; i < m; i++) { // Search downwards
				if (Math.abs(mat.getMatrix()[i][col]) > maxMagnitude) {
					maxMagnitude = Math.abs(mat.getMatrix()[i][col]);
					p = i;
				}
			}
			if (Math.abs(mat.getMatrix()[p][col]) < epsilon) {
				continue;
			}

			if (p != targetRow) {
				swapRows(mat, p, targetRow);
			}

			double pivotValue = mat.getMatrix()[targetRow][col];
			scaleRow(mat, targetRow, 1.0 / pivotValue);

			for (int row = 0; row < m; row++) {
				if (row != targetRow) {
					double entryToEliminate = mat.getMatrix()[row][col];
					addRowsYScalar(mat, row, targetRow, -entryToEliminate);
				}
			}
			targetRow++;
			if (targetRow >= m) {
				break;
			}

		}

		return mat;
	}

	public static String colVecToString(double[] colVec) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		for (double x : colVec) {
			sb.append("[ ");
			sb.append(x);
			sb.append(" ]\n");
		}
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Prints a given column vector given a column index
	 * 
	 * @param columnIndex
	 */
	public static void printColVec(Matrix m, int columnIndex) {
		if (columnIndex < 0 || columnIndex > m.getNumCols()) {
			throw new RuntimeException("Column index is out of bounds");
		}
		double[] columnArray = m.getColumn(columnIndex);
		String out = colVecToString(columnArray);
		System.out.println(out);
	}

}

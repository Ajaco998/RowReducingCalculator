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
	public static void scaleRow(Matrix m, int row, int scalar) {
		double[] scaledRow = m.getRow(row);
		for (int i = 0; i < m.getRow(row).length; i++) {
			scaledRow[i] *= scalar;
		}
		m.setRow(scaledRow, row);
	}

	/**
	 * Method to add one row to another, can accept scalars
	 * 
	 * @param matrix
	 * @param rowX   (Row to be added to)
	 * @param rowY   (Row that is added)
	 */
	public static void addRows(Matrix m, int rowXIndex, int rowYIndex, int xScalar, int yScalar) {
		double[] rowX = m.getRow(rowXIndex);
		double[] rowY = m.getRow(rowYIndex);

		if (rowX.length != rowY.length) {
			throw new RuntimeException("Rows cannot be of different lengths");
		}

		if (xScalar != 1) {
			for (int i = 0; i < rowX.length; i++) {
				rowX[i] *= xScalar;
			}
		}

		if (yScalar != 1) {
			for (int i = 0; i < rowY.length; i++) {
				rowY[i] *= yScalar;
			}
		}

		for (int i = 0; i < rowX.length; i++) {
			rowX[i] += rowY[i];
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
	public static void addRowsXScalar(Matrix m, int rowXIndex, int rowYIndex, int xScalar) {
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
	public static void addRowsYScalar(Matrix m, int rowXIndex, int rowYIndex, int yScalar) {
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
	 * @param m
	 * @return
	 */
	public static Matrix rowReduce(Matrix m) {
		// TODO: Figure out algorithm for row reduction and implement it
		// Note: Figure out if this should be a void method or return the matrix

		double[][] A = m.getMatrix();

		// Step 1: Determine leftmost non-zero column

		return null;
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

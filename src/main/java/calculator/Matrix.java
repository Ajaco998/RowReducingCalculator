package calculator;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class to represent a matrix type object
 * @author Andrew Jacobson
 */
public class Matrix {

	private int rows; // rows
	private int cols; // columns
	private double[][] matrix;
	
	/**
	 * Default Constructor
	 * @param n
	 * @param m
	 */
	public Matrix(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.matrix = new double[rows][cols];
	}
	
	/*
	 * Constructor to make a matrix object given a 2d array
	 */
	public Matrix(double[][] mat) {
		this.rows = mat.length;
		this.cols = mat[0].length;
		this.matrix = mat;
	}

	public int getNumRows() {
		return rows;
	}

	public int getNumCols() {
		return cols;
	}

	public double[][] getMatrix() {
		return matrix;
	}
	
	/**
	 * Gets the specified row
	 * @param row
	 * @return array representing row
	 */
	public double[] getRow(int row) {
		return this.matrix[row];
	}
	
	public void setRow(double[] rowToBeSet, int rowIndex) {
		if(rowIndex < 0) {
			throw new RuntimeException("Row cannot be negative");
		}
		this.matrix[rowIndex] = rowToBeSet;
	}
	
	/**
	 * Method to set a specified column of the matrix
	 * @param colVec
	 * @param column
	 */
	@SuppressWarnings("unused")
	private void setColumn(double[] colVec, int column) {
		if(column < 0) {
			throw new RuntimeException();
		}
		for(int i = 0; i < this.rows; i++) {
			this.matrix[i][column] = colVec[i];
		}
	}
	/**
	 * Gets the specified column vector
	 * @return Array representing the column
	 */
	public double[] getColumn(int column) {
		double[] colVec = new double[this.rows];
		if(column < 0) {
			throw new RuntimeException();
		}
		for(int i = 0; i < this.rows; i++) {
			colVec[i] = this.matrix[i][column];
		}
		return colVec;
	}

//	@Override
//	public String toString() {
//		String out = "{ \n";
//		for(double[] row : this.matrix) {
//			out += Arrays.toString(row) + "\n";
//		}
//		out += "}";
//		return out;
//	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.rows; i++) {
			sb.append("[ ");
			for(int j = 0; j < this.cols; j++) {
				sb.append(String.format("%7.2f", this.matrix[i][j]));
				
				if(j < this.rows - 1) {
					sb.append(", ");
				}
			}
			sb.append("]\n");
		}
		
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
		result = prime * result + Objects.hash(cols, rows);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		return cols == other.cols && Arrays.deepEquals(matrix, other.matrix) && rows == other.rows;
	}
	
	public static void main(String[] args) {
		
		
	}

}

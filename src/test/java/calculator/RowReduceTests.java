package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * This class acts as a testing suite for my calculator.
 * TODO:
 * 	- Add test cases for basic examples
 *  - Add test cases for edge cases
 *  - Add test cases for bad inputs
 *  - Add test to make sure the matrix gets printed correctly
 */
public class RowReduceTests {
	
	@Test
	public void testScalarMult() {
		int scalar = 2;
		int row = 0;
		Matrix test = new Matrix(2, 2);
		Matrix expected = new Matrix(2,2);
		
		double testRow1[] = {1, 2};
		double testRow2[] = {3, 4};
		double expectedRow1[] = {2, 4};
		double expectedRow2[] = {3, 4}; 
		
		test.setRow(testRow1, 0);
		test.setRow(testRow2, 1);
		expected.setRow(expectedRow1, 0);
		expected.setRow(expectedRow2, 1);
		
		MatrixUtils.scaleRow(test, row, scalar);
		
		System.out.println(expected);

		assertEquals(expected, test);		
	}
	
	@Test
	public void testSwapRows() {
		Matrix test = new Matrix(2,2);
		Matrix expected = new Matrix(2,2);
		
		double tRow1[] = {1,2};
		double tRow2[] = {3,4};
		double eRow1[] = {3,4};
		double eRow2[] = {1,2};
		
		test.setRow(tRow1, 0);
		test.setRow(tRow2, 1);
		expected.setRow(eRow1, 0);
		expected.setRow(eRow2, 1);
		
		MatrixUtils.swapRows(test, 0, 1);
		
		assertEquals(expected, test);
				
	}
	
	@Test
	public void testAddRows() {
		double[][] test = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		double[][] expected = { {1, 2, 3}, {4, 5, 6}, {8, 10, 12} };
		
		Matrix testM = new Matrix(test);
		Matrix expectedM = new Matrix(expected);
		
		int rowToAddTo = 2;
		int rowToAdd   = 0;
		
		MatrixUtils.addRows(testM, rowToAddTo, rowToAdd);
		
		assertEquals(expectedM, testM);
	}
}

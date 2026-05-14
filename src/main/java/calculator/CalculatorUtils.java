package calculator;

import java.util.Scanner;

/**
 * Class to hold utility methods for the main calculator program
 */
public class CalculatorUtils {

	/**
	 * Generates the introduction to the program, i.e., the first thing you see in the terminal
	 * @param programName
	 * @param version
	 * @return
	 */
	public static String generateProgramIntro(String programName, String version) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Program: " + programName + "\n");
		sb.append("Version: " + version + "\n");
		
		return sb.toString();
	}
	
	/**
	 * Fills a matrix with rows readin via the CLI
	 * 
	 * @param m
	 * @param row
	 */
	public static void setupMatrix(Matrix m, Scanner s, int rowIndex) {
		// If there is not input to be readin, noop
		if(!s.hasNextLine()) {
			return;
		}
		String currentRow = s.nextLine();
		String[] rowNums = currentRow.split(" ");
		if(rowNums.length != m.getNumCols()) {
			throw new RuntimeException("Error, out of column bounds");
		}
		double[] nums = new double[rowNums.length];
		// Convert Str nums to double nums
		for(int i = 0; i < rowNums.length; i++) {
			nums[i] = Double.parseDouble(rowNums[i]);
		}
		m.setRow(nums, rowIndex);
	}
	
	/**
	 * Print method for the calculator to display options
	 */
	public static void printCalcOptions() {
		/**
		 * 1. Print Matrix
		 * 2. Row Reduce Matrix
		 * 3. Manual Mode
		 * 		a. Add rows
		 * 		b. Scale row
		 *      c. Swap rows
		 * 4. Print column vector
		 * 5. Print menu 
		 * 0. Exit Program
		 *  
		 */
		StringBuilder sb = new StringBuilder();
		sb.append("(1) --  Print the matrix\n");
		sb.append("(2) --  Row Reduce Matrix\n");
		sb.append("(3) --  Manual Mode\n");
		sb.append("(4) --  Print Column Vector\n");
		sb.append("(5) --  Print Menu\n");
		sb.append("(0) --  Exit Program\n");
		
		System.out.println(sb.toString());
	}
	
	/**
	 * Print method to print the manual mode options
	 */
	public static void printManualModeOptions() {
		/**
		 * a. Add rows
		 * b. Scale row
		 * c. Swap rows
		 * d. Print matrix
		 * e. Print Manual mode menu
		 * f. Exit manual mode
		 */
		StringBuilder sb = new StringBuilder();
		sb.append("(a) -- Add rows\n");
		sb.append("(b) -- Scale row\n");
		sb.append("(c) -- Swap rows\n");
		sb.append("(d) -- Print Matrix\n");
		sb.append("(e) -- Print Manual Mode menu\n");
		sb.append("(f) -- Exit Manual Mode\n");
		
		System.out.println(sb.toString());
	}
}

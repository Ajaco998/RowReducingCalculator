package calculator;

import java.util.Scanner;

/**
 * This class acts as the main runner for this program.
 * It computes Row Reduction on a given matrix. 
 * It then outputs what the matrix would look like in Row Reduced Form
 * 
 */
public class Calculator {
	
	public static final String PROGRAM_NAME = "Row Reducing Calculator";
	public static final String PROGRAM_VERSION = "1.0.1";
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		String intro = CalculatorUtils.generateProgramIntro(PROGRAM_NAME, PROGRAM_VERSION);
		
		/**
		 * Current Plan:
		 *  - Implement methods to reset the matrix
		 *  	> Possibly implement a system to store matrices (?)
		 * 	
		 */
		
		
		System.out.println(intro);
		
		System.out.println("Please enter the dimensions of the matrix: ");
		String dimInput = s.nextLine();
		String[] dimensions = dimInput.split("x");
		
		int numRows = Integer.parseInt(dimensions[0]);
		int numCols = Integer.parseInt(dimensions[1]);
		System.out.println(String.format("Num rows: %d\nNum cols: %d", numRows, numCols));
		
		Matrix A = new Matrix(numRows, numCols);
		
		for(int i = 0; i < numRows; i++) {
			System.out.println(String.format("Please enter the current row to add (Row = %d): ", i+1));
			CalculatorUtils.setupMatrix(A, s, i);
		}
		
		System.out.println("\nCalculator Options\n"
				+ "----------------------------"
				+ "\nPick a number:\n");
		CalculatorUtils.printCalcOptions();
		
		boolean running = true;
		// Program Loop
		while(running) {
			int userChoice = s.nextInt();
			if(userChoice < 0 || userChoice > 5) {
				System.out.println("Enter a valid number: ");
			}
			switch(userChoice) {
			case 1:
				// Print Matrix
				System.out.println(A.toString());
				break;
			case 2:
				// Row Reduce Matrix
				System.out.print("Starting Matrix:\n" + A.toString() + "\n");
				A = MatrixUtils.rowReduce(A);
				System.out.print("RREF Matrix: \n" + A.toString() + "\n");
				
				//TODO: handle what do after the RREF matrix is printed.
				break;
			case 3:
				// Manual Mode
				// Print Manual Mode options
				// Enter "manual mode" loop
				// Have case for:
				// 	a. Add rows
				//  b. Scale row
				//  c. Swap rows
				//  d. Print matrix
				//  e. Print Manual Mode menu
				//  f. Exit Manual Mode
				boolean manualMode = true;
				while(manualMode) {
					int rowX, rowY;
					System.out.println("Manual Mode\n"
							+ "----------------------------");
					CalculatorUtils.printManualModeOptions();
					System.out.println("Enter a valid letter: ");
					while(!s.hasNext("[abcdef]")) {
						System.out.println("Please enter a valid letter.");
						s.next();
					}
					String manualChoice = s.next();
					switch(manualChoice) {
					case "a": // Add Rows
						System.out.println("Row X = X + Y");
						System.out.println("Please enter row X: ");
						rowX = s.nextInt() - 1; // Adjusted for user input
						
						System.out.println("Please enter row Y: ");
						rowY = s.nextInt() - 1; // Adjusted for user input
						
						System.out.println("Original: \n" + A.toString());
						MatrixUtils.addRows(A, rowX, rowY);
						System.out.println("After: \n" + A.toString());
	
						break;
					case "b": // Scale Row
						System.out.println("Please enter a row: ");
						int rowToBeScaled = s.nextInt() - 1; // Adjusted for user input
						
						System.out.println("Please enter a scalar: ");
						int scalar = s.nextInt();
						
						System.out.println("Original: \n" + A.toString());
						MatrixUtils.scaleRow(A, rowToBeScaled, scalar);
						System.out.println("After: \n" + A.toString());
						
						break;
					case "c": // Swap Rows
						System.out.println("Row X -> Y, Y -> X");
						System.out.println("Please enter row X: ");
						rowX = s.nextInt() - 1; // Adjusted for user input
						
						System.out.println("Please enter row Y: ");
						rowY = s.nextInt() - 1; // Adjusted for user input
						
						System.out.println("Original: \n" + A.toString());
						MatrixUtils.swapRows(A, rowX, rowY);
						System.out.println("After: \n" + A.toString());
						
						break;
					case "d": // Print Matrix
						System.out.println(A.toString());
						break;
					case "e": // Print Manual Mode menu
						CalculatorUtils.printManualModeOptions();
						break;
					case "f": // Exit Manual Mode
						manualMode = false;
						System.out.println("Leaving manual mode...");
						System.out.println("\nCalculator Options\n"
								+ "----------------------------"
								+ "\nPick a number:\n");
						CalculatorUtils.printCalcOptions();
						break;
					default:
						System.out.println("Please enter a valid letter.");
					}
				}
				break;
			case 4:
				// Print column vector
				System.out.println("Please enter a column: ");
				int colVecIndex = s.nextInt() - 1; // Adjusted for user input
				s.nextLine();
				MatrixUtils.printColVec(A, colVecIndex);
				break;
			case 5:
				// Print Menu
				System.out.println("\nCalculator Options\n"
						+ "----------------------------"
						+ "\nPick a number:\n");
				CalculatorUtils.printCalcOptions();
				break;
			case 0:
				// Exit Program 
				System.out.println("Exiting Program...");
				running = false;
				break;
				
			}
		}
		s.close();
	}

}

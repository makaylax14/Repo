/*
 * Class: CMSC203
 * Project: 5
 * Instructor: Farnaz Eivazi
 * Description: This class contains methods that allow the program
 * to manipulate a two-dimensional array that represents the sales report
 * for the stores of a particular district. This class contains methods like
 * finding totals for rows and columns and determining the indices of certain values.
 * Due: 11/17/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Makayla Lee
 */

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TwoDimRaggedArrayUtility {
	/*
	 * The constructor below is used to
	 * instantiate a TwoDimRaggedArrayUtility.
	 * There are no attributes to assign values to
	 * because this class does not have attributes.
	 */
	public TwoDimRaggedArrayUtility() {}
	/*
	 * This method takes in a two dimensional array
	 * and returns the average.
	 */
	public static double getAverage(double[][] data) {
		double total=0;
		int tracker=0;
		for (double[] row : data) {
			for (double val : row) {
				total+=val;
				tracker++;
			}
		}
		return total/tracker;
	}
	/*
	 * This method takes in a two dimensional array
	 * and a column index. It calculates the total of
	 * that column.
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total=0;
		for (int counter = 0; counter < data.length; counter++) {
			for (int counter2 = 0; counter2 < data[counter].length; counter2++) {
				if (counter2==col) {
					total+=data[counter][counter2];
				}
			}
		}
		return total;
	}
	/*
	 * This method takes in a two dimensional array
	 * and returns the highest in the array. It uses a loop
	 * to do this.
	 */
	public static double getHighestInArray(double[][] data) {
		double max=data[0][0];
		for (int counter =0; counter < data.length; counter++) {
			for (int counter2 =0; counter2 < data[counter].length; counter2++) {
				if (data[counter][counter2]>max) {
					max=data[counter][counter2];
				}
			}
		}
		return max;
	}
	/*
	 * This method finds the highest in a column by
	 * taking in a two dimensional array and a column index.
	 * It returns the highest in the column.
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double max=0;
		for (int count = 0; count<data.length; count++) {
			if (data[count].length>col) {
				max=data[count][col];
				break;
			}
		}
		for (int counter = 0; counter<data.length; counter++) {
			for (int counter2 = 0; counter2<data[counter].length; counter2++) {
				if (counter2==col) {
					if (data[counter][counter2]>max) {
						max=data[counter][counter2];
					}
				}
			}
		}
		return max;
	}
	/*
	 * This method takes in a two dimensional array and a value
	 * for the column. It then calculates the index (the row index) where the highest
	 * value in the column is.
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int index=0;
		double max=0;
		for (int count = 0; count<data.length; count++) {
			if (data[count].length>col) {
				max=data[count][col];
				index=count;
				break;
			}
		}
		for (int counter = 0; counter<data.length; counter++) {
			for (int counter2 = 0; counter2<data[counter].length; counter2++) {
				if (counter2==col) {
					if (data[counter][counter2]>max) {
						max=data[counter][counter2];
						index=counter;
					}
				}
			}
		}
		return index;
	}
	/*
	 * This method takes in a two dimensional array
	 * and a value for the row index. Then, it returns
	 * the highest in that row.
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double max=data[row][0];
		for (int counter = 0; counter < data[row].length; counter++) {
			if (data[row][counter]>max) {
				max=data[row][counter];
			}
		}
		return max;
	}
	/*
	 * This method takes in a two dimensional array
	 * and a value for the row index. It returns the
	 * column index at which the highest value in the row is at.
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double max=data[row][0];
		int index=0;
		for (int counter = 0; counter < data[row].length; counter++) {
			if (data[row][counter]>max) {
				max=data[row][counter];
				index=counter;
			}
		}
		return index;
	}
	/*
	 * This method takes in a two dimensional array
	 * and determines the lowest value in the array. It then returns it.
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest=data[0][0];
		for (int counter=0; counter<data.length; counter++) {
			for (int counter2=0; counter2<data[counter].length; counter2++) {
				if (data[counter][counter2]<lowest) {
					lowest=data[counter][counter2];
				}
			}
		}
		return lowest;
	}
	/*
	 * This method takes in a two dimensional array
	 * and a value for the column index. It finds the
	 * lowest value in that column and returns it.
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest=0;
		for (int count = 0; count<data.length; count++) {
			if (data[count].length>col) {
				lowest=data[count][col];
				break;
			}
		}
		for (int counter = 0; counter<data.length; counter++) {
			for (int counter2 = 0; counter2<data[counter].length; counter2++) {
				if (counter2==col) {
					if (data[counter][counter2]<lowest) {
						lowest=data[counter][counter2];
					}
				}
			}
		}
		return lowest;
	}
	/*
	 * This methods takes in a two dimensional array
	 * and a value for the column index. It determines
	 * the index (row index) of the lowest value in the column
	 * and returns it.
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest=0;
		int index=0;
		for (int count = 0; count<data.length; count++) {
			if (data[count].length>col) {
				lowest=data[count][col];
				index=count;
				break;
			}
		}
		for (int counter = 0; counter<data.length; counter++) {
			for (int counter2 = 0; counter2<data[counter].length; counter2++) {
				if (counter2==col) {
					if (data[counter][counter2]<lowest) {
						lowest=data[counter][counter2];
						index=counter;
					}
				}
			}
		}
		return index;
	}
	/*
	 * This method takes in a two dimensional array and a
	 * value for the row index. It finds the lowest value in that
	 * row and returns it.
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest=data[row][0];
		for (int counter = 0; counter < data[row].length; counter++) {
			if (data[row][counter]<lowest) {
				lowest=data[row][counter];
			}
		}
		return lowest;
	}
	/*
	 * This method takes in a two dimensional array
	 * and a value for the row index. It determines the index of the lowest value in
	 * that row and returns it.
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest=data[row][0];
		int index=0;
		for (int counter = 0; counter < data[row].length; counter++) {
			if (data[row][counter]<lowest) {
				lowest=data[row][counter];
				index=counter;
			}
		}
		return index;
	}
	/*
	 * This method takes in a two dimensional array
	 * and a value for the row index. It calculates
	 * the total of that row and returns it.
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total=0;
		for (int counter=0; counter<data[row].length; counter++) {
			total+=data[row][counter];
		}
		return total;
	}
	/*
	 * This method takes in a two dimensional array
	 * and calculates the total of the values in the array.
	 * It returns the total.
	 */
	public static double getTotal(double[][] data) {
		double total=0;
		for (double[] row : data) {
			for (double val : row) {
				total+=val;
			}
		}
		return total;
	}
	/*
	 * This method takes in a file as a parameter and
	 * then reads the values from the file into a ragged array.
	 */
	public static double[][] readFile(File file) throws FileNotFoundException{
		final int MAX_ROW=10;
		final int MAX_COLUMN=10;
		int numOfCols=0,
				numOfRows=0,
				index1OfTempArr=0,
				index2OfTempArr=0,
				colNum=0;
		String[][] tempArr = new String[MAX_ROW][MAX_COLUMN];
		
		try (Scanner sc = new Scanner(file)) {
			if (!sc.hasNext()) {
				return null;
			}
		}
		
		try (Scanner sc = new Scanner(file)) {
			for (int counter=0; counter<MAX_ROW && sc.hasNextLine(); counter++) {
				
				colNum=0;
				
				String[] tokens = (sc.nextLine()).split(" ");
				for (int tracker=0; tracker<tokens.length; tracker++) {
					tempArr[counter][colNum]=tokens[tracker];
					colNum++;
				}
				
			}
		}
		
		// Counting num of rows
		for (int count = 0; count < MAX_ROW; count++) {
			if (tempArr[count][0]!=null) {
				numOfRows++;
			}
		}
		
		double[][] arr = new double[numOfRows][];
		//Counting num of cols
		for (int count1=0; count1<numOfRows; count1++) {
			numOfCols=0;
			for (int count2=0; count2<MAX_COLUMN; count2++) {
				if (tempArr[count1][count2]!=null) {
					numOfCols++;
				}
			}
			arr[count1]=new double[numOfCols];
		}
		
		
		for (int counter=0; counter<arr.length; counter++) {
			for (int counter2=0; counter2<arr[counter].length; counter2++) {
				arr[counter][counter2]=Double.parseDouble(tempArr[counter][counter2]);
			}
		}
		return arr;
	}
	/*
	 * This method takes in a two dimensional array
	 * and a file. It writes the  values of the array
	 * to the file.
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(outputFile);
		for (int counter=0; counter<data.length; counter++) {
			for (int counter2=0; counter2<data[counter].length; counter2++) {
				if (counter2==data[counter].length-1) {
					pw.print(data[counter][counter2]);
				}
				else {
					pw.print(data[counter][counter2]+" ");
				}
			}
			pw.print("\n");
		}
		pw.close();
	}
}

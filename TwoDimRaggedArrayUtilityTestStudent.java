import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.*;

class TwoDimRaggedArrayUtilityTestStudent {
	private double[][] arr1 = {{7.2, 2.5, 9.3, 4.8}, {5.9}, {8.1, 1.7, 3.3}, {11.6, 6.9, 7.3, 2.7}};
	private double[][] arr2 = {{-2.5, -5.3, 6.1}, {-4.4, 8.2}, {2.3, -7.5}, {-4.2, 7.3, -5.9, 2.6}};

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAverage() {
		assertEquals(5.94166667, TwoDimRaggedArrayUtility.getAverage(arr1), .01);
		assertEquals(-0.3, TwoDimRaggedArrayUtility.getAverage(arr2), .01);
	}

	@Test
	void testGetColumnTotal() {
		assertEquals(32.8, TwoDimRaggedArrayUtility.getColumnTotal(arr1, 0), .01);
		assertEquals(11.1, TwoDimRaggedArrayUtility.getColumnTotal(arr1, 1), .01);
		assertEquals(19.9, TwoDimRaggedArrayUtility.getColumnTotal(arr1, 2), .01);
		assertEquals(7.5, TwoDimRaggedArrayUtility.getColumnTotal(arr1, 3), .01);
		assertEquals(-8.8, TwoDimRaggedArrayUtility.getColumnTotal(arr2, 0), .01);
		assertEquals(2.7, TwoDimRaggedArrayUtility.getColumnTotal(arr2, 1), .01);
		assertEquals(0.2, TwoDimRaggedArrayUtility.getColumnTotal(arr2, 2), .01);
		assertEquals(2.6, TwoDimRaggedArrayUtility.getColumnTotal(arr2, 3), .01);
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(11.6, TwoDimRaggedArrayUtility.getHighestInArray(arr1));
		assertEquals(8.2, TwoDimRaggedArrayUtility.getHighestInArray(arr2));
	}

	@Test
	void testGetHighestInColumn() {
		assertEquals(11.6, TwoDimRaggedArrayUtility.getHighestInColumn(arr1, 0));
		assertEquals(6.9, TwoDimRaggedArrayUtility.getHighestInColumn(arr1, 1));
		assertEquals(9.3, TwoDimRaggedArrayUtility.getHighestInColumn(arr1, 2));
		assertEquals(4.8, TwoDimRaggedArrayUtility.getHighestInColumn(arr1, 3));
		assertEquals(2.3, TwoDimRaggedArrayUtility.getHighestInColumn(arr2, 0));
		assertEquals(8.2, TwoDimRaggedArrayUtility.getHighestInColumn(arr2, 1));
		assertEquals(6.1, TwoDimRaggedArrayUtility.getHighestInColumn(arr2, 2));
		assertEquals(2.6, TwoDimRaggedArrayUtility.getHighestInColumn(arr2, 3));
	}

	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr1, 0));
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr1, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr1, 2));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr1, 3));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr2, 0));
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr2, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr2, 2));
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(arr2, 3));
	}

	@Test
	void testGetHighestInRow() {
		assertEquals(9.3, TwoDimRaggedArrayUtility.getHighestInRow(arr1, 0));
		assertEquals(5.9, TwoDimRaggedArrayUtility.getHighestInRow(arr1, 1));
		assertEquals(8.1, TwoDimRaggedArrayUtility.getHighestInRow(arr1, 2));
		assertEquals(11.6, TwoDimRaggedArrayUtility.getHighestInRow(arr1, 3));
		assertEquals(6.1, TwoDimRaggedArrayUtility.getHighestInRow(arr2, 0));
		assertEquals(8.2, TwoDimRaggedArrayUtility.getHighestInRow(arr2, 1));
		assertEquals(2.3, TwoDimRaggedArrayUtility.getHighestInRow(arr2, 2));
		assertEquals(7.3, TwoDimRaggedArrayUtility.getHighestInRow(arr2, 3));
	}

	@Test
	void testGetHighestInRowIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(arr1, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(arr1, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(arr1, 2));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(arr1, 3));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(arr2, 0));
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(arr2, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(arr2, 2));
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(arr2, 3));
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(1.7, TwoDimRaggedArrayUtility.getLowestInArray(arr1));
		assertEquals(-7.5, TwoDimRaggedArrayUtility.getLowestInArray(arr2));
	}

	@Test
	void testGetLowestInColumn() {
		assertEquals(5.9, TwoDimRaggedArrayUtility.getLowestInColumn(arr1, 0));
		assertEquals(1.7, TwoDimRaggedArrayUtility.getLowestInColumn(arr1, 1));
		assertEquals(3.3, TwoDimRaggedArrayUtility.getLowestInColumn(arr1, 2));
		assertEquals(2.7, TwoDimRaggedArrayUtility.getLowestInColumn(arr1, 3));
		assertEquals(-4.4, TwoDimRaggedArrayUtility.getLowestInColumn(arr2, 0));
		assertEquals(-7.5, TwoDimRaggedArrayUtility.getLowestInColumn(arr2, 1));
		assertEquals(-5.9, TwoDimRaggedArrayUtility.getLowestInColumn(arr2, 2));
		assertEquals(2.6, TwoDimRaggedArrayUtility.getLowestInColumn(arr2, 3));
	}

	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr1, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr1, 1));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr1, 2));
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr1, 3));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr2, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr2, 1));
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr2, 2));
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(arr2, 3));
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(2.5, TwoDimRaggedArrayUtility.getLowestInRow(arr1, 0));
		assertEquals(5.9, TwoDimRaggedArrayUtility.getLowestInRow(arr1, 1));
		assertEquals(1.7, TwoDimRaggedArrayUtility.getLowestInRow(arr1, 2));
		assertEquals(2.7, TwoDimRaggedArrayUtility.getLowestInRow(arr1, 3));
		assertEquals(-5.3, TwoDimRaggedArrayUtility.getLowestInRow(arr2, 0));
		assertEquals(-4.4, TwoDimRaggedArrayUtility.getLowestInRow(arr2, 1));
		assertEquals(-7.5, TwoDimRaggedArrayUtility.getLowestInRow(arr2, 2));
		assertEquals(-5.9, TwoDimRaggedArrayUtility.getLowestInRow(arr2, 3));
	}

	@Test
	void testGetLowestInRowIndex() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(arr1, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(arr1, 1));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(arr1, 2));
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInRowIndex(arr1, 3));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(arr2, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(arr2, 1));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(arr2, 2));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(arr2, 3));
	}

	@Test
	void testGetRowTotal() {
		assertEquals(23.8, TwoDimRaggedArrayUtility.getRowTotal(arr1, 0), .01);
		assertEquals(5.9, TwoDimRaggedArrayUtility.getRowTotal(arr1, 1), .01);
		assertEquals(13.1, TwoDimRaggedArrayUtility.getRowTotal(arr1, 2), .01);
		assertEquals(28.5, TwoDimRaggedArrayUtility.getRowTotal(arr1, 3), .01);
		assertEquals(-1.7, TwoDimRaggedArrayUtility.getRowTotal(arr2, 0), .01);
		assertEquals(3.8, TwoDimRaggedArrayUtility.getRowTotal(arr2, 1), .01);
		assertEquals(-5.2, TwoDimRaggedArrayUtility.getRowTotal(arr2, 2), .01);
		assertEquals(-0.2, TwoDimRaggedArrayUtility.getRowTotal(arr2, 3), .01);
	}

	@Test
	void testGetTotal() {
		assertEquals(71.3, TwoDimRaggedArrayUtility.getTotal(arr1), .001);
		assertEquals(-3.3, TwoDimRaggedArrayUtility.getTotal(arr2), .001);
	}

	@Test
	void testReadFile() throws FileNotFoundException{
		boolean bothSame1=true;
		boolean bothSame2=true;
		File file = new File("dataSet3.txt");
		double[][] arr1Returned=TwoDimRaggedArrayUtility.readFile(file);
		File file2 = new File("dataSet4.txt");
		double[][] arr2Returned=TwoDimRaggedArrayUtility.readFile(file2);
		double[][] arr1Compare={{7.2, 2.5, 9.3, 4.8}, {5.9}, {8.1, 1.7, 3.3}, {11.6, 6.9, 7.3, 2.7}};
		double[][] arr2Compare={{-2.5, -5.3, 6.1}, {-4.4, 8.2}, {2.3, -7.5}, {-4.2, 7.3, -5.9, 2.6}};
		assertEquals(arr1Returned.length, arr1Compare.length);
		assertEquals(arr2Returned.length, arr2Compare.length);
		for (int row = 0; row < arr1Returned.length; row++) {
			assertEquals(arr1Returned[row].length, arr1Compare[row].length);
		}
		for (int row = 0; row < arr2Returned.length; row++) {
			assertEquals(arr2Returned[row].length, arr2Compare[row].length);
		}
		for (int row=0; row<arr1Returned.length; row++) {
			for (int col=0; col<arr1Returned[row].length; col++) {
				if (arr1Returned[row][col]!=arr1Compare[row][col]) {
					bothSame1=false;
				}
			}
		}
		for (int row=0; row<arr2Returned.length; row++) {
			for (int col=0; col<arr2Returned[row].length; col++) {
				if (arr2Returned[row][col]!=arr2Compare[row][col]) {
					bothSame2=false;
				}
			}
		}
		assertEquals(true, bothSame1);
		assertEquals(true, bothSame2);
	}

	@Test
	void testWriteToFile() throws FileNotFoundException{
		boolean bothSame1=true;
		boolean bothSame2=true;
		File file = new File("file1.txt");
		File file2 = new File("file2.txt");
		TwoDimRaggedArrayUtility.writeToFile(arr1, file);
		TwoDimRaggedArrayUtility.writeToFile(arr2, file2);
		double[][] array1=TwoDimRaggedArrayUtility.readFile(file);
		double[][] array2=TwoDimRaggedArrayUtility.readFile(file2);
		
		assertEquals(array1.length, arr1.length);
		assertEquals(array2.length, arr2.length);
		for (int row = 0; row < array1.length; row++) {
			assertEquals(array1[row].length, arr1[row].length);
		}
		for (int row = 0; row < array2.length; row++) {
			assertEquals(array2[row].length, arr2[row].length);
		}
		for (int row=0; row<array1.length; row++) {
			for (int col=0; col<array1[row].length; col++) {
				if (array1[row][col]!=arr1[row][col]) {
					bothSame1=false;
				}
			}
		}
		for (int row=0; row<array2.length; row++) {
			for (int col=0; col<array2[row].length; col++) {
				if (array2[row][col]!=arr2[row][col]) {
					bothSame2=false;
				}
			}
		}
		assertEquals(true, bothSame1);
		assertEquals(true, bothSame2);
		
	}

}

/*
 * Class: CMSC203
 * Project: 5
 * Instructor: Farnaz Eivazi
 * Description: This class contains methods that allow the program
 * to determine the holiday bonuses each store receives as well as the total
 * holiday bonuses a particular district receives.
 * Due: 11/17/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Makayla Lee
 */

public class HolidayBonus {
	private static final int HIGHEST=5000;
	private static  final int LOWEST=1000;
	private static final int OTHERS=2000;
	/*
	 * The constructor below is used to
	 * instantiate a HolidayBonus.
	 * There are no attributes to assign values to
	 * because this class only has final attributes.
	 */
	public HolidayBonus() {}
	/*
	 * This method takes in a two dimensional array
	 * and goes through each column to determine which store receives the
	 * highest bonus, lowest bonus, and the $2,000 bonus. It returns an array with
	 * the bonuses for each store.
	 */
	public static double[] calculateHolidayBonus(double[][] data) {
		double[] bonuses = new double[data.length];
		int index1,
			index2,
			maxCols;
		maxCols=data[0].length;
		// Determines the max number of rows in the ragged array
		for (int count=0; count<data.length; count++) {
			if (data[count].length>maxCols) {
				maxCols=data[count].length;
			}
		}
		
		
		for (int count=0; count < maxCols; count++) {
			// Finds the index with the highest value
			index1=TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, count);
			// Finds the index with the lowest value
			index2=TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, count);
			
			for (int row=0; row<data.length; row++) {
				// Makes sure the row has the column and the value is greater than 0
				if (count<data[row].length&&data[row][count]>0) {
					if (row==index1) {
						bonuses[row]+=HIGHEST;
					}
					else if (row==index2) {
						bonuses[row]+=LOWEST;
					}
					else {
						bonuses[row]+=OTHERS;
					}
				}
			}
			
		}
		return bonuses;
	}
	/*
	 * This method takes in a two dimensional array
	 * and calls calculateHolidayBonus(). It receives the returned
	 * array and calculates the total of the bonuses. It then returns it.
	 */
	public static double calculateTotalHolidayBonus(double[][] data) {
		double total=0;
		double[] arr=calculateHolidayBonus(data);
		for (int count=0; count<arr.length; count++) {
			total+=arr[count];
		}
		return total;
	}
}

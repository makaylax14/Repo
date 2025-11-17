import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {
	private double[][] arr1 = {{7.2, 2.5, 9.3, 4.8}, {5.9}, {8.1, 1.7, 3.3}, {11.6, 6.9, 7.3, 2.7}};
	private double[][] arr2 = {{-2.5, -5.3, 6.1}, {-4.4, 8.2}, {2.3, -7.5}, {-4.2, 7.3, -5.9, 2.6}};
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateHolidayBonus() {
		double[] returned1=HolidayBonus.calculateHolidayBonus(arr1);
		double[] compare1= {14000, 1000, 4000, 13000};
		assertEquals(compare1.length, returned1.length);
		for (int count=0; count<compare1.length; count++) {
			assertEquals(compare1[count], returned1[count]);
		}
		double[] returned2=HolidayBonus.calculateHolidayBonus(arr2);
		double[] compare2= {5000, 5000, 5000, 7000};
		assertEquals(compare2.length, returned2.length);
		for (int count=0; count<compare2.length; count++) {
			assertEquals(compare2[count], returned2[count]);
		}
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(32000, HolidayBonus.calculateTotalHolidayBonus(arr1));
		assertEquals(22000, HolidayBonus.calculateTotalHolidayBonus(arr2));
	}

}

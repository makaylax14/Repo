import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	@Test
	void testProperty() {
		Property prop = new Property();
		assertEquals("", prop.getCity());
		assertEquals("", prop.getOwner());
		assertEquals("", prop.getPropertyName());
		boolean test = prop.getPlot()==null;
		assertFalse(test);
	}

	@Test
	void testPropertyStringStringDoubleString() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me");
		boolean test = prop.getPlot()==null;
		assertFalse(test);
		assertEquals("Rose", prop.getPropertyName());
		assertEquals("Rockville", prop.getCity());
		assertEquals(1500.6, prop.getRentAmount());
		assertEquals("Me", prop.getOwner());
	}

	@Test
	void testPropertyStringStringDoubleStringIntIntIntInt() {
		Property prop = new Property("Bob", "Chicago", 1000.30, "Me", 5, 5, 1, 2);
		boolean test = prop.getPlot()==null;
		assertFalse(test);
		assertEquals("Bob", prop.getPropertyName());
		assertEquals("Chicago", prop.getCity());
		assertEquals(1000.30, prop.getRentAmount());
		assertEquals("Me", prop.getOwner());
		assertEquals(5, prop.getPlot().getX());
		assertEquals(5, prop.getPlot().getY());
		assertEquals(1, prop.getPlot().getWidth());
		assertEquals(2, prop.getPlot().getDepth());
	}

	@Test
	void testPropertyProperty() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		Property prop2 = new Property(prop);
		boolean test = prop2.getPlot()==null;
		assertFalse(test);
		assertEquals("Rose", prop2.getPropertyName());
		assertEquals("Rockville", prop2.getCity());
		assertEquals(1500.6, prop2.getRentAmount());
		assertEquals("Me", prop2.getOwner());
		assertEquals(1, prop2.getPlot().getX());
		assertEquals(5, prop2.getPlot().getY());
		assertEquals(1, prop2.getPlot().getWidth());
		assertEquals(2, prop2.getPlot().getDepth());
	}

	@Test
	void testGetCity() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		assertEquals("Rockville", prop.getCity());
	}

	@Test
	void testSetCity() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		prop.setCity("Towson");
		assertEquals("Towson", prop.getCity());
	}

	@Test
	void testGetOwner() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		assertEquals("Me", prop.getOwner());
	}

	@Test
	void testSetOwner() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		prop.setOwner("You");
		assertEquals("You", prop.getOwner());
	}

	@Test
	void testGetPlot() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		assertEquals(1, prop.getPlot().getX());
		assertEquals(5, prop.getPlot().getY());
		assertEquals(1, prop.getPlot().getWidth());
		assertEquals(2, prop.getPlot().getDepth());
	}

	@Test
	void testSetPlot() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		Plot plot = new Plot(1, 4, 6, 2);
		prop.setPlot(plot);
		assertEquals(1, prop.getPlot().getX());
		assertEquals(4, prop.getPlot().getY());
		assertEquals(6, prop.getPlot().getWidth());
		assertEquals(2, prop.getPlot().getDepth());
		
	}

	@Test
	void testGetPropertyName() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		assertEquals("Rose", prop.getPropertyName());
	}

	@Test
	void testSetPropertyName() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		prop.setPropertyName("John's");
		assertEquals("John's", prop.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		assertEquals(1500.6, prop.getRentAmount());
	}

	@Test
	void testSetRentAmount() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		prop.setRentAmount(2000.1);
		assertEquals(2000.1, prop.getRentAmount());
	}

	@Test
	void testToString() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		String str = "Rose,Rockville,Me,1500.6";
		assertEquals(str, prop.toString());
	}
	@Test
	void testEquals() {
		Property prop = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		Property prop2 = new Property("Dog", "Richmond", 1938.3, "Betty", 3, 8, 1, 1);
		assertEquals(false, prop.equals(prop2));
		Property prop3 = new Property("Rose", "Rockville", 1500.6, "Me", 1, 5, 1, 2);
		assertEquals(true, prop.equals(prop3));
	}

}

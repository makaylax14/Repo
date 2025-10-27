import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {
	Property exProperty;
	ManagementCompany overallCo=new ManagementCompany("Mak", "123", 5.0, 0, 0, 10, 10);
	
	@Test
	public void testManagementCompany2() {
		ManagementCompany exCo;
		Plot plot = new Plot(0, 0, 10, 10);
		Property[] properties = new Property[5];
		exCo = new ManagementCompany("Bob's", "1234", 15.6);		 
		assertEquals("Bob's", exCo.getName());
		assertEquals("1234", exCo.getTaxID());
		assertEquals(15.6, exCo.getMgmFeePer());
		boolean test = exCo.getPlot()==null;
		assertFalse(test);
		assertEquals(0, exCo.getPlot().getX());
		assertEquals(0, exCo.getPlot().getY());
		assertEquals(10, exCo.getPlot().getWidth());
		assertEquals(10, exCo.getPlot().getDepth());
		assertEquals(5, exCo.getProperties().length);
		
		//assertEquals(plot, exCo.getPlot());
		//assertEquals(properties, exCo.getProperties());
	}
	@Test
	public void testManagementCompany1() {
		ManagementCompany exCo;
		Plot exPlot = new Plot(0, 0, 10, 10);
		Property[] properties = new Property[5];
		exCo = new ManagementCompany();		
		boolean test = exCo.getPlot()==null;
		assertFalse(test);
		assertEquals("", exCo.getName());
		assertEquals("", exCo.getTaxID());
		assertEquals(0, exCo.getPlot().getX());
		assertEquals(0, exCo.getPlot().getY());
		assertEquals(10, exCo.getPlot().getWidth());
		assertEquals(10, exCo.getPlot().getDepth());
		assertEquals(5, exCo.getProperties().length);
		//assertEquals(exPlot, exCo.getPlot());
		//assertEquals(properties, exCo.getProperties());
	}
	@Test
	public void testManagementCompany3() {
		ManagementCompany exCo;
		Plot exPlot = new Plot(0, 0, 10, 10);
		Property[] properties = new Property[5];
		exCo = new ManagementCompany("Bob's", "555", 15.6, 1, 2, 3, 2);		
		assertEquals("Bob's", exCo.getName());
		assertEquals("555", exCo.getTaxID());
		assertEquals(15.6, exCo.getMgmFeePer());
		boolean test = exCo.getPlot()==null;
		assertFalse(test);
		assertEquals(1, exCo.getPlot().getX());
		assertEquals(2, exCo.getPlot().getY());
		assertEquals(3, exCo.getPlot().getWidth());
		assertEquals(2, exCo.getPlot().getDepth());
		assertEquals(5, exCo.getProperties().length);
		
		//assertEquals(exPlot, exCo.getPlot());
		//assertEquals(properties, exCo.getProperties());
	}
	@Test
	public void testManagementCompany4() {
		Plot exPlot = new Plot(0, 0, 10, 10);
		ManagementCompany exCo=new ManagementCompany("Johnson", "555", 14.3, 1, 6, 3, 3);	
		ManagementCompany exCo2 = new ManagementCompany(exCo);
		assertEquals("Johnson", exCo2.getName());
		assertEquals("555", exCo2.getTaxID());
		assertEquals(14.3, exCo2.getMgmFeePer());
		boolean test = exCo.getPlot()==null;
		assertFalse(test);
		assertEquals(1, exCo.getPlot().getX());
		assertEquals(6, exCo.getPlot().getY());
		assertEquals(3, exCo.getPlot().getWidth());
		assertEquals(3, exCo.getPlot().getDepth());
		//assertEquals(exPlot, exCo2.getPlot());
		
		assertEquals(0, exCo2.getNumberOfProperties());
		assertEquals(null, exCo2.getProperties()[0]);
	}
	@Test
	public void testMgmFee() {
		overallCo.setMgmFeePer(5.1);
		assertEquals(5.1, overallCo.getMgmFeePer());
	}
	@Test
	public void testName() {
		overallCo.setName("Makayla");
		assertEquals("Makayla", overallCo.getName());
	}
	@Test
	public void testNumOfProperties() {
		overallCo.setNumberOfProperties(1);
		assertEquals(1, overallCo.getNumberOfProperties());
		assertEquals(1, overallCo.getPropertiesCount());
		overallCo.setNumberOfProperties(0);
		overallCo.addProperty("B", "Chicago", 4000.2, "Bob", 1, 1, 2, 2);
		assertEquals(1, overallCo.getNumberOfProperties());
		overallCo.addProperty("G", "Boston", 3000.5, "Bob", 3, 4, 1, 2);
		assertEquals(2, overallCo.getNumberOfProperties());
	}
	@Test
	public void testPlot() {
		Plot plot = new Plot(1, 4, 3, 2);
		overallCo.setPlot(plot);
		assertEquals(plot, overallCo.getPlot());
	}
	@Test
	public void testTaxID() {
		overallCo.setTaxID("12");
		assertEquals("12", overallCo.getTaxID());
	}
	@Test
	public void testMaxProperty() {
		assertEquals(5, ManagementCompany.getMaxProperty());
	}
	@Test
	public void testMgmtDepth() {
		assertEquals(10, ManagementCompany.getMgmtDepth());
	}
	@Test
	public void testMgmtWidth() {
		assertEquals(10, ManagementCompany.getMgmtWidth());
	}
	@Test
	public void testIsManagementFeeValid() {
		overallCo.setMgmFeePer(15);
		assertEquals(true, overallCo.isManagementFeeValid());
		overallCo.setMgmFeePer(-1);
		assertEquals(false, overallCo.isManagementFeeValid());
	}
	@Test
	public void testIsPropertiesFull() {
		assertEquals(false, overallCo.isPropertiesFull());
		overallCo.setNumberOfProperties(5);
		assertEquals(true, overallCo.isPropertiesFull());
	}
	@Test
	public void testAddPropertiesAndToString() {
		overallCo.setMgmFeePer(5.1);
		String str = "List of the properties for Mak, taxID: 123\n"
				+ "______________________________________________________\n"
				+ "Smith,Towson,You,300.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 15.30";
		assertEquals(0, overallCo.addProperty("Smith", "Towson", 300, "You", 1, 1, 1, 1));
		assertEquals(str, overallCo.toString());
		assertEquals(1, overallCo.addProperty("Johnson", "Rockville", 100, "Me", 2, 1, 1, 1));
	}
	@Test
	public void testGetHighestRentProperty() {
		overallCo.addProperty("Smith", "Towson", 300, "You");
		overallCo.addProperty("Johnson", "Rockville", 100, "Me");
		Property highestProp = overallCo.getHighestRentProperty();
		assertEquals(300, highestProp.getRentAmount());
	}
	@Test
	public void testGetTotalRent() {
		overallCo.addProperty("Smith", "Towson", 300, "You", 1, 1, 1, 1);
		overallCo.addProperty("Johnson", "Rockville", 100, "Me", 2, 1, 1, 1);
		assertEquals(400, overallCo.getTotalRent());
	}
	@Test
	public void testRemoveProperty() {
		overallCo.addProperty("Smith", "Towson", 300, "You");
		overallCo.addProperty("Johnson", "Rockville", 100, "Me");
		overallCo.removeLastProperty();
		assertEquals(1, overallCo.getNumberOfProperties());
	}
	@Test
	public void testEquals() {
		ManagementCompany num1 = new ManagementCompany("Ross", "134", 1450.9, 3, 4, 1, 2);
		ManagementCompany num2 = new ManagementCompany("Chandler", "384", 190.2, 1, 2, 2, 1);
		assertEquals(false, num1.equals(num2));
		ManagementCompany num3 = new ManagementCompany("Ross", "134", 1450.9, 3, 4, 1, 2);
		assertEquals(true, num1.equals(num3));
	}

}

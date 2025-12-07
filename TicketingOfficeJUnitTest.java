import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketingOfficeJUnitTest {

    private TicketingOffice office;

    @BeforeEach
    void setUp() {
        office = new TicketingOffice("Beige", 8, 7);
    }

    @Test
	void testConstructor(){
    	assertEquals("Beige", office.getColor());
    	assertEquals(8, office.getLength());
    	assertEquals(7, office.getWidth());
    	assertEquals("Ticketing Office", office.getBuildingType());
    }
	
    @Test
    void testSetSize() {
    	office.setSize(6,  5);
    	assertEquals(6, office.getLength());
    	assertEquals(5, office.getWidth());
    }
	
	@Test
	void testSetColor() {
		office.setColor("Pink");
		assertEquals("Pink", office.getColor());
	}


    @Test
    void testSetBuildingType() {
    	office.setBuildingType("Big Ticketing Office");
    	assertEquals("Big Ticketing Office", office.getBuildingType());
    }

      
    @Test
	void testToString() {
    	String str = "Color: Beige\nLength: 8.0\nWidth: 7.0\nBuilding Type: Ticketing Office";
    	assertEquals(str, office.toString());
    }
	




    
    
}

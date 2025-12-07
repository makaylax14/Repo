import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArenaJUnitTest {

    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena("Blue", 100.0, 50.0);
    }

    @Test
    void testConstructorAndInitialValues() {
        assertEquals("Blue", arena.getColor(), "Initial color is incorrect.");
        assertEquals(100.0, arena.getLength(), 0.001, "Initial length is incorrect.");
        assertEquals(50.0, arena.getWidth(), 0.001, "Initial width is incorrect.");
        assertEquals("Arena", arena.getBuildingType(), "Initial building type is incorrect.");
    }

    @Test
	void testSetSize() {
    	arena.setSize(10.0, 20.0);
    	assertEquals(10.0, arena.getLength());
    	assertEquals(20.0, arena.getWidth());
    }

    @Test
	void testSetColor() {
    	arena.setColor("Pink");
    	assertEquals("Pink", arena.getColor());
    }


    @Test
	void testSetBuildingType() {
    	arena.setBuildingType("Big arena");
    	assertEquals("Big arena", arena.getBuildingType());
    }

      
    @Test
	void testToString() {
    	String expected = "Color: Blue\nLength: 100.0\nWidth: 50.0\nBuilding Type: Arena";
    	assertEquals(expected, arena.toString());
    }

    
    
}

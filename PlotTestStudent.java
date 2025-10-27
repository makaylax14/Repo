import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

	@Test
	void testPlot() {
		Plot plot = new Plot();
		assertEquals(1, plot.getWidth());
		assertEquals(1, plot.getDepth());
	}

	@Test
	void testPlotIntIntIntInt() {
		Plot plot = new Plot(1, 3, 1, 2);
		assertEquals(1, plot.getX());
		assertEquals(3, plot.getY());
		assertEquals(1, plot.getWidth());
		assertEquals(2, plot.getDepth());
	}

	@Test
	void testPlotPlot() {
		Plot plot = new Plot(1, 5, 4, 4);
		Plot plot2 = new Plot(plot);
		assertEquals(1, plot2.getX());
		assertEquals(5, plot2.getY());
		assertEquals(4, plot2.getWidth());
		assertEquals(4, plot2.getDepth());
	}

	@Test
	void testGetDepth() {
		Plot plot = new Plot(1, 5, 4, 4);
		assertEquals(4, plot.getDepth());
	}

	@Test
	void testSetDepth() {
		Plot plot = new Plot(1, 5, 4, 4);
		plot.setDepth(3);
		assertEquals(3, plot.getDepth());
	}

	@Test
	void testGetWidth() {
		Plot plot = new Plot(1, 5, 4, 4);
		assertEquals(4, plot.getWidth());
	}

	@Test
	void testSetWidth() {
		Plot plot = new Plot(1, 5, 4, 4);
		plot.setWidth(3);
		assertEquals(3, plot.getWidth());
	}

	@Test
	void testGetX() {
		Plot plot = new Plot(1, 5, 4, 4);
		assertEquals(1, plot.getX());
	}

	@Test
	void testSetX() {
		Plot plot = new Plot(1, 5, 4, 4);
		plot.setX(2);
		assertEquals(2, plot.getX());
	}

	@Test
	void testGetY() {
		Plot plot = new Plot(1, 5, 4, 4);
		assertEquals(5, plot.getY());
	}

	@Test
	void testSetY() {
		Plot plot = new Plot(1, 2, 4, 4);
		assertEquals(2, plot.getY());
	}

	@Test
	void testEncompasses() {
		Plot plot = new Plot(1, 1, 4, 4);
		Plot plot2 = new Plot(2, 2, 1, 1);
		assertEquals(true, plot.encompasses(plot2));
		Plot plot3 = new Plot(6, 1, 2, 3);
		assertEquals(false, plot.encompasses(plot3));
	}

	@Test
	void testOverlaps() {
		Plot plot = new Plot(1, 1, 4, 4);
		Plot plot2 = new Plot(2, 2, 1, 1);
		assertEquals(true, plot.overlaps(plot2));
		Plot plot3 = new Plot(6, 1, 2, 3);
		assertEquals(false, plot.overlaps(plot3));
		Plot plot4 = new Plot(1, 1, 1, 5);
		assertEquals(true, plot.overlaps(plot4));
		Plot plot5 = new Plot(8, 1, 1, 1);
		assertEquals(false, plot.overlaps(plot5));
	}

	@Test
	void testToString() {
		Plot plot = new Plot(1, 6, 4, 3);
		String str = 1+","+6+","+4+","+3;
		assertEquals(str, plot.toString());
	}
	@Test
	void testEquals() {
		Plot plot1 = new Plot(1, 2, 2, 3);
		Plot plot2 = new Plot(6, 1, 1, 3);
		assertEquals(false, plot1.equals(plot2));
		Plot plot3 = new Plot(1, 2, 2, 3);
		assertEquals(true, plot1.equals(plot3));
	}

}

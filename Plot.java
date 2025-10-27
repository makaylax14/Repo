/*
 * Class: CMSC203
 * Project: 4
 * Instructor: Farnaz Eivazi
 * Description: This program allows users to act like property managers. The user can create a management company and
 * add properties to it. They can enter characteristics like the size, name, rent amount, etc. They can also calculate
 * the total rent amount, find the property with the max rent, and view a list of all their properties.
 * Due: 10/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Makayla Lee
 */
import java.util.Objects;

public class Plot {
	private int depth;
	private int width;
	private int x;
	private int y;
	public Plot() {
		width=1;
		depth=1;
	}
	public Plot(int x, int y, int width, int depth) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}
	public Plot(Plot otherPlot) {
		this(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean encompasses(Plot plot) {
		boolean containsOrNot=false;
		
		int highestY,
		lowestY,
		highestX,
		lowestX;
	int topLeftX,
		topLeftY,
		topRightX,
		topRightY,
		bottomLeftX,
		bottomLeftY,
		bottomRightX,
		bottomRightY;
	
	highestY=this.y;
	lowestY=(this.y+depth);
	lowestX=this.x;
	highestX=(this.x+width);
	
	topLeftX=plot.getX();
	topLeftY=plot.getY();
	topRightX=plot.getX()+plot.getWidth();
	topRightY=plot.getY();
	bottomLeftX=plot.getX();
	bottomLeftY=plot.getY()+plot.getDepth();
	bottomRightX=plot.getX()+plot.getWidth();
	bottomRightY=plot.getY()+plot.getDepth();
	
	/* If all these conditions are true (the left and right corners are within the x coordinates of the top and left
	 * corners of the larger plot and the y coordinates are between the largest and smallest y coordinates of the
	 * larger plot), then the given plot must be within the larger plot
	 */
	if (topLeftX>=lowestX && topRightX<=highestX && topLeftY >= highestY && bottomLeftY<=lowestY) {
		containsOrNot=true;
	}
		// False if doesn't encompass, true if it does
		return containsOrNot;
	}
	public boolean overlaps(Plot plot) {
		int highestY,
			lowestY,
			highestX,
			lowestX;
		int topLeftX,
			topLeftY,
			topRightX,
			topRightY,
			bottomLeftX,
			bottomLeftY,
			bottomRightX,
			bottomRightY;
		
		highestY=this.y;
		lowestY=(this.y+depth);
		lowestX=this.x;
		highestX=(this.x+width);
		
		topLeftX=plot.getX();
		topLeftY=plot.getY();
		topRightX=plot.getX()+plot.getWidth();
		topRightY=plot.getY();
		bottomLeftX=plot.getX();
		bottomLeftY=plot.getY()+plot.getDepth();
		bottomRightX=plot.getX()+plot.getWidth();
		bottomRightY=plot.getY()+plot.getDepth();
		
		// Checks if the top left corner of the given plot is on the top left corner of the other plot (this means they have to overlap)
		if (topLeftX==lowestX&&topLeftY==highestY) {
			return true;
		}
		// Checks if the top left corner is inside the this plot
		if (topLeftX>lowestX&&topLeftX<highestX&&topLeftY<lowestY&&topLeftY>highestY) {
			return true;
		}
		// Checks if the top right corner is inside the this plot
		if (topRightX>lowestX&&topRightX<highestX&&topRightY<lowestY&&topRightY>highestY) {
			return true;
		}
		// Checks if the bottom left corner is inside the this plot
		if (bottomLeftX>lowestX&&bottomLeftX<highestX&&bottomLeftY<lowestY&&bottomLeftY>highestY) {
			return true;
		}
		// Checks if the bottom right corner is inside the this plot
		if (bottomRightX>lowestX&&bottomRightX<highestX&&bottomRightY<lowestY&&bottomRightY>highestY) {
			return true;
		}
		// Does the same but the other way around (compares the this plot to the given plot)
		if (highestY<bottomLeftY&&highestY>topLeftY&&lowestX<topRightX&&lowestX>topLeftX) {
			return true;
		}
		if (highestY<bottomLeftY&&highestY>topLeftY&&highestX<topRightX&&highestX>topLeftX) {
			return true;
		}
		if (lowestY<bottomLeftY&&lowestY>topLeftY&&lowestX<topRightX&&lowestX>topLeftX) {
			return true;
		}
		if (lowestY<bottomLeftY&&lowestY>topLeftY&&highestX<topRightX&&highestX>topLeftX) {
			return true;
		}
		// Checks if they are exactly on top of each other
		if (topLeftX==lowestX&&topRightX==highestX&&topLeftY==highestY&&highestY==topRightY&&bottomLeftX==lowestX&&bottomRightX==highestX&&bottomLeftY==lowestY&&bottomRightY==lowestY) {
			return true;
		}
		// Returns false if none of the if statements above are true
		return false;
	}
	@Override
	public String toString() {
		return (x+","+y+","+width+","+depth);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plot other = (Plot) obj;
		return depth == other.depth && width == other.width && x == other.x && y == other.y;
	}
}

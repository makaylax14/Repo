/*
 * This class represents a ticketing office. It
 * has the attributes color, length, width, and buildingType.
 * It also includes methods to manipulate an instance of TicketingOffice.
 */
public class TicketingOffice implements Building {
	//instance variables
    private String color;
    private double length;
    private double width;
    private String buildingType;

    //constructor
    /**
     * This method takes in the parameter values and assigns them to the corresponding attributes. It makes buildingType "Ticketing Office".
     * @param color The color
     * @param length The length
     * @param width The width
     */
    public TicketingOffice(String color, double length, double width) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.buildingType = "Ticketing Office";
    }
    
    /**
     * This method sets the length and width.
     * @param length The length
     * @param width The width
     */
    @Override
	public void setSize(double length, double width) {
    	this.length=length;
    	this.width=width;
    }
    
    /**
     * This method returns length.
     * @return length
     */
    @Override
	public double getLength() {
    	return length;
    }

    /**
     * This method returns width.
     * @return width
     */
    @Override
	public double getWidth() {
    	return width;
    }
    
    /**
     * This method sets the color using a parameter value.
     * @param color
     */
    @Override
	public void setColor(String color) {
    	this.color=color;
    }

    /**
     * This method returns color.
     * @return color
     */
    @Override
	public String getColor() {
    	return color;
    }

    /**
     * This method sets the buildingType.
     * @param type
     */
    @Override
	public void setBuildingType(String type) {
    	buildingType=type;
    }

    /**
     * This method returns buildingType.
     * @return buildingType
     */
    @Override
	public String getBuildingType() {
    	return buildingType;
    }
    
    /**
     * This method returns a String of all the data.
     * @return A String of all the data
     */
    @Override
	public String toString() {
    	return ("Color: "+color+"\nLength: "+length+"\nWidth: "+width+"\nBuilding Type: "+getBuildingType());
    }

}

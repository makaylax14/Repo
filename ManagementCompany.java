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
import java.util.Arrays;
import java.util.Objects;

public class ManagementCompany {
	public static final int MAX_PROPERTY=5;
	private double mgmFeePer;
	public static final int MGMT_DEPTH=10;
	public static final int MGMT_WIDTH=10;
	private String name;
	private int numberOfProperties;
	private Plot plot;
	private Property[] properties;
	private String taxID;
	public ManagementCompany() {
		name="";
		taxID="";
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name=name;
		this.taxID=taxID;
		mgmFeePer=mgmFee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name=name;
		this.taxID=taxID;
		mgmFeePer=mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(ManagementCompany otherCompany) {
		this(otherCompany.getName(), otherCompany.getTaxID(), otherCompany.getMgmFeePer(), otherCompany.getPlot().getX(), otherCompany.getPlot().getY(), otherCompany.getPlot().getWidth(), otherCompany.getPlot().getDepth());
		numberOfProperties=otherCompany.getNumberOfProperties();
		for (int counter = 0; counter < numberOfProperties; counter++) {
			properties[counter].setCity(otherCompany.getProperties()[counter].getCity());
			properties[counter].setOwner(otherCompany.getProperties()[counter].getOwner());
			properties[counter].setPropertyName(otherCompany.getProperties()[counter].getPropertyName());
			properties[counter].setRentAmount(otherCompany.getProperties()[counter].getRentAmount());
			properties[counter].getPlot().setX(otherCompany.getProperties()[counter].getPlot().getX());
			properties[counter].getPlot().setY(otherCompany.getProperties()[counter].getPlot().getY());
			properties[counter].getPlot().setDepth(otherCompany.getProperties()[counter].getPlot().getDepth());
			properties[counter].getPlot().setWidth(otherCompany.getProperties()[counter].getPlot().getWidth());
		}
		
	}
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfProperties() {
		return numberOfProperties;
	}
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	public void setNumberOfProperties(int numberOfProperties) {
		this.numberOfProperties = numberOfProperties;
	}
	public Plot getPlot() {
		return plot;
	}
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	public Property[] getProperties() {
		return properties;
	}
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public static int getMaxProperty() {
		return MAX_PROPERTY;
	}
	public static int getMgmtDepth() {
		return MGMT_DEPTH;
	}
	public static int getMgmtWidth() {
		return MGMT_WIDTH;
	}
	public double getTotalRent() {
		double total = 0;
		for (int count = 0; count < numberOfProperties; count++) {
			total+=properties[count].getRentAmount();
		}
		return total;
	}
	public boolean isManagementFeeValid() {
		if (mgmFeePer>=0 && mgmFeePer<=100) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isPropertiesFull() {
		if (numberOfProperties>=MAX_PROPERTY) {
			return true;
		}
		else {
			return false;
		}
	}
	public void removeLastProperty() {
		// Sets last element in properties to null
		properties[numberOfProperties-1]=null;
	}
	public int addProperty(Property property) {
		boolean overlaps=false;
		for (int count = 0; count < numberOfProperties; count ++) {
			// Checks if property overlaps with any existing properties
			if (property.getPlot().overlaps(properties[count].getPlot())) {
				overlaps=true;
			}
		}
		if (overlaps) {
			return -4;
		}
		// Checks if there cannot be any more properties added
		else if (numberOfProperties==MAX_PROPERTY) {
			return -1;
		}
		// Checks if property is null
		else if (property==null) {
			return -2;
		}
		// Checks if property is inside the plot of the company
		else if (!(plot.encompasses(property.getPlot()))) {
			return -3;
		}
		
		else {
			// Adds the property, increments numberOfProperties, and returns the index at which the property was added at
			properties[numberOfProperties]=new Property(property);
			numberOfProperties++;
			return (numberOfProperties-1);
		}
	}
	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner);
		return addProperty(property);
	}
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(property);
	}
	public Property getHighestRentProperty() {
		Property hasMax = properties[0];
		for (int count = 1; count < numberOfProperties; count++) {
			if (properties[count].getRentAmount()>hasMax.getRentAmount()) {
				hasMax=properties[count];
			}
		}
		return hasMax;
	}
	private int getHighestRentPropertyIndex() {
		int index=0;
		Property hasMax = properties[0];
		for (int count = 1; count < numberOfProperties; count++) {
			if (properties[count].getRentAmount()>hasMax.getRentAmount()) {
				hasMax=properties[count];
				index=count;
			}
		}
		return index;
	}
	@Override
	public String toString() {
		double totalMgmFee = 0;
		String str="List of the properties for "+name+", taxID: "+taxID+"\n______________________________________________________\n";
		for (int count = 0; count < numberOfProperties; count++) {
			str+=properties[count].toString()+"\n";
		}
		str+="______________________________________________________\n\n";
		str+=" total management Fee: ";
		for (int count = 0; count < numberOfProperties; count++) {
			totalMgmFee+=properties[count].getRentAmount()*(mgmFeePer/100);
		}
		str+=String.format("%.2f", totalMgmFee);
		return str;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManagementCompany other = (ManagementCompany) obj;
		return Double.doubleToLongBits(mgmFeePer) == Double.doubleToLongBits(other.mgmFeePer)
				&& Objects.equals(name, other.name) && numberOfProperties == other.numberOfProperties
				&& Objects.equals(plot, other.plot) && Arrays.equals(properties, other.properties)
				&& Objects.equals(taxID, other.taxID);
	}
}

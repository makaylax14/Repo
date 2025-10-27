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

public class Property {
	private String city;
	private String owner;
	private Plot plot;
	private String propertyName;
	private double rentAmount;
	public Property() {
		city="";
		owner="";
		plot=new Plot();
		propertyName="";
	}
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.city=city;
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		this.owner=owner;
		plot=new Plot();
	}
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.city=city;
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		this.owner=owner;
		plot = new Plot(x, y, width, depth);
	}
	public Property(Property otherProperty) {
		this.city=otherProperty.getCity();
		this.owner=otherProperty.getOwner();
		this.propertyName=otherProperty.getPropertyName();
		this.rentAmount=otherProperty.getRentAmount();
		plot = new Plot(otherProperty.getPlot());
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Plot getPlot() {
		return plot;
	}
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	@Override
	public String toString() {
		return String.format(propertyName+","+city+","+owner+",%.1f", rentAmount);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		return Objects.equals(city, other.city) && Objects.equals(owner, other.owner)
				&& Objects.equals(plot, other.plot) && Objects.equals(propertyName, other.propertyName)
				&& Double.doubleToLongBits(rentAmount) == Double.doubleToLongBits(other.rentAmount);
	}
}

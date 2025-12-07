/*
 * This class represents a Dog. It has
 * the attributes name, age, species, and color.
 * It includes methods to manipulate an instance of it.
 */
import java.util.Objects;

public class Dog implements Animal, Cloneable {
    // Instance variables
    private String name;
    private int age;
    protected String species;
    protected String color;

    // Constructor
    /**
     * This method assigns the parameter values to the corresponding attributes.
     * @param name
     * @param age
     * @param species
     * @param color
     */
    public Dog(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }
    
    /**
     * This method returns species.
     * @return species
     */
    public String getSpecies() {
    	return species;
    }

    /**
     * This method returns color.
     * @return color
     */
    public String getColor() {
    	return color;
    }
    
    /**
     * This method prints the action of a dog.
     */
    @Override
	public void move() {
    	System.out.println("Dog walks");
    }
	
    /**
     * This method prints the sound of a dog.
     */
    @Override
	public void makeSound() {
    	System.out.println("Bark");
    }

    /**
     * This method returns name.
     * @return name
     */
    @Override
	public String getName() {
    	return name;
    }
	
    /**
     * This method returns age.
     * @return age
     */
    @Override
	public int getAge() {
    	return age;
    }

    /**
     * This method makes a shallow copy of a Dog object.
     * @return A shallow copy of the object
     */
    @Override
	public Object clone() throws CloneNotSupportedException {
    	return super.clone();
    }

    /**
     * This method checks if two Dogs are equal.
     * @return True or false
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return (age == other.age && Objects.equals(color, other.color) && Objects.equals(name, other.name)
				&& Objects.equals(species, other.species));
	}

	/**
     * This method returns a String of all the data.
     * @return A String of all the data
     */
    @Override
	public String toString() {
    	return ("Name: "+name+"\nAge: "+age+"\nSpecies: "+species+"\nColor: "+getColor());
    }
    
}    

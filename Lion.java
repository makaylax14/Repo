/*
 * This class represents a Lion. It has
 * the attributes name, age, species, and color.
 * It includes methods to manipulate an instance of it.
 */
import java.util.Objects;

public class Lion implements Animal, Cloneable {
	//instance variables
    private String name;
    private int age;
    private String species;
    private String color;

    //constructor
    /**
     * This method assigns the parameter values to the corresponding attributes.
     * @param name
     * @param age
     * @param species
     * @param color
     */
    public Lion(String name, int age, String species, String color) {
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
     * This method prints the action of a lion.
     */
    @Override
	public void move() {
    	System.out.println("Lion strides");
    }
	
    /**
     * This method prints the sound of a lion.
     */
    @Override
	public void makeSound() {
    	System.out.println("Roar");
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
     * This method makes a shallow copy of a Lion object.
     * @return A shallow copy of the object
     */
    @Override
	public Object clone() throws CloneNotSupportedException {
    	return super.clone();
    }

    /**
     * This method checks if two Lions are equal.
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
		Lion other = (Lion) obj;
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

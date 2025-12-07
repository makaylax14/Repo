/*
 * This class represents a Circus. It has
 * the attributes animals, persons, buildings, and tickets.
 * It includes methods to manipulate an instance of it.
 */
import java.util.ArrayList;
import java.util.List;

public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;
    private List<Ticket> tickets;

    /**
     * This method instantiates array lists for animals, persons, buildings, and tickets.
     */
    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    /**
     * This method adds a building to buildings.
     * @param building A Building object
     */
    public void addBuilding(Building building) {
    	buildings.add(building);
    }

    /**
     * This method displays all buildings in buildings
     * @return A String of all the buildings' data
     */
    public String displayAllBuildings(){
    	StringBuilder str = new StringBuilder();
    	for (Building val : buildings) {
    		System.out.println(val.toString());
    		str.append(val.toString());
    		str.append("\n");
    	}
    	return str.toString();
    }
    
    /**
     * This method returns buildings.
     * @return buildings
     */
    public List<Building> getBuildings(){
    	return buildings;
    }

    /**
     * This method returns persons.
     * @return persons
     */
    public List<Person> getPersons(){
    	return persons;
    }
    
    /**
     * This method adds a Person to persons.
     * @param person
     */
    public void addPerson(Person person) {
    	persons.add(person);
    }

    /**
     * This method displays all elements in persons.
     * @return A String of all the elements' data
     */
    public String displayAllPersons() {
    	StringBuilder str = new StringBuilder();
    	for (Person val : persons) {
    		System.out.println(val.toString());
    		str.append(val.toString());
    		str.append("\n");
    	}
    	return str.toString();
    }

    /**
     * This method adds an Animal to animals.
     * @param animal
     */
   public void addAnimal(Animal animal) {
	   animals.add(animal);
   }

   /**
    * This method displays everything in animals.
    * @return A String of all the data for animals
    */
   public String displayAllAnimals() {
	   StringBuilder str = new StringBuilder();
	   for (Animal val : animals) {
		   System.out.println(val.toString());
		   str.append(val.toString());
		   str.append("\n");
	   }
	   return str.toString();
   }
   
   /**
    * This method returns animals.
    * @return animals
    */
   public List<Animal> getAnimals(){
	   return animals;
   }

   /**
    * This method sorts animals by age.
    */
   	public void sortAnimalsByAge() {
   		int startScan, index, minIndex;
   		Animal minValue;
   		for (startScan = 0; startScan < (animals.size()-1); startScan++) {
   			minIndex=startScan;
   			minValue=animals.get(startScan);
   			for (index = startScan+1; index < animals.size(); index++) {
   				if (animals.get(index).getAge()<minValue.getAge()) {
   					minValue=animals.get(index);
   					minIndex=index;
   				}
   			}
   			animals.set(minIndex, animals.get(startScan));
   			animals.set(startScan, minValue);
   		}
   	}
    
   	/**
   	 * This method sorts animals by name.
   	 */
    public void sortAnimalsByName() {
    	int startScan, index, minIndex;
   		Animal minValue;
   		for (startScan = 0; startScan < (animals.size()-1); startScan++) {
   			minIndex=startScan;
   			minValue=animals.get(startScan);
   			for (index = startScan+1; index < animals.size(); index++) {
   				if ((animals.get(index).getName()).compareTo(minValue.getName())<0) {
   					minValue=animals.get(index);
   					minIndex=index;
   				}
   			}
   			animals.set(minIndex, animals.get(startScan));
   			animals.set(startScan, minValue);
   		}
    }
    
    /**
     * This method looks for an animal using its name.
     * @param name The name
     * @return The index it was found at or negative one if it was not found
     */
    public int searchAnimalByName(String name) {
    	int count = 0;
    	for (Animal val : animals) {
    		if (val.getName().equals(name)) {
    			System.out.println("Animal found!");
    			return count;
    		}
    		count++;
    	}
    	System.out.println("Animal not found!");
    	return -1;
    }
    
    /**
     * This method adds a Ticket to tickets.
     * @param ticket A Ticket object
     */
    public void addTicket(Ticket ticket) {
    	tickets.add(ticket);
    }

    /**
     * This method returns tickets.
     * @return tickets
     */
    public List<Ticket> getTickets(){
    	return tickets;
    }
    
    /**
     * This method displays everything in tickets.
     * @return A String representing all the data in tickets
     */
    public String displayAllTickets() {
    	StringBuilder str = new StringBuilder();
 	   for (Ticket val : tickets) {
 		   System.out.println(val.toString());
 		   str.append(val.toString());
 		   str.append("\n");
 	   }
 	   return str.toString();
    }
    
    /**
     * This method generates a ticket and returns it.
     * @param dayOfWeek The day of the week
     * @param basePrice The base price
     * @param age The age
     * @return A Ticket
     */
    public Ticket generateTicket(String dayOfWeek, double basePrice, int age) {
        Ticket ticket = new Ticket(dayOfWeek, basePrice, age);  // Pass dayOfWeek, basePrice, age to Ticket constructor
        addTicket(ticket);
        return ticket;
    }
}

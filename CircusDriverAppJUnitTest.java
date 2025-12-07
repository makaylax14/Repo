import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CircusDriverAppJUnitTest {
    private Circus circus;

    @BeforeEach
    void setUp() {
        circus = new Circus();
    }
    
    @Test
    void testAddDog() {
        Dog dog = new Dog("Shila", 3, "Golden Retriever", "Brown");
        circus.addAnimal(dog);
        List<Animal> animals = circus.getAnimals();
        assertEquals(1, animals.size());
        assertTrue(animals.get(0) instanceof Dog);
        assertEquals("Shila", animals.get(0).getName());
    }

    @Test
    void testAddBird() {
    	Bird bird = new Bird("Bob", 2, "Pigeon", "Gray");
    	circus.addAnimal(bird);
    	List<Animal> animals=circus.getAnimals();
    	assertEquals(1, animals.size());
    	assertTrue(animals.get(0) instanceof Bird);
    	assertEquals("Bob", animals.get(0).getName());
    }

    @Test
    void testDisplayAnimals() {
    	Dog dog = new Dog("Shila", 3, "Golden Retriever", "Brown");
        circus.addAnimal(dog);
        Bird bird = new Bird("Bob", 2, "Pigeon", "Gray");
    	circus.addAnimal(bird);
    	String str = "Name: Shila\nAge: 3\nSpecies: Golden Retriever\nColor: Brown\nName: Bob\nAge: 2\nSpecies: Pigeon\nColor: Gray\n";
    	assertEquals(str, circus.displayAllAnimals());
    }

    @Test
    void testSortAnimalsByAge() {
    	Dog dog = new Dog("Shila", 3, "Golden Retriever", "Brown");
        circus.addAnimal(dog);
        Bird bird = new Bird("Bob", 2, "Pigeon", "Gray");
        circus.addAnimal(bird);
        circus.sortAnimalsByAge();
        List<Animal> animals=circus.getAnimals();
        assertEquals(2, animals.get(0).getAge());
        assertEquals(3, animals.get(1).getAge());
    }

    @Test
    void testSortAnimalsByName() {
    	Dog dog = new Dog("Shila", 3, "Golden Retriever", "Brown");
        circus.addAnimal(dog);
        Bird bird = new Bird("Bob", 2, "Pigeon", "Gray");
        circus.addAnimal(bird);
        circus.sortAnimalsByName();
        List<Animal> animals=circus.getAnimals();
        assertEquals("Bob", animals.get(0).getName());
        assertEquals("Shila", animals.get(1).getName());
    }

    @Test
    void testSearchAnimalByName() {
    	Dog dog = new Dog("Shila", 3, "Golden Retriever", "Brown");
        circus.addAnimal(dog);
        Bird bird = new Bird("Bob", 2, "Pigeon", "Gray");
        circus.addAnimal(bird);
        Lion lion = new Lion("John", 4, "Cub", "Orange");
        circus.addAnimal(lion);
        int num = circus.searchAnimalByName("John");
        assertEquals(2, num);
    }

     @Test
     void testAddAndDisplayTickets() {
    	 Ticket ticket = new Ticket("monday", 20, 7);
    	 circus.addTicket(ticket);
    	 List<Ticket> tickets = circus.getTickets();
    	 assertEquals(1, tickets.size());
         assertTrue(tickets.get(0) instanceof Ticket);
         assertEquals("monday", tickets.get(0).getDayOfWeek());
         String str = "Ticket [Day: Monday, Age: 7, Price: $16.20]\n";
         assertEquals(str, circus.displayAllTickets());
     }
}




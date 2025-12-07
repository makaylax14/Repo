/*
 * This class represents a ticket. It has
 * the attributes basePrice, dayOfWeek, and age.
 * It also has methods to manipulate an instance of Ticket.
 */
public class Ticket {
    private double basePrice;
    private String dayOfWeek;
    private int age;

    /**
     * This method takes in values and assigns them to the corresponding attributes.
     * @param dayOfWeek The day of the week
     * @param basePrice The base price
     * @param age The age
     */
    public Ticket(String dayOfWeek, double basePrice, int age) {
        this.basePrice = basePrice;
        this.age = age;
        this.dayOfWeek = dayOfWeek.toLowerCase();
    }

    /**
     * This method returns dayOfWeek.
     * @return dayOfWeek
     */
    public String getDayOfWeek() {
    	return dayOfWeek;
    }
    
    /**
     * This method returns basePrice.
     * @return basePrice
     */
    public double getBasePrice() {
    	return basePrice;
    }
    
    /**
     * This method returns age.
     * @return age
     */
    public int getAge() {
    	return age;
    }
    
    /**
     * This method calculates the price based on the day of the week and the age of the customer.
     * @return finalPrice
     */
    public double calculatePrice() {
    	double finalPrice=basePrice;
    	if (!dayOfWeek.equals("sunday") && !(dayOfWeek.equals("saturday"))) {
    		finalPrice=.90*finalPrice;
    	}
    	if (age<18) {
    		finalPrice=.90*finalPrice;
    	}
    	if (age>=65) {
    		finalPrice=.95*finalPrice;
    	}
    	return finalPrice;
    }

    // Display the ticket details
    /**
     * This method displays the details of the ticket.
     */
    public void displayTicketDetails() {
        System.out.printf("Ticket Details: [Age: %d, Day: %s, Price: $%.2f]%n",
                          age, dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), calculatePrice());
    }

    /**
     * This method displays the data about the Ticket instance.
     * @return A String with all the data
     */
    @Override
    public String toString() {
        return String.format("Ticket [Day: %s, Age: %d, Price: $%.2f]",
                             dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), 
                             age, calculatePrice());
    }
}

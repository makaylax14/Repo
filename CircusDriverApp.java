/*
 * Class: CMSC203
 * Project: 6
 * Instructor: Farnaz Eivazi
 * Description: This class contains methods that allow the user to select
 * an option out of 11 possible options.
 * It imitates a circus and allows users to do things like generate tickets
 * and add animals.
 * Due: 12/8/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Makayla Lee
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class CircusDriverApp {
	/**
	 * This method is the main method and is where the program begins.
	 * @param args An optional String[]
	 */
    public static void main(String[] args) {
        Circus circus = new Circus();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Bob's Circus Management System!");

        while (!exit) {
            try {
                // Display menu
                System.out.println("\nMenu:");
                System.out.println("1. Add Animal");
                System.out.println("2. Add Person");
                System.out.println("3. Add Building");
                System.out.println("4. Generate Ticket");
                System.out.println("5. Display All Animals");
                System.out.println("6. Display All Persons");
                System.out.println("7. Display All Buildings");
                System.out.println("8. Sort Animals by Age");
                System.out.println("9. Sort Animals by Name");
                System.out.println("10. Search Animal by Name");
                System.out.println("11. Exit\n");

                System.out.print("Choose an option: ");
              
                // Use validateInput method
                int choice = 0;
                boolean validInput = false;

                // Retry until valid input is received
                while (!validInput) {
                    try {
                        choice=validateInput(scanner);
                        validInput=true;
                    } catch (CustomInputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.print("Choose an option: ");
                    }
                }
   

                switch (choice) {
                    case 1:
                        handleAddAnimal(circus, scanner);
                        break;
                    case 2:
                        handleAddPerson(circus, scanner);
                        break;
                    case 3:
                        handleAddBuilding(circus, scanner);
                        break;
                    case 4:
                        handleGenerateTicket(scanner);
                        break;
                    case 5:
                        System.out.println("Displaying all animals:");
                        System.out.println("----------------------");
                        circus.displayAllAnimals();
                        break;
                    case 6:
                        System.out.println("Displaying all persons:");
                        System.out.println("----------------------");
                        circus.displayAllPersons();
                        break;
                    case 7:
                        System.out.println("Displaying all buildings:");
                        System.out.println("------------------------");
                        circus.displayAllBuildings();
                        break;
                    case 8:
                        System.out.println("Sorting animals by age...");
                        circus.sortAnimalsByAge();
                        System.out.println("Animals sorted by age.");
                        break;
                    case 9:
                        System.out.println("Sorting animals by name...");
                        circus.sortAnimalsByName();
                        System.out.println("Animals sorted by name.");
                        break;                       
                    case 10:
                        System.out.print("Enter the name of the animal to search: ");
                        scanner.nextLine(); // Consume the leftover newline
                        String searchName = scanner.nextLine();
                        circus.searchAnimalByName(searchName);
                        break;
                    case 11:
                        exit = true;
                        System.out.println("Exiting Bob's Circus Management System. Goodbye!\n");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
       
                } catch (Exception e) {
		            System.out.println("An unexpected error occurred: " + e.getMessage());
		            e.printStackTrace();
                } 
            
        }

        scanner.close();
    }

    
    /**
     * This method checks if the input is an int.
     * @param scanner A Scanner
     * @return scanner.nextInt()
     * @throws CustomInputMismatchException
     */
    private static int validateInput(Scanner scanner) throws CustomInputMismatchException {
        try {
        	// Tests if it input an int
            return scanner.nextInt();
        } catch (InputMismatchException e) {
        	scanner.nextLine();
            throw new CustomInputMismatchException("Invalid input type!");
        }
    }
    /**
     * This method allows the user to add an Animal to animals.
     * @param circus An instance of Circus
     * @param scanner A Scanner
     */
    private static void handleAddAnimal(Circus circus, Scanner scanner) {
    	System.out.print("Enter animal type: \n1. Bird\n2. Dog\n3. Horse\n4. Lion\n");
    	
    	 int choice = 0;
         boolean validInput = false;
         // Checks if input is valid
         while (!validInput) {
             try {
                 choice=validateInput(scanner);
                 switch(choice) {
                 case 1:
                 case 2:
                 case 3:
                 case 4:
                	 validInput=true;
                	 break;
                 default:
                	System.out.println("Invalid option. Please choose again.");
                 }
             } catch (CustomInputMismatchException e) {
                 System.out.println(e.getMessage());
                 System.out.print("Choose an option: ");
             }
         }
        scanner.nextLine();
        // Asks for attributes
    	System.out.print("Enter name: ");
    	String name = scanner.nextLine();
    	System.out.print("Enter age: ");
    	int age = scanner.nextInt();
    	scanner.nextLine();
    	System.out.print("Enter species: ");
    	String species = scanner.nextLine();
    	System.out.print("Enter color: ");
    	String color = scanner.nextLine();
    	Animal animal=null;
    	switch (choice) {
    	case 1:
    		animal=new Bird(name, age, species, color);
    		break;
    	case 2:
    		animal=new Dog(name, age, species, color);
    		break;
    	case 3:
    		animal=new Horse(name, age, species, color);
    		break;
    	case 4:
    		animal=new Lion(name, age, species, color);
    		break;
    	}
    	circus.addAnimal(animal);
    }
	
    /**
     * This method allows the user to add a Person to persons.
     * @param circus An instance of Circus
     * @param scanner A Scanner
     */
    private static void handleAddPerson(Circus circus, Scanner scanner) {
    	System.out.print("Enter person type: \n1. Clerk\n2. Acrobatic\n");
    	int choice = 0;
        boolean validInput = false;
        // Checks if input is valid
        while (!validInput) {
            try {
                choice=validateInput(scanner);
                switch(choice) {
                case 1:
                case 2:
                	validInput=true;
                	break;
                default:
                	System.out.println("Invalid option. Please choose again.");
                }
            } catch (CustomInputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.print("Choose an option: ");
            }
        }
        scanner.nextLine();
        // Asks for attributes
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter years worked: ");
        int yearsWorked = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter job: ");
        String job = scanner.nextLine();
        Person person = null;
        switch (choice) {
        case 1:
        	person=new Clerk(name, age, yearsWorked, job);
        	break;
        case 2:
        	person=new Acrobatic(name, age, yearsWorked, job);
        	break;
        }
        circus.addPerson(person);
        
    }
    
    /**
     * This method allows the user to add a Building to buildings.
     * @param circus An instance of Circus
     * @param scanner A Scanner
     */
    private static void handleAddBuilding(Circus circus, Scanner scanner) {
    	System.out.println("Enter building type: \n1. Arena\n2. Ticketing Office\n");
    	int choice = 0;
        boolean validInput = false;
        // Checks if input is valid
        while (!validInput) {
            try {
                choice=validateInput(scanner);
                switch(choice) {
                case 1:
                case 2:
                	validInput=true;
               	 	break;
                default:
                	System.out.println("Invalid option. Please choose again.");
                }
            } catch (CustomInputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.print("Choose an option: ");
            }
        }
        scanner.nextLine();
        // Asks for attributes
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width: ");
        double width = scanner.nextDouble();
        Building building = null;
        switch (choice) {
        case 1:
        	building=new Arena(color, length, width);
        	break;
        case 2:
        	building=new TicketingOffice(color, length, width);
        	break;
        }
        circus.addBuilding(building);
    }




    /**
     * This method allows the user to pick their preferences for their ticket and calculates the price they need to pay.
     * @param scanner A Scanner
     */
    private static void handleGenerateTicket(Scanner scanner) {
        double totalAmount = 0;
        double basePrice,
        	ticketPrice,
        	discountAmount;
        StringBuilder ticketDetails = new StringBuilder();
        boolean addMoreTickets = true;
        int age=0;

        System.out.print("\nEnter ticket base price: ");
        basePrice = scanner.nextDouble();
        scanner.nextLine();

        ticketDetails.append(String.format("Regular ticket price: $%.2f%n%n", basePrice));

        while (addMoreTickets) {
            // Select day of the week
            System.out.println("\nSelect day of the week:");
            for (int i = 0; i < DayOfWeek.values().length; i++) {
                DayOfWeek day = DayOfWeek.values()[i];
                if (day.getDiscount() > 0) {
                    System.out.printf("%d. %s (%.0f%% discount)%n", i + 1, day, day.getDiscount() * 100);
                } else {
                    System.out.printf("%d. %s%n", i + 1, day);
                }
            }
            System.out.print("\nEnter your choice: ");
            int dayChoice = scanner.nextInt();
            scanner.nextLine();

            if (dayChoice < 1 || dayChoice > DayOfWeek.values().length) {
                System.out.println("Invalid choice. Please select a valid day.");
                continue;
            }

            DayOfWeek selectedDay = DayOfWeek.values()[dayChoice - 1];
            double dayDiscount = selectedDay.getDiscount();

            // Select customer type
            System.out.println("\nEnter customer type:");
            System.out.println("1. Child (10% discount)");
            System.out.println("2. Student (10% discount)");
            System.out.println("3. Adult");
            System.out.println("4. Senior (5% discount)");
            System.out.print("\nEnter your choice: ");
            int customerType = scanner.nextInt();
            scanner.nextLine();

            double customerDiscount = 0.0;
            String customerTypeName = "";
            switch (customerType) {
                case 1:
                    customerDiscount = 0.10;
                    customerTypeName = "child";
                    age=10;
                    break;
                case 2:
                    customerDiscount = 0.10;
                    customerTypeName = "student";
                    age=10;
                    break;
                case 3:
                    customerTypeName = "adult";
                    break;
                case 4:
                    customerDiscount = 0.05;
                    customerTypeName = "senior";
                    age=70;
                    break;
                default:
                    System.out.println("Invalid customer type. Please try again.");
                    continue;
            }

            // Select seat location
            System.out.println("\nSeat Location in the Arena:");
            System.out.println("1. Lower level");
            System.out.println("2. T-level (double ticket price)");
            System.out.println("3. Upper level (5% discount)");
            System.out.print("\nEnter your choice: ");
            int seatLocation = scanner.nextInt();
            scanner.nextLine();

            double seatMultiplier = (seatLocation == 2) ? 2.0 : 1.0;
            double seatDiscount = (seatLocation == 3) ? 0.05 : 0.0;

            System.out.print("Enter number of tickets: ");
            int numberOfTickets = scanner.nextInt();
            scanner.nextLine();

            // Assigns a String based on the day of the week the user picked
            String dayOfWeekStr="";
            switch(selectedDay) {
            case MONDAY:
            	dayOfWeekStr="monday";
            	break;
            case TUESDAY:
            	dayOfWeekStr="tuesday";
            	break;
            case WEDNESDAY:
            	dayOfWeekStr="wednesday";
            	break;
            case THURSDAY:
            	dayOfWeekStr="thursday";
            	break;
            case FRIDAY:
            	dayOfWeekStr="friday";
            	break;
            case SATURDAY:
            	dayOfWeekStr="saturday";
            	break;
            case SUNDAY:
            	dayOfWeekStr="sunday";
            	break;
            }
            
            // Calculates the discount amount and applies discounts
            discountAmount=dayDiscount+customerDiscount+seatDiscount;
            ticketPrice=basePrice*seatMultiplier;
            ticketPrice=ticketPrice*(1-discountAmount);
            ticketPrice=ticketPrice*numberOfTickets;


            // Add to total amount
            totalAmount+=ticketPrice;

            // Append details of this batch to the ticket details
            ticketDetails.append(String.format("%d %s $%.2f ", numberOfTickets, customerTypeName, ticketPrice));
            ticketDetails.append("(Day: "+selectedDay);
            if (dayDiscount==.1) {
            	ticketDetails.append(String.format(", Day Discount: %.0f", (dayDiscount*100)));
            	ticketDetails.append("%");
            }
            if (customerDiscount>0) {
            	ticketDetails.append(String.format(", Customer Type Discount: %.0f", (customerDiscount*100)));
            	ticketDetails.append("%");
            }
            if (seatDiscount>0) {
            	ticketDetails.append(String.format(", Seat Type Discount: %.0f", (seatDiscount*100)));
            	ticketDetails.append("%");
            }
            
            
            ticketDetails.append(")\n");

            for (int count = 0; count < numberOfTickets; count++) {
            	Ticket ticket = new Ticket(dayOfWeekStr, basePrice, age);
            }
            
            // Ask user to add more tickets
            System.out.print("\nDo you want to add more tickets? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            addMoreTickets = response.equals("y");
        }

        // Display ticket calculation details
        System.out.println("\nTicket Calculation Details:");
        System.out.println("---------------------------");
        System.out.println(ticketDetails);

        // Display final total amount
        System.out.printf("Final Total Amount: $%.2f%n", totalAmount);
        System.out.println("Enjoy the show!");
    }


   
}

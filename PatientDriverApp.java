/*
 * Class: CMSC203
 * Project: 2
 * Instructor: Farnaz Eivazi
 * Description: This program accepts user input regarding their basic information (such as their name and address). Then, it asks them to enter
 * data about 3 different procedures and prints their information and procedure data. Finally, it calculates the total cost for all 3 procedures.
 * Due: 9/29/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Makayla Lee
 */
import java.util.Scanner;

/*
 * The class, PatientDriverApp, creates instances of Patient
 * and Procedure. It interacts with these objects by using their
 * methods and ultimately prints the patient's and procedures' information.
 */
public class PatientDriverApp {
	/*
	 * The main method is the entry point for the program. In this method, the program prompts the user for their basic information as well as
	 * information regarding three procedures. Then, it uses the input to create an instance of Patient and three instances of Procedure. Finally,
	 * it prints the data for these instances.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String firstName,
			middleName,
			lastName,
			street,
			city,
			state,
			phoneNumber,
			emergencyName,
			emergencyNumber,
			procName1,
			procName2,
			procName3,
			date1,
			date2,
			date3,
			practName1,
			practName2,
			practName3;
		int zipCode=0;
		double cost1=0.0,
			cost2=0.0,
			cost3=0.0;
		boolean validInput=false;
		// Prompts the user for their basic information and accepts their input
		System.out.print("Enter first name: ");
		// Validates input (makes sure it is a string)
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter first name: ");
		}
		firstName=scanner.nextLine();
		System.out.print("Enter middle name: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter middle name: ");
		}
		middleName=scanner.nextLine();
		System.out.print("Enter last name: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter last name: ");
		}
		lastName=scanner.nextLine();
		/*
		 * Makes sure street address ends with a character (to ensure it is a string) while allowing numbers at the beginning.
		 * Also ensures the input is not a boolean.
		 */
		do {
			System.out.print("Enter street address: ");
			street=scanner.nextLine();
		} while (!(street.charAt(street.length()-1) > 'A' && street.charAt(street.length()-1) < 'Z' || street.charAt(street.length()-1) > 'a' && street.charAt(street.length()-1) < 'z') || street=="True" || street=="true" || street=="false" || street=="False");
		System.out.print("Enter city: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter city: ");
		}
		city=scanner.nextLine();
		System.out.print("Enter state: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter state: ");
		}
		state=scanner.nextLine();
		// Validates zipCode and makes sure it is an int between 0501 (the lowest possible zip code) and 99950 (the highest possible zip code)
		do {
			System.out.print("Enter zip code: ");
			if (scanner.hasNextInt()) {
				zipCode=scanner.nextInt();
			}
			else {
				scanner.nextLine();
			}
		} while (zipCode < 0501 || zipCode > 99950);
		scanner.nextLine();
		System.out.print("Enter your phone number: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter your phone number: ");
		}
		phoneNumber=scanner.nextLine();
		System.out.print("Enter an emergency contact name: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter an emergency contact name: ");
		}
		emergencyName=scanner.nextLine();
		System.out.print("Enter the emergency contact's phone number: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter the emergency contact's phone number: ");
		}
		emergencyNumber=scanner.nextLine();
		// Instantiates a Patient variable and uses the user's input to initialize its instance variables
		Patient patient1 = new Patient(firstName, middleName, lastName, street, city, state, zipCode, phoneNumber, emergencyName, emergencyNumber);
		// Prompts for information about the procedures
		System.out.print("Enter procedure #1 name: ");
		// Validates whether it is a string and repeats prompt if it isn't
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			// Stores the input
			System.out.print("Enter procedure #1 name: ");
		}
		procName1=scanner.nextLine();
		System.out.print("Enter date: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter date: ");
		}
		date1=scanner.nextLine();
		System.out.print("Enter practitioner name: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter practitioner name: ");
		}
		practName1=scanner.nextLine();
		// Validates the data type of cost (checks if it is a double)
		do {
			System.out.print("Enter cost: ");
			if (scanner.hasNextDouble()) {
				// Assigns true if the input is a double
				validInput=true;
				cost1=scanner.nextDouble();
			}
			else {
				scanner.nextLine();
			}
		// Makes sure the user doesn't enter a negative value
		} while (cost1 < 0 || validInput==false);
		// Resets validInput to false
		validInput=false;
		scanner.nextLine();
		// Repeats the steps for procedure #2
		System.out.print("Enter procedure #2 name: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter procedure #2 name: ");
		}
		procName2=scanner.nextLine();
		System.out.print("Enter date: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter date: ");
		}
		date2=scanner.nextLine();
		System.out.print("Enter practitioner name: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter practitioner name: ");
		}
		practName2=scanner.nextLine();
		do {
			System.out.print("Enter cost: ");
			if (scanner.hasNextDouble()) {
				validInput=true;
				cost2=scanner.nextDouble();
			}
			else {
				scanner.nextLine();
			}
		} while (cost2 < 0 || validInput==false);
		validInput=false;
		scanner.nextLine();
		// Repeats the steps for procedure #3
		System.out.print("Enter procedure #3 name: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter procedure #3 name: ");
		}
		procName3=scanner.nextLine();
		System.out.print("Enter date: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter date: ");
		}
		date3=scanner.nextLine();
		System.out.print("Enter practitioner name: ");
		while (scanner.hasNextByte() || scanner.hasNextShort() || scanner.hasNextInt() || scanner.hasNextLong() || scanner.hasNextFloat() || scanner.hasNextDouble() || scanner.hasNextBoolean()) {
			scanner.nextLine();
			System.out.print("Enter practitioner name: ");
		}
		practName3=scanner.nextLine();
		do {
			System.out.print("Enter cost: ");
			if (scanner.hasNextDouble()) {
				validInput=true;
				cost3=scanner.nextDouble();
			}
			else {
				scanner.nextLine();
			}
		} while (cost3 < 0 || validInput==false);	
		scanner.nextLine();
		// Instantiates first procedure using no-arg constructor
		Procedure procedure1 = new Procedure();
		// Assigns values to the instance variables
		procedure1.setProcedureName(procName1);
		procedure1.setDate(date1);
		procedure1.setPractitionerName(practName1);
		procedure1.setCost(cost1);
		// Instantiates second procedure using constructor that takes in two arguments
		Procedure procedure2 = new Procedure(procName2, date2);
		// Assigns values to the other two instance variables
		procedure2.setPractitionerName(practName2);
		procedure2.setCost(cost2);
		// Instantiates third procedure using constructor that takes in arguments for all instance variables
		Procedure procedure3 = new Procedure(procName3, date3, practName3, cost3);
		// Displays patient's information
		displayPatient(patient1);
		// Displays information about all three procedures
		displayProcedure(procedure1);
		displayProcedure(procedure2);
		displayProcedure(procedure3);
		// Calculates and prints the total cost
		System.out.printf("Total Charges: $%,.2f", calculateTotalCharges(procedure1, procedure2, procedure3));
		System.out.println("");
		System.out.println("");
		// Prints programmer's information
		System.out.println("Student Name: Makayla Lee");
		System.out.println("MC#: M21192283");
		System.out.println("Due Date: 09/29/2025");
		System.out.println("");
		System.out.println("The program was developed by a Student: Makayla Lee 09/29/2025");
		scanner.close();
	}
	/*
	 * The method below, displayPatient, receives
	 * obj as an argument, a variable of type Patient,
	 * and prints the instance variables values for that instance.
	 */
	public static void displayPatient(Patient obj) {
		System.out.println("Patient info:");
		System.out.println(obj);
		System.out.println("");
	}
	/*
	 * The method below, displayProcedure, receives
	 * obj as an argument, a variable of type Procedure,
	 * and prints the instance variables values for that instance.
	 */
	public static void displayProcedure(Procedure obj) {
		System.out.println(obj);
		System.out.println("");
	}
	/*
	 * The method below, calculateTotalCharges, accepts three arguments
	 * of type Procedure, and gets the cost of each. It adds them up and
	 * returns the value.
	 */
	public static double calculateTotalCharges(Procedure obj1, Procedure obj2, Procedure obj3) {
		return (obj1.getCost()+obj2.getCost()+obj3.getCost());
	}
}

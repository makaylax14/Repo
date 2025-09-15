/*
 * Class: CMSC203
 * Project: 1
 * Instructor: Farnaz Eivazi
 * Description: This program plays a game with the user. It asks the user how many colors they want to use in the game and the user tries to guess
 * the color. The user's score is revealed at the end.
 * Due: 9/15/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Makayla Lee
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.*;

public class ESPGame {
	public static void main(String[] args) throws IOException{
		int score=0,
				compsNum,
				answer=0,
				numOfLinesUserPicked=0;
		final int NUM_OF_ROUNDS=3;
		String compsColor="",
			usersGuess,
			playAgain="Yes",
			usersName,
			usersDescription,
			dueDate,
			fileName;
		final String COLOR_BLACK="Black",
			COLOR_WHITE="White",
			COLOR_GRAY="Gray",
			COLOR_SILVER="Silver",
			COLOR_MAROON="Maroon",
			COLOR_RED="Red",
			COLOR_PURPLE="Purple",
			COLOR_FUCHSIA="Fuchsia",
			COLOR_GREEN="Green",
			COLOR_LIME="Lime",
			COLOR_OLIVE="Olive",
			COLOR_YELLOW="Yellow",
			COLOR_NAVY="Navy",
			COLOR_BLUE="Blue",
			COLOR_TEAL="Teal",
			COLOR_AQUA="Aqua";
		boolean validGuess=false;
		// Introduces user to the game
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		System.out.println("Welcome to ESP - extrasensory perception!");
		Scanner input = new Scanner(System.in);
		while (playAgain.equals("Yes") || playAgain.equals("yes")) {
			// Provides the user with options
			answer=0;
			while (answer != 1 && answer != 2 && answer != 3 && answer != 4) {
				System.out.println("Would you please choose one of the 4 options from the menu:");
				System.out.println("");
				System.out.println("1- read and display on the screen first 16 names of colors from a file colors.txt, so the player can select one " + 
									" of the names of colors.");
				System.out.println("2- read and display on the screen first 10 names of colors from a file colors.txt, so the player can select one of" +
									" the names of colors.");
				System.out.println("3- read and display on the screen first 5 names of colors from a file colors.txt, so the player can select one of" + 
									" the names of colors.");
				System.out.println("4- Exit from a program");
				// Asks the user for input
				System.out.print("Enter the option: ");
				answer=input.nextInt();
				input.nextLine();
			}
			if (answer==4) {
				break;
			}
			score=0;
			// Asks for the file name
			System.out.print("Enter the filename: ");
			fileName=input.nextLine();
			if (!fileName.equals("colors.txt")) {
				System.out.println("That's not the right file. Ending program.");
				return;
			}
			try (Scanner readsFile = new Scanner(new File(fileName))) {
				// Based on the user's choice, the program decides what do next and how many colors to print
				switch (answer) {
					case 1:
						System.out.println("There are sixteen colors from a file: ");
						for (int count = 0; count < 16; count++) {
							System.out.print((count+1)+" ");
							System.out.println(readsFile.nextLine());
						}
						numOfLinesUserPicked=16;
						break;
					case 2:
						System.out.println("There are ten colors from a file: ");
						for (int count = 0; count < 10; count++) {
							System.out.print((count+1)+" ");
							System.out.println(readsFile.nextLine());
						}
						numOfLinesUserPicked=10;
						break;
					case 3:
						System.out.println("There are five colors from a file: ");
						for (int count = 0; count < 5; count++) {
							System.out.print((count+1)+" ");
							System.out.println(readsFile.nextLine());
						}
						numOfLinesUserPicked=5;
						break;
				}
			}
			System.out.println(" ");
			Random num = new Random();
			for (int count = 1; count <= 3; count++) {
				System.out.println("Round "+count);
				// Computer randomly picks a number that is associated with one of the colors on the list
				System.out.println("");
				compsNum=num.nextInt(numOfLinesUserPicked)+1;
				switch (compsNum) {
					case 1:
						compsColor=COLOR_BLACK;
						break;
					case 2:
						compsColor=COLOR_WHITE;
						break;
					case 3:
						compsColor=COLOR_GRAY;
						break;
					case 4:
						compsColor=COLOR_SILVER;
						break;
					case 5:
						compsColor=COLOR_MAROON;
						break;
					case 6:
						compsColor=COLOR_RED;
						break;
					case 7:
						compsColor=COLOR_PURPLE;
						break;
					case 8:
						compsColor=COLOR_FUCHSIA;
						break;
					case 9:
						compsColor=COLOR_GREEN;
						break;
					case 10:
						compsColor=COLOR_LIME;
						break;
					case 11:
						compsColor=COLOR_OLIVE;
						break;
					case 12:
						compsColor=COLOR_YELLOW;
						break;
					case 13:
						compsColor=COLOR_NAVY;
						break;
					case 14:
						compsColor=COLOR_BLUE;
						break;
					case 15:
						compsColor=COLOR_TEAL;
						break;
					case 16:
						compsColor=COLOR_AQUA;
						break;
				}
				// Has user guess the color
				System.out.println("I am thinking of a color.");
				System.out.println("Is it one of list of colors above?");
				System.out.println("Enter your guess: ");
				usersGuess=input.nextLine();
				// Validates user's choice
				validGuess=false;
				while (validGuess==false) {
					Scanner readsFile2 = new Scanner(new File(fileName));
					for (int counter = 0; counter<numOfLinesUserPicked; counter++) {
						if (usersGuess.compareToIgnoreCase(readsFile2.nextLine())==0) {
							validGuess=true;
						}
					}
					readsFile2.close();
					if (validGuess==false) {
						System.out.print("Reenter a color. It is not part of the list: ");
						usersGuess=input.nextLine();
					}
				}
				System.out.println("");
				System.out.println("I was thinking of "+compsColor+".");
				// Determines if the user was right and if they get a point
				if (compsColor.compareToIgnoreCase(usersGuess)==0) {
					score++;
				}
			}
			System.out.println("Game Over");
			// Prints user's score
			System.out.println("You guessed "+score+" out of "+NUM_OF_ROUNDS+" colors correctly.");
			// Asks user if they want to play again
			System.out.println("Would you like to continue a Game? Type Yes/No");
			playAgain=input.nextLine();
			while (!playAgain.equals("Yes") && !playAgain.equals("No") && !playAgain.equals("yes") && !playAgain.equals("no")) {
				System.out.println("Not a valid response. Try again: ");
				playAgain=input.nextLine();
			}
			if (playAgain.equals("No") || playAgain.equals("no")) {
				System.out.println("");
			}
			
		}
		// Asks user for their name, description, and the due date
		System.out.print("Enter your name: ");
		usersName=input.nextLine();
		System.out.print("Describe yourself: ");
		usersDescription=input.nextLine();
		System.out.print("Due Date: ");
		dueDate=input.nextLine();
		// Prints the information to the user
		System.out.println("Username: "+usersName);
		System.out.println("User Description: "+usersDescription);
		System.out.println("Date: "+dueDate);
		input.close();
		// Writes the user's information the file
		PrintWriter outputFile = new PrintWriter("EspGameResults.txt");
		outputFile.println("Game Over");
		outputFile.println("You guessed "+score+" out of "+NUM_OF_ROUNDS+" colors correctly.");
		outputFile.println("Due Date: "+dueDate);
		outputFile.println("Username: "+usersName);
		outputFile.println("User Description: "+usersDescription);
		outputFile.println("Date: "+dueDate);
		outputFile.close();
	}
}

package com.cognixia.jump.corejava.fizzbuzz;
import java.util.Scanner;

public class FizzBuzzUser implements User {
	public static FizzBuzz introGame(){
		
		System.out.println("---FizzBuzz---\nWe have a sequence of"
				+ " numbers that evaluate to 'Fizz' if divisible\n"
				+ "by 3, 'Buzz' if divisible by 5, and 'FizzBuzz'"
				+ "if divisible by both 3 and 5.\n"
				+ "In this implementation, you will be able to play "
				+ "with any two divisors you want,\n"
				+ "not just 3, 5. X's indicate prime numbers.\n");
		
		FizzBuzz introduction = new FizzBuzz();
		
		System.out.println("\nThis is what a typical game looks like: \n" + introduction
				+ "\n");
		
		return introduction;
	}
	
	public static boolean isInterested() {
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to play another game? "
				+ "Enter y or n");
		char interested = getCharInput(input);
		if(interested == 'y' || interested == 'Y') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void playWhileInterested(FizzBuzz sampleGame) {
	
		
		while(isInterested()) {
			
			//needs debugging
			//isCustomGame(sampleGame);
			
			int gameLength = promptUser(sampleGame);
			sampleGame.setNumberOfDividends(gameLength);
			
			System.out.println("Your game: \n" + sampleGame);
			
			trackGame(sampleGame.getCount());
				
		}
		
		System.out.println("Happy coding!");
		
	}
	
	public static void isCustomGame(FizzBuzz currentObj) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Would you like to continue playing the conventional"
				+ "\n3, 5 divisor FizzBuzz game? Enter y or n");
		
		char interested = getCharInput(input);
		
		if(interested == 'n' || interested == 'N') {
			
			System.out.println("Enter the divisor you would like to Fizz to: ");
			int divisorOne = getIntegerInput(input);
			
			System.out.println("Enter the next divisor you would like to Buzz to: ");
			int divisorTwo = getIntegerInput(input);
			
			currentObj.setDivisors(divisorOne, divisorTwo);
		}
		else {
			return;
		}
	}
	
	
	public static int getIntegerInput(Scanner input) {
		int intInput = 0;
		while(intInput <= 0) {
			try {
				intInput = input.nextInt();
				if(intInput <= 0) {
					System.out.println("Your value is too low");
				}
			}
			catch(RuntimeException ex) {
				System.out.println("Invalid Input");
			}
		}
		return intInput;
	}
	
	public static char getCharInput(Scanner input) {
		char charInput = '\0';
		
		while(isInvalidChar(charInput)) {
			try {
				
				charInput = input.next().charAt(0);
				
			}
			catch(RuntimeException ex) {
				System.out.println("Invalid Input");
			}
		}
		return charInput;
		
	}
	
	private static boolean isInvalidChar(char testChr) {
		switch(testChr) {
		case 'y':
			return false;
		case 'Y':
			return false;
		case 'n':
			return false;
		case 'N':
			return false;
		default:
			return true;
		}
	}
	
	public static int promptUser(FizzBuzz currentObj) {
		int gameLength = 0;
		Scanner input = new Scanner(System.in);
		isCustomGame(currentObj);
		//prompt
		System.out.println("Enter a number you would like "
				+ "to fizz-buzz to: ");
		
		
		gameLength = input.nextInt();
		
		
		return gameLength;
	}
	
	public static void changeDivisors(FizzBuzz currentObj) {
		
		Scanner input = new Scanner(System.in);
		
	}
	
	public static void trackGame(int round) {
		if(round == 1) {
			System.out.println("You've played " + round
					+ " game.");
		}
		else if(round < 10) {
			System.out.println("You've played " + round
					+ " games.");
		}
		else {
			System.out.println("You've played " + round
					+ "games. Are you sure you're not bored of this game?");
		}
	}
	
}

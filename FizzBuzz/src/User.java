package com.cognixia.jump.corejava.fizzbuzz;

import java.util.Scanner;

public interface User {
	public static FizzBuzz introGame(){
		
		System.out.println("In FizzBuzz, we have a sequence of"
				+ " numbers that evaluate to 'Fizz' if divisible\n"
				+ "by 3, 'Buzz' if divisible by 5, and 'FizzBuzz'"
				+ "if divisible by both 3 and 5.\n");
		
		FizzBuzz introduction = new FizzBuzz();
		
		System.out.println("\nThis is what a typical game looks like: \n" + introduction
				+ "\n");
		
		return introduction;
	}
	public static boolean isInterested() {
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to play another game? "
				+ "Enter y or n");
		char interested = input.next().charAt(0);
		if(interested == 'y' || interested == 'Y') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void playWhileInterested(FizzBuzz sampleGame) {
	
		
		while(isInterested()) {
			
			sampleGame.setNumberOfDividends(promptUser());
			
			System.out.println("Your game: \n" + sampleGame);
			
			trackGame(sampleGame.getCount());
				
		}
		
		System.out.println("Happy coding!");
		
	}
	
	public static int promptUser() {
		int gameLength = 0;
		//prompt
		System.out.println("Enter a number you would like "
				+ "to fizz-buzz to: ");
		Scanner input = new Scanner(System.in);
		
		gameLength = input.nextInt();
		
		return gameLength;
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

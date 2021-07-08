package com.cognixia.jump.corejava.fizzbuzz;
import java.util.Scanner;

public class FizzBuzzDriver {

	public static void main(String[] args) {
		
		char playAnother = 'y';
		
		//prompt
		System.out.println("Welcome to fizz buzz! Enter a number you would like "
				+ "to fizz-buzz to: ");
		Scanner input = new Scanner(System.in);
		
		int inputNumber = input.nextInt();
		
		//play a game as specified by the user:
		FizzBuzz userDefinedGame = new FizzBuzz(inputNumber);
		
		while(playAnother == 'y') {
			
			
			System.out.println("Your game: \n" + userDefinedGame);
			
			System.out.println("Would you like to play another game? "
					+ "Enter y or n");
			playAnother = input.next().charAt(0);
			System.out.println("Enter the number you would like to play to: ");
			inputNumber = input.nextInt();
			userDefinedGame.setNumberOfDividends(inputNumber);
			
			
		}
		System.out.println("Happy coding!");
		
		//play a default game of FizzBuzz (up to 50)
		//FizzBuzz letsPlay = new FizzBuzz();
		//System.out.println(letsPlay);
		
		/*
		//specifying that you want to play a game up to 100
		FizzBuzz playToOneHundred = new FizzBuzz(100);
		//System.out.println(playToOneHundred);
		
		//have 2 as a divisor instead of 3
		FizzBuzz changeRules = new FizzBuzz(50, 2);
		//System.out.println(changeRules);
		
		//replace the divisors 3, 5 with 2, 7, respectively
		FizzBuzz changeRules2 = new FizzBuzz(50, 2, 7);
		System.out.println(changeRules2);
		*/
		
		

	}

}

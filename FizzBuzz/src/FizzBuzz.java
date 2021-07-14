package com.cognixia.jump.corejava.fizzbuzz;
import java.util.Hashtable;

public final class FizzBuzz extends FizzBuzzMath{
	
	private int divisorOne;
	private int divisorTwo;
	public int numberOfDividends;
	private static int gamesPlayed = 0;
	private static Hashtable<String, String> gamesMap = new 
			Hashtable<String, String>(); 
	
	public FizzBuzz() {
		
		setNumberOfDividends(100);
		setDivisors(3, 5);
		
	}
	
	public FizzBuzz(int numberOfDividends) {
		
		setNumberOfDividends(numberOfDividends);
		setDivisors(3, 5);
	}
	
	public FizzBuzz(int numberOfDividends, int divisorOne) {
		
		setNumberOfDividends(numberOfDividends);
		setDivisors(divisorOne, 5);

	}
	public FizzBuzz(int numberOfDividends, int divisorOne, int divisorTwo) {
		
		setNumberOfDividends(numberOfDividends);
		setDivisors(divisorOne, divisorTwo);
		
	}
	
	static {
		System.out.println("Welcome to FizzBuzz!");
	}
	
	@Override
	public String toString() {
		loadFizzBuzz();
		String fizzBuzzStr = gamesMap.get(getCurrentKey());
		return fizzBuzzStr.substring(0, fizzBuzzStr.length()-2);
		
	}
	
	private String evaluateFizzBuzz(int dividend) {
		
		if(divisibilityCheckDivisors(dividend, divisorOne, divisorTwo)) {

			return "FizzBuzz\n ";
		}
		else if(divisibilityCheck(dividend, divisorOne)) {
			return "Fizz, ";
		}
		else if(divisibilityCheck(dividend, divisorTwo)) {

			return "Buzz, ";
		}
		else {
			if(this.isPrime(dividend)) {
				return "X, ";
			}
			else {
				return String.valueOf(dividend) + ", ";
			}
		}
	}
	
	private void loadFizzBuzz() {
		
		if(gamesMap.isEmpty()) {
			String fizzBuzzString = generateFizzBuzz(0, numberOfDividends);
			//put the maximum-value for that current divisor configuration
			gamesMap.put(getMaxDivisorPairKey(), 
					String.valueOf(numberOfDividends));
			gamesMap.put(getCurrentKey(), fizzBuzzString);			
		}
		else if(!(gameAlreadyExists(getCurrentKey()))) {
			
			if(!(gamesMap.containsKey(getMaxDivisorPairKey()))) {
				
				String fizzBuzzString = generateFizzBuzz(0, numberOfDividends);
				gamesMap.put(getMaxDivisorPairKey(), 
						String.valueOf(numberOfDividends));
				gamesMap.put(getCurrentKey(), fizzBuzzString);	
			}
			else {
				int currentMax = getMaxDividend(
						gamesMap.get(getMaxDivisorPairKey())
						); 
				if(numberOfDividends > currentMax) {
					
					gamesMap.replace(getMaxDivisorPairKey(),
							String.valueOf(numberOfDividends));
					int difference  = numberOfDividends - currentMax;
					String subString = generateFizzBuzz(currentMax, 
							currentMax + difference);	
					String fizzBuzzString = gamesMap.get(
							getExistingGameKey(currentMax)) + subString;
					gamesMap.put(getCurrentKey(), fizzBuzzString);
				}
				else {
					String wholeString = gamesMap.get(getExistingGameKey(currentMax));
					String fizzBuzzString = wholeString.substring(0, numberOfDividends);
					gamesMap.put(getCurrentKey(), fizzBuzzString);
				}
			}
		}
		else {
			return;
		}
	}
	private String getExistingGameKey(int formerMax) {
		return getMaxDivisorPairKey() + formerMax;
	}
	private String generateFizzBuzz(int startIdx, int endIdx) {
		String fizzBuzzString = " ";
		for (int i = startIdx; i < endIdx; i++) {
			fizzBuzzString += evaluateFizzBuzz(i + 1);
		}
		return fizzBuzzString;
	}
	
	public boolean gameAlreadyExists(String gameKey) {
		return gamesMap.containsKey(gameKey);
	}
	
	
	private String getCurrentKey() {
		
		return divisorOne+"/"+getMaxDivisorPairKey();
	}
	
	private String getMaxDivisorPairKey() {
		return ""+divisorOne+divisorTwo;
	}
	
	//for comparing values if not in table/ decoding
	public int getMaxDividend(String maxDividendKey) {
		return Integer.parseInt(gamesMap.get(maxDividendKey));
	}
	
	public int getDivisorOne() {
		return divisorOne;
	}

	public int getDivisorTwo() {
		return divisorTwo;
	}

	public void setDivisors(int divisorOne, int divisorTwo) {
		this.divisorOne = divisorOne;
		this.divisorTwo = divisorTwo;
		
	}
		
	public void setNumberOfDividends(int numberOfDividends) {
		this.numberOfDividends = numberOfDividends;
		gamesPlayed++;
		
	}
	
	public int getCount() {
		return gamesPlayed;
	}

}

package com.cognixia.jump.corejava.fizzbuzz;

public class FizzBuzzMath implements Modulo {
	
	@Override
	public boolean divisibilityCheck(int testDividend, int divisor) {
		
				return testDividend % divisor == 0;
	}

	@Override
	public boolean divisibilityCheckDivisors(int testDividend,
			int firstDivisor, int secondDivisor) {
		 
		return testDividend % firstDivisor == 0 && 
				testDividend % secondDivisor == 0;
	}

	@Override
	public boolean isPrime(int target) {
		
		int flag = 0;
		
		for(int i = 2; i <= target / 2; i++) {
			if(target % i == 0) {
				flag = 1;
				break;
			}
		}
		
		if(target == 1) {
			//System.out.println("1 is neither prime nor composite.");
			return false;
		}
		
		else {
			if(flag == 0) {
				return true;
			}
			else {
				return false;
			}
		}
	
	}
}

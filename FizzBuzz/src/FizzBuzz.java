import java.util.Arrays;

public final class FizzBuzz extends FizzBuzzMath{
	
	private int divisorOne;
	private int divisorTwo;
	private int numberOfDividends;
	

	public FizzBuzz() {
		setNumberOfDividends(50);
		setDivisorOne(3);
		setDivisorTwo(5);
	}
	public FizzBuzz(int numberOfDividends) {
		setNumberOfDividends(numberOfDividends);
		setDivisorOne(3);
		setDivisorTwo(5);
	}
	public FizzBuzz(int numberOfDividends, int divisorOne) {
		setNumberOfDividends(numberOfDividends);
		setDivisorOne(divisorOne);
		setDivisorTwo(5);
	}
	public FizzBuzz(int numberOfDividends, int divisorOne, int divisorTwo) {
		setNumberOfDividends(numberOfDividends);
		setDivisorOne(divisorOne);
		setDivisorTwo(divisorTwo);
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.generateFizzBuzz());
	}
	
	private String[] generateFizzBuzz() {
		int fizzBuzzRange = getNumberOfDividends();
		String[] fizzBuzzArray = new String[fizzBuzzRange];
		int divisorOne = getDivisorOne();
		int divisorTwo = getDivisorTwo();
		FizzBuzzMath fizzBuzzChecker = new FizzBuzzMath();
		
		for (int i = 0; i < fizzBuzzArray.length; i++) {
			if(fizzBuzzChecker.divisibilityCheckDivisors(i+1, divisorOne, divisorTwo)) {
				fizzBuzzArray[i] = "FizzBuzz\n";
			}
			else if(fizzBuzzChecker.divisibilityCheck(i+1, divisorOne)) {
				fizzBuzzArray[i] = "Fizz";
			}
			else if(fizzBuzzChecker.divisibilityCheck(i+1, divisorTwo)) {
				fizzBuzzArray[i] = "Buzz";
			}
			else {
				if(fizzBuzzChecker.isPrime(i+1)) {
					//continue;
					fizzBuzzArray[i] = " ";
				}
				else {
					fizzBuzzArray[i] = String.valueOf(i+1);
				}
			}
		}
		return fizzBuzzArray;
	}
	
	public int getNumberOfDividends() {
		return numberOfDividends;
	}

	public void setNumberOfDividends(int numberOfDividends) {
		this.numberOfDividends = numberOfDividends;
	}
	
	public int getDivisorOne() {
		return divisorOne;
	}

	public void setDivisorOne(int divisorOne) {
		this.divisorOne = divisorOne;
	}

	public int getDivisorTwo() {
		return divisorTwo;
	}

	public void setDivisorTwo(int divisorTwo) {
		this.divisorTwo = divisorTwo;
	}

}

package practice.challenges;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
	public static void main(String[] args) {
		
		long testNumber =(long) ((Math.random() + 0.01) * Math.pow(10.0, 20) - Math.pow(10.0, 14));
		System.out.println("Input: " + testNumber);
		System.out.println(validate(testNumber));
		
		
		
	}

	private static boolean validate(long testNumber) {
		int checkDigit = (int) (testNumber % 10l);
		System.out.println("Check digit: " + checkDigit);
		
		long testNoCheck = testNumber / 10l;
		System.out.println("Test digit removed: " + testNoCheck);
		
		List<Integer> numArray = new ArrayList<>();
		int i = 1;
		
		int sum = 0;
		
		while (testNoCheck > 0) {
			int digit = (int) (testNoCheck % 10l);
			if (i % 2 != 0) {
				digit = digit * 2;
				if(digit >= 10) {
					digit = (digit % 10) + (digit / 10);
				}
			}
			sum += digit;
			numArray.add(digit);
			testNoCheck = testNoCheck / 10;
			i++;
		}
		System.out.println(numArray);
		if (numArray.size() < 13 || numArray.size() > 19) {
			return false;
		}
		if (checkDigit == 10 - sum%10) {
			return true;
		}
		return false;
	}
}
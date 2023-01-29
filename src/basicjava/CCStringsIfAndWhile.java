package basicjava;

public class CCStringsIfAndWhile {
	
	public static boolean isDigit(char aChar) {
		//boolean state changes to true when char is an integer and returns the final boolean value
		boolean state = false;
		if (Character.isDigit(aChar)) {
			state = true;
		}
		return state;
		
	}
	
	public static int count(String str, String chars) {
		//initializing iterative counter that keeps track of how many times a letter has occurred
		int counter = 0;
		//converting strings to match case, as upper case and lower case char have different ranks
		String newStr1 = str.toLowerCase();
		String newStr2 = chars.toLowerCase();
		//loops through every char in chars 
		for (char ch : newStr2.toCharArray()) {
			//loops through every char in str
			for (char stringCH : newStr1.toCharArray()) {	
				// if char in str and chars is the same, counter adds one and returns the final value
				if (stringCH == ch) {
					counter += 1;
				}
			}
		}
		return counter;
		
	}
	
	public static int smallestDigit(int num) {
		//getting rid of negative sign as it doesn't matter
		num = Math.abs(num);
		//finding length of number to loops over later. Found this function using:
		// https://www.baeldung.com/java-number-of-digits-in-int
		int length = String.valueOf(num).length();
		
		// initializing variables
		int i = 0;
		int num1 = 0;
		int smallestdig = 0;
		// largestnum serves as a reference, reference is changed every time a smaller value is found
		int largestnum = 9;
		int returnvalue = 0;
		
		//loop cuts off the last digit and analyzes if its the smallest value yet encountered
		//once smallest value is found it stores it as returnvalue, and returns returnvalue in the end
		while (i < length) {
			num1 = num % 10;
			smallestdig = num1;
			if (smallestdig < largestnum) {
				largestnum = smallestdig;
				returnvalue = smallestdig;
			}
			num /= 10;
			i +=1;
		}
		return returnvalue;
	}

}

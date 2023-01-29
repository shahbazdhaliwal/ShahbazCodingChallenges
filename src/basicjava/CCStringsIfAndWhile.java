package basicjava;

public class CCStringsIfAndWhile {
	
	public static boolean isDigit(char aChar) {
		//boolean state changes to true when char is an integer and returns the final boolean value
		//found how to make char list from: https://www.w3schools.com/java/java_arrays.asp
		boolean state = false;
		char[] list = {'0','1','2','3','4','5','6','7','8','9'};
		for (char ch : list) {
			if (ch == aChar) {
				state = true;
			}
		}
		return state;
		
	}
	
	public static int count(String str, String chars) {
		//initializing iterative counter that keeps track of how many times a letter has occurred
		int counter = 0;
		//converting strings to match case, as upper case and lower case char have different ranks
		//found how to convert strings case from: https://www.w3schools.com/java/ref_string_touppercase.asp
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
		if (num < 0) {
			num *= -1;
		}		
		// initializing variables
		int num1 = 0;
		int smallestdig = 0;
		// following variable serves as a reference, reference is changed every time a smaller value is found
		int largestnum = 9;
		int returnvalue = 0;
		
		//loop cuts off the last digit and analyzes if its the smallest value yet encountered
		//once smallest value is found it stores it as a variable, and returns it in the end
		while (num > 0) {
			num1 = num % 10;
			smallestdig = num1;
			if (smallestdig < largestnum) {
				largestnum = smallestdig;
				returnvalue = smallestdig;
			}
			num /= 10;
		}
		return returnvalue;
	}

}

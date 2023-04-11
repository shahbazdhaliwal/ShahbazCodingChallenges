package basicjava;

import java.util.ArrayList;

public class RecursionExercises {

	/**
	 * counts the number of digits present in a whole number
	 * @param number
	 * @return number of digits in a whole number
	 */
	public int countDigits(int number) {
		//if there is only 1 digit
		if (number / 10 < 1) {
			return 1;
		}
		//calls recursive function with last digit removed
		int total = 1 + countDigits(number/10);
		return total;
	}

	/**
	 * finds the sum of all digits in a whole number 
	 * @param number
	 * @return sum
	 */
	public int addDigits(int number) {
		//if there is only one digit left to add
		if (number < 10) {
			return number;
		}
		//adds the last digit in the number and recursively calls function with last digit removed
		int total = number % 10 + addDigits(number / 10);
		return total;
	}

	/**
	 * finds the sum of all numbers in between 2 numbers
	 * @param sumFrom starting number (inclusive)
	 * @param sumTo ending number (inclusive)
	 * @return sum
	 */
	public int sum(int sumFrom, int sumTo) {
		//handling awkward method calls or the last case of recursion before unwind stage
		if (sumFrom < 0 || sumTo < 0 || sumFrom > sumTo) {
			return 0;
		} 
		//increment + recursive call
		int total = sumFrom + sum(sumFrom + 1, sumTo);
		return total;
	}

	/**
	 * adds up all the even numbers between 0 and number specified in parameter
	 * @param number 
	 * @return sum
	 */
	public int sumEvenNumbers(int number) {
		//too small a number or last case in recursion before unwind
		if (number < 2)  {
			return 0;
		}
		int total = 0;
		//recursive call if number is even
		if (number % 2 == 0) {
			total += number + sumEvenNumbers(number - 2);
		//recursive call if number is odd
		} else {
			sumEvenNumbers(number - 1);
		}
		return total;
	}

	/**
	 * adds all numbers divisible by 5 in a list recursively
	 * @param list
	 * @return sum
	 */
	public int sumOfMultiple(ArrayList<Integer> list) {
		//making sure method call is valid
		if (list != null && !list.isEmpty()) {
			int sum = 0;
			//unwinding condition
			if (list.get(0) % 5 == 0) {
				sum += list.get(0);
			} else {
				sum += 0;
			}
			
			//recursive call
			if (list.size() > 1) {
				// setting list equal to a new list without first element
				list = new ArrayList<Integer>(list.subList(1, list.size()));
				sum += sumOfMultiple(list);
			}
			return sum;
		} else {
			return 0;
		}
	}
	
	/**
	 * counts the number of vowels present in a String
	 * @param potentialVowels
	 * @return number of vowels
	 */
	public int countVowels(String potentialVowels) {
		//Handling invalid method call
		if (potentialVowels != null && !potentialVowels.isEmpty()) {
			potentialVowels = potentialVowels.toLowerCase();
			String vowels = "aeiou";
			int count = 0;
			//unwinding condition + initialization
			if (vowels.contains("" + potentialVowels.charAt(0))) {
				count ++;
			}
			//recursive call
			if (potentialVowels.length() > 1) {
				count += countVowels(potentialVowels.substring(1));
			}
			
			return count;
		} else {
			return 0;
		}
	}
	
	/**
	 * removes all vowels in a string
	 * @param word
	 * @return string without vowels
	 */
	public String removeVowels(String word) {
		//Handling invalid method call
		if (word != null && !word.isEmpty()) {
			String vowels = "aeiou";
			word = word.toLowerCase();
			String newWord = "";
			//unwinding case and initialization;
			if (vowels.contains("" + word.charAt(0))) {
				newWord = "";
			} else {
				newWord = "" + word.charAt(0);
			}
			
			//recursive call
			if (word.length() > 1 ) {
				newWord += removeVowels(word.substring(1));
			}
			return newWord;
		} else {
			return word;
		}
		
	}
	
}

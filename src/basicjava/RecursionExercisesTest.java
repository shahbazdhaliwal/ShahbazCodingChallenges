package basicjava;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class RecursionExercisesTest {
	
	@Test 
	public void test_numOfDigits_one() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing 0", 1, se.countDigits(0));
		assertEquals("Testing 9", 1, se.countDigits(9));
		assertEquals("Testing 5", 1, se.countDigits(5));
	}
	
	@Test 
	public void test_numOfDigits_two() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing 10", 2, se.countDigits(10));
		assertEquals("Testing 99", 2, se.countDigits(99));
		assertEquals("Testing 45", 2, se.countDigits(45));
	}
	
	@Test 
	public void test_numOfDigits_many() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing 1234", 4, se.countDigits(1234));
		assertEquals("Testing 5639576", 7, se.countDigits(5639576));
	}
	
	@Test
	public void test_addDigits_12345() {
		int expected = 15;
		int actual = (new RecursionExercises()).addDigits(12345);
		
		assertEquals("testing 12345", expected, actual);
	}
	
	@Test
	public void test_addDigits_0() {
		int expected = 0;
		int actual = (new RecursionExercises()).addDigits(0);
		
		assertEquals("testing 0", expected, actual);
	}

	@Test
	public void test_addDigits_98765() {
		int expected = 35;
		int actual = (new RecursionExercises()).addDigits(98765);
		
		assertEquals("testing 98765", expected, actual);
	}
	
	@Test
	public void test_addDigits_10() {
		int expected = 1;
		int actual = (new RecursionExercises()).addDigits(10);
		
		assertEquals("testing 10", expected, actual);
	}

	@Test
	public void test_addDigits_911111() {
		int expected = 14;
		int actual = (new RecursionExercises()).addDigits(911111);
		
		assertEquals("testing 911111", expected, actual);
	}

	@Test 
	public void test_sum_negative() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing sum starting and ending at negative number", 0, se.sum(-1 , -1));
		assertEquals("Testing sum starting at negative number", 0, se.sum(-2, 1));
		assertEquals("Testing sum ending at negative number", 0, se.sum(1, -5));
	}
	
	@Test 
	public void test_sum_zero() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing sum starting at zero", 0, se.sum(0,0));
	}
	
	@Test 
	public void test_sum_one() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing sum starting at one", 1, se.sum(1, 1));
	}
	
	@Test 
	public void test_sum_five() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing sum one to ten", 15, se.sum(1,5));
	}
	
	@Test 
	public void test_sum_fifty_to_100() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing sum 50 to 100", 3825, se.sum(50,100));
	}
	

	@Test 
	public void test_sum_100_to_50() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing sum 100 to 50", 0, se.sum(100,50));
	}
	

	
	@Test 
	public void test_sumEvenNumbers_negative() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing summing starting at negative number", 0, se.sumEvenNumbers(-1));
		assertEquals("Testing summing starting at negative number", 0, se.sumEvenNumbers(-2));
		assertEquals("Testing summing starting at negative number", 0, se.sumEvenNumbers(-5));
		assertEquals("Testing summing starting at negative number", 0, se.sumEvenNumbers(-10));
	}
	
	@Test 
	public void test_sumEvenNumbers_zero() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing summing starting at zero", 0, se.sumEvenNumbers(0));
	}
	
	@Test 
	public void test_sumEvenNumbers_one() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing summing even numbers from zero to one", 0, se.sumEvenNumbers(1));
	}
	
	@Test 
	public void test_sumEvenNumbers_two() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing summing even numbers from zero to two", 2, se.sumEvenNumbers(2));
	}
	
	@Test 
	public void test_sumEvenNumbers_ten() {
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing summing even numbers from zero to ten", 30, se.sumEvenNumbers(10));
	}
	
	@Test
	public void test_countVowels_NullString() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing countVowels for null string.", 0, se.countVowels(null));
		
	}
	
	@Test
	public void test_countVowels_EmptyString() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing countVowels for empty string.", 0, se.countVowels(""));
		
	}
	
	@Test
	public void test_countVowels_OnlyVowels() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing countVowels for string with only vowels.", 9, se.countVowels("aeiuaeioo"));
		
	}
	
	@Test
	public void test_countVowels_NoVowels() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing countVowels for string with no vowels.", 0, se.countVowels("sqwrtyplkjhgfdszxcvbnm"));
		
	}
	
	@Test
	public void test_countVowels_VowelsAndConsonants() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing countVowels for string with vowels and consonants.", 8, se.countVowels("Is is this. A string with vowels?"));
	}

	// testing removeVowels
	@Test
	public void test_removeVowels_NullString() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing removeVowels for null string.", null, se.removeVowels(null));
		
	}
	
	@Test
	public void test_removeVowels_EmptyString() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing removeVowels for empty string.", "", se.removeVowels(""));
		
	}
	
	@Test
	public void test_removeVowels_OnlyVowels() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing removeVowels for string with only vowels.", "", se.removeVowels("aeiuaeioo"));
		
	}
	
	@Test
	public void test_removeVowels_NoVowels() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing removeVowels for string with no vowels.", "sqwrtyplkjhgfdszxcvbnm", se.removeVowels("sqwrtyplkjhgfdszxcvbnm"));
		
	}
	
	@Test
	public void test_removeVowels_VowelsAndConsonants() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing removeVowels for string with vowels and consonants.", "s s ths.  strng wth vwls?", se.removeVowels("Is is this. A string with vowels?"));
	}
	
	@Test
	public void test_sumOfMultiple2_Mix() {
		RecursionExercises se = new RecursionExercises();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(10);
		list.add(15);
		list.add(5);
		
		assertEquals("Testing sumOfMultiple2 for {7,10,15,5}.", 30, se.sumOfMultiple(list));	
	}
	
	@Test
	public void test_sumOfMultiple2_NoMultipleof5() {
		RecursionExercises se = new RecursionExercises();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(3);
		list.add(6);
		list.add(9);
		list.add(12);

		
		assertEquals("Testing sumOfMultiple2 for {0,3,6,9,12}.", 0, se.sumOfMultiple(list));
		
	}
	
	@Test
	public void test_sumOfMultiple2_OnlyMultipleOf5() {
		RecursionExercises se = new RecursionExercises();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(20);
		
		assertEquals("Testing sumOfMultiple2 for {5,10,20}.", 35, se.sumOfMultiple(list));
		
	} 
	
	@Test
	public void test_sumOfMultiple2_EmptyList() {
		//Test empty list
		RecursionExercises se = new RecursionExercises();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		assertEquals("Testing sumOfMultiple2 for {}.", 0, se.sumOfMultiple(list));
		
	}
	
	@Test
	public void test_sumOfMultiple2_NullList() {
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing sumOfMultiple2 for null list.", 0, se.sumOfMultiple(null));
		
	}
}

package basicjava;

import java.util.Arrays;
import java.util.Comparator;

public class CCArrays {
	
	/**
	 * In a given charArray[], method replaces any char to a char of choice
	 * @param charArray charArray[]
	 * @param toReplace char in charArray[] you want replaced
	 * @param replaceWith char you want to replace it with
	 */
	public static void replace(char[] charArray, char toReplace, char replaceWith) {
		
		String strToReplace = ("" + toReplace).toLowerCase();
		int counter = 0;
		
		for (char i : charArray) {
			String newI = ("" + i).toLowerCase();
			if (newI.equals(strToReplace)) {
				charArray[counter] = replaceWith;
			}
			counter ++;
		}
	}
	
	
	public static void sortAlphabetic(String[] strArray) {
		//learned from http://www.java2s.com/Tutorials/Java/java.lang/String/Java_String_CASE_INSENSITIVE_ORDER.htm
		Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);		
		
	}

}

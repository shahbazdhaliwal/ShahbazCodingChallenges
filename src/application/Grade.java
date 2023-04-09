package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javafx.scene.control.TextField;


public class Grade {
	
	double value;
	double weightOfComponent;
	
	// contains the first character encountered that is not valid
	String errorValue = "";
	//turns true when error encountered during validation
	boolean error = false;
	//contains all invalid characters found in quiz grades
	String quizErrorValue = "";
	
	/**
	 * default constructor
	 */
	Grade () {
		
	}
	
	/**
	 * validates whether a double value is greater than 0 and smaller than or equal to max value. Initializes weight as well
	 * @param valueAsDouble
	 * @param maxValue
	 * @param weight
	 */
	Grade (double valueAsDouble, int maxValue, double weight)  {
		weightOfComponent = weight;
		if (valueAsDouble > maxValue) {
			value = 0;
		} else {
			value = valueAsDouble;
		}
	}
	
	
	/**
	 * Checks if a string can be converted into a double ranging from 0 to max value
	 * @param valueAsString string to convert
	 * @param maxValue maximum value the double can have
	 * @param weight weight of grade
	 * @return string value as double
	 * @throws InvalidGradeException throws if string cannot be converted to valid double
	 */
	Grade(String valueAsString, int maxValue, double weight) throws InvalidGradeException{
		//initializing some variables
    	boolean validValue = true;
    	int decimalCount = 0;
    	
    	
    	// making sure string value can be converted into a double
    	for (char c : valueAsString.toCharArray()) {
    		//makes sure incorrect characters aren't in project grade
    		if (!Character.isDigit(c) && c != '.') {
    			validValue = false;
    			error = true;
    			errorValue += c;
    			value = 0;
    			throw new InvalidGradeException("Invalid Value: " + valueAsString + " entered. Enter a number from 0 to " + maxValue);
    		// makes sure too many decimals aren't allowed through
    		} else if (c == '.') {
    			decimalCount += 1;
    			if (decimalCount >= 2) {
    				validValue = false;
    				error = true;
    				errorValue += c;
    				value = 0; 
    				throw new InvalidGradeException("Invalid Value: " + valueAsString + " entered. Enter a number from 0 to " + maxValue);
    			}
    		
    		}

    	}
    	//Converting valid grade into a double and later checking its between 0 and max value
     	if (validValue) {
    		value = Double.parseDouble(valueAsString);
       	}
    	if (value < 0 || value > maxValue) {
    		error = true;
    		errorValue += value;
    		value = 0;
    		throw new InvalidGradeException("Invalid Value: " + valueAsString + " entered. Enter a number from 0 to " + maxValue);
    	}
    	
    	weightOfComponent = weight;
    	
    }
	
	/**
	 * returns value
	 * @return
	 */
	double getWeightedPercentageGrade() {
		return value;
	}
	
	/**
	 * Applies the weight to a given grade
	 * @param grade grade 
	 * @param weight weight 
	 * @return
	 */
	double doCalculation(double grade, double weight) {
		return grade * weight;
	}

	/**
	 * finds the average number in a given list
	 * @param list list 
	 * @param averageOutOf what you want the average out of
	 * @return average
	 */
	double findListAverage(Double[] list, double averageOutOf) {
		double listAverage = 0.0;
		for (Double i : list) {
			listAverage += i;
		}
		listAverage = listAverage * 10 / averageOutOf;
		return listAverage;
	}
		
	/**
	 * creates a Double[] list from ArrayList<TextField> with the text fields containing String doubles. 
	 * @param list that you want updated after function
	 * @param textFields with all the text field values
	 * @param maxValue max value a double can have
	 * @return String doubles converted to Double doubles
	 */
	ArrayList<Double> fromTextFieldsToArray (Double[] list, ArrayList<TextField>textFields, int maxValue) {
		ArrayList<Double> listArray = new ArrayList<Double>(Arrays.asList(list));
		String rawTextFieldEntry;
		
		//looking through text field and adding numbers to a list
		for (TextField textField : textFields) {
		    
			if (!textField.getText().isEmpty()) {
				
				rawTextFieldEntry = textField.getText();
				try {
					Grade gradeToAdd = new Grade(rawTextFieldEntry, maxValue, 0.0);
					listArray.add(gradeToAdd.value);
					if (gradeToAdd.error == true) {
						error = true;
						quizErrorValue += rawTextFieldEntry + ",";
					}
				} catch (InvalidGradeException e) {
					// TODO Auto-generated catch block
					Grade gradeToAdd = new Grade(0.0, maxValue, 0.0);
					listArray.add(gradeToAdd.value);
					error = true;
					quizErrorValue += rawTextFieldEntry + ",";
				} 
				} else {
        			error = true;		
        			listArray.add(0.0);
				}
			
    	}
		//adds all error causing characters to errorValueList
		if (quizErrorValue.endsWith(",")) {
			quizErrorValue = quizErrorValue.substring(0, quizErrorValue.length() -1);
		}
        return listArray;
	}
	
	
	/**
	 * makes all values inside a list equal to 0.0
	 * @param list 
	 * @return list
	 */
	Double[] resetList (Double[] list) {
		int i = (int) (list.length);
		int read = 0;
		while (read < i) {
			list[read] = 0.0;
			read++;
		}
		return list;
	}
	
	/**
	 * Find the five greatest numbers in a given list and makes all others values equal to 0
	 * @param doubleList list
	 * @return list with only five greatest numbers
	 */
	Double[] findTopFive(Double[] doubleList) {
        if (doubleList.length > 5.0) {
        	//sorts numbers greatest to smallest
        	//found how to do this using: https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
        	Arrays.sort(doubleList, Collections.reverseOrder());
        	int index = doubleList.length - 1;
        	//deletes all other small numbers
        	while (index > 4) {
        		doubleList[index] = 0.0;
        		index --;
        	}
        	     
        } 
    	return doubleList;
    }
	
	/**
	 * find the average % value of two lists
	 * @param quizGradeList list
	 * @param quizOptionList list
	 * @return average value 
	 */
	Double avgList(Double[] list1, Double[] list2, Double avgOutOf) {
    	Double sum = 0.0;
    	for (Double i : list1) {
    		sum += i;
    	}
    	for (Double j : list2) {
    		sum += j;
    		
    	}
    	Double average = sum * 10 / avgOutOf;
    	return average;
    }
	
	
	
	

}



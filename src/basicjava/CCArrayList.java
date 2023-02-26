package basicjava;

import java.util.ArrayList;
import java.util.ListIterator;

public class CCArrayList {
	
	public static int indexOfIgnoreCase(ArrayList<String> strs, String toFind) {
		
		//Initializing variable
		int indexOfToFind = -1;
		//increments index by 1;
		for (int index = 0; index < strs.size(); index++) {
			//checking if there is a match
			if (strs.get(index).toLowerCase().equals(toFind.toLowerCase())) {
				//setting index to return value
				indexOfToFind = index;
				//ending the loop by making condition false
				index = strs.size();
			}
		}
		return indexOfToFind;
	}
	
	public static void insert(ArrayList<Double> nums, double numToInsert, int insertAtIndex) {
		
		//conditional checks if index is in the size of list
		if (insertAtIndex < nums.size()) {
			//increases the size of list by 1
			nums.ensureCapacity(nums.size() + 1);
			//creates an iterator to iterate over list from insertAtIndex
			ListIterator<Double> iterator = nums.listIterator(insertAtIndex);
			//sets every next value to the last, essentially moving it all one to the right
			iterator.set(iterator.previous());
			//adds the desired double at desired index
			nums.add(insertAtIndex, numToInsert);
		}
	}

}

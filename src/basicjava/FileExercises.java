package basicjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileExercises {

	/**
	 * finds the number of times a word appears in a text file called "example.txt" which exists in eclipse workspace
	 * @param wordToCount word to keep count of
	 * @return number of times word appears
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static int counting(String wordToCount) throws FileNotFoundException, IOException{
		int wordCount;
		//trying to read into a file called "example.txt"
		try {
			BufferedReader reader = new BufferedReader(new FileReader("../GradeCalculator/example.txt"));
			String line = reader.readLine();
			wordCount = 0;
			//looping through every line
			while (line != null) {
				//found how to split strings at every " " from: https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
				String[] words = line.split("\\s+");
				for (String word : words) {
					// increments word count if word in file is the same as wordToCount
					if (word.equalsIgnoreCase(wordToCount)) {
						wordCount++;
					}   
				}
				//reads next line
				line = reader.readLine();
			}
			reader.close();
		//catching exceptions and setting word count to 0
		} catch (FileNotFoundException fnf) {
			wordCount = 0;
			throw fnf;
		} catch (IOException ioe) {
			wordCount = 0;
			throw ioe;
		}
		return wordCount;
	}
	
	/**
	 * takes input from a file and creates/writes into an all capital character version of input file
	 * @param inputName reading file name
	 * @param outputName new capital characters file name
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void toUpper(String inputName, String outputName) throws FileNotFoundException, IOException{
		try {
		BufferedReader readerFile = new BufferedReader(new FileReader("../GradeCalculator/"+inputName));
		BufferedWriter writeFile = new BufferedWriter(new FileWriter("../GradeCalculator/"+outputName));
		
		//loop to read through every line of read file
		for (String line = readerFile.readLine(); line != null; line = readerFile.readLine()) {
			line = line.toUpperCase();
			//adds every character (after its changed to upper case) in every line of read file into write file
			for (char c : line.toCharArray()) {
				writeFile.append(c);
			}
			//adding a line in write file before reading a new line
			writeFile.append("\n");
		}
		readerFile.close();
		writeFile.close();
		//catching exceptions and throwing them to code that handles them
		} catch (FileNotFoundException fnf){
			throw fnf;
			
		} catch (IOException ioe) {
			throw ioe;
		}
		
		
	}
}

package application;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GradeCalculatorControler {
	
	//Making it a global variable 
	Stage applicationStage;
	
	//making these variable global variables because they need to be accessed by different methods
	Double[] quizGradeList = {0.0};
	Double[] quizOptionList = {0.0};	
	int typeOfQuiz = 0;	
	int quizErrorFlag = 0;
	
	@FXML
	private ChoiceBox<Integer> requiredCCchoicebox;

    @FXML
    private TextField projectgradeTextfield;
    
    @FXML 
    private ChoiceBox<Integer> quizzesChoiceBox;
    
    @FXML
    private ChoiceBox<Integer> reqQuizzesChoiceBox;

    
    @FXML
    private Label projectGradeErrorLabel;
    
    @FXML
    private Label requiredGradeLabel;
    
    @FXML
    private Label optionalGradeLabel;
    
    @FXML
    private Label quizErrorLabel;
    
    @FXML
    private ChoiceBox<Integer> optionCCchoicebox;
    
    @FXML
    private Label courseGradeLabel;
    
    @FXML 
    private Button reqQuizButton;
    
    @FXML
    private Button optionQuizButton;
    
    /**
     * Checks if the value provided in a text field is a valid value for a project grade. For it to pass through this function,
     * the value must be a string type number from 0 to 100 without any other special characters. Valid values are returned as 
     * an equivalent double types, while invalid values return a double of 0.0.  
     * @param valueEntered string value entered as the project grade
     * @return returns a double of valueEntered if its a number between 0 and 100, otherwise it will return the double 0.0
     * along with error messages in the Grade Calculator GUI
     */
    double getProjectGrade(String valueEntered) {
    
    	//initializing some variables
    	boolean validProjectGrade = true;
    	double projectGrade = 0.0;
    	int decimalCount = 0;
    	
    	// making sure string value can be converted into a double
    	for (char c : valueEntered.toCharArray()) {
    		//makes sure incorrect characters aren't in project grade
    		if (!Character.isDigit(c) && c != '.') {
    			validProjectGrade = false;
    			projectGradeErrorLabel.setText("Project Grade should be percentage. "+"Don't include the character: "
    			+c);
    			projectGrade = 0;
    		// makes sure too many decimals aren't allowed through
    		} else if (c == '.') {
    			decimalCount += 1;
    			if (decimalCount >= 2) {
    				validProjectGrade = false;
    				projectGradeErrorLabel.setText("There are too many decimals in: "+valueEntered+". Enter valid number");
    				projectGrade = 0;    				
    			}
    		
    		}
    	}
    	//Converting valid project grade into a double and later checking its between 0 and 100
     	if (validProjectGrade) {
    		projectGrade = Double.parseDouble(valueEntered);
       	}
    	if (projectGrade < 0 || projectGrade > 100) {
    		projectGradeErrorLabel.setText("Invalid Project Grade Entered: " + projectGrade +
    				". Enter value from 0 to 100");
    		projectGrade = 0;
    	}
    	return projectGrade;
    }
    
    /**
     * Checks if the value provided in a text field is a valid value for a quiz. For it to pass through this function,
     * the value must be a string type number from 0 to 100 without any other special characters. Valid values are returned as 
     * an equivalent double types, while invalid values return a double of 0.0.  
     * @param valueEntered string value entered as the quiz grade
     * @return returns a double of valueEntered if its a number between 0 and 100, otherwise it will return the double 0.0
     */
    double getQuizGrade(String valueEntered) {
    	//initializing some variables
    	boolean validQuizGrade = true;
    	double quizGrade = 0.0;
    	int decimalCount = 0;
    	
    	// making sure string value can be converted into a double
    	for (char c : valueEntered.toCharArray()) {
    		//makes sure incorrect characters aren't in quiz grade
    		if (!Character.isDigit(c) && c != '.') {
    			validQuizGrade = false;
    			quizGrade = 0;
    			quizErrorFlag = 1;
    		// makes sure too many decimals aren't allowed through
    		} else if (c == '.') {
    			decimalCount += 1;
    			if (decimalCount >= 2) {
    				validQuizGrade = false;
    				quizGrade = 0;
    				quizErrorFlag = 1;
    			}
    		
    		}
    	}
    	//Converting valid quiz grade into a double and later checking its between 0 and 100
     	if (validQuizGrade) {
    		quizGrade = Double.parseDouble(valueEntered);
       	}
    	if (quizGrade < 0 || quizGrade > 10) {
    		quizGrade = 0;
    		quizErrorFlag = 1;
    	}
    	return quizGrade;
    }
    
    /**
     * validates user input for choice box and returns int value of CC passed
     * @param reqCCPassed value of required CC passed choice box
     * @return return int value of coding challenges passed
     */
    int getReqCC (int reqCCPassed) {
      	if (requiredCCchoicebox.getValue() == null) {
      		reqCCPassed = 0;
      	} else {
      		reqCCPassed = requiredCCchoicebox.getValue();
      	}
    	return reqCCPassed;
    }

    /**
     * validates user input for choice box and returns int value of CC passed
     * @param optionCCPassed value of option CC passed choice box
     * @return return int value of optional coding challenges passed
     */
    int getOptionCC (int optionCCPassed) {
    	if (optionCCchoicebox.getValue() == null) {
      		optionCCPassed = 0;
      	} else {
      		optionCCPassed = optionCCchoicebox.getValue();
      	}
    	return optionCCPassed;
    }
    
    /**
     * Finds the largest 5 numbers in a array with more than 5 elements
     * @param tempDoubleList Double[] array
     * @return Double[] array
     */
    Double[] findTopFive(Double[] tempDoubleList) {
    	Double[] newList;
        if (tempDoubleList.length > 5.0) {
        	//sorts numbers greatest to smallest
        	//found how to do this using: https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
        	Arrays.sort(tempDoubleList, Collections.reverseOrder());
        	newList = new Double[5];
        	int counter = 0;
        	for (Double i : tempDoubleList) {
        		while (counter < 5) {
        			newList[counter] = i;
        			counter ++;
        		}
        	}       
        } else {
        	newList = tempDoubleList;
        }
    	return newList;
    }
    
    /**
     * Makes all values inside a Double[] list equal to 0
     * @param list input list
     * @return output list
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
     * gets values from quiz grade text fields and appends them onto a double[] list. TextField Strings are verified
     * by get quiz grade
     * @param mainScene main scene of GUI
     * @param quizGradeTextFields ArrayList<TextField> type that is an array of all the different text fields
     * @param typeOfQuiz variable that dictates whether to read optional quiz grades or required
     */
    void calculateQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextFields, int typeOfQuiz) {
    	
    	String rawQuizGrade;
    	int quizCheck = 1;
    	//case for if user wants to enter option quiz grades
    	if (typeOfQuiz == quizCheck) {
    		
    		quizOptionList = resetList(quizOptionList);
    		//makes identical list of different type to be able to add numbers to the list
    		//Learned how to use this array list from: https://www.javatpoint.com/add-elements-to-array-in-java
    		ArrayList<Double> averageOptionQuizGrade = new ArrayList<Double>(Arrays.asList(quizOptionList));
    		
    		//temporary list in order to find top five marks
    		Double[] tempDoubleList = {0.0};
    		ArrayList<Double> tempList = new ArrayList<Double>(Arrays.asList(tempDoubleList));
    		
    		//looks through text fields	and adds quiz grades to a list
    		for (TextField textField : quizGradeTextFields) {
    			if (!textField.getText().isEmpty()) {
    				rawQuizGrade = textField.getText();
        			tempList.add(getQuizGrade(rawQuizGrade));
        		
    			} else {
    				tempList.add(0.0);
    			}
    		}
    		//converting back to Double[]
    		tempDoubleList = tempList.toArray(tempDoubleList);
    		//finding top five grades
    		Double[] newList = findTopFive(tempDoubleList);
    		Double optionQuizAverage = 0.0;
    		//adding grades to a list that gets used in grade calculation 
    		for (Double i : newList) {
    			averageOptionQuizGrade.add(i);
    			optionQuizAverage += i;
    		}
    		//finding quiz average to update label
    		optionQuizAverage /= 5;
    		optionQuizAverage *= 10;
    		quizOptionList = averageOptionQuizGrade.toArray(quizOptionList);
    		optionalGradeLabel.setText(String.format("%.2f", optionQuizAverage) + "%");
    		
    		
    	} else {
    		//case for user entering required quizzes
    		Double requiredQuizAverage = 0.0;
    		quizGradeList = resetList(quizGradeList);
    		ArrayList<Double> averageQuizGrade = new ArrayList<Double>(Arrays.asList(quizGradeList));
    		
    		//looking through text field and adding numbers to a list
    		for (TextField textField : quizGradeTextFields) {
    		    
    			if (!textField.getText().isEmpty()) {
    				rawQuizGrade = textField.getText();
            		//adds double to averageQuizGrade after verifying string can be converted to a double
            		averageQuizGrade.add(getQuizGrade(rawQuizGrade));
            		requiredQuizAverage += getQuizGrade(rawQuizGrade);
    			} else {
    				averageQuizGrade.add(0.0);
    				requiredQuizAverage += 0;
    			}
        	}
    		//update grade label
    		requiredQuizAverage /= 15;
    		requiredQuizAverage *= 10;
    		requiredGradeLabel.setText(String.format("%.2f", requiredQuizAverage) + "%" );
            quizGradeList = averageQuizGrade.toArray(quizGradeList);
    	}
    	
    	//condition that lets the user know when they've input an invalid grade
    	if (quizErrorFlag == 1) {
    		quizErrorLabel.setText("1 or more incorrect values entered");
    		quizErrorFlag = 0;
    	} else {
    		quizErrorLabel.setText("");
    	}
    	
    	
    	
    	applicationStage.setScene(mainScene);
    	return;
    }
    
    /**
     * changes scene when enter quiz grades is pressed to be able to enter quiz grades. When "done" is pressed in new GUI
     * calculation is done
     * @param enterQuizGradesEvent event type of mouse click
     */
    @FXML
    void getQuizGrades(ActionEvent enterQuizGradesEvent) {
    	
    	int numberofQuizzes = 0;
    	Scene mainScene = applicationStage.getScene();
    	
    	//to find if enter quiz grades was pressed for required quizzes or optional quizzes
    	//learned from https://edencoding.com/check-whats-been-clicked/#:~:text=When%20a%20button%20is%20clicked,when%20the%20button%20was%20created.
        EventTarget quizType = enterQuizGradesEvent.getTarget();
        String strQuizType = quizType.toString();
        
        //finds which "Enter Quiz Grades" button was pressed and obtains the number of quizzes the user wants to enter
        if (strQuizType.contains("reqQuizButton")) {
        	if (reqQuizzesChoiceBox.getValue() == null) {
        		numberofQuizzes = 0;
        	} else {
        		numberofQuizzes = reqQuizzesChoiceBox.getValue();
            	typeOfQuiz = 0;
        	}        	
        }else if (strQuizType.contains("optionQuizButton")) {
        	if (quizzesChoiceBox.getValue() == null) {
        		numberofQuizzes = 0;
        	} else {
        		numberofQuizzes = quizzesChoiceBox.getValue();
            	typeOfQuiz = 1;
        	}
        }
        
        //making rows given the number of quizzes 
    	int rowCounter = 0;
    	VBox allRows = new VBox();
    	allRows.setAlignment(Pos.TOP_CENTER);
    	
    	ArrayList<TextField> quizGradeTextFields = new ArrayList<TextField>();
    	while (rowCounter < numberofQuizzes) {
    		rowCounter ++;
    		
    		HBox quizRow = new HBox();
    		quizRow.setPrefHeight(30.0);
    		quizRow.setAlignment(Pos.CENTER);
    		
        	Label quizLabel = new Label("Quiz " + rowCounter + " grade");
        	quizLabel.setAlignment(Pos.CENTER_LEFT);
        	Insets quizRowInsets = new Insets(5);
        	HBox.setMargin(quizLabel, quizRowInsets);
        	
        	
        	TextField quizGradeTextField = new TextField();
        	quizGradeTextField.setAlignment(Pos.CENTER_RIGHT);
        	quizGradeTextField.setPrefWidth(50.0);
        	quizGradeTextFields.add(quizGradeTextField);
        	
        	quizRow.getChildren().addAll(quizLabel, quizGradeTextField);
            
        	
        	allRows.getChildren().add(quizRow);
        	
        		
    	}
    	
    	//makes sure choice box values are valid in order to make a new window and configures the done button
    	if ((reqQuizzesChoiceBox.getValue() != null && numberofQuizzes == reqQuizzesChoiceBox.getValue()) 
    			|| (quizzesChoiceBox.getValue() != null && numberofQuizzes == quizzesChoiceBox.getValue())) {
    		
    		HBox buttonRow = new HBox();
    		
    		buttonRow.setPrefWidth(150.0);
    		buttonRow.setPrefHeight(20.0);
    		buttonRow.setAlignment(Pos.CENTER);
    		
    		Button doneButton = new Button("Done");
    		doneButton.setAlignment(Pos.TOP_CENTER);
    		
    		buttonRow.getChildren().addAll(doneButton);
    		
    		doneButton.setOnAction(doneEvent -> calculateQuizGrade(mainScene, quizGradeTextFields, typeOfQuiz));
			
        	allRows.getChildren().add(buttonRow);
        	
        	Scene quizScene = new Scene(allRows);
        	applicationStage.setScene(quizScene);
        	
        	//Scene title
        	if (reqQuizzesChoiceBox.getValue() != null && numberofQuizzes == reqQuizzesChoiceBox.getValue()) {
        		applicationStage.setTitle("Required Quizzes");
        	}
        	if (quizzesChoiceBox.getValue() != null && numberofQuizzes == quizzesChoiceBox.getValue()) {
        		applicationStage.setTitle("Optional Quizzes");
        	}
        	
    	} 
    	}
    
    /**
     * reads through list of quiz grades and find their average
     * @return return average quiz grade as a Double
     */
    Double avgQuizGrade() {
    	Double sumQuizGrade = 0.0;
    	for (Double i : quizGradeList) {
    		sumQuizGrade += i;
    	}
    	for (Double j : quizOptionList) {
    		sumQuizGrade += j;
    		
    	}
    	Double averageQuizGrade = sumQuizGrade * 10 / 20;
    	return averageQuizGrade;
    }

    /**
     * Takes user input from a Grade Calculator GUI that has a text field for project grade, 2 choice boxes for required 
     * and optional coding challenges completed and a slider to indicate average quiz grade. From user input data, the user's
     * course grade is calculated. 
     * @param event the button "Calculate Grade" must be clicked on when in the grade calculator GUI for this method to work
     */
    @FXML
    void calculateGrade(ActionEvent event) {
    	
    	projectGradeErrorLabel.setText("");
    	
    	// initializing variables for calculations and other uses later
    	double courseGrade = 0.0;
    	double projectWeight = 0.5;
    	double ccWeight = 0.25;
    	double quizWeight = 0.25; 
    	double projectMass = 0.0;
    	int reqCCPassed = 0;
    	int optionCCPassed = 0;
    	double projectGrade = 0.0;
    	
    	//getting text from text field
    	String projectValueEntered = projectgradeTextfield.getText();

    	//calling getProjectGrade function to validate user input in text field
    	if (!projectValueEntered.isEmpty()) {
    		projectGrade = getProjectGrade(projectValueEntered);
 
    	} else {
    		projectGrade = 0.0;
    	}
    	
    	
   		//Calculating projectMass
   		projectMass = (projectGrade)*projectWeight;    	

    	
    	//calculating quiz mass
    	double quizGrade = avgQuizGrade();
      	double quizMass = quizGrade * quizWeight;
    	
    	// getting values from choice boxes and calculating CC mass
		int ccPassed = getReqCC(reqCCPassed) + getOptionCC(optionCCPassed);
		double ccMass = (Double.valueOf(ccPassed)*100/20) * ccWeight;

		// updating course grade
		courseGrade = courseGrade + projectMass + quizMass + ccMass; 
 		
		/* console prints used while debugging
    	System.out.println("Project Grade Entered " + projectGrade);
    	System.out.println("Quiz Grade Entered: "+ quizGrade);
    	System.out.println("Optional Coding Challenges passed: "+ optionCCchoicebox.getValue());
		System.out.println("Required Coding Challenges Passed: " + requiredCCchoicebox.getValue());	
    	System.out.println("Your Current Course Grade is: " + courseGrade);
        System.out.println(averageQuizGrade);
    	
        */
  		//printing calculated grade 
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade) + "%");
    }

}

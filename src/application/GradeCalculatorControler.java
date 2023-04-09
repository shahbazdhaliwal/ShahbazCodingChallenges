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
import javafx.util.Pair;


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
     * validates user input for choice box and returns int value of CC passed
     * @param reqCCPassed value of required CC passed choice box
     * @return return value of coding challenges passed
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
     * @return return value of optional coding challenges passed
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
     * resets the quiz grade error label to ""
     */
    void removeError() {
    	quizErrorLabel.setText("");
    }
    
    /**
     * sets quizErrorLabel to display why error was encountered
     * @param quizzes instance of Grade class where quizzes were initialized
     */
    void setError(Grade quizzes) {
    	quizErrorLabel.setText("Error in one or more quiz text fields. Error caused by: "+ quizzes.quizErrorValue);
    }
       
    /**
     * gets values from quiz grade text fields and appends them onto a double[] list. TextField Strings are verified
     * by Grade class
     * @param mainScene main scene of GUI
     * @param quizGradeTextFields that is an array of all the different text fields
     * @param typeOfQuiz variable that dictates whether to read optional quiz grades or required
     */
    void calculateQuizGrade(Scene mainScene, ArrayList<TextField> quizGradeTextFields, int typeOfQuiz) {
    	int quizCheck = 1;
    	//case for if user wants to enter option quiz grades
    	if (typeOfQuiz == quizCheck) {
    		Grade optionQuizzes = new Grade();
    		quizOptionList = optionQuizzes.resetList(quizOptionList);
    		quizOptionList = optionQuizzes.fromTextFieldsToArray
    				(quizOptionList, quizGradeTextFields, 10).toArray(quizOptionList);
    		Grade findTopFive = new Grade();
    		quizOptionList = findTopFive.findTopFive(quizOptionList);
    		optionalGradeLabel.setText(String.format("%.2f", optionQuizzes.findListAverage(quizOptionList, 5)) + "%" );
    		if (optionQuizzes.error == true) {
    			setError(optionQuizzes);
    		} else {
    			removeError();
    		}
    	} else {
    		Grade requiredQuizzes = new Grade();
    		quizGradeList = requiredQuizzes.resetList(quizGradeList);
    		quizGradeList = requiredQuizzes.fromTextFieldsToArray
    				(quizGradeList, quizGradeTextFields, 10).toArray(quizGradeList);
    		requiredGradeLabel.setText(String.format("%.2f", requiredQuizzes.findListAverage(quizGradeList, 15.0)) + "%" );
    		if (requiredQuizzes.error == true) {
    			setError(requiredQuizzes);
    		} else {
    			removeError();
    		}
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
        
        SceneEditor makeRows = new SceneEditor();
        VBox vBox = makeRows.makeRows(numberofQuizzes);
        
    	//makes sure choice box values are valid in order to make a new window and configures the done button
    	if ((reqQuizzesChoiceBox.getValue() != null && numberofQuizzes == reqQuizzesChoiceBox.getValue()) 
    			|| (quizzesChoiceBox.getValue() != null && numberofQuizzes == quizzesChoiceBox.getValue())) {
    		
    		SceneEditor newButton = new SceneEditor();
    		HBox buttonRow = newButton.makeButton();
    		ArrayList<TextField> quizGradeTextFields = makeRows.quizGradeTextFields;
    		
    		newButton.doneButton.setOnAction(doneEvent -> calculateQuizGrade(mainScene, quizGradeTextFields, typeOfQuiz));
			
        	vBox.getChildren().add(buttonRow);
        	
        	Scene quizScene = new Scene(vBox);
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
     * Takes user input from a Grade Calculator GUI that has a text field for project grade, 2 choice boxes for required 
     * and optional coding challenges completed and a 2 choice boxes to indicate average quiz grade. From user input data, the user's
     * course grade is calculated. 
     * @param event the button "Calculate Grade" must be clicked on when in the grade calculator GUI for this method to work
     * @throws InvalidGradeException 
     */
    @FXML
    void calculateGrade(ActionEvent event) throws InvalidGradeException {
    	
    	projectGradeErrorLabel.setText("");
    	
    	// initializing variables for calculations and other uses later
    	double courseGrade = 0.0;
    	double projectWeight = 0.5;
    	double ccWeight = 0.25*100/20;
    	double quizWeight = 0.25; 
    	int reqCCPassed = 0;
    	int optionCCPassed = 0;
    	
    	//getting text from text field
    	String projectValueEntered = projectgradeTextfield.getText();
    	
    	Grade projectCalc;
    	
    	//using grade class to validate user input in text field
    	if (!projectValueEntered.isEmpty()) {
    		try {
    			projectCalc = new Grade(projectValueEntered, 100, projectWeight);
    			if (projectCalc.error == true) {
        			projectGradeErrorLabel.setText("Don't include the following character in the project grade: " + projectCalc.errorValue);
    			}
    		} catch (InvalidGradeException e) {
    			projectCalc = new Grade(0.0, 100, projectWeight);
    			projectGradeErrorLabel.setText("Invalid Value: " + projectValueEntered + " entered. Enter a number from 0 to 100.");
    		}
    		
    	} else {
    		projectCalc = new Grade(0.0, 100, projectWeight);
    		projectGradeErrorLabel.setText("Project Grade Text Field is Empty");
    	}

    	
    	//calculating quiz mass
    	Grade calculateQuizzes = new Grade();
    	double quizGrade = calculateQuizzes.avgList(quizGradeList, quizOptionList, 20.0);
      	double quizMass = calculateQuizzes.doCalculation(quizGrade, quizWeight);
    	
    	// getting values from choice boxes and calculating CC mass
		int ccPassed = getReqCC(reqCCPassed) + getOptionCC(optionCCPassed);
		Grade ccCalc = new Grade();
		double ccGrade = ccCalc.doCalculation(ccPassed, ccWeight);
		
		double projectGrade = projectCalc.value * projectCalc.weightOfComponent;
		
		// updating course grade
		courseGrade = courseGrade + projectGrade + quizMass + ccGrade; 
 		
  		//printing calculated grade 
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade) + "%");
    }

}

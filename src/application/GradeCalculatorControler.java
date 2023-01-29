package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class GradeCalculatorControler {

	@FXML
	private ChoiceBox<Integer> requiredCCchoicebox;

    @FXML
    private TextField projectgradeTextfield;

    @FXML
    private Slider quizgradeSlider;
    
    @FXML
    private Label projectGradeErrorLabel;
    
    @FXML
    private ChoiceBox<Integer> optionCCchoicebox;
    
    @FXML
    private Label courseGradeLabel;
    
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
    	
    	//getting text from text field
    	String projectValueEntered = projectgradeTextfield.getText();

    	//calling getProjectGrade function to validate user input in text field
    	double projectGrade = getProjectGrade(projectValueEntered);
    	
   		//Calculating projectMass
   		projectMass = (projectGrade)*projectWeight;    	

    	
    	// getting values from slider and calculating quiz mass
    	double quizGrade = quizgradeSlider.getValue();    
      	double quizMass = quizGrade * 10.0 * quizWeight;
    	
    	// getting values from choice boxes and calculating CC mass
    	int reqCCPassed = requiredCCchoicebox.getValue();
		int optionCCPassed = optionCCchoicebox.getValue();
		int ccPassed = reqCCPassed + optionCCPassed;
		double ccMass = (Double.valueOf(ccPassed)*100/20) * ccWeight;

		// updating course grade
  		courseGrade = courseGrade + projectMass + quizMass + ccMass; 

  		/* console prints used while debugging
    	System.out.println("Project Grade Entered " + projectGrade);
    	System.out.println("Quiz Grade Entered: "+ quizGrade);
    	System.out.println("Optional Coding Challenges passed: "+ optionCCchoicebox.getValue());
		System.out.println("Required Coding Challenges Passed: " + requiredCCchoicebox.getValue());	
    	System.out.println("Your Current Course Grade is: " + courseGrade);
        */
  		
    	//printing calculated grade 
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade) + "%");
    }

}

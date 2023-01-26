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
    private ChoiceBox<Integer> optionCCchoicebox;
    
    @FXML
    private Label courseGradeLabel;

    @FXML
    void calculateGrade(ActionEvent event) {
    	
    	// initializing variables for calculations later
    	double courseGrade = 0.0;
    	double projectWeight = 0.4;
    	double ccWeight = 0.35;
    	double quizWeight = 0.25;    	
    	
    	// getting values from text field and calculating project mass
    	String projectGrade = projectgradeTextfield.getText();
    	double projectMass = Double.parseDouble(projectGrade)*projectWeight;    	
    	
    	// getting values from slider and calculating quiz mass
    	double quizGrade = quizgradeSlider.getValue();
    	double quizMass = quizGrade * quizWeight;
    	
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
    	
    	courseGradeLabel.setText(String.format("Your overall course grade is: %.2f", courseGrade) + "%");
    }

}

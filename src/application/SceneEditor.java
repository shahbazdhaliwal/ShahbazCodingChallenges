package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SceneEditor {
	//ArrayList that contains all text fields that are generated
	ArrayList<TextField> quizGradeTextFields = new ArrayList<TextField>();
	Button doneButton;
	
	/**
	 * makes a desired amount of text fields and puts them into a VBox
	 * @param numberofTextFields int
	 * @return VBox with all text fields
	 */
	VBox makeRows(int numberofTextFields) {
		int rowCounter = 0;
    	VBox allRows = new VBox();
    	allRows.setAlignment(Pos.TOP_CENTER);
    	
    	
    	while (rowCounter < numberofTextFields) {
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
    	return allRows;
    	
	}
	
	/**
	 * makes a button and places it inside an HBox
	 * @return returns the HBox
	 */
	HBox makeButton() {
		
		HBox buttonRow = new HBox();
		
		buttonRow.setPrefWidth(150.0);
		buttonRow.setPrefHeight(20.0);
		buttonRow.setAlignment(Pos.CENTER);
		
		doneButton = new Button("Done");
		doneButton.setAlignment(Pos.TOP_CENTER);
		
		buttonRow.getChildren().addAll(doneButton);
		
		return buttonRow;
	}

}

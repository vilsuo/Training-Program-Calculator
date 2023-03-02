
package com.mycompany.controllers;

import com.mycompany.domain.types.Exercise;
import com.mycompany.domain.SmolovJrTrainingProgram;
import com.mycompany.logic.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SmolovJrViewController {
    
    @FXML private Label errorLabel;
    
    @FXML private TextField oneRepMaxTextField;
    
    @FXML private ComboBox exerciseNameComboBox;
    @FXML private ComboBox incrementComboBox;
    
    public void initialize() {
        final ObservableList<String> incrementOptions = 
            FXCollections.observableArrayList(
                "1.0",
                "1.5",
                "2.0",
                "2.5",
                "5.0",
                "7.5",
                "10.0"
            );
        this.incrementComboBox.getItems().addAll(incrementOptions);
        this.incrementComboBox.getSelectionModel().select(3); // 2.5
        
        final ObservableList<String> exerciseNameOptions = 
            FXCollections.observableArrayList(
                    Exercise.BARBELL_SQUAT.label,
                    Exercise.BENCH_PRESS.label
            );
        this.exerciseNameComboBox.getItems().addAll(exerciseNameOptions);
        this.exerciseNameComboBox.getSelectionModel().selectFirst(); // Squat
    }
    
    @FXML
    private void onCalculateButtonPressed() {
        SmolovJrTrainingProgram program = createSmolovJrTrainingProgram();
        
        if (program == null){
            // show error
            this.errorLabel.setText(
                    "Invalid value(s) entered. Enter the values in the range"
                  + " [0,1000), with the accuracy of atmost three decimals"
            );
            return;
        }
        
        // clear the potential error message
        this.errorLabel.setText("");
        
        System.out.println(program);
        
        // send program to a new window...
        
    }
    
    private SmolovJrTrainingProgram createSmolovJrTrainingProgram() {
        String input = this.oneRepMaxTextField.getText();
        
        if (!Utilities.validateOneRepMaxInput(input)){
            return null;
        }
        
        Exercise exerciseName = Exercise.valueOfLabel(
                this.exerciseNameComboBox.getValue().toString()
        );
        double oneRepMax = Utilities.getInputDoubleValue(input);
        double increment = Double.valueOf(
                this.incrementComboBox.getValue().toString()
        );
        
        return new SmolovJrTrainingProgram(exerciseName, oneRepMax, increment);
    }
    
}


package com.mycompany.controllers;

import com.mycompany.domain.SmolovJrTrainingProgram;
import com.mycompany.logic.Utilities;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SmolovJrViewController implements Initializable {
    
    @FXML private Label errorLabel;
    
    @FXML private TextField oneRepMaxTextField;
    
    @FXML private ComboBox incrementComboBox;
    
    @FXML private ComboBox exerciseNameComboBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
                "Squat",
                "Bench"
            );
        
        this.exerciseNameComboBox.getItems().addAll(exerciseNameOptions);
        this.exerciseNameComboBox.getSelectionModel().selectFirst(); // Squat
    }
    
    @FXML
    private void onCalculateButtonPressed() throws Exception {
        String input = this.oneRepMaxTextField.getText();
            
            if (!validateInput(input)){
                return;
            }
            
            // clear the potential error message
            this.errorLabel.setText("");
            
            String exerciseName = this.exerciseNameComboBox.getValue().toString();
            double oneRepMax = Utilities.getInputDoubleValue(input);
            double increment = Double.valueOf(this.incrementComboBox.getValue().toString());
            
            SmolovJrTrainingProgram program = new SmolovJrTrainingProgram(exerciseName, oneRepMax, increment);
            System.out.println(program);
    }
    
    private boolean validateInput(String input) {
        if (!Utilities.validateOneRepMaxInput(input)) {
            errorLabel.setText("Invalid value(s) entered. Enter the values in a range [0,1000)"
                + ", with the accuracy of atmost three decimals");
            return false;
        }
        return true;
    }
    
}

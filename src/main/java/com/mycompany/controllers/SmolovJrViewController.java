
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
    
    //@FXML private TrainingCycleViewController trainingCycleViewController;
    
    @FXML private Label errorLabel;
    
    @FXML private TextField oneRepMaxTextField;
    
    @FXML private ComboBox incrementComboBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final ObservableList<String> incrementOptions = 
            FXCollections.observableArrayList(
                "0.0",
                "1.0",
                "1.25",
                "2.5",
                "3.75",
                "5.0",
                "6.25",
                "7.5",
                "8.75",
                "10.0"
            );
        
        this.incrementComboBox.getItems().addAll(incrementOptions);
        this.incrementComboBox.getSelectionModel().select(3); // 2.5
    }
    
    @FXML
    private void onCalculateButtonPressed() throws Exception {
        String input = this.oneRepMaxTextField.getText().strip();
            
            if (!Utilities.validateOneRepMaxInput(input)) {
                this.errorLabel.setText("Your one rep max is in an incorrect form.");
                return;
            }
            
            // clear the potential error message
            this.errorLabel.setText("");
            
            double increment = Double.valueOf(this.incrementComboBox.getValue().toString());
            
            double value = Double.valueOf(input.replace(",", "."));
            double oneRepMax = Utilities.getRounded(value, increment);
            System.out.println("your one rep max used in calculations: " + oneRepMax);
            
            // update table
            //this.trainingCycleViewController.updateTrainingTable(this.oneRepMax, this.increment);
            SmolovJrTrainingProgram program = new SmolovJrTrainingProgram(oneRepMax, increment);
            System.out.println(program);
    }
    
}

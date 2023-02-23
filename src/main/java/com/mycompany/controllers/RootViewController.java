
package com.mycompany.controllers;

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

public class RootViewController implements Initializable {
    
    @FXML private TrainingCycleViewController trainingCycleViewController;
    
    private double oneRepMax;
    private double increment;
    
    @FXML
    private Label errorLabel;
    
    @FXML
    private TextField insertOneRepMaxtextField;
    
    @FXML
    private ComboBox chooseIncrementComboBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final ObservableList<String> incrementOptions = 
            FXCollections.observableArrayList(
                "1.0",
                "1.25",
                "2.5", 
                "5.0"
            );
        this.chooseIncrementComboBox.getItems().addAll(incrementOptions);
    }
    
    @FXML
    private void onCalculateButtonPressed() throws Exception {
        String input = this.insertOneRepMaxtextField.getText().strip();
            
            if (!input.matches("[0-9]{1,3}([,.][0-9]{0,3})?")) {
                this.errorLabel.setText("Your one rep max is in an incorrect form.");
                return;
            }
            
            if (this.chooseIncrementComboBox.getValue() == null) {
                this.errorLabel.setText("You have not selected the increment.");
                return;
            }
            
            // clear error message
            this.errorLabel.setText("");
            this.oneRepMax = Double.valueOf(input.replace(",", "."));
            
            this.oneRepMax = Utilities.getRounded(this.oneRepMax, this.increment);
            System.out.println("your one rep max used in calculations: " + this.oneRepMax);
            
            // update table
            this.trainingCycleViewController.updateTrainingTable(this.oneRepMax, this.increment);
    }
    
    @FXML
    private void onIncrementChoosen() throws Exception {
        this.increment = Double.valueOf(this.chooseIncrementComboBox.getValue().toString());
    }
}

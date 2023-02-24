
package com.mycompany.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;


public class Wendler531SettingsViewController implements Initializable {
    
    @FXML private ComboBox trainingMaxPercentComboBox;
    @FXML private ComboBox upperBodyIncrementComboBox;
    @FXML private ComboBox lowerBodyIncrementComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final ObservableList<String> trainingMaxPercentageOptions = 
            FXCollections.observableArrayList(
                "80.0",
                "85.0",
                "90.0",
                "95.0"
            );
        this.trainingMaxPercentComboBox.getItems().addAll(trainingMaxPercentageOptions);
        // here really the default value should be 90
        this.trainingMaxPercentComboBox.getSelectionModel().selectFirst();
        
        final ObservableList<String> addToTrainingMaxOptions = 
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
        
        this.upperBodyIncrementComboBox.getItems().addAll(addToTrainingMaxOptions);
        this.lowerBodyIncrementComboBox.getItems().addAll(addToTrainingMaxOptions);
        
        this.upperBodyIncrementComboBox.getSelectionModel().selectFirst();
        this.lowerBodyIncrementComboBox.getSelectionModel().selectFirst();
    }
    
    public double getTrainingMaxPercent() {
        return Double.valueOf(this.trainingMaxPercentComboBox.getValue().toString());
    }
    
    public double getUpperBodyIncrement() {
        return Double.valueOf(this.upperBodyIncrementComboBox.getValue().toString());
    }
    
    public double getLowerBodyIncrement() {
        return Double.valueOf(this.lowerBodyIncrementComboBox.getValue().toString());
    }
}

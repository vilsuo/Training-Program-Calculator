
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
                "85.0",
                "87.5",
                "90.0",
                "92.5",
                "95.0"
            );
        this.trainingMaxPercentComboBox.getItems().addAll(trainingMaxPercentageOptions);
        this.trainingMaxPercentComboBox.getSelectionModel().select(2); // 90.0
        
        final ObservableList<String> addToUBTrainingMaxOptions = 
            FXCollections.observableArrayList(
                "0.0",
                "2.5",
                "5.0",
                "7.5",
                "10.0",
                "12.5",
                "15.0",
                "17.5",
                "20.0"
            );
        
        final ObservableList<String> addToLBTrainingMaxOptions = 
            FXCollections.observableArrayList(
                "0.0",
                "5.0",
                "10.0",
                "15.0",
                "20.0",
                "25.0",
                "30.0",
                "35.0",
                "40.0"
            );
        
        this.upperBodyIncrementComboBox.getItems().addAll(addToUBTrainingMaxOptions);
        this.lowerBodyIncrementComboBox.getItems().addAll(addToLBTrainingMaxOptions);
        
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

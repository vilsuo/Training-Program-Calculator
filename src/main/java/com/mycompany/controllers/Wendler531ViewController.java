/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.domain.Wendler531TrainingProgram;
import com.mycompany.logic.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Wendler531ViewController {
    
    @FXML private TextField ohpORMTextField;
    @FXML private TextField benchORMTextField;
    @FXML private TextField squatORMTextField;
    @FXML private TextField deadliftORMTextField;
    
    @FXML private Label tORMLabel;
    
    @FXML private Label ohpTORMTextField;
    @FXML private Label benchTORMField;
    @FXML private Label squatTORMTextField;
    @FXML private Label deadliftTORMTextField;
    
    @FXML private Label errorLabel;
    
    @FXML private ComboBox trainingMaxPercentComboBox;
    @FXML private ComboBox upperBodyIncrementComboBox;
    @FXML private ComboBox lowerBodyIncrementComboBox;
    
    public void initialize() {
        final ObservableList<String> trainingMaxPercentageOptions = 
            FXCollections.observableArrayList(
                "85.0",
                "87.5",
                "90.0",
                "92.5",
                "95.0"
            );
        this.trainingMaxPercentComboBox.getItems()
                .addAll(trainingMaxPercentageOptions);
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
        this.upperBodyIncrementComboBox.getItems()
                .addAll(addToUBTrainingMaxOptions);
        this.upperBodyIncrementComboBox.getSelectionModel().selectFirst(); // 0.0
        
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
        
        this.lowerBodyIncrementComboBox.getItems()
                .addAll(addToLBTrainingMaxOptions);
        this.lowerBodyIncrementComboBox.getSelectionModel().selectFirst(); // 0.0
    }
    
    @FXML
    private void onCalculateButtonPressed() {
        // clear previous training max text
        clearTORMLabels();
        
        // check all one rep max inputs
        String ohpInput = this.ohpORMTextField.getText();
        String benchInput = this.benchORMTextField.getText();
        String squatInput = this.squatORMTextField.getText();
        String deadliftInput = this.deadliftORMTextField.getText();
        
        String[] inputs = new String[]{
            ohpInput, benchInput, squatInput, deadliftInput
        };
        
        // proceed only if all inputs are valid
        if(!areInputsValid(inputs)) {
            // show error
            return;
        }
        
        // calculate training one rep maxes
        double uBIncrement = Double.valueOf(
                this.upperBodyIncrementComboBox.getValue().toString()
        );
        double lBIncrement = Double.valueOf(
                this.lowerBodyIncrementComboBox.getValue().toString()
        );
        
        double ohpTORM = calculateTORM(
                Utilities.getInputDoubleValue(ohpInput), uBIncrement
        );
        double benchTORM = calculateTORM(
                Utilities.getInputDoubleValue(benchInput), uBIncrement
        );
        double squatTORM = calculateTORM(
                Utilities.getInputDoubleValue(squatInput), lBIncrement
        );
        double deadliftTORM = calculateTORM(
                Utilities.getInputDoubleValue(deadliftInput), lBIncrement
        );
        
        // update view to show training one rep maxes
        showTORMLabels(ohpTORM, benchTORM, squatTORM, deadliftTORM);
        
        // create the training program
        Wendler531TrainingProgram program = new Wendler531TrainingProgram(
                ohpTORM, deadliftTORM, benchTORM, squatTORM
        );
        
        System.out.println(program);
    }
    
    private double calculateTORM(double oneRepMax, double increment) {
        double tORMPercentage = Double.valueOf(
                this.trainingMaxPercentComboBox.getValue().toString()
        );
        return tORMPercentage/100.0 * oneRepMax + increment;
    }
    
    private boolean areInputsValid(String[] inputs) {
        for (int i = 0; i < inputs.length; ++i) {
            if (!Utilities.validateOneRepMaxInput(inputs[i])) {
                this.errorLabel.setText(
                        "Invalid value(s) entered. Enter the values in the range"
                      + " [0,1000), with the accuracy of atmost three decimals");
                return false;
            }
        }
        return true;
    }
    
    private void clearTORMLabels() {
        this.tORMLabel.setText("");
        this.ohpTORMTextField.setText("");
        this.benchTORMField.setText("");
        this.squatTORMTextField.setText("");
        this.deadliftTORMTextField.setText("");
    }
    
    private void showTORMLabels(double ohpTROM, double benchTORM,
            double squatTORM, double deadliftTORM)
    {
        // clear the potential error message
        this.errorLabel.setText("");
        
        this.tORMLabel.setText("Training ORM");
        this.ohpTORMTextField.setText(String.format("%.3f", ohpTROM));
        this.benchTORMField.setText(String.format("%.3f", benchTORM));
        this.squatTORMTextField.setText(String.format("%.3f", squatTORM));
        this.deadliftTORMTextField.setText(String.format("%.3f", deadliftTORM));
    }
    
}


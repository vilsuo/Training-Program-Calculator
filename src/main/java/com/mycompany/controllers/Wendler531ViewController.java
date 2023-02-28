/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.domain.Wendler531TrainingProgram;
import com.mycompany.logic.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Wendler531ViewController {
    
    @FXML private Wendler531SettingsViewController wendler531SettingsViewController;
    
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
    
    @FXML
    private void onCalculateButtonPressed() throws Exception {
        // clear previous training max text
        clearTORMLabels();
        
        // check all one rep max inputs
        String ohpInput = this.ohpORMTextField.getText();
        String benchInput = this.benchORMTextField.getText();
        String squatInput = this.squatORMTextField.getText();
        String deadliftInput = this.deadliftORMTextField.getText();
        
        // proceed only if all inputs are valid
        if(!validateInput(ohpInput) || !validateInput(benchInput)
                || !validateInput(squatInput) ||  !validateInput(deadliftInput)) {
            return;
        }
        
        // clear the potential error message
        this.errorLabel.setText("");
        
        // calculate training one rep maxes
        double uBIncrement = this.wendler531SettingsViewController
                .getUpperBodyIncrement();
        double lBIncrement = this.wendler531SettingsViewController
                .getLowerBodyIncrement();
        
        double ohpTROM = calculateTORM(Utilities.getInputDoubleValue(ohpInput), uBIncrement);
        double benchTORM = calculateTORM(Utilities.getInputDoubleValue(benchInput), uBIncrement);
        double squatTORM = calculateTORM(Utilities.getInputDoubleValue(squatInput), lBIncrement);
        double deadliftTORM = calculateTORM(Utilities.getInputDoubleValue(deadliftInput), lBIncrement);
        
        // update view to show training one rep maxes
        updateTORMLabels(ohpTROM, benchTORM, squatTORM, deadliftTORM);
        
        // create the training program
        Wendler531TrainingProgram program 
                = new Wendler531TrainingProgram(ohpTROM, deadliftTORM, benchTORM, squatTORM);
        System.out.println(program);
    }
    
    private double calculateTORM(double oneRepMax, double increment) {
        double tORMPercentage = this.wendler531SettingsViewController.getTrainingMaxPercent();
        return tORMPercentage/100.0 * oneRepMax + increment;
    }
    
    private boolean validateInput(String input) {
        if (!Utilities.validateOneRepMaxInput(input)) {
            this.errorLabel.setText("Invalid value(s) entered. Enter the values in a range [0,1000)"
                + ", with the accuracy of atmost three decimals");
            return false;
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
    
    private void updateTORMLabels(double ohpTROM, double benchTORM, double squatTORM, double deadliftTORM) {
        this.tORMLabel.setText("Training ORM");
        this.ohpTORMTextField.setText(String.format("%.3f", ohpTROM));
        this.benchTORMField.setText(String.format("%.3f", benchTORM));
        this.squatTORMTextField.setText(String.format("%.3f", squatTORM));
        this.deadliftTORMTextField.setText(String.format("%.3f", deadliftTORM));
    }
    
}


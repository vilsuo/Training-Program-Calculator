/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.logic.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Wendler531ViewController {
    
    @FXML private Wendler531SettingsViewController wendler531SettingsViewController;
    
    @FXML private TextField ohpOneRepMaxTextField;
    @FXML private TextField benchOneRepMaxTextField;
    @FXML private TextField squatOneRepMaxTextField;
    @FXML private TextField deadliftOneRepMaxTextField;
    
    @FXML private Label ohpTrainingOneRepMaxTextField;
    @FXML private Label benchTrainingOneRepMaxTextField;
    @FXML private Label squatTrainingOneRepMaxTextField;
    @FXML private Label deadliftTrainingOneRepMaxTextField;
    
    @FXML private Label errorLabel;
    
    // lot of copy pasta here...
    @FXML
    private void onCalculateButtonPressed() throws Exception {
        // check all one rep max inputs
        String ohpInput = cleanInput(this.ohpOneRepMaxTextField.getText());
        if (!validateInput(ohpInput, "Your ohp one rep max is in an incorrect form.")) {
            return;
        }
        double ohpOneRepMax = Double.valueOf(ohpInput);
        
        String benchInput = cleanInput(this.benchOneRepMaxTextField.getText());
        if (!validateInput(benchInput, "Your bench one rep max is in an incorrect form.")) {
            return;
        }
        double benchOneRepMax = Double.valueOf(benchInput);
        
        String squatInput = cleanInput(this.squatOneRepMaxTextField.getText());
        if (!validateInput(squatInput, "Your squat one rep max is in an incorrect form.")) {
            return;
        }
        double squatOneRepMax = Double.valueOf(squatInput);
        
        String deadliftInput = cleanInput(this.deadliftOneRepMaxTextField.getText());
        if (!validateInput(deadliftInput, "Your deadlift one rep max is in an incorrect form.")) {
            return;
        }
        double deadliftOneRepMax = Double.valueOf(deadliftInput);
        
        
        // clear the potential error message
        this.errorLabel.setText("");
        
        double trMaxPercentage = wendler531SettingsViewController.getTrainingMaxPercent();
        double uBIncrement = wendler531SettingsViewController.getUpperBodyIncrement();
        double lBIncrement = wendler531SettingsViewController.getLowerBodyIncrement();
        
        double ohpTrainingOneRepMax = trMaxPercentage/100 * ohpOneRepMax + uBIncrement;
        double benchTrainingOneRepMax = trMaxPercentage/100 * benchOneRepMax + uBIncrement;
        double squatTrainingOneRepMax = trMaxPercentage/100 * squatOneRepMax + lBIncrement;
        double deadliftTrainingOneRepMax = trMaxPercentage/100 * deadliftOneRepMax + lBIncrement;
        
        this.ohpTrainingOneRepMaxTextField.setText(String.valueOf(ohpTrainingOneRepMax));
        this.benchTrainingOneRepMaxTextField.setText(String.valueOf(benchTrainingOneRepMax));
        this.squatTrainingOneRepMaxTextField.setText(String.valueOf(squatTrainingOneRepMax));
        this.deadliftTrainingOneRepMaxTextField.setText(String.valueOf(deadliftTrainingOneRepMax));
        
        // update table
        //this.trainingCycleViewController.updateTrainingTable(this.oneRepMax, this.increment);
        //SmolovJrTrainingProgram program = new SmolovJrTrainingProgram(this.oneRepMax, this.increment);
        //System.out.println(program);
        
    }
    
    private String cleanInput(String input) {
        return input.strip().replace(",", ".");
    }
    
    private boolean validateInput(String input, String errorText) {
        if (!Utilities.validateOneRepMaxInput(input)) {
            this.errorLabel.setText(errorText);
            return false;
        }
        return true;
    }
    
}


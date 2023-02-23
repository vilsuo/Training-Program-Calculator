
package com.mycompany.controllers;

import javafx.fxml.FXML;

public class TrainingCycleViewController {
    
    @FXML private TrainingTableViewController trainingTableView1Controller;
    @FXML private TrainingTableViewController trainingTableView2Controller;
    @FXML private TrainingTableViewController trainingTableView3Controller;

    
    public void updateTrainingTable(double oneRepMax, double increment) {
        this.trainingTableView1Controller.updateTrainingTable(oneRepMax, increment, 1);
        this.trainingTableView2Controller.updateTrainingTable(oneRepMax, increment, 2);
        this.trainingTableView3Controller.updateTrainingTable(oneRepMax, increment, 3);
    }
}

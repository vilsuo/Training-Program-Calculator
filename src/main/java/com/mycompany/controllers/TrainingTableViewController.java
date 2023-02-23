
package com.mycompany.controllers;

import com.mycompany.domain.TrainingPlan;
import com.mycompany.domain.WorkOutDay;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class TrainingTableViewController implements Initializable {
    
    @FXML
    private Label tableTitle;
    
    @FXML
    private TableView trainingTable;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void updateTrainingTable(double oneRepMax, double increment, int week) {
        TrainingPlan plan = new TrainingPlan(oneRepMax, increment, week);
        final ObservableList<WorkOutDay> data = FXCollections.observableList(
            plan.getTrainingPlan()
        );
        this.trainingTable.setItems(data);
        this.tableTitle.setText("Week " + week);
    }

}


package com.mycompany.controllers;

import com.mycompany.navigators.TrainingProgramViewNavigator;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class RootViewController {
    
    @FXML private BorderPane root;
    
    @FXML private StackPane trainingProgramPane;
    @FXML private StackPane paginationPane;
    
    @FXML
    private void changeSmolovJR() {
        TrainingProgramViewNavigator.loadTrainingProgramView(
                TrainingProgramViewNavigator.SMOLOV_JR
        );
    }
    
    @FXML
    private void changeWendler531() {
        TrainingProgramViewNavigator.loadTrainingProgramView(
                TrainingProgramViewNavigator.WENDLER_531
        );
    }
    
    public void setTrainingProgram(Node node) {
        this.trainingProgramPane.getChildren().setAll(node);
    }
    
    public void setPagination(Node node) {
        this.paginationPane.getChildren().setAll(node);
    }
}

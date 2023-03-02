
package com.mycompany.controllers;

import com.mycompany.domain.bases.TrainingProgramBase;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;

public class PaginationViewController {
    
    @FXML private Pagination pagination;
    
    private TrainingProgramBase trainingProgram;
    
    public void setTrainingProgram(TrainingProgramBase trainingProgram) {
        this.trainingProgram = trainingProgram;
        
        this.pagination.setPageCount(this.trainingProgram.getNumberOfWeeks());
        
        this.pagination.setPageFactory(this::createPage);
    }
    
    private VBox createPage(int index) {
        if (index >= this.trainingProgram.getNumberOfWeeks()) {
            return null;
        }
        
        Label trainingWeek = new Label(
                this.trainingProgram.getWorkoutWeek(index).toString()
        );
        
        VBox page = new VBox();
        page.getChildren().add(trainingWeek);
        return page;
    }
    
}


package com.mycompany.controllers;

import com.mycompany.domain.TrainingProgram;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class PaginationViewController {
    
    @FXML private Pagination pagination;
    
    private TrainingProgram trainingProgram;
    
    public PaginationViewController() {
        this.trainingProgram = new TrainingProgram("No Training Program Entered");
    }
    
    public PaginationViewController(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
        
    }
    /*
    public void initialize() {
        this.pagination.setPageCount(this.trainingProgram.weeks());
        this.trainingProgram.weeks();
        this.pagination.setPageFactory(new Callback<Integer, Node>() {
            
            @Override
            public Node call(Integer pageIndex) {
                return createPage(pageIndex);
            }
        });
    }
    
    private VBox createPage(int index) {
        if (index >= this.trainingProgram.weeks()) {
            return null;
        }
        
        Label trainingWeek = new Label(
                this.trainingProgram.getWorkoutWeek(index).toString()
        );
        
        VBox page = new VBox();
        page.getChildren().add(trainingWeek);
        return page;
    }
    */
}

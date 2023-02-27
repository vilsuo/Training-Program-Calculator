
package com.mycompany.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class RootViewController implements Initializable {
    
    @FXML private BorderPane root;
    
    @FXML private MenuViewController menuViewController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

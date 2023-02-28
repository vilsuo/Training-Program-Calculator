
package com.mycompany.controllers;

import com.mycompany.Main;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class RootViewController {
    
    @FXML private BorderPane root;
    
    @FXML
    private void changeSmolovJR() {
        try {
            URL fileURL = Main.class.getResource("fxml/SmolovJrView.fxml");
            this.root.setCenter(new FXMLLoader().load(fileURL));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @FXML
    private void changeWendler531() {
        try {
            URL fileURL = Main.class.getResource("fxml/Wendler531View.fxml");
            this.root.setCenter(new FXMLLoader().load(fileURL));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

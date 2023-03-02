package com.mycompany.controllers;

import com.mycompany.logic.PropertyManager;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class MenuViewController implements Initializable {
    
    @FXML private ToggleGroup weightAccuracyToggleGroup;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setUpSavedSettingSelections();
        
        this.weightAccuracyToggleGroup.selectedToggleProperty().addListener(
            (ov, old_toggle, new_toggle) -> {
                if (new_toggle != null) {
                    try {
                        RadioMenuItem rmi = (RadioMenuItem) new_toggle;
                        new PropertyManager().writeProperty(
                                "weightAccuracy", rmi.getText(), "selected weight accuracy");
                        
                    } catch (Exception ex) {
                        System.out.println("Error setting the weight accuracy: " + ex.getMessage());
                    }
                }
            });
    }
    
    private void setUpSavedSettingSelections() {
        try {
            Properties props = new PropertyManager().loadProperties();
            
            // set up default selection
            String weightAccuracy = props.getProperty("weightAccuracy");
            this.weightAccuracyToggleGroup.getToggles().stream()
                    .map(toggle -> (RadioMenuItem) toggle)
                    .filter(rmi -> rmi.getText().equals(weightAccuracy))
                    .findAny().get().setSelected(true);
            
        } catch (Exception ex) {
            System.out.println("Error setting up the saved toggle group options: " + ex.getMessage());
        }
    }
}

package com.mycompany.controllers;

import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;


public class MenuViewController implements Initializable {
    
    @FXML private ToggleGroup weightAccuracyToggleGroup;
    @FXML private ToggleGroup trainingProgramToggleGroup;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // load saved properties
            String configFileName = "config.properties";
            FileReader reader = new FileReader(configFileName);
            Properties props = new Properties();
            props.load(reader);
            
            // set up default
            String weightAccuracy = props.getProperty("weightAccuracy");
            this.weightAccuracyToggleGroup.getToggles().stream()
                    .map(toggle -> (RadioMenuItem) toggle)
                    .filter(rmi -> rmi.getText().equals(weightAccuracy))
                    .findAny().get().setSelected(true);
            
            String trainingProgram = props.getProperty("trainingProgram");
            this.trainingProgramToggleGroup.getToggles().stream()
                    .map(toggle -> (RadioMenuItem) toggle)
                    .filter(rmi -> rmi.getText().equals(trainingProgram))
                    .findAny().get().setSelected(true);
            
        } catch (Exception ex) {
            System.out.println("Error setting up the saved toggle group options: " + ex.getMessage());
        }
        
        
        this.weightAccuracyToggleGroup.selectedToggleProperty().addListener(
            (ov, old_toggle, new_toggle) -> {
                RadioMenuItem rmi = (RadioMenuItem) new_toggle;
                if (new_toggle != null) {
                    try {
                        // load saved properties
                        String configFileName = "config.properties";
                        FileReader reader = new FileReader(configFileName);
                        Properties props = new Properties();
                        props.load(reader);
                        
                        props.setProperty("weightAccuracy", rmi.getText());
                        FileWriter writer = new FileWriter(configFileName);
                        
                        props.store(writer, "selected weight accuracy");
                        writer.close();
                        
                    } catch (Exception ex) {
                        System.out.println("Error setting the weight accuracy: " + ex.getMessage());
                    }
                }
            });
        
        this.trainingProgramToggleGroup.selectedToggleProperty().addListener(
            (ov, old_toggle, new_toggle) -> {
                RadioMenuItem rmi = (RadioMenuItem) new_toggle;
                try {
                    // load saved properties
                    String configFileName = "config.properties";
                    FileReader reader = new FileReader(configFileName);
                    Properties props = new Properties();
                    props.load(reader);
                    
                    props.setProperty("trainingProgram", rmi.getText());
                    FileWriter writer = new FileWriter(configFileName);
                    
                    props.store(writer, "selected training program");
                    writer.close();

                } catch (Exception ex) {
                    System.out.println("Error setting the training program: " + ex.getMessage());
                }
                
            });
    }
}


package com.mycompany;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
TODO
- create base class for training programs (abstract class?)

- implement training program change
- implement rounding in training programs

- toString-method: no string concatenations


*/

public class Main extends Application {
    
    @Override
    public void init() {
        try {
            File configFile = new File("config.properties");
            if (configFile.createNewFile()) {
                System.out.println("File " + configFile.getName() + " created");
                
                FileReader reader = new FileReader(configFile);
                Properties props = new Properties();
                props.load(reader);
                
                props.setProperty("weightAccuracy", "2.5");
                props.setProperty("trainingProgram", "Smolov Jr");
                
                FileWriter writer = new FileWriter(configFile);
                System.out.println("Properties written:");
                props.list(System.out);
                
                props.store(writer, "selected weight accuracy");
                writer.close();
            } else {
                System.out.println("File " + configFile.getName() + " already exists");
                
                FileReader reader = new FileReader(configFile);
                Properties props = new Properties();
                props.load(reader);
                
                System.out.println("Properties loaded:");
                props.list(System.out);
            }
            
        } catch (Exception ex) {
            System.out.println("Error in Main.init(): " + ex.getMessage());
        }
    }
            
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Smolov Jr Calculator FXML");
        Parent root = FXMLLoader.load(getClass().getResource("fxml/RootView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

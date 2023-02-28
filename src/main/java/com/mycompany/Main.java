
package com.mycompany;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
TODO
- create base class for training programs (abstract class?)

- organize files: smolov and wendler into own packages

- add info to training programs, with images

- smolov jr: add option to change for bench press
*/

public class Main extends Application {
      
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Training program calculator");
        Parent root = FXMLLoader.load(getClass().getResource("fxml/RootView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

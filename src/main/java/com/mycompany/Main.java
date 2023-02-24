
package com.mycompany;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
TODO
- toString-method: no string concatenations
  - is toString -method even necessary?

*/

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Smolov Jr Calculator FXML");
        Parent root = FXMLLoader.load(getClass().getResource("fxml/SmolovJrView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

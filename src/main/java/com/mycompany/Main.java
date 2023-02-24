
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
- create option to change between smolov jr and wendler5/3/1 (radio button?)
- create settings int menubar for changing the rounding
  - implement rounding in training programs

- toString-method: no string concatenations


*/

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Smolov Jr Calculator FXML");
        Parent root = FXMLLoader.load(getClass().getResource("fxml/Wendler531View.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

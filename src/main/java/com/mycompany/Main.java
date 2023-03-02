
package com.mycompany;

import com.mycompany.controllers.RootViewController;
import com.mycompany.navigators.TrainingProgramViewNavigator;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
- should training programs constructor (smolov/wendler) throw exceptions?

- error label wrap

*/
public class Main extends Application {
      
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Training program calculator");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
        Parent root = loader.load();
        
        RootViewController rootViewController = loader.getController();
        TrainingProgramViewNavigator.setRootViewController(rootViewController);
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

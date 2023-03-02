
package com.mycompany.navigators;

import com.mycompany.controllers.RootViewController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class TrainingProgramViewNavigator {
    
    public static final String SMOLOV_JR    = "/fxml/SmolovJrView.fxml";
    public static final String WENDLER_531  = "/fxml/Wendler531View.fxml";
    
    private static RootViewController rootViewController;
    
    //private Map<String, 
    
    public static void setRootViewController(RootViewController rootViewController) {
        TrainingProgramViewNavigator.rootViewController = rootViewController;
    }
    
    public static void loadTrainingProgramView(String fxml) {
        try {
            rootViewController.setTrainingProgram(
                FXMLLoader.load(
                    TrainingProgramViewNavigator.class.getResource(
                        fxml
                    )
                )
            );
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

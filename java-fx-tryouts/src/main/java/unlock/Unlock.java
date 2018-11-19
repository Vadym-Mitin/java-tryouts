/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 */

package unlock;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Main class for the Unlock demo.
 * This is boilerplate code:
 * Loads 'Unlock.fxml', adds the root node to a Scene, and set the scene
 * to the application primary stage.
 */
public class Unlock extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            String filename = "Unlock.fxml";
            Pane page = FXMLLoader.load(getClass().getResource("/unlock/Unlock.fxml"));
//            Pane page = FXMLLoader.load("Unlock.fxml");
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Unlock Demo");
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Unlock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

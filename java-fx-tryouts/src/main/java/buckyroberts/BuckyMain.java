package buckyroberts;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * https://github.com/buckyroberts/Source-Code-from-Tutorials/tree/master/JavaFX
 * https://www.youtube.com/watch?v=QGGE0WsUslc&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG&index=3
 *
 * @author Vadym Mitin
 */
public class BuckyMain extends Application implements EventHandler<ActionEvent> {

    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("title of the window");

        button = new Button();
        button.setText("Hello World");
        button.setOnAction(this::handle);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void handle(ActionEvent event) {
        if (button.equals(event.getSource())) {
            System.out.println("button clicked");
        }
    }
}

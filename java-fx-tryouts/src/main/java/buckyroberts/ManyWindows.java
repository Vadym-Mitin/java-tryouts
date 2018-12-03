package buckyroberts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Vadym Mitin
 */
public class ManyWindows extends Application {

    Stage window;
    Scene scene1;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Title here");

        button = new Button("open your mind");
        button.setOnAction(e -> AlertBox.display("new window", "Hello World"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        scene1 = new Scene(layout, 600, 300);

        window.setScene(scene1);
        window.show();

    }

    private static class AlertBox {

        public static void display(String title, String message) {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setWidth(250);

            Label label = new Label();
            label.setText(message);

            Button closeButton = new Button("Close the window");
            closeButton.setOnAction(e -> window.close());

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, closeButton);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            window.setScene(scene);
            window.showAndWait();
        }

    }
}
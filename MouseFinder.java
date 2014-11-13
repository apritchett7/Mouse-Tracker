import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;

public class MouseFinder extends Application {

    private double posX = 0;
    private double posY = 0;

    public void start(Stage stage) {
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        Label finder = new Label("Mouse is found at X: " + posX + ", Y: " + posY);
        Rectangle background = new Rectangle(0, 0, 300, 300);
        background.setFill(Color.rgb(255, 255, 255));
        root.getChildren().addAll(background, finder);
        Scene scene = new Scene(root);
        root.setOnMouseMoved(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                posX = me.getX();
                posY = me.getY();
                finder.setText("Mouse is found at X: " + posX + ", Y: " + posY);
                Color c = Color.rgb(((int) posX) % 255, ((int) posY) % 255, 0);
                background.setFill(c);
            };
        });
        stage.setMinWidth(255);
        stage.setMinHeight(255);
        stage.setScene(scene);
        stage.setTitle("Cursor Finder");
        stage.show();

    }
}

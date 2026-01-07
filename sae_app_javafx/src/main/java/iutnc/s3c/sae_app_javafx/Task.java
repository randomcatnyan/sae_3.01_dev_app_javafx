package iutnc.s3c.sae_app_javafx;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Task extends VBox {

    private String description;
    private Task tacheParent;
    private Text t;

    Task(String description) {
        super();
        this.t = new Text(description);
        Color color = new Color(Math.random(), Math.random(), Math.random(), 1);
        this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(0), new Insets(0))));
        StackPane taskDesc = new StackPane(new Rectangle(260, 110, color), t);
        this.getChildren().addAll(taskDesc, new VBox(4));
    }

    public void setDescription(String description) {
        this.description = description;
        t.setText(description);
    }

}

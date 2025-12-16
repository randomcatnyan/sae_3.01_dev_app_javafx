package iutnc.s3c.sae_app_javafx;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Task extends VBox {

    Task() {
        super(new Rectangle(200, 100));
        Color color = new Color(Math.random(), Math.random(), Math.random(), 1);
        this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(0), new Insets(0))));
    }

}

package iutnc.s3c.sae_app_javafx;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Task extends StackPane {

    Task() {
        super(new Rectangle(200, 100, new Color(
                Math.random(),
                Math.random(),
                Math.random(),
                1
        )));
    }

}

package iutnc.s3c.sae_app_javafx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControlTaskContainer implements EventHandler<MouseEvent> {

    Pane container;

    ControlTaskContainer(Pane container) {
        this.container = container;
    }

    public void handle(MouseEvent mouseEvent) {
        Task t = new Task("Nouvelle tâche");
        this.container.getChildren().add(t);
        ControlTask c = new ControlTask(t, container);
        t.setOnMouseDragged(c);
        t.setOnMouseReleased(c);
        t.setOnMouseEntered(c);
        t.setOnMouseExited(c);
    }

}

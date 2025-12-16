package iutnc.s3c.sae_app_javafx;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;

public class ControlTask implements EventHandler<MouseEvent> {

    Task task;

    ControlTask(Task task) {
        this.task = task;
    }

    public void handle(MouseEvent e) {
        //check MouseDragEvent for later
        String eventName = e.getEventType().getName();
        switch (eventName) {
            case "MOUSE_DRAGGED":
                this.task.relocate(this.task.getLayoutX() + e.getX() - 2, this.task.getLayoutY() + e.getY() - 2);
                break;
            case "MOUSE_ENTERED":
                HBox task_menu = new HBox(8, new Button("hi"));
                this.task.getChildren().add(1, task_menu);
                break;
            case "MOUSE_EXITED":
                this.task.getChildren().remove(1);
                break;
        }

    }

}

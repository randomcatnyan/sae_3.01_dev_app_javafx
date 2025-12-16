package iutnc.s3c.sae_app_javafx;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

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
                this.task.relocate(this.task.getLayoutX() + e.getX() - (this.task.getWidth() / 2), this.task.getLayoutY() + e.getY() - (this.task.getHeight() / 2));
                break;
            case "MOUSE_ENTERED":
                HBox task_menu = new HBox(
                        8,
                        new Button("Modifier"),
                        new Button("Sélectionner"),
                        new Button("Archiver")
                );
                StackPane taskDesc = (StackPane) this.task.getChildren().getFirst();
                taskDesc.getChildren().add(task_menu);
                this.task.getChildren().set(0, taskDesc);
                break;
            case "MOUSE_EXITED":
                StackPane task_desc = (StackPane) this.task.getChildren().getFirst();
                task_desc.getChildren().removeLast();
                this.task.getChildren().set(0, task_desc);
                break;
        }

    }

}

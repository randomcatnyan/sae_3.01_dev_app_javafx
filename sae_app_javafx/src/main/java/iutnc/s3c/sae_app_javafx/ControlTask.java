package iutnc.s3c.sae_app_javafx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControlTask implements EventHandler<MouseEvent> {

    Task task;

    ControlTask(Task task){
        this.task = task;
    }

    public void handle(MouseEvent e){
        //MouseDragEvent
        this.task.relocate(this.task.getLayoutX() + e.getX(), this.task.getLayoutY() + e.getY());

    }

}

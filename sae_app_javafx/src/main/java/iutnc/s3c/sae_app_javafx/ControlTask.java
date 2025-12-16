package iutnc.s3c.sae_app_javafx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;

public class ControlTask implements EventHandler<MouseEvent> {

    Task task;

    ControlTask(Task task){
        this.task = task;
    }

    public void handle(MouseEvent e){
        //MouseDragEvent MOUSE_DRAGGED
        System.out.println(e.getEventType());
        String eventName = e.getEventType().getName();
        if (eventName == "MOUSE_DRAGGED") {
            this.task.relocate(this.task.getLayoutX() + e.getX(), this.task.getLayoutY() + e.getY());
        }

    }

}

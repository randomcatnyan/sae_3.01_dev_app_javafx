package iutnc.s3c.sae_app_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ControlTaskContainer implements EventHandler<MouseEvent> {

    Pane container;

    ControlTaskContainer(Pane container) {
        this.container = container;
    }

    public void handle(MouseEvent mouseEvent) {
        HBox h = new HBox();
        h.setPadding(new Insets(10));
        h.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0))));
        h.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        TextField name = new TextField("Nouvelle tâche");
        Button b = new Button("Créer tâche");
        h.getChildren().addAll(name, b);
        this.container.getChildren().add(h);
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String n = name.getText();
                container.getChildren().remove(h);
                createTask(n);
            }
        });
    }

    public void createTask(String s){
        Task t = new Task(s);
        this.container.getChildren().add(t);
        ControlTask c = new ControlTask(t, container);
        t.setOnMouseDragged(c);
        t.setOnMouseReleased(c);
        t.setOnMouseEntered(c);
        t.setOnMouseExited(c);
    }

}

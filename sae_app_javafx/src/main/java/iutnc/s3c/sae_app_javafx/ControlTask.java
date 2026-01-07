package iutnc.s3c.sae_app_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static javafx.scene.input.MouseEvent.MOUSE_PRESSED;

public class ControlTask implements EventHandler<MouseEvent> {

    Task task;
    Pane container;

    ControlTask(Task task, Pane container) {
        this.task = task;
        this.container = container;
    }

    public void handle(MouseEvent e) {
        //check MouseDragEvent for later
        String eventName = e.getEventType().getName();
        switch (eventName) {
            case "MOUSE_DRAGGED":
                double x = this.task.getLayoutX() + e.getX() - (this.task.getWidth() / 2);
                double y = this.task.getLayoutY() + e.getY() - (this.task.getHeight() / 2);
                this.task.relocate(x, y);
                break;
            case "MOUSE_ENTERED":
                //build task description (the 3 btns when hoverring)
                Button buttonArchive = new Button("Archiver");
                Button buttonModif = new Button("Modifier");
                Button buttonSelec = new Button("Sélectionner");
                HBox task_menu = new HBox(8, buttonModif, buttonSelec, buttonArchive);
                StackPane taskDesc = (StackPane) this.task.getChildren().getFirst();
                taskDesc.getChildren().add(task_menu);
                this.task.getChildren().set(0, taskDesc);
                //add interactivity to the btns
                buttonArchive.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        BorderPane BPane = new BorderPane();
                        Text t = new Text("Etes-vous sûr ?");
                        Button bA = new Button("Annuler");
                        Button bC = new Button("Confirmer");
                        BPane.setTop(t);
                        BPane.setLeft(bA);
                        BPane.setRight(bC);
                        BPane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0))));
                        BPane.setPadding(new Insets(10));
                        BPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                        bA.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                container.getChildren().remove(BPane);
                            }
                        });
                        bC.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                container.getChildren().remove(BPane);
                                container.getChildren().remove(task);
                            }
                        });
                        container.getChildren().add(BPane);
                    }
                });
                break;
            case "MOUSE_RELEASED":
                for (Node node : container.getChildren()) {
                    boolean thisInsideNode = (
                            node.getLayoutX() < this.task.getLayoutX() &&
                            this.task.getLayoutX() < (node.getLayoutX() + node.getLayoutBounds().getWidth()) &&
                            node.getLayoutY() < this.task.getLayoutY() &&
                            this.task.getLayoutY() < (node.getLayoutY() + node.getLayoutBounds().getHeight())
                    );
                    if ( node instanceof Task && thisInsideNode ) {
                        this.task.relocate(node.getLayoutX() + 10, node.getLayoutY() + 10);
                        System.out.println("todo");
                    }
                }
                break;
            case "MOUSE_EXITED":
                StackPane task_desc = (StackPane) this.task.getChildren().getFirst();
                task_desc.getChildren().removeLast();
                this.task.getChildren().set(0, task_desc);
                break;
        }

    }

}

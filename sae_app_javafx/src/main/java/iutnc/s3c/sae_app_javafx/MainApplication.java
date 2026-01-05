package iutnc.s3c.sae_app_javafx;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //tasks container
        Pane taskContainer = new Pane();
        ControlTaskContainer controlTaskContainer = new ControlTaskContainer(taskContainer);

        //board at the top of the screen
        ComboBox visualisationChoix = new ComboBox<String>();
        visualisationChoix.getItems().addAll("Bureau", "Liste");
        visualisationChoix.getSelectionModel().selectFirst();

        Button newTask = new Button("+ tâche");
        newTask.setOnMouseClicked(controlTaskContainer);

        Button ganttVisualisation = new Button("Visualiser Gantt");

        TitledPane titledPane = new TitledPane("", new HBox(8, visualisationChoix, newTask, ganttVisualisation));

        //container principal
        BorderPane root = new BorderPane();
        root.setCenter(taskContainer);//renmplacer le bouton par un conteneur pour les taches
        root.setBackground(new Background(new BackgroundFill(Color.SEASHELL, new CornerRadii(0), new Insets(0))));
        root.setTop(titledPane);
        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("The app");
        stage.setScene(scene);
        stage.show();
    }
}

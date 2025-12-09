package iutnc.s3c.sae_app_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Label labelVisualisation = new Label("Visualisation :");
        ComboBox visualisationChoix = new ComboBox<String>();
        visualisationChoix.getItems().addAll("bureau","liste");
        visualisationChoix.getSelectionModel().selectFirst();
        Button buttonNouvelleGrille = new Button("Visualiser Gantt");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(15,15,0,15));
        gridPane.add(labelVisualisation, 0, 0);
        gridPane.add(visualisationChoix, 1, 0);
        gridPane.add(buttonNouvelleGrille, 2, 0);

//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        //container principal
        BorderPane root = new BorderPane();
        root.setLeft(gridPane);
        Scene scene = new Scene(root, 620, 400);


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}

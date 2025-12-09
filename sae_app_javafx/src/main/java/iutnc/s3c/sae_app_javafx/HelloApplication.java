package iutnc.s3c.sae_app_javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ComboBox visualisationChoix = new ComboBox<String>();
        visualisationChoix.getItems().addAll("Bureau","Liste");
        visualisationChoix.getSelectionModel().selectFirst();

        TitledPane titledPane = new TitledPane(
                "",
                new HBox(
                        8,
                        visualisationChoix,
                        new Button("Visualiser Gantt")
                )
        );

//        GridPane gridPane = new GridPane();
//        gridPane.setHgap(10);
//        gridPane.setVgap(10);
//        gridPane.setPadding(new Insets(15,15,0,15));
//        gridPane.add(labelVisualisation, 0, 0);
//        gridPane.add(visualisationChoix, 1, 0);
//        gridPane.add(buttonGantt, 2, 0);

//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        //container principal
        BorderPane root = new BorderPane();
        root.setTop(titledPane);
        root.setCenter(new Button("hi"));//renmplacer le bouton par un conteneur pour les taches
        root.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.SEASHELL,
                                new CornerRadii(0),
                                new Insets(0)
                        )
                )
        );

        Scene scene = new Scene(root, 620, 400);

        stage.setTitle("The app");
        stage.setScene(scene);
        stage.show();
    }
}

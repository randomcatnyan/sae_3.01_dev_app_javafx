module iutnc.s3c.sae_app_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens iutnc.s3c.sae_app_javafx to javafx.fxml;
    exports iutnc.s3c.sae_app_javafx;
}
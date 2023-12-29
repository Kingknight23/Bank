package org.example.banking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import static org.example.banking.Usermaps.findAndPrintUserInfo;
import static org.example.banking.Usermaps.readCsvFile;

public class Home extends Application {
    public static Stage primaryStage;

    static Map<String, Map<String, String>> userMap = readCsvFile();
    @Override
    public void start(Stage stage) throws IOException {

        primaryStage = stage;

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
        Scene scene = new Scene(root);

//        String css = this.getClass().getResource("style.css").toExternalForm();
//
//        scene.getStylesheets().add(css);
        stage.setTitle("Bank");
        stage.setScene(scene);
        Image icon =  new Image("icon.jpg");
        stage.getIcons().add(icon);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}

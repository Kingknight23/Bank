package org.example.banking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Bank extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
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
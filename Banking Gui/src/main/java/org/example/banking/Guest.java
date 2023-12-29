package org.example.banking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Guest extends Application {
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("guest.fxml")));


        Scene scene = new Scene(root);

//        String css = Objects.requireNonNull(this.getClass().getResource("style.css")).toExternalForm();
//
//        scene.getStylesheets().add(css);

        //fix style sheet
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

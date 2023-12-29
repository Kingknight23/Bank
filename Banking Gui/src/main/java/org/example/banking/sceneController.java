package org.example.banking;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

import static org.example.banking.Home.primaryStage;
import static org.example.banking.Usermaps.findAndPrintUserInfo;

public class sceneController {

    public Parent root;

    @FXML
    public TextField searchingtext;
    @FXML
    public Text searchfield;
    @FXML
    public Text searchfield1;
    @FXML
    public Text searchfield2;
    @FXML
    public Text searchfield3;

    @FXML
    public Text searchfield4;

    



    public void logout () throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));


        Scene scene = new Scene(root);
        primaryStage.setTitle("Bank");
        primaryStage.setScene(scene);
        Image icon =  new Image("icon.jpg");
        primaryStage.getIcons().add(icon);


        primaryStage.show();
    }

    public void withdraw() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("withdrawDeposit.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Bank");
        primaryStage.setScene(scene);
        Image icon =  new Image("icon.jpg");
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }

    @FXML
    public void searchInfo() throws IOException {
        root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin2.0.fxml")));
        String textField = searchingtext.getText();
        if (textField != null) {
            //System.out.println(textField);
            String[] info = findAndPrintUserInfo(Home.userMap,textField);

            if (info.length>0){
                Text[] nodeIds = new Text[]{searchfield,searchfield4,searchfield2, searchfield1, searchfield3};
                int count = 0;
                for (Text nodeId : nodeIds) {
                    try {
                        if (count ==1){
                            count+=1;
                        }

                        // Check if the retrieved TextField is not null before using it
                        if (nodeId != null) {
                            nodeId.getText();
                            nodeId.setText(info[count]);

                        } else {
                            System.out.println("TextField with ID " + nodeId + " not found");
                        }
                        count++;
                    } catch (NullPointerException e) {
                        // Catch and handle the NullPointerException
                        System.out.println("Caught NullPointerException for " + nodeId + ": User is null");
                        // You might want to log the exception or perform other error-handling actions here
                    }
                }

            }

        } else {
            System.out.println("TextField with ID 'search' not found");
        }



    }


}

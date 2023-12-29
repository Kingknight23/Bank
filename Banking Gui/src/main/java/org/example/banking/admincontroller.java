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

public class admincontroller {

    public Parent root;


    public admincontroller() throws IOException {
        root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin2.0.fxml")));

    }

//    public admincontroller(Parent node) throws IOException {
//        root = node;
//
//    }

    @FXML
    public void addAdminfo(Parent root , String[] info) {
        String[] nodeIds = new String[]{"#userfield", "#userfield2", "#userfield1", "#userfield3"};
        int count = 0;
        for (String nodeId : nodeIds) {
            try {
                if (count ==1){
                    count+=2;
                }
                Text textField = (Text) root.lookup(nodeId);

                // Check if the retrieved TextField is not null before using it
                if (textField != null) {
                    textField.setText(info[count]);

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




    @FXML
    public void searchInfo(Parent root){
        TextField textField = (TextField) root.lookup("#searchbar");
        if (textField != null && !textField.getText().isEmpty()) {
            String[] info = findAndPrintUserInfo(Home.userMap,textField.getText());

            if (info.length>0){
                String[] nodeIds = new String[]{"#searchfield", "#searchfield1", "#searchfield2", "#searchfield3"};
                int count = 0;
                for (String nodeId : nodeIds) {
                    try {
                        if (count ==1){
                            count+=2;
                        }
                        Text text = (Text) root.lookup(nodeId);

                        // Check if the retrieved TextField is not null before using it
                        if (text != null) {
                            text.setText(info[count]);

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

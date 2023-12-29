package org.example.banking;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Objects;

public class guestcontroller {

    public Parent root;



    public guestcontroller() throws IOException {
        root =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("guest.fxml")));

    }

    @FXML
    public void addGuestInfo(Parent root , String[] info) {
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
}




package org.example.banking;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Arrays;

import static org.example.banking.Home.primaryStage;
import static org.example.banking.Home.userMap;
import static org.example.banking.Usermaps.findAndPrintUserInfo;
import static org.example.banking.Usermaps.transactionCSV;


public class HomeControl {

   public String[] track  = new String[]{"default", "default"};
   @FXML
   public TextField User;

   @FXML
   public PasswordField passwordVal;


   public Parent root;


   public String username;
   public String view;

   @FXML
   public TextField amount;




   @FXML
   public void login() throws IOException {
      username = User.getText();
      String pass = passwordVal.getText();

      if (!username.isEmpty() && !pass.isEmpty()) {
         String[] data  = findAndPrintUserInfo(Home.userMap, username);

         System.out.println(Arrays.toString(data));

         if (data.length != 0) {
            if (check(data[1] , pass)){
               track[0] = username;
               if (checkIgnorecase(data[2], "admin"))

               {
                  track[1] = "admin";
                  view = "admin";
                  admincontroller control = new admincontroller();
                  root = control.root;
                  control.addAdminfo(root, data);
                  scenerender(root);
               }
               else{
                  track[1] = "guest";
                  view = "guest";
                  guestcontroller control = new guestcontroller();
                  root = control.root;
                  control.addGuestInfo(root, data);
                  scenerender(root);
               }

            }

         } else {
            System.out.println("The array is not empty.");
         }
         User.clear();
         passwordVal.clear();
      } else {
         System.out.println("Username or password is empty.");
      }
   }

   private Boolean check (String a , String b){
      return a.equals(b);
   }

   private Boolean checkIgnorecase (String a , String b){
      return a.equalsIgnoreCase(b);
   }
   private void scenerender(Parent root){
      Scene scene = new Scene(root);
      primaryStage.setTitle("Bank");
      primaryStage.setScene(scene);
      Image icon =  new Image("icon.jpg");
      primaryStage.getIcons().add(icon);
      primaryStage.show();

   }

   @FXML
   public void withdraw() throws IOException {
      System.out.println("withdraw");

      this.username = User.getText();

     // TextField number = (TextField) root.lookup();

      String number = amount.getText();

      System.out.println(number);
      System.out.println(Arrays.toString(track));

//
//      if(number!=null && !number.isEmpty()){
//         String[] data  = findAndPrintUserInfo(Home.userMap, username);
//         if (data.length >0){
//            transactionCSV("withdraw", username, number);
//
//            data  = findAndPrintUserInfo(Home.userMap, username);
//            if (checkIgnorecase(view, "admin"))
//            {
//               view = "admin";
//               admincontroller control = new admincontroller();
//               root = control.root;
//               control.addAdminfo(root, data);
//               scenerender(root);
//            }
//            else{
//               view = "guest";
//               guestcontroller control = new guestcontroller();
//               root = control.root;
//               control.addGuestInfo(root, data);
//               scenerender(root);
//            }
//         }
//         else{
//            System.out.println("user not found");
//         }
//      }
//
//
//


   }

   @FXML
   public void deposit(){
      System.out.println("deposit");
   }

   public void back(){
      //scenerender(root);
   }


}

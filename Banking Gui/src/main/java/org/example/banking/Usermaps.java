package org.example.banking;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Usermaps {
    static String csvFilePath = "src\\main\\resources\\Users.csv";

    public String user;




    public static Map<String, Map<String, String>> readCsvFile() {
        Map<String, Map<String, String>> userMap = new HashMap<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            String[] header = csvReader.readNext(); // Assuming the first line is the header

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Map<String, String> userInfo = new HashMap<>();
                for (int i = 0; i < header.length; i++) {
                    userInfo.put(header[i], line[i]);
                }
                userMap.put(line[0], userInfo); // Assuming the first column contains usernames
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return userMap;
    }

    public static String[] findAndPrintUserInfo(Map<String, Map<String, String>> userMap, String usernameToFind) {
        // Check if the username exists in the HashMap

        if (userMap.containsKey(usernameToFind)) {
            Map<String, String> userInfo = userMap.get(usernameToFind);

            // Print the information for the specified username
            System.out.println("User Found - Username: " + usernameToFind + ", Info: " + userInfo);

            return new String[]{usernameToFind,
                    userInfo.get("password"),
                    userInfo.get("Roles"),
                    userInfo.get("Account No"),
                    userInfo.get("Account Type"),
                    "$" + userInfo.get("Balance")};
        } else {
            System.out.println("User not found with the username: " + usernameToFind);

            return new String[]{};
        }
    }

    public static void transactionCSV(String type, String username, String depositAmount) {
        try {
            double amount = Double.parseDouble(depositAmount);
            transactionCSV(type, username, amount);
        } catch (NumberFormatException e) {
            // Handle the case where depositAmount is not a valid double
            System.err.println("Invalid deposit amount. Please enter a valid number.");
            // Optionally, you can log the exception or take other appropriate actions.
        }
    }

    public static void transactionCSV(String type, String username, double depositAmount) {
        String csvFilePath = "src\\main\\resources\\Users.csv"; // Replace with the actual path to your CSV file

        try {
            // Read the CSV file
            CSVReader reader = new CSVReader(new FileReader(csvFilePath));
            List<String[]> lines = reader.readAll();

            // Find the row corresponding to the given username
            for (String[] line : lines) {
                if (line[0].equalsIgnoreCase(username)) {
                    // Update the deposit or perform other operations based on the transaction type
                    if (type.equalsIgnoreCase("deposit")) {
                        // Assuming the balance is in the last column (index: line.length - 1)
                        double currentBalance = Double.parseDouble(line[line.length - 1]);
                        double newBalance = currentBalance + depositAmount;

                        // Update the balance in the CSV data
                        line[line.length - 1] = String.valueOf(newBalance);

                        // Display the updated balance
                        System.out.println("Updated Balance for " + username + ": " + newBalance);
                    } else {
                        // Add your logic for other transaction types here
                        double currentBalance = Double.parseDouble(line[line.length - 1]);
                        double newBalance = currentBalance - depositAmount;

                        // Update the balance in the CSV data
                        line[line.length - 1] = String.valueOf(newBalance);
                    }

                    // Update the CSV data
                    CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath));
                    writer.writeAll(lines);
                    writer.close();
                    break; // Break the loop once the user is found and updated
                }
            }

            reader.close();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        //transactionCSV("deposit", "aaliyah", 1000);
        transactionCSV("withdraw", "aaliyah", 1000);
        //Map<String, Map<String, String>> userMap = readCsvFile();

        // Example: Find and print information for the username "aaliyah"

    }

}







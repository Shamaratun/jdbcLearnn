package EXAMMIDMONTH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;


public class InsertProduct {

        private static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
        private static final String USER = "orclpdbuser";
        private static final String PASSWORD = "isdb62";


        public static void insertDummyData(String[][] products) {

            String insertQuery = "INSERT INTO Product (name, quantity,brand) VALUES (?, ?, ?)";


            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                // Loop through each student in the input array
                for (String[] product : products) {

                    if (product.length == 3) {
                        preparedStatement.setString(1, product[0]);
                        preparedStatement.setInt(2, Integer.parseInt(product[1]));

                        preparedStatement.setString(3, product[2]);

                        preparedStatement.addBatch();
                    } else {
                        System.out.println("Skipping invalid product data: " + Arrays.toString(product));
                    }
                }


                int[] rowsInserted = preparedStatement.executeBatch();


                System.out.println("Rows inserted: " + rowsInserted.length);

            } catch (SQLException e) {
                System.err.println("Error inserting data: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error processing data: " + e.getMessage());
                e.printStackTrace();
            }
        }


        public static void main(String[] args) {

            String[][] products = {
                    {"Books", "100",  "Ananda Prokasona"},
                    {"Computers", "20" ,"Dell"},
                    {"Pen", "110",  "Matador"},
                    {"Table", "110",  "Hatil"},
                    {"keyboard", "110",  "A4TECH"},
            };

            InsertProduct insertProduct = new InsertProduct();


            InsertProduct.insertDummyData(products);
        }
    }



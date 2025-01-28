package EXAMMIDMONTH;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static EXAMMIDMONTH.SelectProduct.fetchProductData;


public class DeleteProduct {
    static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
    static final String USER = "orclpdbuser";
    static final String PASSWORD = "isdb62";
    public static void deleteRecordsWithId() {
        String deleteQuery = "DELETE FROM Product WHERE id = 6";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            int rowsAffected = statement.executeUpdate(deleteQuery);
            System.out.println(rowsAffected + " row(s) deleted from Products WHERE id is 6");

        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        deleteRecordsWithId();
        fetchProductData();
    }
}





package EXAMMIDMONTH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;



public class SelectProduct {
    static final String URL = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
    static final String USER = "orclpdbuser";
    static final String PASSWORD = "isdb62";

    public static void fetchProductData() {
        String selectQuery = "SELECT id, name, quantity ,brand FROM Product";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");

                String brand = resultSet.getString("brand");


                System.out.println( "id: "+ id + ", Name: " + name + ", Quantity: " + quantity +  ", Brand: " + brand );
            }

        } catch (SQLException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
    }


}




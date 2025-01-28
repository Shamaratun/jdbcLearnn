package EXAMMIDMONTH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProduct {
    static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
    static final String USER = "orclpdbuser";
    static final String PASSWORD = "isdb62";

    public void updateProductWithBrands(int productId, String productName) {
        String updateProductBrand = "UPDATE Product SET NAME = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(updateProductBrand)) {


            statement.setString(1, productName);
            statement.setInt(2, productId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product updated successfully for " + rowsAffected + " row(s).");
            } else {
                System.out.println("No product was updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UpdateProduct updater = new UpdateProduct();


        updater.updateProductWithBrands(5, "chair");
    }
}

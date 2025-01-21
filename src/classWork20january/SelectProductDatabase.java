package classWork20january;

import java.sql.*;



public class SelectProductDatabase extends Oracle {

        public void selectAllProduct() {
            String selectQuery = "SELECT * FROM InsertProduct";

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String buyer = resultSet.getString("buyer");
                    String seller= resultSet.getString("seller");

                    double price = resultSet.getDouble("price");
                    Date buy_Date = resultSet.getDate("buy_Date");
                    Date sell_Date = resultSet.getDate("sell_Date");

                    System.out.println("ID: " + id + ", Name: " + name + ", Buyer: " + buyer + ", Seller: " + seller +", price: "+price  +", buy_Date: "+buy_Date+",sell_Date: "+sell_Date );
                }
            } catch (SQLException e) {
                System.err.println("Error selecting data: " + e.getMessage());
            }
        }

    }





package classWork20january;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertProduct{
static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
 static final String USER = "orclpdbuser";
 static final String PASSWORD = "isdb62";

public void insertDummyData(String[][ ]products ){
    String insertQuery = "INSERT INTO product (name,buyer,seller,price,buy_Date,sell_Date) VALUES (?,?,?,?,?,?)";


    try(Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){
        for (String[] product:products){

            preparedStatement.setString(1,product[0]);
            preparedStatement.setString(2,product[1]);
            preparedStatement.setString(3,product[2]);
            preparedStatement.setInt(4,Integer.parseInt(product[3]));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(product[4]);
            preparedStatement.setDate(5, new java.sql.Date(parsedDate.getTime()));

            // Correct date parsing for sell_Date
            Date parsedDatee = dateFormat.parse(product[5]);
            preparedStatement.setDate(6, new java.sql.Date(parsedDatee.getTime()));

            preparedStatement.addBatch();
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
}




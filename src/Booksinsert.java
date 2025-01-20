import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booksinsert {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
    private static final String USER = "orclpdbuser";
    private static final String PASSWORD = "isdb62";

    public void insertDummyData(String[][ ]books ){
        String insertQuery = "INSERT INTO BOOK (name,author,genre,price,publish_date) VALUES (?,?,?,?,?)";


        try(Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){
            for (String[] book:books){

                preparedStatement.setString(1,book[0]);
                preparedStatement.setString(2,book[1]);
                preparedStatement.setString(3,book[2]);
                preparedStatement.setInt(4,Integer.parseInt(book[3]));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(book[4]);
                preparedStatement.setDate(5, new java.sql.Date(parsedDate.getTime()));
                preparedStatement.addBatch();
            }
            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: " +rowsInserted.length);
        }catch( SQLException e) {
            System.err.println("Error inserting data:" + e.getMessage());
        }catch (Exception e) {
                System.err.println("Error processing data: " + e.getMessage());
                e.printStackTrace();
        }
    }
}


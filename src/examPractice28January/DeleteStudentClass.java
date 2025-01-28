package examPractice28January;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static examPractice28January.SelectStudentClass.fetchStudentData;

public class DeleteStudentClass {
    static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";  // Check if ORCLPDB is your service name or SID
    static final String USER = "orclpdbuser";
    static final String PASSWORD = "isdb62";
    public static void deleteRecordsWithZeroOrNullMarks() {
    String deleteQuery = "DELETE FROM StudentClass WHERE mark IS NULL OR mark = 0";

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         Statement statement = connection.createStatement()) {

        int rowsAffected = statement.executeUpdate(deleteQuery);
        System.out.println(rowsAffected + " row(s) deleted from StudentClass where mark is NULL or 0.");

    } catch (SQLException e) {
        System.out.println("Error deleting data: " + e.getMessage());
    }
}

    public static void main(String[] args) {
        // Example usage
        deleteRecordsWithZeroOrNullMarks();
        fetchStudentData(); // Optionally fetch and print the data after deletion
    }
}


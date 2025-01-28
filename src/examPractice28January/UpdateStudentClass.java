package examPractice28January;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudentClass {
    static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";  // Check if ORCLPDB is your service name or SID
    static final String USER = "orclpdbuser";
    static final String PASSWORD = "isdb62";

    public void updateMarksWith5PercentIncrease() {
        String updateStudentMarks = "UPDATE StudentClass SET mark = CASE " +
                "WHEN mark * 1.05 > 100 THEN 100 " +
                "ELSE mark * 1.05 END";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(updateStudentMarks)) {

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Marks updated successfully for " + rowsAffected + " students.");
            } else {
                System.out.println("No student marks were updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UpdateStudentClass updater = new UpdateStudentClass();
        updater.updateMarksWith5PercentIncrease();
    }
}

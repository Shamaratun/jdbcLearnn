package examPractice28January;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class InsertStudentClass {
    // Database connection parameters
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";  // Check if ORCLPDB is your service name or SID
    private static final String USER = "orclpdbuser";
    private static final String PASSWORD = "isdb62";

    // Method to insert student data
    public void insertDummyData(String[][] students) {
        // SQL query for inserting data into the StudentClass table
        String insertQuery = "INSERT INTO StudentClass (name, sclass, age, classTeacher, mark) VALUES (?, ?, ?, ?, ?)";

        // Try-with-resources to ensure proper resource management
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Loop through each student in the input array
            for (String[] student : students) {
                // Check that the student data array has the correct number of elements
                if (student.length == 5) {
                    preparedStatement.setString(1, student[0]);    // Set student name
                    preparedStatement.setInt(2, Integer.parseInt(student[1]));  // Set student class
                    preparedStatement.setInt(3, Integer.parseInt(student[2]));  // Set student age
                    preparedStatement.setString(4, student[3]);    // Set class teacher name

                    // If the mark is empty or the value is "NULL", insert a NULL value for mark
                    if (student[4].equalsIgnoreCase("NULL") || student[4].isEmpty()) {
                        preparedStatement.setNull(5, java.sql.Types.INTEGER); // Set NULL for mark
                    } else {
                        preparedStatement.setInt(5, Integer.parseInt(student[4]));  // Set student marks
                    }

                    // Add this statement to the batch
                    preparedStatement.addBatch();
                } else {
                    System.out.println("Skipping invalid student data: " + Arrays.toString(student));
                }
            }

            // Execute the batch and get the result
            int[] rowsInserted = preparedStatement.executeBatch();

            // Print the number of rows inserted
            System.out.println("Rows inserted: " + rowsInserted.length);

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Main method to test inserting dummy student data
    public static void main(String[] args) {
        // Dummy data for testing: name, class, age, teacher, mark
        // Here, we set the mark as "NULL" for the last student to demonstrate the NULL insertion
        String[][] students = {
                {"John Doe", "10", "15", "Mr. Smith", "85"},
                {"Jane Smith", "12", "17", "Ms. Johnson", "90"},
                {"Alice Brown", "11", "16", "Mr. Davis", "NULL"} // Mark is set to NULL here
        };

        // Create an instance of InsertStudentClass
        InsertStudentClass insertStudentClass = new InsertStudentClass();

        // Insert the dummy student data
        insertStudentClass.insertDummyData(students);
    }
}

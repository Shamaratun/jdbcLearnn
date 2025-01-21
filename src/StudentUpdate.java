import java.sql.*;

public class StudentUpdate {

    // Assuming you have a predefined connection URL, USER, and PASSWORD
    static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
    static final String USER = "orclpdbuser";
    static final String PASSWORD = "isdb62";

    public void updateStudent(int id, String name) throws SQLException {
        String sql = "UPDATE Student SET name=? WHERE id=?";

        // Debugging print to ensure SQL and parameters are correct
        System.out.println("Executing SQL: " + sql);
        String email;
        System.out.println("Parameters:  id = "+ id +" name = " +name );

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set parameters
            preparedStatement.setString(1, name);

            preparedStatement.setInt(2, id);

            // Execute the update
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Student record updated successfully.");
            } else {
                System.out.println("No student found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error updating student record", e);
        }
    }

    public static void main(String[] args) {
        StudentUpdate studentUpdate = new StudentUpdate();
        try {
            studentUpdate.updateStudent(1, "John Doe");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
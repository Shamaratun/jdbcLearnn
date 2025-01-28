package examPractice28January;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudentClass {
    static final String URL = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";  // Check if ORCLPDB is your service name or SID
    static final String USER = "orclpdbuser";
     static final String PASSWORD = "isdb62";
        public void updateStudentMark(StudentClass student) {


            String updateStudent = "UPDATE StudentClass SET mark = ? WHERE id = ?";

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement statement = connection.prepareStatement(updateStudent)) {

                statement.setString(1, student.getMark( ));
                statement.setInt(2, student.getId());

                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Student updated successfully");
                } else {
                    System.out.println("No student found with this given ID");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



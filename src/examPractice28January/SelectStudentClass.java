package examPractice28January;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class SelectStudentClass {
     static final String URL = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
    static final String USER = "orclpdbuser";
    static final String PASSWORD = "isdb62";

    public static void fetchStudentData() {
        String selectQuery = "SELECT name, sclass, age, classTeacher, mark FROM StudentClass";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {

            // Iterate through the result set and print data
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int sclass = resultSet.getInt("sclass");
                int age = resultSet.getInt("age");
                String classTeacher = resultSet.getString("classTeacher");
                int mark = resultSet.getInt("mark");

                System.out.println("Name: " + name + ", Class: " + sclass + ", Age: " + age + ", Teacher: " + classTeacher + ", Mark: " + mark);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
    }

        }

package Student;

import java.sql.*;
public class SelectInsertOracleStudent extends Oracle {

        public void selectAllStudents() {
            String selectQuery = "SELECT * FROM studentjdbc";


            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");

                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email);
                }
            } catch (SQLException e) {
                System.err.println("Error selecting data: " + e.getMessage());
            }
        }

    }



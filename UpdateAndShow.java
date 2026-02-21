import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateAndShow {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE"; // your DB SID
        String username = "tables";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement()) {

            // 1️⃣ Update a student's age
            String updateSQL = "UPDATE students SET age = 23 WHERE name = 'Bob'";
            int rowsUpdated = statement.executeUpdate(updateSQL);
            System.out.println("Rows updated: " + rowsUpdated);

            // 2️⃣ Select and display all students
            String selectSQL = "SELECT * FROM students";
            try (ResultSet resultSet = statement.executeQuery(selectSQL)) {
                System.out.println("\nID\tName\t\tAge");
                System.out.println("-----------------------------");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println(id + "\t" + name + "\t\t" + age);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
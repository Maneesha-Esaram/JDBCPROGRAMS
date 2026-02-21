import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleJDBCExample {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE"; // replace XE with your DB SID if different
        String username = "tables";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {

            System.out.println("Oracle JDBC Driver Registered!");
            System.out.println("Connected to Oracle Database!");
            System.out.println("ID\tName\t\tAge");
            System.out.println("-----------------------------");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(id + "\t" + name + "\t\t" + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
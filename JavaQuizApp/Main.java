import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/quizdb"; // Replace with your MySQL URL
        String user = "root"; // Your MySQL username
        String password = "root"; // Your MySQL password

        try {
            // Establish connection to MySQL
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to MySQL database!");

            // Create a Statement
            Statement statement = connection.createStatement();

            // Example: Execute a simple query
            String query = "SELECT * FROM questions";
            statement.executeQuery(query);

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
















// src/com/quizapp/DatabaseConnection.java
import java.sql.*;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/quizdb";
    private static final String USER = "root"; // Your MySQL username
    private static final String PASSWORD = "admin"; // Your MySQL password

    public static Connection getConnection() {
        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to fetch quiz questions
    public static ResultSet getQuestions() {
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM questions";
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}










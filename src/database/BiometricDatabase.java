package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.User;

public class BiometricDatabase {
    
    private static final String connectionString = "jdbc:mysql://localhost:3306/biometric";
    private static final String username = "root";
    private static final String password = "";
    
    private Connection connection = null;
    
    public BiometricDatabase() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        // Load the Connector/J driver
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(connectionString, username, password);
    }
    
    public User registerUser(String name, String email, String password) throws SQLException {
        String query = "INSERT into users (name, email, password) VALUES (" +
                "'" + name + "', " +
                "'" + email + "', " +
                "'" + password + "'" +
            ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        
        return authenticateUser(email, password);
    }
    
    public User authenticateUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE email = '" + email
                + "' AND password = SHA2(CONCAT('" + password + "', salt), 256)";

        Statement statement = connection.createStatement();
        ResultSet resultset  = statement.executeQuery(query);
        
        if (resultset.next()) {
            return new User(resultset.getInt("id"),
                resultset.getString("name"), resultset.getString("email"));
        } else {
            return null;
        }
    }
}

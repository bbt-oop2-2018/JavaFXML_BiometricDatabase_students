package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Temperature;
import models.User;

public class BiometricDatabase {
    
    private static final String connectionString = "jdbc:mysql://localhost:3306/biometric";
    private static final String username = "root";
    private static final String password = "";
    
    private Connection connection = null;
    private Statement statement;
    
    public BiometricDatabase() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        // Load the Connector/J driver
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(connectionString, username, password);
        statement = connection.createStatement();
    }
    
    public User registerUser(String name, String email, String password) throws SQLException {
        return null;
    }
    
    public User authenticateUser(String email, String password) throws SQLException {
        return null;
    }
    
    public void addTemperature(Temperature temperature) {
    }
    
    public ArrayList<Temperature> getTemperatures(int userId, int limit) {
        return null;
    }
}

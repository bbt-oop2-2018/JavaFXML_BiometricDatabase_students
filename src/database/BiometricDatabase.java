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
        String query = "INSERT into users (name, email, password) VALUES (" +
                "'" + name + "', " +
                "'" + email + "', " +
                "'" + password + "'" +
            ")";

        statement.executeUpdate(query);
        
        return authenticateUser(email, password);
    }
    
    public User authenticateUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE email = '" + email
                + "' AND password = SHA2(CONCAT('" + password + "', salt), 256)";

        ResultSet resultset  = statement.executeQuery(query);
        
        if (resultset.next()) {
            return new User(resultset.getInt("id"),
                resultset.getString("name"), resultset.getString("email"));
        } else {
            return null;
        }
    }
    
    public void addTemperature(Temperature temperature) {
        try{
            String query = 
                    "INSERT INTO temperatures (value, user_id)"
                            + " VALUES("
                            + temperature.getValue() + ", "
                            + temperature.getOwner()
                            + ")";
            statement.executeUpdate(query);
        } catch(SQLException ex){
            Logger.getLogger(BiometricDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Temperature> getTemperatures(int userId, int limit) {
        ArrayList temperatures = new ArrayList();
        try {
            ResultSet resultset = statement.executeQuery("SELECT * FROM temperatures WHERE user_id"
                    + "=" + userId + " ORDER BY timestamp DESC LIMIT " + limit);
            while(resultset.next()){
                int id = resultset.getInt("id");
                double value = resultset.getDouble("value");
                temperatures.add(new Temperature(id, value, userId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BiometricDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temperatures;
    }
}

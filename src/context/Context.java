package context;

import database.BiometricDatabase;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Context {
    
    private static BiometricDatabase database;
    
    public static BiometricDatabase getDatabase() {
        if (database == null) {
            try {
                database = new BiometricDatabase();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Context.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Context.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Context.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Context.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return database;
    }
}

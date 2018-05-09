package javafxml_biometricdatabase;

import context.Context;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.User;
import scenemanager.SceneLoader;


public class RegisterDocumentController implements Initializable {
    
    @FXML private TextField email;
    @FXML private TextField name;
    @FXML private PasswordField password;
    @FXML private AnchorPane root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    
    @FXML
    private void handleRegister(ActionEvent event) throws IOException, SQLException {
    } 
}

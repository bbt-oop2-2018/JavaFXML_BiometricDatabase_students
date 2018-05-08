package javafxml_biometricdatabase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.User;

public class MainDocumentController implements Initializable {
    
    @FXML private Label username;

    private User user;
    
    public void setUser(User user) {
        this.user = user;
        username.setText("Welcome " + user.getName());
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}

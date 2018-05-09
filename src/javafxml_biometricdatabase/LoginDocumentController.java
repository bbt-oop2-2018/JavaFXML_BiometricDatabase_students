/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author nicod
 */
public class LoginDocumentController implements Initializable {
    
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private AnchorPane root;
    
    @FXML
    private void handleLogin(ActionEvent event) throws SQLException, IOException {
    }
    
    @FXML
    private void handleGoRegister(ActionEvent event) throws IOException {
        RegisterDocumentController controller = (RegisterDocumentController)SceneLoader.getInstance().loadScene(this, "RegisterDocument", root);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}

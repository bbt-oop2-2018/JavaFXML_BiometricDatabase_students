package scenemanager;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoader {
    
    private static SceneLoader instance = null;
    
    public static SceneLoader getInstance() {
        if (instance == null) {
            instance = new SceneLoader();
        }
        return instance;
    }
    
    public Object loadScene(Object currentController, String resourceName, Node root) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(currentController.getClass().getResource(resourceName + ".fxml"));
        Parent anchor = fxmlLoader.load();    
        
        Scene scene = new Scene(anchor);
        ((Stage)(root.getScene().getWindow())).setScene(scene);
        
        return fxmlLoader.getController();
    }
    
}

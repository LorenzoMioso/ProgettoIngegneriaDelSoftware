package controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class RegisterController implements Initializable {
    
    @FXML
    Button register;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handleMouseClick(MouseEvent evt) {
        System.out.println("Mouse clicked");
    }
}

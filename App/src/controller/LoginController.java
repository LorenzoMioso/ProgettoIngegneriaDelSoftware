package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Utente;
import model.UtenteDaoImpl;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;

public class LoginController implements Initializable {

    UtenteDaoImpl utenteDaoImpl;
    Utente utente = null;
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    Label result;
    @FXML
    Button login;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utenteDaoImpl = new UtenteDaoImpl();
    }

    @FXML
    public void loginMouseClick(MouseEvent evt) throws SQLException {
        if (!email.getText().equals("")) {
            if (!password.getText().equals("")) {
                if (utenteDaoImpl.isRegistered(email.getText()) == true) {
                    utente = utenteDaoImpl.login(email.getText(), password.getText());
                    if (utente != null) {
                        result.setText("Login riuscito");
                        result.setTextFill(Color.web("green"));
                        utenteDaoImpl.updateUtente(utente);
                    } else {
                        result.setText("Password errata");
                        result.setTextFill(Color.web("red"));
                    }
                } else {
                    result.setText("Email non registrata");
                    result.setTextFill(Color.web("red"));
                }
            } else {
                result.setText("Inserire una password");
                result.setTextFill(Color.web("red"));
            }
        } else {
            result.setText("Inserire una email");
            result.setTextFill(Color.web("red"));
        }
        result.setVisible(true);
    }
}

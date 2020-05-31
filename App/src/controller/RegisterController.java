package controller;

import javafx.scene.paint.Color;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Utente;
import model.UtenteDaoImpl;

public class RegisterController implements Initializable {

    UtenteDaoImpl utenteDaoImpl;
    Utente utente = null;
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    PasswordField reenterPassword;
    @FXML
    Label result;
    @FXML
    Button register;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utenteDaoImpl = new UtenteDaoImpl();
    }

    @FXML
    public void handleMouseClick(MouseEvent evt) throws SQLException {
        String regex = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email.getText());
        if (matcher.matches()) {
            if (!password.getText().equals("")) {
                if (password.getText().equals(reenterPassword.getText())) {
                    if (utenteDaoImpl.isRegistered(email.getText())) {
                        result.setText("Email già utilizzata");
                        result.setTextFill(Color.web("red"));
                    } else {
                        utente = utenteDaoImpl.register(email.getText(), password.getText());
                        result.setText("Registrazione effettuata");
                        result.setTextFill(Color.web("green"));
                    }
                } else {
                    result.setText("Le password non coincidono");
                    result.setTextFill(Color.web("red"));
                }
            } else {
                result.setText("Devi inserire una password");
                result.setTextFill(Color.web("red"));
            }
        } else {
            result.setText("Email non valida");
            result.setTextFill(Color.web("red"));
        }
        result.setVisible(true);
    }
}

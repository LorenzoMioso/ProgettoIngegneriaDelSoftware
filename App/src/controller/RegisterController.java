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
    //campi di register.fxml
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
        String regexEmail = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String regexPassword= "/^[a-zA-Z0-9\\_\\*\\-\\+\\!\\?\\,\\:\\;\\.\\xE0\\xE8\\xE9\\xF9\\xF2\\xEC\\x27]{6,12}/";
        Pattern patternEmail = Pattern.compile(regexEmail);
        Pattern patternPassword = Pattern.compile(regexPassword);
        Matcher matcher = patternEmail.matcher(email.getText());
        Matcher matcherPwd = patternEmail.matcher(password.getText());
        if (matcher.matches()) {
            if (!password.getText().equals("")) {
                if(matcherPwd.matches()){
                
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
                }else{
                    result.setText("Password non valida! La password deve avere min 6, max 12 di caratteri, numeri, _ * – + ! ? , : ; . e lettere accentate");
                    result.setTextFill(Color.web("red"));
                } 
            }else {
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

package net.snortum.javafx.multiscenefxml.controller;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import net.snortum.javafx.multiscenefxml.Main;
import net.snortum.javafx.multiscenefxml.model.SceneName;
import net.snortum.javafx.multiscenefxml.model.SessionStorage;
import net.snortum.javafx.multiscenefxml.model.Stageable;
import net.snortum.javafx.multiscenefxml.model.Utente;
import net.snortum.javafx.multiscenefxml.model.UtenteDaoImpl;

public class LoginController implements Stageable, Initializable {

    private Stage stage;
    private SessionStorage sessionStorage;
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
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sessionStorage = Main.getSessionStorage();
        utenteDaoImpl = new UtenteDaoImpl();
        utente = (Utente) sessionStorage.getUtente();
    }

    @FXML
    public void loginMouseClick(MouseEvent evt) throws SQLException {
        if (!email.getText().equals("")) {
            if (!password.getText().equals("")) {
                if (utenteDaoImpl.isRegistered(email.getText()) == true) {
                    utente = utenteDaoImpl.login(email.getText(), password.getText());
                    if (utente != null) {
                        sessionStorage.setUtente(utente);
                        
                        email.setText("");
                        password.setText("");
                        stage.setScene(Main.getScenes().get(SceneName.CATALOG).getScene());

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

    @FXML
    private void handleOnActionBack(ActionEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.CATALOG).getScene());
    }
}

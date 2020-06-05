package net.snortum.javafx.multiscenefxml.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import net.snortum.javafx.multiscenefxml.Main;
import net.snortum.javafx.multiscenefxml.model.SceneName;
import net.snortum.javafx.multiscenefxml.model.Stageable;
import net.snortum.javafx.multiscenefxml.model.Utente;
import net.snortum.javafx.multiscenefxml.model.UtenteDaoImpl;

public class LoginController implements Stageable {

    private Stage stage;
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

    @FXML
    private void handleOnActionBack(ActionEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.ROOT).getScene());
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

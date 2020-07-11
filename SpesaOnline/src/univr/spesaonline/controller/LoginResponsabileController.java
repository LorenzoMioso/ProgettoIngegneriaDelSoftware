package univr.spesaonline.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import univr.spesaonline.Main;
import univr.spesaonline.model.ResponsabileReparto;
import univr.spesaonline.model.ResponsabileRepartoDaoImpl;
import univr.spesaonline.model.SceneName;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Stageable;
import univr.spesaonline.model.Utente;
import univr.spesaonline.model.UtenteDaoImpl;

public class LoginResponsabileController implements Stageable, Initializable {

    private Stage stage;
    private SessionStorage sessionStorage;
    ResponsabileRepartoDaoImpl responsabileRepartoDaoImpl;
    ResponsabileReparto responsabile = null;
    
    @FXML
    TextField matricola;
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
        responsabileRepartoDaoImpl = new ResponsabileRepartoDaoImpl();
        responsabile = (ResponsabileReparto) sessionStorage.getResponsabile();
    }

    @FXML
    public void loginMouseClick(MouseEvent evt) throws SQLException {
        if (!matricola.getText().equals("")) {
            if (!password.getText().equals("")) {
                if (responsabileRepartoDaoImpl.isRegistered(matricola.getText()) == true) {
                    responsabile = (ResponsabileReparto) responsabileRepartoDaoImpl.login(matricola.getText(), password.getText());
                    if (responsabile != null) {
                        sessionStorage.setResponsabile(responsabile);

                        matricola.setText("");
                        password.setText("");
                        stage.setScene(Main.getScenes().get(SceneName.OVERVIEW_RESPONSABILE).getScene());

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
            result.setText("Inserire una matricola");
            result.setTextFill(Color.web("red"));
        }
        result.setVisible(true);
    }

    @FXML
    private void handleOnActionBack(ActionEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.START_SCREEN).getScene());
    }

}

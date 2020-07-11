package univr.spesaonline.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import univr.spesaonline.Main;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Stageable;

public class OverviewResponsabileController implements Stageable, Initializable {
    private Stage stage;
    private SessionStorage sessionStorage;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sessionStorage = Main.getSessionStorage();

    }

}

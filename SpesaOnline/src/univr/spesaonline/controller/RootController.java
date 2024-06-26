package univr.spesaonline.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import univr.spesaonline.Main;
import univr.spesaonline.model.SceneName;
import univr.spesaonline.model.Stageable;

/**
 * Pressing a button displays the different scenes.
 *
 * @author Knute Snortum
 * @version 2018-05-24
 */
public class RootController implements Stageable {

    private Stage stage;

    @FXML
    private void handleOnActionCatalog(ActionEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.CATALOG).getScene());
    }

    @FXML
    private void handleOnActionLogin(ActionEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.LOGIN).getScene());
    }

    @FXML
    private void handleOnActionRegister(ActionEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.REGISTER).getScene());
    }

    @FXML
    private void handleOnActionFullRegister(ActionEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.FULLREGISTER).getScene());
    }

    /**
     * Needed by the close button
     *
     * @param stage primary stage to set
     */
    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

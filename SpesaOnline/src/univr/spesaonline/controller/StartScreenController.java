/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univr.spesaonline.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import univr.spesaonline.Main;
import univr.spesaonline.model.SceneName;
import univr.spesaonline.model.Stageable;

/**
 *
 * @author elisa
 */
public class StartScreenController implements Stageable{
    
    private Stage stage;
    @FXML
    Button btnUtente;
    @FXML 
    Button btnResponsabileReparto;
    public void handleOnActionUtente(ActionEvent evt){
        stage.setScene(Main.getScenes().get(SceneName.CATALOG).getScene());
    }
    public void handleOnActionResponsabileReparto(ActionEvent evt){
        stage.setScene(Main.getScenes().get(SceneName.LOGIN_RESPONSABILE).getScene());
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

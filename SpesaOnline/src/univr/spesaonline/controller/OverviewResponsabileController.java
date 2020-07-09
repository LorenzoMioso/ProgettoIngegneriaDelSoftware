/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univr.spesaonline.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import univr.spesaonline.Main;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Stageable;

/**
 *
 * @author elisa
 */
public class OverviewResponsabileController implements Stageable, Initializable{
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

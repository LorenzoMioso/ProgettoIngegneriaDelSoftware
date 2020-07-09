/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univr.spesaonline.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import univr.spesaonline.Main;
import univr.spesaonline.model.ProductFilter;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Spesa;
import univr.spesaonline.model.SpesaDaoImpl;

/**
 *
 * @author elisa
 */
public class OverviewResponsabileSpeseController implements Initializable{
    private List<Spesa> speseList;
    private SpesaDaoImpl spesaDaoImpl = null;
    private SessionStorage sessionStorage;
    @FXML
    VBox speseVBox;

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        sessionStorage = Main.getSessionStorage();
        spesaDaoImpl = new SpesaDaoImpl();
        try {
            speseList = spesaDaoImpl.getAllSpesa();
        } catch (SQLException ex) {
            Logger.getLogger(OverviewResponsabileSpeseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        sessionStorage.setSpeseList(speseList);
        for (Spesa s : speseList) {
            URL urlFile = getClass().getResource("/view/spesaItem.fxml");
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node prodottoSmall = null;
            try {
                prodottoSmall = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(OverviewResponsabileSpeseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            SpesaItemController ctrl = loader.getController();
            speseVBox.getChildren().add(prodottoSmall);
            try {
                ctrl.setSpesa(s);
            } catch (SQLException ex) {
                Logger.getLogger(OverviewResponsabileSpeseController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(OverviewResponsabileSpeseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

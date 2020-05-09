/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Catalogo;
import model.Fetcher;

/**
 *
 * @author lore
 */
public class FXMLDocumentController implements Initializable {
    Fetcher f = new Fetcher();
    Catalogo c = new Catalogo();
    
    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        c = f.fetchProdotti();
        label.setText(c.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            f.createProdotti();
            f.insertProdotti();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

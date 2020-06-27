/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snortum.javafx.multiscenefxml.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import net.snortum.javafx.multiscenefxml.model.Spesa;

/**
 *
 * @author elisa
 */
public class SpesaItemController implements Initializable{
    private Spesa spesa;
    @FXML
    private Label inCorsoConsegnata;
    @FXML
    private Label dataAcquisto;
    @FXML
    private Label dataConsegna;
    @FXML
    private Label prezzoTotale;
    @FXML
    private Button btnArticoli;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    public void setSpesa(Spesa spesa) throws SQLException, IOException{
        this.spesa = spesa;
        inCorsoConsegnata.setText(spesa.getStato());
        dataAcquisto.setText("" + spesa.getDataOrdine());
        dataConsegna.setText("" + spesa.getDataConsegna());
        prezzoTotale.setText("" + spesa.getCostoTot());
    }
    public void handleMouseClickBtnArticoli(MouseEvent evt){
        
    }
}

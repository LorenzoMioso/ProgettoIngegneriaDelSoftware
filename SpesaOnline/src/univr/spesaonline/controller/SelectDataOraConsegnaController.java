/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univr.spesaonline.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import univr.spesaonline.model.Stageable;

/**
 *
 * @author elisa
 */
public class SelectDataOraConsegnaController implements Initializable, Stageable{
    private final static int FIRST_ELEMENT = 0;
    private final static int LAST_ELEMENT = 0;
    private final static int BEGIN = 8;
    private final static int END = 20;
    
    
    
    private Stage stage;
    @FXML 
    ComboBox comboData;
    @FXML 
    ComboBox comboOraInizio;
    @FXML 
    ComboBox comboOraFine;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List <String> timeTable = new ArrayList <>();
        int i;
        for(i = BEGIN; i < END - 1; i++){
            timeTable.add(""+ i + ":00");
        }
        comboOraInizio.getItems().setAll(timeTable);
        timeTable.remove(FIRST_ELEMENT);
        i = END - 1;
        timeTable.add(""+ i + ":00");
        comboOraFine.getItems().setAll(timeTable);
        
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
}

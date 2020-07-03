package net.snortum.javafx.multiscenefxml.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.snortum.javafx.multiscenefxml.Main;
import net.snortum.javafx.multiscenefxml.model.Observer;
import net.snortum.javafx.multiscenefxml.model.Prodotto;
import net.snortum.javafx.multiscenefxml.model.SessionStorage;
import net.snortum.javafx.multiscenefxml.model.Spesa;
import net.snortum.javafx.multiscenefxml.model.Stageable;

public class ProductListController extends Observer implements Stageable, Initializable {

    private SessionStorage sessionStorage;
    private Spesa spesa;
    private Stage stage;
    private List<Spesa> speseList;
    @FXML
    VBox vbox;
    @FXML
    Label prezzoTotale;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSpesa(Spesa spesa) {
        this.spesa = spesa;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sessionStorage = Main.getSessionStorage();
        sessionStorage.attach(this);
        speseList = sessionStorage.getSpeseList();
        System.out.println("Setto la spesa");
        spesa = sessionStorage.getSpesa();
        try {
            showItems();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(ProductListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showItems() throws IOException, SQLException {
        prezzoTotale.setText("" + spesa.getCostoTot());
        vbox.getChildren().clear();

        System.out.println("Spesa: " + spesa);
        System.out.println("Prodotti: " + spesa.getProdotti().toString());
        for (Map.Entry<Prodotto, Integer> entry : spesa.getProdotti().entrySet()) {
            URL urlFile = getClass().getResource("/view/prodottoSmallWithoutButton.fxml");
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node prodottoSmallWithoutButton = loader.load();
            ProdottoSmallWithoutButtonController ctrl = loader.getController();
            vbox.getChildren().add(prodottoSmallWithoutButton);
            ctrl.setProdotto(entry.getKey(), entry.getValue());
            ctrl.showProdotto();
        }
        prezzoTotale.setText(String.valueOf(sessionStorage.getCarrello().getPrezzoTot()));
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSpesa() {
        sessionStorage = Main.getSessionStorage();
        speseList = sessionStorage.getSpeseList();
        System.out.println("Setto la spesa");
        spesa = sessionStorage.getSpesa();
        try {
            showItems();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(ProductListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package net.snortum.javafx.multiscenefxml.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.snortum.javafx.multiscenefxml.Main;
import net.snortum.javafx.multiscenefxml.model.ObserverCarrello;
import net.snortum.javafx.multiscenefxml.model.Prodotto;
import net.snortum.javafx.multiscenefxml.model.SessionStorage;
import net.snortum.javafx.multiscenefxml.model.Stageable;

public class CartController extends ObserverCarrello implements Stageable, Initializable {

    private SessionStorage sessionStorage;
    private Stage stage;

    @FXML
    VBox vbox;
    @FXML
    Label prezzoTotale;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sessionStorage = Main.getSessionStorage();
        sessionStorage.getCarrello().attach(this);
        try {
            showItems();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showItems() throws IOException, SQLException {
        sessionStorage = Main.getSessionStorage();
        vbox.getChildren().clear();
        System.out.println("Carrello:");
        for (Map.Entry<Prodotto, Integer> entry : sessionStorage.getCarrello().getProdotti().entrySet()) {
            System.out.println("Prodotto " + entry.getKey() + " Quantità: " + entry.getValue());
        }
        for (Map.Entry<Prodotto, Integer> entry : sessionStorage.getCarrello().getProdotti().entrySet()) {
            URL urlFile = getClass().getResource("/view/cartItem.fxml");
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node cartItem = loader.load();
            CartItemController ctrl = loader.getController();
            vbox.getChildren().add(cartItem);
            ctrl.setCartItem(entry.getKey(), entry.getValue());
            ctrl.showCartItem();
        }
        prezzoTotale.setText(String.valueOf(sessionStorage.getCarrello().getPrezzoTot()));
    }

    @Override
    public void update() {
        try {
            showItems();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

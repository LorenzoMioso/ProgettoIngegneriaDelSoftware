package net.snortum.javafx.multiscenefxml.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.snortum.javafx.multiscenefxml.Main;
import net.snortum.javafx.multiscenefxml.model.Prodotto;
import net.snortum.javafx.multiscenefxml.model.SessionStorage;
import net.snortum.javafx.multiscenefxml.model.Stageable;

public class CartItemController implements Stageable, Initializable {

    private SessionStorage sessionStorage;
    private Stage stage;
    private Prodotto prodotto;
    private int numeroProdotto;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 10;
    private static final int STEP = 1;
    private static final int INITIAL_VALUE = 1;

    @FXML
    Pane pane;
    @FXML
    Spinner quantità;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sessionStorage = Main.getSessioStorage();
    }

    public void setCartItem(Prodotto p, int n){
        this.prodotto = p;
        this.numeroProdotto = n;
    }

    public void showCartItem() throws IOException, SQLException {
        URL urlFile = getClass().getResource("/view/prodottoSmall.fxml");
        FXMLLoader loader = new FXMLLoader(urlFile);
        Node prodottoSmall = loader.load();
        ProdottoSmallController ctrl = loader.getController();
        pane.getChildren().add(prodottoSmall);
        ctrl.setProdotto(prodotto);
        ctrl.showProdotto();
        //set spinner value
        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(MIN_VALUE, MAX_VALUE, numeroProdotto, STEP);
        quantità.setValueFactory(factory);
        quantità.setEditable(true);
    }

    @FXML
    private void handleMouseClickRemoveItem(MouseEvent event) {
        sessionStorage.getCarrello().removeProdotto(prodotto);
    }
}

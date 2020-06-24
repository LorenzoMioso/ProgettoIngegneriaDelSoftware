package net.snortum.javafx.multiscenefxml.controller;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import net.snortum.javafx.multiscenefxml.Main;

import net.snortum.javafx.multiscenefxml.model.Stageable;
import net.snortum.javafx.multiscenefxml.model.Prodotto;
import net.snortum.javafx.multiscenefxml.model.ProdottoDaoImpl;
import net.snortum.javafx.multiscenefxml.model.SceneName;

public class CatalogController implements Stageable, Initializable {

    private Stage stage;
    @FXML
    StackPane stackpane;
    @FXML
    GridPane catalogo;
    @FXML
    TilePane tilepane;
    @FXML
    ComboBox combobox;

    ProdottoDaoImpl prodottoDaoImpl;
    List<Prodotto> productList;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combobox.getItems().addAll("Caratteristiche", "Marca", "Tipo");
        prodottoDaoImpl = new ProdottoDaoImpl();
        try {
            addProdotti();
        } catch (SQLException ex) {
            Logger.getLogger(CatalogController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CatalogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //        Platform.runLater(() -> {
//            try {
//                addProdotti();
//            } catch (SQLException ex) {
//                Logger.getLogger(CatalogController.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(CatalogController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
    }

    private void addProdotti() throws SQLException, IOException {
        productList = prodottoDaoImpl.getAllProdotto();
        for (Prodotto p : productList) {
            URL urlFile = getClass().getResource("/view/prodottoSmall.fxml");
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node prodottoSmall = loader.load();
            ProdottoSmallController ctrl = loader.getController();
            tilepane.getChildren().add(prodottoSmall);
            ctrl.setProdotto(p);
        }
    }

    @FXML
    private void handleMouseClickLogin(MouseEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.LOGIN).getScene());
    }

    @FXML
    private void handleMouseClickRegister(MouseEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.REGISTER).getScene());
    }

    @FXML
    private void handleMouseClickCart(MouseEvent event) {
        // stage.setScene(Main.getScenes().get(SceneName.LOGIN).getScene());
    }
}

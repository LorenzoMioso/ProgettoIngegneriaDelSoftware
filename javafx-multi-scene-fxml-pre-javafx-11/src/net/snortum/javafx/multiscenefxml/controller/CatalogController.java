package net.snortum.javafx.multiscenefxml.controller;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import net.snortum.javafx.multiscenefxml.Main;

import net.snortum.javafx.multiscenefxml.model.Stageable;
import net.snortum.javafx.multiscenefxml.model.Prodotto;
import net.snortum.javafx.multiscenefxml.model.ProdottoDaoImpl;
import net.snortum.javafx.multiscenefxml.model.ProductFilter;
import net.snortum.javafx.multiscenefxml.model.ProductSorter;
import net.snortum.javafx.multiscenefxml.model.Reparto;
import net.snortum.javafx.multiscenefxml.model.SceneName;

public class CatalogController implements Stageable, Initializable {

    private Stage stage;
    ProdottoDaoImpl prodottoDaoImpl;
    List<Prodotto> productList;
    ProductFilter pFilter;
    ProductSorter pSorter;

    @FXML
    StackPane stackpane;
    @FXML
    GridPane catalogo;
    @FXML
    TilePane tilepane;
    @FXML
    ComboBox combobox;
    @FXML
    ToggleButton repartoBevande;
    @FXML
    ToggleButton repartoFrutta;
    @FXML
    ToggleButton repartoGastronomia;
    @FXML
    ToggleButton repartoLatteria;
    @FXML
    ToggleButton repartoMacelleria;
    @FXML
    ToggleButton repartoOlieAceti;
    @FXML
    ToggleButton repartoPanetteria;
    @FXML
    ToggleButton repartoPasticceria;
    @FXML
    ToggleButton repartoPescheria;
    @FXML
    ToggleButton repartoScatolame;
    @FXML
    ToggleButton repartoSughieSalse;
    @FXML
    ToggleButton repartoSurgelati;
    @FXML
    ToggleButton repartoVerdura;
    @FXML
    ToggleButton repartoVinieLiquori;
    @FXML
    ToggleButton prezzoCrescente;
    @FXML
    ToggleButton prezzoDecrescente;
    @FXML
    ToggleButton marcaCrescente;
    @FXML
    ToggleButton marcaDecrescente;
    @FXML
    TextField searchBar;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combobox.getItems().addAll("Caratteristiche", "Marca", "Tipo");
        prodottoDaoImpl = new ProdottoDaoImpl();
        try {
            showAllProductSmall();
        } catch (SQLException | IOException ex) {
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

    private void showProductSmall() throws SQLException, IOException {
        tilepane.getChildren().clear();
        for (Prodotto p : productList) {
            URL urlFile = getClass().getResource("/view/prodottoSmall.fxml");
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node prodottoSmall = loader.load();
            ProdottoSmallController ctrl = loader.getController();
            tilepane.getChildren().add(prodottoSmall);
            ctrl.setProdotto(p);
            ctrl.showProdotto();
        }
    }

    private void showAllProductSmall() throws SQLException, IOException {
        productList = prodottoDaoImpl.getAllProdotto();
        showProductSmall();
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
    private void handleMouseClickOverviewUtente(MouseEvent event) {
        stage.setScene(Main.getScenes().get(SceneName.OVERVIEWUTENTE).getScene());
    }

    @FXML
    private void handleMouseClickCart(MouseEvent event) {
        Stage cartWindow = new Stage();
        cartWindow.setTitle("Carrello");
        cartWindow.setScene(Main.getScenes().get(SceneName.CART).getScene());
        cartWindow.show();
//        stage.setScene(Main.getScenes().get(SceneName.CART).getScene());
    }

    @FXML
    private void handleMouseClickCerca(MouseEvent event) throws SQLException, IOException {
        if (searchBar.getText() != null && combobox.getSelectionModel().getSelectedItem() != null) {
            productList = prodottoDaoImpl.getAllProdotto();
            pFilter = new ProductFilter(productList);
            switch (combobox.getSelectionModel().getSelectedItem().toString()) {
                case "Caratteristiche":
                    pFilter.searchCaratteristica(searchBar.getText());
                    break;
                case "Marca":
                    pFilter.searchMarca(searchBar.getText());
                    break;
                case "Tipo":
                    pFilter.searchTipo(searchBar.getText());
                    break;
            }
            productList = pFilter.getProductList();
            showProductSmall();
        }
    }

    @FXML
    private void handleMouseClickPrezzo(MouseEvent event) throws SQLException, IOException {
        pSorter = new ProductSorter(productList);
        switch (((ToggleButton) event.getSource()).getId()) {
            case "prezzoCrescente":
                pSorter.SortByPrezzoCrescente();
                break;
            case "prezzoDecrescente":
                pSorter.SortByPrezzoDecrescente();
                break;
        }
        productList = pSorter.getProductList();
        showProductSmall();
    }

    @FXML
    private void handleMouseClickMarca(MouseEvent event) throws SQLException, IOException {
        pSorter = new ProductSorter(productList);
        switch (((ToggleButton) event.getSource()).getId()) {
            case "marcaCrescente":
                pSorter.SortByMarcaCrescente();
                break;
            case "marcaDecrescente":
                pSorter.SortByMarcaDecrescente();
                break;
        }
        productList = pSorter.getProductList();
        showProductSmall();
    }

    @FXML
    private void handleMouseClickReparto(MouseEvent event) throws SQLException, IOException {
        if (((ToggleButton) event.getSource()).isSelected()) {
            String filter = "";
            switch (((ToggleButton) event.getSource()).getId()) {
                case "repartoBevande":
                    filter = "Bevande";
                    break;
                case "repartoFrutta":
                    filter = "Frutta";
                    break;
                case "repartoGastronomia":
                    filter = "Gastronomia";
                    break;
                case "repartoLatteria":
                    filter = "Latteria";
                    break;
                case "repartoMacelleria":
                    filter = "Macelleria";
                    break;
                case "repartoOlieAceti":
                    filter = "Oli e aceti";
                    break;
                case "repartoPanetteria":
                    filter = "Panetteria";
                    break;
                case "repartoPasticceria":
                    filter = "Pasticceria";
                    break;
                case "repartoPescheria":
                    filter = "Pescheria";
                    break;
                case "repartoScatolame":
                    filter = "Scatolame";
                    break;
                case "repartoSughieSalse":
                    filter = "Sughi e Salse";
                    break;
                case "repartoSurgelati":
                    filter = "Surgelati";
                    break;
                case "repartoVerdura":
                    filter = "Verdura";
                    break;
                case "repartoVinieLiquori":
                    filter = "Vini e Liquori";
                    break;
            }
            productList = prodottoDaoImpl.getAllProdotto();
            pFilter = new ProductFilter(productList);
            pFilter.filterByReparto(new Reparto(filter));
            productList = pFilter.getProductList();
            showProductSmall();
        } else {
            showAllProductSmall();
        }
    }

}

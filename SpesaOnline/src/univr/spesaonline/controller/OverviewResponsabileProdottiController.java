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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.ProdottoDaoImpl;
import univr.spesaonline.model.ProductFilter;
import univr.spesaonline.model.ProductSorter;
import univr.spesaonline.model.SessionStorage;

/**
 *
 * @author elisa
 */
public class OverviewResponsabileProdottiController implements Initializable{
     private Stage stage;
    private SessionStorage sessionStorage;
    ProdottoDaoImpl prodottoDaoImpl;
    List<Prodotto> productList;
    ProductFilter pFilter;
    ProductSorter pSorter;
    @FXML
    TextField searchBar;
    @FXML
    ComboBox combobox;
    @FXML
    TilePane tilepane;
     @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
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
     private void showAllProductSmall() throws SQLException, IOException {
        productList = prodottoDaoImpl.getAllProdotto();
        showProductSmall();
    }

   
}

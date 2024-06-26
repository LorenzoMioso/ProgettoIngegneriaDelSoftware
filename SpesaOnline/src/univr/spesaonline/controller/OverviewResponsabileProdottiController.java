package univr.spesaonline.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import univr.spesaonline.Main;
import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.ProdottoDaoImpl;
import univr.spesaonline.model.ProductFilter;
import univr.spesaonline.model.ProductSorter;
import univr.spesaonline.model.Reparto;
import univr.spesaonline.model.ResponsabileReparto;
import univr.spesaonline.model.SessionStorage;

public class OverviewResponsabileProdottiController implements Initializable {

    private Stage stage;
    private SessionStorage sessionStorage;
    private Reparto reparto;
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
    @FXML
    Label nomeReparto;
    @FXML
    Button aggiungiProdotti;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sessionStorage = Main.getSessionStorage();
        prodottoDaoImpl = new ProdottoDaoImpl();
        productList = new ArrayList<>();

        combobox.getItems().addAll("Caratteristiche", "Marca", "Tipo");
        nomeReparto.setText("" + ((ResponsabileReparto) sessionStorage.getResponsabile()).getRuolo());
        reparto = new Reparto(((ResponsabileReparto) sessionStorage.getResponsabile()).getRuolo());
        try {
            showAllProductSmall();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(CatalogController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showProductSmall() throws SQLException, IOException {
        tilepane.getChildren().clear();
        for (Prodotto p : productList) {
            URL urlFile = getClass().getResource("/view/prodottoSmallEditable.fxml");
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node prodottoSmall = loader.load();
            ProdottoSmallEditableController ctrl = loader.getController();
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
            pFilter.filterByReparto(reparto);
            productList = pFilter.getProductList();
            switch (combobox.getSelectionModel().getSelectedItem().toString()) {
                case "Caratteristiche":
                    pFilter.searchCaratteristicaReparto(searchBar.getText(), reparto.getNome());
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
        pFilter = new ProductFilter(productList);
        pFilter.filterByReparto(reparto);
        productList = pFilter.getProductList();
        showProductSmall();
    }

    public void handleMouseClickAggiungiProdotto(MouseEvent evt) throws IOException, SQLException {
        URL urlFile = getClass().getResource("/view/prodottoBigAdd.fxml");
        FXMLLoader loader = new FXMLLoader(urlFile);
        Parent prodottoBig = loader.load();
        ProdottoBigAddController ctrl = loader.getController();

        Scene scene = new Scene(prodottoBig);

        Stage prodottoBigWindow = new Stage();
        prodottoBigWindow.setTitle("Aggiungi prodotto");
        prodottoBigWindow.setScene(scene);
        prodottoBigWindow.show();

        //ctrl.setProdotto(prodotto);
        ctrl.showProdotto();
    }

    @FXML
    private void handleMouseClickRefresh(MouseEvent event) throws SQLException, IOException {
        showAllProductSmall();
    }

}

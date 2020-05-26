package controller;

import java.io.File;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import model.*;

public class RootController implements Initializable {

    @FXML
    StackPane stackpane;
    @FXML
    TilePane tilepane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProdottoDaoImpl prodottoDaoImpl = new ProdottoDaoImpl();
        List<Prodotto> productList = null;
        try {
            productList = prodottoDaoImpl.getAllProdotto();
            for (Prodotto p : productList) {
                URL urlFile = new File("src/view/prodottoSmall.fxml").toURI().toURL();
                FXMLLoader loader = new FXMLLoader(urlFile);
                Node prodottoSmall = (Node) loader.load();
                ProdottoSmallController ctrl = loader.getController();
                tilepane.getChildren().add(prodottoSmall);
            }
        } catch (IOException ex) {
            Logger.getLogger(RootController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RootController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

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
import model.Prodotto;
import model.ProdottoDaoImpl;

public class RootController implements Initializable {

    @FXML
    StackPane stackpane;
    @FXML
    TilePane tilepane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Start login view
        /*
        try {
            URL urlFile = new File("src/view/login.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node login = (Node) loader.load();
            LoginController ctrl = loader.getController();
            stackpane.getChildren().add(login);
        } catch (IOException ex) {
            Logger.getLogger(RootController.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        //Start register view
        /*
        try {
            URL urlFile = new File("src/view/register.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node register = (Node) loader.load();
            RegisterController ctrl = loader.getController();
            stackpane.getChildren().add(register);
        } catch (IOException ex) {
            Logger.getLogger(RootController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        //Start full register  view
        /*
        try {
            URL urlFile = new File("src/view/fullRegister.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node register = (Node) loader.load();
            FullRegisterController ctrl = loader.getController();
            stackpane.getChildren().add(register);
        } catch (IOException ex) {
            Logger.getLogger(RootController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        //Start catalogo view

        
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
                ctrl.setProdotto(p);
            }
        } catch (IOException ex) {
            Logger.getLogger(RootController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RootController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

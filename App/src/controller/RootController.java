package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

public class RootController implements Initializable {

    @FXML
    StackPane stackpane;
    @FXML
    TilePane tilepane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL urlFile = new File("src/view/prodottoSmall.fxml").toURI().toURL();
            Node prodottoSmall = FXMLLoader.load(urlFile);
            Node prodottoSmall1 = FXMLLoader.load(urlFile);
            tilepane.getChildren().add(prodottoSmall);
            tilepane.getChildren().add(prodottoSmall1);
        } catch (IOException ex) {
            Logger.getLogger(RootController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

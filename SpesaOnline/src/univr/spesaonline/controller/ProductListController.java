package univr.spesaonline.controller;

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
import univr.spesaonline.Main;
import univr.spesaonline.model.Observer;
import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Spesa;
import univr.spesaonline.model.Stageable;

public class ProductListController implements Stageable, Initializable {

    private Spesa spesa;
    private Stage stage;

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
    }

    public void showItems() throws IOException, SQLException {
        vbox.getChildren().clear();
        System.out.println("Spesa ProductListController: " + spesa);
        prezzoTotale.setText("" + spesa.getCostoTot() + "");
        System.out.println("PrezzoTotale Label: " + prezzoTotale.getText());
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
        prezzoTotale.setText(String.valueOf(spesa.getCostoTot()));
    }

}

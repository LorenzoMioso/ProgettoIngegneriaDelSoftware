package univr.spesaonline.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import univr.spesaonline.Main;
import univr.spesaonline.model.SceneName;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Spesa;
import univr.spesaonline.model.Stageable;

public class SpesaItemController implements Stageable, Initializable {

    private Stage stage;
    private Spesa spesa;
    private SessionStorage sessionStorage;
    @FXML
    private Label inCorsoConsegnata;
    @FXML
    private Label dataAcquisto;
    @FXML
    private Label dataConsegna;
    @FXML
    private Label prezzoTotale;
    @FXML
    private Button btnArticoli;

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sessionStorage = Main.getSessionStorage();
    }

    public void setSpesa(Spesa spesa) throws SQLException, IOException {
        this.spesa = spesa;
        inCorsoConsegnata.setText(spesa.getStato());
        dataAcquisto.setText("" + spesa.getDataOrdine());
        dataConsegna.setText("" + spesa.getDataConsegna());
        prezzoTotale.setText("" + spesa.getCostoTot());
    }

    public void handleMouseClickBtnArticoli(MouseEvent evt) throws IOException, SQLException {
        URL urlFile = getClass().getResource("/view/productList.fxml");
        FXMLLoader loader = new FXMLLoader(urlFile);
        Parent productList = loader.load();
        ProductListController ctrl = loader.getController();

        Stage ItemListWindow = new Stage();
        ItemListWindow.setTitle("Prodotti comprati");
        Scene scene = new Scene(productList);

        ItemListWindow.setScene(scene);
        ItemListWindow.show();

        System.out.println("Spesa in SpesaItemController" + spesa.toString());
        ctrl.setSpesa(spesa);
        ctrl.showItems();

    }

}

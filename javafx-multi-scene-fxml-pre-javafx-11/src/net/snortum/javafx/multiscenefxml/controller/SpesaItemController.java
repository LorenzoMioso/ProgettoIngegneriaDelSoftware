package net.snortum.javafx.multiscenefxml.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.snortum.javafx.multiscenefxml.Main;
import net.snortum.javafx.multiscenefxml.model.SceneName;
import net.snortum.javafx.multiscenefxml.model.SessionStorage;
import net.snortum.javafx.multiscenefxml.model.Spesa;
import net.snortum.javafx.multiscenefxml.model.Stageable;

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
        sessionStorage.setSpesa(spesa);
    }

    public void handleMouseClickBtnArticoli(MouseEvent evt) throws IOException, SQLException {
       
        Stage ItemListWindow = new Stage();
        ItemListWindow.setTitle("Prodotti comprati");
        ItemListWindow.setScene(Main.getScenes().get(SceneName.PRODUCTLIST).getScene());
        ItemListWindow.show();
//        URL urlFile = getClass().getResource("/view/productList.fxml");
//        FXMLLoader loader = new FXMLLoader(urlFile);
//        Node productList = loader.load();
//        ProductListController ctrl = loader.getController();
//        System.out.println("Spesa in SpesaItemController: " + spesa);
//        ctrl.setSpesa(spesa);
//        ctrl.showItems();
    }

}

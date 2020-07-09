package univr.spesaonline.controller;

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
import javafx.scene.layout.VBox;
import univr.spesaonline.Main;
import univr.spesaonline.model.SessionStorage;
import univr.spesaonline.model.Spesa;
import univr.spesaonline.model.SpesaDaoImpl;

public class OverviewResponsabileSpeseController implements Initializable {

    private List<Spesa> speseList;
    private SpesaDaoImpl spesaDaoImpl = null;
    private SessionStorage sessionStorage;
    private Spesa s;
    @FXML
    VBox speseVBox;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        sessionStorage = Main.getSessionStorage();
        spesaDaoImpl = new SpesaDaoImpl();
        sessionStorage = Main.getSessionStorage();
        spesaDaoImpl = new SpesaDaoImpl();
        try {
            showSpese();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(OverviewResponsabileSpeseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showSpese() throws SQLException, IOException {
        speseList = spesaDaoImpl.getAllSpesa();
        for (Spesa s : speseList) {
            URL urlFile = getClass().getResource("/view/spesaItem.fxml");
            FXMLLoader loader = new FXMLLoader(urlFile);
            Node prodottoSmall = null;
            prodottoSmall = loader.load();
            SpesaItemController ctrl = loader.getController();
            speseVBox.getChildren().add(prodottoSmall);
            System.out.println("DentroOverviewResponsabile spesa " + s);
            ctrl.setSpesa(s);
        }
    }
}

package univr.spesaonline.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import univr.spesaonline.Main;

import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.SessionStorage;

public class ProdottoSmallEditableController implements Initializable {

    private SessionStorage sessionStorage;
    private Prodotto prodotto;

    @FXML
    Label nomeProdotto;
    @FXML
    Label marcaProdotto;
    @FXML
    Label prezzoProdotto;
    @FXML
    Label pesoProdotto;
    @FXML
    Label numeroPezzi;
    @FXML
    ImageView immagineProdotto;
    @FXML
    Button carrello;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sessionStorage = Main.getSessionStorage();

    }

    public void setProdotto(Prodotto p) {
        this.prodotto = p;
    }

    public void showProdotto() throws SQLException, IOException {
        nomeProdotto.setText(prodotto.getNome());
        marcaProdotto.setText(prodotto.getMarca());
        prezzoProdotto.setText(prodotto.getPrezzo() + " €");

        if (prodotto.getImmagine() != null) {
            Blob aBlob = prodotto.getImmagine();
            InputStream is = null;
            BufferedImage imag = null;
            is = aBlob.getBinaryStream(1, aBlob.length());
            imag = ImageIO.read(is);
            Image image1 = SwingFXUtils.toFXImage(imag, null);
            immagineProdotto.setImage(image1);
        }
    }

    public void handleMouseShowProdottoBigEditable() throws IOException, SQLException {
        URL urlFile = getClass().getResource("/view/prodottoBigEditable.fxml");
        FXMLLoader loader = new FXMLLoader(urlFile);
        Parent prodottoBig = loader.load();
        ProdottoBigEditableController ctrl = loader.getController();

        Scene scene = new Scene(prodottoBig);

        Stage prodottoBigWindow = new Stage();
        prodottoBigWindow.setTitle("MOdifica prodotto");
        prodottoBigWindow.setScene(scene);
        prodottoBigWindow.show();

        ctrl.setProdotto(prodotto);
        ctrl.showProdotto();
    }

}

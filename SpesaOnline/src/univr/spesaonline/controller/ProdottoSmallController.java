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
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import univr.spesaonline.Main;

import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.SceneName;
import univr.spesaonline.model.SessionStorage;

public class ProdottoSmallController implements Initializable {

    private SessionStorage sessionStorage;
    private Prodotto prodotto;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 10;
    private static final int STEP = 1;
    private static final int INITIAL_VALUE = 1;

    @FXML
    Label nomeProdotto;
    @FXML
    Label marcaProdotto;
    @FXML
    Label prezzo;
    @FXML
    Label pesoProdotto;
    @FXML
    Label numeroPezzi;
    @FXML
    ImageView immagineProdotto;
    @FXML
    Spinner quantità;
    @FXML
    ToggleButton carrello;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sessionStorage = Main.getSessionStorage();
        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(MIN_VALUE, MAX_VALUE, INITIAL_VALUE, STEP);
        quantità.setValueFactory(factory);
        quantità.setEditable(true);
    }

    public void setProdotto(Prodotto p) {
        this.prodotto = p;
    }

    public void showProdotto() throws SQLException, IOException {
        nomeProdotto.setText("" + prodotto.getNome());
        marcaProdotto.setText(prodotto.getMarca());
        prezzo.setText("" + prodotto.getPrezzo());
        pesoProdotto.setText("" + prodotto.getPeso());
        numeroPezzi.setText("" + prodotto.getnPezzi());

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

    public void handleMouseAddToCart() {
        sessionStorage.getCarrello().putProdotto(prodotto, (Integer) quantità.getValue());
        System.out.println("Aggiunto " + prodotto + "\nQuantità: " + (Integer) quantità.getValue());
    }

    public void handleMouseShowProdottoBig() throws IOException, SQLException {
        URL urlFile = getClass().getResource("/view/prodottobig.fxml");
        FXMLLoader loader = new FXMLLoader(urlFile);
        Node prodottoBig = loader.load();
        ProdottoBigController ctrl = loader.getController();
        ctrl.setProdotto(prodotto);
        ctrl.showProdotto();

        Stage prodottoBigWindow = new Stage();
        prodottoBigWindow.setTitle("Prodotto");
        prodottoBigWindow.setScene(prodottoBig.getScene());
        prodottoBigWindow.show();
    }

}

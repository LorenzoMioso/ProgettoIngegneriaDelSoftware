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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import univr.spesaonline.Main;

import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.SessionStorage;

public class ProdottoSmallWithoutButtonController implements Initializable {

    private SessionStorage sessionStorage;
    private Prodotto prodotto;
    private int nProdotto;

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
    Label quantitàProdotto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sessionStorage = Main.getSessionStorage();
    }

    public void setProdotto(Prodotto p, int n) {
        this.prodotto = p;
        this.nProdotto = n;
    }

    public void showProdotto() throws SQLException, IOException {
        nomeProdotto.setText("" + prodotto.getNome());
        marcaProdotto.setText(prodotto.getMarca());
        prezzo.setText("" + prodotto.getPrezzo());
        pesoProdotto.setText("" + prodotto.getPeso());
        numeroPezzi.setText("" + prodotto.getnPezzi());
        quantitàProdotto.setText(String.valueOf(nProdotto));

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

    
}

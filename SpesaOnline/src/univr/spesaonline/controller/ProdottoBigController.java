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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import univr.spesaonline.Main;
import univr.spesaonline.model.Caratteristica;
import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.ProdottoDaoImpl;
import univr.spesaonline.model.SessionStorage;

public class ProdottoBigController implements Initializable {

    private SessionStorage sessionStorage;
    ProdottoDaoImpl prodottoDaoImpl;
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
    Label prezzoProdotto;
    @FXML
    Label pesoProdotto;
    @FXML
    Label nPezziProdotto;
    @FXML
    ImageView immagineProdotto;
    @FXML
    Spinner quantità;
    @FXML
    TextArea caratteristicheProdotto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sessionStorage = Main.getSessionStorage();
        prodottoDaoImpl = new ProdottoDaoImpl();
        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(MIN_VALUE, MAX_VALUE,
                INITIAL_VALUE, STEP);
        quantità.setValueFactory(factory);
        quantità.setEditable(true);
    }

    public void setProdotto(Prodotto p) {
        this.prodotto = p;
    }

    public void showProdotto() throws SQLException, IOException {
        nomeProdotto.setText("" + prodotto.getNome());
        marcaProdotto.setText(prodotto.getMarca());
        prezzoProdotto.setText("" + prodotto.getPrezzo() + " €");
        pesoProdotto.setText("" + prodotto.getPeso() + " g");
        nPezziProdotto.setText("" + prodotto.getnPezzi() + " pezzi");

        if (prodotto.getImmagine() != null) {
            Blob aBlob = prodotto.getImmagine();
            InputStream is = null;
            BufferedImage imag = null;
            is = aBlob.getBinaryStream(1, aBlob.length());
            imag = ImageIO.read(is);
            Image image1 = SwingFXUtils.toFXImage(imag, null);
            immagineProdotto.setImage(image1);
        }

        prodotto.setCarattristiche(prodottoDaoImpl.getCaratteristicaByProdotto(prodotto.getId()));

        for (Caratteristica c : prodotto.getCarattristiche()) {
            caratteristicheProdotto.appendText(c.getNome() + "\n");

        }
    }

    public void handleMouseAddToCart() {
        sessionStorage.getCarrello().putProdotto(prodotto, (Integer) quantità.getValue());
        System.out.println("Aggiunto " + prodotto + "\nQuantità: " + (Integer) quantità.getValue());
    }

}

package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import model.Prodotto;

public class ProdottoSmallController implements Initializable {

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
    Button carrello;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory <Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(MIN_VALUE, MAX_VALUE,INITIAL_VALUE, STEP);
        quantità.setValueFactory(factory);
        quantità.setEditable(true);
    }

    public void setProdotto(Prodotto p) {
        try {
            this.prodotto = p;
            nomeProdotto.setText("" + prodotto.getNome());
            marcaProdotto.setText(prodotto.getMarca());
            prezzo.setText("" + prodotto.getPrezzo());
            pesoProdotto.setText("" + prodotto.getPeso());
            numeroPezzi.setText("" + prodotto.getnPezzi());
          
            if (p.getImmagine() != null) {
                Blob aBlob = prodotto.getImmagine();
                InputStream is = null;
                BufferedImage imag = null;
                is = aBlob.getBinaryStream(1, aBlob.length());
                imag = ImageIO.read(is);
                Image image1 = SwingFXUtils.toFXImage(imag, null);
                immagineProdotto.setImage(image1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdottoSmallController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProdottoSmallController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

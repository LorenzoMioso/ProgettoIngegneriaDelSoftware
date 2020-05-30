package controller;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import model.Prodotto;

public class ProdottoSmallController implements Initializable {

    private Prodotto prodotto;
    @FXML
    Label nomeProdotto;
    @FXML
    Label marca;
    @FXML
    Label prezzo;
    @FXML
    Label peso;
    @FXML
    ImageView immagineProdotto;

    @FXML 
    Button carrello;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }

    public void setProdotto(Prodotto p) {
        try {
            FileInputStream input;
            input = new FileInputStream("../designImages/shopping_cart-white-18dp.svg");
            Image image = new Image(input);
            carrello.setGraphic(new ImageView(image));
            this.prodotto = p;
            nomeProdotto.setText("" + prodotto.getNome());
            if (p.getImmagine() != null) {
                Blob aBlob = prodotto.getImmagine();
                InputStream is = null;
                BufferedImage imag = null;
                is = aBlob.getBinaryStream(1, aBlob.length());
                imag = ImageIO.read(is);
                Image image1 = SwingFXUtils.toFXImage(imag, null);;
                immagineProdotto.setImage(image1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdottoSmallController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProdottoSmallController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

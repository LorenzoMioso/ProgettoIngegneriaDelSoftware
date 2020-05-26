
package controller;

import java.awt.image.BufferedImage;
import java.io.File;
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
    ImageView immagineProdotto;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }
    public void setProdotto(Prodotto p){
        this.prodotto = p;
        nomeProdotto.setText("" + prodotto.getNome());
       
        Blob aBlob = prodotto.getImmagine();
        InputStream is = null;
        BufferedImage imag = null;
        try {
            is = aBlob.getBinaryStream(0, aBlob.length());
            imag = ImageIO.read(is);
        } catch (SQLException ex) {
            Logger.getLogger(ProdottoSmallController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProdottoSmallController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Image image = SwingFXUtils.toFXImage(imag, null);;
        
        immagineProdotto.setImage(image);
    
    }

}

package univr.spesaonline.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import univr.spesaonline.model.Caratteristica;
import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.ProdottoDaoImpl;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProdottoTest {
    
    @Test 
    public void containsProdottoAggiunto() throws SQLException{
        Prodotto prodotto;
        List<Prodotto> prodotti;
        ProdottoDaoImpl prodottoDaoImpl;

        prodottoDaoImpl = new ProdottoDaoImpl();

        prodotto = new Prodotto(0, "Mele", "PinkLady", null, "Frutta", "Frutta", true, 1000, 10, 1.75);

        //inserimento prodotto 
        prodottoDaoImpl.insertProdotto(prodotto);
        prodotti = prodottoDaoImpl.getAllProdotto();
        //controllo inserimeto
        //assertNotNull(prodotto);
       Assertions.assertTrue(prodotti.contains(prodotto));

    }
    @Test 
    public void containsProdottoModificato() throws SQLException{
        Prodotto prodotto;
        prodotto = new Prodotto(0, "Mele", "PinkLady", null, "Frutta", "Frutta", true, 1000, 10, 1.75);
        List<Prodotto> prodotti;
        ProdottoDaoImpl prodottoDaoImpl;

        prodottoDaoImpl = new ProdottoDaoImpl();
        prodotto.setPrezzo(3.0);
        prodottoDaoImpl.updateProdotto(prodotto);
        prodotti = prodottoDaoImpl.getAllProdotto(); 
        Assertions.assertTrue(prodotti.contains(prodotto));
    }
   
}

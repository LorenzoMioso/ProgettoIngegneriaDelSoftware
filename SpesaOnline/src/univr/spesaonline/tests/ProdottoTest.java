package univr.spesaonline.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import univr.spesaonline.model.Caratteristica;
import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.ProdottoDaoImpl;

class ProdottoTest {

    public static void main(String[] args) throws SQLException {
        Prodotto prodotto;
        List<Prodotto> prodotti;
        ProdottoDaoImpl prodottoDaoImpl;

        prodottoDaoImpl = new ProdottoDaoImpl();

        prodotto = new Prodotto(0, "Mele", "PinkLady", null, "Frutta", "Frutta", true, 1000, 10, 1.75);

        //inserimento prodotto 
        prodottoDaoImpl.insertProdotto(prodotto);
        prodotti = prodottoDaoImpl.getAllProdotto();
        //controllo inserimeto
        for (Prodotto p : prodotti) {
            if (p.equals(prodotto)) {
                System.out.println("Protto inserito");
            }
        }

        //modifica prodotto
        prodotto.setPrezzo(3.0);
        prodottoDaoImpl.updateProdotto(prodotto);
        prodotti = prodottoDaoImpl.getAllProdotto();
        //controllo modifica
        for (Prodotto p : prodotti) {
            if (p.equals(prodotto)) {
                System.out.println("Protto modificato");
            }
        }
    }

}

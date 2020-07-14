/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univr.spesaonline.tests;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import univr.spesaonline.model.Prodotto;
import univr.spesaonline.model.ProdottoDaoImpl;
import univr.spesaonline.model.Utente;
import univr.spesaonline.model.UtenteDaoImpl;
/**
 *
 * 
 */
public class TestRunner {
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
                System.out.println("Prodotto inserito");
            }
        }

        //modifica prodotto
        prodotto.setPrezzo(3.0);
        prodottoDaoImpl.updateProdotto(prodotto);
        prodotti = prodottoDaoImpl.getAllProdotto();
        //controllo modifica
        for (Prodotto p : prodotti) {
            if (p.equals(prodotto)) {
                System.out.println("Prodotto modificato");
            }
        }
        //inserimento di un utente
        Utente u;
        List <Utente> utenti ;
        UtenteDaoImpl utenteDaoImpl = new UtenteDaoImpl();
       
        Date date = Date.valueOf("1989-03-31");
        u = new Utente("b.rosi@gmail.com", "Ciao12", "Bianca","Rosi", date , "Via De Gasperi", "15","Verona", "Verona", 37030, "045521982","Paypal");
        utenteDaoImpl.register(u.getEmail(), u.getPassword());
        utenteDaoImpl.updateUtente(u);
        if(u.equals(utenteDaoImpl.login(u.getEmail(), u.getPassword())))
              System.out.println("Utente aggiunto nel db");
        
    }
    
}

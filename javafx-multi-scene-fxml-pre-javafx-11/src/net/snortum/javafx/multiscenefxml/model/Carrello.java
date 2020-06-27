package net.snortum.javafx.multiscenefxml.model;

import java.util.HashMap;
import java.util.Map;

public class Carrello {

    private HashMap<Prodotto, Integer> Prodotti;
    private int prezzoTot;

    public Carrello() {
        Prodotti = new HashMap<Prodotto, Integer>();
        prezzoTot = 0;
    }

    public void putProdotto(Prodotto p, int n) {
        Prodotti.put(p, n);
        updatePrezzoTot();
    }

    public void removeProdotto(Prodotto p) {
        Prodotti.remove(p);
        updatePrezzoTot();
    }

    public HashMap<Prodotto, Integer> getProdotti() {
        return Prodotti;
    }

    public void setProdotti(HashMap<Prodotto, Integer> Prodotti) {
        this.Prodotti = Prodotti;
    }

    private void updatePrezzoTot() {
        for (Map.Entry<Prodotto, Integer> entry : Prodotti.entrySet()) {
            prezzoTot += entry.getKey().getPrezzo() * entry.getValue();
        }
    }

    public int getPrezzoTot() {
        return prezzoTot;
    }

}

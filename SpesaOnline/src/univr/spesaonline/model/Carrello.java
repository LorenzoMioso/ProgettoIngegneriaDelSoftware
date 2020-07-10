package univr.spesaonline.model;

import java.util.HashMap;
import java.util.Map;

public class Carrello extends Subject {

    private Map<Prodotto, Integer> prodotti;
    private double prezzoTot;

    public Carrello() {
        this.prodotti = new HashMap<Prodotto, Integer>();
        this.prezzoTot = 0;
    }

    public void putProdotto(Prodotto p, int n) {
        prodotti.put(p, n);
        updatePrezzoTot();
        notifyAllObservers();
    }

    public void removeProdotto(Prodotto p) {
        prodotti.remove(p);
        updatePrezzoTot();
        notifyAllObservers();
    }

    public Map<Prodotto, Integer> getProdotti() {
        return prodotti;
    }

    public void setProdotti(HashMap<Prodotto, Integer> Prodotti) {
        this.prodotti = Prodotti;
        notifyAllObservers();
    }

    private void updatePrezzoTot() {
        prezzoTot = 0;
        for (Map.Entry<Prodotto, Integer> entry : prodotti.entrySet()) {
            prezzoTot += entry.getKey().getPrezzo() * entry.getValue();
        }
    }

    public void emptyCarrello() {
        this.prodotti = new HashMap<Prodotto, Integer>();
        this.prezzoTot = 0;
        notifyAllObservers();
    }

    public double getPrezzoTot() {
        return prezzoTot;
    }

}

package net.snortum.javafx.multiscenefxml.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrello {

    private List<Observer> observers;
    private HashMap<Prodotto, Integer> prodotti;
    private int prezzoTot;

    public Carrello() {
        this.observers = new ArrayList<>();
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

    public HashMap<Prodotto, Integer> getProdotti() {
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

    public int getPrezzoTot() {
        return prezzoTot;
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}

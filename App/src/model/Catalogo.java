package model;

import java.util.ArrayList;

public class Catalogo {

    private ArrayList<Prodotto> catalogo;

    public Catalogo() {
        this.catalogo = new ArrayList<Prodotto>();
    }

    public void addProdotto(Prodotto prodotto) {
        this.catalogo.add(prodotto);
    }

    @Override
    public String toString() {
        return this.catalogo.toString();
    }

}

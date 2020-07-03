package net.snortum.javafx.multiscenefxml.model;

import java.util.ArrayList;
import java.util.List;

public class SessionStorage extends Subject {

    private Autenticabile utente;
    private TesseraFedelta tesseraFedelta;
    private Carrello carrello;
    private List<Spesa> speseList;
    private Spesa spesa;

    public SessionStorage() {
        this.carrello = new Carrello();
        this.utente = new Utente();
        this.utente.setIsLogged(false);
        this.speseList = new ArrayList<>();
        this.spesa = new Spesa();
    }

    public Utente getUtente() {
        return (Utente) utente;
    }

    public void setUtente(Autenticabile utente) {
        this.utente = utente;
        notifyAllObservers();
    }

    public boolean isLogged() {
        return utente.isIsLogged();
    }

    public void logOut() {
        this.carrello = new Carrello();
        this.utente = new Utente();
        this.utente.setIsLogged(false);
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
        notifyAllObservers();
    }

    public List<Spesa> getSpeseList() {
        return speseList;
    }

    public void setSpeseList(List<Spesa> speseList) {
        this.speseList = speseList;
    }

    public Spesa getSpesa() {
        return spesa;
    }

    public void setSpesa(Spesa spesa) {
        this.spesa = spesa;
        notifyAllObserversSpesa();
    }

    public TesseraFedelta getTesseraFedelta() {
        return tesseraFedelta;
    }

    public void setTesseraFedelta(TesseraFedelta tesseraFedelta) {
        this.tesseraFedelta = tesseraFedelta;
        notifyAllObservers();
    }

}

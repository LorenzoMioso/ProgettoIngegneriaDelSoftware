package univr.spesaonline.model;

import java.util.ArrayList;
import java.util.List;

public class SessionStorage extends Subject {

    private Autenticabile autenticabile;
    private TesseraFedelta tesseraFedelta;
    private Carrello carrello;
    private List<Spesa> speseList;
    private Spesa spesa;

    public SessionStorage() {
        this.carrello = new Carrello();
        this.autenticabile = new Utente();
        this.autenticabile.setIsLogged(false);
        this.speseList = new ArrayList<>();
        this.spesa = new Spesa();
    }

    public Autenticabile getAutenticabile() {
        return autenticabile;
    }

    public void setAutenticabile(Autenticabile autenticabile) {
        this.autenticabile = autenticabile;
        notifyAllObservers();
    }

    public boolean isLogged() {
        return autenticabile.isLogged();
    }

    public void logOut() {
        this.carrello = new Carrello();
        this.autenticabile = new Utente();
        notifyAllObservers();
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

package univr.spesaonline.model;

import java.util.ArrayList;
import java.util.List;

public class SessionStorage extends Subject {

    private Autenticabile utente;
    private Autenticabile responsabile;
    private TesseraFedelta tesseraFedelta;
    private Carrello carrello;
    private List<Spesa> speseList;
    private Spesa spesa;

    public SessionStorage() {
        this.carrello = new Carrello();
        this.utente = new Utente();
        this.responsabile = new ResponsabileReparto();
        this.utente.setIsLogged(false);
        this.responsabile.setIsLogged(false);
        this.speseList = new ArrayList<>();
        this.spesa = new Spesa();
    }
   
    public Autenticabile getUtente() {
        return utente;
    }

    public void setUtente(Autenticabile utente) {
        this.utente = utente;
        notifyAllObservers();
    }

    public boolean isLoggedUtente() {
        return utente.isLogged();
    }

    public void logOut() {
        this.carrello = new Carrello();
        this.utente = new Utente();
        notifyAllObservers();
    }
    public Autenticabile getResponsabile() {
        return responsabile;
    }

    public void setResponsabile(Autenticabile responsabile) {
        this.responsabile = responsabile;
    }

    public boolean isLoggedResponsabile() {
        return responsabile.isLogged();
    }

    public void logOutResponsabile() {
        this.responsabile = new ResponsabileReparto();
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

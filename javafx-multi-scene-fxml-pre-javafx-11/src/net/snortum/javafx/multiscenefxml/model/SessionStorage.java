package net.snortum.javafx.multiscenefxml.model;

public class SessionStorage {

    Autenticabile utente;
    Carrello carrello;

    public SessionStorage() {
        carrello = new Carrello();
    }

    public Autenticabile getUtente() {
        return utente;
    }

    public void setUtente(Autenticabile utente) {
        this.utente = utente;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

}

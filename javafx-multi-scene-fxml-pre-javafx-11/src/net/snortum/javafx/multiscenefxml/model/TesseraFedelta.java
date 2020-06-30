package net.snortum.javafx.multiscenefxml.model;

import java.util.Date;

public class TesseraFedelta {

    private int id;
    private Date dataEmissione;
    private int punti;
    private Utente utente;

    public TesseraFedelta(int id, Date dataEmissione, int punti, Utente utente) {
        this.id = id;
        this.dataEmissione = dataEmissione;
        this.punti = punti;
        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(Date dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

};

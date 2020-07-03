package net.snortum.javafx.multiscenefxml.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
public class Spesa {

    private int id;
    private Timestamp dataOrdine;
    private Date dataConsegna;
    private Time oraInizio;
    private Time oraFine;
    private double costoTot;
    private int saldoPunti;
    private String pagamento;
    private Utente utente;
    private String stato;
    private Map <Prodotto, Integer> prodotti;

    public Spesa(int id, Timestamp dataOrdine, Date dataConsegna, Time oraInizio, Time oraFine, double costoTot, int saldoPunti, String pagamento, Utente utente, String stato, Map <Prodotto, Integer> prodotti) {
        this.id = id;
        this.dataOrdine = dataOrdine;
        this.dataConsegna = dataConsegna;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.costoTot = costoTot;
        this.saldoPunti = saldoPunti;
        this.pagamento = pagamento;
        this.utente = utente;
        this.stato = stato;
        this.prodotti = prodotti;
    }

    public Spesa(){
        this.id = 0;
        this.dataOrdine = null;
        this.dataConsegna = null;
        this.oraInizio = null;
        this.oraFine = null;
        this.costoTot = 0.0;
        this.saldoPunti = 0;
        this.pagamento = "";
        this.utente = null;
        this.prodotti = null;
    }

    public Spesa(double costoTot, int saldoPunti, Utente utente, Map<Prodotto, Integer> prodotti) {
        this.costoTot = costoTot;
        this.saldoPunti = saldoPunti;
        this.utente = utente;
        this.prodotti = prodotti;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Timestamp dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public Date getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(Date dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public Time getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(Time oraInizio) {
        this.oraInizio = oraInizio;
    }

    public Time getOraFine() {
        return oraFine;
    }

    public void setOraFine(Time oraFine) {
        this.oraFine = oraFine;
    }

    public double getCostoTot() {
        return costoTot;
    }

    public void setCostoTot(double costoTot) {
        this.costoTot = costoTot;
    }

    public int getSaldoPunti() {
        return saldoPunti;
    }

    public void setSaldoPunti(int saldoPunti) {
        this.saldoPunti = saldoPunti;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Map<Prodotto, Integer> getProdotti() {
        return prodotti;
    }

    public void setProdotti(Map<Prodotto, Integer> prodotti) {
        this.prodotti = prodotti;
    }

    @Override
    public String toString() {
        return "Spesa{" + "id=" + id + ", dataOrdine=" + dataOrdine + ", dataConsegna=" + dataConsegna + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", costoTot=" + costoTot + ", saldoPunti=" + saldoPunti + ", pagamento=" + pagamento + ", utente=" + utente + ", stato=" + stato + ", prodotti=" + prodotti + '}';
    }

   
    
};

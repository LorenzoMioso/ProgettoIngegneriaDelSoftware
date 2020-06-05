package net.snortum.javafx.multiscenefxml.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
public class Spesa {

    private int id;
    private Timestamp dataOrdine;
    private Date dataConsegna;
    private Time oraInizio;
    private Time oraFine;
    private int costoTot;
    private int saldoPunti;
    private String pagamento;
    private Utente utente;
    private String stato;
    private Prodotto[] prodotto;
};

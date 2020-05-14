package model;

import java.sql.Date;
import java.sql.Time;

public class Spesa {

    private int id;
    private Date dataConsegna;
    private Time oraInizio;
    private Time oraFine;
    private int costoTot;
    private int saldoPunti;
    private String pagamento;
    private Prodotto[] prodotto;
    
    private String stato;
};

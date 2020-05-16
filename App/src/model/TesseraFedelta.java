package model;

import java.util.Date;

public class TesseraFedelta {

    private int id;
    private Date dataEmissione;
    private int punti;
    public TesseraFedelta(int id, Date dataEmissione, int punti) {
        this.id = id;
        this.dataEmissione = dataEmissione;
        this.punti = punti;
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
};

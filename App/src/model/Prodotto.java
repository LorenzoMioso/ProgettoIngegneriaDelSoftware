package model;

public class Prodotto {

    private int id;
    private String nome;
    private String marca;
    private String reparto;
    private boolean inVendita;
    private double peso;
    private int nPezzi;
    private int prezzo;

    public Prodotto(int id, String nome, String marca, String reparto, boolean inVendita, double peso, int nPezzi, int prezzo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.reparto = reparto;
        this.inVendita = inVendita;
        this.prezzo = prezzo;
        
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getReparto() {
        return reparto;
    }

    public int getnPezzi() {
        return nPezzi;
    }

    public void setnPezzi(int nPezzi) {
        this.nPezzi = nPezzi;
    }
    public boolean getInVendita() {
        return inVendita;
    }

    public int getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "id=" + id + ", nome=" + nome + ", marca=" + marca + ", reparto=" + reparto + ", quantit\u00e0=" + inVendita + ", prezzo=" + prezzo + '}';
    }

    String getPeso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getNPezzi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

};


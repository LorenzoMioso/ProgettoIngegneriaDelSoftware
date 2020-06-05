package net.snortum.javafx.multiscenefxml.model;

import java.sql.Blob;

public class Prodotto {

    private int id;
    private String nome;
    private String marca;
    private String reparto;
    private Blob immagine;
    private boolean inVendita;
    private double peso;
    private int nPezzi;
    private double prezzo;

    public Prodotto(int id, String nome, String marca, Blob immagine, String reparto, boolean inVendita, double peso, int nPezzi, double prezzo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.immagine = immagine;
        this.reparto = reparto;
        this.inVendita = inVendita;
        this.peso = peso;
        this.nPezzi = nPezzi;
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

    public double getPrezzo() {
        return prezzo;
    }

    public Blob getImmagine() {
        return immagine;
    }

    public boolean isInVendita() {
        return inVendita;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "id=" + id + ", nome=" + nome + ", marca=" + marca + ", reparto=" + reparto + ", inVendita= " + inVendita + ", peso= " + peso +", nPezzi= " + nPezzi +", prezzo=" + prezzo + '}';
    }



};


package net.snortum.javafx.multiscenefxml.model;

import java.sql.Blob;

public class Prodotto {

    private int id;
    private String nome;
    private String marca;
    private Blob immagine;
    private String reparto;
    private String tipo;
    private boolean inVendita;
    private double peso;
    private int nPezzi;
    private double prezzo;

    public Prodotto(int id, String nome, String marca, String reparto, String tipo, Blob immagine, boolean inVendita, double peso, int nPezzi, double prezzo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.reparto = reparto;
        this.tipo = tipo;
        this.immagine = immagine;
        this.inVendita = inVendita;
        this.peso = peso;
        this.nPezzi = nPezzi;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Blob getImmagine() {
        return immagine;
    }

    public void setImmagine(Blob immagine) {
        this.immagine = immagine;
    }

    public boolean isInVendita() {
        return inVendita;
    }

    public void setInVendita(boolean inVendita) {
        this.inVendita = inVendita;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getnPezzi() {
        return nPezzi;
    }

    public void setnPezzi(int nPezzi) {
        this.nPezzi = nPezzi;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "id=" + id + ", nome=" + nome + ", marca=" + marca + ", reparto=" + reparto + ", tipo=" + tipo + ", immagine=" + immagine + ", inVendita=" + inVendita + ", peso=" + peso + ", nPezzi=" + nPezzi + ", prezzo=" + prezzo + '}';
    }

};

package model;

public class Prodotto {

    private int id;
    private String nome;
    private String marca;
    private String reparto;
    private int quantità;
    private int prezzo;

    public Prodotto(int id, String nome, String marca, String reparto, int quantità, int prezzo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.reparto = reparto;
        this.quantità = quantità;
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

    public int getQuantità() {
        return quantità;
    }

    public int getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "id=" + id + ", nome=" + nome + ", marca=" + marca + ", reparto=" + reparto + ", quantit\u00e0=" + quantità + ", prezzo=" + prezzo + '}';
    }

};

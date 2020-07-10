package univr.spesaonline.model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Prodotto {

    private int id;
    private String nome;
    private String marca;
    private Blob immagine;
    private String tipo;
    private String reparto;
    private boolean inVendita;
    private double peso;
    private int nPezzi;
    private double prezzo;
    private List<Caratteristica> carattristiche;

    public Prodotto(int id, String nome, String marca, Blob immagine, String tipo, String reparto, boolean inVendita, double peso, int nPezzi, double prezzo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.immagine = immagine;
        this.tipo = tipo;
        this.reparto = reparto;
        this.inVendita = inVendita;
        this.peso = peso;
        this.nPezzi = nPezzi;
        this.prezzo = prezzo;
        this.carattristiche = new ArrayList();
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

    public Blob getImmagine() {
        return immagine;
    }

    public void setImmagine(Blob immagine) {
        this.immagine = immagine;
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

    public List<Caratteristica> getCarattristiche() {
        return carattristiche;
    }

    public void setCarattristiche(List<Caratteristica> carattristiche) {
        this.carattristiche = carattristiche;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "id=" + id + ", nome=" + nome + ", marca=" + marca + ", immagine=" + immagine + ", tipo=" + tipo + ", reparto=" + reparto + ", inVendita=" + inVendita + ", peso=" + peso + ", nPezzi=" + nPezzi + ", prezzo=" + prezzo + ", carattristiche=" + carattristiche + '}';
    }

    public static Comparator<Prodotto> prezzoComparator = new Comparator<Prodotto>() {
        @Override
        public int compare(Prodotto p1, Prodotto p2) {
            return (p1.getPrezzo() < p2.getPrezzo() ? -1
                    : (p1.getPrezzo() == p2.getPrezzo() ? 0 : 1));
        }
    };

    public static Comparator<Prodotto> marcaComparator = new Comparator<Prodotto>() {
        @Override
        public int compare(Prodotto p1, Prodotto p2) {
            return p1.getMarca().compareTo(p2.getMarca());
        }
    };

};

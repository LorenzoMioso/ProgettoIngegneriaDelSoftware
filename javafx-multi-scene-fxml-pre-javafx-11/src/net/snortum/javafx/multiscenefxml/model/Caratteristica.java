package net.snortum.javafx.multiscenefxml.model;

public class Caratteristica {

    private String nome;

    public Caratteristica(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Caratteristica{" + "nome=" + nome + '}';
    }

}

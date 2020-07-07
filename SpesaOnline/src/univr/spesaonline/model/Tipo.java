package univr.spesaonline.model;

public class Tipo {

    private String nome;

    public Tipo(String nome) {
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
        return "Tipo{" + "nome=" + nome + '}';
    }

}

package univr.spesaonline.model;

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

    @Override
    public boolean equals(Object c) {
        return c instanceof Caratteristica
                && ((Caratteristica) c).getNome().equals(this.getNome());
    }
}

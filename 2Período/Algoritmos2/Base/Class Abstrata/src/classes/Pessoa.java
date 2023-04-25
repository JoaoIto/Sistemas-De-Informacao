package src.classes;

public abstract class Pessoa {
    private String nome;

    public abstract void imprimir();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

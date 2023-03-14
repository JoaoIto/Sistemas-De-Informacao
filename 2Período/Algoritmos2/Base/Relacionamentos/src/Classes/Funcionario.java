package src.Classes;

public class Funcionario {
    private String nome;
    private Funcionario chefeImediato;

    public Funcionario getChefeImediato() {
        return chefeImediato;
    }

    public void setChefeImediato(Funcionario chefeImediato) {
        this.chefeImediato = chefeImediato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

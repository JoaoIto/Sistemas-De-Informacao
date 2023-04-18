package Classes.Associacao;

public class Professor {
    private String nome;
    private String titulacao;

    public Professor(String nome, String titulacao) {
        this.nome = nome;
        this.titulacao = titulacao;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public String getTitulacao() {
        return titulacao;
    }
}
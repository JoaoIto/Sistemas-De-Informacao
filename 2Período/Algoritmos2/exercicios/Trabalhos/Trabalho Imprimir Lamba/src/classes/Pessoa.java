package src.classes;
public class Pessoa implements Impressao {
    private String nome;
    private int idade;
    private Telefone telefone;
    private Sexo sexo;

    public Pessoa(String nome, int idade, Telefone telefone, Sexo sexo) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }



    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", telefone=" + telefone +
                ", sexo=" + sexo +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Telefone: +" + telefone.getCodigoArea() + " " + telefone.getNumero());
        System.out.println("Sexo: " + sexo);
    }

}

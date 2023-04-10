package src.classes;

public class Aluno {
    private String nome;
    //private String disciplina;
    private Telefone telefone;
    //private double nota1;
    //private double nota2;
    //private double media;
    private String status;

    public Aluno() {

    }

    public Aluno(String nome, Telefone telefone, String status) {
        this.nome = nome;
        //this.disciplina = disciplina;
        this.telefone = telefone;
      //  this.nota1 = nota1;
        //this.nota2 = nota2;
        //this.media = (nota1 + nota2) / 2;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void getTelefone() {
        System.out.println(telefone.getCodigoArea());
        System.out.println(telefone.getNumero());
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}

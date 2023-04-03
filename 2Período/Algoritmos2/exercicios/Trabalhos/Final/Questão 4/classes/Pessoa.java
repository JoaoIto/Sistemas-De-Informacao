package classes;

public class Pessoa {
    private Integer id;
    private String nome;
    private String email;

    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void imprimir(Pessoa pessoa){
        System.out.println("O id da pessoa é: " + pessoa.id);
        System.out.println("O nome da pessoa é: " + pessoa.nome);
        System.out.println("O email da pessoa é: " + pessoa.email);
        System.out.println("\n");
    }
}

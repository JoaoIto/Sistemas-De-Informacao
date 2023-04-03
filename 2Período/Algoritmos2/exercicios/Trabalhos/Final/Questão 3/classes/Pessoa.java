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

    public void imprimir(){
        System.out.println("O id da pessoa é: " + this.id);
        System.out.println("O nome da pessoa é: " + this.nome);
        System.out.println("O email da pessoa é: " + this.email);
    }
}

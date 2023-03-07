package Classes;
import java.util.Scanner;
import Classes.Data;
public class Pessoa {
    private String cpf;
    private String nome;
    private String sobrenome;
    private String date;

    public Pessoa lerDados(){
        Scanner sc = new Scanner(System.in);
        Pessoa p = new Pessoa();
        System.out.print("Informe o nome: ");
        p.setNome(sc.next());
        System.out.print("Informe o sobrenome: ");
        p.setSobrenome(sc.next());
        System.out.print("Informe o CPF: ");
        p.setCpf(sc.next());
        return p;
    }

    public void imprimir(Pessoa p){
        System.out.println("Nome: " + p.nome);
        System.out.println("Sobrenome: " + p.sobrenome);
        System.out.println("CPF: " + p.cpf);
        System.out.println("Data de Nascimento: " + p.date);
    }

    /*
    public Pessoa(String cpf, String nome, String sobrenome) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    */

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    private String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getNomeCompleto(){
        return nome+" "+sobrenome;
    }
}
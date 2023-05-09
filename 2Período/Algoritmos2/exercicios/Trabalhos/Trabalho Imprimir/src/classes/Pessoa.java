package src.classes;

import java.util.List;
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private String cpf;
    private Sexo sexo;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    public Pessoa(Scanner sc) {
        this.nome = sc.next();
        this.cpf = sc.next();
        String sexoLocal = sc.next();
        this.sexo = Sexo.valueOf(sexoLocal.toUpperCase());
    }

    public Pessoa(String nome, String cpf, Sexo sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public static void imprimirTudo(List<Pessoa> lista) {
        System.out.println(lista);
    }

    public static void removerMasculino(List<Pessoa> lista) {
        for (Pessoa pessoa : lista) {
            if(pessoa.getSexo() == Sexo.MASCULINO)
                lista.remove(pessoa);
        }
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo=" + sexo +
                '}';
    }
}

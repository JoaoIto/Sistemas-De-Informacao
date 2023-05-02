package src.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private String cpf;
    private Sexo sexo;

    public Pessoa() {

    }
    public Pessoa(String nome, String cpf, Sexo sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
    }

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

    public String Cadastrar(){
        Scanner scan = new Scanner(System.in);
        List listPessoas = new ArrayList<Pessoa>(4);

        for(int i = 0; i < listPessoas.size(); i++){
            System.out.println("Cadastro de pessoa " + i + "\n");
            System.out.println("Digite o nome da pessoa: ");
            String nome = scan.next();

            System.out.println("Digite o CPF da pessoa: ");
            String cpf = scan.next();

            System.out.println("Digite o sexo da pessoa: ");
            int sexoId = scan.nextInt();
            Sexo sexoSelecionado = null;
            for (Sexo sexo : Sexo.values()) {
                if (sexo.getId() == sexoId) {
                    sexoSelecionado = sexo;
                }
            }

            Pessoa pessoa = new Pessoa(nome, cpf, sexoSelecionado);
            listPessoas.add(pessoa);
        }
        return listPessoas.toString();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}

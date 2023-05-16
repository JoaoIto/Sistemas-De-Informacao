package src.classes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

    public static Pessoa lerDados() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome da pessoa:");
        String nome = scanner.nextLine();

        System.out.println("Digite a idade da pessoa:");
        int idade = scanner.nextInt();

        scanner.nextLine(); // Consumir a quebra de linha após a leitura do int

        System.out.println("Digite o código de área do telefone:");
        String codigoArea = scanner.nextLine();

        System.out.println("Digite o número do telefone:");
        String numero = scanner.nextLine();

        System.out.println("Digite o sexo da pessoa (MASCULINO ou FEMININO):");
        String sexoStr = scanner.nextLine();

        Sexo sexo = Sexo.valueOf(sexoStr.toUpperCase());

        Telefone telefone = new Telefone(codigoArea, numero);

        return new Pessoa(nome, idade, telefone, sexo);
    }

    public static void imprimirListaOrdenadaPorNome(List<Pessoa> lista) {
        /*
        // Expressão comum
        Collections.sort(lista, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa pessoa1, Pessoa pessoa2) {
                return pessoa1.getNome().compareToIgnoreCase(pessoa2.getNome());
            }
        });
        */

        Collections.sort(lista, (pessoa1, pessoa2) -> pessoa1.getNome().compareToIgnoreCase(pessoa2.getNome()));

        System.out.println("Lista de Pessoas Ordenada por Nome:");
        imprimirLista(lista);
        System.out.println("----------------------------------");
    }

    public static void imprimirListaOrdenadaPorIdade(List<Pessoa> lista) {
       /*
       // Expressão comum
       Collections.sort(lista, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa pessoa1, Pessoa pessoa2) {
                return Integer.compare(pessoa1.getIdade(), pessoa2.getIdade());
            }
        });
       */

        Collections.sort(lista, Comparator.comparingInt(Pessoa::getIdade));

        System.out.println("Lista de Pessoas Ordenada por Idade:");
        imprimirLista(lista);
        System.out.println("----------------------------------");
    }

    public static void imprimirListaOrdenadaPorSexo(List<Pessoa> lista) {
        /*
        Expressão comum
        Collections.sort(lista, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa pessoa1, Pessoa pessoa2) {
                return pessoa1.getSexo().compareTo(pessoa2.getSexo());
            }
        });
        */

        Collections.sort(lista, Comparator.comparing(Pessoa::getSexo));

        System.out.println("Lista de Pessoas Ordenada por Sexo:");
        imprimirLista(lista);
        System.out.println("----------------------------------");
    }

    public static void imprimirLista(List<Pessoa> lista) {
        for (Pessoa pessoa : lista) {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println("Telefone: +" + pessoa.getTelefone().getCodigoArea() + " " + pessoa.getTelefone().getNumero());
            System.out.println("Sexo: " + pessoa.getSexo());
            System.out.println("----------------------------------");
        }
    }
}

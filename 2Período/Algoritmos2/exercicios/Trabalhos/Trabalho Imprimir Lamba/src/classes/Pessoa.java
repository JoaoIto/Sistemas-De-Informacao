package src.classes;

import java.util.*;

public class Pessoa implements Impressao {
    private String nome;
    private int idade;
    private List<Telefone> telefones;
    private Sexo sexo;

    public Pessoa() {

    }

    public Pessoa(String nome, int idade, List<Telefone> telefones, Sexo sexo) {
        this.nome = nome;
        this.idade = idade;
        this.telefones = telefones;
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
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
                ", telefones=" + telefones +
                ", sexo=" + sexo +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        for (Telefone telefone : telefones) {
            System.out.println("Telefone: +" + telefone.getCodigoArea() + " " + telefone.getNumero());
        }
        System.out.println("Sexo: " + sexo);
    }


    public static Pessoa lerDados() {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        System.out.println("Digite o nome da pessoa:");
        String nome = scanner.nextLine();

        System.out.println("Digite a idade da pessoa:");
        int idade = scanner.nextInt();

        scanner.nextLine(); // Consumir a quebra de linha após a leitura do int

        System.out.println("Digite o sexo da pessoa (MASCULINO ou FEMININO):");
        String sexoStr = scanner.nextLine();

        Sexo sexo = Sexo.valueOf(sexoStr.toUpperCase());

        List<Telefone> telefones = new ArrayList<>();

        System.out.println("Digite a quantidade de telefones da pessoa:");
        int quantidadeTelefones = scanner.nextInt();

        scanner.nextLine(); // Consumir a quebra de linha após a leitura do int

        for (int i = 0; i < quantidadeTelefones; i++) {
            System.out.println("Telefone " + (i + 1) + ":");
            Telefone telefone = Telefone.lerDados();
            telefones.add(telefone);
        }

        pessoa.setNome(nome);
        pessoa.setIdade(idade);
        pessoa.setTelefones(telefones);
        pessoa.setSexo(sexo);

        return pessoa;
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
            pessoa.imprimir();
            System.out.println("----------------------------------");
        }
    }
}
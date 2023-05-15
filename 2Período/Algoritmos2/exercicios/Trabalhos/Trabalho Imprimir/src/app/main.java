package src.app;

import src.classes.Pessoa;
import src.classes.Sexo;
import src.classes.Telefone;

import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Pessoa> listaPessoas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Pessoa pessoa = lerDados();
            listaPessoas.add(pessoa);
        }

        imprimirListaOrdenadaPorNome(listaPessoas);
        imprimirListaOrdenadaPorIdade(listaPessoas);
        imprimirListaOrdenadaPorSexo(listaPessoas);
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
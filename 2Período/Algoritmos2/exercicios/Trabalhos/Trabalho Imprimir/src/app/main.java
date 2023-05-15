package src.app;

import src.classes.Pessoa;
import src.classes.Sexo;
import src.classes.Telefone;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        List<Pessoa> listaPessoas = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Pessoa pessoa = lerDados();
            listaPessoas.add(pessoa);
        }

        imprimirLista(listaPessoas);
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


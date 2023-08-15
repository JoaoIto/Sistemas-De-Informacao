package src.main;

import src.classes.Array;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Array manipulador = new Array(5);

        // Inserindo informações no array:
        manipulador.inserirNoPrimeiroIndiceVazio(42);
        manipulador.inserirNoPrimeiroIndiceVazio(17);
        manipulador.inserirNoPrimeiroIndiceVazio(30);
        manipulador.inserirNoPrimeiroIndiceVazio(55);
        manipulador.inserirNoPrimeiroIndiceVazio(23);

        int escolha;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir informação no primeiro índice vazio");
            System.out.println("2. Inserir informação em um índice específico");
            System.out.println("3. Alterar informação em um índice");
            System.out.println("4. Listar informações do array");
            System.out.println("0. Sair");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valor = scanner.nextInt();
                    manipulador.inserirNoPrimeiroIndiceVazio(valor);
                    break;
                case 2:
                    System.out.print("Digite o índice: ");
                    int indice = scanner.nextInt();
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorIndice = scanner.nextInt();
                    manipulador.inserirNoIndice(indice, valorIndice);
                    break;
                case 3:
                    System.out.print("Digite o índice: ");
                    int indiceAlteracao = scanner.nextInt();
                    System.out.print("Digite o novo valor: ");
                    int novoValor = scanner.nextInt();
                    manipulador.alterarInformacao(indiceAlteracao, novoValor);
                    break;
                case 4:
                    manipulador.listarInformacoes();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        scanner.close();
    }
}
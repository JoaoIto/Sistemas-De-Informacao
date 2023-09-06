package src.app;

import src.classes.ListaDuplamenteEncadeada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada minhaLista = new ListaDuplamenteEncadeada();
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir no fim");
            System.out.println("2. Inserir no início");
            System.out.println("3. Remover do início");
            System.out.println("4. Remover do fim");
            System.out.println("5. Mostrar lista");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido no fim: ");
                    int valorFim = scanner.nextInt();
                    minhaLista.inserirNoFim(valorFim);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser inserido no início: ");
                    int valorInicio = scanner.nextInt();
                    minhaLista.inserirNoInicio(valorInicio);
                    break;
                case 3:
                    minhaLista.removerDoInicio();
                    break;
                case 4:
                    minhaLista.removerDoFim();
                    break;
                case 5:
                    minhaLista.mostrar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
}

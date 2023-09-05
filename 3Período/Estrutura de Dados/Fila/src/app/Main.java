package src.app;

import src.classes.FilaDinamica;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaDinamica<Integer> fila = new FilaDinamica<>();
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir elemento na fila");
            System.out.println("2. Retirar elemento da fila");
            System.out.println("3. Tamanho da fila");
            System.out.println("4. Verificar se a fila está vazia");
            System.out.println("5. Listar itens da fila");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para inserir na fila: ");
                    int valor = scanner.nextInt();
                    fila.inserir(valor);
                    break;
                case 2:
                    try {
                        int valorRetirado = fila.retirar();
                        System.out.println("Valor retirado da fila: " + valorRetirado);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Tamanho da fila: " + fila.tamanho());
                    break;
                case 4:
                    System.out.println("A fila está vazia? " + fila.estaVazia());
                    break;
                case 5:
                    System.out.print("Itens na fila: ");
                    fila.listarItens();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

package src.app;

import src.classes.ListaEncadeada;
import src.classes.No;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    String elemento = scanner.nextLine();
                    lista.inserirNoFinal(elemento);
                    System.out.println("Elemento inserido no final da lista.");
                    break;
                case 2:
                    System.out.println("Quantidade de nós na lista: " + lista.getTamanho());
                    break;
                case 3:
                    System.out.println("Elementos na lista:");
                    lista.percorrer();
                    break;
                case 4:
                    lista.limpar();
                    System.out.println("Lista limpa.");
                    break;
                case 5:
                    System.out.print("Digite a posição do nó a ser pesquisado: ");
                    int posicao = scanner.nextInt();
                    No noPesquisado = lista.pesquisar(posicao);
                    if (noPesquisado != null) {
                        System.out.println("Elemento na posição " + posicao + ": " + noPesquisado.getElemento());
                    } else {
                        System.out.println("Posição inválida.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o elemento a ser inserido: ");
                    elemento = scanner.nextLine();
                    System.out.print("Digite a posição onde inserir: ");
                    posicao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    lista.inserirNaPosicao(elemento, posicao);
                    System.out.println("Elemento inserido na posição " + posicao + ".");
                    break;
                case 7:
                    lista.removerInicio();
                    System.out.println("Elemento removido do início da lista.");
                    break;
                case 8:
                    lista.removerFinal();
                    System.out.println("Elemento removido do final da lista.");
                    break;
                case 9:
                    System.out.print("Digite a posição do nó a ser removido: ");
                    posicao = scanner.nextInt();
                    lista.removerNaPosicao(posicao);
                    System.out.println("Elemento removido da posição " + posicao + ".");
                    break;
                case 10:
                    System.out.print("Digite o elemento a ser inserido ordenadamente: ");
                    elemento = scanner.nextLine();
                    lista.inserirOrdenado(elemento);
                    System.out.println("Elemento inserido ordenadamente na lista.");
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("----- Menu -----");
        System.out.println("1. Inserir nó no final");
        System.out.println("2. Quantidade de nós");
        System.out.println("3. Percorrer a lista");
        System.out.println("4. Limpar a lista");
        System.out.println("5. Pesquisar nó na posição");
        System.out.println("6. Inserir na posição");
        System.out.println("7. Remover no início");
        System.out.println("8. Remover no final");
        System.out.println("9. Remover na posição");
        System.out.println("10. Inserir ordenado");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
}

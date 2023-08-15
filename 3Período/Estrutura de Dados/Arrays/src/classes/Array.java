package src.classes;

public class Array {
    private int[] array;
    private int tamanho;

    public Array(int capacidade) {
        array = new int[capacidade];
        tamanho = 0;
    }

    public void inserirNoPrimeiroIndiceVazio(int valor) {
        if (tamanho < array.length) {
            array[tamanho] = valor;
            tamanho++;
        } else {
            System.out.println("O array está cheio, não é possível inserir mais elementos.");
        }
    }

    public void inserirNoIndice(int indice, int valor) {
        if (indice >= 0 && indice < tamanho) {
            array[indice] = valor;
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void alterarInformacao(int indice, int novoValor) {
        if (indice >= 0 && indice < tamanho) {
            array[indice] = novoValor;
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void listarInformacoes() {
        System.out.print("Array: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

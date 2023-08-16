package src.classes;

public class Pilha {
    private int[] array;
    private int tamanho;

    public Pilha(int capacidade) {
        array = new int[capacidade];
        tamanho = 0;
    }

    public void push(int valor) {
        if (tamanho < array.length) {
            array[tamanho] = valor;
            tamanho++;
        } else {
            System.out.println("A pilha está cheia! Não é possível adicionar mais elementos.");
        }
    }

    public void pop() {
        if (!isEmpty()) {
            array[tamanho - 1] = 0;
            tamanho--;
        } else {
            System.out.println("A pilha está vazia! Não é possível remover elementos.");
        }
    }

    public void imprime() {
        if (!isEmpty()) {
            System.out.print("[Topo] ");
            for (int i = tamanho - 1; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
            System.out.println("[Base]");
        }
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}

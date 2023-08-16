package src.classes;

public class Pilha {
    private int[] array;
    private int tamanho;

    public Pilha(int capacidade) {
        array = new int[capacidade];
        tamanho = 0;
    }

    public void push(int valor) {
        verificaCheia();
        array[tamanho] = valor;
        tamanho++;
    }

    public void pop() {
        verificaVazio();
        tamanho--;
        System.out.println("Valor deletado é: " + array[tamanho]);
        array[tamanho] = 0;
    }

    public void tamanho(){
        System.out.println("Tamanho da pilha: " + tamanho);
    }

    public void imprime() {
        verificaVazio();
        System.out.println("Pilha: ");
        for (int i = tamanho - 1; i >= 0; i--) {
            System.out.print("" + array[i] + " ");
        }
        System.out.println("\n");
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == array.length;
    }

    private void verificaVazio() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia! Insira valores nela!");
        }
    }

    private void verificaCheia() {
        if (isFull()) {
            System.out.println("A pilha está cheia! Não é possível adicionar mais elementos.");
        }
    }
}

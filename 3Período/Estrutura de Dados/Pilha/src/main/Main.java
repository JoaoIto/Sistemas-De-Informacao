package src.main;

import src.classes.Pilha;

public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.imprime();

        pilha.pop();
        pilha.imprime();
    }
}
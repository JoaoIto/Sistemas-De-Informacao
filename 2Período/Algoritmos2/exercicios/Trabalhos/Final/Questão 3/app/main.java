package app;

import classes.Pessoa;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Criando pessoa e testando método imprimir principal;
        Pessoa pessoa = new Pessoa(1, "Joao", "joaovictorpfr@gmail.com");
        pessoa.imprimir();
    }
}

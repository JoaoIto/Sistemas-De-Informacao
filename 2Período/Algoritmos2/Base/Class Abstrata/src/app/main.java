package src.app;

import src.classes.Pessoa;
import src.classes.PessoaFisica;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Joao");

        System.out.println(pf.getNome());
    }
}

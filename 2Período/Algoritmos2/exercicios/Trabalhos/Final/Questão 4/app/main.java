package app;

import classes.Pessoa;
import classes.PessoaFisica;
import classes.PessoaJuridica;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Criando pessoa e testando método imprimir principal;
        Pessoa pessoa = new Pessoa(1, "Joao", "joaovictorpfr@gmail.com");

        Pessoa pessoaFisica = new PessoaFisica(pessoa, "984207313", "02347982349");

        Pessoa pessoaJuridica = new PessoaJuridica(pessoa, "282394629347", "13-TO", "3692478236");
    }
}

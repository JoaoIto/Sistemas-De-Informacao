package app;

import classes.Pessoa;
import classes.PessoaFisica;
import classes.PessoaJuridica;

public class main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1, "Joao", "joaovictorpfr@gmail.com");
        PessoaFisica pessoaFisica = new PessoaFisica(pessoa, "984207313", "02347982349");
        PessoaJuridica pessoaJuridica = new PessoaJuridica(pessoa, "282394629347", "13-TO", "3692478236");

        Pessoa.imprimir(pessoa);
        Pessoa.imprimir(pessoaFisica);
        Pessoa.imprimir(pessoaJuridica);
    }
}
package src.app;

import src.classes.Pessoa;
import src.classes.Sexo;
import src.classes.Telefone;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Telefone telefone = new Telefone("55", "123456789");
        Pessoa pessoa = new Pessoa("João", 25, telefone, Sexo.MASCULINO);

        telefone.imprimir();
        pessoa.imprimir();
    }
}


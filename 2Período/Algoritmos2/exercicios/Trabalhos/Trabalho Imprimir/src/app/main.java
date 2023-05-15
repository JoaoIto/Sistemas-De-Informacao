package src.app;

import src.classes.Pessoa;
import src.classes.Telefone;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Telefone telefone = new Telefone("55", "123456789");
        Pessoa pessoa = new Pessoa("João", 25, telefone, Sexo.MASCULINO);

        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Telefone: +" + pessoa.getTelefone().getCodigoArea() + " " + pessoa.getTelefone().getNumero());
        System.out.println("Sexo: " + pessoa.getSexo());
    }
}


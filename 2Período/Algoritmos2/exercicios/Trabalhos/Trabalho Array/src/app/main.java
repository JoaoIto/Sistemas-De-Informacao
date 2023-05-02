package src.app;

import src.classes.Pessoa;
import src.classes.Sexo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello World!");
        System.out.println("Lista");
        List list = new ArrayList<Pessoa>(3);

        System.out.println("Deseja cadastrar pessoas? Digite 1: ");
        int escolha = scan.nextInt();

        switch (escolha) {

            case 1:
                System.out.println("Cadastrando!");
               Pessoa pessoa = new Pessoa();
               pessoa.Cadastrar();
            case 2:
                System.out.println("Encerrado!");
        }
    }
}

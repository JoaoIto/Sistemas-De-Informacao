package src.app;

import src.classes.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner scApp = new Scanner(System.in);
        List<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lista.add(new Pessoa(scApp));
        }
        System.out.println("Incluindo pessoas do sexo masculino: ");
        Pessoa.imprimirTudo(lista);
        System.out.println("Removendo pessoas do sexo masculino: ");
        Pessoa.removerMasculino(lista);
        Pessoa.imprimirTudo(lista);
    }
}

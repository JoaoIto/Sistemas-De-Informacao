package src.app;

import src.classes.Telefone;
import src.enums.Cor;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Telefone iphone = new Telefone();
        iphone.setModelo("Iphone12");
        iphone.setColors(Cor.AZUL);

        for (Cor cor: Cor.values()) {
            System.out.println(cor.toString());
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Selecione as cores: ");
        for (Cor cor: Cor.values()) {
            System.out.println(cor.toString());
        }

        int idColor = scan.nextInt();
    }
}

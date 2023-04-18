package src.app;

import src.classes.Telefone;
import src.enums.Cor;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Telefone iphone = new Telefone();
        iphone.setModelo("Iphone12");
        iphone.setColors(Cor.AZUL);

        for (Cor cor: Cor.values()) {
            System.out.println(cor.toString());
        }
    }
}

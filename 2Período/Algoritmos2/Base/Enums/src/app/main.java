package src.app;

import src.enums.Cor;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        for (Cor cor: Cor.values()) {
            System.out.println(cor.ordinal() + " - " + cor.name());
        }
    }
}

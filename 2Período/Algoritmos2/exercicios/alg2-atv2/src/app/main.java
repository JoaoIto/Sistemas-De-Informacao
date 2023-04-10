package src.app;

import src.classes.Carro;
import src.classes.Veiculo;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Corrida de veículos!");
        System.out.println("Bem Vindo a corrida!");

        Veiculo veiculo1 = new Veiculo("Gol 1.0", "Wolks", 2012, 200, 1200.0);
        Veiculo veiculo2 = new Veiculo("Fiat", "Uno 1.2", 2006, 250, 1600.0);
        Veiculo veiculo3 = new Veiculo("Ferrari", "458 3.0 V8", 2016, 600, 900.0);

        Carro gol = new Carro(veiculo1);
        Carro unoEscada = new Carro(veiculo2);
        Carro ferrari = new Carro(veiculo3);

        gol.imprimir();
        System.out.println("");
        unoEscada.imprimir();
        System.out.println("");
        ferrari.imprimir();
        System.out.println("");

        for(int i = 1; i < 20; i++) {
            System.out.println("TACA-LE PAU NESSE CARINHO!");
            System.out.println(i);
            gol.acelerar();
            unoEscada.acelerar();
            ferrari.acelerar();
            if(i == 6 || i == 11 || i == 15) {
                System.out.println("VAI BATEEERRR");
                gol.frear();
                unoEscada.frear();
                ferrari.frear();
            }
        }

        gol.imprimir();
        System.out.println("");
        unoEscada.imprimir();
        System.out.println("");
        ferrari.imprimir();
        System.out.println("");
    }
    }

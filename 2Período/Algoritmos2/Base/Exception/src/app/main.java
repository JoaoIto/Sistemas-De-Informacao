package src.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import src.classes.Carro;
public class main {
    public static void main(String[] args) {

        Carro carro1 = new Carro();
        Carro carro2 = new Carro();
        Carro carro3 = new Carro();
        Carro carro4 = new Carro();
        Carro carro5 = new Carro();
        Carro.lerDados(5);

        Carro[] listCarros = new Carro[4];

        listCarros[0] = carro1;
        listCarros[1] = carro2;
        listCarros[2] = carro3;
        listCarros[3] = carro4;
        listCarros[4] = carro5;

        Carro carros = new Carro();
        carros.imprimir(listCarros);
    }
}
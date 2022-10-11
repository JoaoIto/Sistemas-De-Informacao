// Questão 4

/* 4 - Escreva um algoritmos que, dadas a distância entre duas cidades,
o consumo médio de combustível e o preço da gasolina,
calcule quanto se gasta para ir de uma cidade à outra.
*/

import java.util.Scanner;

public class Qt4 {
    public static void main(String[] args){
    Scanner leitor = new Scanner(System.in);

    int distancia;
    double consumo, preco, gasto;

    System.out.println("Escreva a distância entre duas cidades em km:");
    distancia =leitor.nextInt();

    System.out.println("Escreva o consumo médio de combustível:");
    consumo =leitor.nextDouble();

    System.out.println("Escreva o preco do combustível:");
    preco =leitor.nextDouble();

    gasto =distancia *(consumo *preco);

    System.out.println("O gasto de se ir de uma cidade a outra é de: "+gasto);
}
}

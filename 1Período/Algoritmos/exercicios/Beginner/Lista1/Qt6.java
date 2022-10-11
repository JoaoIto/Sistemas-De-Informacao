// Questão 6

/* 6 - Escreva um programa que permita ao usuário
calcular o total gasto com carne para um churrasco,
sabendo que deve ter 200g para cada crianças e 400g
para cada adulto presentes.
Também deve ser considerado que haverá apenas
um tipo de carne com valor definido pelo usuário.
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Qt6 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        DecimalFormat deci = new DecimalFormat("0.00");

        double preco, gasto, valorCriancas, valorAdultos;
        int qtdCriancas, qtdAdultos;

        System.out.println("Qual a quantidade de crianças no churras?");
        qtdCriancas = leitor.nextInt();

        System.out.println("Qual a quantidade de adultos no churras?");
        qtdAdultos = leitor.nextInt();

        System.out.println("Qual o preço da carne:");
        preco = leitor.nextDouble();

        valorCriancas = qtdCriancas * 0.2;
        valorAdultos = qtdAdultos * 0.4;

        gasto = (valorAdultos + valorCriancas) * preco;

        System.out.println("O total gasto no churras é de: R$" + deci.format(gasto));
    }
}

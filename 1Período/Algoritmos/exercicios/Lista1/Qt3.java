// Questão 3

/* 3 - Sabendo que um boleto tem cobrança de juros de 1% por dia de atraso,
escreva um algoritmo que solicite o valor do boleto, a quantidade de dias de atraso
e calcule o valor final do boleto. */

import java.util.Scanner;

public class Qt3 {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        double boleto, taxa, juros = 0.1;
        int atraso;

        System.out.println("Escreva o valor do boleto:");
        boleto = leitor.nextDouble();

        System.out.println("Escreva quantos dias de atraso:");
        atraso = leitor.nextInt();

        taxa = atraso * juros;
        boleto = boleto + taxa;

        System.out.println("O valor final do boleto é de: " + boleto);
    }
}
// Questão 2

/*2 - - Escreva um algoritmo que solicite ao usuário que informe:
a temeratura máxima e mínima em um dia e,
informe a variação de temperatura desse dia.
*/

import java.util.Scanner;

public class Qt2 {
    public static void Qt2(String[] args) {
        Scanner leitor = new Scanner(System.in);

        double tempMin, tempMax, variacao;

        System.out.println("Informe a temperatura mínima de hoje:");
        tempMin = leitor.nextDouble();

        System.out.println("Informe a temperatura máxima de hoje:");
        tempMax = leitor.nextDouble();

        variacao = tempMax - tempMin;

        System.out.println("A variação de temperatura de hoje é de: " + variacao + " graus!");
    }
}

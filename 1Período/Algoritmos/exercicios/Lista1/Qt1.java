// Questão 1:

/*1 - Escreva um algoritmo para ler duas notas de um aluno.
Sabendo que a nota 1 tem peso 4 e a nota 2 tem peso 6,
o algoritmo deve calcular e apresentar a média final do aluno (média ponderada).
*/

import java.util.Scanner;
public class Qt1 {

    public static void Qt1(String[] args) {
        Scanner leitor = new Scanner(System.in);
        double nota1, nota2, media;
        System.out.println("Informe a nota 1:");
        nota1 = leitor.nextDouble();

        System.out.println("Informe a nota 2:");
        nota2 = leitor.nextDouble();

        media = ((nota1 * 4) + (nota2 * 6)) / 2;

        System.out.println("A sua média ponderada é de:" + media);

    }
}
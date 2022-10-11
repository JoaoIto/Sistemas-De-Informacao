// Questão 7

/* 7 - Escreva um programa que solicite do usuário
as duas notas de um aluno e o valor da média para ser aprovado.
O programa deve calcular a média das duas notas e informar
se o aluno está aprovado ou reprovado.
*/

import java.util.Scanner;

public class Qt7 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        double nota1, nota2, media;

        System.out.println("Informe a primeira nota do aluno:");
        nota1 = leitor.nextDouble();

        System.out.println("Informe a segunda nota do aluno:");
        nota2 = leitor.nextDouble();

        media = (nota1 + nota2) / 2;

        if(media < 6){
            System.out.println("O aluno está reprovado!");
        }else {
            System.out.println("O aluno está aprovado!");
        }
    }
}

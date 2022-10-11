// Questão 9

/* 9 - Escreva um algoritmo que solicite do usuário as dimensões de um terreno (frente e lateral) e
informe se é ideal construir uma casa mais larga (frente maior que lateral)  ou
mais comprida (lateral maior que a frente)
 */

import java.util.Scanner;

public class Qt9 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        double frente, lateral;

        System.out.println("Informe a dimensão da lateral do terreno:");
        lateral = leitor.nextDouble();

        System.out.println("Informe a dimensão da frente do terreno:");
        frente = leitor.nextDouble();

        if(frente > lateral){
            System.out.println("É melhor ser construída uma casa mais larga!");
        }else {
            System.out.println("É melhor ser construída uma casa mais comprida!");
        }
    }
}

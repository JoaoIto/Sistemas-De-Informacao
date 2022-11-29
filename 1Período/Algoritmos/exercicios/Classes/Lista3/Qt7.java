/* 07 - Escreva um programa que contenha uma função 
que receba um número inteiro como parâmetro e retorne o fatorial desse número. 
*/

import java.util.*;
public class Qt7 {

    public static int fatorial(int number) {
        int fatorial = 1;

        for (int i = 1; i < 11; i++) {
            fatorial *= i;
        }

        return fatorial;
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int number;

        System.out.println("Insira um número para receber fatorial");
        number = leitor.nextInt();

        System.out.println("O fatorial deste número é: " + fatorial(number));
    }
}

/* *02 - Escreva um programa que preencha um array de 100 posições automaticamente
com valores aleatórios. O usuário deverá digitar um número e o programa deverá apresentar
a quantidade de valores do array que são menores, maiores e iguais ao número digitado pelo usuário*
*/

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.util.Random;

public class Qt2 {
    public static void main (String args[]){
        Scanner leitor = new Scanner(System.in);

        int[] arr;
        arr = new int[100];
        Random  numeros = new Random();
        int numero, maior = 0, menor = 0, igual= 0;

        for(int i = 0; i < arr.length; i++) {
            arr[i] = numeros.nextInt(100);
        }
        System.out.println("Informe o seu número: ");
        numero = leitor.nextInt();

        for(int i = 0; i < arr.length; i++) {
            System.out.println("[" + arr[i] + "]");
            if (arr[i] < numero) {
                menor++;
            } else if (arr[i] > numero) {
                maior++;
            } else {
                igual++;
            }
        }
        System.out.println("Os números maiores que o seu são: " + maior);
        System.out.println("Os números menores que o seu são: " + menor);
        System.out.println("Os números iguais que o seu são: " + igual);
    }
}
/*
* *03 - Escreva um programa que permita ao usuário preencher dois vetores de 5 posições
e preencha automaticamente um terceiro vetor contendo a soma das posições correspondentes
dos vetores preenchidos pelo usuário*
*/

import java.util.Scanner;
public class Qt3 {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        int[] arr1, arr2, arr3;
        arr1 = new int[5];
        arr2 = new int[5];
        arr3 = new int[5];

        for(int i = 0; i <arr1.length; i++){
            System.out.println("Insira o número do primeiro array: ");
            arr1[i] = leitor.nextInt();
        }
        for(int i = 0; i <arr2.length; i++){
            System.out.println("Insira o número do segundo array: ");
            arr2[i] = leitor.nextInt();
        }

        for(int i = 0; i < arr3.length; i++){
            arr3[i] = arr1[i] + arr2[i];
            System.out.println("O seu array 3 é: " + arr3[i]);
        }
    }
}

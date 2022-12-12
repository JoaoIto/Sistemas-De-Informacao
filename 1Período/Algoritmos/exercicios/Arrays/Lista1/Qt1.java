/* *01 - Escreva um programa que permita ao usuário
preencher um array de 10 inteiros e ao final apresente
o dobro de cada valor contido no array*
*/

import java.util.Scanner;
public class Qt1 {
    public static void main (String[] args){
        Scanner leitor = new Scanner(System.in);
        int[] arr;
        arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Defina um valor: ");
            arr[i] = leitor.nextInt();
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println("Os valores do array são: "+ arr[i]*2);
        }
    }
}

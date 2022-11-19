/*

Escreva um programa que contenha:

=>uma função que retorne a soma dos valores contidos em um array preenchido pelo usuário.
=>uma função que retorne a media dos valores contidos no array
=>uma função que retorne a quantidade de valores pares no array
=> Uma função que retorne a quantidade de valores acima da média no array (a média do próprio array)
=> uma função que reduza em 50% cada valor contido no array

 */

import java.util.*;

public class Main {

    static void item1(int[] numbers){
        int rest = 0;
        for (int number : numbers) {
            rest += number;
        }

        System.out.print("\nSoma dos arrays: "+rest);

    }

    static int item2(int[] numbers){
        int rest = 0;

        for (int number : numbers) {
            rest += number;
        }

        rest = rest/numbers.length;
        System.out.print("\nA média é: "+rest);
        return rest;
    }

    static void item3(int[] numbers){
        int count = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }

        System.out.print("\nNúmeros pares são: "+count);
    }

    static void item4(int[] numbers){
        int media, counter = 0;

        media = item2(numbers);
        
        for(int number : numbers){
            if(number > media){
                counter++;
            }
        }
        System.out.print("\nNúmeros acima da média são: "+counter);
    }

    static void item5(int[] numbers){
        for(int i=0; i<numbers.length; i++){
            numbers[i] = numbers[i]/2;
        }

        System.out.print("\nNúmeros 50%: \n");
        for(int number : numbers){
            System.out.print(number + "\t");
        }
    }

    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        int[] arr = new int[4];

        System.out.print("Digite 4 valores: \n");

        for(int i=0; i<arr.length; i++){
            arr[i] = leitor.nextInt();
        }
        item1(arr);
        item2(arr);
        item3(arr);
        item4(arr);
        item5(arr);
    }
}


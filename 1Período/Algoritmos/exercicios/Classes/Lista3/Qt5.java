/* 05 - Escreva um programa que contenha uma função 
com os parâmetros base e expoente. 
A função deve retornar a potência correspondente. 
*/

import java.util.*;
public class Qt5 {

    public static int potencia(int base, int expoente){
        int potencia = 1;

        for(int i = expoente; i >= 1; i--){
            potencia *= base;
        }
        
        return potencia;
    }
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int base, expoente;


        System.out.println("Defina a base do número: ");
        base = leitor.nextInt();

        System.out.println("Defina o expoente do número: ");
        expoente = leitor.nextInt();

        int potencia = potencia(base, expoente);

        System.out.println("A potência desse número é: "+ potencia);
    }
}

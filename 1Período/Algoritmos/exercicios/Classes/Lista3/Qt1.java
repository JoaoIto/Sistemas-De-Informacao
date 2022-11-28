/* 01 - Escreva um programa que solicite do usuário dois valores numéricos. 
O programa deve conter uma função para 
calcular e retornar a média aritmética dos valores informados. 
*/

 import java.util.Scanner;
 import java.util.Random;

 public class Qt1
 {
    public static int media(int x, int y){
        return (x + y) / 2;
    }
    public static void main(String[] args){
         Scanner leitor = new Scanner(System.in);
 
         int x, y;

         System.out.println("Indique o primeiro valor: ");
         x = leitor.nextInt();

         System.out.println("Indique o segundo valor: ");
         y = leitor.nextInt();

         System.out.println("A média aritmética dos valores é: " + media(x, y));
     }
 }
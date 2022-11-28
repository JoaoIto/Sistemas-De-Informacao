/* 02 - Escreva um programa que solicite do usuário 
os valores dos lados de um retângulo. 
O programa deve conter funções diferentes para 
calcular a área e o perímetro do retângulo em questão. 
*/

import java.util.*;

public class Qt2{

    public static double area(double base, double altura){
        return (base * altura) / 2;
    }

    public static double perimetro(double lado1, double lado2, double lado3) {
        return lado1 + lado2 + lado3;
    }
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        double base, altura, lado1, lado2, lado3;

        System.out.println("Vamos definir a área e perímetro de um triângulo!");

        System.out.println("Primeiramente vamos definir a área!");
        

        System.out.println("Defina a base do triângulo:");
        base = leitor.nextDouble();

        System.out.println("Defina a altura do triângulo:");
        altura = leitor.nextDouble();

        System.out.println("O area do triãngulo é: " + area(base, altura));

        
        System.out.println("Vamos definir o perímetro!");

        System.out.println("Defina o lado 1 do triângulo: ");
        lado1 = leitor.nextDouble();

        System.out.println("Defina o lado 2 do triângulo: ");
        lado2 = leitor.nextDouble();

        System.out.println("Defina o lado 3 do triângulo: ");
        lado3 = leitor.nextDouble();

        System.out.println("O perímetro do triângulo é: " + perimetro(lado1, lado2, lado3));
    }
}
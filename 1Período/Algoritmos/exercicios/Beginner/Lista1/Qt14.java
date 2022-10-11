// Questão 14

/* 14 - Escreva um programa que auxilie no cálculo da dose de um remédio
para um determinado paciente.  Caso o paciente seja jovem (até 18 anos)
a dose deve ser de 1 gota para cada 2 Kg.
Caso o paciente seja adulto (até 55 anos) deve ser de uma gota para cada 3 Kg.
Em qualquer caso, a dose não pode ultrapassar 50 gotas.
*/

import java.util.Scanner;

public class Qt14 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        double peso, gotas = 0;
        int idade;

        System.out.println("Informe a idade da pessoa que tomará a dose:");
        idade = leitor.nextInt();

        System.out.println("Informe o peso da pessoa:");
        peso = leitor.nextDouble();

        if(idade <= 18){
            gotas = peso / 2;
            System.out.println("Sua dose é de: " + gotas);
        }else if(idade <= 55){
            gotas = peso / 3;
            System.out.println("Sua dose é de: " + gotas);
        }if (gotas >= 50){
            System.out.println("Você não pode tomar esse remédio!");
        }
        }
}

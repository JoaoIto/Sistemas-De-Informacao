/* 03 - Escreva um programa que solicite do usuário 
o peso e a altura de uma pessoa. 
O programa deve conter uma função que calcule o IMC 
e indique se a pessoa está magra (abaixo de 20), 
com peso dentro dos padrões saudáveis (entre 20 e 25) 
ou acima do peso (acima de 25). 
*/

import java.util.*;

public class Qt3 {

    public static double imc(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String classifica(double imc){
        if (imc < 20)
        return "Você está com IMC magro!";

        else if (imc > 20 && imc < 25)
        return "Você tem um IMC ideal!";

        else 
        return "Você tem o IMC alto!";
    }
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        double peso, altura, imc = 0;

        System.out.println("Insira o seu peso: ");
        peso = leitor.nextDouble();

        System.out.println("Insira sua altura: ");
        altura = leitor.nextDouble();

        imc = imc(peso, altura);
        System.out.println("Seu IMC é de: " + imc);
        System.out.println("A sua classificação é: " + classifica(imc));
    }
}

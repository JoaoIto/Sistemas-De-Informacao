// Questão 13

/* 13 - Escreva um programa que solicite do usuário o valor do salário bruto e
a quantidade de dependentes de um funcionário.
Para cada dependente o funcionário receberá um acréscimo de R$ 200,00.
E sabendo que o valor do imposto de renda segue a seguinte tabela:

Salário até R$ 1.500,00 - imposto de 10%
Salário até R$ 3.500,00 - imposto de 12,5%
Salário até R$ 5.500,00 - imposto de 15%
Salário acima de R$ 5.500,00 - imposto de 20%

Observação: O imposto é aplicado somente sobre o salário. A contribuição por dependente não é tributada.
O programa deve calcular o salário líquido do funcionário.
*/

import java.util.Scanner;

public class Qt13 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        double salarioBruto, salarioLiquido;
        int dependentes;

        System.out.println("Informe o salário bruto:");
        salarioBruto = leitor.nextDouble();

        System.out.println("Informe a quantidade de dependentes:");
        dependentes = leitor.nextInt();

        if(salarioBruto <= 1500){
            salarioLiquido = salarioBruto-(salarioBruto*0.10) + (dependentes * 200);
        }else if (salarioBruto <= 3500){
            salarioLiquido = salarioBruto-(salarioBruto*0.125) + (dependentes * 200);
        }else if (salarioBruto <=5500){
            salarioLiquido = salarioBruto-(salarioBruto*0.15) + (dependentes * 200);
        }else{
            salarioLiquido = salarioBruto-(salarioBruto*0.2) + (dependentes * 200);
        }

        System.out.println("O salário líquido com seus dependentes é de: " + salarioLiquido);
    }
}

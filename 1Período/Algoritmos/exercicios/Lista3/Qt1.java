/* 01 - Escreva um programa em Java que permita ao usuário 
informar dois valores numéricos e executar uma das operações básicas 
da matemática sobre os valores digitados. 
Para escolher a operação o usuário deve usar os caracteres: 
'+', '-', '*', '/'. 
*/

import java.util.Scanner;

public class Qt1 {
    public static void Qt1(String[] args){
        Scanner leitor = new Scanner(System.in);

        String = Result = "";
        int x = 0, y = 0, result = 0;
        char operacao;

        System.out.println("Digite o primeiro número:");
        x = leitor.nextInt();
        System.out.println("Digite o segundo número:");
        y = leitor.nextInt();

        System.out.println("Informe a operação a ser feita:");
        operacao = next().charAt(0);
        if(operacao == "+"){
            result = x + y;
            Result = "Soma entre numbers: x + y";
        }else if (operacao == "-"){
            result x - y;
            Result = "Subtração entre numbers: x - y";
        }else if (operacao == "*"){
            result x * y;
            Result = "Multiplicação entre numbers: x * y";
        }else {
            result = x / y;
            Result = "Divisão entre numbers: x / y";
        }

        leitor.close();
    }
}

/* 01 - Escreva um programa em Java que permita ao usuário 
informar dois valores numéricos e executar uma das operações básicas 
da matemática sobre os valores digitados. 
Para escolher a operação o usuário deve usar os caracteres: 
'+', '-', '*', '/'. 
*/

import java.util.Scanner;

public class Qt1 {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        int x, y, resultado;
        char operacao;
        String Resultado;

        x = 0;
        y = 0;
        resultado = 0;
        Resultado = "";

        System.out.println("Digite o primeiro numero: ");
        x = leitor.nextInt();
        System.out.println("Digite o segundo numero: ");
        y = leitor.nextInt();

        System.out.println("Digite a operacao desejada: ");
        operacao = leitor.next().charAt(0);

        if (operacao == '+'){
            resultado = x + y;
            Resultado = "Soma";
        }
        else if (operacao == '-'){
            resultado = x - y;
            Resultado = "Subtracao";
        }
        else if (operacao == '*'){
            resultado = x * y;
            Resultado = "Multiplicacao";
        }
        else{
            resultado = x / y;
            Resultado = "Divisao";
        }

        System.out.println("A operacao utilizada foi: " + Resultado + " e o resultado é: " + resultado);
		
		leitor.close();
    }
}

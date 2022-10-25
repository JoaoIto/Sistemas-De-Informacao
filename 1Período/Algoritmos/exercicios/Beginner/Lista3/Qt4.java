/* 4- Escreva um programa que solicite do usuário 
dois valores inteiros positivos. 
O programa deve informar a quantidade de valores múltiplos de 3 
contidos no intervalo (incluindo os limites). 
Caso os valores digitados não se enquadrem no critério informado 
(inteiros positivos), uma mensagem deve ser enviada ao usuário 
informando o fato. 
*/

import java.util.Scanner;
public class Qt4 {
    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);
        
        int i = 0, valorInicial, valorFinal;

        System.out.println("Informe o valor inicial a ser colocado: ");
        valorInicial = leitor.nextInt();

        System.out.println("Informe o valor final a ser colocado: ");
        valorFinal = leitor.nextInt();

        for(i = valorInicial; i < valorFinal; i++){
            if(i % 3 == 0){
                System.out.println(i);
            }
            
        }
        if(i % 3 == 1){
            System.out.println("Não existem mais múltiplos de 3!");
        }
    }
}

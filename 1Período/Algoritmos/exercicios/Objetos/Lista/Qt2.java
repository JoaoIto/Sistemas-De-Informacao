/* 02 - Escreva um programa que contenha um registro 
com 4 valores inteiros correspondentes aos octetos de um endereço IP V4. 
O programa deve permitir ao usuário preencher os campos do registro 
e informar se o endereço IP digitado é válido ou não. */

import java.util.Scanner;
import java.util.Random;

class endereco {
    int campo1, campo2, campo3, campo4;
    int ipv4;
}

public class Qt2
{
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        endereco ipv4;
        ipv4 = new endereco();

        System.out.println("Informe o primeiro módulo: ");
        ipv4.campo1 = leitor.nextInt();

        while(ipv4.campo1 < 0 && ipv4.campo1 > 255)

           do System.out.println("Campo Inválido")
        
        System.out.println("Informe o segundo módulo: ");
        ipv4.campo2 = leitor.nextInt();

        System.out.println("Informe o terceiro módulo: ");
        ipv4.campo3 = leitor.nextInt();

        System.out.println("Informe o quarto módulo: ");
        ipv4.campo4 = leitor.nextInt();
    }
}
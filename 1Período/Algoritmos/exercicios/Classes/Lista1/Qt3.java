/* 03 - Escreva um programa que contenha um 
array de registros com os campos 
nome do produto, valor de compra, valor de venda. 
O programa deve permitir ao usuário escolher 
a quantidade de produtos que irá manipular, 
preencher o array com as informações pertinentes 
e ao final apresentar um relatório apresentando 
os produtos acompanhados do lucro unitário de cada um deles. 
*/

import java.util.Scanner;

class loja{
    String produto;
    double compra, venda;
}

public class Qt3 {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        int produtoQuant;

        loja[] conta;

        System.out.println("Informe a quantidade do produto: ");
        produtoQuant = leitor.nextInt();

        conta = new loja[produtoQuant];

        for(int i = 0; i < produtoQuant; i++){
            conta[i] = new loja();
        }

        for(int i = 0; i<produtoQuant; i++){
            System.out.println("Nome do produto: ");
            conta[i].produto = leitor.next();
            System.out.println("Valor da compra: ");
            conta[i].compra = leitor.nextDouble();
            System.out.println("Valor da venda: ");
            conta[i].venda = leitor.nextDouble();
        }

        for(int i = 0; i < produtoQuant; i++){
            System.out.println(conta[i].produto+"\t");
            System.out.println(conta[i].compra+"\t");
            System.out.println(conta[i].venda + "\t");
        }
    }
}
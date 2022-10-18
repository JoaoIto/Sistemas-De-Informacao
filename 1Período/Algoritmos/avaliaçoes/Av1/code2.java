/* Escreva um programa que permita ao usuário informar 
o nome, sobrenome e a idade de diversas pessoas, 
encerrando quando o usuário quiser. 

O programa deve apresentar ao final:

- a quantidade de pessoas
- a idade da pessoa mais velha
- a diferença de idade entre a pessoa mais velha e a mais nova
- a quantidade de pessoas maiores de idade */

import java.util.Scanner;
public class code2 {
    public static void code2(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String nome = "", sobrenome, senha = "sair";
        int idade, pessoaVelha = 0, pessoaNova = 0, count;
        while(senha != "sair"){
            System.out.println("Quer continuar?");
            senha = leitor.next();

            for(count = 0; nome != "sair"; count++)
            System.out.println("Digite o nome da pessoa: ");
            nome = leitor.nextLine();

            System.out.println("Digite o sobrenome da pessoa: ");
            sobrenome = leitor.nextLine();

            System.out.println("Digite a idade da pessoa: ");
            idade = leitor.nextInt();

            if(idade > pessoaNova){
                pessoaVelha = idade;
            }else {
                pessoaNova = idade;
            };
        };
        System.out.println("A pessoa mais velha é: " + pessoaVelha);
        System.out.println("A pessoa mais nova é: " + pessoaNova);
        System.out.println("A diferença de idade é: " + (pessoaVelha - pessoaNova));
    };
};

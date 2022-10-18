/* Escreva um programa em Java que solicite do usuário 
os nomes e a quantidade de gols marcados pelos 
times participantes de um jogo de futebol. 
O programa deve informar qual foi o time vencedor 
ou se houve empate */

import java.util.Scanner;
public class code1 {
    public static void code1(String args[]) {
        Scanner leitor = new Scanner(System.in);

        String time1, time2;
        int gols1, gols2;

        System.out.println("Informe o time 1: ");
        time1 = leitor.next();

        System.out.println("Informe o time 2: ");
        time2 = leitor.next();

        System.out.println("Informe a quantidade de gols time1: ");
        gols1 = leitor.nextInt();

        System.out.println("Informe a quantidade de gols time2: ");
        gols2 = leitor.nextInt();

        if(gols1 > gols2){
            System.out.println("Time 1 vencedor!");
        }else if (gols2 > gols1){
            System.out.println("Time 2 vencedor!");
        }else {
            System.out.println("Empate entre os times!");
        };
    };
};

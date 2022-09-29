// Questão 8

/* 8 - Escreva um algoritmo que solicite do usuário
os nomes de dois times de uma partida de futebol e
a quantidade de gols marcado por cada um.
O algoritmo deve informar se houve um vencedor (e qual o vencedor) ou
se houve empate.
Além disso, deve mostrar o saldo de gols do time que venceu o jogo.
*/

import java.util.Locale;
import java.util.Scanner;

public class Qt8 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        int ponto1, ponto2;
        String time1, time2;

        System.out.println("Informe o time1:");
        time1 = leitor.nextLine();

        System.out.println("Informe o time2:");
        time2 = leitor.nextLine();

        System.out.printf("Quando gols %s fez ? %n", time1);
        ponto1 = leitor.nextInt();

        System.out.printf("Quando gols %s fez ? %n", time2);
        ponto2 = leitor.nextInt();

        if(ponto1 > ponto2){
            System.out.printf("%s ganhou %d x %d %n", time1, ponto1, ponto2);
        }else if(ponto1 == ponto2){
            System.out.printf("O jogo terminou entre empate de %d x %d %n", ponto1, ponto2);
        }else {
            System.out.printf("%s ganhou por %d x %d %n", time2, ponto2, ponto1);
        }
    }
}

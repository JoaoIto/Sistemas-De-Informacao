// Questão 12

/* 12 - Sabendo que em um campeonato de futebol
cada time ganha 3 pontos por vitória e um ponto por empate,
escreva um programa que solicite do usuário a quantidade de vitórias e
empates de dois times e
informe qual deles estará mais bem classificado no campeonato.
*/
import java.util.Scanner;

public class Qt12 {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int time1, time2, vitorias, empates, resultado;

        System.out.println("Digite a quantidade de vitorias do time 1 ");
        time1 = leitor.nextInt();
        System.out.println("Digite a quantidade de empates do time 1");
        time1 = leitor.nextInt();

        System.out.println("Digite a quantidafe de vitorias do time 2");
        time2 = leitor.nextInt();
        System.out.println("Digite a quantidade de empates do time 2");
        time2 = leitor.nextInt();

        if (time1 > time2){
            System.out.println(" time 1 venceu por " + time1  * time2);
        } else if (time1 == time2){
            System.out.println("O jogo de empate de " + time1 * time2 );
        } else {
            System.out.println("O resultado e: ");

        }


    }
}

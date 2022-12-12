/* 06 - Escreva um programa que permita ao usuário informar 
a média necessária para aprovação e o peso das notas A1 e A2. 
Além disso, deve permitir ao usuário informar as notas A1 e A2 
para diversos alunos e informar, para cada aluno se estão 
aprovados ou reprovados 
(implementar essa funcionalidade de informar se estão aprovados ou reprovados 
usando uma ou mais funções). 
*/

import java.util.*;

public class Qt6 {

    public static Double media(double A1, int P1, double A2, int P2) {
        double ponderada;
        ponderada = ((A1 * P1) + (A2 * P2)) / (P1 + P2);
        return ponderada;
    }

    public static String status(double result, double pass) {
        String status;

        if (result >= pass) {
            status = "Com parâmetro " + pass + " e nota " + result + ", aluno foi aprovado.";
        } else {
            status = "Com parâmetro " + pass + " e nota " + result + ", aluno foi reprovado.";
        }
        return status;
    }

    public static void main(String[] args) {
        double resultado, n1, n2;
        int p1, p2, passar, escolha;
        String passou;

        Scanner leia = new Scanner(System.in);

        do {
            System.out.print("Escreva a nota da A1 e respectivo peso.\nAperte ENTER após digitar o primeiro.\n");
            n1 = leia.nextDouble();
            p1 = leia.nextInt();

            System.out.print("Escreva a nota da A2 e respectivo peso.\nAperte ENTER após digitar o primeiro.\n");
            n2 = leia.nextDouble();
            p2 = leia.nextInt();

            System.out.print("Escreva a média necessária para passar.\n");
            passar = leia.nextInt();

            resultado = media(n1, p1, n2, p2);
            passou = status(resultado, passar);

            System.out.print(passou + "\n");

            System.out.print("Deseja continuar a execução? Digite '1' para sim e qualquer outro para não.\n");
            escolha = leia.nextInt();

        } while (escolha == 1);
        System.out.print("Programa encerrado.");
        leia.close();
    }
}

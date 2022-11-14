/*
Escreva um programa que contenha um registro para armazenar as notas A1 e A2 de um aluno.
Implemente funções para:

=>retornar a média do aluno,
=>informar se o aluno foi aprovado ou reprovado (a média para passar deve ser informada pelo usuário)
=>substituir a nota de A1 ou A2 pela nota da recuperação (o aluno pode escolher qual nota vai substituir)
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        double nota1, nota2, necessario, media;
        String index;
        int choose;

        System.out.print("Escreva as notas da A1 e da A2 de um aluno.\n");
        nota1 = leitor.nextDouble();
        nota2 = leitor.nextDouble();

        System.out.print("Qual a média para aprovação.\n");
        necessario = leitor.nextDouble();

        media = media(nota1, nota2);
        index = index(media, necessario);

        if (index.equals("Recuperacao")) {
            System.out.print(
                    "\nQual nota você deseja substituir?\nDigite 1 para substituir a A1.\nDigite 2 para substituir a A2.\n");
            choose = leitor.nextInt();
            if (choose == 1) {
                System.out.print("Digite o novo valor da sua A1.\n");
                nota1 = leitor.nextDouble();
            } else if (choose == 2) {
                System.out.print("Digite o novo valor da sua A2.\n");
                nota2 = leitor.nextDouble();
            }
            media = media(nota1, nota2);
            recuperacao(media, necessario);

        }
    }

    static double media(double n1, double n2) {
        double media;
        media = (n1 + n2) / 2;
        return media;
    }

    static String index(double media, double nec) {
        String index;

        if (media >= nec) {
            System.out.print("\nAluno aprovado!");
            index = "Aprovado";

        } else {
            System.out.print("\nAluno em recuperação!");
            index = "Recuperacao";
        }

        return index;
    }

    static void recuperacao(double media, double nec) {
        if (media >= nec) {
            System.out.print("\nAluno aprovado!");
        } else {
            System.out.print("\nAluno reprovado!");
        }
    }

}

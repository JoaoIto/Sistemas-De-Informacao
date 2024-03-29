/* Desenvolver um programa para a resolução de uma tabela verdade
com entrada de duas proprosições, sendo (p e q), utilizados para
formar uma proposições ou expressão, sendo possível atribuir os valores
entre V ou F, e assim trabalhando os conectivos das operações, sendo ainda
no final que deve ser informada a saída dos valores e conectivos dados
na entrada.
*/

package src.app;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Construção da tabela verdade: ");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de P (V ou F): ");
        String p = scanner.nextLine();

        System.out.print("P está negado? (S ou N): ");
        String negP = scanner.nextLine();
        boolean negacaoP = negP.equalsIgnoreCase("S");
        boolean pv = p.equalsIgnoreCase("V") ^ negacaoP;

        System.out.print("Digite o valor de Q (V ou F): ");
        String q = scanner.nextLine();

        System.out.print("Q está negado? (S ou N): ");
        String negQ = scanner.nextLine();
        boolean negacaoQ = negQ.equalsIgnoreCase("S");
        boolean qv = q.equalsIgnoreCase("V") ^ negacaoQ;

        System.out.println("P\tQ\tAND\tOR\tXOR\tSE-SOMENTE-SE\tCONDICIONAL");
        System.out.println("--------------------------------------------------------------");

        System.out.print(p + (negacaoP ? "'" : "") + "\t" + q + (negacaoQ ? "'" : "") + "\t");
        System.out.print((pv && qv) + "\t" + (pv || qv) + "\t");
        System.out.print((pv ^ qv) + "\t" + (pv == qv) + "\t");
        System.out.print((!pv || qv));
        System.out.println();

        System.out.println("--------------------------------");

        scanner.close();
    }
}

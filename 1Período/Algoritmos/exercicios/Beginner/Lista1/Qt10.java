// Questão 10

/* 10 - Escreva um algoritmo que solicite do usuário a capacidade de um estádio de futebol e
a quantide de pessoas presentes em um jogo.
O programa deve informar se o estádio está lotado (acima de 80% de ocupação),
parcialmente lotado (acima de 50% de ocupação) ou
vazio (abaixo de 20% de ocupação).
*/

import java.util.Scanner;

public class Qt10 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int capacidade, pessoas;
        System.out.println("Informe a capacidade do estádio :");
        capacidade = leitor.nextInt();
        System.out.println("Informe a quantidade de pessoas presentes: ");
        pessoas = leitor.nextInt();

        if(pessoas > capacidade * 0.8){
            System.out.println("Estádio Lotado");
        } else if (pessoas > capacidade * 0.5) {
            System.out.println("Estádio Parcialmente Lotado");
        } else if (pessoas > capacidade * 0.2) {
            System.out.println("Estádio Parcialmente Vazio");
        } else {
            System.out.println("Estádio Vazio");
        }
    }
}
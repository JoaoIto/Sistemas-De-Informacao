package src.app;

import src.classes.Aluno;
import src.classes.Telefone;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Aluno[] alunos = new Aluno[2];
        Telefone[] telefones = new Telefone[2];

        Scanner leitor = new Scanner(System.in);

        // Cadastrando
        System.out.println("Cadastro de alunos em array: ");
        for(int i = 0; i < alunos.length; i++) {

            System.out.println("Digite o nome do aluno:\n" +
                    "Digite o codigo de área do telefone \n " +
                    "Digite o número dele:\n "+
                    "Digite o status dele: \n");

            String nome = leitor.next();
            int codigoArea = leitor.nextInt();
            int numero = leitor.nextInt();
            String status = leitor.next();

            telefones[i] = new Telefone(codigoArea, numero);
            alunos[i] = new Aluno(nome, telefones[i], status);
        }

        // Imprimindo
        for (int i = 0; i < alunos.length; i++) {
            System.out.println("O nome do aluno " + (i + 1) +" é: " + alunos[i].getNome());
            System.out.println("O telefone do aluno " + (i + 1) + " é: ");
            alunos[i].getTelefone();
            System.out.println("O status do aluno " + (i + 1) +" é: " + alunos[i].getStatus());
}
    }
}

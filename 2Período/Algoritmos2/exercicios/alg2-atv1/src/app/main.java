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
                    "Digite o status dele: \n" +
                    "Digite a nota 1 dele: \n " +
                    "Digite a nota 2 dele: ");

            String nome = leitor.next();
            int codigoArea = leitor.nextInt();
            int numero = leitor.nextInt();
            String status = leitor.next();
            double nota1 = leitor.nextDouble();
            double nota2 = leitor.nextDouble();

            telefones[i] = new Telefone(codigoArea, numero);
            alunos[i] = new Aluno(nome, telefones[i], status, nota1, nota2);
            alunos[i].setMedia(nota1, nota2);
            double media = alunos[i].getMedia();
            alunos[i].setAprovacao(media);
        }

        // Imprimindo
        for (int i = 0; i < alunos.length; i++) {
            System.out.println("O nome do aluno " + (i + 1) +" é: " + alunos[i].getNome());
            System.out.println("O telefone do aluno " + (i + 1) + " é: ");
            alunos[i].getTelefone();
            System.out.println("O status do aluno " + (i + 1) +" é: " + alunos[i].getStatus());
            System.out.println("A média do aluno é: " + alunos[i].getMedia());
            System.out.println("O aluno está" + alunos[i].getAprovacao());
            System.out.println();
}
    }
}

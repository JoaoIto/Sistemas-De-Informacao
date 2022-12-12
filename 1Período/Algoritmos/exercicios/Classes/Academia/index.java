/* 01 - Considere uma academia de musculação que realiza um acompanhamento
dos alunos matriculados. Para cada aluno são armazenados
o nome, idade, peso, altura, a quanto tempo treina (em meses),
tipo de treino e o dia da matrícula.

Escreva um programa que contenha funções que
permitam cadastrar um aluno (com o limite de 100 alunos),
atualizar o tempo de treino de todos os alunos que se matricularam em um determinado dia,
consultar os dados de um aluno (pesquisando pelo número),
calcular o IMC de um aluno e
atualizar o tipo de treino de todos os alunos (até 3 meses: iniciante,
entre 4 e 6 meses: intermediário,
entre 7 meses e 1 ano: marombeiro junior,
entre 1 e 2 anos: marombeiro sênior,
acima de 2 anos: Arnold Schwarzenegger.

*/

import java.util.Scanner;

class Registro {
    String nome, tipoTreino;
    int idade, tempoTreino, diaMatricula;
    double altura, peso;
}

public class index {

    public static String Cadastro(Registro[] aluno, int pessoa) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        aluno[pessoa].nome = leitor.nextLine();

        System.out.println("Digite sua idade: ");
        aluno[pessoa].idade = leitor.nextInt();

        System.out.println("Digite seu peso: ");
        aluno[pessoa].peso = leitor.nextDouble();

        System.out.println("Digite seu altura: ");
        aluno[pessoa].altura = leitor.nextDouble();

        System.out.println("Digite o dia do mês da matrícula: ");
        aluno[pessoa].diaMatricula = leitor.nextInt();

        aluno[pessoa].tempoTreino = 0;
        aluno[pessoa].tipoTreino = "Iniciante";

        return "Pessoa número " + pessoa + "foi cadastrada com sucesso \n";
    }

    public static String Atualiza(Registro[] aluno, int pessoa) {
        Scanner leitor = new Scanner(System.in);

        int data;

        System.out.println("Que dia de treino é hoje: ");
        data = leitor.nextInt();

        for (int i = 0; i < aluno.length; i++) {
            if (data == aluno[i].diaMatricula) {
                aluno[i].tempoTreino += 30;
            }

            if (aluno[i].tempoTreino >= 120) {
                aluno[i].tipoTreino = "Intermediário";
            }

            else if (aluno[i].tempoTreino >= 210) {
                aluno[i].tipoTreino = "Marombeiro Júnior";
            }

            else if (aluno[i].tempoTreino > 360) {
                aluno[i].tipoTreino = "Marombeiro sênior";
            }

            else if (aluno[i].tempoTreino > 720) {
                aluno[i].tipoTreino = "Arnold Schwarzenegger";
            }
        }

        for (int i = 0; i < pessoa; i++) {
            System.out.println(aluno[i].nome);
            System.out.println(aluno[i].idade);
            System.out.println(aluno[i].peso);
            System.out.println(aluno[i].altura);
            System.out.println(aluno[i].diaMatricula);
            System.out.println(aluno[i].tempoTreino);
            System.out.println(aluno[i].tipoTreino);
        }

        return "Sistema atualizado com sucesso \n";
    }

    public static String Consulta(Registro[] aluno) {
        Scanner leitor = new Scanner(System.in);

        int idAluno;

        System.out.println("Digite o id do aluno a ser consultado: ");
        idAluno = leitor.nextInt();

        return (aluno[idAluno].nome +
                aluno[idAluno].idade +
                aluno[idAluno].peso +
                aluno[idAluno].altura +
                aluno[idAluno].diaMatricula +
                aluno[idAluno].tempoTreino +
                aluno[idAluno].tipoTreino);
    }

    public static String IMC(Registro[] aluno) {
        Scanner leitor = new Scanner(System.in);

        int idAluno;

        System.out.println("Digite o id do aluno a ser calculado o IMC: ");
        idAluno = leitor.nextInt();

        double imc = aluno[idAluno].peso / (aluno[idAluno].altura * aluno[idAluno].altura);
        String tipoIMC;

        if (imc < 18.5) {
            tipoIMC = "Magro";
        }

        else if (imc <= 24.9) {
            tipoIMC = "Normal";
        }

        else if (imc <= 29.9) {
            tipoIMC = "Sobrepeso";
        }

        else {
            tipoIMC = "Gordo";
        }

        return ("O IMC do aluno é: " + imc + "tipo: " + tipoIMC);
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int escolha, pessoa = 0;
        Registro[] aluno = new Registro[100];

        for (int i = 0; i < 100; i++) {
            aluno[i] = new Registro();
        }

        do {
            System.out.println("O que deseja fazer?");

            System.out.println("Escolha 1: Cadastrar aluno");
            System.out.println("Escolha 2: Atualizar tempo de treino");
            System.out.println("Escolha 3: Consultar dados");
            System.out.println("Escolha 4: Calcular o IMC do aluno");

            escolha = leitor.nextInt();

            if (escolha == 1) {
                System.out.println(Cadastro(aluno, pessoa));
                pessoa++;
            }

            if (escolha == 2) {
                System.out.println(Atualiza(aluno, pessoa));
            }

            if (escolha == 3) {
                System.out.println(Consulta(aluno));
            }

            if (escolha == 4) {
                System.out.println(IMC(aluno));
            }

        } while (pessoa < 100);
    }
}
import Classes.Associacao.Aluno;
import Classes.Associacao.Disciplina;
import Classes.Associacao.Professor;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println("No programa principal de Main, iremos criar os objetos\n" +
                "de relacionamento entre as classes!");
        System.out.println("Dentre eles temos: \nAssociação;\nAgregação;\nComposição;");

        //Criação objeto professor
        Professor professor1 = new Professor("Janio", "123456789");
        Professor professor2 = new Professor("Carlos", "987654321");

        //Criando array de professores
        List<Professor> professores = new ArrayList<>();
        professores.add(professor1);
        professores.add(professor2);

        // Criação dos objetos de Disciplina
        Disciplina d1 = new Disciplina("Algoritmos", 60, professores);
        Disciplina d2 = new Disciplina("Algoritmos2", 60, professores);

        //Criação de array de disciplinas
        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(d1);
        disciplinas.add(d2);

        // Criação dos objetos de Aluno
        Aluno a1 = new Aluno("JoaoIto", 17, "2243433", disciplinas);
        Aluno a2 = new Aluno("Bruno", 19, "435332743", disciplinas);

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(a1);
        alunos.add(a2);

        // Imprime as informações de Alunos e Disciplinas associadas a cada um
        System.out.println("Informações do Aluno " + a1.getNome() + ":");
        System.out.println("Matrícula: " + a1.getMatricula());
        System.out.println("Disciplinas:");

        for (Disciplina disciplina : a1.getDisciplinas()) {
            System.out.println("- " + disciplina.getNome());
        }
        System.out.println();

        System.out.println("Informações do Aluno " + a2.getNome() + ":");
        System.out.println("Matrícula: " + a2.getMatricula());
        System.out.println("Disciplinas:");

        for (Disciplina disciplina : a2.getDisciplinas()) {
            System.out.println("- " + disciplina.getNome());
        }
        System.out.println();

        // Imprime as informações do Professor e Disciplinas associadas a ele
        System.out.println("Informações dos Professores: ");

        // Loop for para percorrer a lista de professores
        for (int i = 0; i < professores.size(); i++) {
            // Obtem o objeto da lista de professores na posicao i
            Professor professor = professores.get(i);

            // Imprime as informações do professor
            System.out.println("Nome do professor: " + professor.getNome());
            System.out.println("Titulação do professor: " + professor.getTitulacao());
        }

        // Listando com uma filtragem de atributos:

        // Filtra os alunos por idade
        List<Aluno> alunosPorIdade = new ArrayList<>();
        int idadeFiltro = 18;
        for (Aluno aluno : alunos) {
            if (aluno.getIdade() <= idadeFiltro) {
                alunosPorIdade.add(aluno);
            }
        }

// Imprime as informações dos alunos filtrados
        System.out.println("Alunos com " + idadeFiltro + " anos:");
        for (Aluno aluno : alunosPorIdade) {
            System.out.println("Nome do aluno: " + aluno.getNome());
            System.out.println("Idade do aluno: " + aluno.getIdade());
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println("Disciplinas:");
            for (Disciplina disciplina : aluno.getDisciplinas()) {
                System.out.println("- " + disciplina.getNome());
            }
            System.out.println();
        }
    }
}

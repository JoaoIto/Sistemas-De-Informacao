package app;
import java.util.Scanner;

import Cadastros1aula1.Aluno;
import Cadastros1aula1.Telefone;
public class Qt3 {
	
	static Scanner leitor = new Scanner(System.in);
	
    public static void main(String[] args) {
    	Aluno[] alunos = new Aluno[1];
    	
    	for(int i = 0; i < alunos.length; i++) {
    		alunos[i] = new Aluno();
    		alunos[i].lerAluno();
    	}
    	imprimir(aluno);
    	
    	for(Aluno a : alunos) {
    		System.out.println(aluno.nome);
    		System.out.println(aluno.disciplina);
    		System.out.println(aluno.media);
    	}
    }
}
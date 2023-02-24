package app;
import Cadastros1aula1.Aluno;
import java.util.Scanner;
import java.util.Scanner;
public class Qt4 {
	
	static Scanner leitor = new Scanner(System.in);
	
	 public static Aluno lerAluno(){
	        Aluno novoAluno = new Aluno();
	        novoAluno.nome = leitor.next();
	        novoAluno.disciplina = leitor.next();
	        novoAluno.notaA1 = leitor.nextDouble();
	        novoAluno.notaA2 = leitor.nextDouble();
	        novoAluno.media = media(novoAluno.notaA1, novoAluno.notaA2);
	        aprovado(novoAluno);
	        return novoAluno;
	    }
	 
	 public static double media(double n1, double n2){
	        return ((n1+n2)/2);
	    }
	 
	 public static void aprovado(Aluno aluno){
	        if(aluno.media < 6)
	            aluno.statusDisciplina = "Reprovado";
	        else
	            aluno.statusDisciplina = "Aprovado";
	    }
	 
	 public static void imprimir(Aluno[] vetAluno){
	        for (Aluno aluno : vetAluno) {
	            if (vetAluno.length != 0) {
	                System.out.println("Nome do aluno: "+aluno.nome);
	                System.out.println("Média: "+aluno.media);
	                System.out.println("Status: "+aluno.statusDisciplina);
	            }
	        }
	    }


	public static void main(String[] args) {
		Aluno[] alunos = new Aluno[10];
		int escolha;
		
		System.out.println("Cadastro de alunos");
		
		do {
    		System.out.println("Digite 1 para padastrar yum aluno; E digite 2 para ver dados de alunos: ");
    		escolha = leitor.nextInt();
    		
    		switch(escolha) {
    		case 1 -> {
    			for(int i = 0; i < alunos.length; i++) {
    				System.out.println("Escreva o nome do aluno: "+ (i + 1));
    				System.out.println("Escreva a disciplina do aluno: "+ (i + 1));
    				System.out.println("Escreva a nota 1 do aluno: "+ (i + 1));
    				System.out.println("Escreva a nota 2 do aluno: "+ (i + 1));
    				
    				alunos[i] = lerAluno();
    				
    				System.out.println("Quer fazer mais cadastros? Digite 1 para continuar e digite 2 para não: ");
    				int decisao = leitor.nextInt();
    				
    				if(decisao != 1) {
    					i = 10;
    				}
    			}
    		}
    		case 2 -> imprimir(alunos);
    		}
    		
    		System.out.println("Quer fazer mais cadastros? Digite 1: ");
    		escolha = leitor.nextInt();
    	}while(escolha != 2);
	}
}

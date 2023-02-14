package app;
import java.util.Scanner;
import Cadastros1aula1.Aluno;
import Cadastros1aula1.Telefone;

public class Qt3 {
	
	static Scanner leitor = new Scanner(System.in);
	
	public static Telefone lerTelefone(){
        Telefone novoTelefone = new Telefone();
        novoTelefone.codigoArea = leitor.nextInt();
        novoTelefone.numero = leitor.nextInt();
        return novoTelefone;
	}
	
	public static Aluno lerAluno(){

        Aluno novoAluno = new Aluno();
        novoAluno.nome = leitor.next();
        novoAluno.telefone = lerTelefone();
        return novoAluno;
     }
	
	public static void imprimir(Aluno[] vetAluno){
        for (Aluno aluno : vetAluno) {
            if (vetAluno.length != 0) {
                System.out.println("Nome: " + aluno.nome);
                System.out.println("Telefone: (" + aluno.telefone.codigoArea + ") " + aluno.telefone.numero);
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
    				System.out.println("Escreva o nome do aluno "+ (i + 1));
    				System.out.println("Escreva o codigo de area do telefone do aluno "+ (i + 1));
    				System.out.println("Escreva o telefone do aluno "+ (i + 1));
    				
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

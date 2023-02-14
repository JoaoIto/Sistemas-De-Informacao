package app;
import java.util.Scanner;
import Cadastros1aula1.Aluno;
import Cadastros1aula1.Telefone;

public class Qt2 {
	
	static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) {
    	Aluno[] alunos = new Aluno[10];
    	
    	System.out.println("cadastro de alunos: ");
    	
    	for(int i = 0; i < alunos.length; i++) {
    		System.out.println("Escreva os dados do aluno "+ (i + i));
    		alunos[i] = new Aluno();
    		
    		System.out.println("Digite o nome do aluno: ");
    		alunos[i].nome = leitor.next();
    		// System.out.println("nome;\ncodigo de area;\nnumero;");
    		System.out.println("Digite o código de área do aluno: ");
            alunos[i].telefone = new Telefone();
            alunos[i].telefone.codigoArea = leitor.nextInt();
            
            System.out.println("Digite o numero do aluno: ");
            alunos[i].telefone.numero = leitor.nextInt();
            
            System.out.println("Continuar cadastro? Digite 1 para SIM e 2 para NÃO.");
            int decisao = leitor.nextInt();
            
            if (decisao == 2) {
                break;
            }
            
            for(Aluno aluno : alunos) {
            	if(alunos.length != 0) {
            		System.out.println("nome: "+ aluno.nome);
            		System.out.println("telefone: ("+aluno.telefone.codigoArea+") "+aluno.telefone.numero);
            	}
            }
    	}
    }
}

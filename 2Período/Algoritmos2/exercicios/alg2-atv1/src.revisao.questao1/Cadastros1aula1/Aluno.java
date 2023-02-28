package Cadastros1aula1;
import java.util.Scanner;
import Cadastros1aula1.Telefone;

public class Aluno {
    public String nome;
    public String disciplina;
    public Telefone telefone;
    public double notaA1;
    public double notaA2;
    public double media;
    public String statusDisciplina;
    
    public static Aluno lerAluno(){

    	 Scanner leitor = new Scanner(System.in);
    	
        Aluno novoAluno = new Aluno();
        novoAluno.nome = leitor.next();
        Telefone telefone = new Telefone();
        novoAluno.telefone = telefone.lerTelefone();
        return novoAluno;
     }
}
package Cadastros1aula1;

import java.util.Scanner;

public class Telefone {
	public int codigoArea;
	public int numero;
	
	static Scanner leitor = new Scanner(System.in);
	
	public static Telefone lerTelefone(){
        Telefone novoTelefone = new Telefone();
        novoTelefone.codigoArea = leitor.nextInt();
        novoTelefone.numero = leitor.nextInt();
        return novoTelefone;
	}
}


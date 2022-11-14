/* 01 - Escreva um programa que solicite do usuário dois valores numéricos. 
O programa deve conter uma função para calcular 
e retornar a média aritmética dos valores informados.
*/
import java.util.Scanner;
public class Main
{
    
    public static int media(int n1, int n2)
    {
        int result = (n1 + n2) / 2;
        return result;
    }
    
	public static void main(String[] args) {
	    Scanner leitor = new Scanner(System.in);
	    
	    int n1, n2;
	    
	    System.out.println("Informe um número: ");
	    n1 = leitor.nextInt();
	    
	    System.out.println("Informe outro número: ");
	    n2 = leitor.nextInt();
	    
	    System.out.println("A media dos valores é: " + media(n1, n2));
	}
}

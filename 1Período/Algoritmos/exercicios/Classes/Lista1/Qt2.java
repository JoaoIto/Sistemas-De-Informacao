/* 02 - Escreva um programa que solicite do usuário os valores 
dos lados de um retângulo. 
O programa deve conter funções diferentes para 
calcular a área e o perímetro do retângulo em questão.
*/
import java.util.Scanner;
public class Main
{
    
    public static int area(int base, int altura)
    {
        int area = base * altura;
        return area;
    }

    public static int perimetro(int base, int altura)
    {
        int perimetro = (base * 2) + (altura * 2);
        return perimetro;
    }
    
	public static void main(String[] args) {
	    Scanner leitor = new Scanner(System.in);
	    
	    int base, altura;
	    
	    System.out.println("Informe a base do retângulo: ");
	    base = leitor.nextInt();
	    
	    System.out.println("Informe a altura do retângulo: ");
	    altura = leitor.nextInt();
	    
	    System.out.println("A area dos valores é: " + area(base, altura));
        System.out.println("O perímetro dos valores é: " + perimetro(base, altura));
	}
}

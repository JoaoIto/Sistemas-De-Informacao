/* 03 - Escreva um programa que solicite do usuário 
o peso e a altura de uma pessoa. 
O programa deve conter uma função que calcule o IMC 
e indique se a pessoa está magra (abaixo de 20), 
com peso dentro dos padrões saudáveis (entre 20 e 25) 
ou acima do peso (acima de 25).
*/

import java.util.Scanner;
public class Main
{
    
    public static float imc(float peso, float altura)
    {
        float imc = peso * (altura * altura);
        return imc;
    }

    public static String tipo(float imc)
    {
        String tipo;
        if(imc < 20){
         tipo = "magra";
         return tipo;
         else if(imc < 25 && imc > 20){
            tipo = "ideal";
            return tipo;
         }else{
            tipo = "alto";
            return tipo;
         }
    }
    
	public static void main(String[] args) {
	    Scanner leitor = new Scanner(System.in);
	    
	    int peso, altura, imc;
	    
	    System.out.println("Informe o peso: ");
	    peso = leitor.nextInt();
	    
	    System.out.println("Informe a altura: ");
	    altura = leitor.nextInt();
	    
	    System.out.println("O seu IMC é: " + imc(peso, altura));
        System.out.println("O seu imc está " + tipo(imc));
	}
}

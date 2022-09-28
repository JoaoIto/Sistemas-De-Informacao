import java.util.Scanner;
public class Qt3 {
    public static void main (String[]args)
  {
    Scanner leitor = new Scanner (System.in);

    /* 02 - Escreva um algoritmo que solicite do usuC!rio que 
       informe uma sequC*ncia de 10 nC:meros inteiros. 
       Ao final deve informar a quantidade de nC:meros pares e C-mpares 
       que foram digitados. */

    int pares = 0, impares = 0, numero = 0;

    for (int i = 0; i < 10; i++)
      {
	System.out.print ("Informe um numero inteiro:");
	numero = leitor.nextInt();
      

    if (numero % 2 == 0)
      {
      pares++;}
    else
      {
      impares++;}
}
System.out.print("Existem "+ impares + "impares, e "+ pares + "pares.");
  }
}

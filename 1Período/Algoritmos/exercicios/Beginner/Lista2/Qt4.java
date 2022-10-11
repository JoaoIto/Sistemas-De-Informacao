import java.util.Scanner;
public class Qt4 {
    public static void main (String[]args)
    {
      Scanner leitor = new Scanner (System.in);
  
      /* 01 - Escreva um algoritmo que permira ao usuário informar 
      valores numéricos inteiros até que um número negativo seja informado. 
      Ao final deve apresentar ao usuário a quantidade de números 
      que foram informados. */
  
      int numero = 0, numeroNeg = 0, count = 0;
      
      for(; count >= 0; count++){
      System.out.print("Informe um número: \n");
      numero = leitor.nextInt();
      
      if(numero < 0){
          break;
      }
      }
      
      System.out.print("Foram informados "+ count + "numeros");
      
      
    }
}

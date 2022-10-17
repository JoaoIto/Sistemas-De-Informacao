import java.util.Scanner;
public class Qt2 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
          
        /* 03 - Escreva um algoritmo que solicite do usuário 
        uma sequência de números e apresente ao final o maior número digitado. 
        A sequência de números deve ser encerrada com o número 0. */
        
        int maiorNum = 0;
        
        while(true){
            System.out.println("Informe um número: ");
              int n = leitor.nextInt();
              if(n == 0){
                  break;
              } else if (n > maiorNum) {
                  maiorNum = n;
          }
        }
        System.out.println("O maior numero foi: " + maiorNum);
      }
}

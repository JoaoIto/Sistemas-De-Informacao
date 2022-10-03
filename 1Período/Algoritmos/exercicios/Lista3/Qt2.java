/* 02 - Escreva um programa em Java que solicite do usuário 
a digitação de diversas palavras, devendo encerrar automaticamente 
quando a palavra "sair" for digitada. 
O programa deve apresentar ao final quantas vezes a palavra "para" foi digitada.
*/

import java.util.Scanner;

public class Qt2 {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
    
        String palavra;
        int count = 0;
        
        while(true){
            System.out.println("Informe a palavra: ");
            palavra = leitor.nextLine();
            if(palavra.equals("sair")){
                break; 
            }
            if(palavra.contains("para")){
                count++;
            }
        }
        System.out.println("A palavra 'para' foi digitada : " + count + " vezes.");
    
        leitor.close();
    }
}
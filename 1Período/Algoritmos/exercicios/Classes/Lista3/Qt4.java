import java.util.*;

/* 04 - Escreva um programa que solicite do usuário 
uma mensagem de natal e contenha uma função que 
imprima 10 vezes a mensagem na tela. 
*/

public class Qt4 {

    public static void repeteMensagem(String mensagem){
            for(int i = 0; i < 10; i++){
                System.out.println(mensagem);
            }
    }
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String mensagemNatalina;
        System.out.println("Insira a sua mensagem natalina!");
        mensagemNatalina = leitor.next();

        repeteMensagem(mensagemNatalina);
    }
}

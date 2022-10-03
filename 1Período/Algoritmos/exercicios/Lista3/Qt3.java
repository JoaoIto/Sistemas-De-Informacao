/* 03 - Escreva um programa que permita ao usuário informar 
uma senha e confirmar a senha. Caso a senha e a confirmação sejam diferentes 
o programa deve solicitar ao usuário que digite a confirmação novamente. 
Deve ser possível confirmar a senha corretamente por 3 tentativas. 
Caso o usuário tenha sucesso o programa deve imprimir a mensagem "Senha confirmada com sucesso", 
caso contrário, apresentar a mensagem "Senha bloqueada". 
*/

import java.util.Scanner;
public class Qt3 {
    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);

        int countSenha = 0;
        String senha, confirmacao;

        System.out.println("Informe a sua senha: ");
        senha = leitor.next();

        System.out.println("Informe a confirmacao de sua senha: (deve ser idêntica a senha:)");
        confirmacao = leitor.next();
    
        while(countSenha <= 3 && confirmacao != senha){
            System.out.println("Informe a confirmação de sua senha: (deve ser idêntica a senha:)");
            confirmacao = leitor.next();
            countSenha++;
        }
        if(confirmacao != senha)
            System.out.println("Senha bloqueada!");
        else 
        System.out.println("Senha confirmada com sucesso");
    }
}

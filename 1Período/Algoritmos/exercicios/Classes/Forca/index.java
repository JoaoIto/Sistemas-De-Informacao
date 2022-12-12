/* - Escreva um programa para simular o jogo da Forca. 
O jogo deve ter um jogador que irá escolher a palavra 
e outro que será o desafiante. 

O desafiante poderá informar os caracteres que ele acha que tem 
na frase secreta e o programa deve conter uma função que 
apresenta na tela somente os caracteres que o desafiante já acertou. 
O desafiante ainda poderá tentar acertar antecipadamente a frase secreta. 
Ao final o programa deve apresentar a quantidade de letras chutadas 
até que a frase secreta seja descoberta. 
*/

import java.util.Scanner;

public class index {

    static void palpiteDesafiante(char[] charArrayChallenger, int numC, char[] charArrayPlayer, int numP) {
        char[] vetorPalpite = new char[numC];
        int acertos = 0;

        for (int i = 0; i < numC; i++) {
            vetorPalpite[i] = charArrayChallenger[i];
            for (int j = 0; j < numP; j++) {
                if (vetorPalpite[i] == charArrayPlayer[j]) {
                    System.out.printf("O DESAFIANTE ACERTOU A LETRA %s%n", charArrayChallenger[i]);
                    acertos++;
                }
            }
        }
        
        System.out.printf("O DESAFIANTE ACERTOU %d letras%n", acertos);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String palavraForca;

        System.out.print("Jogador, qual e a palavra secreta?: ");
        palavraForca = sc.nextLine();

        char[] charArrayJogador = palavraForca.toCharArray();
        int nJ = charArrayJogador.length;

        System.out.print("Quer tentar acertar a palavra inteira ? Digite 1 para sim, 2 para nao.");
        int tentativaDireta = sc.nextInt();
        sc.nextLine();

        if (tentativaDireta == 1) {
            System.out.print("Desafiante, digite a palavra inteira: ");
            String palavraDesafiante = sc.nextLine();
            if (palavraDesafiante.equals(palavraForca)) {
                System.out.print("Voce acertou!.");
            }
        }
        if (tentativaDireta == 2) {

            System.out.println();

            System.out.print("Numeros de tentativas do desafiante: ");
            int nD = sc.nextInt();

            char[] charArrayDesafiante = new char[nD];

            for (int i = 0; i < nD; i++) {
                System.out.print("Desafiante, digite seu " + (i + 1) + " palpite : ");
                charArrayDesafiante[i] = sc.next().charAt(0);
            }

            palpiteDesafiante(charArrayDesafiante, nD, charArrayJogador, nJ);
        }
        sc.close();
    }
}
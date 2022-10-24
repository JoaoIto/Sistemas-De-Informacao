/*
01 - Escreva um programa que preencha um array de 100 posições
com números aletaórios entre 0 e 199. O usuário 
terá 10 chances de chutar valores que estejam no array. 
A cada chute que ele digitar um valor contido no array a 
sua pontuação deve ser atualizada. Ao final o programa 
deve apresentar a pontuação final.
*/

import java.util.Scanner;
import java.util.Random;

public class Qt1
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        Random sorteio = new Random();
        int[] vetor = new int[100];
        int[] jafoi = new int[10];
        int chute=0, pontos = 0, quantChutes=0, ok=0;
        
        // preenche o array com valores aleatórios
        for(int i=0; i<100; i++)
            vetor[i] = sorteio.nextInt(199);
        //----------------------------------------
        
        for(int i=0; i<10; i++)
            jafoi[i]  = -1;
        
        // ------------ 10 CHUTES ------------------------
        for(int i=0; i<10; i++)
        {
            //-------- Apresenta o conteudo do array ------------------------
            for(int n=0; n<100; n++)
            {
                System.out.print("[" + vetor[n] + "]");
                if(n % 10 == 0)
                    System.out.print("\n");
            }//----------------------------------
            
            // ok sinaliza se o numero chutado já foi chutado antes
            // se ok = 1 então numero liberado
            // se ok = 0 numero ja foi chutado antes
            //---------------------------------------------------------------
            while(ok != 1)
            {   
                System.out.print("Vamos lá, dê seu melhor lance:");
                chute = leitor.nextInt();
                ok = 1; // libera o valor chutado
                for(int c=0; c<quantChutes; c++)
                {
                    if(jafoi[c] == chute)     // já tem esse valor chutado no array ja foi
                    {
                        ok = 0;
                        System.out.print("Numero já foi chutado\n");
                        c = quantChutes; // permite sair do laço
                    }
                }
                // inclui o chute no array jafoi
            }
            
            // atualiza o array jafoi e a quantidade de chutes validos
            jafoi[quantChutes] = chute;
            quantChutes++;
            ok = 0; // variavel reinicializada
            // verifica se o numero chutado está no array
            for(int j=0; j<100; j++)
            {
                if(chute == vetor[j])
                {
                    pontos++;
                    j = 100;
                }
            }//----------------------------------
            System.out.println("Você tem :" + pontos + " pontos.");
            System.out.println("Restam " + (10-quantChutes) +"chutes!");
        }
        //--------------------------------------
        
	}
}


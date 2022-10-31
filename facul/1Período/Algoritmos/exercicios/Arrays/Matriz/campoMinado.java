import java.util.Scanner;
import java.util.Random;

public class campoMinado
{
	public static void main(String[] args) 
	{   
	    Scanner leitor = new Scanner(System.in);
	    Random sorteio = new Random();
	    int dimensao, jogadas, linha=0, coluna=0;
	    
	    System.out.println("Informe o tamanho do tabuleiro");
	    dimensao = leitor.nextInt();
	    
	    System.out.println("Informe a quantidade de jogadas");
	    jogadas = leitor.nextInt();

	    int[][] matriz = new int[dimensao][dimensao];     // declaração e instanciação de uma matriz de 
        
	    
        // processamento de uma matriz
        for(int l=0; l<dimensao; l++) // percorre as linhas
        {
            for(int c=0; c<dimensao; c++) // percorre as colunas de uma linha (indicada pelo índice "l")
            {
                matriz[l][c] = sorteio.nextInt(100);
            }
        }
        
        System.out.print("Encontre números pares:\n");
        for(int i=0; i<jogadas; i++)
        {
            System.out.print("Linha:");
            linha = leitor.nextInt();
            System.out.print("Coluna:");
            coluna = leitor.nextInt();
            
            if(matriz[linha][coluna] % 2 == 0)
                System.out.println("Parabéns!");
            else
                System.out.println("Errou!");
            
            // processamento de uma matriz
            for(int l=0; l<dimensao; l++) // percorre as linhas
            {
                for(int c=0; c<dimensao; c++) // percorre as colunas de uma linha (indicada pelo índice "l")
                {
                    if(l == linha && c == coluna)
                        System.out.print("[" + matriz[l][c] + "]\t");
                    else
                        System.out.print("[ X ]\t");
                }
                System.out.print("\n");
            }
        }
	}
}

import java.util.Scanner;
import java.util.Random;

public class Qt1
{
    public static void main(final String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        Random sorteio = new Random();
        int i, count, valor, countAcertos = 0, countErros=0, achado = 0;
        
        int[] vetor = new int[100]; // declaracao e instanciacao do array
        
        // preenche o array de 100 posições com valores aleatorios entre 0 e 199
        for(i=0; i<100; i++)
        {
            vetor[i] = sorteio.nextInt(200);
        }

        for(count=0; count<10; count++)
        {
            System.out.println("Informe um valor do array: ");
            valor = leitor.nextInt();
            for(i=0; i<100; i++)
        {
            if(valor==vetor[i] && achado == 0){
                countAcertos++;
                achado++;
            }else {
                countErros++;
            }
        }
        achado = 0;
        }
        System.out.println("\nVocê acertou: "+ countAcertos);
        System.out.println("Você errou: "+ countErros);
	}
}
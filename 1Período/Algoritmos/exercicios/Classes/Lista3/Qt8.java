/* 08 - Escreva um programa em Java que solicite do usuário 

- o consumo médio de um carro (em Km / litros), 
- o valor do litro de combustível, 
- a distância de uma viagem e 
- a velocidade média pretendida para a viagem. 

O programa deve ter funções que permitam 
- obter o tempo previsto e 
- o valor a ser gasto com combustível. 
*/

import java.util.*;

public class Qt8 {

    public static double tempo(double velocidadeMedia, double distancia){
        return velocidadeMedia / distancia;
    }

    public static double valorGasto(double distancia, double consumo){
        return distancia / consumo;
    }
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        double consumo, valorLitro, distancia, velocidadeMedia;

        System.out.println("Insira o consumo médio do veículo: ");
        consumo = leitor.nextDouble();

        System.out.println("Insira o valor do litro de combustível: ");
        valorLitro = leitor.nextDouble();

        System.out.println("Insira a distância que será percorrida: ");
        distancia = leitor.nextDouble();

        System.out.println("Insira a velocidade média prevista na viagem: ");
        velocidadeMedia = leitor.nextDouble();

        System.out.println("O tempo previsto da sua viagem é de: "+ tempo(velocidadeMedia, distancia));

        System.out.println("O valor a ser gasto de combustível é de: " + valorGasto(distancia, consumo));
    }
}

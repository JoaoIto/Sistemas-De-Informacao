/* Avaliação A2 – Algoritmos e Programação I
Aluno: João Victor Póvoa França
Unitins – Sistemas de Informação
1° Período
Considere uma empresa de transportes que cobra o valor do frete a partir do peso da carga e
da distância entre a origem e o destino. Para cada frete deve-se informar a origem, o destino, o 
peso do pacote. Para pacotes de até 10 Kg o valor é de R$ 0,25 por Km. Acima de 10 Kg, o 
valor é de R$ 0,45 por Km.
Escreva um programa que permita ao usuário:
• Registrar até 100 solicitações de entrega (1,0)
• Calcular o valor a ser cobrado para realizar uma entrega (1,0)
• Listar a quantidade de entregas que saem de uma determinada origem (1,5)
• Calcular a distância média das entregas realizadas (1,0)
• Apresentar os dados da entrega mais cara realizada (1,0)
• Calcular o total arrecadado com todas as entregas (1,5)
• Calcular o peso total das cargas transportadas (1,0)
• Calcular o total percorrido pelos entregadores (1,0)
Além disso, o programador deve:
• Declarar e instanciar as estruturas para armazenar os dados do programa (1,0)
• Utilizar funções para implementar as funcionalidades (pelo menos 2) (1,5)
• Apresentar um menu de opções para o usuário (1,0) */

import java.util.*;

class Pacote {
    String origem, destino;
    double peso, distancia, taxaEntrega;
}

public class Index {

    public static String Registro(Pacote[] pacote, int count) {
        Scanner leitor = new Scanner(System.in);

        String informe;
        double taxaEntrega = 0;

        System.out.println("Informe a origem da sua entrega: ");
        pacote[count].origem = leitor.nextLine();

        System.out.println("Informe o destino da sua entrega: ");
        pacote[count].destino = leitor.nextLine();

        System.out.println("Informe a distancia da sua entrega: ");
        pacote[count].distancia = leitor.nextDouble();

        System.out.println("Informe o peso da sua entrega: ");
        pacote[count].peso = leitor.nextDouble();

        if (pacote[count].peso <= 10) {
            taxaEntrega = (pacote[count].distancia * 0.25);
        }

        else if (pacote[count].peso > 10) {
            taxaEntrega = (pacote[count].distancia * 0.45);
        }

        pacote[count].taxaEntrega = taxaEntrega;

        informe = "Sua entrega tem numero: " + count + " Sua taxa de entrega e de: " + taxaEntrega;
        return informe;
    }

    public static String totalDistancia(Pacote[] pacote, int count) {
        double acumulator = 0, totalDistancia;
        int i = 0;
        String informe;

        for (i = 0; i < count; i++) {
            acumulator = acumulator + pacote[i].distancia + pacote[i + 1].distancia;
        }

        totalDistancia = acumulator;

        informe = "A distancia total percorrida e: " + totalDistancia;

        return informe;
    }

    public static String totalArrecadado(Pacote[] pacote, int count) {
        double acumulator = 0, totalArrecadado;
        int i = 0;
        String informe;

        for (i = 0; i < count; i++) {
            acumulator = acumulator + pacote[i].taxaEntrega + pacote[i + 1].taxaEntrega;
        }

        totalArrecadado = acumulator;

        informe = "O total arrecadado com cada entrega e: " + totalArrecadado;

        return informe;
    }

    public static String EntregaCara(Pacote[] pacote, int count) {
        double acumulator = 0, entregaCara = 0;
        int i = 0;
        String informe;

        for (i = 0; i < count; i++) {
            if (pacote[i].taxaEntrega > pacote[i + 1].taxaEntrega) {
                entregaCara = pacote[i].taxaEntrega;
            }
        }

        informe = "A entrega mais cara realizada foi: " + entregaCara;

        return informe;
    }

    public static String pesoTotal(Pacote[] pacote, int count) {
        double acumulator = 0, pesoTotal;
        int i = 0;
        String informe;

        for (i = 0; i < count; i++) {
            acumulator = (pacote[i].peso + pacote[i + 1].peso);
        }

        pesoTotal = acumulator;
        informe = "O peso total de suas entregas e: " + pesoTotal;

        return informe;
    }

    public static String distanciaMedia(Pacote[] pacote, int count) {
        double acumulator = 0, distanciaMedia;
        int i = 0;
        String informe;

        for (i = 0; i < count; i++) {
            acumulator = (pacote[i].distancia + pacote[i + 1].distancia);
        }

        distanciaMedia = (acumulator / i);
        informe = "A distancia media de suas entregas e: " + distanciaMedia;

        return informe;
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int escolha, count = 0;

        Pacote[] pacote = new Pacote[100];

        for (int i = 0; i < 100; i++) {
            pacote[i] = new Pacote();
        }

        do {
            System.out.println("Oque você deseja fazer? ");

            System.out.println("Escolha 1: Registrar uma solicitacao de venda; ");
            System.out.println("Escolha 2: Verificar dados de todas as entregas; ");
            escolha = leitor.nextInt();

            if (escolha == 1) {
                System.out.println(Registro(pacote, count));
                count++;
            }
            if (escolha == 2) {
                int escolhaDados;

                System.out.println("Oque você deseja fazer? ");

                System.out.println("Deseja listar o total arrecadado com cada entrega? Digite: 1");
                System.out.println("Deseja saber a distancia media de nossas entregas? Digite 2: ");
                System.out.println("Deseja saber o peso total de nossas entregas? Digite 3: ");
                System.out.println("Deseja saber a distancia total de nossas entregas? Digite 4: ");
                System.out.println("Deseja saber a entrega mais cara feita? Digite 5: ");
                escolhaDados = leitor.nextInt();

                if (escolhaDados == 1) {
                    System.out.println(totalArrecadado(pacote, count));
                }
                if (escolhaDados == 2) {
                    System.out.println(distanciaMedia(pacote, count));
                }
                if (escolhaDados == 3) {
                    System.out.println(pesoTotal(pacote, count));
                }
                if (escolhaDados == 4) {
                    System.out.println(totalDistancia(pacote, count));
                }
                if (escolhaDados == 5) {
                    System.out.println(EntregaCara(pacote, count));
                }
            }

        } while (count < 100);
        System.out.println("Programa encerrado! ");
    }
}
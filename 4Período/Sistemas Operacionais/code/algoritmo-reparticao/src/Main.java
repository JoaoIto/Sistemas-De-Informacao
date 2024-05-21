package src;

import src.alocadores_processos.AlocadorMemoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numParticoes = 10;
        int numProcessos = 5;

        List<Particao> particoes = new ArrayList<>();
        List<Processo> processos = new ArrayList<>();
        Random random = new Random();

        // Gerando partições com tamanhos aleatórios entre 100 e 600
        for (int i = 0; i < numParticoes; i++) {
            int tamanho = 100 + random.nextInt(501); // (100 a 600)
            particoes.add(new Particao(tamanho));
        }

        // Gerando processos com tamanhos aleatórios entre 100 e 500
        for (int i = 0; i < numProcessos; i++) {
            int tamanho = 100 + random.nextInt(401); // (100 a 500)
            processos.add(new Processo(i, tamanho));
        }

        AlocadorMemoria alocador = new AlocadorMemoria();

        // Copiando listas para não alterar as originais ao usar diferentes métodos de alocação
        List<Particao> particoesFirstFit = new ArrayList<>(particoes);
        List<Particao> particoesBestFit = new ArrayList<>(particoes);
        List<Particao> particoesWorstFit = new ArrayList<>(particoes);

        // First-fit
        System.out.println("First-Fit:");
        alocador.firstFit(particoesFirstFit, processos);
        for (Particao particao : particoesFirstFit) {
            System.out.println(particao);
        }

        // Best-fit
        System.out.println("\nBest-Fit:");
        alocador.bestFit(particoesBestFit, processos);
        for (Particao particao : particoesBestFit) {
            System.out.println(particao);
        }

        // Worst-fit
        System.out.println("\nWorst-Fit:");
        alocador.worstFit(particoesWorstFit, processos);
        for (Particao particao : particoesWorstFit) {
            System.out.println(particao);
        }
    }
}

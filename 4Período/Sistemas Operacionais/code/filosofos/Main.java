package filosofos;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        final int NUM_FILOSOFOS = 5;
        Semaphore[] hashis = new Semaphore[NUM_FILOSOFOS];
        Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS];

        // Inicializa os semáforos dos hashis
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            hashis[i] = new Semaphore(1); // Cada par de hashis é representado por um semáforo
        }

        // Cria e inicia as threads dos filósofos
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            int hashiEsquerda = i;
            int hashiDireita = (i + 1) % NUM_FILOSOFOS;
            filosofos[i] = new Filosofo(i, hashis[hashiEsquerda], hashis[hashiDireita]);
            filosofos[i].start();
        }
    }
}

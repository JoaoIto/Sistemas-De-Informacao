package filosofos;

import java.util.concurrent.Semaphore;
import java.util.Random;

class Filosofo extends Thread {
    private int id;
    private Semaphore hashiEsquerda;
    private Semaphore hashiDireita;
    private Random random;

    public Filosofo(int id, Semaphore hashiEsquerda, Semaphore hashiDireita) {
        this.id = id;
        this.hashiEsquerda = hashiEsquerda;
        this.hashiDireita = hashiDireita;
        this.random = new Random();
    }

    public void run() {
        try {
            while (true) {
                // Filósofo pensa por um tempo aleatório
                System.out.println("Filósofo " + id + " está pensando...");
                Thread.sleep(random.nextInt(5000));

                // Filósofo fica com fome e tenta pegar os hashis
                System.out.println("Filósofo " + id + " está com fome.");
                hashiEsquerda.acquire(); // Tenta pegar o hashi da esquerda
                hashiDireita.acquire(); // Tenta pegar o hashi da direita

                // Filósofo conseguiu pegar ambos os hashis e come
                System.out.println("Filósofo " + id + " está comendo...");
                Thread.sleep(random.nextInt(5000)); // Filósofo come por um tempo aleatório

                // Filósofo termina de comer e coloca os hashis de volta na mesa
                hashiEsquerda.release(); // Devolve o hashi da esquerda
                hashiDireita.release(); // Devolve o hashi da direita
                System.out.println("Filósofo " + id + " terminou de comer e colocou os hashis de volta na mesa.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

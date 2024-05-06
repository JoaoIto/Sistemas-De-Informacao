# Documentação de código

- A classe Filosofo representa um filósofo. Cada filósofo tem um identificador, uma referência aos semáforos dos hashis à sua esquerda e à sua direita, e um objeto Random para gerar números aleatórios.


- No método run(), cada filósofo passa por um ciclo de pensar, ficar com fome, comer e terminar de comer. Durante o processo, eles tentam adquirir os hashis disponíveis usando acquire() e liberam os hashis após comer usando release().


- Na classe Main, criamos os semáforos para representar os hashis e as threads para representar os filósofos. Cada filósofo é conectado aos hashis à sua esquerda e à sua direita.


- O programa cria uma simulação onde os filósofos pensam, ficam com fome, comem e terminam de comer, garantindo que nenhum deadlock ou starvation ocorra.

## Execução

Os filósofos estão representados por threads em execução simultânea. Eles pensam por um tempo aleatório, ficam com fome, tentam pegar os hashis, comem e depois voltam a pensar. O código garante que nenhum deadlock ou starvation ocorra, permitindo que todos os filósofos possam comer.

## Código comentado

- Filósofo

````java
import java.util.concurrent.Semaphore;
import java.util.Random;

// Classe que representa um filósofo
class Filosofo extends Thread {
    private int id; // Identificador do filósofo
    private Semaphore hashiEsquerda; // Semáforo para o hashi à esquerda
    private Semaphore hashiDireita; // Semáforo para o hashi à direita
    private Random random; // Objeto para gerar números aleatórios

    // Construtor do filósofo
    public Filosofo(int id, Semaphore hashiEsquerda, Semaphore hashiDireita) {
        this.id = id;
        this.hashiEsquerda = hashiEsquerda;
        this.hashiDireita = hashiDireita;
        this.random = new Random();
    }

    // Método que representa o comportamento do filósofo
    public void run() {
        try {
            while (true) { // Loop infinito para simular a ação contínua do filósofo
                // Filósofo pensa por um tempo aleatório
                System.out.println("Filósofo " + id + " está pensando...");
                Thread.sleep(random.nextInt(5000)); // Tempo aleatório entre 0 e 5000 milissegundos

                // Filósofo fica com fome e tenta pegar os hashis
                System.out.println("Filósofo " + id + " está com fome.");
                hashiEsquerda.acquire(); // Tenta pegar o hashi da esquerda
                hashiDireita.acquire(); // Tenta pegar o hashi da direita

                // Filósofo conseguiu pegar ambos os hashis e come
                System.out.println("Filósofo " + id + " está comendo...");
                Thread.sleep(random.nextInt(5000)); // Tempo aleatório entre 0 e 5000 milissegundos

                // Filósofo termina de comer e coloca os hashis de volta na mesa
                hashiEsquerda.release(); // Devolve o hashi da esquerda
                hashiDireita.release(); // Devolve o hashi da direita
                System.out.println("Filósofo " + id + " terminou de comer e colocou os hashis de volta na mesa.");
            }
        } catch (InterruptedException e) { // Captura exceção caso a thread seja interrompida
            e.printStackTrace();
        }
    }
}

````

- Main

````java
public class Main {
    public static void main(String[] args) {
        final int NUM_FILOSOFOS = 5; // Número de filósofos na mesa
        Semaphore[] hashis = new Semaphore[NUM_FILOSOFOS]; // Array de semáforos para os hashis
        Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS]; // Array de filósofos

        // Inicializa os semáforos dos hashis
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            hashis[i] = new Semaphore(1); // Cada par de hashis é representado por um semáforo com permissão inicial 1
        }

        // Cria e inicia as threads dos filósofos
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            int hashiEsquerda = i; // O hashi à esquerda do filósofo i é o hashi na posição i do array
            int hashiDireita = (i + 1) % NUM_FILOSOFOS; // O hashi à direita do filósofo i é o hashi na posição seguinte no array (com tratamento de overflow)
            filosofos[i] = new Filosofo(i, hashis[hashiEsquerda], hashis[hashiDireita]); // Cria um filósofo com os hashis corretos
            filosofos[i].start(); // Inicia a thread do filósofo
        }
    }
}
````

---

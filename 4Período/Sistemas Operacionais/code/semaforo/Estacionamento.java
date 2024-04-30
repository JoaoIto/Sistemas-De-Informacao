package semaforo;

import java.util.concurrent.Semaphore;

class Estacionamento {
    private Semaphore semaforo;
    private int vagas;

    public Estacionamento(int vagas) {
        this.vagas = vagas;
        this.semaforo = new Semaphore(vagas, true);
    }

    public void entrar(String carro) throws InterruptedException {
        semaforo.acquire();
        System.out.println(carro + " entrou no estacionamento.");
        vagas--;
        System.out.println("Vagas disponíveis: " + vagas);
    }

    public void sair(String carro) {
        semaforo.release();
        vagas++;
        System.out.println(carro + " saiu do estacionamento.");
        System.out.println("Vagas disponíveis: " + vagas);
    }
}
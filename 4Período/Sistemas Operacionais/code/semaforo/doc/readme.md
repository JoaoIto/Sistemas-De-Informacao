# Documentação de código

Estacionamento é a classe que representa o estacionamento. Ela possui um semáforo para controlar o acesso às vagas e um contador de vagas disponíveis.

- **O método ***entrar()***** é chamado quando um carro quer entrar no estacionamento. Ele adquire uma permissão do semáforo (bloqueando se não houver vagas disponíveis), decrementa o contador de vagas e imprime uma mensagem.

- **O método ***sair()***** é chamado quando um carro quer sair do estacionamento. Ele libera uma permissão do semáforo, incrementa o contador de vagas e imprime uma mensagem.
Carro é uma classe que representa um carro. 

- **No método ***run()*****, ele tenta entrar no estacionamento, dorme por um tempo simulando o tempo que fica no estacionamento, e então sai do estacionamento.

- **Na classe ***Main*****, criamos uma instância do estacionamento com um número específico de vagas e várias instâncias de carros, cada uma tentando estacionar.



## Código comentado

- Estacionamento
````java
import java.util.concurrent.Semaphore;

// Classe que representa o estacionamento
class Estacionamento {
    private Semaphore semaforo; // Semáforo para controlar acesso às vagas
    private int vagas; // Contador de vagas disponíveis

    // Construtor que inicializa o estacionamento com a quantidade de vagas especificada
    public Estacionamento(int vagas) {
        this.vagas = vagas;
        this.semaforo = new Semaphore(vagas, true); // Inicializa o semáforo com a quantidade de vagas
    }

    // Método para um carro entrar no estacionamento
    public void entrar(String carro) throws InterruptedException {
        semaforo.acquire(); // Adquire uma permissão do semáforo (bloqueia se não houver vagas disponíveis)
        System.out.println(carro + " entrou no estacionamento."); // Mensagem de entrada do carro
        vagas--; // Decrementa o contador de vagas
        System.out.println("Vagas disponíveis: " + vagas); // Mensagem com quantidade de vagas disponíveis
    }

    // Método para um carro sair do estacionamento
    public void sair(String carro) {
        semaforo.release(); // Libera uma permissão do semáforo
        vagas++; // Incrementa o contador de vagas
        System.out.println(carro + " saiu do estacionamento."); // Mensagem de saída do carro
        System.out.println("Vagas disponíveis: " + vagas); // Mensagem com quantidade de vagas disponíveis
    }
}
````

- Carro

````java
// Classe que representa um carro como uma thread
class Carro extends Thread {
    private String nome; // Nome do carro
    private Estacionamento estacionamento; // Referência ao estacionamento onde o carro quer estacionar

    // Construtor que inicializa o carro com um nome e a referência ao estacionamento
    public Carro(String nome, Estacionamento estacionamento) {
        this.nome = nome;
        this.estacionamento = estacionamento;
    }

    // Método que será executado quando a thread do carro for iniciada
    @Override
    public void run() {
        try {
            estacionamento.entrar(nome); // Carro tenta entrar no estacionamento
            Thread.sleep(2000); // Simula o tempo que o carro fica no estacionamento
            estacionamento.sair(nome); // Carro sai do estacionamento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
````

---

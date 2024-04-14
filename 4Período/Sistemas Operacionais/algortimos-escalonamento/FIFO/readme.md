# FIFO

Dentro de um sistema operacional, o algoritmo FIFO (First-In First-Out) é utilizado para o escalonamento de processos na CPU. Aqui está como funciona:

- Quando um processo chega ao estado de pronto para execução, ele é adicionado ao final da fila de processos prontos.
- O escalonador do sistema operacional seleciona o próximo processo a ser executado com base na ordem de chegada na fila. O processo que chegou primeiro é o próximo a ser executado.
- Quando um processo termina sua execução ou é interrompido, o próximo processo na fila é selecionado para execução.

Esse algoritmo é simples e fácil de implementar, mas pode não ser o mais eficiente em termos de tempo de espera, especialmente se processos longos forem colocados na fila antes de processos mais curtos.

Aqui está um exemplo simples de implementação do algoritmo FIFO em Java:

```java
import java.util.LinkedList;
import java.util.Queue;

public class FIFO {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Adiciona processos à fila
        queue.add("Processo A");
        queue.add("Processo B");
        queue.add("Processo C");

        // Simula execução dos processos
        while (!queue.isEmpty()) {
            String processo = queue.poll(); // Remove o primeiro processo da fila
            System.out.println("Executando " + processo);
            // Simulação de execução
            try {
                Thread.sleep(1000); // Espera de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

E um exemplo em TypeScript:

```typescript
class FIFO {
    queue: string[];

    constructor() {
        this.queue = [];
    }

    adicionarProcesso(processo: string) {
        this.queue.push(processo);
    }

    executarProcessos() {
        while (this.queue.length > 0) {
            const processo = this.queue.shift(); // Remove o primeiro processo da fila
            console.log(`Executando ${processo}`);
            // Simulação de execução
            this.sleep(1000); // Espera de 1 segundo
        }
    }

    sleep(ms: number) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
}

const escalonador = new FIFO();
escalonador.adicionarProcesso("Processo A");
escalonador.adicionarProcesso("Processo B");
escalonador.adicionarProcesso("Processo C");
escalonador.executarProcessos();
```

Esses exemplos simulam a execução de processos na ordem em que foram adicionados à fila, conforme o princípio do algoritmo FIFO.

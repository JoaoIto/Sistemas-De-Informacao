# Round Robin (Implementação e funcionamento)

Dentro de um sistema operacional:

- O algoritmo Round Robin é baseado em um conceito de tempo compartilhado, onde cada processo recebe uma fatia de tempo fixa chamada "quantum" para executar na CPU.
- Quando um processo chega ao estado de pronto para execução, ele é adicionado ao final da fila de processos prontos.
- O escalonador do sistema operacional seleciona o próximo processo na fila e permite que ele execute por um quantum.
- Após o término do quantum, o processo é suspenso e colocado de volta no final da fila.
- O escalonador então seleciona o próximo processo na fila e o processo se repete até que todos os processos sejam concluídos.

Aqui está um exemplo simples de implementação do algoritmo Round Robin em Java:

```java
import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        fila.add("Processo A");
        fila.add("Processo B");
        fila.add("Processo C");

        int quantum = 2; // Quantum de 2 unidades de tempo

        while (!fila.isEmpty()) {
            String processo = fila.poll(); // Remove o primeiro processo da fila
            System.out.println("Executando " + processo);
            // Simulação de execução por quantum
            for (int i = 0; i < quantum; i++) {
                // Verifica se o processo ainda tem instruções para executar
                if (processo.length() > 0) {
                    // Simula a execução de uma instrução
                    processo = processo.substring(1);
                } else {
                    break; // Processo concluído
                }
            }
            // Se o processo ainda tiver instruções, ele é colocado no final da fila
            if (processo.length() > 0) {
                fila.add(processo);
            }
        }
    }
}
```

E aqui está um exemplo em TypeScript:

```typescript
class RoundRobin {
    fila: string[];
    quantum: number;

    constructor(processos: string[], quantum: number) {
        this.fila = [...processos];
        this.quantum = quantum;
    }

    executarProcessos() {
        while (this.fila.length > 0) {
            const processo = this.fila.shift(); // Remove o primeiro processo da fila
            console.log(`Executando ${processo}`);
            // Simulação de execução por quantum
            for (let i = 0; i < this.quantum; i++) {
                // Verifica se o processo ainda tem instruções para executar
                if (processo && processo.length > 0) {
                    // Simula a execução de uma instrução
                    processo = processo.slice(1);
                } else {
                    break; // Processo concluído
                }
            }
            // Se o processo ainda tiver instruções, ele é colocado no final da fila
            if (processo && processo.length > 0) {
                this.fila.push(processo);
            }
        }
    }
}

const escalonador = new RoundRobin(["Processo A", "Processo B", "Processo C"], 2);
escalonador.executarProcessos();
```

Esses exemplos demonstram como o algoritmo Round Robin distribui a CPU entre os processos por meio de um quantum, proporcionando um compartilhamento justo e equitativo dos recursos da CPU.

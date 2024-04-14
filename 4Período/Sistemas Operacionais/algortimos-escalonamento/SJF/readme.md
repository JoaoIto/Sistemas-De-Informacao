# SJF

Dentro de um sistema operacional:

- O algoritmo SJF seleciona o próximo processo a ser executado com base na duração do tempo de execução. Ou seja, o processo com o menor tempo de execução é escolhido primeiro para ser executado.
- Isso ajuda a minimizar o tempo médio de espera, permitindo que processos mais curtos sejam concluídos mais rapidamente.
- Se um novo processo chegar enquanto um processo mais longo estiver em execução, o escalonador pode interromper a execução do processo atual para iniciar a execução do novo processo, desde que o novo processo seja mais curto.

Aqui está um exemplo simples de implementação do algoritmo SJF em Java:

```java
import java.util.Arrays;

public class SJF {
    public static void main(String[] args) {
        int[] burstTimes = {6, 8, 3, 1};
        Arrays.sort(burstTimes); // Ordena os tempos de burst em ordem crescente

        for (int i = 0; i < burstTimes.length; i++) {
            System.out.println("Executando processo por " + burstTimes[i] + " unidades de tempo.");
            // Simulação de execução
            try {
                Thread.sleep(burstTimes[i] * 1000); // Espera de acordo com o tempo de burst
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

E aqui está um exemplo em TypeScript:

```typescript
class SJF {
    constructor(private burstTimes: number[]) {
        this.burstTimes.sort((a, b) => a - b); // Ordena os tempos de burst em ordem crescente
    }

    executarProcessos() {
        for (let i = 0; i < this.burstTimes.length; i++) {
            console.log(`Executando processo por ${this.burstTimes[i]} unidades de tempo.`);
            // Simulação de execução
            this.sleep(this.burstTimes[i] * 1000); // Espera de acordo com o tempo de burst
        }
    }

    sleep(ms: number) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
}

const escalonador = new SJF([6, 8, 3, 1]);
escalonador.executarProcessos();
```

Esses exemplos demonstram como o algoritmo SJF seleciona e executa os processos com base em seus tempos de burst, dando prioridade aos processos mais curtos.

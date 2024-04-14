# SRTF

Dentro de um sistema operacional:

- O algoritmo SRTF é uma variação dinâmica do SJF, onde o próximo processo a ser executado é selecionado com base no tempo restante de execução, não apenas na duração total do processo.
- Se um novo processo chegar enquanto um processo estiver em execução, o escalonador verificará se o novo processo tem um tempo de burst mais curto do que o restante do tempo do processo atual. Se sim, o processo atual é interrompido e o novo processo é executado.
- Isso permite uma adaptação dinâmica às mudanças na carga de trabalho e ajuda a minimizar o tempo médio de espera.

Aqui está um exemplo simples de implementação do algoritmo SRTF em Java:

```java
import java.util.PriorityQueue;

public class SRTF {
    static class Processo implements Comparable<Processo> {
        int id;
        int burstTime;

        public Processo(int id, int burstTime) {
            this.id = id;
            this.burstTime = burstTime;
        }

        @Override
        public int compareTo(Processo outro) {
            return Integer.compare(this.burstTime, outro.burstTime);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Processo> fila = new PriorityQueue<>();
        fila.add(new Processo(1, 6));
        fila.add(new Processo(2, 8));
        fila.add(new Processo(3, 3));
        fila.add(new Processo(4, 1));

        int tempoAtual = 0;

        while (!fila.isEmpty()) {
            Processo processo = fila.poll(); // Processo com menor tempo restante
            System.out.println("Executando processo " + processo.id + " por " + processo.burstTime + " unidades de tempo.");
            tempoAtual += processo.burstTime; // Atualiza o tempo atual
            // Simulação de execução
            try {
                Thread.sleep(processo.burstTime * 1000); // Espera de acordo com o tempo de burst
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

E aqui está um exemplo em TypeScript:

```typescript
class SRTF {
    fila: { id: number; burstTime: number }[];

    constructor(processos: { id: number; burstTime: number }[]) {
        this.fila = [...processos];
        this.fila.sort((a, b) => a.burstTime - b.burstTime); // Ordena a fila pelo tempo de burst
    }

    executarProcessos() {
        let tempoAtual = 0;
        while (this.fila.length > 0) {
            const processo = this.fila.shift(); // Processo com menor tempo restante
            console.log(`Executando processo ${processo.id} por ${processo.burstTime} unidades de tempo.`);
            tempoAtual += processo.burstTime; // Atualiza o tempo atual
            // Simulação de execução
            this.sleep(processo.burstTime * 1000); // Espera de acordo com o tempo de burst
        }
    }

    sleep(ms: number) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
}

const escalonador = new SRTF([
    { id: 1, burstTime: 6 },
    { id: 2, burstTime: 8 },
    { id: 3, burstTime: 3 },
    { id: 4, burstTime: 1 }
]);
escalonador.executarProcessos();
```

Esses exemplos demonstram como o algoritmo SRTF seleciona e executa os processos com base no tempo restante de execução, adaptando-se dinamicamente à carga de trabalho.

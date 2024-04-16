## Exercício de cálculo

Vamos criar uma tabela com uma lista de processos para que você possa calcular o tempo médio de execução (turnaround time) e o tempo médio de espera para os algoritmos de escalonamento. Vou incluir processos com tempos de chegada e execução variados.

| Processo | Chegada | Tempo de Execução |
|----------|---------|-------------------|
|    P1    |    0    |         5         |
|    P2    |    1    |         3         |
|    P3    |    2    |         6         |
|    P4    |    3    |         4         |
|    P5    |    4    |         2         |

Agora, vamos calcular o tempo médio de execução e o tempo médio de espera para esses processos, usando o algoritmo Round Robin com um quantum de 2 unidades de tempo.

Vamos lá:

### Algoritmo Round Robin (Quantum = 2)
1. **Execução dos Processos**:
   - Rodada 1:
     - P1 (5ms)
     - P2 (3ms)
     - P3 (2ms)
     - P4 (2ms)
     - P5 (2ms)
   - Rodada 2:
     - P1 (3ms)
     - P3 (4ms)
     - P4 (2ms)
     - P5 (2ms)
   - Rodada 3:
     - P1 (1ms)
     - P3 (2ms)
     - P4 (2ms)
     - P5 (2ms)
   - Rodada 4:
     - P1 (0ms)
     - P3 (0ms)
     - P4 (0ms)
     - P5 (0ms)
2. **Cálculo dos Tempos**:
   - Tempo Médio de Execução: (5ms + 6ms + 8ms + 6ms + 4ms) / 5 = 29ms / 5 = 5.8ms
   - Tempo Médio de Espera: (4ms + 5ms + 5ms + 3ms + 0ms) / 5 = 17ms / 5 = 3.4ms

---

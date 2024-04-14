# Cálculos

1. **Tempo Médio de Execução (Turnaround Time)**:
   - O tempo médio de execução é o tempo total que um processo leva desde sua chegada até sua conclusão, incluindo o tempo de espera na fila de prontos e o tempo de execução na CPU.
   - Para calcular o tempo médio de execução, somamos o tempo total de cada processo e dividimos pelo número total de processos.

2. **Tempo Médio de Espera (Waiting Time)**:
   - O tempo médio de espera é o tempo médio que um processo passa na fila de prontos aguardando sua vez de ser executado na CPU.
   - Para calcular o tempo médio de espera, subtraímos o tempo de execução de cada processo pelo seu tempo de chegada e somamos esses valores para todos os processos, dividindo pelo número total de processos.

Aqui está um exemplo simples para ilustrar como calcular o tempo médio de execução e o tempo médio de espera para um conjunto de processos:

Suponha que temos três processos com os seguintes atributos:

| Processo | Chegada | Tempo de Execução | Tempo de Espera | Tempo de Turnaround |
|----------|---------|-------------------|------------------|---------------------|
|    P1    |    0    |         6         |        0         |          6          |
|    P2    |    2    |         4         |        0         |          6          |
|    P3    |    4    |         8         |        2         |          10         |

Aqui estão os cálculos detalhados:

- Para o Processo 1:
  - Tempo de Espera: 0ms (chegou primeiro)
  - Tempo de Turnaround: 0ms (tempo de chegada) + 6ms (tempo de execução) = 6ms

- Para o Processo 2:
  - Tempo de Espera: 2ms (tempo de espera na fila de prontos) + 0ms (tempo de espera para executar) = 2ms
  - Tempo de Turnaround: 2ms (tempo de chegada) + 4ms (tempo de execução) = 6ms

- Para o Processo 3:
  - Tempo de Espera: 4ms (tempo de espera na fila de prontos) + 2ms (tempo de espera para executar) = 6ms
  - Tempo de Turnaround: 4ms (tempo de chegada) + 8ms (tempo de execução) = 12ms

Isso nos dá os seguintes resultados:

- Tempo Médio de Execução: (6ms + 6ms + 12ms) / 3 = 8ms
- Tempo Médio de Espera: (0ms + 2ms + 6ms) / 3 = 2ms

Essa tabela visualiza de forma clara a ordem dos processos, seus tempos de chegada, execução e espera, facilitando a compreensão dos cálculos de tempo médio.
1. Calculando o Tempo Médio de Execução:
   - Tempo de Execução do Processo 1: 6ms
   - Tempo de Execução do Processo 2: 6ms (2ms de espera + 4ms de execução)
   - Tempo de Execução do Processo 3: 10ms (4ms de espera + 8ms de execução)
   - Tempo Médio de Execução = (6ms + 6ms + 10ms) / 3 = 22ms / 3 ≈ 7.33ms

2. Calculando o Tempo Médio de Espera:
   - Tempo de Espera do Processo 1: 0ms
   - Tempo de Espera do Processo 2: 0ms
   - Tempo de Espera do Processo 3: 2ms
   - Tempo Médio de Espera = (0ms + 0ms + 2ms) / 3 = 2ms / 3 ≈ 0.67ms

Esses cálculos nos dão uma ideia do desempenho do algoritmo de escalonamento em relação ao tempo médio que cada processo leva para ser executado e o tempo médio que eles passam aguardando na fila de prontos. Essas métricas são úteis para comparar diferentes algoritmos de escalonamento e avaliar sua eficácia em diferentes cenários.

---

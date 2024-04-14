# Cálculos

1. **Tempo Médio de Execução (Turnaround Time)**:
   - O tempo médio de execução é o tempo total que um processo leva desde sua chegada até sua conclusão, incluindo o tempo de espera na fila de prontos e o tempo de execução na CPU.
   - Para calcular o tempo médio de execução, somamos o tempo total de cada processo e dividimos pelo número total de processos.

2. **Tempo Médio de Espera (Waiting Time)**:
   - O tempo médio de espera é o tempo médio que um processo passa na fila de prontos aguardando sua vez de ser executado na CPU.
   - Para calcular o tempo médio de espera, subtraímos o tempo de execução de cada processo pelo seu tempo de chegada e somamos esses valores para todos os processos, dividindo pelo número total de processos.

Aqui está um exemplo simples para ilustrar como calcular o tempo médio de execução e o tempo médio de espera para um conjunto de processos:

Suponha que temos três processos com os seguintes atributos:
- Processo 1: Chegada em 0ms, Tempo de Execução de 6ms
- Processo 2: Chegada em 2ms, Tempo de Execução de 4ms
- Processo 3: Chegada em 4ms, Tempo de Execução de 8ms

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

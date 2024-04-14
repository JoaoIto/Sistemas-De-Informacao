Claro! Vamos detalhar como os cálculos são feitos para obter o tempo médio de execução e o tempo médio de espera para os processos.

1. **Tempo Médio de Execução (Turnaround Time)**:
   - O tempo médio de execução é calculado somando o tempo total de cada processo, desde sua chegada até sua conclusão (turnaround time), e dividindo pelo número total de processos.
   - Para cada processo, o turnaround time é calculado somando o tempo de chegada ao tempo de execução.
   - Após calcular o turnaround time para cada processo, o tempo médio de execução é obtido somando todos os turnaround times e dividindo pelo número total de processos.

   Fórmula:
   ***Tempo Médio de Execução = Time de cada processo/Número total de processos***

2. **Tempo Médio de Espera (Waiting Time)**:
   - O tempo médio de espera é calculado subtraindo o tempo de execução de cada processo pelo seu tempo de chegada, para obter o tempo que cada processo passou esperando na fila de prontos.
   - Após calcular o tempo de espera para cada processo, o tempo médio de espera é obtido somando todos os tempos de espera e dividindo pelo número total de processos.

   Fórmula:
   ***Tempo Médio de Espera = Tempo de Espera de cada processo / Número total de processos***


Vamos utilizar os mesmos processos do exemplo anterior:

| Processo | Chegada | Tempo de Execução |
|----------|---------|-------------------|
|    P1    |    0    |         6         |
|    P2    |    2    |         4         |
|    P3    |    4    |         8         |

- Calculando o Tempo Médio de Execução:
   - Turnaround Time de P1: 0ms (tempo de chegada) + 6ms (tempo de execução) = 6ms
   - Turnaround Time de P2: 2ms (tempo de chegada) + 4ms (tempo de execução) = 6ms
   - Turnaround Time de P3: 4ms (tempo de chegada) + 8ms (tempo de execução) = 12ms
   - Tempo Médio de Execução = (6ms + 6ms + 12ms) / 3 = 8ms

- Calculando o Tempo Médio de Espera:
   - Tempo de Espera de P1: 0ms (chegou primeiro)
   - Tempo de Espera de P2: 2ms (tempo de espera na fila de prontos)
   - Tempo de Espera de P3: 4ms (tempo de espera na fila de prontos)
   - Tempo Médio de Espera = (0ms + 2ms + 4ms) / 3 = 2ms

Esses cálculos nos fornecem uma medida do desempenho do algoritmo de escalonamento em termos de tempo médio que cada processo leva para ser executado e o tempo médio que eles passam aguardando na fila de prontos.

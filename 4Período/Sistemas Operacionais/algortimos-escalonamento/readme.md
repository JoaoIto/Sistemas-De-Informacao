# Algoritmos de Escalonamento

1. **FIFO (First-In First-Out) ou FCFS (First-Come First-Served)**:
   - Este é o algoritmo mais simples de escalonamento. Ele funciona atribuindo a CPU ao processo que chegou primeiro na fila de prontos. Portanto, o primeiro processo a entrar na fila é o primeiro a ser executado. Não considera a duração do processo, apenas a ordem de chegada.

2. **SJF (Shortest Job First) ou SPN (Shortest Process Next)**:
   - Este algoritmo atribui a CPU ao processo com o menor tempo de execução. Ele é ideal para minimizar o tempo médio de espera, pois processos mais curtos são executados primeiro. Isso ajuda a evitar o problema de inanição para processos mais longos.

3. **SRTF (Shortest Remaining Time First)**:
   - Este é uma variação dinâmica do SJF. Ele seleciona o próximo processo a ser executado com base no tempo restante de execução, não apenas na duração total do processo. Se um processo mais curto chega enquanto outro está sendo executado, o SRTF pode interromper a execução do processo atual para iniciar o novo processo.

4. **Round Robin (Rodízio)**:
   - Neste algoritmo, cada processo é executado por um pequeno intervalo de tempo chamado de "quantum". Após esse intervalo, o processo é colocado no final da fila de prontos e o próximo processo é executado. Isso continua até que todos os processos sejam concluídos.

5. **Priority (Prioridade)**:
   - Este algoritmo atribui a CPU ao processo com a prioridade mais alta. Cada processo é atribuído a uma prioridade e o escalonador escolhe o processo com a prioridade mais alta para execução. Se houver vários processos com a mesma prioridade, o escalonador pode usar outros critérios, como FCFS, para desempatar.

6. **Multiple queue (Múltiplas filas)**:
   - Este é um algoritmo que divide a fila de prontos em várias filas com diferentes prioridades. Cada fila tem seu próprio algoritmo de escalonamento (por exemplo, FCFS, SJF, etc.). Os processos são atribuídos a uma fila com base em sua prioridade e o escalonador seleciona a fila com maior prioridade para execução. Isso permite uma gestão mais eficiente de processos com diferentes requisitos de tempo.
  
   - ---
   

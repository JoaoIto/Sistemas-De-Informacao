# Exercício de Roudin Robin

A atividade proposta consiste em implementar algum dos algoritmos de escalonamento estudados (SJF,
Round Robin, Prioridade Cooperativo, Prioridade Preemptivo). Será sorteado qual algoritmo cada aluno irá
implementar. Para esse programa, os dados dos processos deverão ser gerados aleatoriamente.
Informações relacionadas à prioridade dos processos e o seu quantum podem ser gerados apenas quando
for necessário. Esse algoritmo deverá solicitar ao usuário a quantidade de processos que serão criados. 

- Para a geração dos processos, considere os seguintes valores:

| PID | Arrival Time (AT) | Burst Time (BT) | Prioridade | Quantum |
|-----|-------------------|------------------|------------|---------|
| 1   | 1-30              | 0-15             | 1-25       | 1-5     |
| 2   |                   |                  |            | 4-10    |

Esses são os intervalos permitidos para os valores dos campos PID, Arrival Time, Burst Time, Prioridade e Quantum, conforme indicado na descrição da atividade.


## Implementação base

Para implementar o algoritmo de Round Robin em Java, você pode seguir o seguinte passo a passo:

1. **Criação da classe Processo**: Defina uma classe `Processo` com os atributos PID, Arrival Time, Burst Time, Prioridade e Quantum.

2. **Geração aleatória dos processos**: Utilize a classe `Random` para gerar os valores aleatórios para os processos de acordo com os intervalos especificados.

3. **Implementação do Round Robin**: Crie uma classe principal que simule o algoritmo de Round Robin. Nessa implementação, você precisará de uma fila para armazenar os processos prontos para execução, um contador de tempo para simular o tempo do sistema e um loop para simular a execução dos processos.

4. **Lógica de escalonamento**: No algoritmo Round Robin, os processos são executados por um quantum de tempo e, se não terminarem, são colocados novamente na fila de espera. Você precisará de uma estrutura de repetição para iterar sobre a fila de processos prontos, executando-os em turnos de quantum.

5. **Saída do programa**: Ao final da execução, o programa deve imprimir as informações dos processos gerados e a sequência em que foram escalonados.

Aqui está um exemplo de como poderia ser a implementação em Java:

```java
import java.util.*;

class Processo {
    int PID;
    int arrivalTime;
    int burstTime;
    int prioridade;
    int quantum;

    // Construtor da classe Processo
    public Processo(int PID, int arrivalTime, int burstTime, int prioridade, int quantum) {
        this.PID = PID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.prioridade = prioridade;
        this.quantum = quantum;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Solicita ao usuário a quantidade de processos
        System.out.print("Digite a quantidade de processos: ");
        int numProcessos = scanner.nextInt();

        // Lista para armazenar os processos gerados
        List<Processo> processos = new ArrayList<>();

        // Gerar processos aleatórios
        for (int i = 0; i < numProcessos; i++) {
            int PID = i + 1;
            int arrivalTime = random.nextInt(16); // Tempo de chegada aleatório entre 0 e 15
            int burstTime = random.nextInt(25) + 1; // Tempo de execução aleatório entre 1 e 25
            int prioridade = random.nextInt(5) + 1; // Prioridade aleatória entre 1 e 5
            int quantum = random.nextInt(7) + 4; // Quantum aleatório entre 4 e 10

            // Cria um novo processo com os valores aleatórios gerados
            Processo processo = new Processo(PID, arrivalTime, burstTime, prioridade, quantum);
            processos.add(processo); // Adiciona o processo à lista de processos
        }

        // Exibir informações dos processos gerados
        System.out.println("\nInformações dos processos gerados:");
        for (Processo processo : processos) {
            System.out.println("PID: " + processo.PID + " | Arrival Time: " + processo.arrivalTime +
                    " | Burst Time: " + processo.burstTime + " | Prioridade: " + processo.prioridade +
                    " | Quantum: " + processo.quantum);
        }

        // Simular escalonamento Round Robin
        System.out.println("\nSequência de escalonamento (Round Robin):");
        int tempo = 0; // Tempo do sistema
        Queue<Processo> fila = new LinkedList<>(); // Fila de processos prontos para execução

        // Enquanto houver processos na lista ou na fila
        while (!processos.isEmpty() || !fila.isEmpty()) {
            // Verifica se algum processo chegou no tempo atual e o adiciona na fila
            for (Processo processo : processos) {
                if (processo.arrivalTime == tempo) {
                    fila.add(processo);
                }
            }

            // Se houver processo na fila pronto para execução
            if (!fila.isEmpty()) {
                // Executa o próximo processo da fila
                Processo processoAtual = fila.poll();
                System.out.println("Tempo " + tempo + ": Executando processo PID " + processoAtual.PID);
                processoAtual.burstTime -= processoAtual.quantum; // Reduz o burst time pelo quantum

                // Se o processo ainda não terminou
                if (processoAtual.burstTime > 0) {
                    processoAtual.arrivalTime = tempo + processoAtual.quantum; // Atualiza o tempo de chegada do processo
                    fila.add(processoAtual); // Adiciona o processo de volta à fila
                } else {
                    // Se o processo terminou, remove-o da lista de processos
                    System.out.println("Tempo " + tempo + ": Processo PID " + processoAtual.PID + " finalizado");
                    processos.remove(processoAtual);
                }
            } else {
                // Se não houver processo pronto para execução
                System.out.println("Tempo " + tempo + ": Nenhum processo pronto para execução");
            }

            tempo++; // Avança o tempo do sistema
        }

        scanner.close(); // Fecha o scanner
    }
}
```

---

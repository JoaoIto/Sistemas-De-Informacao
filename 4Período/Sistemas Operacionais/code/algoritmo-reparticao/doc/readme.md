# Explicação do Código de Simulação de Alocação de Memória

Este código implementa um simulador de alocação de memória usando três algoritmos diferentes: First-Fit, Best-Fit e Worst-Fit. O simulador gera partições de memória e processos com tamanhos aleatórios e tenta alocar os processos nas partições usando cada um dos algoritmos. Abaixo está uma explicação detalhada de cada parte do código.

## Definição das Classes de Partição e Processo

### Classe `Particao`

```java
class Particao {
    int tamanho;
    int processoID;
    int fragmentacao;

    public Particao(int tamanho) {
        this.tamanho = tamanho; 
        this.processoID = -1;  // -1 indica que a partição está livre
        this.fragmentacao = 0;
    }

    @Override
    public String toString() {
        return "Partição{" +
                "tamanho=" + tamanho +
                ", processoID=" + processoID +
                ", fragmentacao=" + fragmentacao +
                '}';
    }
}
```

- `int tamanho;`: Armazena o tamanho da partição.
- `int processoID;`: Armazena o ID do processo alocado na partição. `-1` indica que a partição está livre.
- `int fragmentacao;`: Armazena o valor da fragmentação interna da partição.
- Construtor `Particao(int tamanho)`: Inicializa o tamanho da partição e define o processo como `-1` e a fragmentação como `0`.
- Método `toString()`: Retorna uma string representando a partição, incluindo seu tamanho, ID do processo e fragmentação.

### Classe `Processo`

```java
class Processo {
    int id;
    int tamanho;

    public Processo(int id, int tamanho) {
        this.id = id;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", tamanho=" + tamanho +
                '}';
    }
}
```

- `int id;`: Armazena o ID do processo.
- `int tamanho;`: Armazena o tamanho do processo.
- Construtor `Processo(int id, int tamanho)`: Inicializa o ID e o tamanho do processo.
- Método `toString()`: Retorna uma string representando o processo, incluindo seu ID e tamanho.

## Métodos de Alocação

### Classe `AlocadorMemoria`

#### Método `firstFit`

```java
public void firstFit(List<Particao> particoes, List<Processo> processos) {
    for (Processo processo : processos) {
        for (Particao particao : particoes) {
            if (particao.processoID == -1 && particao.tamanho >= processo.tamanho) {
                particao.processoID = processo.id;
                particao.fragmentacao = particao.tamanho - processo.tamanho;
                break;
            }
        }
    }
}
```

- Itera sobre cada processo na lista de processos.
- Para cada processo, verifica cada partição na lista de partições.
- Se a partição estiver livre (`processoID == -1`) e for suficientemente grande (`tamanho >= processo.tamanho`), aloca o processo na partição.
- Calcula e armazena a fragmentação interna (`fragmentacao = particao.tamanho - processo.tamanho`).
- Interrompe a busca de partições após encontrar a primeira partição adequada (First-Fit).

#### Método `bestFit`

```java
public void bestFit(List<Particao> particoes, List<Processo> processos) {
    for (Processo processo : processos) {
        Particao melhorParticao = null;
        for (Particao particao : particoes) {
            if (particao.processoID == -1 && particao.tamanho >= processo.tamanho) {
                if (melhorParticao == null || particao.tamanho < melhorParticao.tamanho) {
                    melhorParticao = particao;
                }
            }
        }
        if (melhorParticao != null) {
            melhorParticao.processoID = processo.id;
            melhorParticao.fragmentacao = melhorParticao.tamanho - processo.tamanho;
        }
    }
}
```

- Itera sobre cada processo na lista de processos.
- Para cada processo, procura a partição livre mais adequada (menor partição suficientemente grande).
- Armazena a referência para a melhor partição encontrada.
- Se encontrar uma partição adequada, aloca o processo na melhor partição e calcula a fragmentação interna.

#### Método `worstFit`

```java
public void worstFit(List<Particao> particoes, List<Processo> processos) {
    for (Processo processo : processos) {
        Particao piorParticao = null;
        for (Particao particao : particoes) {
            if (particao.processoID == -1 && particao.tamanho >= processo.tamanho) {
                if (piorParticao == null || particao.tamanho > piorParticao.tamanho) {
                    piorParticao = particao;
                }
            }
        }
        if (piorParticao != null) {
            piorParticao.processoID = processo.id;
            piorParticao.fragmentacao = piorParticao.tamanho - processo.tamanho;
        }
    }
}
```

- Itera sobre cada processo na lista de processos.
- Para cada processo, procura a partição livre maior (maior partição suficientemente grande).
- Armazena a referência para a pior partição encontrada.
- Se encontrar uma partição adequada, aloca o processo na pior partição e calcula a fragmentação interna.

## Simulação e Execução

### Classe `Main`

```java
public class Main {
    public static void main(String[] args) {
        int numParticoes = 10;
        int numProcessos = 5;

        List<Particao> particoes = new ArrayList<>();
        List<Processo> processos = new ArrayList<>();
        Random random = new Random();

        // Gerando partições com tamanhos aleatórios entre 100 e 600
        for (int i = 0; i < numParticoes; i++) {
            int tamanho = 100 + random.nextInt(501); // (100 a 600)
            particoes.add(new Particao(tamanho));
        }

        // Gerando processos com tamanhos aleatórios entre 100 e 500
        for (int i = 0; i < numProcessos; i++) {
            int tamanho = 100 + random.nextInt(401); // (100 a 500)
            processos.add(new Processo(i, tamanho));
        }

        AlocadorMemoria alocador = new AlocadorMemoria();

        // Copiando listas para não alterar as originais ao usar diferentes métodos de alocação
        List<Particao> particoesFirstFit = new ArrayList<>(particoes);
        List<Particao> particoesBestFit = new ArrayList<>(particoes);
        List<Particao> particoesWorstFit = new ArrayList<>(particoes);

        // First-fit
        System.out.println("First-Fit:");
        alocador.firstFit(particoesFirstFit, processos);
        for (Particao particao : particoesFirstFit) {
            System.out.println(particao);
        }

        // Best-fit
        System.out.println("\nBest-Fit:");
        alocador.bestFit(particoesBestFit, processos);
        for (Particao particao : particoesBestFit) {
            System.out.println(particao);
        }

        // Worst-fit
        System.out.println("\nWorst-Fit:");
        alocador.worstFit(particoesWorstFit, processos);
        for (Particao particao : particoesWorstFit) {
            System.out.println(particao);
        }
    }
}
```

- `int numParticoes = 10;`: Define o número de partições.
- `int numProcessos = 5;`: Define o número de processos.
- `List<Particao> particoes = new ArrayList<>();`: Cria uma lista de partições.
- `List<Processo> processos = new ArrayList<>();`: Cria uma lista de processos.
- `Random random = new Random();`: Cria um gerador de números aleatórios.
- Gera partições com tamanhos aleatórios entre 100 e 600 e adiciona à lista de partições.
- Gera processos com tamanhos aleatórios entre 100 e 500 e adiciona à lista de processos.
- Cria uma instância de `AlocadorMemoria`.
- Cria cópias das listas de partições para uso nos diferentes algoritmos de alocação.
- Executa o algoritmo `First-Fit` e imprime o estado das partições após a alocação.
- Executa o algoritmo `Best-Fit` e imprime o estado das partições após a alocação.
- Executa o algoritmo `Worst-Fit` e imprime o estado das partições após a alocação.

---

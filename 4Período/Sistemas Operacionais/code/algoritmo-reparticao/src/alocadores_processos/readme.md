# Como funcionam os códigos?

### Método `firstFit`

#### Explicação

- **Objetivo**: Alocar cada processo na primeira partição livre que seja grande o suficiente.
- **Funcionamento**:
    1. **Iteração sobre processos**: O algoritmo percorre a lista de processos, um por um.
    2. **Verificação de partição livre**: Para cada processo, o algoritmo percorre a lista de partições e verifica se a partição está livre e se é suficientemente grande.
    3. **Alocação do processo**: Quando encontra uma partição adequada, o processo é alocado nessa partição.
    4. **Cálculo da fragmentação**: A fragmentação interna é calculada como a diferença entre o tamanho da partição e o tamanho do processo.
    5. **Interrupção da busca**: O loop de partições é interrompido após a alocação, passando para o próximo processo.

### Método `bestFit`

#### Explicação

- **Objetivo**: Alocar cada processo na partição livre mais adequada, ou seja, na menor partição que seja suficientemente grande.
- **Funcionamento**:
    1. **Iteração sobre processos**: O algoritmo percorre a lista de processos, um por um.
    2. **Seleção da melhor partição**: Para cada processo, o algoritmo percorre a lista de partições, procurando a partição mais adequada (menor possível que ainda acomoda o processo).
    3. **Alocação do processo**: Se uma partição adequada é encontrada, o processo é alocado nessa partição.
    4. **Cálculo da fragmentação**: A fragmentação interna é calculada como a diferença entre o tamanho da partição e o tamanho do processo.

### Método `worstFit`

#### Explicação

- **Objetivo**: Alocar cada processo na maior partição livre disponível.
- **Funcionamento**:
    1. **Iteração sobre processos**: O algoritmo percorre a lista de processos, um por um.
    2. **Seleção da pior partição**: Para cada processo, o algoritmo percorre a lista de partições, procurando a maior partição que ainda acomoda o processo.
    3. **Alocação do processo**: Se uma partição adequada é encontrada, o processo é alocado nessa partição.
    4. **Cálculo da fragmentação**: A fragmentação interna é calculada como a diferença entre o tamanho da partição e o tamanho do processo.

## Exemplo in code:
### Método `firstFit`
```java
public void firstFit(List<Particao> particoes, List<Processo> processos) {
    // Itera sobre cada processo na lista de processos.
    for (Processo processo : processos) {
        // Itera sobre cada partição na lista de partições.
        for (Particao particao : particoes) {
            // Verifica se a partição está livre (processoID == -1) e se a partição pode acomodar o processo.
            if (particao.processoID == -1 && particao.tamanho >= processo.tamanho) {
                // Aloca o processo na partição.
                particao.processoID = processo.id;
                // Calcula a fragmentação interna.
                particao.fragmentacao = particao.tamanho - processo.tamanho;
                // Sai do loop interno, já que a alocação foi feita.
                break;
            }
        }
    }
}
```

#### Exemplo `firstFit`

- Partições: [300, 500, 200]
- Processos: [ID:1, Tamanho:150], [ID:2, Tamanho:450], [ID:3, Tamanho:100]

1. Processo 1 (150):
    - Partição 1 (300): suficiente, aloca Processo 1, fragmentação 150.
2. Processo 2 (450):
    - Partição 1 (300): insuficiente.
    - Partição 2 (500): suficiente, aloca Processo 2, fragmentação 50.
3. Processo 3 (100):
    - Partição 1 (300): insuficiente (já está alocada).
    - Partição 2 (500): insuficiente (já está alocada).
    - Partição 3 (200): suficiente, aloca Processo 3, fragmentação 100.

### Método `bestFit`

```java
public void bestFit(List<Particao> particoes, List<Processo> processos) {
    // Itera sobre cada processo na lista de processos.
    for (Processo processo : processos) {
        Particao melhorParticao = null;
        // Itera sobre cada partição na lista de partições.
        for (Particao particao : particoes) {
            // Verifica se a partição está livre e se pode acomodar o processo.
            if (particao.processoID == -1 && particao.tamanho >= processo.tamanho) {
                // Verifica se é a melhor (menor) partição até agora.
                if (melhorParticao == null || particao.tamanho < melhorParticao.tamanho) {
                    melhorParticao = particao;
                }
            }
        }
        // Se uma partição adequada foi encontrada, aloca o processo.
        if (melhorParticao != null) {
            melhorParticao.processoID = processo.id;
            melhorParticao.fragmentacao = melhorParticao.tamanho - processo.tamanho;
        }
    }
}
```

#### Exemplo `bestFit`

- Partições: [300, 500, 200]
- Processos: [ID:1, Tamanho:150], [ID:2, Tamanho:450], [ID:3, Tamanho:100]

1. Processo 1 (150):
    - Partição 1 (300): possível.
    - Partição 2 (500): possível.
    - Partição 3 (200): melhor escolha, aloca Processo 1, fragmentação 50.
2. Processo 2 (450):
    - Partição 1 (300): insuficiente.
    - Partição 2 (500): melhor escolha, aloca Processo 2, fragmentação 50.
3. Processo 3 (100):
    - Partição 1 (300): melhor escolha (única opção restante), aloca Processo 3, fragmentação 200.

### Método `worstFit`

```java
public void worstFit(List<Particao> particoes, List<Processo> processos) {
    // Itera sobre cada processo na lista de processos.
    for (Processo processo : processos) {
        Particao piorParticao = null;
        // Itera sobre cada partição na lista de partições.
        for (Particao particao : particoes) {
            // Verifica se a partição está livre e se pode acomodar o processo.
            if (particao.processoID == -1 && particao.tamanho >= processo.tamanho) {
                // Verifica se é a pior (maior) partição até agora.
                if (piorParticao == null || particao.tamanho > piorParticao.tamanho) {
                    piorParticao = particao;
                }
            }
        }
        // Se uma partição adequada foi encontrada, aloca o processo.
        if (piorParticao != null) {
            piorParticao.processoID = processo.id;
            piorParticao.fragmentacao = piorParticao.tamanho - processo.tamanho;
        }
    }
}
```

#### Exemplo `worstFit`

- Partições: [300, 500, 200]
- Processos: [ID:1, Tamanho:150], [ID:2, Tamanho:450], [ID:3, Tamanho:100]

1. Processo 1 (150):
    - Partição 1 (300): possível.
    - Partição 2 (500): pior escolha, aloca Processo 1, fragmentação 350.
2. Processo 2 (450):
    - Partição 1 (300): insuficiente.
    - Partição 2 (500): insuficiente (já está alocada).
    - Partição 3 (200): insuficiente.
3. Processo 3 (100):
    - Partição 1 (300): possível.
    - Partição 3 (200): pior escolha, aloca Processo 3, fragmentação 100.

### Explicação do Fluxo do Código

1. **Importações e Definição da Classe**

```java
package src.alocadores_processos;

import src.Particao;
import src.Processo;

import java.util.List;
```
- Importa as classes `Particao` e `Processo` do pacote `src`.
- Importa a classe `List` da biblioteca Java.

2. **Classe `AlocadorMemoria`**

```java
public class AlocadorMemoria {
```
- Define a classe `AlocadorMemoria` que contém os métodos de alocação de memória.

3. **Método `firstFit`**

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
- Itera sobre cada processo e partição, alocando o processo na primeira partição suficiente encontrada.

4. **Método `bestFit`**

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
- Itera sobre cada processo, procurando a menor partição suficiente para alocá-lo.

5. **Método `worstFit`**

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
}
```
- Itera sobre cada processo, procurando a maior partição suficiente para alocá-lo.

Cada método de alocação implementa uma estratégia diferente para alocar processos em partições, afetando a eficiência da alocação e a quantidade de fragmentação interna.

---
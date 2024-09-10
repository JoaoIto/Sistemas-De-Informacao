# Questões de algoritmos de gerenciamento

**1. Considere um sistema cuja gerência de memória é feita através de partições variáveis. Nesse momento, existem as seguintes lacunas: 10k, 4k, 20k, 18k, 7k, 9k, 12k e 13k, nessa ordem. Quais espaços serão ocupados pelas solicitações: 5k, 10k e 6k, nessa ordem, se:**

- **Usando First-Fit**
- **Usando Next-Fit**
- **Usando Best-Fit**
- **Usando Worst-Fit**

### Tabelas de Alocação

#### First-Fit

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 5k          | 5k      | 10k                  | 5k                   |
| 10k         | 10k     | 5k, 4k, 20k          | 10k                  |
| 6k          | 6k      | 5k, 4k, 10k, 18k     | 18k (resta 12k)      |

#### Next-Fit

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 5k          | 5k      | 10k                  | 5k                   |
| 10k         | 10k     | 5k, 4k, 20k          | 10k                  |
| 6k          | 6k      | 5k, 4k, 10k, 18k     | 18k (resta 12k)      |

#### Best-Fit

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 5k          | 5k      | 7k                  | 2k                   |
| 10k         | 10k     | 10k                 | 0k                   |
| 6k          | 6k      | 9k                  | 3k                   |

#### Worst-Fit

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 5k          | 5k      | 20k                 | 15k                  |
| 10k         | 10k     | 15k                 | 5k                   |
| 6k          | 6k      | 18k                 | 12k                  |

---

**2. Considere um sistema cuja gerência de memória é feita através de partições variáveis. Nesse momento, existem as seguintes lacunas: 8k, 5k, 15k, 10k, 9k, 7k, 11k, 6k, nessa ordem. Quais espaços serão ocupados pelas solicitações: 4k, 8k e 6k, nessa ordem, se:**

- **Usando First-Fit**
- **Usando Next-Fit**
- **Usando Best-Fit**
- **Usando Worst-Fit**

### Tabelas de Alocação

#### First-Fit

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 4k          | 4k      | 8k                   | 4k                   |
| 8k          | 8k      | 4k, 5k, 15k          | 15k (resta 7k)       |
| 6k          | 6k      | 4k, 5k, 7k, 10k      | 10k (resta 4k)       |

#### Next-Fit

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 4k          | 4k      | 8k                   | 4k                   |
| 8k          | 8k      | 4k, 5k, 15k          | 15k (resta 7k)       |
| 6k          | 6k      | 4k, 5k, 7k, 10k      | 10k (resta 4k)       |

#### Best-Fit

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 4k          | 4k      | 5k                   | 1k                   |
| 8k          | 8k      | 8k                   | 0k                   |
| 6k          | 6k      | 7k                   | 1k                   |

#### Worst-Fit

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 4k          | 4k      | 15k                  | 11k                  |
| 8k          | 8k      | 11k                  | 3k                   |
| 6k          | 6k      | 10k                  | 4k                   |

---

Essas tabelas ilustram como diferentes algoritmos de alocação de memória gerenciam as lacunas disponíveis em um sistema de partições variáveis. Cada algoritmo tem suas próprias regras para selecionar a lacuna a ser usada, o que afeta o desempenho e a eficiência do sistema.

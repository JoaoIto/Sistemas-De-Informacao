# Explicação 

Vamos explicar detalhadamente como o endereçamento é feito para cada algoritmo usando a tabela do novo conjunto de lacunas e solicitações. 

## Lacunas e Solicitações
**Lacunas:** 8k, 5k, 15k, 10k, 9k, 7k, 11k, 6k (nessa ordem)
**Solicitações:** 4k, 8k, 6k (nessa ordem)

### First-Fit

**Algoritmo:** Aloca a primeira lacuna que seja suficientemente grande para a solicitação.

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 4k          | 4k      | 8k                   | 4k (8k - 4k)         |
| 8k          | 8k      | 4k, 5k, 15k          | 7k (15k - 8k)        |
| 6k          | 6k      | 4k, 5k, 7k, 10k      | 4k (10k - 6k)        |

**Passo a Passo:**
1. **4k:** A primeira lacuna que pode acomodar 4k é a de 8k. Após alocar 4k, resta uma lacuna de 4k.
2. **8k:** A próxima lacuna que pode acomodar 8k é a de 15k. Após alocar 8k, resta uma lacuna de 7k.
3. **6k:** A primeira lacuna disponível que pode acomodar 6k é a de 10k. Após alocar 6k, resta uma lacuna de 4k.

### Next-Fit

**Algoritmo:** Aloca a próxima lacuna disponível que seja suficientemente grande, começando de onde parou na última alocação.

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 4k          | 4k      | 8k                   | 4k (8k - 4k)         |
| 8k          | 8k      | 4k, 5k, 15k          | 7k (15k - 8k)        |
| 6k          | 6k      | 4k, 5k, 7k, 10k      | 4k (10k - 6k)        |

**Passo a Passo:**
1. **4k:** A primeira lacuna que pode acomodar 4k é a de 8k. Após alocar 4k, resta uma lacuna de 4k.
2. **8k:** A próxima lacuna que pode acomodar 8k é a de 15k. Após alocar 8k, resta uma lacuna de 7k.
3. **6k:** A primeira lacuna disponível que pode acomodar 6k é a de 10k. Após alocar 6k, resta uma lacuna de 4k.

### Best-Fit

**Algoritmo:** Aloca a menor lacuna que seja suficientemente grande para a solicitação.

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 4k          | 4k      | 5k                   | 1k (5k - 4k)         |
| 8k          | 8k      | 8k                   | 0k (8k - 8k)         |
| 6k          | 6k      | 7k                   | 1k (7k - 6k)         |

**Passo a Passo:**
1. **4k:** A menor lacuna que pode acomodar 4k é a de 5k. Após alocar 4k, resta uma lacuna de 1k.
2. **8k:** A menor lacuna que pode acomodar 8k é a de 8k. Após alocar 8k, não resta lacuna.
3. **6k:** A menor lacuna disponível que pode acomodar 6k é a de 7k. Após alocar 6k, resta uma lacuna de 1k.

### Worst-Fit

**Algoritmo:** Aloca a maior lacuna disponível.

| Solicitação | Tamanho | Lacuna Inicialmente | Lacuna Após Alocação |
|-------------|---------|----------------------|----------------------|
| 4k          | 4k      | 15k                  | 11k (15k - 4k)       |
| 8k          | 8k      | 11k                  | 3k (11k - 8k)        |
| 6k          | 6k      | 10k                  | 4k (10k - 6k)        |

**Passo a Passo:**
1. **4k:** A maior lacuna que pode acomodar 4k é a de 15k. Após alocar 4k, resta uma lacuna de 11k.
2. **8k:** A maior lacuna que pode acomodar 8k é a de 11k. Após alocar 8k, resta uma lacuna de 3k.
3. **6k:** A maior lacuna disponível que pode acomodar 6k é a de 10k. Após alocar 6k, resta uma lacuna de 4k.

---

## Explicação Detalhada da Tabela para o Algoritmo First-Fit

**Passo a Passo:**

1. **Primeira Solicitação: 4k**
   - Lacunas disponíveis: 8k, 5k, 15k, 10k, 9k, 7k, 11k, 6k.
   - A primeira lacuna suficientemente grande é a de 8k.
   - Aloca-se 4k na lacuna de 8k.
   - Lacunas após alocação: 4k, 5k, 15k, 10k, 9k, 7k, 11k, 6k.

2. **Segunda Solicitação: 8k**
   - Lacunas disponíveis: 4k, 5k, 15k, 10k, 9k, 7k, 11k, 6k.
   - A primeira lacuna suficientemente grande é a de 15k.
   - Aloca-se 8k na lacuna de 15k.
   - Lacunas após alocação: 4k, 5k, 7k (15k - 8k), 10k, 9k, 7k, 11k, 6k.

3. **Terceira Solicitação: 6k**
   - Lacunas disponíveis: 4k, 5k, 7k, 10k, 9k, 7k, 11k, 6k.
   - A primeira lacuna suficientemente grande é a de 10k.
   - Aloca-se 6k na lacuna de 10k.
   - Lacunas após alocação: 4k, 5k, 7k, 4k (10k - 6k), 9k, 7k, 11k, 6k.

**Resumo Final para First-Fit:**
- As solicitações 4k, 8k e 6k foram alocadas nas lacunas de 8k, 15k e 10k, respectivamente.
- Após as alocações, as lacunas restantes são: 4k, 5k, 7k, 4k, 9k, 7k, 11k, 6k.

Essa abordagem mostra como o algoritmo First-Fit lida com as solicitações de memória e como escolhe a primeira lacuna disponível que é suficientemente grande para cada solicitação.

### Questão 1
#### a) Gráfico de uso da memória com particionamento Buddy

Para representar o uso da memória, primeiro dividimos a memória de 4 GB em blocos de potência de 2.

- Memória total: 4 GB (4096 MB)

Solicitações:
- A: 130 MB
- B: 750 MB
- C: 600 MB
- D: 300 MB
- E: 230 MB

**Particionamento Buddy:**
- Divide a memória em blocos de tamanho de potência de 2.
- Aloca o menor bloco de potência de 2 que pode conter o tamanho da solicitação.

**Alocação das solicitações:**
1. **A (130 MB):** Bloco mínimo de 256 MB (128 MB é muito pequeno, precisa do próximo maior).
2. **B (750 MB):** Bloco mínimo de 1024 MB (512 MB é muito pequeno, precisa do próximo maior).
3. **C (600 MB):** Bloco mínimo de 1024 MB (512 MB é muito pequeno, precisa do próximo maior).
4. **D (300 MB):** Bloco mínimo de 512 MB (256 MB é muito pequeno, precisa do próximo maior).
5. **E (230 MB):** Bloco mínimo de 256 MB (128 MB é muito pequeno, precisa do próximo maior).

**Gráfico de uso da memória:**

```
| 4096 MB (Total)                     |
|-------------------------------------|
| 2048 MB  | 2048 MB                  |
|--------- | -------------------------|
| B (1024) | C (1024) | D (512) | A (256) | E (256) | Livre (0)
```

#### b) É possível no particionamento Buddy haver fragmentação externa?

Sim, é possível haver fragmentação externa no particionamento Buddy. Isso ocorre porque os blocos de memória são divididos em tamanhos fixos de potência de 2, e quando uma solicitação de memória não preenche exatamente um desses blocos, o espaço restante dentro desse bloco fica inutilizado, resultando em fragmentação externa.

#### c) Onde seria carregado o processo X (240 MB)?

Para alocar 240 MB, precisamos de um bloco de 256 MB, o mesmo tamanho que foi usado para alocar a solicitação E (230 MB). Portanto, se houver um bloco de 256 MB disponível, ele seria alocado ali.

### Questão 2
#### Como executar o programa usando overlay

- Memória total: 64 KB
- Sistema operacional: 14 KB
- Memória disponível para programas: 64 KB - 14 KB = 50 KB

Programa de 80 KB, dividido em:
- Módulo principal: 20 KB
- Módulos independentes: 10 KB, 20 KB, 30 KB

**Técnica de overlay:**
- O módulo principal e um módulo independente são carregados na memória principal de cada vez.

**Exemplo de execução:**
1. Carregar o módulo principal (20 KB) + módulo de 10 KB na memória (30 KB no total).
2. Executar o módulo principal, depois carregar o próximo módulo.
3. Descarregar o módulo de 10 KB e carregar o módulo de 20 KB (módulo principal + 20 KB).
4. Descarregar o módulo de 20 KB e carregar o módulo de 30 KB (módulo principal + 30 KB).

### Questão 3
#### Memória virtual com paginação

- Tamanho do programa: 8 KB
- Memória física: 3 KB
- Tamanho dos quadros: 1 KB

**String de referência:** 5, 2, 3, 5, 2, 5, 1, 5, 4, 2, 3, 2, 1, 3, 2, 3

**a) LRU (Least Recently Used)**

1. Carrega página 5.
2. Carrega página 2.
3. Carrega página 3.
4. Página 5 já está na memória.
5. Página 2 já está na memória.
6. Página 5 já está na memória.
7. Página 1 substitui a página 3 (LRU).
8. Página 5 substitui a página 2 (LRU).
9. Página 4 substitui a página 1 (LRU).
10. Página 2 substitui a página 5 (LRU).
11. Página 3 substitui a página 4 (LRU).
12. Página 2 já está na memória.
13. Página 1 substitui a página 3 (LRU).
14. Página 3 substitui a página 2 (LRU).
15. Página 2 substitui a página 1 (LRU).
16. Página 3 já está na memória.

**Páginas na memória após cada referência (LRU):**
```
5
5, 2
5, 2, 3
5, 2, 3
5, 2, 3
5, 2, 3
5, 1, 3
5, 1, 3
4, 1, 3
4, 1, 2
4, 1, 2
4, 1, 2
4, 1, 2
4, 1, 2
4, 1, 2
```

**b) FIFO (First In, First Out)**

1. Carrega página 5.
2. Carrega página 2.
3. Carrega página 3.
4. Página 5 já está na memória.
5. Página 2 já está na memória.
6. Página 5 já está na memória.
7. Página 1 substitui a página 5 (FIFO).
8. Página 5 substitui a página 2 (FIFO).
9. Página 4 substitui a página 3 (FIFO).
10. Página 2 substitui a página 1 (FIFO).
11. Página 3 substitui a página 5 (FIFO).
12. Página 2 já está na memória.
13. Página 1 substitui a página 4 (FIFO).
14. Página 3 substitui a página 2 (FIFO).
15. Página 2 substitui a página 1 (FIFO).
16. Página 3 já está na memória.

**Páginas na memória após cada referência (FIFO):**
```
5
5, 2
5, 2, 3
5, 2, 3
5, 2, 3
5, 2, 3
1, 2, 3
1, 5, 3
1, 5, 4
2, 5, 4
2, 3, 4
2, 3, 4
2, 3, 4
1, 3, 4
1, 2, 4
1, 2, 4
```

**Melhor política para essas referências:**

A política LRU é melhor para estas referências porque substitui a página que não foi usada por mais tempo, resultando em menos substituições desnecessárias em comparação com FIFO, que substitui a página mais antiga independentemente do uso recente.

### Questão 4
#### Algoritmo de substituição

| Página | Tempo de carga | Última referência | Modificado | Referenciado |
|--------|----------------|-------------------|------------|--------------|
| 0      | 227            | 327               | 1          | 0            |
| 1      | 345            | 367               | 1          | 1            |
| 2      | 101            | 331               | 1          | 0            |
| 3      | 234            | 382               | 0          | 1            |

**LRU:** Substitui a página que não foi referenciada há mais tempo (Página 0).

**Segunda Chance:** Dá uma segunda chance às páginas referenciadas recentemente. Página 0 será substituída, pois é a primeira que não está referenciada.

**NRU:** Not Recently Used, substitui a página que não está referenciada e não modificada (Página 2).

### Questão 5
#### Vantagens de diferentes tamanhos de páginas

**a) 8Kbytes:**
- **Vantagens:** Menos entradas na tabela de páginas, menos page faults, melhor uso da TLB (Translation Lookaside Buffer).
- **Desvantagens:** Maior fragmentação interna, maior latência de transferência de páginas.

**b) 2Kbytes:**
- **Vantagens:** Menor fragmentação interna, melhor uso da memória para pequenos processos.
- **Desvantagens:** Mais entradas na tabela de páginas, mais page faults, menor uso da TLB.

### Questão 6
#### Algoritmo de substituição

| Página | Tempo de carga | Última referência | Modificado | Referenciado |
|--------|----------------|-------------------|------------|--------------|
| 3      | 126            | 279               | 0          | 0            |
| 5      | 230            | 260               | 1          | 0            |
| 9      | 120            | 271               | 1          | 1            |
| 7      | 160            | 280               | 1          | 1            |

**FIFO:** Substitui a página mais antiga (Página 3).

**

LRU:** Substitui a página menos recentemente usada (Página 5).

**Segunda Chance:** Dá uma segunda chance às páginas referenciadas recentemente. Página 3 será substituída.

**NRU:** Not Recently Used, substitui a página que não está referenciada e não modificada (Página 3).

### Questão 7
#### Algoritmo de substituição

| Página | Tempo de carga | Última referência | Modificado | Referenciado |
|--------|----------------|-------------------|------------|--------------|
| 7      | 100            | 231               | 0          | 1            |
| 8      | 112            | 233               | 1          | 1            |
| 5      | 187            | 230               | 1          | 0            |
| 10     | 200            | 232               | 0          | 1            |

**FIFO:** Substitui a página mais antiga (Página 7).

**LRU:** Substitui a página menos recentemente usada (Página 5).

**Segunda Chance:** Dá uma segunda chance às páginas referenciadas recentemente. Página 5 será substituída.

**NRU:** Not Recently Used, substitui a página que não está referenciada e não modificada (Página 5).

### Questão 8
#### Algoritmo de envelhecimento

Bits R nas interrupções:
1. 0111
2. 1011
3. 1010
4. 1101
5. 0010
6. 1010
7. 1100
8. 0001

**Contadores de 8 bits após cada interrupção:**

Inicialmente, todos os contadores são 0.

1. 00000001, 00000001, 00000001, 00000001 (para 0111)
2. 00000010, 00000011, 00000011, 00000011 (para 1011)
3. 00000101, 00000111, 00000110, 00000111 (para 1010)
4. 00001011, 00001111, 00001101, 00001111 (para 1101)
5. 00010110, 00011110, 00011010, 00011110 (para 0010)
6. 00101101, 00111100, 00110101, 00111100 (para 1010)
7. 01011011, 01111000, 01101011, 01111000 (para 1100)
8. 10110110, 11110000, 11010110, 11110001 (para 0001)

Os valores finais dos contadores após a última interrupção são:

- Página 0: 10110110
- Página 1: 11110000
- Página 2: 11010110
- Página 3: 11110001

---

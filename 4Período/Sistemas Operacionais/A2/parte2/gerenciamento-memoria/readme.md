## Gerenciamento de Memória: Resumo para Prova

**Introdução**

Este resumo apresenta os tópicos essenciais de gerenciamento de memória em sistemas operacionais, com base no conteúdo disponibilizado. A intenção é fornecer uma referência rápida e abrangente para se preparar para a prova de amanhã.

**Conceitos Básicos**

* **Tempo de acesso:** Tempo para iniciar uma transferência de dados de/para um meio de armazenamento.
* **Taxa de transferência:** Velocidade de leitura/escrita de dados em bytes por segundo.
* **Memória física:** Quantidade de RAM instalada em um computador.
* **Espaço de endereçamento:** Conjunto de endereços de memória que um processador pode gerar, independente da RAM disponível.
* **Barramento de endereços:** Define a quantidade de endereços que o processador pode gerar (ex: 32 vias para 4 GB, 48 vias para 256 TB).

**Memória Virtual**

* **Endereços físicos vs. lógicos:** Físicos são da memória real, lógicos são usados por processos.
* **MMU (Unidade de Gerência de Memória):** Traduz endereços lógicos em físicos.

**Gerenciamento de Memória**

* **Funções:** Isolamento de processos, alocação de RAM, swapping entre memória principal e disco, etc.
* **Classes de MMU:** Movem processos entre memórias ou os mantêm fixos na memória principal.

**Monoprogramação e Multiprogramação**

* **Monoprogramação:** Apenas um processo na memória.
* **Multiprogramação:** Vários processos na memória, melhor uso da CPU.

**Partições Fixas**

* **Divisão da memória em partições fixas:** Espaços não utilizados são perdidos.

**Realocação e Proteção**

* **Realocação:** Mapear endereços em tempo de execução.
* **Proteção:** Impedir acesso indevido entre processos.

**Swapping**

* **Conceito:** Mover processos entre memória principal e disco.
* **Problemas:** Fragmentação da memória.

**Gerenciamento de Espaços Livres**

* **Bit Map e Lista Encadeada:** Métodos para gerenciar espaços livres.
* **Algoritmos:** First Fit, Best Fit, Worst Fit, Quick Fit.

**Memória Virtual e Paginação**

* **Paginação:** Divide a memória em páginas.
* **Page Fault:** Interrupção quando uma página necessária não está na memória.

**Algoritmos de Substituição de Página**

* **FIFO, LRU, Segunda Chance, NRU, Envelhecimento:** Algoritmos para escolher páginas a serem substituídas, considerando uso recente e modificação.

**Trashing**

* **Conjunto de Trabalho:** Cada processo precisa de um conjunto de páginas na memória para execução eficiente.
* **Localidade de Referência:** Boa localidade resulta em conjuntos pequenos e estáveis. Má localidade implica conjuntos grandes e voláteis.
* **Memória Disponível:** Enquanto houver RAM suficiente para os conjuntos de trabalho dos processos ativos, o sistema opera sem problemas.
* **Problema de Thrashing:** Ocorre quando a soma dos conjuntos de trabalho excede a memória RAM disponível. Processos não conseguem carregar completamente suas páginas na memória, resultando em constantes faltas de páginas e suspensões.

**Segmentação**

* **Definição:** Divide programas e dados em segmentos lógicos com atributos de privilégio e proteção.
* **Visibilidade:** Geralmente visível ao programador, diferente da paginação que é invisível.
* **Compartilhamento e Proteção:** Facilita o compartilhamento de rotinas e dados com diferentes direitos de acesso.
* **Crescimento de Estruturas de Dados:** Simplifica o ajuste no tamanho de segmentos conforme necessário.
* **Problemas:** Fragmentação externa e complexidade nos algoritmos de substituição.

**Paginação vs. Segmentação**

| Característica | Paginaçã | Segmentação |
|---|---|---|
| Visibilidade | Invisível ao programador | Geralmente visível ao programador |
| Espaço de endereçamento | Linear | Múltiplos espaços de endereçamento |
| Fragmentação | Interna | Interna e externa |
| Implementação | Mais simples | Mais complexa |

**Segmentação com Paginação**

* **Combinação:** Resolve problemas de fragmentação externa da segmentação e interna da paginação.
* **Endereçamento:** Segmentos são divididos em páginas, com endereços formados pelo número do segmento, número da página e deslocamento.
* **Utilização Histórica:** Implementado em sistemas como Multics, antigos Unix, IBM OS/

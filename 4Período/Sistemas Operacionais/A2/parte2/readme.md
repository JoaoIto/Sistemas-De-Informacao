## A2: Resumo para Prova

**Introdução**

Este resumo apresenta os tópicos essenciais de gerenciamento de memória em sistemas operacionais, com foco em alocação de memória e thrashing. A intenção é fornecer uma referência rápida e abrangente para se preparar para a prova.

**Conceitos Básicos**

* **Memória física:** Quantidade de RAM instalada em um computador.
* **Espaço de endereçamento:** Conjunto de endereços de memória que um processador pode gerar.
* **Endereços físicos vs. lógicos:** Físicos são da memória real, lógicos são usados por processos.
* **MMU (Unidade de Gerência de Memória):** Traduz endereços lógicos em físicos.

**Gerenciamento de Memória**

* **Funções:** Isolamento de processos, alocação de RAM, swapping entre memória principal e disco, etc.
* **Classes de MMU:** Movem processos entre memórias ou os mantêm fixos na memória principal.

**Estratégias de Alocação de Memória**

* **First Fit:** Aloca o primeiro espaço livre encontrado com tamanho igual ou superior ao solicitado.
* **Best Fit:** Aloca o menor espaço livre com tamanho igual ou superior ao solicitado.
* **Worst Fit:** Aloca o maior espaço livre com tamanho igual ou superior ao solicitado.
* **Next Fit:** Inicia a busca a partir do último local de alocação, buscando o primeiro espaço livre com tamanho igual ou superior ao solicitado.
* **Quick Fit:** Mantém listas separadas por tamanho de espaço livre, buscando na lista correspondente ao tamanho solicitado.

**Thrashing**

* **Conjunto de Trabalho:** Cada processo precisa de um conjunto de páginas na memória para execução eficiente.
* **Localidade de Referência:** Boa localidade resulta em conjuntos pequenos e estáveis. Má localidade implica conjuntos grandes e voláteis.
* **Memória Disponível:** Enquanto houver RAM suficiente para os conjuntos de trabalho dos processos ativos, o sistema opera sem problemas.
* **Problema de Thrashing:** Ocorre quando a soma dos conjuntos de trabalho excede a memória RAM disponível. Processos não conseguem carregar completamente suas páginas na memória, resultando em constantes faltas de páginas e suspensões.

**Soluções para Thrashing**

* **Aumentar a Memória RAM:** Solução definitiva, mas nem sempre viável.
* **Algoritmos de Substituição de Página Aprimorados:** Considerar o histórico de uso e modificação das páginas para escolher quais serão substituídas.
* **Técnicas de Compactação de Memória:** Reduzir a fragmentação da memória, liberando espaço para alocação de novas páginas.
* **Limitar o Número de Processos:** Controlar o número de processos em execução para evitar a sobrecarga da memória.

**Considerações Finais**

* A escolha da estratégia de alocação de memória ideal depende dos requisitos específicos do sistema e das características dos processos.
* O thrashing é um problema sério que pode afetar significativamente o desempenho do sistema. É importante implementar técnicas para evitá-lo ou minimizá-lo.

---

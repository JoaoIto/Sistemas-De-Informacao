# Síntese Conceitual para a Apresentação e Trabalho

**Natureza: Determinístico vs. Estocástico**

* **LIFO é uma disciplina de atendimento da fila**, não um modelo por si só. Portanto, **ele é utilizado tanto em modelos determinísticos quanto estocásticos**.


* **No modelo determinístico ($D/D/1/\text{LIFO}$):** Os tempos de chegada e tempos de atendimento são constantes e pré-fixados. A ordem de saída é exatamente previsível e repetível a cada ciclo.


* **No modelo estocástico ($M/M/1/\text{LIFO}$ ou $G/G/1/\text{LIFO}$):** As chegadas e durações de atendimento são variáveis aleatórias com distribuições de probabilidade (médias e variâncias). Em simulação de eventos discretos, o contexto estocástico é o mais comum para refletir a aleatoriedade dos sistemas reais.


* **Comportamento Estocástico Chave:** Em uma fila $M/M/1$, a média de tempo de espera ($\bar{W}_q$) e o tamanho médio da fila ($L_q$) são matematicamente idênticos para FIFO e LIFO. No entanto, a **variância do tempo de espera** no LIFO é consideravelmente superior, o que significa alto risco de algumas entidades ficarem presas na base da pilha por tempos excessivamente longos (risco de *starvation*).



**Principais Vantagens em Simulação**

* Modela com precisão sistemas físicos onde o acesso ao recurso está restrito a uma única extremidade (ex.: gavetas, silos, contêineres).
* Reduz custos de movimentação mecânica em simulações logísticas, evitando a necessidade de desempilhar itens para alcançar os mais antigos.
* Prioriza requisições com dados mais recentes (*cache locality* ou processamento de pacotes urgentes mais recentes).

---

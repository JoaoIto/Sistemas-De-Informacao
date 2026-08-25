# Introdução

Este resumo técnico estrutura os conceitos e fundamentos da **Aula 1: Introdução à Simulação**, fundamentada na obra de Chwif & Medina (*Modelagem e Simulação de Eventos Discretos*) e adaptada pela Profa. Marcia Savoine.

---

## 1. Definições e Fundamentos da Simulação

A simulação é uma disciplina voltada à representação e análise do comportamento de sistemas complexos por meio de experimentação controlada.

### Definições Formais

* **Kelton et al. (1998):** Gama variada de métodos e aplicações que reproduzem o comportamento de sistemas reais, usualmente utilizando ferramentas computacionais.


* **Shannon (1975):** Processo de elaboração de um modelo de um sistema real (ou hipotético) e a condução de experimentos com a finalidade de entender o comportamento do sistema ou avaliar sua operação.


* **Pidd (2000):** Construção de modelos computacionais do sistema de interesse para inicializar seu comportamento e submetê-lo a diversas políticas operacionais, visando a seleção da melhor alternativa.


* **Michaelis (2024):** Imitação do funcionamento de um processo por meio de outro; teste, experiência ou ensaio.



### Capacidades e Limitações Metodológicas

* **Poder Preditivo:** A simulação não adivinha o futuro de forma determinística absoluta; ela estima, com determinado grau de confiança estatística, o comportamento provável de um sistema condicionado a dados de entrada específicos e a um conjunto estrito de premissas.


* **Relação com Modelos Matemáticos:** A simulação não se reduz a um cálculo algébrico fechado ou fórmula estática.


* **Análise de Cenários vs. Otimização:** A simulação é primordialmente uma ferramenta de análise de cenários (*"E se...?"* / *What-if*). Pode ser acoplada a algoritmos de otimização heurística, mas, isoladamente, não garante a obtenção de uma solução matematicamente ótima.


* **Princípio SINSFIT (*Simulation Is No Substitute For Intelligent Thinking*):** A simulação atua como suporte à decisão e não substitui o julgamento analítico do tomador de decisão.



---

## 2. Conceitos Estruturais: Sistemas e Processos

### Sistema

* **Definições:** Agrupamento de partes que operam coordenadas visando um objetivo comum (Forrester, 1968), ou um conjunto de componentes e subsistemas interdependentes voltados a objetivos comuns (Laudon, 2014).


* **Estrutura Cibernética:** Todo sistema opera em um **Ambiente**, integrado a uma **Organização**, com fluxos de **Entrada $\rightarrow$ Processamento $\rightarrow$ Saída**, regulados por mecanismos de **Realimentação (*Feedback*)**.


* **Fronteira do Sistema:** Delimitação conceitual que define quais elementos pertencem ao sistema e quais pertencem ao ambiente externo.



### Processo

Definido como um grupo de atividades estruturadas em sequência lógica com o objetivo de produzir um bem ou serviço de valor para um cliente (Hammer & Champy, 1994).

```
                 ┌──────────────────────────┐
                 │         CONTEXTO         │
                 │ Regras, Políticas, Leis, │
                 │ Normas e Procedimentos   │
                 └────────────┬─────────────┘
                              │
                              ▼
┌──────────────────┐     ┌───────────┐     ┌──────────────────────┐
│     ENTRADAS     │ ──> │ PROCESSO  │ ──> │        SAÍDAS        │
│ Demandas,        │     └─────▲─────┘     │ Produtos, Serviços,  │
│ Consumíveis e    │           │           │ Resultados de Negócio│
│ Matérias-primas  │           │           │ e Saídas Indesejadas │
└──────────────────┘     ┌─────┴─────┐     └──────────────────────┘
                         │ RECURSOS  │
                         │ Pessoas,  │
                         │ Tecnologia│
                         │ e Espaço  │
                         └───────────┘

```

---

## 3. Tipologia de Modelos

Um modelo é uma abstração simplificada das relações entre os componentes de um sistema, aproximando-se do seu comportamento real.

| Categoria | Definição e Aplicação | Vantagens | Limitações |
| --- | --- | --- | --- |
| **Modelos Simbólicos** | Representações gráficas e visuais (Fluxogramas, DFD, layouts de fábrica).

 | Facilidade de comunicação, documentação e padronização.

 | Estáticos; não fornecem métricas quantitativas nem detalhes dinâmicos.

 |
| **Modelos Analíticos** | Formulações matemáticas fechadas (Programação Linear, Teoria das Filas).

 | Soluções exatas, formulação rápida e garantia de otimalidade teórica.

 | Em sua maioria são estáticos; a complexidade de sistemas reais inviabiliza deduções diretas.

 |
| **Modelos de Simulação** | Modelos computacionais dinâmicos que imitam o comportamento temporal e estocástico.

 | Capturam alta complexidade, variabilidade e interações temporais.

 | Construção laboriosa; não garantem solução ótima.

 |

### Aplicação Analítica da Teoria das Filas (Modelo $M/M/1$)

Em sistemas simples com chegadas e atendimentos exponencialmente distribuídos com disciplina FIFO, o número médio de elementos na fila ($L_f$ ou $L_q$) é dado analiticamente por:


$$L_q = \frac{\rho^2}{1-\rho}$$


Onde $\rho = \frac{\lambda}{\mu}$ representa a intensidade de tráfego (taxa de chegada $\lambda$ dividida pela taxa de atendimento $\mu$).

* **Exemplo de Cálculo:**
* Taxa de chegada ($\lambda$): 50 clientes/hora.


* Taxa de atendimento ($\mu$): 60 clientes/hora.


* Utilização: $\rho = \frac{50}{60} = \frac{5}{6}$.


* Média de clientes em fila:

$$L_q = \frac{\left(\frac{5}{6}\right)^2}{1 - \frac{5}{6}} = \frac{\frac{25}{36}}{\frac{1}{6}} = \frac{25}{6} \approx 4,1667 \text{ clientes}$$






---

## 4. Classificação das Técnicas de Simulação

### Técnicas Gerais

* **Simulação Não-Computacional:** Ensaios físicos ou de escala (ex.: modelos em túneis de vento) e simulação de acontecimentos (treinamentos operacionais).


* **Simulação Computacional:**
* *Estática / Monte Carlo:* Não incorpora a evolução contínua do tempo; baseia-se em amostragem probabilística de variáveis.


* *Sistemas Contínuos:* O estado do sistema varia de forma fluida ao longo do tempo (modelado por equações diferenciais).


* *Eventos Discretos (DES):* O estado do sistema altera-se instantaneamente em pontos específicos no tempo em que ocorrem eventos discretos.





### Eixos da Simulação de Eventos Discretos

* **Comportamento Temporal:** Dinâmico (as variáveis e estados evoluem com o passar do relógio).


* **Natureza dos Dados:**
* *Determinística:* Variáveis e parâmetros operam com valores exatos e taxas constantes.


* *Estocástica:* Entradas e durações são descritas por variáveis aleatórias governadas por distribuições de probabilidade com média e variância.





---

## 5. Justificativa, Aplicações e Ciclo Metodológico

### Critérios de Decisão: Quando Simular?

A simulação é indicada quando o sistema apresenta simultaneamente:

1. **Alta Complexidade:** Múltiplos componentes interconectados.


2. **Dinâmica Temporal:** O estado futuro depende diretamente da sequência histórica de estados anteriores.


3. **Aleatoriedade e Variabilidade:** A utilização exclusiva de valores médios mascara gargalos reais e períodos críticos (a "falácia das médias", na qual trabalhar com médias oculta os picos de fila e o risco operacional).



### Áreas de Aplicação

Redes logísticas, sistemas de manufatura, terminais de transporte (portos, aeroportos, rodovias), serviços hospitalares, operações militares, redes de computadores, reengenharia de processos e cadeias de serviços (*fast-food*, tráfego).

### Fases do Ciclo de Vida da Simulação

```
┌───────────────────────────────────────────────────────────┐
│ 1. CONCEPÇÃO                                              │
│    • Definição do Problema e Objetivos                    │
│    • Modelo Abstrato e Formulação Conceitual              │
└─────────────────────────────┬─────────────────────────────┘
                              │
                              ▼
┌───────────────────────────────────────────────────────────┐
│ 2. IMPLEMENTAÇÃO                                          │
│    • Coleta e Ajuste dos Dados de Entrada                 │
│    • Codificação do Modelo Computacional                  │
│    • Verificação e Validação (V&V)                        │
└─────────────────────────────┬─────────────────────────────┘
                              │
                              ▼
┌───────────────────────────────────────────────────────────┐
│ 3. ANÁLISE                                                │
│    • Modelo Operacional e Experimentação                  │
│    • Análise Estatística dos Resultados                   │
│    • Redefinição e Suporte à Decisão                      │
└───────────────────────────────────────────────────────────┘

```

(Fases metodológicas do ciclo de projeto de simulação segundo Chwif & Medina).

### Disciplinas de Atendimento em Filas Estudadas

* **FIFO (*First In, First Out*):** Atendimento por ordem estrita de chegada.


* **LIFO (*Last In, First Out*):** Atendimento pelo último elemento que ingressou no sistema.


* **Prioridade:** Atendimento definido por pesos ou classes atribuídas às entidades.


* **Round Robin:** Compartilhamento temporal do servidor por frações de tempo pré-fixadas (*quanta*).


* **SIRO (*Service In Random Order*):** Atendimento por seleção aleatória entre as entidades presentes na fila.

---

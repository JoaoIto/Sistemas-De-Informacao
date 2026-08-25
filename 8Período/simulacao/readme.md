# Simulação

Este resumo técnico estabelece os fundamentos teóricos, matemáticos e metodológicos da disciplina de **Simulação de Sistemas de Informação** da UNITINS.

---

## 1. Fundamentos de Modelagem e Simulação

### Conceitos Centrais

* **Sistema:** Coleção de entidades (pessoas, máquinas, nós de rede) que interagem ao longo do tempo para cumprir um ou mais objetivos operacionais.


* **Estado do Sistema:** Conjunto de variáveis necessárias para descrever o sistema em determinado instante no tempo.
* **Modelo:** Representação simplificada e abstrata de um sistema real ou hipotético, projetada para estudo estrutural ou comportamental.


* **Simulação:** Técnica computacional que reproduz o comportamento temporal de um modelo sob condições experimentais controladas, permitindo inferir métricas de desempenho e prever gargalos sem alterar o sistema real.



### Classificação Formal dos Modelos

Os modelos computacionais de simulação são categorizados segundo três eixos fundamentais:

```
                          ┌── Determinístico (Sem aleatoriedade)
         ┌── Estocasticidade
         │                └── Estocástico (Com distribuições de probabilidade)
         │
         │                ┌── Estático (Ponto fixo no tempo / Monte Carlo)
Modelo ──┼── Tempo ───────┤
         │                └── Dinâmico (Evolução temporal contínua ou discreta)
         │
         │                ┌── Contínuo (Variáveis de estado mudam continuamente)
         └── Continuidade ┤
                          └── Discreto (Mudança de estado restrita a eventos pontuais)

```

### Ciclo de Vida de um Projeto de Simulação

A condução de um estudo de modelagem e simulação segue etapas sequenciais e iterativas:

1. **Definição do Problema e Objetivos:** Delimitação do escopo, hipóteses simplificadoras e métricas de desempenho (KPIs) a serem avaliadas.


2. **Conceituação do Modelo:** Levantamento de fluxos, variáveis de decisão e formulação das regras lógicas do sistema.


3. **Coleta e Tratamento de Dados de Entrada:** Caracterização estatística dos dados empíricos e ajuste de distribuições teóricas de probabilidade.


4. **Construção Computacional (Codificação):** Implementação das entidades, filas e rotinas de controle de tempo em linguagem/ferramenta de simulação.


5. **Verificação e Validação (V&V):** Avaliação de conformidade entre modelo computacional, modelo conceitual e sistema real.


6. **Planejamento Experimental e Execução:** Definição de cenários, tamanho do período de aquecimento (*warm-up*), replicações e horizontes temporais.


7. **Análise de Saída e Tomada de Decisão:** Interpretação inferencial dos resultados por meio de intervalos de confiança.



---

## 2. Mecanismos de Controle e Avanço do Tempo

Em **Simulação a Eventos Discretos (DES - *Discrete Event Simulation*)**, o estado do sistema permanece inalterado entre a ocorrência de dois eventos sucessivos.

### Componentes de um Simulador a Eventos Discretos

* **Relógio de Simulação ($T$):** Variável que rastreia o tempo corrente da simulação.
* **Lista de Eventos Futuros (FEL - *Future Event List*):** Estrutura de dados ordenada temporalmente (geralmente uma fila de prioridade baseada em *min-heap*) contendo tuplas no formato $(\text{tempo\_do\_evento}, \text{tipo\_de\_evento}, \text{atributos})$.
* **Rotinas de Evento:** Sub-rotinas disparadas para atualizar as variáveis de estado e agendar novos eventos na FEL.

### Mecanismos de Avanço do Tempo

| Característica | Avanço por Próximo Evento (*Next-Event Time Advance*) | Avanço por Incremento Fixo (*Fixed-Increment Time Advance*) |
| --- | --- | --- |
| **Mecânica** | O relógio $T$ salta diretamente para o instante do próximo evento agendado na FEL.

 | O relógio $T$ avança em passos constantes de tamanho fixo $\Delta t$.

 |
| **Tratamento Temporal** | Períodos de inatividade são ignorados instantaneamente. | Intervalos vazios continuam sendo processados ciclicamente. |
| **Eficiência Computacional** | Alta eficiência para sistemas esparsos no tempo. | Pode desperdiçar ciclos de CPU se $\Delta t$ for muito pequeno. |
| **Aplicação Típica** | Redes de filas, sistemas de informação, manufatura e telecomunicações.

 | Modelos de dinâmica de fluidos, equações diferenciais e física de jogos. |

---

## 3. Variabilidade, Aleatoriedade e o Método de Monte Carlo

A variabilidade observada em sistemas reais é incorporada aos modelos computacionais por meio de componentes probabilísticos.

### O Método de Monte Carlo

Técnica estocástica que emprega amostragem pseudoaleatória repetitiva para obter estimativas numéricas de problemas matemáticos ou físicos complexos, mesmo que desprovidos de dimensão temporal dinâmica.

### Geradores de Números Pseudoaleatórios (PRNG)

Algoritmos determinísticos que produzem sequências de valores estatisticamente indistinguíveis de uma distribuição uniforme contínua $U(0, 1)$.

* **Gerador Congruencial Linear (LCG):**

$$X_{i+1} = (a \cdot X_i + c) \pmod m$$


* $X_0$: Semente inicial (*seed*).
* $a$: Multiplicador.
* $c$: Incremento.
* $m$: Módulo (determina o período máximo antes da repetição da sequência).
* O número normalizado gerado é dado por $R_i = \frac{X_i}{m} \in [0, 1)$.



### Geração de Variáveis Aleatórias Não-Uniformes

Para modelar tempos de atendimento, taxas de chegada ou falhas, converte-se o valor uniforme $R \sim U(0, 1)$ para a distribuição de interesse:

1. **Método da Transformada Inversa:**
Se $X$ é uma variável aleatória contínua com Função de Distribuição Acumulada $F(x)$, calcula-se a inversa analítica $F^{-1}(u)$:

$$X = F^{-1}(R), \quad \text{onde } R \sim U(0, 1)$$


* *Exemplo (Distribuição Exponencial com taxa $\lambda$):*

$$F(x) = 1 - e^{-\lambda x} \implies X = -\frac{1}{\lambda} \ln(1 - R)$$




2. **Método da Aceitação-Rejeição:**
Utilizado quando a inversa analítica $F^{-1}(u)$ não existe em forma fechada (ex: Distribuição Normal, Beta ou Gama). Gera-se um par de valores sob uma função limitante e aceita-se o valor caso ele se situe abaixo da função de densidade de probabilidade alvo.

---

## 4. Teoria das Filas e Modelagem de Recursos

A Teoria das Filas analisa matematicamente o congestionamento e o fluxo de entidades disputando recursos de capacidade finita.

### Notação de Kendall

Identifica sistemas de filas pelo padrão formal:


$$A / B / c / K / m / Z$$

* **$A$:** Distribuição do tempo entre chegadas ($M = \text{Exponencial/Markoviano}$, $D = \text{Determinístico}$, $G = \text{Geral}$).
* **$B$:** Distribuição do tempo de atendimento ($M, D, G$).
* **$c$:** Número de servidores paralelos disponíveis.
* **$K$:** Capacidade total de clientes no sistema (fila + servidores); padrão $\infty$ se omitido.
* **$m$:** Tamanho da população de entrada; padrão $\infty$ se omitido.
* **$Z$:** Disciplina de atendimento da fila.

### Disciplinas de Atendimento e Alocação de Recursos

* **FIFO (*First In, First Out*):** Atendimento por estrita ordem de chegada.
* **LIFO (*Last In, First Out*):** Atendimento em ordem inversa à chegada (comportamento de pilha).
* **Filas com Prioridade:** Entidades possuem níveis de importância associados.
* **Sem Preempção (*Non-preemptive*):** Se uma entidade de alta prioridade chega enquanto o servidor está ocupado, ela vai para a frente da fila, mas aguarda o término do atendimento corrente.


* **Com Preempção (*Preemptive*):** A entidade de maior prioridade interrompe imediatamente o atendimento de uma entidade de menor prioridade, assumindo o servidor.




* **Recursos do Tipo Contêiner (*Containers*):** Alocação de capacidades contínuas ou de múltiplos blocos discretos não atrelados a agentes individuais (ex: espaço em buffer, tanques de combustível, limites de memória RAM).



---

## 5. Arquitetura de Simulação com SimPy

O **SimPy** é um framework em Python para simulação a eventos discretos baseado em geradores assíncronos (`yield`) e co-rotinas.

### Componentes Principais da Arquitetura

| Componente SimPy | Função Técnica |
| --- | --- |
| `simpy.Environment` | Gerencia a lista de eventos futuros (FEL) e o relógio de simulação (`env.now`).

 |
| **Processos (`env.process`)** | Funções geradoras em Python que modelam o ciclo de vida e comportamento ativo das entidades.

 |
| `env.timeout(delay)` | Agenda um evento que pausa a entidade por um intervalo $\Delta t$, avançando o tempo do modelo.

 |
| `simpy.Resource` | Recurso com capacidade compartilhada finita e fila FIFO automática.

 |
| `simpy.PriorityResource` | Recurso com suporte a filas ordenadas por prioridade numérica.

 |
| `simpy.PreemptiveResource` | Recurso com interrupção ativa de processos em execução.

 |
| `simpy.Container` | Gerencia armazenamento e consumo de quantidades homogêneas (contínuas ou discretas).

 |

### Mecânica de Execução (Ciclo de Vida de Processo)

```
┌────────────────────────────────────────────────────────┐
│ Processo Criado: env.process(cliente(env, servidor))   │
└────────────────────────────────────────────────────────┘
                           │
                           ▼
┌────────────────────────────────────────────────────────┐
│ Requisição de Recurso: with servidor.request() as req  │
│ yield req (Pausa até o servidor estar disponível)      │
└────────────────────────────────────────────────────────┘
                           │
                           ▼
┌────────────────────────────────────────────────────────┐
│ Retenção e Atendimento: yield env.timeout(tempo_serv) │
│ (Relógio avança tempo_serv para este processo)         │
└────────────────────────────────────────────────────────┘
                           │
                           ▼
┌────────────────────────────────────────────────────────┐
│ Liberação Automática do Recurso e Fim do Processo     │
└────────────────────────────────────────────────────────┘

```

---

## 6. Verificação, Validação e Análise Estatística de Saída

### Verificação versus Validação (V&V)

* **Verificação:** Responde à pergunta *"O modelo foi construído corretamente?"*. Garante que o código computacional implementa fielmente o modelo conceitual (auditoria de código, testes de estresse, depuração de eventos).


* **Validação:** Responde à pergunta *"O modelo construído é o modelo correto?"*. Avalia se o comportamento do simulador corresponde satisfatoriamente ao comportamento do sistema do mundo real (comparações empíricas, testes estatísticos de aderência, teste de Turing com especialistas).



### Análise e Tratamento de Dados de Entrada

Para alimentar o modelo com distribuições confiáveis, executam-se testes de bondade de ajuste (*goodness-of-fit*) sobre os dados coletados:

* **Teste Qui-Quadrado ($\chi^2$):** Adequado para amostras grandes e variáveis discretas.
* **Teste Kolmogorov-Smirnov (K-S):** Adequado para amostras contínuas e tamanhos amostrais menores.

### Análise de Dados de Saída

Os resultados de uma simulação estocástica são variáveis aleatórias que exigem tratamento estatístico rigoroso:

* **Fase Transiente vs. Regime Permanente:** Em simulações de horizonte infinito, os dados iniciais contêm distorções decorrentes do estado inicial vazio. Utiliza-se um período de aquecimento (*warm-up period*) cujas métricas iniciais são descartadas antes da coleta final.
* **Método das Replicações Independentes:** Executa-se o modelo $n$ vezes com diferentes sementes (*seeds*) de números aleatórios, garantindo que as observações finais sejam independentes e identicamente distribuídas (i.i.d.).
* **Intervalo de Confiança:** Para uma métrica de saída com média amostral $\bar{X}$ e desvio padrão amostral $S$, calcula-se o intervalo de confiança a $(1-\alpha)\%$ via distribuição $t$-Student:

$$\text{IC} = \left[ \bar{X} - t_{n-1, \alpha/2} \cdot \frac{S}{\sqrt{n}}, \; \bar{X} + t_{n-1, \alpha/2} \cdot \frac{S}{\sqrt{n}} \right]$$

---

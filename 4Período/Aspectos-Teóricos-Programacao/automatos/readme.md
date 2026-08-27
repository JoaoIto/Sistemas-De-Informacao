# Resumo Técnico: Autômatos Finitos Determinísticos (AFD)

---

## 1. Fundamentos e Modelo de Estados Finitos

Um **Sistema de Estados Finitos** é um modelo matemático de computação com entradas e saídas discretas, composto por um número finito e pré-definido de estados.

```
                 FITA DE ENTRADA (Apenas Leitura)
                ┌───┬───┬───┬───┬───┬───┬───┐
                │ a │ b │ b │ a │ a │ b │ … │
                └───┴───┴───┴───┴───┴───┴───┘
                                ▲
                                │ Cabeça de leitura (move-se apenas para a direita)
                     ┌──────────┴──────────┐
                     │ UNIDADE DE CONTROLE │
                     │   (Estado Atual: q) │
                     └─────────────────────┘

```

### Características Operacionais

* **Memória de Trabalho Inexistente:** O autômato não dispõe de memória auxiliar dinâmica (como pilhas ou fitas de escrita). Toda a informação sobre o histórico do processamento deve ser representada na definição do **estado corrente**.


* **Fita de Leitura Unidirecional:** A cadeia de entrada é disposta em células discretas na fita. A cabeça de leitura avança obrigatoriamente uma célula para a direita a cada símbolo consumido.


* **Garantia de Término:** Como a palavra de entrada é finita e a cada transição um símbolo é consumido, **um autômato finito sempre para** (não ocorrem loops infinitos durante o processamento de uma palavra).



---

## 2. Definição Formal do AFD

Formalmente, um **Autômato Finito Determinístico (AFD)** é definido por uma 5-tupla:

$$M = (\Sigma, Q, \delta, q_0, F)$$

* $\Sigma$: Alfabeto finito e não vazio de símbolos de entrada.


* $Q$: Conjunto finito e não vazio de estados internos.


* $\delta$: Função programa ou função de transição de estados:



$$\delta: Q \times \Sigma \rightarrow Q$$



Para cada par de estado corrente e símbolo lido $(q, a)$, $\delta(q, a)$ determina um único próximo estado de forma determinística.


* $q_0$: Estado inicial ($q_0 \in Q$), onde a máquina inicia o processamento.


* $F$: Conjunto de estados finais ou de aceitação ($F \subseteq Q$).



---

## 3. Função Programa Estendida ($\delta^*$) e Critério de Aceitação

Para descrever o comportamento do autômato ao processar palavras completas ($w \in \Sigma^*$) em vez de símbolos isolados, define-se a **Função Programa Estendida** $\delta^*: Q \times \Sigma^* \rightarrow Q$ recursivamente:

1. **Base da Indução (Cadeia Vazia $\epsilon$):**

$$\delta^*(q, \epsilon) = q$$


2. **Passo Indutivo (Para $a \in \Sigma$ e $w \in \Sigma^*$):**

$$\delta^*(q, aw) = \delta^*(\delta(q, a), w)$$



### Critério de Reconhecimento

Dada uma palavra $w \in \Sigma^*$, diz-se que $w$ é **aceita** por $M$ se e somente se o processamento completo a partir do estado inicial atingir um estado pertencente a $F$:


$$w \in L(M) \iff \delta^*(q_0, w) \in F$$

Caso $\delta^*(q_0, w) \notin F$, a cadeia é **rejeitada**.

---

## 4. Operações Algébricas sobre AFDs

### Fechamento sob Complemento ($\bar{L} = \Sigma^* \setminus L$)

Se uma linguagem $L$ é reconhecida por um AFD determinístico e total $M = (\Sigma, Q, \delta, q_0, F)$, a linguagem complementar $\bar{L}$ é reconhecida pelo autômato:


$$M' = (\Sigma, Q, \delta, q_0, Q \setminus F)$$


*Mantêm-se o alfabeto, o conjunto de estados, o estado inicial e as funções de transição, invertendo-se apenas os estados de aceitação.*

### Fechamento sob Interseção ($L_1 \cap L_2$) via Autômato Produto

Sejam $M_1 = (\Sigma, Q_1, \delta_1, q_{01}, F_1)$ e $M_2 = (\Sigma, Q_2, \delta_2, q_{02}, F_2)$. O autômato produto $M_{\cap} = (\Sigma, Q, \delta, q_0, F)$ é dado por:

* $Q = Q_1 \times Q_2$
* $q_0 = (q_{01}, q_{02})$
* $F = F_1 \times F_2 = \{(p, q) \mid p \in F_1 \land q \in F_2\}$
* $\delta((p, q), a) = (\delta_1(p, a), \delta_2(q, a)), \quad \forall a \in \Sigma$

---

# Resolução Passo a Passo da Atividade Proposta

---

## Questão 1: Interseção de Linguagens via Autômato Produto

**Alfabeto base:** $\Sigma = \{a, b\}$

---

### Item 1.a) $L = \{w \mid w \text{ tem pelo menos três } a\text{'s e pelo menos dois } b\text{'s}\}$

#### Passo 1: Construção do AFD $M_1$ ($L_1$: pelo menos 3 $a$'s)

* Estados: $Q_1 = \{A_0, A_1, A_2, A_3\}$, onde o índice representa a quantidade de símbolos $a$ lidos (com $A_3$ sendo o estado absorvente de 3 ou mais $a$'s).
* Estado inicial: $A_0$
* Estado final: $F_1 = \{A_3\}$
* Transições de $M_1$:
* $\delta_1(A_0, a) = A_1$, $\delta_1(A_0, b) = A_0$
* $\delta_1(A_1, a) = A_2$, $\delta_1(A_1, b) = A_1$
* $\delta_1(A_2, a) = A_3$, $\delta_1(A_2, b) = A_2$
* $\delta_1(A_3, a) = A_3$, $\delta_1(A_3, b) = A_3$



#### Passo 2: Construção do AFD $M_2$ ($L_2$: pelo menos dois $b$'s)

* Estados: $Q_2 = \{B_0, B_1, B_2\}$, onde o índice representa a contagem de $b$'s lidos.
* Estado inicial: $B_0$
* Estado final: $F_2 = \{B_2\}$
* Transições de $M_2$:
* $\delta_2(B_0, a) = B_0$, $\delta_2(B_0, b) = B_1$
* $\delta_2(B_1, a) = B_1$, $\delta_2(B_1, b) = B_2$
* $\delta_2(B_2, a) = B_2$, $\delta_2(B_2, b) = B_2$



#### Passo 3: Produto Cartesiano $M = M_1 \times M_2$

* Conjunto de Estados: $Q = Q_1 \times Q_2 = \{(A_i, B_j) \mid 0 \le i \le 3, \; 0 \le j \le 2\}$ (12 estados).
* Estado Inicial: $(A_0, B_0)$
* Conjunto de Estados Finais: $F = \{(A_3, B_2)\}$

#### Tabela de Transição do AFD Produto ($M$):

| Estado Atual $(A_i, B_j)$ | Entrada $a$ | Entrada $b$ |
| --- | --- | --- |
| **$\rightarrow (A_0, B_0)$** | $(A_1, B_0)$ | $(A_0, B_1)$ |
| **$(A_0, B_1)$** | $(A_1, B_1)$ | $(A_0, B_2)$ |
| **$(A_0, B_2)$** | $(A_1, B_2)$ | $(A_0, B_2)$ |
| **$(A_1, B_0)$** | $(A_2, B_0)$ | $(A_1, B_1)$ |
| **$(A_1, B_1)$** | $(A_2, B_1)$ | $(A_1, B_2)$ |
| **$(A_1, B_2)$** | $(A_2, B_2)$ | $(A_1, B_2)$ |
| **$(A_2, B_0)$** | $(A_3, B_0)$ | $(A_2, B_1)$ |
| **$(A_2, B_1)$** | $(A_3, B_1)$ | $(A_2, B_2)$ |
| **$(A_2, B_2)$** | $(A_3, B_2)$ | $(A_2, B_2)$ |
| **$(A_3, B_0)$** | $(A_3, B_0)$ | $(A_3, B_1)$ |
| **$(A_3, B_1)$** | $(A_3, B_1)$ | $(A_3, B_2)$ |
| **$* (A_3, B_2)$** | $(A_3, B_2)$ | $(A_3, B_2)$ |

#### Diagrama de Estados do AFD Combinado:

```
          a             a             a
  (A0,B0) ───> (A1,B0) ───> (A2,B0) ───> (A3,B0) ──┐ a
   │             │             │             │   │ └──┘
 b │           b │           b │           b │   └─────┐
   ▼             ▼             ▼             ▼         │ b
  (A0,B1) ───> (A1,B1) ───> (A2,B1) ───> (A3,B1) <────┘
   │      a      │      a      │      a      │   │ a
 b │           b │           b │           b │   └──┘
   ▼             ▼             ▼             ▼
  (A0,B2) ───> (A1,B2) ───> (A2,B2) ───> *((A3,B2))* ──┐ a, b
          a             a             a   └───┘      └──┘

```

---

### Item 1.b) $L = \{w \mid w \text{ tem exatamente dois } a\text{'s e pelo menos dois } b\text{'s}\}$

#### Passo 1: Construção do AFD $M_1$ ($L_1$: exatamente dois $a$'s)

* Estados: $Q_1 = \{A_0, A_1, A_2, A_E\}$, onde $A_E$ é o estado de erro (mais de dois $a$'s).
* Estado inicial: $A_0$
* Estado final: $F_1 = \{A_2\}$
* Transições de $M_1$:
* $\delta_1(A_0, a) = A_1$, $\delta_1(A_0, b) = A_0$
* $\delta_1(A_1, a) = A_2$, $\delta_1(A_1, b) = A_1$
* $\delta_1(A_2, a) = A_E$, $\delta_1(A_2, b) = A_2$
* $\delta_1(A_E, a) = A_E$, $\delta_1(A_E, b) = A_E$



#### Passo 2: Construção do AFD $M_2$ ($L_2$: pelo menos dois $b$'s)

* Estados: $Q_2 = \{B_0, B_1, B_2\}$, $q_{02} = B_0$, $F_2 = \{B_2\}$.
* Transições idênticas às do item 1.a.

#### Passo 3: Produto Cartesiano $M = M_1 \times M_2$

* Estados: $Q = \{(A_i, B_j) \mid i \in \{0, 1, 2, E\}, \; j \in \{0, 1, 2\}\}$.
* Estado Inicial: $(A_0, B_0)$
* Estado Final: $F = \{(A_2, B_2)\}$

#### Tabela de Transição do AFD Produto ($M$):

| Estado Atual | Entrada $a$ | Entrada $b$ |
| --- | --- | --- |
| **$\rightarrow (A_0, B_0)$** | $(A_1, B_0)$ | $(A_0, B_1)$ |
| **$(A_0, B_1)$** | $(A_1, B_1)$ | $(A_0, B_2)$ |
| **$(A_0, B_2)$** | $(A_1, B_2)$ | $(A_0, B_2)$ |
| **$(A_1, B_0)$** | $(A_2, B_0)$ | $(A_1, B_1)$ |
| **$(A_1, B_1)$** | $(A_2, B_1)$ | $(A_1, B_2)$ |
| **$(A_1, B_2)$** | $(A_2, B_2)$ | $(A_1, B_2)$ |
| **$(A_2, B_0)$** | $(A_E, B_0)$ | $(A_2, B_1)$ |
| **$(A_2, B_1)$** | $(A_E, B_1)$ | $(A_2, B_2)$ |
| **$* (A_2, B_2)$** | $(A_E, B_2)$ | $(A_2, B_2)$ |
| **$(A_E, B_0)$** | $(A_E, B_0)$ | $(A_E, B_1)$ |
| **$(A_E, B_1)$** | $(A_E, B_1)$ | $(A_E, B_2)$ |
| **$(A_E, B_2)$** | $(A_E, B_2)$ | $(A_E, B_2)$ |

#### Diagrama de Estados do AFD:

```
          a             a             a
  (A0,B0) ───> (A1,B0) ───> (A2,B0) ───> (AE,B0) ──┐ a
   │             │             │             │   │ └──┘
 b │           b │           b │           b │   └─────┐
   ▼             ▼             ▼             ▼         │ b
  (A0,B1) ───> (A1,B1) ───> (A2,B1) ───> (AE,B1) <────┘
   │      a      │      a      │      a      │   │ a
 b │           b │           b │           b │   └──┘
   ▼             ▼             ▼             ▼
  (A0,B2) ───> (A1,B2) ───> *((A2,B2))* ─> (AE,B2) ──┐ a, b
          a             a       │     a          └──┘
                                └─── b (loop)

```

---

## Questão 2: Complemento de Linguagens

**Alfabeto base:** $\Sigma = \{a, b\}$

---

### Item 2.a) $L = \{w \mid w \text{ não contém a subcadeia } ab\}$

#### Passo 1: Construção do AFD da Linguagem Simples $L_{orig}$ ($w$ contém $ab$)

* Estados: $Q = \{q_0, q_1, q_2\}$
* $q_0$: Nenhum prefixo de $ab$ ativo (início ou último símbolo foi $b$).
* $q_1$: Prefixo $a$ detectado (espera-se $b$ para completar a subcadeia).
* $q_2$: Subcadeia $ab$ reconhecida com sucesso (estado poço de aceitação).


* Estado Inicial: $q_0$
* Estado Final: $F_{orig} = \{q_2\}$
* Transições de $L_{orig}$:
* $\delta(q_0, a) = q_1$, $\delta(q_0, b) = q_0$
* $\delta(q_1, a) = q_1$, $\delta(q_1, b) = q_2$
* $\delta(q_2, a) = q_2$, $\delta(q_2, b) = q_2$



#### Passo 2: Aplicação do Teorema do Complemento

Para obter o autômato da linguagem complementar $\bar{L} = \{w \mid w \text{ não contém a subcadeia } ab\}$, mantêm-se os estados e as transições de $M$, alterando-se os estados finais para $F_{comp} = Q \setminus F_{orig}$:


$$F_{comp} = \{q_0, q_1, q_2\} \setminus \{q_2\} = \{q_0, q_1\}$$

#### Passo 3: Definição Formal do AFD Resultante

$$M_{comp} = (\{a, b\}, \{q_0, q_1, q_2\}, \delta, q_0, \{q_0, q_1\})$$

#### Tabela de Transição:

| Estado | Entrada $a$ | Entrada $b$ |
| --- | --- | --- |
| **$\rightarrow * q_0$** | $q_1$ | $q_0$ |
| **$* q_1$** | $q_1$ | $q_2$ |
| **$q_2$** | $q_2$ | $q_2$ |

#### Diagrama de Estados do AFD Complementar:

```
        b                 a
      ┌───┐             ┌───┐
      │   │             │   │
      ▼   │      a      ▼   │       b             a, b
    (( q0 )) ────────> (( q1 )) ────────> ( q2 ) ──┐
                                            ▲    │ └──┘
                                            └────┘

```

---

## Questão 3: Construção, Definição Formal e Computação Estendida

**Alfabeto base:** $\Sigma = \{0, 1\}$

---

### Item 3.1) $L_1 = \{w \mid \text{o comprimento de } w \text{ não é divisível por } 3\}$

#### Passo 1: Lógica dos Estados

A condição formal exige que $\vert{}w\vert{} \not\equiv 0 \pmod 3$, o que implica $\vert{}w\vert{} \equiv 1 \pmod 3$ ou $\vert{}w\vert{} \equiv 2 \pmod 3$.

* $q_0$: $\vert{}w\vert{} \equiv 0 \pmod 3$ (comprimento divisível por 3).
* $q_1$: $\vert{}w\vert{} \equiv 1 \pmod 3$ (resto 1).
* $q_2$: $\vert{}w\vert{} \equiv 2 \pmod 3$ (resto 2).

#### Passo 2: Definição Formal

$$M_1 = (\{0, 1\}, \{q_0, q_1, q_2\}, \delta_1, q_0, \{q_1, q_2\})$$

#### Tabela de Transição:

| Estado | Entrada $0$ | Entrada $1$ |
| --- | --- | --- |
| **$\rightarrow q_0$** | $q_1$ | $q_1$ |
| **$* q_1$** | $q_2$ | $q_2$ |
| **$* q_2$** | $q_0$ | $q_0$ |

#### Diagrama de Estados:

```
                 0, 1               0, 1
       ( q0 ) ─────────> (( q1 )) ─────────> (( q2 ))
         ▲                                      │
         └──────────────────────────────────────┘
                           0, 1

```

#### Passo 3: Computação da Função de Transição Estendida ($\delta^*$)

* **Cadeia Aceita: $w = 01$ ($\vert{}w\vert{} = 2$)**

$$\delta^*(q_0, 01) = \delta^*(\delta(q_0, 0), 1)$$


$$\delta^*(\delta(q_0, 0), 1) = \delta^*(q_1, 1)$$


$$\delta^*(q_1, 1) = \delta^*(\delta(q_1, 1), \epsilon)$$


$$\delta^*(\delta(q_1, 1), \epsilon) = \delta^*(q_2, \epsilon) = q_2$$



*Resultado:* Como $q_2 \in F_1$, a cadeia $01$ é **aceita**.
* **Cadeia Rejeitada: $w = 011$ ($\vert{}w\vert{} = 3$)**

$$\delta^*(q_0, 011) = \delta^*(\delta(q_0, 0), 11) = \delta^*(q_1, 11)$$


$$\delta^*(q_1, 11) = \delta^*(\delta(q_1, 1), 1) = \delta^*(q_2, 1)$$


$$\delta^*(q_2, 1) = \delta^*(\delta(q_2, 1), \epsilon) = \delta^*(q_0, \epsilon) = q_0$$



*Resultado:* Como $q_0 \notin F_1$, a cadeia $011$ é **rejeitada**.

---

### Item 3.2) $L_2 = \{w \mid w \text{ contém um } 0 \text{ em cada posição ímpar}\}$

#### Passo 1: Lógica dos Estados

* Posições ímpares (1ª, 3ª, 5ª, ...) devem conter o símbolo `0`.
* Posições pares (2ª, 4ª, 6ª, ...) podem conter `0` ou `1`.
* A cadeia vazia $\epsilon$ possui 0 posições ímpares (condição satisfeita por vacuidade).
* Estados:
* $q_0$: Comprimento par acumulado; o próximo símbolo será em posição **ímpar** (exige `0`).
* $q_1$: Comprimento ímpar acumulado; o próximo símbolo será em posição **par** (aceita `0` ou `1`).
* $q_E$: Estado de erro/rejeição permanente (caso surja `1` em posição ímpar).



#### Passo 2: Definição Formal

$$M_2 = (\{0, 1\}, \{q_0, q_1, q_E\}, \delta_2, q_0, \{q_0, q_1\})$$

#### Tabela de Transição:

| Estado | Entrada $0$ | Entrada $1$ |
| --- | --- | --- |
| **$\rightarrow * q_0$** | $q_1$ | $q_E$ |
| **$* q_1$** | $q_0$ | $q_0$ |
| **$q_E$** | $q_E$ | $q_E$ |

#### Diagrama de Estados:

```
                     0
            ┌─────────────────┐
            ▼                 │
        (( q0 )) ────────> (( q1 ))
            │       0
          1 │
            ▼           0, 1
         ( qE ) ──────┐
           ▲    │     │
           └────┴─────┘

```

#### Passo 3: Computação da Função de Transição Estendida ($\delta^*$)

* **Cadeia Aceita: $w = 010$ (Posições: 1ª=`0`, 2ª=`1`, 3ª=`0`)**

$$\delta^*(q_0, 010) = \delta^*(\delta(q_0, 0), 10) = \delta^*(q_1, 10)$$


$$\delta^*(q_1, 10) = \delta^*(\delta(q_1, 1), 0) = \delta^*(q_0, 0)$$


$$\delta^*(q_0, 0) = \delta^*(\delta(q_0, 0), \epsilon) = \delta^*(q_1, \epsilon) = q_1$$



*Resultado:* Como $q_1 \in F_2$, a cadeia $010$ é **aceita**.
* **Cadeia Rejeitada: $w = 10$ (Posição 1ª=`1`, violação)**

$$\delta^*(q_0, 10) = \delta^*(\delta(q_0, 1), 0) = \delta^*(q_E, 0)$$


$$\delta^*(q_E, 0) = \delta^*(\delta(q_E, 0), \epsilon) = \delta^*(q_E, \epsilon) = q_E$$



*Resultado:* Como $q_E \notin F_2$, a cadeia $10$ é **rejeitada**.

---

### Item 3.3) $L_3 = \{w \mid \text{o comprimento de } w \text{ é pelo menos } 3 \text{ e o terceiro símbolo é um } 0\}$

#### Passo 1: Lógica dos Estados

* $q_0$: 0 símbolos lidos (início).
* $q_1$: 1 símbolo lido (qualquer símbolo em $\Sigma$).
* $q_2$: 2 símbolos lidos (qualquer símbolo em $\Sigma$).
* $q_3$: 3º símbolo foi `0` (estado final absorvente).
* $q_E$: 3º símbolo foi `1` (estado de erro absorvente).

#### Passo 2: Definição Formal

$$M_3 = (\{0, 1\}, \{q_0, q_1, q_2, q_3, q_E\}, \delta_3, q_0, \{q_3\})$$

#### Tabela de Transição:

| Estado | Entrada $0$ | Entrada $1$ |
| --- | --- | --- |
| **$\rightarrow q_0$** | $q_1$ | $q_1$ |
| **$q_1$** | $q_2$ | $q_2$ |
| **$q_2$** | $q_3$ | $q_E$ |
| **$* q_3$** | $q_3$ | $q_3$ |
| **$q_E$** | $q_E$ | $q_E$ |

#### Diagrama de Estados:

```
               0, 1          0, 1            0             0, 1
       ( q0 ) ──────> ( q1 ) ──────> ( q2 ) ────> (( q3 )) ──┐
                                       │            ▲    │ └──┘
                                     1 │            └────┘
                                       ▼           0, 1
                                    ( qE ) ──────┐
                                      ▲    │     │
                                      └────┴─────┘

```

#### Passo 3: Computação da Função de Transição Estendida ($\delta^*$)

* **Cadeia Aceita: $w = 1101$ ($\vert{}w\vert{} \ge 3$ e 3º símbolo = `0`)**

$$\delta^*(q_0, 1101) = \delta^*(\delta(q_0, 1), 101) = \delta^*(q_1, 101)$$


$$\delta^*(q_1, 101) = \delta^*(\delta(q_1, 1), 01) = \delta^*(q_2, 01)$$


$$\delta^*(q_2, 01) = \delta^*(\delta(q_2, 0), 1) = \delta^*(q_3, 1)$$


$$\delta^*(q_3, 1) = \delta^*(\delta(q_3, 1), \epsilon) = \delta^*(q_3, \epsilon) = q_3$$



*Resultado:* Como $q_3 \in F_3$, a cadeia $1101$ é **aceita**.
* **Cadeia Rejeitada: $w = 1110$ (3º símbolo = `1`)**

$$\delta^*(q_0, 1110) = \delta^*(\delta(q_0, 1), 110) = \delta^*(q_1, 110)$$


$$\delta^*(q_1, 110) = \delta^*(\delta(q_1, 1), 10) = \delta^*(q_2, 10)$$


$$\delta^*(q_2, 10) = \delta^*(\delta(q_2, 1), 0) = \delta^*(q_E, 0)$$


$$\delta^*(q_E, 0) = \delta^*(\delta(q_E, 0), \epsilon) = \delta^*(q_E, \epsilon) = q_E$$



*Resultado:* Como $q_E \notin F_3$, a cadeia $1110$ é **rejeitada**.

# Resolução Técnica: Atividade 1 — Autômatos Finitos Determinísticos (AFD)

Este documento contém a resolução completa, formal e didática das quatro linguagens especificadas na **Atividade 1** da UNITINS, sob o alfabeto $\Sigma = \{a, b\}$.

---

## Estrutura da Definição Formal

Todo Autômato Finito Determinístico (AFD) é formalmente definido pela 5-tupla:


$$M = (\Sigma, Q, \delta, q_0, F)$$

* $\Sigma$: Alfabeto de entrada.


* $Q$: Conjunto finito de estados.


* $\delta$: Função de transição total $\delta: Q \times \Sigma \rightarrow Q$.


* $q_0$: Estado inicial ($q_0 \in Q$).


* $F$: Conjunto de estados finais/aceitação ($F \subseteq Q$).



---

## 1. Linguagem 1: $L_1 = \{w \mid w \text{ é terminado em } a\}$

### Passo 1: Análise Lógica dos Estados

* O autômato precisa registrar apenas a informação do **último símbolo lido**.


* $q_0$: Estado inicial. Representa a cadeia vazia ($\epsilon$) ou que o último símbolo lido foi $b$ (não aceita).


* $q_1$: Representa que o último símbolo lido foi $a$ (aceita).



### Passo 2: Definição Formal

$$M_1 = (\{a, b\}, \{q_0, q_1\}, \delta_1, q_0, \{q_1\})$$

### Passo 3: Tabela de Transição ($\delta_1$)

| Estado | Entrada $a$ | Entrada $b$ |
| --- | --- | --- |
| $\rightarrow q_0$ | $q_1$ | $q_0$ |
| $* q_1$ | $q_1$ | $q_0$ |

### Passo 4: Representação Gráfica (Diagrama de Estados)

```
             b
           ┌───┐
           ▼   │     a
       ──> ( q0 ) ────────> (( q1 )) ──┐ a
             ▲                 │       └──┘
             │                 │
             └─────────────────┘
                      b

```

---

## 2. Linguagem 2: $L_2 = \{w \mid w \text{ não contém a subcadeia } ab\}$

(Nota: Na literatura formal e em listas da disciplina, a notação $\{w \mid w \notin ab\}$ representa as palavras que não contêm $ab$ como subpalavra. O autômato abaixo modela essa propriedade via complemento de subcadeia).

### Passo 1: Análise Lógica dos Estados

* $q_0$: Estado inicial. Nenhum prefixo perigoso ativo (início ou sequência de $b$'s). Aceita.


* $q_1$: O último símbolo lido foi $a$. Se o próximo for $b$, a subcadeia proibida $ab$ será formada. Aceita.


* $q_E$: Estado de erro/poço. A subcadeia $ab$ foi encontrada, invalidando a cadeia permanentemente. Rejeita.



### Passo 2: Definição Formal

$$M_2 = (\{a, b\}, \{q_0, q_1, q_E\}, \delta_2, q_0, \{q_0, q_1\})$$

### Passo 3: Tabela de Transição ($\delta_2$)

| Estado | Entrada $a$ | Entrada $b$ |
| --- | --- | --- |
| $\rightarrow * q_0$ | $q_1$ | $q_0$ |
| $* q_1$ | $q_1$ | $q_E$ |
| $q_E$ | $q_E$ | $q_E$ |

### Passo 4: Representação Gráfica (Diagrama de Estados)

```
             b                 a
           ┌───┐             ┌───┐
           ▼   │      a      ▼   │       b             a, b
       ──> (( q0 )) ───────> (( q1 )) ───────> ( qE ) ──┐
                                                 ▲    │ └──┘
                                                 └────┘

```

---

## 3. Linguagem 3: $L_3 = \{w \mid w \text{ tem } aa \text{ como prefixo e } bb \text{ como sufixo}\}$

### Passo 1: Análise Lógica dos Estados

A cadeia deve iniciar obrigatoriamente com $aa$ e terminar obrigatoriamente com $bb$.

* $q_0$: Início (0 símbolos lidos).
* $q_1$: Leu o 1º símbolo $a$.
* $q_2$: Leu o prefixo $aa$ com sucesso. A partir daqui, monitora-se o sufixo.
* $q_3$: Prefixo $aa$ válido e o último símbolo lido foi $b$ (candidato a início de sufixo $bb$).
* $q_4$: Prefixo $aa$ válido e os dois últimos símbolos lidos foram $bb$ (estado de aceitação).
* $q_E$: Estado de erro/poço. A cadeia iniciou com $b$ ou com $ab$, violando o prefixo obrigatório $aa$.

### Passo 2: Definição Formal

$$M_3 = (\{a, b\}, \{q_0, q_1, q_2, q_3, q_4, q_E\}, \delta_3, q_0, \{q_4\})$$

### Passo 3: Tabela de Transição ($\delta_3$)

| Estado | Entrada $a$ | Entrada $b$ |
| --- | --- | --- |
| $\rightarrow q_0$ | $q_1$ | $q_E$ |
| $q_1$ | $q_2$ | $q_E$ |
| $q_2$ | $q_2$ | $q_3$ |
| $q_3$ | $q_2$ | $q_4$ |
| $* q_4$ | $q_2$ | $q_4$ |
| $q_E$ | $q_E$ | $q_E$ |

### Passo 4: Representação Gráfica (Diagrama de Estados)

```
                 a             a             b             b
       ──> ( q0 ) ────> ( q1 ) ────> ( q2 ) ────> ( q3 ) ────> (( q4 )) ──┐ b
             │             │           ▲   ▲         │             │      └──┘
           b │           b │         a │   └─────────┼─────────────┘
             ▼             │           │         a   │ a
           ( qE ) <────────┘           └─── a ───────┘
           ▲    │
           └────┘ a, b

```

---

## 4. Linguagem 4: $L_4 = \{w \mid w \text{ iniciado e terminado em } a\}$

### Passo 1: Análise Lógica dos Estados

* A cadeia mais curta aceita é a palavra unitária $w = "a"$ (inicia e termina com o mesmo símbolo $a$).
* Cadeias iniciadas por $b$ devem ser descartadas imediatamente.
* $q_0$: Estado inicial.
* $q_1$: Cadeia iniciada por $a$ e cujo último símbolo lido foi $a$ (estado de aceitação).
* $q_2$: Cadeia iniciada por $a$, porém cujo último símbolo lido foi $b$ (aguarda novo $a$ para ser aceita).
* $q_E$: Estado de erro/poço (a cadeia iniciou com o símbolo $b$).

### Passo 2: Definição Formal

$$M_4 = (\{a, b\}, \{q_0, q_1, q_2, q_E\}, \delta_4, q_0, \{q_1\})$$

### Passo 3: Tabela de Transição ($\delta_4$)

| Estado | Entrada $a$ | Entrada $b$ |
| --- | --- | --- |
| $\rightarrow q_0$ | $q_1$ | $q_E$ |
| $* q_1$ | $q_1$ | $q_2$ |
| $q_2$ | $q_1$ | $q_2$ |
| $q_E$ | $q_E$ | $q_E$ |

### Passo 4: Representação Gráfica (Diagrama de Estados)

```
                            a
                          ┌───┐
             a            ▼   │     b
       ──> ( q0 ) ────> (( q1 )) ────────> ( q2 ) ──┐ b
             │            ▲                 │       └──┘
           b │            └─────────────────┘
             ▼                     a
           ( qE ) ──┐
             ▲    │ └──┘ a, b
             └────┘

```

---

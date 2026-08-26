# Fundamentos de Linguagens Formais e Gramáticas

Este documento apresenta a base teórica inicial sobre alfabetos, palavras e gramáticas formais, acompanhada de atividades práticas resolvidas passo a passo para a geração de números e palavras.

---

## 1. Conceitos Teóricos Fundamentais

### 1.1. Alfabeto ($\Sigma$)

Conjunto finito e não vazio de símbolos ou caracteres.

* **Exemplos:**
* $\Sigma = \{0, 1\}$ (alfabeto binário)
* $\Sigma = \{a, b, c\}$
* $\Sigma = \{0, 1, 2, 3, 4, 5, 6, 7, 8, 9\}$ (dígitos decimais)



### 1.2. Palavra (ou Cadeia de Caracteres)

Sequência finita de símbolos justapostos pertencentes a um alfabeto $\Sigma$.

* **Palavra Vazia ($\varepsilon$):** Representa a ausência de símbolos. Seu comprimento é zero ($\vert{}\varepsilon\vert{} = 0$).
* **Comprimento de uma Palavra ($\vert{}w\vert{}$):** Quantidade total de símbolos que compõem a palavra $w$.
* **Concatenação ($u \cdot v$ ou $uv$):** Operação de junção entre duas palavras. O elemento neutro da concatenação é a palavra vazia ($w\varepsilon = \varepsilon w = w$).
* **Prefixo:** Qualquer sequência inicial de símbolos de uma palavra.
* **Sufixo:** Qualquer sequência final de símbolos de uma palavra.

### 1.3. Gramática Formal ($G$)

Mecanismo axiomático e finito utilizado para definir e gerar as palavras de uma linguagem. Formalmente, é uma quádrupla:

$$G = (V, T, P, S)$$

Onde:

* **$V$ (Variáveis ou Não-Terminais):** Símbolos auxiliares representados por letras maiúsculas ($A, B, N, S, \dots$) que são substituídos durante o processo.
* **$T$ (Terminais):** Símbolos finais do alfabeto ($a, b, 0, 1, \dots$) que formam a palavra final. $V$ e $T$ são conjuntos disjuntos ($V \cap T = \emptyset$).
* **$P$ (Regras de Produção):** Conjunto de regras no formato $\alpha \to \beta$, indicando que o elemento $\alpha$ pode ser substituído por $\beta$.
* **$S$ (Símbolo Inicial):** Elemento pertencente a $V$ que marca o início da geração.

### 1.4. Derivação ($\Rightarrow$)

Aplicação sucessiva de regras de produção a partir do símbolo inicial $S$ até que a cadeia resultante contenha exclusivamente símbolos terminais ($w \in T^*$).

* $S \Rightarrow w$ : Derivação em 1 passo.
* $S \Rightarrow^+ w$ : Derivação em 1 ou mais passos.
* $S \Rightarrow^* w$ : Derivação em 0 ou mais passos.

---

## 2. Atividades Práticas Resolvidas

### Exercício 1: Operações Básicas com Palavras

**Enunciado:**

Considere o alfabeto $\Sigma = \{a, b\}$ e as palavras $u = ab$ e $v = ba$.

1. Determine a concatenação $w = u \cdot v$.
2. Calcule o comprimento $\vert{}w\vert{}$.
3. Liste todos os prefixos e sufixos da palavra $u$.

---

#### Passo a Passo da Solução:

* **Passo 1 (Concatenação):**
Justaponha a cadeia $u$ com a cadeia $v$:

$$w = (ab)(ba) = abba$$


* **Passo 2 (Comprimento):**
Conte o número de símbolos da palavra resultante:

$$\vert{}abba\vert{} = 4$$


* **Passo 3 (Prefixos e Sufixos de $u = ab$):**
* **Prefixos (início da palavra):** $\varepsilon$, $a$, $ab$
* **Sufixos (fim da palavra):** $\varepsilon$, $b$, $ab$



---

### Exercício 2: Derivação de Números Naturais com Gramática

**Enunciado:**

Dada a gramática $G = (V, T, P, N)$, onde:

* $V = \{N, D\}$
* $T = \{0, 1, 2, 3, 4, 5, 6, 7, 8, 9\}$
* Símbolo inicial: $N$
* Regras de Produção ($P$):
1. $N \to D$
2. $N \to DN$
3. $D \to 0 \mid 1 \mid 2 \mid 3 \mid 4 \mid 5 \mid 6 \mid 7 \mid 8 \mid 9$



Demonstre o processo de derivação para gerar o número **57**.

---

#### Passo a Passo da Solução:

* **Objetivo:** Transformar a variável inicial $N$ na sequência terminal $57$.
* **Análise:** O número possui 2 dígitos. Portanto, deve-se utilizar a regra recursiva $N \to DN$ uma vez e depois finalizar com $N \to D$.

#### Sequência de Derivação:

```text
Passo 1: N  => DN     (Aplicou a regra: N -> DN)
Passo 2:    => 5N     (Aplicou a regra: D -> 5)
Passo 3:    => 5D     (Aplicou a regra: N -> D)
Passo 4:    => 57     (Aplicou a regra: D -> 7)

```

**Resultado:** A derivação foi concluída em 4 passos ($N \Rightarrow^4 57$).

---

### Exercício 3: Derivação de Cadeias Estruturadas

**Enunciado:**

Considere a gramática $G = (\{S\}, \{a, b\}, P, S)$ com as seguintes regras de produção:

1. $S \to aSb$
2. $S \to ab$

Demonstre o processo de derivação para gerar a palavra **$aabb$**.

---

#### Passo a Passo da Solução:

* **Objetivo:** Gerar a cadeia $aabb$ a partir de $S$.
* **Análise:** A regra $S \to aSb$ insere um terminal $a$ à esquerda e um $b$ à direita da variável central. A regra $S \to ab$ insere o par final sem reintroduzir variáveis.

#### Sequência de Derivação:

```text
Passo 1: S  => aSb    (Aplicou a regra: S -> aSb)
Passo 2:    => a(ab)b (Aplicou a regra: S -> ab no lugar de S)
            => aabb

```

**Resultado:** A palavra $aabb$ pertence à linguagem gerada pela gramática ($S \Rightarrow^+ aabb$).

---

## 3. Tabela de Referência Rápida

| Conceito | Notação | Descrição |
| --- | --- | --- |
| **Alfabeto** | $\Sigma$ | Conjunto finito de símbolos básicos. |
| **Palavra Vazia** | $\varepsilon$ | Cadeia com ausência de símbolos ($\vert{}\varepsilon\vert{} = 0$). |
| **Concatenação** | $u \cdot v$ ou $uv$ | União sequencial de duas palavras. |
| **Comprimento** | $\Vert{}w\Vert{}$ | Contagem total de caracteres de $w$. |
| **Não-Terminal** | $V$ ou $N$ | Símbolo intermediário substituível (maiúsculo). |
| **Terminal** | $T$ ou $\Sigma$ | Símbolo final constante da linguagem. |
| **Produção** | $A \to \alpha$ | Regra que define a substituição de $A$ por $\alpha$. |
| **Derivação** | $\alpha \Rightarrow \beta$ | Transformação direta aplicando uma produção. |

# Conjuntos

## 1. Definições Fundamentais e Notação Matemática

### Conceito de Conjunto e Elemento

Um **conjunto** é uma coleção não ordenada de objetos distintos, chamados **elementos**. Um conjunto é completamente determinado pelos elementos que o compõem, sem consideração quanto à ordem ou repetição.

### Relação de Pertinência

Indica se um objeto pertence ou não a uma determinada coleção:

* Se $a$ é elemento do conjunto $A$, escreve-se: $a \in A$ (lê-se "$a$ pertence a $A$").
* Se $a$ não é elemento do conjunto $A$, escreve-se: $a \notin A$ (lê-se "$a$ não pertence a $A$").

### Formas de Representação

1. **Por Extensão (Enumerativa):** Enumeração direta dos elementos delimitados por chaves.

$$A = \{2, 4, 6, 8\}$$


2. **Por Compreensão (Intensiva):** Definição por meio de uma propriedade ou regra lógica $P(x)$ satisfeita exclusivamente pelos elementos do conjunto.

$$A = \{x \in \mathbb{N} \mid x \text{ é par e } 0 < x \le 8\}$$


3. **Representação Gráfica (Diagramas de Venn):** Utilização de regiões fechadas no plano para visualizar a pertinência e interações entre conjuntos.

### Conjuntos Notáveis

* **Conjunto Vazio ($\emptyset$ ou $\{\}$):** Conjunto que não contém nenhum elemento. Formalmente:

$$\forall x \, (x \notin \emptyset)$$



Sua cardinalidade é $\vert{}\emptyset\vert{} = 0$.
* **Conjunto Universo ($U$):** Conjunto de referência que contém todos os elementos sob consideração em determinado contexto formal.
* **Conjunto Unitário:** Conjunto composto por exatamente um único elemento: $A = \{a\}$.

---

## 2. Relações entre Conjuntos

### Relação de Inclusão e Subconjuntos

Um conjunto $A$ é considerado subconjunto de $B$ ($A \subseteq B$) se e somente se todo elemento pertencente a $A$ também pertencer a $B$:


$$A \subseteq B \iff \forall x \, (x \in A \implies x \in B)$$

* **Subconjunto Próprio ($\subset$):** $A$ é subconjunto próprio de $B$ ($A \subset B$) se $A \subseteq B$ e $A \neq B$.
* **Propriedades da Inclusão:**
* **Reflexiva:** $A \subseteq A$ para todo conjunto $A$.
* **Antissimétrica:** Se $A \subseteq B$ e $B \subseteq A$, então $A = B$.
* **Transitiva:** Se $A \subseteq B$ e $B \subseteq C$, então $A \subseteq C$.
* **Elemento Neutro:** $\emptyset \subseteq A$ para todo conjunto $A$.



### Igualdade de Conjuntos

Dois conjuntos $A$ e $B$ são iguais se e somente se contêm exatamente os mesmos elementos:


$$A = B \iff (A \subseteq B \land B \subseteq A)$$

### Conjunto das Partes (Power Set)

Dado um conjunto $A$, o **Conjunto das Partes** de $A$, denotado por $\mathcal{P}(A)$ ou $2^A$, é o conjunto formado por todos os subconjuntos possíveis de $A$:


$$\mathcal{P}(A) = \{X \mid X \subseteq A\}$$

* **Propriedades do Power Set:**
* $\emptyset \in \mathcal{P}(A)$ e $A \in \mathcal{P}(A)$.
* Se a cardinalidade de $A$ é $\vert{}A\vert{} = n$, a cardinalidade do conjunto das partes é:

$$\vert{}\mathcal{P}(A)\vert{} = 2^n$$





---

## 3. Operações Fundamentais sobre Conjuntos

### União ($\cup$)

Operação que resulta no conjunto de todos os elementos que pertencem a $A$, a $B$ ou a ambos.


$$A \cup B = \{x \mid x \in A \lor x \in B\}$$

### Interseção ($\cap$)

Operação que resulta no conjunto contendo apenas os elementos comuns a $A$ e $B$.


$$A \cap B = \{x \mid x \in A \land x \in B\}$$

* **Conjuntos Disjuntos:** $A$ e $B$ são disjuntos se e somente se $A \cap B = \emptyset$.

### Diferença ($A \setminus B$ ou $A - B$)

Conjunto contendo os elementos de $A$ que não pertencem a $B$.


$$A \setminus B = \{x \mid x \in A \land x \notin B\}$$

### Complementar ($A^c$, $\bar{A}$ ou $A'$)

Diferença relativa entre o conjunto universo $U$ e o conjunto $A$.


$$A^c = U \setminus A = \{x \in U \mid x \notin A\}$$

### Diferença Simétrica ($\Delta$)

Conjunto formado pelos elementos pertencentes a $A$ ou a $B$, mas não a ambos simultaneamente.


$$A \Delta B = (A \setminus B) \cup (B \setminus A) = (A \cup B) \setminus (A \cap B)$$

### Produto Cartesiano ($\times$)

Conjunto formado por todos os pares ordenados $(a, b)$ tais que $a \in A$ e $b \in B$.


$$A \times B = \{(a, b) \mid a \in A \land b \in B\}$$

* **Cardinalidade do Produto Cartesiano:**

$$\vert{}A \times B\vert{} = \vert{}A\vert{} \cdot \vert{}B\vert{}$$



---

## 4. Álgebra de Conjuntos e Leis Fundamentais

A união, interseção e complementação obedecem a uma estrutura de **Álgebra Booleana**. A tabela abaixo sumariza as identidades fundamentais:

| Nome da Lei | União ($\cup$) | Interseção ($\cap$) |
| --- | --- | --- |
| **Idempotência** | $A \cup A = A$ | $A \cap A = A$ |
| **Comutatividade** | $A \cup B = B \cup A$ | $A \cap B = B \cap A$ |
| **Associatividade** | $(A \cup B) \cup C = A \cup (B \cup C)$ | $(A \cap B) \cap C = A \cap (B \cap C)$ |
| **Distributividade** | $A \cup (B \cap C) = (A \cup B) \cap (A \cup C)$ | $A \cap (B \cup C) = (A \cap B) \cup (A \cap C)$ |
| **Identidade** | $A \cup \emptyset = A$ | $A \cap U = A$ |
| **Dominação** | $A \cup U = U$ | $A \cap \emptyset = \emptyset$ |
| **Complementação** | $A \cup A^c = U$ | $A \cap A^c = \emptyset$ |
| **Dupla Complementação** | $(A^c)^c = A$ | — |
| **Absorção** | $A \cup (A \cap B) = A$ | $A \cap (A \cup B) = A$ |

### Leis de De Morgan

Regras de dualidade que descrevem como a complementação afeta as operações de união e interseção:

1. **Primeira Lei:** $(A \cup B)^c = A^c \cap B^c$
2. **Segunda Lei:** $(A \cap B)^c = A^c \cup B^c$

---

## 5. Princípio da Inclusão-Exclusão e Cardinalidade

A cardinalidade $\vert{}A\vert{}$ quantifica o número de elementos distintos contidos em um conjunto finito $A$.

### Para dois conjuntos finitos $A$ e $B$:

$$\vert{}A \cup B\vert{} = \vert{}A\vert{} + \vert{}B\vert{} - \vert{}A \cap B\vert{}$$

### Para três conjuntos finitos $A$, $B$ e $C$:

$$\vert{}A \cup B \cup C\vert{} = \vert{}A\vert{} + \vert{}B\vert{} + \vert{}C\vert{} - \vert{}A \cap B\vert{} - \vert{}A \cap C\vert{} - \vert{}B \cap C\vert{} + \vert{}A \cap B \cap C\vert{}$$

---

## 6. Relações, Funções e Aplicação na Ciência da Computação

### Relações Binárias e Partições

* **Relação Binária:** Uma relação $R$ de $A$ em $B$ é formalmente definida como qualquer subconjunto do produto cartesiano: $R \subseteq A \times B$.
* **Relação de Equivalência:** Relação sobre um conjunto $A$ que possui as propriedades reflexiva, simétrica e transitiva. Induz uma **partição** em $A$, dividindo-o em classes de equivalência mutuamente disjuntas cuja união cobre todo o conjunto $A$.

### Funções

Uma função $f: A \to B$ é uma relação que associa cada elemento de $A$ a exatamente um único elemento de $B$.

* **Injetora:** $\forall a_1, a_2 \in A \, (f(a_1) = f(a_2) \implies a_1 = a_2)$
* **Sobrejetora:** $\forall b \in B \, (\exists a \in A \text{ tal que } f(a) = b)$
* **Bijetora:** Função simultaneamente injetora e sobrejetora (garante a existência da função inversa $f^{-1}$).

### Mapeamento direto com Teoria das Linguagens Formais

| Conceito de Teoria dos Conjuntos | Aplicação na Teoria da Computação |
| --- | --- |
| **Alfabeto ($\Sigma$)** | Conjunto finito e não vazio de símbolos primários. |
| **Palavra / Cadeia ($w$)** | Sequência finita obtida pela concatenação de símbolos do conjunto $\Sigma$. |
| **Fecho de Kleene ($\Sigma^*$)** | Conjunto de todas as palavras possíveis formadas sobre o alfabeto $\Sigma$, incluindo a palavra vazia ($\epsilon$). |
| **Linguagem Formal ($L$)** | Qualquer subconjunto do fecho de Kleene: $L \subseteq \Sigma^*$. |
| **Operações sobre Linguagens** | A união de linguagens ($L_1 \cup L_2$), a interseção ($L_1 \cap L_2$) e o complemento ($\bar{L} = \Sigma^* \setminus L$) são operações de conjuntos estritas. |

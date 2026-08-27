# Resolução Técnica: Gramáticas Formais e Fundamentos de Linguagens

---

## 1. Atividade: Gramáticas Formais

### Questão 1: Definição Formal da Quádrupla $G = (V, T, P, S)$

Uma gramática formal é o mecanismo gerador de uma linguagem, formalmente descrita por:


$$G = (V, T, P, S)$$

* **$V$ (Conjunto de Variáveis ou Não-Terminais):** Conjunto finito de símbolos estruturais intermediários que podem ser reescritos e expandidos por meio das regras de produção. Representados convencionalmente por letras maiúsculas ($V \cap T = \emptyset$).


* **$T$ (Conjunto de Símbolos Terminais):** Conjunto finito de caracteres que compõem o alfabeto da linguagem gerada. São os elementos finais das palavras e **não podem ser substituídos**.


* **$P$ (Regras de Produção):** Conjunto finito de regras de reescrita que definem como combinações de não-terminais e terminais podem ser transformadas. Em gramáticas gerais, assumem a forma $\alpha \rightarrow \beta$, onde $\alpha \in (V \cup T)^+$ e $\beta \in (V \cup T)^*$.


* **$S$ (Símbolo Inicial):** Elemento pertencente a $V$ ($S \in V$), também denominado axioma.


* **Papel da Variável Inicial no Processo de Derivação:** O símbolo $S$ atua como o ponto de partida obrigatório de qualquer derivação. Toda sequência de substituições sucessivas inicia-se em $S$ e prossegue aplicando as produções de $P$ até que a cadeia resultante contenha unicamente símbolos pertencentes ao conjunto terminal $T$.



---

### Questão 2: Gramática $G_1$ com Regras $P = \{S \rightarrow aSb \mid \epsilon\}$

* **Definição:** $V = \{S\}$, $T = \{a, b\}$, $S$ como símbolo inicial.



#### Item 2.a) Derivação da palavra $aabb$

A derivação ocorre aplicando substituições a partir de $S$:

1. **Passo 0 (Axioma):**

$$S$$


2. **Passo 1 (Aplicação de $S \rightarrow aSb$):**

$$S \Rightarrow aSb$$


3. **Passo 2 (Aplicação de $S \rightarrow aSb$):**

$$aSb \Rightarrow a(aSb)b = aaSbb$$


4. **Passo 3 (Aplicação de $S \rightarrow \epsilon$ para encerrar):**

$$aaSbb \Rightarrow aa(\epsilon)bb = aabb$$



*Cadeia final derivada com sucesso:* **$aabb$**

#### Item 2.b) Análise da pertinência da palavra $abab$

* **Resposta:** A palavra $abab$ **não pertence** à linguagem gerada por essa gramática.


* **Justificativa Técnica:** As regras de produção impõem uma estrutura estritamente aninhada ($S \rightarrow aSb$). A cada aplicação da regra não-vazia, um símbolo $a$ é inserido no extremo esquerdo e um símbolo $b$ no extremo direito da subcadeia gerada. Consequentemente, a linguagem gerada é $L(G_1) = \{a^n b^n \mid n \ge 0\}$, que exige que todos os símbolos $a$ precedam rigorosamente todos os símbolos $b$. A cadeia $abab$ possui o símbolo $a$ após a ocorrência de $b$, impossibilitando qualquer caminho de derivação válido sob essas regras.



---

### Questão 3: Gramática $G_2$ com Regras $P = \{S \rightarrow SS \mid aSb \mid ab\}$

* **Definição:** $V = \{S\}$, $T = \{a, b\}$, $S$ como símbolo inicial.



#### Item 3.a) Derivação da palavra $abab$

1. **Passo 0 (Axioma):**

$$S$$


2. **Passo 1 (Aplicação de $S \rightarrow SS$):**

$$S \Rightarrow SS$$


3. **Passo 2 (Aplicação de $S \rightarrow ab$ no primeiro $S$):**

$$SS \Rightarrow abS$$


4. **Passo 3 (Aplicação de $S \rightarrow ab$ no segundo $S$):**

$$abS \Rightarrow abab$$



*Cadeia final derivada com sucesso:* **$abab$**

#### Item 3.b) Análise da quantidade de símbolos $a$ e $b$

* **Resposta:** **Sim**, essa gramática gera exclusivamente palavras com a mesma quantidade de símbolos $a$ e $b$ (ou seja, $\vert{}w\vert{}_a = \vert{}w\vert{}_b$ para toda palavra $w \in L(G_2)$).


* **Justificativa Técnica:** Analisando indutivamente cada regra de produção:


* $S \rightarrow ab$: Introduz exatamente 1 símbolo $a$ e 1 símbolo $b$, mantendo a proporção de paridade $1:1$.


* $S \rightarrow aSb$: Adiciona simultaneamente 1 símbolo $a$ à esquerda e 1 símbolo $b$ à direita de $S$, preservando a igualdade de contagem.


* $S \rightarrow SS$: Concatena duas cadeias que, por hipótese indutiva, já possuem quantidades balanceadas de $a$ e $b$ (a soma de duas cadeias com contagens equilibradas resulta em uma cadeia equilibrada).





Não há nenhuma regra de produção capaz de inserir $a$ sem introduzir conjuntamente um $b$.

---

## 2. Atividade: Alfabetos e Operações com Palavras

### Questão 1: Prefixos e Sufixos

Dada uma palavra $w$, a cadeia vazia $\epsilon$ e a própria palavra $w$ são, por definição formal, simultaneamente prefixo e sufixo de $w$.

#### a) Palavra $w = \text{amor}$

* **Comprimento:** $\vert{}w\vert{} = 4$

* **Prefixos:** $\{\epsilon, \text{a}, \text{am}, \text{amo}, \text{amor}\}$

* **Sufixos:** $\{\epsilon, \text{r}, \text{or}, \text{mor}, \text{amor}\}$


#### b) Palavra $w = \text{Vasco}$

* **Comprimento:** $\vert{}w\vert{} = 5$

* **Prefixos:** $\{\epsilon, \text{V}, \text{Va}, \text{Vas}, \text{Vasc}, \text{Vasco}\}$

* **Sufixos:** $\{\epsilon, \text{o}, \text{co}, \text{sco}, \text{asco}, \text{Vasco}\}$


#### c) Palavra $w = \text{FoReVer}$

* **Comprimento:** $\vert{}w\vert{} = 7$

* **Prefixos:** $\{\epsilon, \text{F}, \text{Fo}, \text{FoR}, \text{FoRe}, \text{FoReV}, \text{FoReVe}, \text{FoReVer}\}$

* **Sufixos:** $\{\epsilon, \text{r}, \text{er}, \text{Ver}, \text{eVer}, \text{ReVer}, \text{oReVer}, \text{FoReVer}\}$


---

### Questão 2: Operações com $w_1 = \text{unitins}$ e $w_2 = \text{tocantins}$

* **Comprimentos base:**
* $\vert{}w_1\vert{} = \vert{}\text{unitins}\vert{} = 7$

* $\vert{}w_2\vert{} = \vert{}\text{tocantins}\vert{} = 9$




#### 1. $w_1$ (ou $w_1^1$)



$$w_1 = \text{unitins}$$

#### 2. $(w_1)^3$ (Concatenação sucessiva tripla)



$$(w_1)^3 = w_1 \cdot w_1 \cdot w_1 = \text{unitinsunitinsunitins}$$

#### 3. $\vert{}w_2\vert{}$ (Comprimento da cadeia $w_2$)



$$\vert{}w_2\vert{} = 9$$

#### 4. $(w_2)^1$ (Concatenação unitária)



$$(w_2)^1 = \text{tocantins}$$

#### 5. Avaliação da Expressão Aritmética



$$\text{Resultado} = \frac{\vert{}w_1\vert{} + \vert{}w_1\vert{} \cdot \vert{}w_2\vert{} - \vert{}w_1\vert{} \cdot \left((\vert{}w_2\vert{} - \vert{}w_1\vert{}) \cdot \vert{}w_1\vert{}\right)}{\vert{}w_1\vert{}}$$

*Substituindo os comprimentos $\vert{}w_1\vert{} = 7$ e $\vert{}w_2\vert{} = 9$ passo a passo:*

1. Subtração interna:

$$\vert{}w_2\vert{} - \vert{}w_1\vert{} = 9 - 7 = 2$$


2. Multiplicação do termo interno:

$$2 \cdot \vert{}w_1\vert{} = 2 \cdot 7 = 14$$


3. Multiplicação pelo termo externo $\vert{}w_1\vert{}$:

$$\vert{}w_1\vert{} \cdot 14 = 7 \cdot 14 = 98$$


4. Multiplicação central $\vert{}w_1\vert{} \cdot \vert{}w_2\vert{}$:

$$7 \cdot 9 = 63$$


5. Montagem do numerador:

$$\text{Numerador} = 7 + 63 - 98 = 70 - 98 = -28$$


6. Divisão final por $\vert{}w_1\vert{} = 7$:

$$\text{Resultado} = \frac{-28}{7} = -4$$



---

### Questão 3: Identificação de Alfabetos

Um **Alfabeto ($\Sigma$)** é formalmente definido como um **conjunto finito e não-vazio de símbolos indivisíveis**.

| Item | Conjunto Apresentado | Classificação | Justificativa Técnica Formal |
| --- | --- | --- | --- |
| **1** | Conjunto dos números primos

 | **Não** | Conjunto infinito ($\{2, 3, 5, 7, 11, \dots\}$). Alfabetos não podem ser infinitos.

 |
| **2** | Conjunto de números naturais

 | **Não** | Conjunto infinito ($\mathbb{N} = \{0, 1, 2, 3, \dots\}$).

 |
| **3** | Conjunto das letras do alfabeto brasileiro

 | **SIM** | Conjunto finito de 26 símbolos discretos e indivisíveis.

 |
| **4** | Conjunto $\{a, b, c, d, h\}$<br> | **SIM** | Conjunto finito e não-vazio com 5 símbolos bem definidos.

 |
| **5** | Conjunto das partes de $\{a, b, c\}$<br> | **Não** | $\mathcal{P}(\{a, b, c\})$ é uma família cujos elementos são conjuntos (ex: $\{a, b\}$), não símbolos atômicos.

 |
| **6** | Conjunto dos algarismos arábicos

 | **SIM** | Conjunto finito composto por 10 dígitos base: $\{0, 1, 2, 3, 4, 5, 6, 7, 8, 9\}$.

 |
| **7** | Conjunto dos algarismos romanos

 | **SIM** | Conjunto finito composto por 7 caracteres base: $\{\text{I, V, X, L, C, D, M}\}$.

 |

#### Marcação Final dos Parênteses:

1. ( ) Conjunto dos números primos.


2. ( ) Conjunto de números naturais.


3. **( X )** Conjunto das letras do alfabeto brasileiro.


4. **( X )** Conjunto $\{a, b, c, d, h\}$.


5. ( ) Conjunto das partes de $\{a, b, c\}$.


6. **( X )** Conjunto dos algarismos arábicos.

---

7. **( X )** Conjunto dos algarismos romanos.

8. 

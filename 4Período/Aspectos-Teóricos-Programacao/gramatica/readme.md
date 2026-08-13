# Gramática e Linguagens

## O que é uma Gramática Formal?

Na Teoria da Computação e na Teoria das Linguagens Formais, uma **Gramática Formal** é um conjunto de regras matemáticas utilitárias usadas para gerar todas as cadeias válidas de uma determinada linguagem.

Enquanto os **Autômatos** atuam como *reconhecedores* de linguagens (verificando se uma entrada é válida) , as **Gramáticas** atuam como *geradoras* (descrevendo como construir as cadeias válidas a partir de substituições sucessivas).

---

## Estrutura Formal de uma Gramática

Formalmente, uma gramática $G$ é definida por uma quádrupla:

$$G = (V_N, V_T, P, S)$$

* **$V_N$ (Variáveis ou Símbolos Não-Terminais):** Símbolos genéricos de estrutura que serão substituídos durante o processo. Geralmente representados por letras maiúsculas (ex: $S, A, B, D$).
* **$V_T$ (Símbolos Terminais):** Os caracteres finais que compõem as palavras da linguagem (ex: digitos `0..9`, símbolos `+`, `-`, `.`). Eles nunca são substituídos.


* 
**$P$ (Regras de Produção):** O conjunto de regras de reescrita que definem como um não-terminal pode ser substituído por uma combinação de não-terminais e terminais.


* **$S$ (Símbolo Inicial):** O ponto de partida da geração ($S \in V_N$).

---

## O Mecanismo de Substituição (Derivação)

A geração de uma palavra ocorre por **derivação** ($\Rightarrow$). O processo funciona como uma substituição sistemática de variáveis:

1. Começa-se com o símbolo inicial $S$.
2. Escolhe-se um símbolo não-terminal presente na cadeia atual.
3. Substitui-se esse símbolo pelo lado direito de uma regra de produção $P$ correspondente.
4. O processo se repete até que restem **apenas símbolos terminais** na cadeia.

---

## Exemplos Práticos Passo a Passo: Gerando Números

### Exemplo 1: Gerando o Número Inteiro `358`

Vamos definir uma **Gramática Regular** $G_1$ para gerar qualquer número inteiro de um ou mais dígitos:

* **$V_N$**: $\{S, D\}$
* **$V_T$**: $\{0, 1, 2, 3, 4, 5, 6, 7, 8, 9\}$
* **$S$**: Símbolo inicial
* **Regras de Produção ($P$)**:
1. $S \rightarrow D S \mid D$ *(Um número é um dígito seguido de outro número, ou apenas um dígito)*
2. $D \rightarrow 0 \mid 1 \mid 2 \mid 3 \mid 4 \mid 5 \mid 6 \mid 7 \mid 8 \mid 9$ *(Um dígito é qualquer símbolo de 0 a 9)*



#### Passo a Passo da Derivação para `358`:

| Passo | Cadeia Atual | Regra Aplicada | Explicação Didática |
| --- | --- | --- | --- |
| **0** | $S$ | Início | Começamos com o símbolo inicial. |
| **1** | $D S$ | $S \rightarrow D S$ | Substituímos $S$ por $D S$ para indicar que haverá mais dígitos. |
| **2** | $3 S$ | $D \rightarrow 3$ | Substituímos o primeiro não-terminal $D$ pelo símbolo terminal `3`. |
| **3** | $3 D S$ | $S \rightarrow D S$ | Substituímos o $S$ por $D S$ para preparar o próximo dígito. |
| **4** | $3 5 S$ | $D \rightarrow 5$ | Substituímos o não-terminal $D$ pelo símbolo terminal `5`. |
| **5** | $3 5 D$ | $S \rightarrow D$ | Como `8` será o último dígito, usamos $S \rightarrow D$ para encerrar a expansão. |
| **6** | $3 5 8$ | $D \rightarrow 8$ | Substituímos o último $D$ por `8`. Restam apenas terminais! |

**Resultado final:** `358`

---

### Exemplo 2: Gerando um Número Decimal com Sinal (`-14.5`)

Vamos construir uma **Gramática Livre de Contexto** $G_2$ que permite gerar números com sinal opcional (`+` ou `-`) e parte fracionária:

* **$V_N$**: $\{N, S, I, D\}$
* **$V_T$**: $\{+, -, ., 0, 1, 2, 3, 4, 5, 6, 7, 8, 9\}$
* **$N$**: Símbolo inicial (Número)
* **Regras de Produção ($P$)**:
* $N \rightarrow S I . I \mid I$
* $S \rightarrow + \mid -$
* $I \rightarrow D I \mid D$
* $D \rightarrow 0 \mid 1 \mid 2 \mid 3 \mid 4 \mid 5 \mid 6 \mid 7 \mid 8 \mid 9$



#### Passo a Passo da Derivação para `-14.5`:

1. **Início ($N$)**:

$$\text{Aplicando } N \rightarrow S I . I \implies S I . I$$


2. **Substituindo o Sinal ($S$)**:

$$\text{Aplicando } S \rightarrow - \implies - I . I$$


3. **Expandindo a Parte Inteira ($I$):**
* Precisamos do número `14`, então expandimos o primeiro $I$ para $D I$:

$$\text{Aplicando } I \rightarrow D I \implies - D I . I$$


* Substituímos o primeiro $D$ por `1`:

$$\text{Aplicando } D \rightarrow 1 \implies - 1 I . I$$


* O $I$ restante da parte inteira vira o dígito final `4`:

$$\text{Aplicando } I \rightarrow D \implies - 1 D . I$$


$$\text{Aplicando } D \rightarrow 4 \implies - 1 4 . I$$




4. **Expandindo a Parte Decimal ($I$):**
* A parte decimal tem apenas o dígito `5`:

$$\text{Aplicando } I \rightarrow D \implies - 1 4 . D$$


$$\text{Aplicando } D \rightarrow 5 \implies - 1 4 . 5$$





---

### Exemplo 3: Gerando uma Expressão Aritmética Numérica (`7 + 2 * 3`)

Gramáticas também definem como os números se combinam matematicamente. Consideremos a seguinte gramática de expressões:

* **Regras ($P$)**:
* $E \rightarrow E + T \mid T$ *(Expressão)*
* $T \rightarrow T * F \mid F$ *(Termo)*
* $F \rightarrow D$ *(Fator)*
* $D \rightarrow 0 \mid 1 \mid \dots \mid 9$ *(Dígito)*



#### Derivação Mais à Esquerda (*Leftmost Derivation*):

$$E \Rightarrow E + T$$

$$E + T \Rightarrow T + T$$

$$T + T \Rightarrow F + T$$

$$F + T \Rightarrow D + T$$

$$D + T \Rightarrow 7 + T$$

$$7 + T \Rightarrow 7 + T * F$$

$$7 + T * F \Rightarrow 7 + F * F$$

$$7 + F * F \Rightarrow 7 + D * F$$

$$7 + D * F \Rightarrow 7 + 2 * F$$

$$7 + 2 * F \Rightarrow 7 + 2 * D$$

$$7 + 2 * D \Rightarrow 7 + 2 * 3$$

---

## Representação Gráfica: Árvore de Derivação (Parse Tree)

Toda substituição de símbolos pode ser visualizada como uma estrutura hierárquica em formato de árvore. A raiz é o símbolo inicial, os nós internos são os símbolos não-terminais e as folhas são os símbolos terminais que compõem o número ou a expressão final.

### Hierarquia de Tipos de Gramática (Resumo)

As regras de substituição definem a restrição da gramática de acordo com a **Hierarquia de Chomsky**:

| Tipo | Gramática | Regra de Substituição Permitida | Reconhecedor Associado |
| --- | --- | --- | --- |
| **Tipo 3** | Regular | <br>$A \rightarrow aB$ ou $A \rightarrow a$ |
| Autômato Finito (DFA / NFA) |
| **Tipo 2** | Livre de Contexto | <br>$A \rightarrow \gamma$ (onde $A$ é uma variável única) |
| Autômato de Pilha (PDA) |
| **Tipo 1** | Sensível ao Contexto | <br>$\alpha A \beta \rightarrow \alpha \gamma \beta$ |
| Autômato Limitado por Limite (LBA) |
| **Tipo 0** | Irrestrita | <br>$\alpha \rightarrow \beta$ (qualquer reescrita) | Máquina de Turing |

---

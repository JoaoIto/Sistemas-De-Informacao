# Aspectos Teóricos de Programação

Este resumo técnico serve como base conceitual para a disciplina de **Aspectos Teóricos da Programação** no contexto do curso de Sistemas de Informação da UNITINS.

O conteúdo está estruturado nos pilares fundamentais da ementa acadêmica: Teoria das Linguagens Formais, Autômatos, Processamento/Compilação, Paradigmas e Semântica de Linguagens.

---

## 1. Teoria das Linguagens Formais e Autômatos

A base teórica da computação apoia-se em conceitos matemáticos de alfabetos, linguagens e gramáticas.

### Conceitos Fundamentais

* **Alfabeto ($\Sigma$):** Conjunto finito e não vazio de símbolos.
* **Cadeia ou Palavra ($w$):** Sequência finita de símbolos escolhidos de um alfabeto. O comprimento de uma cadeia é indicado por $\vert{}w\vert{}$. A cadeia vazia é representada por $\epsilon$.
* **Linguagem ($L$):** Conjunto de cadeias sobre um determinado alfabeto, tal que $L \subseteq \Sigma^*$.

### Hierarquia de Chomsky

Classificação das gramáticas formais em quatro níveis de complexidade restritiva:

| Nível | Gramática / Linguagem | Autômato Reconhecedor | Formato das Regras de Produção |
| --- | --- | --- | --- |
| **Tipo 3** | Regular | Autômato Finito (DFA / NFA) | $A \rightarrow aB$ ou $A \rightarrow a$ |
| **Tipo 2** | Livre de Contexto (LLC) | Autômato de Pilha (PDA) | $A \rightarrow \gamma$ (onde $A \in V_N$) |
| **Tipo 1** | Sensível ao Contexto | Autômato Limitado por Límite (LBA) | $\alpha A \beta \rightarrow \alpha \gamma \beta$ |
| **Tipo 0** | Irrestrita (Recursivamente Enumerável) | Máquina de Turing | $\alpha \rightarrow \beta$ |

### Autômatos Finitos

Modelos matemáticos de estados finitos utilizados no reconhecimento de Linguagens Regulares (Tipo 3).

* **Autômato Finito Determinístico (DFA):** Definido formalmente por uma tupla de 5 elementos:

$$M = (Q, \Sigma, \delta, q_0, F)$$


* $Q$: Conjunto finito de estados.
* $\Sigma$: Alfabeto de entrada.
* $\delta$: Função de transição $Q \times \Sigma \rightarrow Q$.
* $q_0$: Estado inicial ($q_0 \in Q$).
* $F$: Conjunto de estados de aceitação/finais ($F \subseteq Q$).


* **Autômato Finito Não-Determinístico (NFA):** Difere do DFA por permitir múltiplas transições para o mesmo símbolo de entrada ou transições sem consumo de símbolo ($\epsilon$-transições). A função de transição assume a forma $\delta: Q \times (\Sigma \cup \{\epsilon\}) \rightarrow \mathcal{P}(Q)$.

---

## 2. Processamento e Tradução de Linguagens

### Pipeline de Compilação

O processo de tradução de código-fonte de alto nível para código executável divide-se nas seguintes fases formais:

```
[Código Fonte] 
      │
      ▼
┌─────────────────────────┐
│     Análise Léxica      │ ──> Converte caracteres em Tokens (RegEx)
└─────────────────────────┘
      │
      ▼
┌─────────────────────────┐
│    Análise Sintática    │ ──> Constrói a Árvores de Análise (BNF/EBNF)
└─────────────────────────┘
      │
      ▼
┌─────────────────────────┐
│    Análise Semântica    │ ──> Verificação de tipos e atribuições
└─────────────────────────┘
      │
      ▼
┌─────────────────────────┐
│ Geração / Otimização   │ ──> Código Intermediário / Código Objeto
└─────────────────────────┘

```

1. **Análise Léxica (Scanner):** Lê o fluxo de caracteres e agrupa-os em sequências com significado conceitual chamadas *lexemas*, traduzindo-os em *tokens*. É fundamentada por Expressões Regulares e Autômatos Finitos.
2. **Análise Sintática (Parser):** Verifica se a sequência de *tokens* obedece às regras estruturais da linguagem. Utiliza Notação de Backus-Naur (**BNF**) ou **EBNF** e gera a Árvore de Sintaxe Abstrata (AST).
* *Parsing Top-Down:* Constrói a árvore da raiz para as folhas (ex: LL).
* *Parsing Bottom-Up:* Constrói a árvore das folhas para a raiz (ex: LR, LALR).


3. **Análise Semântica:** Verifica a coerência do significado do programa (regras estáticas), realizando checagem de tipos (*type checking*), correspondência de parâmetros e verificação de escopo via Tabela de Símbolos.
4. **Geração e Otimização de Código Intermediário:** Converte a AST para uma representação independente de máquina (ex: *Bytecode*, Quadruplas) e aplica melhorias de desempenho.
5. **Geração de Código Objeto:** Traduz o código intermediário para a linguagem de máquina-alvo.

---

## 3. Paradigmas e Semântica de Linguagens

Um paradigma define o estilo de estruturação e execução dos programas.

### Comparativo dos Paradigmas Principais

* **Imperativo / Procedural:**
* *Foco:* Como resolver o problema (instruções passo a passo, mudança de estado e variáveis).
* *Mecanismos:* Atribuição, estruturas de controle sequencial, repetição e sub-rotinas.


* **Orientado a Objetos (POO):**
* *Foco:* Organização do sistema em entidades autônomas contendo estado e comportamento.
* *Pilares:* Abstração, Encapsulamento, Herança e Polimorfismo.


* **Funcional:**
* *Foco:* Avaliação de funções matemáticas puras sem efeito colateral.
* *Mecanismos:* Imutabilidade, Funções de Primeira Classe, Funções de Alta Ordem (*Higher-Order Functions*), Avaliação Preguiçosa (*Lazy Evaluation*) e Recursão.


* **Lógico:**
* *Foco:* Declaração de fatos, regras e relações. O motor de inferência deduz as respostas.
* *Mecanismos:* Unificação, Resolução e Retrocesso (*Backtracking*).



---

## 4. Sistemas de Tipos, Escopo e Execução

### Sistemas de Tipos

* **Checagem Estática vs. Dinâmica:**
* *Estática:* Os tipos das variáveis são verificados e validados em tempo de compilação (ex: C++, Java).
* *Dinâmica:* Os tipos estão associados aos valores e são verificados em tempo de execução (ex: Python, JavaScript).


* **Tipagem Forte vs. Fraca:**
* *Forte:* O sistema impede conversões implícitas não autorizadas entre tipos incompatíveis.
* *Fraca:* O sistema realiza conversões implícitas de tipo (*coerção*) com facilidade, permitindo operações heterogêneas sem erro imediato.



### Regras de Escopo e Amarração (Binding)

* **Escopo Estático (Léxico):** A associação entre nomes de variáveis e suas declarações é determinada pela estrutura textual do código-fonte em tempo de compilação.
* **Escopo Dinâmico:** A associação depende da pilha de chamadas de funções (*call stack*) ativa em tempo de execução.

### Passagem de Parâmetros e Gerenciamento de Memória

| Mecanismo | Descrição Técnica |
| --- | --- |
| **Passagem por Valor** | Copia o valor do argumento para o parâmetro formal da função. Alterações locais não afetam a variável externa. |
| **Passagem por Referência** | Passa o endereço de memória do argumento. Modificações no parâmetro afetam diretamente a variável original. |
| **Pilha (Stack)** | Região de memória utilizada para alocação estática e controle de chamadas de funções (frames). Possui acesso rápido e gerenciamento FIFO/LIFO automático. |
| **Heap** | Região de memória para alocação dinâmica (tempo de execução). Exige gerenciamento manual (como `malloc`/`free`) ou automático por *Garbage Collection*. |

---

## 5. Computabilidade e Decidibilidade

A Teoria da Computabilidade delimita as fronteiras teóricas do que pode ser resolvido por algoritmos.

### Tese de Church-Turing

Afirma que qualquer cálculo que possa ser realizado por um procedimento efetivo (algoritmo) pode ser simulado por uma **Máquina de Turing**.

### Decidibilidade e Indecidibilidade

* **Problema Decidível:** Existe uma Máquina de Turing que sempre para e fornece uma resposta correta ("sim" ou "não") para qualquer entrada válida.
* **Problema Indecidível:** Não existe um algoritmo genérico capaz de responder corretamente para todas as instâncias possíveis.
* **O Problema da Parada (Halting Problem):** Provado por Alan Turing, estabelece que é impossível construir um algoritmo geral que determine se um programa arbitrário irá parar ou rodar indefinidamente para uma determinada entrada.

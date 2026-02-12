# Funções do 2º Grau (Quadráticas)

## 1. Introdução
Uma função do 2º grau, ou função quadrática, é uma lei de formação matemática onde o maior expoente da variável independente ($x$) é 2. Ela é fundamental para modelar fenômenos físicos (como lançamento de projéteis), otimização de lucros e estruturas arquitetônicas.

## 2. Definição e Componentes
A forma geral da função do 2º grau é definida por:

$$f(x) = ax^2 + bx + c$$

### 2.1. Tabela de Coeficientes

| Coeficiente | Nome | Função no Gráfico | Restrição |
| :--- | :--- | :--- | :--- |
| **a** | Coeficiente Principal | Determina a concavidade da parábola. | $a \neq 0$ |
| **b** | Coeficiente Linear | Inclinação da parábola ao cruzar o eixo $y$. | $b \in \mathbb{R}$ |
| **c** | Termo Independente | Ponto onde a parábola intercepta o eixo $y$ $(0, c)$. | $c \in \mathbb{R}$ |

---

## 3. Comportamento Gráfico
O gráfico de uma função do 2º grau é sempre uma **parábola**.

### 3.1. Concavidade (Coeficiente $a$)
* Se **$a > 0$**: Concavidade voltada para **cima** (formato de "U"). A função possui um ponto de mínimo.
* Se **$a < 0$**: Concavidade voltada para **baixo** (formato de "U" invertido). A função possui um ponto de máximo.



---

## 4. Raízes da Função (Zeros da Função)
As raízes representam os valores de $x$ para os quais $f(x) = 0$. Para encontrá-las, utilizamos a **Fórmula de Bhaskara**.

### 4.1. O Discriminante ($\Delta$)
O valor de Delta determina a quantidade de intersecções com o eixo $x$:

| Valor de $\Delta$ | Resultado | Gráfico |
| :--- | :--- | :--- |
| $\Delta > 0$ | Duas raízes reais e distintas. | Corta o eixo $x$ em dois pontos. |
| $\Delta = 0$ | Uma raiz real (dupla). | Toca o eixo $x$ em apenas um ponto (Vértice). |
| $\Delta < 0$ | Nenhuma raiz real. | Não toca o eixo $x$. |

### 4.2. Fórmula de Bhaskara
1.  **Cálculo do Delta:** $$\Delta = b^2 - 4ac$$
2.  **Cálculo das Raízes:** $$x = \frac{-b \pm \sqrt{\Delta}}{2a}$$

---

## 5. Vértice da Parábola
O vértice $V(x_v, y_v)$ é o ponto crítico da função (ponto mais alto ou mais baixo).

### 5.1. Fórmulas do Vértice

| Coordenada | Fórmula | Utilidade |
| :--- | :--- | :--- |
| **X do Vértice ($x_v$)** | $$x_v = \frac{-b}{2a}$$ | Ponto médio entre as raízes. |
| **Y do Vértice ($y_v$)** | $$y_v = \frac{-\Delta}{4a}$$ | Valor máximo ou mínimo da função. |

---

## 6. Exemplo Prático Resolvido
Dada a função $f(x) = x^2 - 6x + 5$:

### Passo 1: Identificar coeficientes
* $a = 1, b = -6, c = 5$

### Passo 2: Calcular $\Delta$
$$\Delta = (-6)^2 - 4(1)(5)$$
$$\Delta = 36 - 20 = 16$$

### Passo 3: Encontrar as raízes
$$x = \frac{-(-6) \pm \sqrt{16}}{2(1)}$$
$$x = \frac{6 \pm 4}{2}$$
* $x_1 = 10 / 2 = 5$
* $x_2 = 2 / 2 = 1$

### Passo 4: Localizar o Vértice
* $x_v = -(-6) / 2(1) = 3$
* $y_v = -16 / 4(1) = -4$
* **Vértice:** $(3, -4)$

---

## 7. Aplicação em Tecnologia e Negócios
No contexto de sistemas SaaS e Análise de Dados:
1.  **Projeção de Lucros:** Modelar o ponto ideal de precificação onde o aumento do preço começa a diminuir o volume de vendas (ponto de máximo).
2.  **Algoritmos de Busca:** Otimização de funções de custo em Machine Learning.
3.  **Física de Jogos:** Cálculo de trajetória de objetos em interfaces gráficas.

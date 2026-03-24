# Correlação e Regressão Linear

## 1. Introdução e Objetivos Principais
O principal objetivo deste estudo é entender como duas variáveis se comportam juntas. Especificamente, buscamos:
1.  [cite_start]**Avaliar o grau de dependência:** Descobrir se (e o quanto) uma variável influencia a outra[cite: 6, 7].
2.  [cite_start]**Encontrar a equação matemática:** Criar um modelo que represente essa relação[cite: 8, 9].

Existem dois tipos principais de relações:
* **Relação Funcional (Exata):** Acontece quando o valor de uma variável determina exatamente o valor da outra. [cite_start]Por exemplo, a conta de água: o valor final está diretamente ligado ao consumo exato em metros cúbicos ($m^3$)[cite: 10, 11, 16].
* **Relação Estatística (Tendência):** Acontece quando as variáveis estão correlacionadas, mas a relação não é matematicamente exata ou imediata. [cite_start]Por exemplo, a relação entre a incidência de uma doença e uma população[cite: 17, 18]. É aqui que a estatística entra.

---

## 2. O Diagrama de Dispersão
Antes de calcular qualquer coisa, a melhor forma de entender os dados é visualizá-los. [cite_start]O **Diagrama de Dispersão** é um gráfico no plano cartesiano onde cada ponto representa um par de dados (X e Y)[cite: 19, 44].

[cite_start]Ao plotar os dados, a nuvem de pontos revela o tipo de correlação[cite: 44, 46]:
* **Linear Positiva:** Quando X aumenta, Y também aumenta. [cite_start]Os pontos formam uma linha subindo[cite: 49].
* **Linear Negativa:** Quando X aumenta, Y diminui. [cite_start]Os pontos formam uma linha descendo[cite: 63].
* [cite_start]**Perfeita:** Todos os pontos se alinham perfeitamente em cima de uma reta (positiva ou negativa)[cite: 95, 99].
* [cite_start]**Nula:** Os pontos ficam totalmente dispersos, indicando que não há relação entre as variáveis[cite: 105, 112].
* [cite_start]**Não-Linear:** Há uma relação, mas ela forma uma curva (como uma parábola), não uma linha reta[cite: 89, 113].

---

## 3. Coeficiente de Correlação de Pearson ($r$)
[cite_start]O diagrama de dispersão dá uma ideia visual, mas precisamos de um número exato para medir a *força* e a *direção* dessa relação[cite: 108]. Esse número é o Coeficiente de Correlação, representado pela letra $r$.

### A Fórmula do Coeficiente ($r$):
[cite_start]$$r = \frac{n \cdot \sum x \cdot y - (\sum x) \cdot (\sum y)}{\sqrt{[n \cdot \sum x^2 - (\sum x)^2][n \cdot \sum y^2 - (\sum y)^2]}}$$ [cite: 109]

**Dissecando a fórmula (O que você precisa calcular antes):**
[cite_start]Para resolver essa fórmula, é altamente recomendável criar uma tabela auxiliar (como mostrado no slide 17) [cite: 115] com as seguintes colunas para encontrar as somatórias ($\sum$):
* [cite_start]$n$: O tamanho da sua amostra (número de pares de dados)[cite: 109, 117].
* $\sum x$: A soma de todos os valores de X.
* $\sum y$: A soma de todos os valores de Y.
* $\sum x \cdot y$: A soma das multiplicações de cada X pelo seu par Y.
* $\sum x^2$: A soma dos quadrados de cada valor de X.
* $\sum y^2$: A soma dos quadrados de cada valor de Y.

### Como Interpretar o Resultado de $r$:
[cite_start]O valor de $r$ sempre estará entre **-1 e +1**[cite: 111].
* [cite_start]**$r = +1$**: Correlação Perfeita Positiva[cite: 111].
* [cite_start]**$r = -1$**: Correlação Perfeita Negativa[cite: 111].
* [cite_start]**$r = 0$**: Correlação Nula (ou não-linear)[cite: 112, 113].
* **$0.6 \le |r| [cite_start]\le 1$**: Indica uma correlação linear considerada forte a perfeita[cite: 114]. Quanto mais próximo de 1 ou -1, mais forte é a relação.

---

## 4. Regressão Linear ($y = ax + b$)
[cite_start]Se o coeficiente $r$ mostrar que existe uma boa correlação, o próximo passo é criar um **modelo matemático**[cite: 130]. A Regressão Linear encontra a "melhor reta" que passa no meio daquela nuvem de pontos do diagrama de dispersão.

[cite_start]Essa reta permite fazer previsões: se eu tiver um novo valor para a variável independente ($X$), qual será o provável valor da variável dependente ($Y$)?[cite: 131, 138].

### A Equação da Reta:
[cite_start]$$y = ax + b$$ [cite: 140]

Para montar essa equação, você precisa descobrir os coeficientes $a$ e $b$.

### 4.1. Calculando o coeficiente angular ($a$)
[cite_start]O valor de $a$ define a inclinação da reta[cite: 140, 142]. Note que a fórmula de $a$ é praticamente idêntica à parte esquerda da fórmula de $r$ (sem a raiz quadrada e sem a parte do Y no denominador):

[cite_start]$$a = \frac{n \cdot \sum x \cdot y - (\sum x) \cdot (\sum y)}{n \cdot \sum x^2 - (\sum x)^2}$$ [cite: 142]

### 4.2. Calculando o coeficiente linear ($b$)
[cite_start]O valor de $b$ é o ponto onde a reta cruza o eixo Y. Para calculá-lo, você precisa primeiro achar as médias de X e Y ($\overline{x}$ e $\overline{y}$)[cite: 143, 144].

1.  [cite_start]Média de X: $\overline{x} = \frac{\sum x}{n}$ [cite: 144]
2.  [cite_start]Média de Y: $\overline{y} = \frac{\sum y}{n}$ [cite: 144]
3.  [cite_start]Fórmula de $b$: $$b = \overline{y} - a \cdot \overline{x}$$ [cite: 143]

[cite_start]Substituindo $a$ e $b$ na equação $y = ax + b$, você tem o seu modelo final[cite: 140, 154].

---

## Resumo do Fluxo de Trabalho (Algoritmo de Resolução)
[cite_start]Para resolver qualquer questão desse assunto[cite: 166, 167, 168]:
1.  **Monte a tabela** estendida com as colunas: $X$, $Y$, $X \cdot Y$, $X^2$, $Y^2$.
2.  **Some** todas as colunas para achar os valores de $\sum$.
3.  **Calcule $r$** (Pearson) para validar se há correlação.
4.  **Calcule $a$** usando as somatórias.
5.  **Calcule as médias** de X e Y.
6.  **Calcule $b$** usando a média de Y, a média de X e o valor de $a$.
7.  **Monte a equação** final $y = ax + b$.

---

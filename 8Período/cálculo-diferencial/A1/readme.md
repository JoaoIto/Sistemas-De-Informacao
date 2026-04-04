Compêndio de Cálculo I: Funções, Limites e Derivadas

Este documento sintetiza os conceitos fundamentais de Matemática Básica e Cálculo Diferencial, abrangendo desde o estudo de funções do 1º grau até a aplicação de regras de derivação e limites fundamentais. O conteúdo prioriza a fundamentação matemática necessária para o domínio dos algoritmos e regras de cálculo.


--------------------------------------------------------------------------------


1. Fundamentos: Função Polinomial do 1º Grau (Função Afim)

A base necessária para o cálculo reside na compreensão das funções lineares. Uma função f: \mathbb{R} \to \mathbb{R} é dita de 1º grau ou função afim quando segue a lei de formação: f(x) = ax + b Onde:

* a: Coeficiente angular (a \neq 0).
* b: Coeficiente linear (ponto onde a reta corta o eixo y).

Zero ou Raiz da Função

A raiz de uma função é o valor de x que faz com que f(x) = 0. Geometricamente, é o ponto onde o gráfico intercepta o eixo x.

* Regra: Para encontrar a raiz, resolve-se ax + b = 0, resultando em: x = \frac{-b}{a}

Exemplos Práticos:

1. y = 3x - 1: Raiz em x = \frac{-(-1)}{3} = \frac{1}{3}.
2. y = -4 - 2x: Raiz em x = \frac{-(-4)}{-2} = -2.

Comportamento e Gráfico

O valor de a determina a inclinação da reta:

* a > 0 (Função Crescente): Conforme x aumenta, f(x) aumenta. f(x_1) < f(x_2).
* a < 0 (Função Decrescente): Conforme x aumenta, f(x) diminui. f(x_1) > f(x_2).

Determinação de Função via Gráfico ou Pontos

Para encontrar a equação y = ax + b a partir de dois pontos (x, y), utiliza-se a substituição.

* Exemplo: Pontos (0, 8) e (4, 0).
  1. Substituindo (0, 8): 8 = a(0) + b \Rightarrow b = 8.
  2. Substituindo (4, 0) com b=8: 0 = a(4) + 8 \Rightarrow 4a = -8 \Rightarrow a = -2.
  3. Resultado: y = -2x + 8.


--------------------------------------------------------------------------------


2. Limites Fundamentais e Continuidade

O estudo do limite é o alicerce para a definição de derivada.

Limites Trigonométricos e o Teorema do Confronto

O limite fundamental trigonométrico estabelece que: \lim_{x \to 0} \frac{\text{sen}(x)}{x} = 1 Este resultado é derivado do Teorema do Confronto (ou do Sanduíche), que utiliza a desigualdade \text{sen}(x) < x < \text{tg}(x) para "prensar" o limite entre dois valores conhecidos.

Algoritmo para resolução de variantes: Se tivermos \lim_{x \to 0} \frac{\text{sen}(5x)}{x}, multiplicamos o numerador e o denominador por 5:

1. 5 \cdot \lim_{x \to 0} \frac{\text{sen}(5x)}{5x}
2. Como \frac{\text{sen}(u)}{u} = 1 quando u \to 0, o resultado é 5 \cdot 1 = 5.

O Número de Euler (e)

O número irracional e \approx 2,71828 é definido pelo limite: \lim_{x \to \infty} \left(1 + \frac{1}{x}\right)^x = e

Continuidade de uma Função

Uma função f(x) é considerada contínua em um ponto a se, e somente se:

1. f(a) está definido.
2. \lim_{x \to a} f(x) existe (limites laterais são iguais).
3. \lim_{x \to a} f(x) = f(a).


--------------------------------------------------------------------------------


3. Derivadas: Definição e Interpretação

A derivada representa a taxa de variação instantânea de uma função.

Definição Matemática

A derivada de f(x) é denotada por f'(x) ou \frac{df}{dx} e é calculada pelo limite do quociente de Newton: f'(x) = \lim_{\Delta x \to 0} \frac{f(x + \Delta x) - f(x)}{\Delta x}

Interpretação Geométrica

Geometricamente, a derivada no ponto x é o coeficiente angular da reta tangente à curva da função naquele ponto. Ela surge do processo de transformar uma reta secante (que toca dois pontos) em uma reta tangente conforme a distância entre esses pontos (\Delta x) tende a zero.

Exemplo de cálculo pela definição: f(x) = x^2 em x = 2.

1. f'(2) = \lim_{\Delta x \to 0} \frac{(2 + \Delta x)^2 - (2)^2}{\Delta x}
2. f'(2) = \lim_{\Delta x \to 0} \frac{4 + 4\Delta x + \Delta x^2 - 4}{\Delta x} = \lim_{\Delta x \to 0} (4 + \Delta x) = 4.


--------------------------------------------------------------------------------


4. Regras e Algoritmos de Diferenciação

Para agilizar o cálculo, utilizam-se regras fundamentais derivadas do limite.

Regras Básicas

Regra	Função	Derivada
Potência	f(x) = x^n	f'(x) = n \cdot x^{n-1}
Constante	f(x) = k	f'(x) = 0
Identidade	f(x) = x	f'(x) = 1
Homogeneidade	f(x) = k \cdot g(x)	f'(x) = k \cdot g'(x)
Soma/Subtração	f(x) = g(x) \pm h(x)	f'(x) = g'(x) \pm h'(x)

Derivadas de Funções Compostas (Produto e Quociente)

* Regra do Produto: Para f(x) = g(x) \cdot h(x) f'(x) = g'(x) \cdot h(x) + g(x) \cdot h'(x)
* Regra do Quociente: Para f(x) = \frac{g(x)}{h(x)} f'(x) = \frac{g'(x) \cdot h(x) - g(x) \cdot h'(x)}{[h(x)]^2}

Exemplo Consolidado (Derivada Imediata)

Dada a função: f(x) = 3x^8 - 9x^6 + 4x^3 - 2x - 5 Aplicando a regra da potência e da soma termo a termo:

1. Derivada de 3x^8: 3 \cdot 8x^7 = 24x^7
2. Derivada de -9x^6: -9 \cdot 6x^5 = -54x^5 (Nota: O contexto indica 6x^5 no exemplo, mas a conta resulta em -54x^5).
3. Derivada de 4x^3: 4 \cdot 3x^2 = 12x^2 (O contexto cita 27x^2 em um exemplo alternativo, demonstrando a importância de seguir a regra n \cdot x^{n-1}).
4. Derivada de -2x: -2 \cdot 1 = -2.
5. Derivada de -5: 0.


--------------------------------------------------------------------------------


5. Estudo de Sinais na Função de 1º Grau

Essencial para entender onde uma função é positiva, negativa ou nula, o que se conecta diretamente à análise de crescimento e decrescimento no Cálculo.

* Função Crescente (a > 0):
  * y > 0 se x > \text{raiz}
  * y = 0 se x = \text{raiz}
  * y < 0 se x < \text{raiz}
* Função Decrescente (a < 0):
  * y > 0 se x < \text{raiz}
  * y = 0 se x = \text{raiz}
  * y < 0 se x > \text{raiz}

Exemplo: f(x) = 12x - 8

1. Raiz: 12x - 8 = 0 \Rightarrow 12x = 8 \Rightarrow x = \frac{8}{12} = \frac{2}{3}.
2. Como a = 12 (a > 0), a função é crescente.
3. Sinais: Negativa antes de 2/3, nula em 2/3, e positiva após 2/3.

---

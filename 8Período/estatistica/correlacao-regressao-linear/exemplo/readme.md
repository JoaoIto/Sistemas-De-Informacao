# Exercício de exemplo:

### Passo 1: Construir a Tabela Estendida
O segredo para não errar a regressão linear é organizar os dados antes de encostar na fórmula. [cite_start]Precisamos calcular $X \cdot Y$, $X^2$ e $Y^2$ para cada linha[cite: 115].

| Preço ($X$) | Demanda ($Y$) | $X \cdot Y$ | $X^2$ | $Y^2$ |
| :--- | :--- | :--- | :--- | :--- |
| 38 | 350 | 13.300 | 1.444 | 122.500 |
| 42 | 325 | 13.650 | 1.764 | 105.625 |
| 50 | 297 | 14.850 | 2.500 | 88.209 |
| 56 | 270 | 15.120 | 3.136 | 72.900 |
| 59 | 256 | 15.104 | 3.481 | 65.536 |
| 63 | 246 | 15.498 | 3.969 | 60.516 |
| 70 | 238 | 16.660 | 4.900 | 56.644 |
| 80 | 223 | 17.840 | 6.400 | 49.729 |
| 95 | 215 | 20.425 | 9.025 | 46.225 |
| 110 | 208 | 22.880 | 12.100 | 43.264 |
| **$\sum X = 663$** | **$\sum Y = 2.628$** | **$\sum XY = 165.327$** | **$\sum X^2 = 48.719$** | **$\sum Y^2 = 711.148$** |

*Nota: $n = 10$ (pois temos 10 pares de dados).*

---

### Passo 2: Calcular o Coeficiente de Correlação ($r$)
[cite_start]Agora pegamos os totais da tabela e jogamos na fórmula de Pearson[cite: 109]. Ela assusta, mas é só substituição:

$$r = \frac{n \cdot \sum XY - (\sum X) \cdot (\sum Y)}{\sqrt{[n \cdot \sum X^2 - (\sum X)^2][n \cdot \sum Y^2 - (\sum Y)^2]}}$$

Substituindo com os nossos totais:
$$r = \frac{10(165.327) - (663)(2.628)}{\sqrt{[10(48.719) - (663)^2][10(711.148) - (2.628)^2]}}$$
$$r = \frac{1.653.270 - 1.742.364}{\sqrt{[487.190 - 439.569][7.111.480 - 6.906.384]}}$$
$$r = \frac{-89.094}{\sqrt{[47.621][205.096]}}$$
$$r = \frac{-89.094}{\sqrt{9.766.876.616}}$$
$$r = \frac{-89.094}{98.827,51}$$
**$r \approx -0,9015$**

[cite_start]**Interpretação:** Temos uma **correlação linear negativa muito forte**[cite: 111]. Faz todo sentido na economia: quando o preço ($X$) sobe, a demanda ($Y$) cai.

---

### Passo 3: Encontrar a Equação da Reta ($y = ax + b$)
[cite_start]Como a correlação é forte, vale a pena criar o modelo matemático[cite: 130].

**1. Calculando $a$ (a inclinação da reta):**
[cite_start]A fórmula de $a$ usa a mesma parte de cima do $r$, dividida apenas pela parte de $X$ da raiz[cite: 142]:

$$a = \frac{n \cdot \sum XY - (\sum X) \cdot (\sum Y)}{n \cdot \sum X^2 - (\sum X)^2}$$
$$a = \frac{-89.094}{47.621}$$
**$a \approx -1,87$**

**2. Calculando as Médias:**
* [cite_start]Média de $X (\overline{x}) = 663 / 10 = 66,3$ [cite: 144]
* [cite_start]Média de $Y (\overline{y}) = 2.628 / 10 = 262,8$ [cite: 144]

**3. Calculando $b$ (o ponto de interceptação):**
$$b = \overline{y} - a \cdot \overline{x}$$
$$b = 262,8 - (-1,87 \cdot 66,3)$$
$$b = 262,8 - (-123,98)$$
**$b \approx 386,78$** *(O quadro da sua foto mostrava 388,77, o que indica que o professor usou arredondamentos um pouco diferentes durante as etapas, mas a lógica e os valores base são exatamente os mesmos).*

### Resposta Final do Exercício
A equação que descreve a relação entre o preço e a demanda desse produto é:
**$Y = -1,87X + 386,78$**

---

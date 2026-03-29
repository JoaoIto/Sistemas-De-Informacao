# Parte 1: Distribuição de Frequência com Intervalos de Classe

Quando temos muitos dados, agrupá-los em intervalos (classes) facilita a visualização do comportamento geral. 

**O Cenário:** Coletamos o tempo de uso de 20 usuários e agrupamos os dados.
* **$i$**: Número da classe.
* **Classes**: Os intervalos de tempo (ex: $10 \vdash 20$ significa de 10 até quase 20).
* **$f_i$ (Frequência Simples)**: Quantos usuários caíram naquela classe.
* **$x_i$ (Ponto Médio)**: O meio da classe (usado para representar a classe toda nos cálculos). Calcula-se somando os limites e dividindo por 2.
* **$F_{ac}$ (Frequência Acumulada)**: A soma das frequências passo a passo (usada para achar posições).

**A Tabela de Trabalho Essencial:**
Antes de olhar para as fórmulas, você **precisa** expandir a tabela da prova com as colunas $x_i$, $F_{ac}$, $x_i \cdot f_i$ (para a média) e $(x_i - \bar{x})^2 \cdot f_i$ (para o desvio padrão).

| $i$ | Classes (min) | $f_i$ | $x_i$ | $F_{ac}$ | $x_i \cdot f_i$ |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | $10 \vdash 20$ | 4 | 15 | 4 | 60 |
| 2 | $20 \vdash 30$ | 10 | 25 | 14 | 250 |
| 3 | $30 \vdash 40$ | 4 | 35 | 18 | 140 |
| 4 | $40 \vdash 50$ | 2 | 45 | 20 | 90 |
| **Total**| | **$n = 20$** | | | **$\sum = 540$** |

*(Dica: A amplitude das classes, chamada de $h$, é 10, pois os intervalos pulam de 10 em 10).*

---

#### 1. Medidas de Tendência Central

**A. Média ($\bar{x}$)**
* **Conceito:** O ponto de equilíbrio dos dados.
* **Fórmula:** $$\bar{x} = \frac{\sum (x_i \cdot f_i)}{n}$$
* **Cálculo:** $$\bar{x} = \frac{540}{20} = 27$$
* **Interpretação:** Em média, os usuários passam 27 minutos no sistema.

**B. Mediana ($Md$)**
* **Conceito:** O valor que divide os dados exatamente ao meio (50% abaixo, 50% acima).
* **Passo 1:** Encontre a posição da mediana ($Pos = n / 2 = 20 / 2 = 10$). Olhando a coluna $F_{ac}$, o 10º dado está na **Classe 2** ($20 \vdash 30$).
* **Fórmula:** $$Md = l_{md} + \left( \frac{\frac{n}{2} - F_{ant}}{f_{md}} \right) \cdot h$$
    * $l_{md} = 20$ (Limite inferior da classe mediana)
    * $F_{ant} = 4$ (Frequência acumulada da classe anterior)
    * $f_{md} = 10$ (Frequência simples da classe mediana)
    * $h = 10$ (Amplitude)
* **Cálculo:** $$Md = 20 + \left( \frac{10 - 4}{10} \right) \cdot 10 = 20 + \left(\frac{6}{10}\right) \cdot 10 = 26$$

**C. Moda ($Mo$) - Fórmula de Czuber**
* **Conceito:** O valor mais frequente.
* **Passo 1:** Identifique a classe modal (a que tem o maior $f_i$). É a **Classe 2**, com $f_i = 10$.
* **Fórmula:** $$Mo = l_{mo} + \left( \frac{\Delta_1}{\Delta_1 + \Delta_2} \right) \cdot h$$
    * $\Delta_1 = f_{mo} - f_{ant} = 10 - 4 = 6$
    * $\Delta_2 = f_{mo} - f_{post} = 10 - 4 = 6$
* **Cálculo:** $$Mo = 20 + \left( \frac{6}{6 + 6} \right) \cdot 10 = 20 + 0,5 \cdot 10 = 25$$

---

#### 2. Medidas de Dispersão e Posição

**A. Desvio Padrão ($S$)**
* **Conceito:** O quanto os dados se afastam, em média, da Média.
* **Fórmula da Variância Amostral:** $$S^2 = \frac{\sum f_i(x_i - \bar{x})^2}{n-1}$$
    * Para a classe 1: $4 \cdot (15 - 27)^2 = 4 \cdot 144 = 576$
    * Para a classe 2: $10 \cdot (25 - 27)^2 = 10 \cdot 4 = 40$
    * Para a classe 3: $4 \cdot (35 - 27)^2 = 4 \cdot 64 = 256$
    * Para a classe 4: $2 \cdot (45 - 27)^2 = 2 \cdot 324 = 648$
    * Soma total = $1520$.
* **Cálculo:** $$S^2 = \frac{1520}{19} = 80$$
    $$S = \sqrt{80} \approx 8,94$$

**B. Quartis ($Q_1$ e $Q_3$)**
* **Conceito:** Dividem os dados em 4 partes. $Q_1$ marca os 25% menores; $Q_3$ marca os 75%. A fórmula é idêntica à da mediana, só muda a posição.
* **Cálculo $Q_1$:** Posição $= \frac{1 \cdot 20}{4} = 5$. Está na **Classe 2**.
    $$Q_1 = 20 + \left( \frac{5 - 4}{10} \right) \cdot 10 = 21$$
* **Cálculo $Q_3$:** Posição $= \frac{3 \cdot 20}{4} = 15$. Está na **Classe 3** (onde o $F_{ac}$ passa de 15).
    $$Q_3 = 30 + \left( \frac{15 - 14}{4} \right) \cdot 10 = 30 + 2,5 = 32,5$$

**C. Percentis ($P_{10}$ e $P_{90}$)**
* **Conceito:** Dividem os dados em 100 partes. O mecanismo é o mesmo.
* **Cálculo $P_{10}$:** Posição $= \frac{10 \cdot 20}{100} = 2$. Está na **Classe 1**.
    $$P_{10} = 10 + \left( \frac{2 - 0}{4} \right) \cdot 10 = 15$$
* **Cálculo $P_{90}$:** Posição $= \frac{90 \cdot 20}{100} = 18$. Está na **Classe 3**.
    $$P_{90} = 30 + \left( \frac{18 - 14}{4} \right) \cdot 10 = 40$$

---

#### 3. Forma da Distribuição

Esses coeficientes dizem qual é o "desenho" do gráfico sem precisar desenhá-lo.

**A. Coeficiente de Assimetria de Pearson ($As$)**
* **Conceito:** Indica se a cauda do gráfico está mais esticada para a direita, esquerda ou se é simétrica.
* **Fórmula:** $$As = \frac{3(\bar{x} - Md)}{S}$$
* **Cálculo:** $$As = \frac{3(27 - 26)}{8,94} \approx 0,33$$
* **Interpretação:** Como $As > 0$, a assimetria é **Positiva** (a cauda se alonga para os valores maiores).

**B. Coeficiente de Curtose ($K$)**
* **Conceito:** Mede o grau de achatamento da curva em relação a uma curva normal.
* **Fórmula:** $$K = \frac{Q_3 - Q_1}{2(P_{90} - P_{10})}$$
* **Cálculo:** $$K = \frac{32,5 - 21}{2(40 - 15)} = \frac{11,5}{50} = 0,23$$
* **Interpretação:** * Se $K \approx 0,263$: Mesocúrtica (Normal).
    * Se $K < 0,263$: **Leptocúrtica** (Mais pontiaguda e alta). É o nosso caso.
    * Se $K > 0,263$: Platicúrtica (Mais achatada).

---

# Parte 2: Correlação e Regressão Linear (Guia Expresso)

A estatística bivariada estuda como a variável $X$ impacta a variável $Y$. 

**O Passo a Passo de Sobrevivência para a Prova:**

1.  **Construa a Tabela Base:** A sua prova fornecerá duas colunas de dados ($X$ e $Y$). A primeira coisa que você fará é criar mais três colunas: $X \cdot Y$, $X^2$ e $Y^2$. Some todas as 5 colunas no final.
2.  **Verifique a Correlação (Pearson $r$):** $$r = \frac{n \cdot \sum XY - (\sum X) \cdot (\sum Y)}{\sqrt{[n \cdot \sum X^2 - (\sum X)^2][n \cdot \sum Y^2 - (\sum Y)^2]}}$$
    Isso vai gerar um número entre -1 e +1. Se for próximo de zero, pare, os dados não têm relação. Se for próximo de 1 ou -1, prossiga.
3.  **Ache a Inclinação da Reta ($a$):**
    $$a = \frac{n \cdot \sum XY - (\sum X) \cdot (\sum Y)}{n \cdot \sum X^2 - (\sum X)^2}$$
4.  **Ache o Ponto de Cruzamento ($b$):**
    Calcule as médias ($\bar{x}$ e $\bar{y}$) dividindo o somatório total de cada variável por $n$. Depois aplique:
    $$b = \bar{y} - a \cdot \bar{x}$$
5.  **Monte a Equação Final:**
    $$y = ax + b$$
    Com essa fórmula em mãos, você pode prever qualquer valor futuro de $Y$ substituindo o $X$ na equação.


---

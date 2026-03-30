# Mapa Mental com fórmulas

<img width="2816" height="1536" alt="Gemini_Generated_Image_tpj8qntpj8qntpj8" src="https://github.com/user-attachments/assets/314348f4-008d-47e4-932a-432bc5fe3e2f" />


# PARTE 1: Distribuição de Frequência (Dados Agrupados)

Antes de aplicar qualquer fórmula desta seção, você precisa da **Tabela Base**. A partir das Classes e da Frequência Simples ($f_i$), você sempre deve calcular:
* **Amplitude ($h$):** A diferença entre os limites da classe (Ex: de $10 \vdash 20$, $h = 10$).
* **Ponto Médio ($x_i$):** O representante da classe. Soma os limites e divide por 2.
* **Frequência Acumulada ($F_{ac}$):** A soma contínua do $f_i$ linha por linha (a "fila indiana").

## 1. Medidas de Tendência Central (O "Centro" dos Dados)

### A) Média Aritmética ($\bar{x}$)
* **Para que serve:** Encontrar o ponto de equilíbrio global dos dados.
* **O que você precisa:** Multiplicar o Ponto Médio ($x_i$) de cada linha pela sua frequência ($f_i$), somar tudo e dividir pelo total de itens ($n$).
* **A Fórmula:**
$$\bar{x} = \frac{\sum (x_i \cdot f_i)}{n}$$

### B) Mediana ($Md$)
* **Para que serve:** Encontrar o valor exato que divide os dados em duas metades iguais (50%). É imune a valores extremos.
* **O que você precisa:** Primeiro, ache a posição alvo fazendo $\frac{n}{2}$. Olhe na coluna $F_{ac}$ para descobrir em qual classe essa posição cai. Depois, pegue os dados **dessa classe** para a fórmula.
* **A Fórmula:**
$$Md = l + \left( \frac{\frac{n}{2} - F_{ant}}{f_{md}} \right) \cdot h$$
> **Legenda:** > $l$ = Limite inferior da classe mediana
> $F_{ant}$ = Frequência Acumulada da classe de *cima* (anterior)
> $f_{md}$ = Frequência simples da própria classe mediana
> $h$ = Amplitude da classe

### C) Moda - Fórmula de Czuber ($Mo$)
* **Para que serve:** Encontrar o valor matemático mais frequente.
* **O que você precisa:** Olhar a coluna $f_i$ e achar o maior número. Essa é a classe modal.
* **A Fórmula:**
$$Mo = l + \left( \frac{\Delta_1}{\Delta_1 + \Delta_2} \right) \cdot h$$
> **Legenda:**
> $\Delta_1$ = Frequência da classe modal *menos* a frequência da classe anterior.
> $\Delta_2$ = Frequência da classe modal *menos* a frequência da classe posterior.

---

## 2. Medidas de Posição (Fatiando os Dados)

A lógica aqui é **exatamente a mesma da Mediana**. A fórmula não muda estruturalmente, só muda o cálculo da **Posição** que você vai procurar na coluna $F_{ac}$.

### A) Quartis ($Q_1$ e $Q_3$)
* **Para que servem:** $Q_1$ acha o limite dos 25% menores valores. $Q_3$ acha o limite dos 75%.
* **As Posições:** Para $Q_1$, calcule $\frac{1 \cdot n}{4}$. Para $Q_3$, calcule $\frac{3 \cdot n}{4}$.
* **A Fórmula (Exemplo do $Q_1$):**
$$Q_1 = l + \left( \frac{\text{Posição} - F_{ant}}{f_{q1}} \right) \cdot h$$

### B) Percentis ($P_{10}$ e $P_{90}$)
* **Para que servem:** Fatiam os dados em 100 partes. O $P_{10}$ isola os 10% menores e o $P_{90}$ isola a "cauda" dos 10% maiores.
* **As Posições:** Para $P_{10}$, calcule $\frac{10 \cdot n}{100}$. Para $P_{90}$, calcule $\frac{90 \cdot n}{100}$.
* **A Fórmula (Exemplo do $P_{90}$):**
$$P_{90} = l + \left( \frac{\text{Posição} - F_{ant}}{f_{p90}} \right) \cdot h$$

---

## 3. Medidas de Dispersão (O Nível de Variação)

### A) Variância Amostral ($S^2$)
* **Para que serve:** É uma etapa intermediária para o desvio padrão. Mede a dispersão dos dados ao quadrado para eliminar números negativos.
* **O que você precisa:** Da Média ($\bar{x}$). Para cada linha, você faz: $(x_i - \bar{x})^2 \cdot f_i$. Depois soma tudo.
* **A Fórmula:**
$$S^2 = \frac{\sum f_i(x_i - \bar{x})^2}{n - 1}$$

### B) Desvio Padrão ($S$)
* **Para que serve:** Mede, na mesma unidade dos dados originais, o quanto os valores se afastam da média. Mostra se a distribuição é estável ou caótica.
* **A Fórmula:**
$$S = \sqrt{S^2}$$

### C) Coeficiente de Variação ($CV$) *(Dica de Prova)*
* **Para que serve:** Compara a dispersão entre bases de dados diferentes transformando o desvio padrão em porcentagem. Útil se a prova pedir "Qual grupo é mais regular/homogêneo?".
* **A Fórmula:**
$$CV = \left( \frac{S}{\bar{x}} \right) \cdot 100$$
*(Quanto menor o CV, mais estáveis/regulares são os dados).*

---

## 4. Medidas de Forma (O Formato do Gráfico)

### A) Coeficiente de Assimetria de Pearson ($As$)
* **Para que serve:** Diz para qual lado a cauda do gráfico está repuxada.
* **O que você precisa:** Média, Mediana e Desvio Padrão.
* **A Fórmula:**
$$As = \frac{3(\bar{x} - Md)}{S}$$
> **Regras:** $As > 0$ (Positiva/Direita); $As < 0$ (Negativa/Esquerda); $As = 0$ (Simétrica).

### B) Coeficiente de Curtose ($K$)
* **Para que serve:** Diz se o pico do gráfico é achatado ou pontiagudo.
* **O que você precisa:** Dos Quartis ($Q_1, Q_3$) e Percentis ($P_{10}, P_{90}$).
* **A Fórmula:**
$$K = \frac{Q_3 - Q_1}{2(P_{90} - P_{10})}$$
> **Regras:** $K < 0,263$ (Leptocúrtica/Pontiaguda); $K > 0,263$ (Platicúrtica/Achatada); $K = 0,263$ (Mesocúrtica/Normal).

---
---

# PARTE 2: Correlação e Regressão Linear

Aqui nós lidamos com pares de dados ($X$ e $Y$). A sua tabela de trabalho **precisa** ter as colunas extras: $X \cdot Y$, $X^2$ e $Y^2$. Você fará a soma ($\sum$) de todas as 5 colunas no final.

### A) Coeficiente de Correlação de Pearson ($r$)
* **Para que serve:** Medir se existe uma relação linear entre $X$ e $Y$, e qual a força dessa relação (varia de -1 a +1).
* **A Fórmula:**
$$r = \frac{n \cdot \sum XY - (\sum X) \cdot (\sum Y)}{\sqrt{[n \cdot \sum X^2 - (\sum X)^2] \cdot [n \cdot \sum Y^2 - (\sum Y)^2]}}$$
*(Se $r=0$, não há correlação linear. Se próximo de 1, há correlação forte positiva. Se próximo de -1, correlação forte negativa).*

### B) Reta de Regressão Linear ($Y = aX + b$)
* **Para que serve:** Criar um modelo matemático para prever valores de $Y$ baseados em $X$. 

**1. O Coeficiente Angular/Inclinação ($a$):**
Mede a taxa de crescimento/decaimento. A fórmula é idêntica à do Pearson, mas sem a raiz e sem a parte do $Y$ embaixo.
$$a = \frac{n \cdot \sum XY - (\sum X) \cdot (\sum Y)}{n \cdot \sum X^2 - (\sum X)^2}$$

**2. O Coeficiente Linear/Intercepto ($b$):**
Mede o ponto de partida (o valor de $Y$ quando $X = 0$).
* **O que você precisa:** Achar a média de X ($\bar{X} = \frac{\sum X}{n}$) e a média de Y ($\bar{Y} = \frac{\sum Y}{n}$).
* **A Fórmula:**
$$b = \bar{Y} - a \cdot \bar{X}$$

---


# Atividade 4: Manual Didático: Posição, Dispersão, Separatrizes e Assimetria

Atividade 4: Manual Didático: Posição, Dispersão, Separatrizes e Assimetria. Este guia está dividido nas exatas competências que a sua atividade exige. Vamos transformar fórmulas complexas em um raciocínio lógico de processamento de dados.

## 1. Dissecando a Tabela de Frequência Contínua

*(Foco: Resolver a Questão 1 da atividade)*

Quando os dados possuem muitas casas decimais (como medidas de peso, altura ou espessura), nós os agrupamos em intervalos contínuos.

### Exemplo Didático Base:

Imagine que medimos o peso de algumas sementes em gramas.

| Classe | Intervalos (Pesos) | Frequência Simples ($f_i$) |
| --- | --- | --- |
| 1ª | 2,75 $\vdash$ 2,80 | 2 |
| 2ª | 2,80 $\vdash$ 2,85 | 3 |
| 3ª | 2,85 $\vdash$ 2,90 | 10 |
| **Total** | - | **n = 15** |

### Como extrair informações cruciais desta matriz:

1. **Limites da Classe ($L_i$ e $L_s$):** O limite inferior ($L_i$) é onde a classe começa. O superior ($L_s$) é onde termina. Na 2ª classe, $L_i = 2,80$ e $L_s = 2,85$.
2. **Frequência Absoluta ($f_i$):** É simplesmente o número que está na coluna $f_i$ daquela linha específica. A frequência da 3ª classe é 10.
3. **Frequência Total ($n$ ou $\Sigma f_i$):** A soma de toda a coluna $f_i$. Aqui, o total é 15.
4. **Amplitude do Intervalo de Classe ($h$):** É o "tamanho" de uma única linha. Para achar, faça $L_s - L_i$. Na 1ª classe: $2,80 - 2,75 = \mathbf{0,05}$. *(Dica: Em tabelas bem construídas, o $h$ é igual para todas as classes).*
5. **Amplitude Total ($AT$):** É o tamanho do cenário inteiro. Pegue o maior número de toda a tabela (o $L_s$ da última linha) e subtraia o menor número de toda a tabela (o $L_i$ da primeira linha). $AT = 2,90 - 2,75 = \mathbf{0,15}$.
6. **Ponto Médio ($X_c$):** O número que fica exatamente no meio de uma classe. É a média dos limites: $\frac{L_i + L_s}{2}$. Para a 1ª classe: $\frac{2,75 + 2,80}{2} = \mathbf{2,775}$.

---

## 2. Medidas de Posição (O Centro de Gravidade)

*(Foco: Resolver as Questões 2, 3, 4, 5, 6 e 7)*

As medidas de posição (também chamadas de tendência central) servem para resumir toda a sua amostra em um único número representativo. Elas respondem à pergunta: *"Para onde os dados tendem a convergir?"*.

### 2.1 A Média Aritmética ($\bar{x}$)

É o ponto de equilíbrio matemático perfeito.

* **Em dados soltos:** Soma tudo e divide pela quantidade.
* **Em tabelas (Dados Agrupados Discretos):** Se você tem uma tabela mostrando que o número "5" apareceu 2 vezes, e o "7" apareceu 3 vezes. Você não soma "5 + 7". Você multiplica o valor pela frequência primeiro.
* **Cálculo:** $\frac{(5 \cdot 2) + (7 \cdot 3)}{2 + 3} = \frac{10 + 21}{5} = \frac{31}{5} = \mathbf{6,2}$.



### 2.2 A Mediana ($Md$)

É o divisor de águas. A mediana é a barreira física onde **exatamente 50% dos dados estão abaixo dela, e 50% estão acima**.

* **Como achar em dados soltos PARES:**
Imagine a série de dados ordenados: $10, 20, \mathbf{40, 50}, 70, 80$.
Como temos 6 números, não existe um único "número do meio". Existem dois (40 e 50). A mediana será a média entre eles: $\frac{40 + 50}{2} = \mathbf{45}$.
* **Como achar em Tabelas de Frequência:**
A chave aqui é criar a coluna de **Frequência Acumulada ($F_i$)**. Ela funciona como um GPS indicando as posições de cada dado. Se o total de dados é $n = 34$, a mediana estará na posição $\frac{34}{2} = 17$. Você olha na coluna $F_i$ e encontra em qual classe a posição 17 está escondida.

### 2.3 A Moda ($Mo$)

É simplesmente o dado que mais se repete. Em tabelas, basta procurar o maior número na coluna da Frequência ($f_i$). A moda será a classe que corresponde àquela linha.

---

## 3. Separatrizes: Fatiando os Dados

*(Foco: Resolver a Questão 8)*

Se a Mediana corta os dados ao meio (2 partes), as separatrizes cortam em mais fatias. A lógica e a fórmula são **exatamente as mesmas da Mediana**, só muda a fração da posição.

* **Quartis ($Q$):** Dividem em 4 partes (25% cada). O $Q_3$ está na posição $\frac{3 \cdot n}{4}$.
* **Decis ($D$):** Dividem em 10 partes (10% cada). O $D_2$ está na posição $\frac{2 \cdot n}{10}$.
* **Percentis ($P$):** Dividem em 100 partes (1% cada). O $P_4$ está na posição $\frac{4 \cdot n}{100}$.

**O Algoritmo Universal de Resolução:**

1. **Calcule a Posição** (usando uma das frações acima). Ex: Posição resultou em 18.
2. **Ache a Classe:** Olhe na Frequência Acumulada ($F_i$) qual linha contém a posição 18.
3. **Aplique a Fórmula de Interpolação:**

$$Separatriz = L_i + \left[ \frac{(\text{Posição} - F_{ant}) \cdot h}{f_i} \right]$$



*Onde $L_i$ é o início da classe encontrada, $F_{ant}$ é a frequência acumulada da linha de cima, $h$ é o tamanho da classe e $f_i$ é a frequência simples da classe atual.*

---

## 4. Medidas de Dispersão (O Termômetro do Caos)

*(Foco: Resolver as Questões 9, 10, 11, 12, 13, 14 e 15)*

Média e Mediana enganam. Se você está com uma perna no fogo (100ºC) e outra no gelo (0ºC), na média você está a uma temperatura confortável de 50ºC, mas na realidade você está morrendo. **As medidas de dispersão revelam a irregularidade dos dados.**

### 4.1 A Regra Zero da Dispersão

O desvio mede o quanto os dados variam. Se todos os valores de uma amostra forem idênticos (Ex: todo mundo tirou nota 7), não há variação. Portanto, o Desvio Padrão e a Variância são **zero**.

### 4.2 A Hierarquia das Medidas

Para medir o caos, existe uma ordem de dependência rigorosa:

1. **A Média ($\bar{x}$):** Você precisa saber onde é o centro antes de calcular o quão longe os dados estão dele. É impossível calcular Variância sem calcular a Média primeiro.
2. **A Variância ($S^2$ ou $\sigma^2$):** É a média das distâncias elevadas ao quadrado. É apenas um passo intermediário.
3. **O Desvio Padrão ($S$ ou $\sigma$):**


É a raiz quadrada da Variância. É o valor real da instabilidade.
* **O Truque Matemático:** Se o problema diz que o Desvio Padrão é 9, para achar a Variância basta fazer o caminho inverso: elevá-lo ao quadrado ($9^2 = 81$).

### 4.3 Coeficiente de Variação ($CV$)

Serve para comparar o risco/dispersão de grupos de naturezas diferentes (ex: comparar variação de Salários vs. variação de Alturas).

* **Fórmula:** $CV = \left( \frac{\text{Desvio Padrão}}{\text{Média}} \right) \cdot 100$
* **Como usar na atividade:** Se o problema pede para analisar qual sexo (homens ou mulheres) apresenta maior dispersão, calcule o $CV$ de cada um separadamente. Aquele que resultar no **maior percentual (%)** é o grupo que varia mais em relação à sua própria realidade.

---

## 5. O Formato da Distribuição (Assimetria)

*(Foco: Resolver as Questões 16 e 17)*

O gráfico de uma distribuição de dados toma diferentes formatos (curvas) dependendo de como a Média, a Mediana e a Moda se comportam entre si. Você não precisa fazer cálculos complexos para responder essas questões, apenas aplicar a regra lógica de comparação.

1. **Curva Simétrica (A Perfeição):**
* **Regra:** Média = Mediana = Moda.
* **Visual:** O gráfico forma um sino perfeito. Não puxa para nenhum lado.


2. **Curva Assimétrica Positiva (Puxada para a Direita):**
* **Regra:** Média > Mediana > Moda.
* **Visual:** A cauda do gráfico se estica para a direita. Ocorre quando a maioria dos dados tem valores baixos (puxando a moda para baixo), mas alguns poucos valores extremamente altos arrastam a média lá para cima.


3. **Curva Assimétrica Negativa (Puxada para a Esquerda):**
* **Regra:** Média < Mediana < Moda.
* **Visual:** A cauda se alonga para a esquerda. Ocorre quando a maioria dos dados tem valores altos, mas alguns poucos zeros ou valores minúsculos derrubam o valor da média geral.

### Tópico 1: Organização de Dados e Distribuição de Frequências

Para transformar informações soltas em dados analisáveis, a estatística utiliza tabelas de distribuição de frequência. O processo de construção exige algumas etapas matemáticas fundamentais.

**Passo a Passo Teórico:**

1. 
**Dados Brutos e Rol:** Dados brutos são aqueles que não foram numericamente organizados no momento da coleta. O Rol é a organização desses dados brutos em ordem de grandeza crescente ou decrescente.


2. 
**Amplitude Total ($H$ ou $r$):** É a diferença entre o valor máximo e o valor mínimo da amostra. A fórmula é $H = L_s - L_i$, onde $L_s$ é o limite superior e $L_i$ é o limite inferior.


3. **Número de Classes ($k$):** Determina a quantidade de linhas (intervalos) da tabela. Uma das formas de calcular é pela Regra de Sturges, utilizando a fórmula $K = 1 + 3,3 \cdot \log n$, onde $n$ é o número total de observações.


4. 
**Amplitude do Intervalo de Classe ($h$ ou $A_i$):** É o comprimento da classe, obtido dividindo a Amplitude Total ($H$) pelo número de classes ($K$).


5. 
**Ponto Médio ($P.M.$ ou $X_c$):** É o ponto que divide o intervalo de classe em duas partes iguais, ou seja, a média aritmética dos limites da classe. A fórmula é $X_c = \frac{l_i + l_s}{2}$.


6. **Tipos de Frequências:**
* 
**Frequência Simples ($f_i$):** É o número de repetições de um valor individual ou de uma classe.


* 
**Frequência Acumulada ($F_i$ ou $f_{ac}$):** É o total das frequências de todos os valores inferiores ao limite superior do intervalo de uma determinada classe. Soma-se a frequência atual com as anteriores.


* 
**Frequência Relativa ($f_r$):** São os valores das razões (divisões) entre as frequências absolutas de cada classe e a frequência total da distribuição.





#### Resolução da Questão 1

**Enunciado:** Dado o rol do número de erros de impressão da primeira página de um jornal durante 50 dias, obteve-se os seguintes resultados: 7, 9, 12, 14, 22... a) Complete a tabela de distribuição de frequência.

**Como resolver:**
O enunciado fornece uma amostra parcial. Se você possuísse os 50 números, o procedimento exato seria:

* **Achar o $H$:** Subtrair o menor número (7) do maior número do rol completo.
* **Achar o $k$:** Como são 50 dias, a fórmula de Sturges ($1 + 3,3 \cdot \log 50$) indica aproximadamente 6 a 7 classes.
* **Achar o $h$:** Dividir o $H$ encontrado por 6 ou 7 e arredondar.
* **Contar o $f_i$:** Agrupar quantos dias tiveram a quantidade de erros estipulada em cada classe.

#### Resolução da Questão 2

**Enunciado Parte 1:** Segundo nos mostra a tabela acima responda: (Classes: $\vdash 08$, $\vdash 11$, $11 \vdash 14$, $\vdash 17$, $\vdash 20$, $\vdash 23$).

* **i) Qual a amplitude total ($r$)?**
Observando a classe central $11 \vdash 14$, vemos que o intervalo é de 3 em 3. Logo, a primeira classe começa em 5 (pois $8 - 3 = 5$). O menor limite é 5 e o maior é 23.
**Cálculo:** $r = 23 - 5 = 18$.
* **ii) Qual o valor de $k$ (número de classe)?**
Basta contar as linhas de intervalos de dados na tabela.
**Resposta:** $k = 6$.
* **iii) Qual o intervalo de cada classe ($h$)?**
É a diferença entre os limites de uma mesma classe.
**Cálculo:** $h = 14 - 11 = 3$.



**Enunciado Parte 2:** Complete a tabela a seguir.
*(Nota didática: A tabela do seu material está com dados fragmentados, mas a lógica matemática para preenchê-la, caso possua os dados brutos, é a seguinte)*:

* **Para achar o $P.M.$:** Some os dois números da classe e divida por 2. (Ex: se a classe for $62 \vdash 65$, o $P.M.$ é $\frac{62 + 65}{2} = 63,5$).
* **Para achar o $F_i$ (Acumulada):** Na primeira linha, repita o $f_i$. Nas linhas seguintes, some o $f_i$ da linha atual com o $F_i$ da linha de cima. O último valor deve ser o Total (300).
* **Para achar o $f_r$:** Divida o $f_i$ da linha pelo Total (300).

---

### Tópico 2: Medidas de Tendência Central (Posição)

Para representar um conjunto de dados e sintetizar seu comportamento, a estatística utiliza valores que tendem a se agrupar no centro da distribuição.

**Passo a Passo Teórico:**
As medidas de posição mais importantes são as medidas de tendência central. Dentre elas, destacam-se:

* 
**Média:** A soma de todos os valores dividida pela quantidade deles.


* 
**Mediana:** O valor que ocupa a posição central da distribuição, dividindo os dados em duas partes iguais (50% maiores e 50% menores).


* 
**Moda:** O valor de maior frequência em uma distribuição, ou seja, o que mais se repete.



#### Resolução da Questão 3

**Enunciado:** Média, Mediana e Moda são medidas de: a) Dispersão b) posição c) assimetria d) curtose.

**Como resolver:**
Baseado nos conceitos teóricos, as medidas de tendência central recebem a denominação de "medidas de posição" porque indicam o ponto em torno do qual os dados da sua distribuição tendem a se agrupar.
**Resposta:** b) posição.

---

### Tópico 3: Separatrizes (Quartis e Percentis)

Separatrizes são valores que dividem a série estatística em partes iguais.

**Passo a Passo Teórico:**

* 
**Quartis ($Q$):** São valores que dividem a série em quatro partes iguais. O primeiro quartil ($Q_1$) engloba 25% dos dados, o segundo ($Q_2$) equivale à mediana (50%), e o terceiro ($Q_3$) engloba 75% dos dados.


* 
**Percentis ($P$):** São os noventa e nove valores que separam uma série em 100 partes iguais.



**O procedimento de cálculo exige 3 passos:**

1. **Frequência Simples ($f_i$):** Descubra a frequência simples de cada classe subtraindo a acumulada atual da anterior.
2. **Encontrar a Posição:**
* Para Quartil: $\frac{k \cdot n}{4}$ (onde $k$ é o número do quartil e $n$ o total).


* Para Percentil: $\frac{k \cdot n}{100}$ (onde $k$ é o número do percentil e $n$ o total).




3. **Aplicar a Fórmula (Interpolação):**

$$Separatriz = L_i + \frac{(Posição - F_{ant}) \cdot h}{f_i}$$



*(Onde $L_i$ é o limite inferior da classe encontrada, $F_{ant}$ é a frequência acumulada da classe anterior, $h$ é o intervalo da classe e $f_i$ é a frequência simples da classe).*

#### Resolução da Questão 4

**Enunciado:** Para a distribuição abaixo calcular $P_{10}$ e $Q_3$.
*(Tabela dada tem as classes de 20 a 70. A coluna $Fi$ mostra valores crescentes até 24, o que significa que é a Frequência Acumulada. Logo, $n = 24$. O intervalo é $h = 10$).*

**Preparação: Tabela de Frequência Simples ($f_i$)**

* Classe $20 \vdash 30$: $f_1 = 3$ (acumulada $F_1 = 3$)
* Classe $30 \vdash 40$: $f_2 = 8 - 3 = 5$ (acumulada $F_2 = 8$)
* Classe $40 \vdash 50$: $f_3 = 18 - 8 = 10$ (acumulada $F_3 = 18$)
* Classe $50 \vdash 60$: $f_4 = 22 - 18 = 4$ (acumulada $F_4 = 22$)
* Classe $60 \vdash 70$: $f_5 = 24 - 22 = 2$ (acumulada $F_5 = 24$)

**Cálculo do $P_{10}$ (Percentil 10):**

1. **Posição:** $\frac{10 \cdot 24}{100} = 2,4$.
2. **Classe:** A posição 2,4 está dentro do acumulado da 1ª classe ($20 \vdash 30$), pois ela abriga as posições de 1 a 3.
3. **Fórmula:**
* $L_i = 20$
* $F_{ant} = 0$ (não há classe anterior)
* $f_i = 3$
* $h = 10$

$$P_{10} = 20 + \frac{(2,4 - 0) \cdot 10}{3}$$


$$P_{10} = 20 + \frac{24}{3}$$


$$P_{10} = 20 + 8$$



**Resposta $P_{10}$: 28**



**Cálculo do $Q_3$ (Terceiro Quartil):**

1. **Posição:** $\frac{3 \cdot 24}{4} = 18$.
2. **Classe:** A posição 18 cai exatamente no limite da 3ª classe ($40 \vdash 50$), cujo acumulado é 18.
3. **Fórmula:**
* $L_i = 40$
* $F_{ant} = 8$ (acumulada da 2ª classe)
* $f_i = 10$
* $h = 10$

$$Q_3 = 40 + \frac{(18 - 8) \cdot 10}{10}$$


$$Q_3 = 40 + \frac{100}{10}$$


$$Q_3 = 40 + 10$$



**Resposta $Q_3$: 50**



---

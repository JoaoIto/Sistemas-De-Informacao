# Manual de Estatística Descritiva e Distribuição de Frequência

Este documento é um guia técnico e estruturado para a construção de tabelas de frequência e cálculo de medidas estatísticas (Média, Variância e Desvio Padrão).

O objetivo da estatística descritiva é atuar como um filtro: ela processa um volume caótico de dados brutos e extrai os "sinais" mais importantes, transformando-os em informações visuais e métricas exatas para a tomada de decisão.

---

## 1. O Cenário: Tratamento de Dados Brutos

Estamos analisando a **Taxa de Mortalidade Infantil** em um *dataset* de 34 municípios.

### 1.1 Organização Lógica (Rol)

Antes de qualquer cálculo matemático, os dados coletados (frequentemente desorganizados) precisam ser ordenados. O nome técnico dessa ordenação (crescente ou decrescente) é **Rol**.

* **Por que fazer isso?** Organizar em Rol permite identificar instantaneamente os limites extremos da amostra: o **Menor Valor (Min)** e o **Maior Valor (Max)**. Esses dois números são a fundação matemática para dimensionar a nossa tabela.

Abaixo, os dados ordenados. As colunas (Baixos, Médios, etc.) são apenas uma divisão visual prévia para facilitar a leitura humana.

| Grupo 1 (Baixos) | Grupo 2 (Médios) | Grupo 3 (Altos) | Grupo 4 (Críticos) |
| --- | --- | --- | --- |
| **09,9** (Min) | 18,4 | 22,6 | 32,3 |
| 10,3 | 19,6 | 22,7 | 32,9 |
| 11,9 | 19,6 | 23,5 | 33,0 |
| 13,1 | 20,0 | 23,7 | 36,3 |
| 13,9 | 20,0 | 23,7 | 36,4 |
| 15,7 | 20,3 | 23,8 | 38,3 |
| 17,0 | 21,7 | 25,4 | 39,2 |
| 18,0 | 21,7 | 27,2 | **62,2** (Max) |
| 18,3 | 22,0 | 27,3 |  |
| 18,4 | 22,0 | 28,9 |  |
|  |  | 29,7 |  |
|  |  | 29,9 |  |

> **Total de Observações (n):** 34 municípios.

---

## 2. Parâmetros de Construção da Tabela

Não podemos desenhar a tabela de forma arbitrária. Precisamos calcular três parâmetros fundamentais que ditarão a arquitetura do nosso agrupamento de dados.

### Passo 1: Amplitude Total ($AT$)

* **O que é:** O intervalo total que engloba todos os nossos dados. Pense nisso como o "tamanho do terreno" que precisamos lotear.
* **Fórmula:** $AT = \text{Max} - \text{Min}$
* **Cálculo:** $62,2 - 9,9 = 52,3$
* **Significado:** A diferença entre o município com pior e melhor taxa é de 52,3 pontos.

### Passo 2: Número de Classes ($k$)

* **O que é:** A quantidade de linhas (agrupamentos) que a tabela terá.
* **Por que calcular:** Se tivermos classes demais, a tabela não resume nada. Se tivermos de menos, perdemos detalhes cruciais.
* **Regra Prática:** Para amostras pequenas (menores que 100), extrai-se a Raiz Quadrada do total de dados ($n$).
* **Cálculo:** $\sqrt{34} \approx 5,83$
* **Decisão:** Como não existe "meia linha", arredondamos para o número inteiro mais próximo.
* **Resultado:** **6 classes**.

### Passo 3: Amplitude da Classe ($h$)

* **O que é:** O "comprimento" de cada linha. Determina o tamanho do intervalo de dados que cada classe vai abrigar.
* **Fórmula:** $h = \frac{AT}{k}$ (Dividimos o "terreno total" pela "quantidade de lotes").
* **Cálculo:** $52,3 \div 6 = 8,71$
* **Decisão de Ajuste:** Tabular dados pulando de 8,71 em 8,71 geraria números quebrados difíceis de interpretar. Na estatística, é permitido e recomendado **arredondar a amplitude de classe para cima**, usando um número inteiro conveniente (neste caso, 10). Arredondar para cima garante que o último valor (62,2) caiba com folga na última classe.
* **Resultado:** **10**.

---

## 3. A Tabela de Distribuição de Frequência

Com as regras definidas ($k = 6$ linhas, saltando de $h = 10$ em $10$), construímos a matriz. Começamos a primeira classe pelo número inteiro imediatamente inferior ao nosso Mínimo (neste caso, 9, para englobar o 9,9).

### Como ler a representação de Classe ($\vdash$):

O símbolo $\vdash$ indica um intervalo "fechado à esquerda e aberto à direita".

* Exemplo: **09 $\vdash$ 19**. Isso significa que a classe **inclui** o número 9 e vai até 18,999..., mas **exclui** o número 19. O 19 só será contabilizado na linha de baixo.

### A Função do Ponto Médio ($X_c$):

Quando agrupamos 10 municípios na primeira classe (09 $\vdash$ 19), perdemos a informação de quais eram as taxas exatas de cada um. O Ponto Médio ($X_c$) surge como o "embaixador" da classe. Ele assume o valor central do intervalo ($\frac{9 + 19}{2} = 14$) e representa todos os municípios daquela linha nos cálculos matemáticos futuros.

### Tabela Estruturada

*Nota: As colunas auxiliares são criadas para evitar cálculos extensos e repetitivos posteriormente. Elas armazenam o resultado da multiplicação da classe inteira pelas suas respectivas frequências.*

| Classe (Intervalo) | $X_c$ (Ponto Médio) | $f_i$ (Freq. Absoluta) | $f_r$ (Freq. Relativa) | Auxiliar Média ($X_c \cdot f_i$) | Auxiliar Variância $(X_c - \bar{X})^2 \cdot f_i$ |
| --- | --- | --- | --- | --- | --- |
| **09 $\vdash$ 19** | 14 | 10 | 29,41% | 140 | 1.184,26 |
| **19 $\vdash$ 29** | 24 | 14 | 41,18% | 336 | 10,90 |
| **29 $\vdash$ 39** | 34 | 9 | 26,47% | 306 | 748,18 |
| **39 $\vdash$ 49** | 44 | 0 | 0,00% | 0 | 0,00 |
| **49 $\vdash$ 59** | 54 | 0 | 0,00% | 0 | 0,00 |
| **59 $\vdash$ 69** | 64 | 1 | 2,94% | 64 | 1.530,19 |
| **TOTAIS ($\Sigma$)** | - | **n = 34** | **100%** | **846** | **3.473,53** |

---

## 4. Cálculos Finais e Diagnóstico

Com a matriz preenchida e os totais somados na última linha, os cálculos complexos se tornam simples divisões.

### 4.1 Média Aritmética ($\bar{X}$)

* **O que indica:** O "centro de gravidade" dos dados. Se todos os municípios tivessem a mesma taxa, qual seria?
* **Lógica:** Em vez de somar 34 números individuais, pegamos a soma da coluna "Auxiliar Média" (que já multiplicou o Ponto Médio pela quantidade de repetições) e dividimos pelo total.
* **Cálculo:** $\bar{X} = \frac{846}{34}$
* **Resultado:** **24,88**

### 4.2 Variância Amostral ($S^2$)

* **O que indica:** É uma medida intermediária para entender a instabilidade dos dados.
* **Por que a fórmula usa quadrados?** A variância calcula a distância de cada município em relação à Média (24,88). Se apenas subtraíssemos, as distâncias negativas cancelariam as positivas (resultando em zero). Elevar ao quadrado transforma todos os desvios em números positivos e "penaliza" fortemente os valores muito distantes da média (como o município isolado na classe de 64).
* **Cálculo:** Dividimos o total da coluna "Auxiliar Variância" por $n-1$ (usamos 33 e não 34 porque é uma amostra, o que ajusta a margem de erro).
* **Resultado:** $S^2 = \frac{3.473,53}{33} \approx$ **105,26** *(Esta unidade está "ao quadrado", não faz sentido prático ainda).*

### 4.3 Desvio Padrão ($S$)

* **O que indica:** O afastamento real e tangível dos dados em relação à Média. É o indicador absoluto de regularidade ou disparidade.
* **Lógica:** Como a variância está elevada ao quadrado, aplicamos a raiz quadrada para trazer a medida de volta para a unidade original (Taxa de Mortalidade).
* **Cálculo:** $S = \sqrt{105,26}$
* **Resultado:** **10,26**.
* **Conclusão Prática:** Isso indica que, em média, a taxa de mortalidade dos municípios flutua aproximadamente 10,26 pontos para cima ou para baixo em relação à média de 24,88. É uma dispersão considerada alta, o que sugere grande desigualdade entre as cidades analisadas.

---

## 5. Resumo Geral: O Mapa das Fórmulas

Utilize este quadro como um "dicionário" de consulta rápida para programar ou automatizar esses cálculos no futuro. Ele dita a ordem de dependência das operações matemáticas.

| Nome | Símbolo | Lógica da Fórmula | O que ela te responde? | Dependência (O que calcular antes) |
| --- | --- | --- | --- | --- |
| **Amplitude Total** | $AT$ | $Max - Min$ | Qual o tamanho do abismo entre o pior e o melhor cenário? | Rol (dados ordenados). |
| **Número de Classes** | $k$ | $\sqrt{n}$ | Em quantos níveis vou classificar esses dados? | Total de registros ($n$). |
| **Amplitude da Classe** | $h$ | $\frac{AT}{k}$ | Qual a margem de tolerância dentro de cada nível? | Ter calculado $AT$ e $k$. |
| **Ponto Médio** | $X_c$ | $\frac{L_i + L_s}{2}$ | Qual número representará este grupo inteiro nas próximas contas? | Definir os limites de cada classe. |
| **Frequência Relativa** | $f_r$ | $(\frac{f_i}{n}) \times 100$ | Qual a porcentagem ou peso desse grupo no cenário global? | Contagem de frequência ($f_i$). |
| **Média Aritmética** | $\bar{X}$ | $\frac{\sum(X_c \cdot f_i)}{n}$ | Qual é o ponto de equilíbrio de todo o cenário? | Coluna auxiliar de soma ($X_c \cdot f_i$). |
| **Variância Amostral** | $S^2$ | $\frac{\sum[(X_c - \bar{X})^2 \cdot f_i]}{n-1}$ | Qual o grau matemático de irregularidade da amostra? | Ter calculado a Média ($\bar{X}$). |
| **Desvio Padrão** | $S$ | $\sqrt{S^2}$ | Na prática, quantos pontos a realidade costuma errar/desviar da média estipulada? | Ter calculado a Variância ($S^2$). |

# Estatística Descritiva e Distribuição de Frequência

Este documento é um manual técnico e didático para a construção de tabelas de frequência e cálculo de medidas estatísticas (Média, Variância e Desvio Padrão).

O objetivo é transformar um conjunto de dados desorganizados em informações úteis para tomada de decisão.

---

## 1. O Cenário (Dados Brutos)

Estamos analisando a **Taxa de Mortalidade Infantil** em 34 municípios.

### 1.1 Visualização dos Dados (Rol)
Para facilitar a análise, os dados já foram organizados em ordem crescente (Rol).
* **Destaque:** Observe o **Menor Valor (Min)** e o **Maior Valor (Max)**, pois eles definem o limite da nossa análise.

| Grupo 1 (Baixos) | Grupo 2 (Médios) | Grupo 3 (Altos) | Grupo 4 (Críticos) |
| :--- | :--- | :--- | :--- |
| **09.9** (Min) | 18.4 | 22.6 | 32.3 |
| 10.3 | 19.6 | 22.7 | 32.9 |
| 11.9 | 19.6 | 23.5 | 33.0 |
| 13.1 | 20.0 | 23.7 | 36.3 |
| 13.9 | 20.0 | 23.7 | 36.4 |
| 15.7 | 20.3 | 23.8 | 38.3 |
| 17.0 | 21.7 | 25.4 | 39.2 |
| 18.0 | 21.7 | 27.2 | **62.2** (Max) |
| 18.3 | 22.0 | 27.3 | |
| 18.4 | 22.0 | 28.9 | |
| | | 29.7 | |
| | | 29.9 | |

> **Total de Dados (n):** 34 municípios.

---

## 2. Parâmetros de Construção

Antes de desenhar a tabela, precisamos calcular as "regras do jogo".

### Passo 1: Amplitude Total ($AT$)
Mede o tamanho total do terreno que os dados ocupam.
* **Fórmula:** $AT = \text{Max} - \text{Min}$
* **Cálculo:** $62,2 - 9,9 = 52,3$
* **Resultado:** **52,3**

### Passo 2: Número de Classes ($k$)
Define quantas linhas (grupos) a tabela terá.
* **Regra:** Para amostras menores que 100, usa-se a Raiz Quadrada do total de dados ($n$).
* **Cálculo:** $\sqrt{34} \approx 5,83$
* **Decisão:** Arredondamos para o inteiro mais próximo.
* **Resultado:** **6 classes**.

### Passo 3: Amplitude da Classe ($h$)
Define o "tamanho do passo" de cada grupo.
* **Fórmula:** $h = AT \div k$
* **Cálculo:** $52,3 \div 6 = 8,71$
* **Decisão Importante:** Para facilitar a leitura humana, arredondamos para um número inteiro, preferencialmente superior ou conveniente (como 5 ou 10). Aqui usaremos 10.
* **Resultado:** **10**.

---

## 3. A Tabela de Distribuição de Frequência

Abaixo está a tabela completa com todas as colunas auxiliares necessárias para os cálculos finais.

**Legenda das Colunas:**
1.  **Classe:** O intervalo (de 10 em 10, começando em 9).
2.  **$X_c$ (Ponto Médio):** O valor central da classe. Representa todos os números daquele grupo.
3.  **$f_i$ (Frequência):** Quantos municípios estão neste intervalo.
4.  **$X_c \cdot f_i$:** Coluna auxiliar para calcular a **Média**.
5.  **$(X_c - \bar{X})^2 \cdot f_i$:** Coluna auxiliar para calcular a **Variância/Desvio Padrão**.

| Classe (Intervalo) | $X_c$ (Ponto Médio) | $f_i$ (Freq. Absoluta) | $f_r$ (Freq. Relativa) | Auxiliar Média ($X_c \cdot f_i$) | Auxiliar Variância $(X_c - \bar{X})^2 \cdot f_i$ |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **09 $\vdash$ 19** | 14 | 10 | 29,41% | 140 | 1.184,26 |
| **19 $\vdash$ 29** | 24 | 14 | 41,18% | 336 | 10,90 |
| **29 $\vdash$ 39** | 34 | 9 | 26,47% | 306 | 748,18 |
| **39 $\vdash$ 49** | 44 | 0 | 0,00% | 0 | 0,00 |
| **49 $\vdash$ 59** | 54 | 0 | 0,00% | 0 | 0,00 |
| **59 $\vdash$ 69** | 64 | 1 | 2,94% | 64 | 1.530,19 |
| **TOTAIS ($\Sigma$)** | - | **n = 34** | **100%** | **846** | **3.473,53** |

---

## 4. Cálculos Finais e Resultados

### 4.1 Média Aritmética ($\bar{X}$)
*Onde está o centro dos dados?*
Basta dividir a soma da coluna "Auxiliar Média" pelo total de dados.
$$
\bar{X} = \frac{846}{34} \approx \mathbf{24,88}
$$

### 4.2 Variância Amostral ($S^2$)
*Qual a dispersão "quadrada" dos dados?*
Basta dividir a soma da coluna "Auxiliar Variância" pelo total de dados menos 1 ($n-1$).
$$
S^2 = \frac{3.473,53}{33} \approx \mathbf{105,26}
$$

### 4.3 Desvio Padrão ($S$)
*Qual a dispersão real dos dados?*
É a raiz quadrada da variância. Isso indica que, em média, a taxa de mortalidade varia 10,26 pontos para cima ou para baixo da média.
$$
S = \sqrt{105,26} \approx \mathbf{10,26}
$$

---

## 5. Resumo Geral de Fórmulas e Contexto

Esta tabela serve como guia de consulta rápida para entender **o que** calcular, **quando** usar e **o que você precisa ter pronto** antes de calcular.

| Nome | Símbolo | Fórmula | Contexto de Uso | O que calcular antes? |
| :--- | :---: | :--- | :--- | :--- |
| **Amplitude Total** | $AT$ | $Max - Min$ | Identificar a "distância" entre o maior e o menor valor da amostra. | Ter os dados brutos ordenados. |
| **Número de Classes** | $k$ | $\sqrt{n}$ | Decidir em quantos grupos dividir os dados para não ficar nem muito resumido, nem muito detalhado. | Contar o total de dados ($n$). |
| **Amplitude da Classe** | $h$ | $\frac{AT}{k}$ | Definir o tamanho de cada intervalo (o "passo"). | Ter calculado $AT$ e $k$. |
| **Ponto Médio** | $X_c$ | $\frac{Lim.Inf + Lim.Sup}{2}$ | Criar um valor representativo para a classe, já que não sabemos os valores exatos dentro do intervalo. | Definir os limites das classes. |
| **Frequência Relativa** | $f_r$ | $(\frac{f_i}{n}) \times 100$ | Saber a porcentagem de participação de cada grupo no todo. | Ter contado a frequência absoluta ($f_i$). |
| **Média Aritmética** | $\bar{X}$ | $\frac{\sum(X_c \cdot f_i)}{n}$ | Encontrar o ponto de equilíbrio dos dados. É o centro de gravidade da distribuição. | Ter as colunas $X_c$ e $f_i$ preenchidas. |
| **Variância Amostral** | $S^2$ | $\frac{\sum[(X_c - \bar{X})^2 \cdot f_i]}{n-1}$ | Medir o grau de dispersão dos dados. Quanto maior, mais "espalhados" estão os dados. | Ter calculado a Média ($\bar{X}$). |
| **Desvio Padrão** | $S$ | $\sqrt{S^2}$ | Traduzir a variância para a mesma unidade dos dados originais. É a medida de risco ou instabilidade mais usada. | Ter calculado a Variância ($S^2$). |****

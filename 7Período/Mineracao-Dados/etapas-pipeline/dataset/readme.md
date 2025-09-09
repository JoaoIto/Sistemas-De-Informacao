# MD_AULA06_ATIVIDADE1: Exercícios de Visualização de Dados

Este notebook contém exercícios práticos para a criação de diferentes tipos de gráficos, utilizando as bibliotecas `matplotlib` e `seaborn` em Python. O objetivo é explorar a distribuição e as relações entre as variáveis de um dataset sintético, fundamental para a análise exploratória de dados (EDA) em mineração de dados.

## Como usar este notebook no Google Colab

1.  Abra este notebook no Google Colab.
2.  Execute as células de código sequencialmente.

## Dataset de Exemplo

Primeiro, vamos criar um dataset sintético para demonstrar as visualizações. Este dataset simula dados de funcionários com `idade`, `salario`, `cidade` e `cargo`.

```python
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

np.random.seed(42) # Para reprodutibilidade

df = pd.DataFrame({
    'idade': np.random.normal(35, 10, 200).astype(int), # Idades com distribuição normal
    'salario': np.random.lognormal(mean=8, sigma=0.4, size=200), # Salários com distribuição log-normal
    'cidade': np.random.choice(['São Paulo','Rio de Janeiro','Belo Horizonte','Curitiba'], 200), # Cidades aleatórias
    'cargo': np.random.choice(['Analista','Gestor','Estagiário','Cientista de Dados'], 200) # Cargos aleatórios
})

print(df.head())
```

**Explicação:**
*   `np.random.seed(42)`: Garante que os dados gerados sejam os mesmos a cada execução, tornando o notebook reprodutível.
*   `pd.DataFrame(...)`: Cria um DataFrame com 200 linhas e 4 colunas, utilizando `numpy.random` para gerar dados numéricos com distribuições específicas (`normal` para idade, `lognormal` para salário) e `numpy.random.choice` para selecionar valores categóricos.

## Exemplos de Gráficos e Exercícios

Serão apresentados exemplos de histograma, boxplot, gráfico de barras, gráfico de dispersão e heatmap de correlação. Após cada seção, haverá um exercício para você praticar.

### Histograma

Mostra a **distribuição de uma variável numérica**. Ajuda a identificar a forma da distribuição, assimetrias e a presença de outliers.

**✏️ Exercício 1**: Faça um histograma para analisar a distribuição da coluna `salario`.

```python
plt.figure(figsize=(10, 6))
sns.histplot(df['salario'], kde=True, bins=30)
plt.title('Distribuição de Salários')
plt.xlabel('Salário')
plt.ylabel('Frequência')
plt.grid(axis='y', alpha=0.75)
plt.show()
```

**Explicação:**
*   `plt.figure(figsize=(10, 6))`: Define o tamanho da figura para o gráfico.
*   `sns.histplot(df['salario'], kde=True, bins=30)`: Cria um histograma da coluna `salario`. `kde=True` adiciona uma estimativa de densidade de kernel (linha suave que representa a distribuição) e `bins=30` define o número de barras no histograma.
*   `plt.title()`, `plt.xlabel()`, `plt.ylabel()`: Definem o título e os rótulos dos eixos do gráfico.
*   `plt.grid()`: Adiciona uma grade ao gráfico para facilitar a leitura.
*   `plt.show()`: Exibe o gráfico.

### Boxplot

Mostra **mediana, quartis e outliers** de uma variável numérica. É bom para comparar a distribuição de uma variável numérica entre diferentes categorias.

**✏️ Exercício 2**: Crie um boxplot para comparar a distribuição de `idade` entre as diferentes `cidades`.

```python
plt.figure(figsize=(12, 7))
sns.boxplot(x='cidade', y='idade', data=df)
plt.title('Distribuição de Idade por Cidade')
plt.xlabel('Cidade')
plt.ylabel('Idade')
plt.grid(axis='y', alpha=0.75)
plt.show()
```

**Explicação:**
*   `sns.boxplot(x='cidade', y='idade', data=df)`: Cria um boxplot onde o eixo X representa as `cidades` (variável categórica) e o eixo Y representa a `idade` (variável numérica). Cada caixa mostra a mediana, os quartis (25% e 75%) e os


limites interquartis, e os pontos fora desses limites são considerados outliers.

### Gráfico de Barras

Compara categorias em termos de frequência ou de alguma métrica agregada. É bom para identificar a categoria mais comum ou para comparar contagens entre grupos.

**✏️ Exercício 3**: Faça um gráfico de barras mostrando a frequência dos valores de `cargo`.

```python
plt.figure(figsize=(10, 6))
sns.countplot(x=\'cargo\', data=df, palette=\'viridis\')
plt.title(\'Frequência de Cargos\')
plt.xlabel(\'Cargo\')
plt.ylabel(\'Contagem\')
plt.xticks(rotation=45, ha=\'right\') # Rotaciona os rótulos do eixo X para melhor visualização
plt.grid(axis=\'y\', alpha=0.75)
plt.tight_layout() # Ajusta o layout para evitar sobreposição
plt.show()
```

**Explicação:**
*   `sns.countplot(x=\'cargo\', data=df, palette=\'viridis\')`: Cria um gráfico de barras onde o eixo X representa as categorias de `cargo` e a altura das barras representa a contagem de ocorrências de cada cargo. `palette=\'viridis\'` define o esquema de cores.
*   `plt.xticks(rotation=45, ha=\'right\')`: Rotaciona os rótulos do eixo X em 45 graus para evitar sobreposição, especialmente quando há muitos rótulos.

### Gráfico de Dispersão

Mostra a relação entre duas variáveis numéricas. É bom para identificar correlação, padrões ou a presença de outliers.

**✏️ Exercício 4**: Crie um gráfico de dispersão comparando `salario` e `idade`, mas colorindo os pontos por `cargo`.

```python
plt.figure(figsize=(10, 6))
sns.scatterplot(x=\'idade\', y=\'salario\', hue=\'cargo\', data=df, s=100, alpha=0.7)
plt.title(\'Salário vs. Idade por Cargo\')
plt.xlabel(\'Idade\')
plt.ylabel(\'Salário\')
plt.grid(True, linestyle=\'--\', alpha=0.6)
plt.legend(title=\'Cargo\', bbox_to_anchor=(1.05, 1), loc=\'upper left\') # Posiciona a legenda fora do gráfico
plt.tight_layout()
plt.show()
```

**Explicação:**
*   `sns.scatterplot(x=\'idade\', y=\'salario\', hue=\'cargo\', data=df, s=100, alpha=0.7)`: Cria um gráfico de dispersão. `hue=\'cargo\'` colore os pontos de acordo com a categoria de `cargo`, permitindo visualizar a relação entre `salario` e `idade` para cada cargo. `s` define o tamanho dos pontos e `alpha` define a transparência.
*   `plt.legend(title=\'Cargo\', bbox_to_anchor=(1.05, 1), loc=\'upper left\')`: Posiciona a legenda fora da área do gráfico para evitar que ela cubra os pontos.

### Heatmap de Correlação

Mostra como variáveis numéricas se relacionam linearmente. A correlação varia de -1 a +1:
*   Próxima de +1: relação positiva forte (quando uma aumenta, a outra também tende a aumentar).
*   Próxima de -1: relação negativa forte (quando uma aumenta, a outra tende a diminuir).
*   Próxima de 0: ausência de relação linear.

**✏️ Exercício 5**: Interprete o heatmap abaixo. Qual a relação entre `idade` e `salario`? Existe correlação forte?

```python
# Calcular a matriz de correlação
correlation_matrix = df[[\'idade\', \'salario\']].corr()

plt.figure(figsize=(6, 5))
sns.heatmap(correlation_matrix, annot=True, cmap=\'coolwarm\', fmt=\'.2f\', linewidths=.5)
plt.title(\'Heatmap de Correlação entre Idade e Salário\')
plt.show()
```

**Explicação:**
*   `df[[\'idade\', \'salario\']].corr()`: Calcula a matriz de correlação de Pearson entre as colunas `idade` e `salario`.
*   `sns.heatmap(correlation_matrix, annot=True, cmap=\'coolwarm\', fmt=\'.2f\', linewidths=.5)`: Cria um heatmap da matriz de correlação. `annot=True` exibe os valores de correlação nas células, `cmap=\'coolwarm\'` define o esquema de cores (azul para negativo, vermelho para positivo) e `fmt=\'.2f\'` formata os números com duas casas decimais.

**Interpretação do Exercício 5:**

Após executar o código, observe o valor de correlação entre `idade` e `salario` no heatmap. Se o valor for próximo de 0, indica que não há uma forte relação linear entre idade e salário neste dataset sintético. Valores próximos de 1 ou -1 indicariam uma forte correlação positiva ou negativa, respectivamente.

## Conclusão

Neste notebook, você explorou diversas técnicas de visualização de dados, que são ferramentas poderosas para entender a estrutura dos dados, identificar padrões, anomalias e relações entre variáveis. A visualização é uma etapa fundamental na análise exploratória de dados (EDA) e no processo de mineração de dados, fornecendo insights valiosos antes da modelagem.

---
# MD_AULA05_ATIVIDADE: Exercícios de Transformação de Dados para Mineração

Este notebook contém exercícios práticos para aplicar diversas técnicas de transformação de dados, que são cruciais para preparar os dados para algoritmos de mineração e aprendizado de máquina. Os exemplos utilizam as bibliotecas `pandas`, `numpy` e `sklearn`.

## Como usar este notebook no Google Colab

1.  Abra este notebook no Google Colab.
2.  Execute as células de código sequencialmente.

## Dataset de Exemplo

Primeiro, vamos criar um dataset sintético para demonstrar as transformações.

```python
import pandas as pd
import numpy as np

# Definir tamanho do dataset
n = 500

# Gerar valores aleatórios
idades = np.random.randint(15, 70, size=n)  # idades entre 15 e 70
salarios = np.random.randint(1200, 20000, size=n)  # salários entre 1200 e 20000

# Escolher cidades de forma aleatória
cidades = np.random.choice(
    ["São Paulo", "Rio de Janeiro", "Fortaleza", "Recife", "Salvador", "Belo Horizonte"],
    size=n
)

# Gerar datas aleatórias entre 2020 e 2023
datas = pd.to_datetime(
    np.random.randint(
        pd.Timestamp("2020-01-01").value,
        pd.Timestamp("2023-12-31").value,
        size=n
    )
).normalize()

# Criar DataFrame
df = pd.DataFrame({
    "idade": idades,
    "salario": salarios,
    "cidade": cidades,
    "data_cadastro": datas
})

df.head()
```

**Explicação:**
*   Este bloco de código gera um DataFrame `df` com 500 entradas, contendo colunas para `idade`, `salario`, `cidade` e `data_cadastro`, utilizando funções de `numpy` para gerar dados aleatórios e `pandas` para criar o DataFrame e manipular datas.

## Exercícios de Transformação de Dados

### Exercício 1: Normalização (Min-Max Scaling)

Aplica a normalização Min-Max no atributo `salario`, escalando os valores para a faixa `[0,1]`. Isso é útil para algoritmos que são sensíveis à escala dos dados.

```python
from sklearn.preprocessing import MinMaxScaler

# Criar um objeto MinMaxScaler
scaler = MinMaxScaler()

# Aplicar a normalização no atributo 'salario'
df["salario_normalizado"] = scaler.fit_transform(df[["salario"]])

# Exibir as primeiras linhas com a nova coluna
print(df.head())
```

**Explicação:**
*   `MinMaxScaler()`: Inicializa o objeto para normalização Min-Max.
*   `scaler.fit_transform(df[["salario"]])`: Calcula os valores mínimo e máximo da coluna `salario` e, em seguida, aplica a fórmula de normalização para transformar os dados para o intervalo [0, 1]. O `[[]]` é usado para passar um DataFrame (mesmo que de uma única coluna) para o `fit_transform`.

### Exercício 2: Padronização (Z-score Standardization)

Padroniza o atributo `salario` usando Z-score, resultando em uma média de 0 e desvio padrão de 1. Isso é benéfico para algoritmos que assumem uma distribuição normal ou que são sensíveis à variância dos dados.

```python
from sklearn.preprocessing import StandardScaler

# Criar um objeto StandardScaler
scaler = StandardScaler()

# Aplicar a padronização no atributo 'salario'
df["salario_padronizado"] = scaler.fit_transform(df[["salario"]])

# Exibir as primeiras linhas com a nova coluna
print(df.head())
```

**Explicação:**
*   `StandardScaler()`: Inicializa o objeto para padronização Z-score.
*   `scaler.fit_transform(df[["salario"]])`: Calcula a média e o desvio padrão da coluna `salario` e, em seguida, aplica a fórmula Z-score para transformar os dados.

### Exercício 3: Transformação Logarítmica

Aplica a transformação logarítmica ao atributo `salario` para reduzir a influência de valores muito altos (assimetria à direita) e tornar a distribuição mais simétrica. `np.log1p()` é usado para lidar com valores zero, pois `log(0)` é indefinido.

```python
# Aplicar a transformação logarítmica no atributo 'salario'
df["salario_log"] = np.log1p(df["salario"])

# Exibir as primeiras linhas com a nova coluna
print(df.head())
```

**Explicação:**
*   `np.log1p(x)`: Retorna `log(1 + x)`. É uma função robusta para aplicar logaritmo em dados que podem conter zeros, pois `log(0)` é indefinido, mas `log(1+0)` é `log(1)` que é 0.

### Exercício 4: Binning (Discretização)

Cria uma nova coluna `faixa_etaria` categorizando a idade em faixas discretas (jovem, adulto, meia-idade, idoso). Isso é útil para converter variáveis contínuas em categóricas, simplificando o modelo ou para análises que exigem categorias.

```python
# Definir os limites das faixas etárias
bins = [0, 18, 30, 50, df["idade"].max() + 1] # +1 para incluir o valor máximo
labels = ["jovem", "adulto", "meia-idade", "idoso"]

# Criar a nova coluna 'faixa_etaria'
df["faixa_etaria"] = pd.cut(df["idade"], bins=bins, labels=labels, right=False)

# Exibir as primeiras linhas com a nova coluna
print(df.head())
```

**Explicação:**
*   `bins`: Uma lista que define os pontos de corte para as categorias de idade.
*   `labels`: Uma lista de rótulos para cada categoria criada.
*   `pd.cut()`: Função do pandas que discretiza (divide em bins) a coluna `idade` de acordo com os `bins` e atribui os `labels` correspondentes. `right=False` indica que o intervalo é fechado à esquerda e aberto à direita (e.g., [0, 18)).

### Exercício 5: One-Hot Encoding

Transforma o atributo categórico `cidade` em colunas binárias (0/1). Isso é necessário para que algoritmos de aprendizado de máquina possam processar variáveis categóricas sem inferir uma ordem artificial.

```python
# Aplicar One-Hot Encoding no atributo 'cidade'
df_cidade_dummies = pd.get_dummies(df["cidade"], prefix="cidade")

# Concatenar o novo DataFrame com o original
df = pd.concat([df, df_cidade_dummies], axis=1)

# Exibir as primeiras linhas com as novas colunas
print(df.head())
```

**Explicação:**
*   `pd.get_dummies(df["cidade"], prefix="cidade")`: Cria novas colunas binárias para cada categoria única na coluna `cidade`. Por exemplo, se houver "São Paulo", "Rio de Janeiro", serão criadas `cidade_São Paulo` e `cidade_Rio de Janeiro`.
*   `pd.concat([df, df_cidade_dummies], axis=1)`: Combina o DataFrame original com as novas colunas dummy. `axis=1` indica que a concatenação deve ser feita pelas colunas.

### Exercício 6: Label Encoding

Converte o atributo categórico `cidade` em números inteiros. Esta técnica é adequada para variáveis ordinais, onde a ordem dos valores importa, ou quando o número de categorias é muito grande para One-Hot Encoding.

```python
from sklearn.preprocessing import LabelEncoder

# Criar um objeto LabelEncoder
le = LabelEncoder()

# Aplicar Label Encoding no atributo 'cidade'
df["cidade_encoded"] = le.fit_transform(df["cidade"])

# Exibir as primeiras linhas com a nova coluna
print(df.head())

# Opcional: Ver as classes e seus valores codificados
print("Classes e seus valores codificados:")
for i, item in enumerate(le.classes_):
    print(f"{item}: {i}")
```

**Explicação:**
*   `LabelEncoder()`: Inicializa o objeto para Label Encoding.
*   `le.fit_transform(df["cidade"])`: Ajusta o encoder às categorias únicas da coluna `cidade` e as transforma em números inteiros sequenciais (0, 1, 2, ...).
*   `le.classes_`: Atributo do `LabelEncoder` que mostra as categorias originais e a ordem em que foram codificadas.

### Exercício 7: Extração de Atributos (de Data)

A partir do atributo `data_cadastro`, cria três novas colunas: `ano`, `mes` e `dia`. Esta é uma forma de engenharia de atributos, onde novas features são derivadas de dados existentes para potencialmente melhorar o desempenho do modelo.

```python
# Extrair ano, mês e dia do atributo 'data_cadastro'
df["ano_cadastro"] = df["data_cadastro"].dt.year
df["mes_cadastro"] = df["data_cadastro"].dt.month
df["dia_cadastro"] = df["data_cadastro"].dt.day

# Exibir as primeiras linhas com as novas colunas
print(df.head())
```

**Explicação:**
*   `.dt.year`, `.dt.month`, `.dt.day`: Acessadores de data/hora do pandas que permitem extrair componentes específicos de uma coluna do tipo datetime. São muito úteis para criar novas features baseadas em tempo.

## Conclusão

Neste notebook, você praticou técnicas fundamentais de transformação de dados, como Normalização, Padronização, Transformação Logarítmica, Binning, One-Hot Encoding, Label Encoding e Extração de Atributos. Dominar essas técnicas é essencial para a preparação de dados e para o sucesso em projetos de mineração de dados e aprendizado de máquina.


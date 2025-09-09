# AULA03_ATIVIDADE_2: Limpeza e Pré-processamento de Dados

Este notebook contém uma série de exercícios práticos focados na limpeza e pré-processamento de dados. O objetivo é aplicar diversas técnicas para tratar dados sujos, inconsistentes e ausentes, preparando-os para análises posteriores ou modelos de Machine Learning.

## Como usar este notebook no Google Colab

1.  Faça o upload do arquivo `dataset_sujo.csv` para o ambiente do Google Colab.
2.  Execute as células de código sequencialmente.

## Exercícios e Explicações

### 0) Preparação: Importar pacotes e carregar o CSV

Carrega o dataset `dataset_sujo.csv` em um DataFrame do pandas e visualiza as primeiras linhas para entender a estrutura dos dados.

```python
import pandas as pd
import numpy as np

# Carregar o dataset
df = pd.read_csv('dataset_sujo.csv')

# Visualizar as primeiras linhas
print(df.head())
```

**Explicação:**
*   `import pandas as pd`: Importa a biblioteca pandas, fundamental para manipulação de DataFrames.
*   `import numpy as np`: Importa a biblioteca NumPy, utilizada para operações numéricas, especialmente com arrays.
*   `pd.read_csv('dataset_sujo.csv')`: Lê o arquivo CSV e cria um DataFrame.
*   `df.head()`: Exibe as 5 primeiras linhas do DataFrame, útil para uma inspeção inicial.

### 1) Inspeção inicial

Realiza uma inspeção inicial do DataFrame para entender suas dimensões, tipos de dados e a presença de valores não nulos.

```python
# Dimensões do DataFrame (linhas, colunas)
print(df.shape)

# Informações sobre os tipos de dados e contagem de não nulos
print(df.info())

# Amostra rápida de 5 linhas aleatórias
print(df.sample(5, random_state=1))
```

**Explicação:**
*   `df.shape`: Retorna uma tupla representando as dimensões do DataFrame (número de linhas, número de colunas).
*   `df.info()`: Imprime um resumo do DataFrame, incluindo o índice dtype e dtypes de coluna, valores não nulos e uso de memória.
*   `df.sample(5, random_state=1)`: Retorna uma amostra aleatória de 5 linhas do DataFrame. `random_state` garante a reprodutibilidade da amostra.

### 2) Padronizar nomes de colunas

Limpa e padroniza os nomes das colunas, removendo espaços extras, símbolos e convertendo para minúsculas, substituindo espaços por underscores.

```python
# Função para padronizar nomes de colunas
def standardize_column_names(df):
    cols = df.columns
    new_cols = []
    for col in cols:
        new_col = col.strip().lower().replace(' ', '_').replace('-', '_')
        new_cols.append(new_col)
    df.columns = new_cols
    return df

df = standardize_column_names(df)
print(df.head())
```

**Explicação:**
*   A função `standardize_column_names` itera sobre os nomes das colunas, aplica operações de string (`strip()`, `lower()`, `replace()`) para limpá-los e os atribui de volta ao DataFrame. Isso garante consistência e facilita o acesso às colunas.

### 3) Conversão de tipos (datas e numéricos)

Converte colunas para os tipos de dados corretos, como `datetime` para datas e tipos numéricos para `idade` e `salario_r`.

```python
# Converter 'data_admissao' para datetime
df['data_admissao'] = pd.to_datetime(df['data_admissao'], errors='coerce')

# Converter 'idade' e 'salario' para numéricos
df['idade'] = pd.to_numeric(df['idade'], errors='coerce')
df['salario'] = pd.to_numeric(df['salario'], errors='coerce')

print(df.dtypes)
```

**Explicação:**
*   `pd.to_datetime(..., errors='coerce')`: Converte a coluna para o tipo datetime. `errors='coerce'` fará com que valores inválidos sejam convertidos para `NaT` (Not a Time).
*   `pd.to_numeric(..., errors='coerce')`: Converte a coluna para um tipo numérico. `errors='coerce'` fará com que valores inválidos sejam convertidos para `NaN` (Not a Number).

### 4) Limpeza de texto em colunas categóricas

Remove espaços em branco e converte para minúsculas os valores das colunas categóricas `nome`, `cidade`, `estado_civil` e `cargo`.

```python
cols_to_clean = ['nome', 'cidade', 'estado_civil', 'cargo']

for col in cols_to_clean:
    if col in df.columns:
        df[col] = df[col].astype(str).str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)
print(df[cols_to_clean].head())
```

**Explicação:**
*   O loop itera sobre as colunas especificadas. Para cada coluna, os valores são convertidos para string, espaços em branco são removidos (`strip()`), convertidos para minúsculas (`lower()`) e múltiplos espaços são substituídos por um único espaço (`replace(r'\s+', ' ', regex=True)`).

### 5) Remover coluna com muitos ausentes

Remove colunas que possuem mais de 90% de valores ausentes, pois são consideradas irrelevantes para a análise.

```python
threshold = 0.90
missing_percentages = df.isnull().sum() / len(df)
drop_columns = missing_percentages[missing_percentages > threshold].index
df = df.drop(columns=drop_columns)

print(f"Colunas removidas: {list(drop_columns)}")
print(df.info())
```

**Explicação:**
*   `df.isnull().sum() / len(df)`: Calcula a porcentagem de valores ausentes para cada coluna.
*   `missing_percentages[missing_percentages > threshold].index`: Seleciona os índices (nomes das colunas) onde a porcentagem de ausentes é maior que o `threshold` (90%).
*   `df.drop(columns=drop_columns)`: Remove as colunas identificadas do DataFrame.

### 6) Tratar incompletude (imputação simples)

Preenche valores ausentes em colunas numéricas com a mediana e em colunas categóricas com a moda.

```python
# Imputar valores ausentes em colunas numéricas com a mediana
for col in ['idade', 'salario']:
    if col in df.columns and df[col].isnull().any():
        median_val = df[col].median()
        df[col].fillna(median_val, inplace=True)
        print(f"Coluna '{col}': valores ausentes preenchidos com a mediana ({median_val})")

# Imputar valores ausentes em colunas categóricas com a moda
for col in ['cidade', 'estado_civil', 'cargo']:
    if col in df.columns and df[col].isnull().any():
        mode_val = df[col].mode()[0] # mode() retorna uma Series, pegamos o primeiro valor
        df[col].fillna(mode_val, inplace=True)
        print(f"Coluna '{col}': valores ausentes preenchidos com a moda ({mode_val})")

print(df.isnull().sum())
```

**Explicação:**
*   O código itera sobre colunas numéricas e categóricas. Para numéricas, preenche `NaN`s com a mediana da coluna. Para categóricas, preenche com a moda (valor mais frequente). `inplace=True` modifica o DataFrame diretamente.

### 7) Inconsistência: regras simples

Trata inconsistências como idades fora de um intervalo plausível (15-95) e datas de admissão no futuro.

```python
# Idade plausível: 15–95 (fora -> NaN -> reimputar)
initial_missing_age = df['idade'].isnull().sum()
df['idade'] = df['idade'].mask(~df['idade'].between(15, 95), np.nan)

# Re-imputar idades que se tornaram NaN após a validação
if df['idade'].isnull().sum() > initial_missing_age:
    median_age = df['idade'].median()
    df['idade'].fillna(median_age, inplace=True)
    print(f"Idades fora do intervalo (15-95) foram corrigidas e re-imputadas com a mediana ({median_age}).")

# data_admissao no futuro -> NaT (Not a Time - nulo)
df['data_admissao'] = df['data_admissao'].mask(df['data_admissao'] > pd.to_datetime('today'), pd.NaT)

# Re-imputar datas de admissão que se tornaram NaT
if df['data_admissao'].isnull().any():
    # Para datas, podemos preencher com a moda ou uma data padrão, dependendo do contexto
    # Aqui, vamos preencher com a moda (data mais frequente)
    mode_date = df['data_admissao'].mode()[0]
    df['data_admissao'].fillna(mode_date, inplace=True)
    print(f"Datas de admissão no futuro foram corrigidas e re-imputadas com a moda ({mode_date.strftime('%Y-%m-%d')}).")

print(df[['idade', 'data_admissao']].head())
```

**Explicação:**
*   `df['idade'].mask(~df['idade'].between(15, 95), np.nan)`: Substitui idades fora do intervalo [15, 95] por `NaN`.
*   `df['data_admissao'].mask(df['data_admissao'] > pd.to_datetime('today'), pd.NaT)`: Substitui datas de admissão futuras por `NaT`.
*   Após a substituição, os valores `NaN`/`NaT` são novamente imputados com a mediana/moda para garantir que não haja mais valores ausentes.

### 8) Ruído: remover duplicatas

Remove linhas duplicadas do DataFrame, mantendo apenas a primeira ocorrência de cada uma.

```python
initial_rows = df.shape[0]
df.drop_duplicates(inplace=True)
final_rows = df.shape[0]
print(f"Foram removidas {initial_rows - final_rows} linhas duplicadas.")
print(f"Novo número de linhas: {final_rows}")
```

**Explicação:**
*   `df.drop_duplicates(inplace=True)`: Remove as linhas duplicadas do DataFrame. `inplace=True` modifica o DataFrame diretamente. Por padrão, ele mantém a primeira ocorrência de cada duplicata.

### 9) Verificações finais e salvar

Realiza uma verificação final para garantir que não há mais valores ausentes ou duplicatas e salva o DataFrame limpo em um novo arquivo CSV.

```python
# Conferir NaN's e duplicatas
print("Valores ausentes após limpeza:")
print(df.isnull().sum())
print("Linhas duplicadas após limpeza:")
print(df.duplicated().sum())

# Salvar o CSV limpo
df.to_csv('dataset_limpo.csv', index=False)
print("Dataset limpo salvo como 'dataset_limpo.csv'")
```

**Explicação:**
*   `df.isnull().sum()` e `df.duplicated().sum()`: Verificam novamente a presença de valores ausentes e duplicatas para confirmar a limpeza.
*   `df.to_csv('dataset_limpo.csv', index=False)`: Salva o DataFrame processado em um novo arquivo CSV. `index=False` evita que o índice do DataFrame seja escrito como uma coluna no arquivo CSV.

---

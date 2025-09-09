# MD_AULA03_ATIVIDADE: Análise de Dados de COVID-19 no Brasil

Este notebook contém uma série de exercícios para análise de dados de COVID-19 no Brasil, utilizando um dataset disponível publicamente. O objetivo é praticar a manipulação e consulta de dados com `pandas` e `numpy` para extrair informações relevantes.

## Como usar este notebook no Google Colab

1.  **Download do Dataset**: O dataset `caso` pode ser baixado diretamente do site [brasil.io](https://brasil.io/dataset/covid19/files/). Procure pelo arquivo `caso.csv.gz` (compactado) ou `caso.csv` (descompactado) e faça o upload para o ambiente do Google Colab.
2.  Execute as células de código sequencialmente.

## Exercícios e Explicações

Primeiro, vamos importar as bibliotecas necessárias e carregar o dataset. Certifique-se de que o arquivo `caso.csv` (ou `caso.csv.gz`) esteja no seu ambiente do Colab.

```python
import pandas as pd
import numpy as np

# Carregar o dataset
# Se você baixou o arquivo .gz, o pandas pode lê-lo diretamente
df_covid = pd.read_csv("caso.csv.gz", compression=\'gzip\')

# Ou se você baixou o arquivo .csv descompactado
# df_covid = pd.read_csv("caso.csv")

# Exibir as primeiras linhas para verificar o carregamento
print(df_covid.head())
```

**Explicação:**
*   `import pandas as pd`: Importa a biblioteca pandas para manipulação de dados.
*   `import numpy as np`: Importa a biblioteca NumPy para operações numéricas.
*   `pd.read_csv("caso.csv.gz", compression=\'gzip\')`: Carrega o dataset. O `compression=\'gzip\'` é importante se você estiver usando o arquivo compactado, pois o pandas o descompacta automaticamente.

### 1. Quantos registros há na base de dados?

```python
num_registros = df_covid.shape[0]
print(f"Número de registros na base de dados: {num_registros}")
```

**Explicação:**
*   `df_covid.shape`: Retorna uma tupla com o número de linhas e colunas do DataFrame. O primeiro elemento (`[0]`) é o número de linhas (registros).

### 2. Quais estados estão presentes na base de dados?

```python
estados_presentes = df_covid["state"].unique()
print("Estados presentes na base de dados:")
for estado in estados_presentes:
    print(estado)
```

**Explicação:**
*   `df_covid["state"].unique()`: Seleciona a coluna 'state' e retorna um array NumPy com todos os valores únicos presentes nessa coluna, ou seja, os nomes dos estados.

### 3. Qual o total de casos confirmados e mortes no Brasil?

Para obter o total de casos e mortes no Brasil, precisamos considerar os dados mais recentes de cada estado ou, se disponível, a linha que representa o total nacional. No dataset `caso.csv`, a linha com `place_type == 'state'` e `is_last == True` representa o último registro de cada estado, e a linha com `place_type == 'overall'` representa o total nacional.

```python
# Filtrar para o total nacional (place_type == 'overall') e o último registro (is_last == True)
# Se 'is_last' não estiver disponível ou for False, podemos somar os últimos registros por estado

# Tentativa 1: Usar 'place_type' == 'overall' e 'is_last' == True (se disponível e confiável)
# Pode ser que o dataset não tenha uma linha 'overall' ou 'is_last' para o Brasil inteiro.
# Vamos tentar somar os casos e mortes dos últimos registros de cada estado.

# Filtrar os últimos registros de cada estado
# Agrupar por estado e pegar o último registro de cada um (assumindo que o dataset está ordenado por data)
# Ou, se houver a coluna 'is_last', usar ela.

# Verificando se a coluna 'is_last' existe e se há 'overall' type
if 'is_last' in df_covid.columns and 'overall' in df_covid['place_type'].unique():
    total_brasil_df = df_covid[(df_covid['place_type'] == 'overall') & (df_covid['is_last'] == True)]
    if not total_brasil_df.empty:
        total_casos = total_brasil_df['confirmed'].sum()
        total_mortes = total_brasil_df['deaths'].sum()
    else:
        # Fallback: somar os últimos registros de cada estado
        latest_state_data = df_covid[df_covid['place_type'] == 'state'].groupby('state').last()
        total_casos = latest_state_data['confirmed'].sum()
        total_mortes = latest_state_data['deaths'].sum()
else:
    # Fallback: somar os últimos registros de cada estado
    latest_state_data = df_covid[df_covid['place_type'] == 'state'].groupby('state').last()
    total_casos = latest_state_data['confirmed'].sum()
    total_mortes = latest_state_data['deaths'].sum()

print(f"Total de casos confirmados no Brasil: {total_casos}")
print(f"Total de mortes no Brasil: {total_mortes}")
```

**Explicação:**
*   Este código tenta primeiro encontrar a linha que representa o total nacional (`place_type == 'overall'` e `is_last == True`).
*   Se essa linha não for encontrada ou não for confiável, ele agrupa os dados por estado (`groupby('state')`) e pega o último registro de cada estado (`.last()`), que deve conter os dados mais recentes.
*   Em seguida, soma as colunas 'confirmed' e 'deaths' para obter os totais.

### 4. Qual estado teve o maior número total de casos confirmados?

```python
# Filtrar os últimos registros de cada estado
latest_state_data = df_covid[df_covid['place_type'] == 'state'].groupby('state').last()

# Encontrar o estado com o maior número de casos confirmados
estado_maior_casos = latest_state_data.loc[latest_state_data['confirmed'].idxmax()]

print(f"Estado com o maior número de casos confirmados: {estado_maior_casos.name} com {estado_maior_casos['confirmed']} casos.")
```

**Explicação:**
*   `df_covid[df_covid['place_type'] == 'state'].groupby('state').last()`: Obtém o último registro de casos confirmados para cada estado.
*   `latest_state_data['confirmed'].idxmax()`: Retorna o índice (nome do estado) da linha que possui o valor máximo na coluna 'confirmed'.
*   `latest_state_data.loc[...]`: Seleciona a linha correspondente ao estado com o maior número de casos.

### 5. Qual a cidade do Tocantins que teve o maior número de óbitos?

```python
# Filtrar dados do Tocantins e por cidade (place_type == 'city')
tocantins_cities_data = df_covid[(df_covid['state'] == 'TO') & (df_covid['place_type'] == 'city')]

# Pegar o último registro de cada cidade no Tocantins
latest_tocantins_cities_data = tocantins_cities_data.groupby('city').last()

# Encontrar a cidade com o maior número de óbitos
cidade_maior_obitos_to = latest_tocantins_cities_data.loc[latest_tocantins_cities_data['deaths'].idxmax()]

print(f"Cidade do Tocantins com o maior número de óbitos: {cidade_maior_obitos_to.name} com {cidade_maior_obitos_to['deaths']} óbitos.")
```

**Explicação:**
*   Filtra o DataFrame para incluir apenas os registros de cidades no estado do Tocantins (`state == 'TO'` e `place_type == 'city'`).
*   Agrupa por cidade e pega o último registro de cada uma para garantir os dados mais recentes.
*   Usa `idxmax()` na coluna 'deaths' para encontrar a cidade com o maior número de óbitos.

### 6. Qual estado teve a maior taxa de mortalidade?

A taxa de mortalidade pode ser calculada como (mortes / casos confirmados) * 100.

```python
# Filtrar os últimos registros de cada estado
latest_state_data = df_covid[df_covid['place_type'] == 'state'].groupby('state').last()

# Calcular a taxa de mortalidade para cada estado
# Evitar divisão por zero: se confirmed é 0, a taxa é 0 ou NaN
latest_state_data['mortality_rate'] = np.where(
    latest_state_data['confirmed'] > 0,
    (latest_state_data['deaths'] / latest_state_data['confirmed']) * 100,
    0 # Ou np.nan, dependendo de como você quer tratar casos sem confirmados
)

# Encontrar o estado com a maior taxa de mortalidade
estado_maior_taxa_mortalidade = latest_state_data.loc[latest_state_data['mortality_rate'].idxmax()]

print(f"Estado com a maior taxa de mortalidade: {estado_maior_taxa_mortalidade.name} com {estado_maior_taxa_mortalidade['mortality_rate']:.2f}%.")
```

**Explicação:**
*   Calcula a taxa de mortalidade para cada estado, tomando cuidado para evitar divisão por zero usando `np.where`.
*   `idxmax()` é usado para encontrar o estado com a maior taxa de mortalidade calculada.

### 7. Qual a média de casos confirmados por estado?

```python
# Filtrar os últimos registros de cada estado
latest_state_data = df_covid[df_covid['place_type'] == 'state'].groupby('state').last()

# Calcular a média de casos confirmados entre os estados
media_casos_por_estado = latest_state_data['confirmed'].mean()

print(f"Média de casos confirmados por estado: {media_casos_por_estado:.2f}")
```

**Explicação:**
*   Primeiro, obtém os últimos dados de cada estado.
*   Em seguida, calcula a média da coluna 'confirmed' para esses últimos registros estaduais.

### 8. Qual a cidade com o maior número de casos confirmados por 100 mil habitantes?

```python
# Filtrar dados de cidades (place_type == 'city')
cities_data = df_covid[df_covid['place_type'] == 'city']

# Pegar o último registro de cada cidade
latest_cities_data = cities_data.groupby('city').last()

# Calcular casos por 100 mil habitantes
# Evitar divisão por zero para 'estimated_population_2019'
latest_cities_data['cases_per_100k_pop'] = np.where(
    latest_cities_data['estimated_population_2019'] > 0,
    (latest_cities_data['confirmed'] / latest_cities_data['estimated_population_2019']) * 100000,
    0 # Ou np.nan
)

# Remover possíveis NaNs resultantes de populações zero ou nulas antes de encontrar o máximo
latest_cities_data.replace([np.inf, -np.inf], np.nan, inplace=True)
latest_cities_data.dropna(subset=['cases_per_100k_pop'], inplace=True)

# Encontrar a cidade com o maior número de casos por 100 mil habitantes
if not latest_cities_data.empty:
    cidade_maior_casos_por_pop = latest_cities_data.loc[latest_cities_data['cases_per_100k_pop'].idxmax()]
    print(f"Cidade com o maior número de casos confirmados por 100 mil habitantes: {cidade_maior_casos_por_pop.name} com {cidade_maior_casos_por_pop['cases_per_100k_pop']:.2f} casos por 100 mil habitantes.")
else:
    print("Não foi possível calcular a cidade com maior número de casos por 100 mil habitantes (dados insuficientes ou ausentes).")
```

**Explicação:**
*   Filtra os dados para incluir apenas registros de cidades.
*   Obtém o último registro de cada cidade.
*   Calcula a métrica 'cases_per_100k_pop' (casos por 100 mil habitantes), tratando a divisão por zero para a população estimada.
*   Remove quaisquer `NaN` ou `inf` que possam ter sido gerados no cálculo antes de encontrar o valor máximo.
*   Identifica a cidade com o maior valor para essa métrica.


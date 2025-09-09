# MD_AULA04_ATIVIDADE: Gerador de Dataset Sintético Sujo

Este notebook é um gerador de datasets sintéticos que introduz **inconsistências aleatórias** em cada execução. Ele é projetado para criar dados "sujos" que podem ser usados para praticar técnicas de limpeza e pré-processamento de dados. As inconsistências incluem valores ausentes, grafia errada (ruído textual), idades e datas inconsistentes, e registros duplicados.

## Como usar este notebook no Google Colab

1.  Abra este notebook no Google Colab.
2.  Execute as células de código sequencialmente.
3.  O dataset sujo gerado será salvo como um arquivo CSV no diretório `/content/` (ou no seu Google Drive, se configurado).

## Parâmetros do Gerador

Você pode configurar o tamanho do dataset e a reprodutibilidade da geração:

```python
import numpy as np
import random

N = 10_000          # número de linhas do dataset a ser gerado
SEMENTE = None      # use um inteiro (ex.: 42) para resultados reprodutíveis
                    # Deixe SEMENTE=None para aleatoriedade total a cada execução.

if SEMENTE is not None:
    np.random.seed(SEMENTE)
    random.seed(SEMENTE)

print(f"N linhas = {N} | Semente = {SEMENTE}")
```

**Explicação:**
*   `N`: Define o número de linhas (registros) que o dataset sintético terá.
*   `SEMENTE`: Permite fixar a semente para a geração de números aleatórios. Se um valor inteiro for fornecido, a geração de dados será a mesma em todas as execuções, garantindo reprodutibilidade. Se for `None`, os dados serão diferentes a cada execução.
*   `np.random.seed(SEMENTE)` e `random.seed(SEMENTE)`: Funções do NumPy e do módulo `random` do Python para definir a semente dos geradores de números pseudoaleatórios.

## Injeção de Inconsistências

O notebook gera um DataFrame base (limpo) e, em seguida, aplica diversas "sujeiras" em porções aleatórias dos dados. Abaixo estão os tipos de inconsistências introduzidas:

### 1. Valores Ausentes (NaN)

Valores `NaN` (Not a Number) são inseridos aleatoriamente em várias colunas (`idade`, `salario`, `cidade`, `estado_civil`, `cargo`, `telefone`) com diferentes proporções. A coluna `telefone` é projetada para ter uma alta porcentagem de valores ausentes.

```python
# Exemplo de como os valores ausentes são inseridos (trecho do código do notebook):
# proporcoes_na = {
#     'idade': np.random.uniform(0.02, 0.08),
#     'salario': np.random.uniform(0.02, 0.08),
#     'cidade': np.random.uniform(0.02, 0.08),
#     'estado_civil': np.random.uniform(0.01, 0.06),
#     'cargo': np.random.uniform(0.01, 0.05),
#     'telefone': np.random.uniform(0.60, 0.95)
# }
# for col, p in proporcoes_na.items():
#     m = np.random.rand(N) < p
#     df.loc[m, col] = np.nan
```

**Explicação:**
*   `np.random.uniform()`: Gera um número aleatório de ponto flutuante dentro de um intervalo especificado, usado para definir a proporção de `NaN`s.
*   `np.random.rand(N) < p`: Cria uma máscara booleana onde `True` indica as posições onde `NaN` será inserido, com base na proporção `p`.
*   `df.loc[m, col] = np.nan`: Atribui `np.nan` (valor ausente do NumPy) às posições selecionadas na coluna.

### 2. Ruído Textual (Grafia Errada)

Caracteres especiais, espaços extras, e variações de maiúsculas/minúsculas são introduzidos em colunas de texto (`nome`, `cidade`, `estado_civil`, `cargo`). Isso simula erros de digitação ou inconsistências na entrada de dados.

```python
# Exemplo de como o ruído textual é inserido (trecho do código do notebook):
# def ruidificar_texto(s: str) -> str:
#     # ... lógica para adicionar espaços, mudar caixa, substituir caracteres (leetspeak)
#     return s2
#
# for col in ['nome','cidade','estado_civil','cargo']:
#     mask_ruido = np.random.rand(N) < np.random.uniform(0.05, 0.15)
#     df.loc[mask_ruido, col] = df.loc[mask_ruido, col].astype('object').apply(ruidificar_texto)
```

**Explicação:**
*   A função `ruidificar_texto` modifica strings adicionando espaços, alterando a capitalização e substituindo letras por números (leetspeak).
*   `np.random.rand()`: Usado para selecionar aleatoriamente quais registros terão ruído textual.

### 3. Idades Inconsistentes

Valores de idade fora de um intervalo plausível (e.g., idades negativas, muito baixas ou muito altas) são inseridos.

```python
# Exemplo de como idades inconsistentes são inseridas (trecho do código do notebook):
# idx_bad_idade = np.random.choice(df.index, size=int(np.random.uniform(0.01, 0.03)*N), replace=False)
# choices = [-5, -1, 5, 8, 10, 120, 150]
# df.loc[idx_bad_idade, 'idade'] = np.random.choice(choices, size=len(idx_bad_idade))
```

**Explicação:**
*   `np.random.choice()`: Seleciona aleatoriamente índices do DataFrame para inserir idades inconsistentes de uma lista predefinida de `choices`.

### 4. Datas Inconsistentes

Datas de admissão no futuro ou em formatos inválidos são introduzidas.

```python
# Exemplo de como datas inconsistentes são inseridas (trecho do código do notebook):
# def data_futura():
#     # ... gera uma data no futuro
#     return data_formatada
# idx_bad_data = np.random.choice(df.index, size=int(np.random.uniform(0.01, 0.03)*N), replace=False)
# for i in idx_bad_data:
#     df.at[i, 'data_admissao'] = data_futura() if random.random() < 0.7 else 'xx/yy/zzzz'
```

**Explicação:**
*   Datas futuras são geradas e inseridas, ou strings inválidas como `xx/yy/zzzz`.

### 5. Outliers e Valores Negativos em Salário

Valores de salário são multiplicados por fatores que criam outliers (muito altos ou muito baixos) e alguns salários negativos são inseridos.

```python
# Exemplo de como outliers e negativos são inseridos (trecho do código do notebook):
# sal = pd.to_numeric(df['salario'], errors='coerce')
# idx_ruido_sal = np.random.choice(df.index, size=int(np.random.uniform(0.01, 0.03)*N), replace=False)
# mult = np.random.choice([10, 20, 0.05], size=len(idx_ruido_sal))
# sal.loc[idx_ruido_sal] = sal.loc[idx_ruido_sal] * mult
# neg_idx = np.random.choice(df.index, size=int(np.random.uniform(0.003, 0.01)*N), replace=False)
# sal.loc[neg_idx] = -abs(sal.loc[neg_idx].fillna(1000))
# df['salario'] = sal
```

**Explicação:**
*   `np.random.choice()`: Usado para selecionar índices para aplicar as modificações de salário.
*   Multiplicadores (`mult`) são aplicados para criar valores extremos.
*   Valores negativos são inseridos para simular erros ou dados inválidos.

### 6. Registros Duplicados

Uma fração dos registros existentes é duplicada e adicionada ao DataFrame, e o DataFrame é então embaralhado para que as duplicatas não estejam adjacentes.

```python
# Exemplo de como duplicatas são inseridas (trecho do código do notebook):
# dup_frac = np.random.uniform(0.01, 0.03)
# dups = df.sample(frac=dup_frac, replace=False, random_state=None)
# df_sujo = pd.concat([df, dups], ignore_index=True).sample(frac=1.0, random_state=None).reset_index(drop=True)
```

**Explicação:**
*   `df.sample(frac=dup_frac, replace=False)`: Seleciona uma fração (`dup_frac`) das linhas do DataFrame para duplicar.
*   `pd.concat()`: Combina o DataFrame original com as linhas duplicadas.
*   `.sample(frac=1.0).reset_index(drop=True)`: Embaralha o DataFrame resultante para distribuir as duplicatas aleatoriamente.

## Salvando o Dataset Gerado

O dataset "sujo" final é salvo em um arquivo CSV com um timestamp no nome para evitar sobrescrever arquivos anteriores.

```python
from datetime import datetime
import os

# O diretório de saída pode ser configurado no início do notebook (OUTPUT_DIR)
# Por padrão, é /content/ no Google Colab
OUTPUT_DIR = "/content/"

ts = datetime.now().strftime("%Y%m%d_%H%M%S")
OUT = os.path.join(OUTPUT_DIR, f"dataset_sintetico_sujo_8attrs_{ts}.csv")
df_sujo.to_csv(OUT, index=False)
print(f"✅ CSV salvo em: {OUT}")
```

**Explicação:**
*   `datetime.now().strftime("%Y%m%d_%H%M%S")`: Gera um timestamp formatado para ser incluído no nome do arquivo, garantindo que cada arquivo gerado seja único.
*   `os.path.join()`: Constrói o caminho completo do arquivo de forma segura, independentemente do sistema operacional.
*   `df_sujo.to_csv(OUT, index=False)`: Salva o DataFrame `df_sujo` no caminho especificado. `index=False` impede que o índice do DataFrame seja escrito como uma coluna no arquivo CSV.


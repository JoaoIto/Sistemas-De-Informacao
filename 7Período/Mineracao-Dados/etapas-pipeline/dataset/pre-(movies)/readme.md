# README — Atividade de Mineração de Dados (Movies)

## 1) Objetivo

Aplicar **pré-processamento** em um dataset de filmes para deixá-lo pronto para análise/modelagem: limpeza, conversão de tipos, tratamento de ausentes, criação de features, padronização e EDA simples.

---

## 2) Fonte dos dados

* **KaggleHub**: `bharatnatrayn/movies-dataset-for-feature-extracion-prediction`
* Arquivo base: `movies.csv` (baixado pelo KaggleHub).

---

## 3) Ambiente (Google Colab)

Principais pacotes: `kagglehub, pandas, numpy, matplotlib, seaborn, scikit-learn (opcional)`.
No Colab, instalar e importar na primeira célula.

---

## 4) Como executar (resumo das células)

1. **Instalação & imports**
   Instalar libs e importar (`pandas`, `numpy`, `matplotlib`, etc.).
2. **Download do dataset (KaggleHub)**
   Baixar o dataset e localizar o `movies.csv`.
3. **Carregar & explorar**
   `pd.read_csv`, `df.head()`, `df.info()`, `df.describe()`, `df.isna().sum()`.
4. **Remover duplicatas**
   `df.drop_duplicates()` e, se existir, por `["title","year"]`.
5. **Converter tipos**

    * `year` → inteiro (extrair 4 dígitos se vier como texto)
    * `rating` → float
    * `votes`, `gross` → números (remover símbolos/letras)
    * `runtime` → minutos (pegar número)
    * Trim em textos: `str.strip()`
6. **Tratar ausentes**

    * Numéricos: **mediana**
    * Categóricos: `"Unknown"`
7. **Criar features**

    * `one_line_len` (tamanho do texto)
    * `stars_count` (nº de nomes em `stars`)
    * `genre` → **one-hot** (dummies) dos 10 gêneros mais comuns
    * `primary_genre` (primeiro gênero da lista)
8. **Transformações**

    * **log1p** em `votes` e `gross` (reduz cauda longa)
    * **Escala Min-Max** manual (0 a 1) nos principais campos (opcional)
9. **EDA (gráficos simples)**

    * Hist: `rating`
    * Hist: `votes` (antes/depois do log)
    * Boxplot: `rating` × `primary_genre` (top 10)
    * Scatter: `rating` × `votes_log1p`
    * Barras: frequência de gêneros (dummies)
10. **Exportar**
    `df.to_csv("movies_clean_preprocessed.csv", index=False)`.

---

## 5) O que foi feito e por quê (didático e direto)

### Limpeza

* **Duplicatas**: removidas para não contar o mesmo filme duas vezes (evita distorção em médias e gráficos).

### Conversão de tipos

* **`year`**: valores como “(2021)” ou “2010–2022” → extraído o **primeiro ano de 4 dígitos** e convertido para inteiro.
* **`rating`**: texto → float (para cálculos).
* **`votes` e `gross`**: remoção de símbolos (“K/M/\$/,”) e conversão para número (para somas/medianas).
* **`runtime`**: minutos (pega o número que aparece).

**Motivo**: modelos e gráficos precisam de **números**; strings quebram estatísticas (ex.: `median()`).

### Ausentes (NaN)

* **Numéricos → mediana**: robusta a outliers (menos sensível que média).
* **Categóricos → "Unknown"**: evita perder linhas inteiras.

### Features

* **`one_line_len`**: proxy de “tamanho de sinopse”.
* **`stars_count`**: qtd. de atores listados (informação de elenco).
* **`genre` → one-hot**: transforma categorias em 0/1 (modelo entende).
* **`primary_genre`**: ajuda em comparações/gráficos por gênero.

### Transformações de distribuição e escala

* **`log1p`** (em `votes`/`gross`) “comprime” valores muito altos (cauda longa), deixando a distribuição mais estável.
* **Min-Max (0–1)**: coloca variáveis em escala comparável (útil para alguns algoritmos e visualizações).

### EDA (por que esses gráficos?)

* **Histograma**: ver forma da distribuição (ex.: se `rating` é simétrica).
* **Boxplot por gênero**: comparar faixas e mediana entre categorias.
* **Scatter `rating` × `votes_log1p`**: observar relação entre popularidade e avaliação.
* **Barras (gêneros)**: identificar os gêneros mais frequentes.

### Saída

* **`movies_clean_preprocessed.csv`**: dataset pronto para próxima etapa (modelos, análises mais profundas).

---

## 6) Problemas comuns & soluções rápidas

* **Erro de mediana (“Cannot convert to numeric”)**
  Causa: coluna “numérica” ainda tem texto (ex.: `"(2021)"`, `"2010–2022"`).
  **Solução**: antes da mediana, **forçar numérico**:
  `df[c] = pd.to_numeric(df[c], errors="coerce")`
  (e, para `year`, **extrair 4 dígitos** com regex antes).

* **`votes`/`gross` com símbolos**
  **Solução**: `str.replace(r"[^0-9.]", "", regex=True)` e depois `pd.to_numeric`.

---

## 7) Principais comandos usados (guia rápido)

* Remover duplicatas: `df.drop_duplicates(...)`
* Converter para número: `pd.to_numeric(col, errors="coerce")`
* Extrair ano: `str.extract(r"(\d{4})")`
* Preencher NaN com mediana: `df[c].fillna(df[c].median())`
* Dummies (one-hot) de `genre`: `df["genre"].str.get_dummies(sep=",")`
* Log seguro: `np.log1p(x)`
* Min-Max manual: `(x - x.min()) / (x.max() - x.min())`
* Gráficos: `series.hist()`, `df.boxplot(...)`, `df.plot.scatter(...)`, `series.plot.bar()`
* Exportar: `df.to_csv("movies_clean_preprocessed.csv", index=False)`

---

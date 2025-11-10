# Regressão com PyCaret – Predição de Gols do Time da Casa

## 1. Introdução

O objetivo deste experimento é aplicar o aprendizado supervisionado, por meio da biblioteca **PyCaret**, para resolver uma tarefa de **regressão** utilizando um conjunto de dados real do futebol internacional, extraído do repositório [Kaggle – International Football Results (1872–2025)](https://www.kaggle.com/datasets/martj42/international-football-results-from-1872-to-2017).

A variável alvo escolhida foi **`home_score`**, que representa a quantidade de gols marcados pelo time mandante em uma partida.
O objetivo é prever esse valor a partir de informações como o adversário, local da partida, torneio e se o jogo foi em campo neutro.

---

## 2. Etapas do Processo

### 2.1 Importação das bibliotecas

O código utiliza as bibliotecas **pandas** para manipulação dos dados e **pycaret.regression** para todo o fluxo de modelagem:

```python
import pandas as pd
from pycaret.regression import *
```

---

### 2.2 Leitura e exploração dos dados

Os dados foram importados diretamente do repositório público:

```python
url = "https://raw.githubusercontent.com/martj42/international_results/master/results.csv"
df = pd.read_csv(url)
```

O dataset contém 48.673 registros de partidas e 9 colunas.
Cada linha representa o resultado de uma partida internacional entre seleções masculinas de futebol.

**Atributos principais:**

| Coluna       | Descrição                                      |
| ------------ | ---------------------------------------------- |
| `date`       | Data da partida                                |
| `home_team`  | Seleção mandante                               |
| `away_team`  | Seleção visitante                              |
| `home_score` | Número de gols do time da casa (variável alvo) |
| `away_score` | Número de gols do time visitante               |
| `tournament` | Nome do torneio                                |
| `city`       | Cidade onde ocorreu o jogo                     |
| `country`    | País onde ocorreu o jogo                       |
| `neutral`    | Indica se o jogo foi realizado em campo neutro |

---

### 2.3 Configuração do ambiente PyCaret

A configuração foi realizada com a função `setup()`, definindo a variável alvo e as variáveis categóricas.
As colunas `date` e `away_score` foram ignoradas por não contribuírem diretamente para a predição do alvo.

```python
reg = setup(
    data=df,
    target='home_score',
    session_id=123,
    ignore_features=['date', 'away_score'],
    categorical_features=['home_team', 'away_team', 'tournament', 'city', 'country']
)
```

Durante essa etapa, o PyCaret executa automaticamente:

* Detecção de variáveis numéricas e categóricas.
* Aplicação de *encoding* para variáveis categóricas.
* Divisão dos dados em treino e teste (por padrão, 70%/30%).
* Criação de validação cruzada (KFold com 10 folds).

---

### 2.4 Comparação dos modelos

A função `compare_models()` foi utilizada para testar e comparar diversos algoritmos de regressão disponíveis no PyCaret, retornando as métricas principais: MAE, MSE, RMSE, R², RMSLE e MAPE.

```python
best = compare_models()
```

**Resumo dos principais resultados:**

| Modelo            | MAE       | RMSE      | R²        |
| ----------------- | --------- | --------- | --------- |
| **LightGBM**      | **1.167** | **1.590** | **0.180** |
| XGBoost           | 1.172     | 1.600     | 0.169     |
| Gradient Boosting | 1.175     | 1.601     | 0.168     |
| Bayesian Ridge    | 1.196     | 1.627     | 0.142     |
| Linear Regression | 1.196     | 1.627     | 0.142     |
| Random Forest     | 1.236     | 1.678     | 0.086     |
| Dummy (baseline)  | 1.293     | 1.757     | -0.000    |

O melhor desempenho foi obtido com o **Light Gradient Boosting Machine (LightGBM)**, apresentando menor erro médio e melhor R² entre os modelos testados.

---

### 2.5 Ajuste de hiperparâmetros

Após selecionar o melhor modelo, aplicou-se a função `tune_model()` para otimizar seus parâmetros internos:

```python
tuned = tune_model(best)
```

Essa etapa busca melhorar as métricas de desempenho, testando combinações de parâmetros (exemplo: número de árvores, profundidade máxima e taxa de aprendizado).

---

### 2.6 Avaliação e interpretação

A etapa de avaliação foi realizada com:

```python
evaluate_model(tuned)
interpret_model(tuned)
```

O PyCaret apresenta gráficos de:

* Erros residuais
* Curva de predição
* Importância das variáveis
* Distribuição das previsões

A **importância das variáveis (Feature Importance)** indica que os atributos **time da casa**, **torneio** e **campo neutro** possuem maior influência na predição do número de gols.

---

## 3. Resultados e análise

A validação cruzada (10 folds) apresentou desempenho médio consistente:

| Métrica | Valor Médio |
| ------- | ----------- |
| MAE     | 1.1588      |
| MSE     | 2.4814      |
| RMSE    | 1.5747      |
| R²      | 0.1960      |

O R² de aproximadamente 0.19 indica que o modelo explica cerca de **19% da variação dos gols marcados pelo time da casa**.
Embora o valor não seja alto, é aceitável considerando que o dataset não contém informações diretas sobre fatores críticos do jogo (como escalação, clima, ranking ou mando de torcida).

---

## 4. Conclusão

O experimento cumpre todos os objetivos da atividade, aplicando de forma correta o processo de **aprendizado supervisionado de regressão** com o PyCaret.

**Resumo técnico:**

* A variável-alvo foi definida corretamente (`home_score`).
* O ambiente PyCaret foi configurado e pré-processado automaticamente.
* Diversos modelos foram comparados de forma padronizada.
* O melhor modelo (LightGBM) apresentou métricas coerentes e estáveis.
* As etapas de ajuste, avaliação e interpretação foram realizadas conforme os conceitos teóricos estudados em aula.

**Limitações:**
O modelo apresenta desempenho limitado por não considerar variáveis contextuais (como desempenho recente, escalações ou condições climáticas). Portanto, sua aplicação em produção seria apenas exploratória, útil para fins de análise estatística ou demonstração didática.

---

## 5. Conclusão final (resumo para relatório)

> Esta atividade está em conformidade com os conceitos apresentados em aula e com o exemplo prático fornecido, pois segue o fluxo completo de um problema de regressão supervisionada no PyCaret: importação e preparação dos dados, configuração do ambiente, comparação de modelos, ajuste de hiperparâmetros, avaliação e interpretação dos resultados.
> O modelo obtido (LightGBM) demonstra capacidade razoável de predição e permite compreender quais fatores mais influenciam o desempenho do time da casa em partidas internacionais.

---


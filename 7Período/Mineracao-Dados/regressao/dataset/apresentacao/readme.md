# [Apresentação Predição de Gols do Time da Casa – Regressão com PyCaret](https://gamma.app/docs/Previsao-de-Gols-em-Partidas-Internacionais-boon0in018vl1sr)

## 1. Introdução

Este projeto tem como objetivo aplicar os conceitos de **aprendizado supervisionado** para resolver uma **tarefa de regressão** utilizando a biblioteca **PyCaret**.
O dataset utilizado é o *International Football Results from 1872 to 2025*, disponível publicamente no [Kaggle](https://www.kaggle.com/datasets/martj42/international-football-results-from-1872-to-2017).

O problema consiste em **prever o número de gols marcados pelo time da casa (`home_score`)** com base em variáveis categóricas como o adversário, o torneio, o país e se o jogo ocorreu em campo neutro.

---

## 2. Descrição do Dataset

O conjunto de dados contém 48.673 partidas internacionais masculinas, registradas entre 1872 e 2025.

| Coluna       | Descrição                                                     |
| ------------ | ------------------------------------------------------------- |
| `date`       | Data da partida                                               |
| `home_team`  | Seleção mandante                                              |
| `away_team`  | Seleção visitante                                             |
| `home_score` | Número de gols marcados pelo time da casa (**variável-alvo**) |
| `away_score` | Número de gols marcados pelo time visitante                   |
| `tournament` | Nome do torneio                                               |
| `city`       | Cidade onde ocorreu o jogo                                    |
| `country`    | País onde ocorreu o jogo                                      |
| `neutral`    | Indica se o jogo ocorreu em campo neutro (True/False)         |

O dataset foi carregado diretamente da fonte original:

```python
import pandas as pd
url = "https://raw.githubusercontent.com/martj42/international_results/master/results.csv"
df = pd.read_csv(url)
```

---

## 3. Configuração do Ambiente PyCaret

A biblioteca **PyCaret** foi utilizada para automatizar o fluxo completo de modelagem de regressão.
A variável alvo foi definida como `home_score`, e as colunas `date` e `away_score` foram ignoradas por não contribuírem para a predição.

```python
from pycaret.regression import *

reg = setup(
    data=df,
    target='home_score',
    session_id=123,
    ignore_features=['date', 'away_score'],
    categorical_features=['home_team', 'away_team', 'tournament', 'city', 'country']
)
```

Durante a configuração, o PyCaret executa automaticamente:

* Pré-processamento (imputação, codificação e normalização).
* Identificação de variáveis categóricas.
* Divisão em dados de treino e teste.
* Criação de validação cruzada (10 folds).

---

## 4. Comparação dos Modelos Disponíveis

A função `compare_models()` foi utilizada para testar múltiplos algoritmos de regressão disponíveis no PyCaret e selecionar automaticamente o de melhor desempenho com base nas métricas de erro e acurácia.

```python
best = compare_models()
```

**Resultados resumidos:**

| Modelo            | MAE       | RMSE      | R²        |
| ----------------- | --------- | --------- | --------- |
| **LightGBM**      | **1.167** | **1.590** | **0.180** |
| XGBoost           | 1.172     | 1.600     | 0.169     |
| Gradient Boosting | 1.175     | 1.601     | 0.168     |
| Linear Regression | 1.196     | 1.627     | 0.142     |
| Random Forest     | 1.236     | 1.678     | 0.086     |
| Dummy Regressor   | 1.293     | 1.757     | -0.000    |

**Análise:**

* O **Light Gradient Boosting Machine (LightGBM)** apresentou o **melhor desempenho geral**, com o menor erro médio (MAE) e maior R² (0.18).
* Isso indica que o modelo consegue capturar parte das variações dos gols do time da casa, mesmo em um problema de alta variabilidade.

---

## 5. Ajuste de Hiperparâmetros com `tune_model`

Após selecionar o melhor modelo, foi utilizado o método `tune_model()` para otimizar seus hiperparâmetros automaticamente.
O processo aplica busca em grade (Grid Search) e validação cruzada para encontrar a melhor combinação de parâmetros.

```python
tuned = tune_model(best)
```

**Objetivo:** reduzir erros e melhorar o desempenho geral.
Após o ajuste, observou-se uma pequena melhora nas métricas, indicando que o modelo ajustado se beneficiou da otimização de parâmetros como taxa de aprendizado e número de árvores.

---

## 6. Avaliação do Modelo Final

A função `evaluate_model()` permite visualizar de forma interativa as principais métricas e gráficos de avaliação, como:

* **Erros residuais** – diferença entre o valor previsto e o valor real.
* **Prediction Error Plot** – correlação entre valores previstos e reais.
* **Learning Curve** – comportamento do erro em função do número de amostras.
* **Feature Importance** – importância relativa de cada variável no modelo.

```python
evaluate_model(tuned)
```

---

## 7. Interpretação dos Resultados com SHAP

Para compreender a influência de cada variável sobre as previsões, foi utilizada a função `interpret_model()`, que aplica os valores **SHAP (SHapley Additive exPlanations)**.

```python
interpret_model(tuned)
```

O gráfico gerado mostra a **importância das variáveis**:

| Variável     | Importância aproximada |
| ------------ | ---------------------- |
| `home_team`  | Alta                   |
| `tournament` | Alta                   |
| `neutral`    | Moderada               |
| `country`    | Moderada               |
| `away_team`  | Baixa                  |

**Interpretação:**

* O desempenho do time da casa depende fortemente **de quem é o mandante** e **do torneio disputado**.
* O fator **campo neutro** reduz a vantagem do time da casa, afetando diretamente o número de gols.
* Times visitantes e países apresentam menor influência individual, mas contribuem para a variabilidade geral.

---

## 8. Interpretação e Discussão dos Resultados

**Desempenho do modelo:**

| Métrica | Valor médio (validação cruzada) |
| ------- | ------------------------------- |
| MAE     | 1.1588                          |
| RMSE    | 1.5747                          |
| R²      | 0.1960                          |

* O modelo possui desempenho **modesto**, explicando cerca de **19% da variação dos gols marcados** pelo time da casa.
* Isso é esperado, pois o dataset não contém informações como escalações, clima, ranking FIFA ou estatísticas de desempenho recentes, que são altamente relevantes em contextos esportivos.

**Principais observações:**

* O **LightGBM** mostrou-se o mais robusto e consistente.
* Pequena variação entre folds indica boa generalização.
* A ausência de *overfitting* mostra que o modelo se ajusta bem aos dados históricos.

---

## 9. Limitações e Possibilidade de Uso em Produção

Apesar do modelo ter sido construído corretamente e apresentar resultados consistentes, ele **não é adequado para uso em produção** em cenários reais de previsão esportiva, pelos seguintes motivos:

1. **Variáveis limitadas:** o dataset contém apenas resultados históricos e não inclui fatores determinantes (escalação, clima, ranking, mando de campo detalhado).
2. **R² baixo:** o modelo explica apenas uma pequena parte da variabilidade dos gols (≈19%).
3. **Mudanças ao longo do tempo:** o desempenho das seleções varia em função de períodos, competições e gerações de atletas.

**Conclusão sobre uso prático:**

> O modelo é adequado para **fins acadêmicos, exploratórios e didáticos**, demonstrando o fluxo completo de um projeto de regressão supervisionada com PyCaret.
> Contudo, para uso preditivo real, seria necessário um conjunto de dados mais completo, com variáveis contextuais e atualizações contínuas.

---

## 10. Conclusão Geral

A atividade cumpre todos os requisitos propostos em aula e segue corretamente o fluxo de modelagem de regressão supervisionada:

1. Importação e exploração dos dados.
2. Configuração do ambiente e definição da variável alvo.
3. Comparação automática de modelos.
4. Ajuste de hiperparâmetros com `tune_model`.
5. Avaliação detalhada com métricas e gráficos.
6. Interpretação dos resultados com SHAP.
7. Discussão sobre limitações e aplicabilidade em produção.

**Resumo técnico:**

* **Melhor modelo:** Light Gradient Boosting Machine (LightGBM)
* **Métricas médias:** MAE = 1.15 | RMSE = 1.57 | R² = 0.19
* **Tipo de problema:** Regressão supervisionada
* **Biblioteca utilizada:** PyCaret 3.0.4
* **Conclusão:** modelo funcional, didático e coerente com os conceitos de aula

---


# Interpretação e Conclusões da Regressão – International Football Results

## 1. Interpretação geral do experimento

A regressão teve como objetivo **prever o número de gols marcados pelo time da casa (`home_score`)** com base em variáveis históricas de partidas internacionais.
O modelo foi treinado com **48.673 partidas**, com pré-processamento automático e validação cruzada de 10 folds, garantindo consistência nas métricas.

O algoritmo de melhor desempenho foi o **Light Gradient Boosting Machine (LightGBM)**, após comparação com 18 modelos diferentes (como XGBoost, Random Forest, Regressão Linear e outros).

---

## 2. Avaliação dos resultados obtidos

### Métricas médias (validação cruzada)

| Métrica                                  | Valor médio | Interpretação                                                                                              |
| ---------------------------------------- | ----------- | ---------------------------------------------------------------------------------------------------------- |
| **MAE (Erro Absoluto Médio)**            | 1.1588      | Em média, o modelo erra cerca de **1,15 gol** por previsão.                                                |
| **RMSE (Raiz do Erro Quadrático Médio)** | 1.5747      | O erro quadrático indica variações médias em torno de 1,57 gols, mostrando alguma dispersão nas previsões. |
| **R² (Coeficiente de Determinação)**     | 0.1960      | O modelo explica aproximadamente **19,6% da variação total** dos gols do time da casa.                     |
| **MAPE (Erro Percentual Médio)**         | 0.504       | Erro percentual médio de cerca de **50%**, típico em problemas esportivos com grande variabilidade.        |

Esses valores mostram que, embora o modelo consiga identificar **tendências gerais**, a **precisão ainda é limitada** para predições exatas, devido à natureza aleatória e contextual do futebol.

---

## 3. Interpretação das variáveis (SHAP e importância de atributos)

A análise com **SHAP (SHapley Values)** e *Feature Importance* indicou as variáveis mais relevantes para as predições:

| Variável     | Importância | Interpretação                                                                                                            |
| ------------ | ----------- | ------------------------------------------------------------------------------------------------------------------------ |
| `home_team`  | Alta        | O time mandante é o principal fator determinante, pois algumas seleções historicamente marcam mais gols jogando em casa. |
| `tournament` | Alta        | O tipo de competição influencia o desempenho (amistosos têm menos gols, enquanto copas podem ter maior intensidade).     |
| `neutral`    | Moderada    | Jogos em campo neutro tendem a reduzir o número de gols do time da casa.                                                 |
| `country`    | Moderada    | O país impacta condições ambientais e vantagens de torcida.                                                              |
| `away_team`  | Baixa       | Embora relevante, o desempenho do adversário afeta menos o número de gols da casa em relação às outras variáveis.        |

---

## 4. Interpretação dos hiperparâmetros ajustados

Após o uso de `tune_model()`, os melhores hiperparâmetros encontrados para o LightGBM foram:

| Parâmetro                 | Valor | Significado                                                                          |
| ------------------------- | ----- | ------------------------------------------------------------------------------------ |
| `learning_rate`           | 0.1   | Taxa de aprendizado moderada, permitindo bom equilíbrio entre precisão e velocidade. |
| `num_leaves`              | 70    | Determina a complexidade das árvores; valor adequado para evitar overfitting.        |
| `n_estimators`            | 260   | Número de árvores; indica um modelo estável.                                         |
| `reg_alpha`, `reg_lambda` | 2 e 3 | Penalizações L1 e L2, usadas para controlar o overfitting.                           |
| `feature_fraction`        | 0.4   | Apenas 40% das variáveis são usadas por árvore, aumentando a generalização.          |

Esses valores reforçam que o modelo foi ajustado para **balancear desempenho e estabilidade**.

---

## 5. Discussão sobre o desempenho do modelo

O modelo apresentou **bom desempenho conceitual**, mas **baixa explicabilidade estatística (R² ≈ 0.19)**, o que é esperado para problemas esportivos.
Isso ocorre porque o número de gols depende fortemente de fatores **não incluídos no dataset**, como:

* Escalações e forma dos jogadores;
* Estratégias táticas;
* Clima, torcida, lesões, penalidades;
* Período histórico (as regras e dinâmicas do futebol mudaram ao longo dos anos).

Mesmo assim, o modelo **aprendeu padrões históricos**, como a vantagem de jogar em casa e o impacto do tipo de torneio.

---

## 6. Conclusões sobre as predições

* O modelo é capaz de **estimar tendências gerais** — por exemplo, prever que seleções fortes em casa tendem a marcar mais gols em torneios competitivos.
* As previsões **não devem ser interpretadas como resultados exatos**, mas como **probabilidades médias** baseadas no histórico.
* Em um cenário prático, o modelo poderia ser utilizado para **análises exploratórias, simulações ou suporte estatístico** — não para apostas ou previsões em tempo real.

---

## 7. Considerações sobre uso em produção

| Aspecto                     | Avaliação                                                                              |
| --------------------------- | -------------------------------------------------------------------------------------- |
| **Generalização**           | Boa, sem sinais de overfitting.                                                        |
| **Interpretação**           | Alta explicabilidade com SHAP.                                                         |
| **Precisão**                | Moderada (erro ≈ 1 gol).                                                               |
| **Viabilidade em produção** | Limitada, pois faltam variáveis dinâmicas (ranking, escalação, estatísticas recentes). |
| **Aplicação prática**       | Indicada para **análises históricas e aprendizado supervisionado acadêmico**.          |

**Conclusão:**

> O modelo cumpre plenamente o objetivo didático da atividade — demonstrando o processo completo de regressão, comparação e ajuste de modelos — e ilustra as limitações de previsões esportivas baseadas apenas em dados históricos.

---

## 8. Síntese final

* **Melhor modelo:** Light Gradient Boosting Machine (LightGBM)
* **Métricas médias:** MAE = 1.15 | RMSE = 1.57 | R² = 0.19
* **Principais variáveis:** `home_team`, `tournament`, `neutral`, `country`
* **Natureza do problema:** Alta variabilidade e baixa previsibilidade individual
* **Conclusão geral:** O modelo identifica padrões históricos, mas a aleatoriedade dos resultados do futebol limita sua precisão. Ele é excelente como exercício de **aprendizado supervisionado e análise preditiva exploratória**.

---

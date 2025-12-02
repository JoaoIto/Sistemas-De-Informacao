# Documentação Mineração de Dados A2 - **Conceitos + Aplicação Prática**

***

## 1. PROCESSO KDD (Knowledge Discovery in Databases)

### **O que é e Para que Serve**
O **KDD** é o **fluxo completo** de transformar dados brutos em conhecimento acionável. Não é só "rodar algoritmo", mas um processo estruturado que garante resultados confiáveis.

**Aprendizado de Máquina:** Base para **todos** os tipos (supervisionado e não-supervisionado).

**Como é feito nas atividades:** 
- Datasets reais com NaN, duplicatas, escalas diferentes
- **Sempre** dividido em: exploração → limpeza → modelagem → validação

| **Etapa** | **O que Faz** | **Nas Atividades (Exemplo)** | **Configuração Típica** |
|-----------|---------------|-----------------------------|-------------------------|
| **Seleção** | Escolher dados relevantes | `df = df[['idade', 'renda', 'compra']]` | Domain knowledge |
| **Pré-processamento** | Limpar sujeira | `df.dropna()`, `df.drop_duplicates()` | 80% do tempo gasto aqui |
| **Transformação** | Preparar formato ML | `StandardScaler()`, `OneHotEncoder()` | **CRÍTICO** para todos algoritmos |
| **Mineração** | Extrair padrões | `KMeans()`, `RandomForest()` | Varia por técnica |
| **Avaliação** | Validar se funciona | `cross_val_score()`, métricas | K-fold=5 ou 10 |

**Como ajuda:** Sem KDD, modelo falha em produção (data leakage, overfitting, métricas erradas).

***

## 2. REGRESSÃO (**SUPERVISIONADO**)

### **O que é e Para que Serve**
**Regressão** prediz **valores contínuos** (preço, temperatura, quantidade). Usa dados **com rótulo** (target conhecido) para aprender relação X → y.

**Aprendizado Supervisionado:** 
1. Treina com pares (features, target)
2. Minimiza erro entre predito e real
3. Generaliza para novos dados

**Nas atividades:** Previsão de preços de casas, vendas, notas. Dataset tem target numérico.

### **Como Funciona na Prática**
```
Dataset: casas.csv [tamanho, quartos, idade] → [preco]
1. Treino: Aprende β₀ + β₁×tamanho + β₂×quartos
2. Teste: Prediz preco novos imóveis
3. Avalia: RMSE, R²
```

### **TABELA — PARÂMETROS E MÉTRICAS DE REGRESSÃO**

| **Parâmetro / Métrica**              | **Serve Para**                                              | **Configuração nas Atividades (Python/Colab)** | **Exemplo Prático (Fácil de Entender)**                        |
| ------------------------------------ | ----------------------------------------------------------- | ---------------------------------------------- | -------------------------------------------------------------- |
| **β₀ (Intercepto)**                  | Valor base quando todas variáveis = 0                       | `model.intercept_`                             | Preço inicial de uma casa sem nenhum atributo = **R$ 50.000**  |
| **β₁, β₂… (Coeficientes)**           | Quanto cada variável impacta no valor                       | `model.coef_`                                  | Cada m² a mais aumenta **R$ 150** no preço                     |
| **R² (Coeficiente de Determinação)** | Quanto o modelo explica da variação do target               | `model.score(X_test, y_test)`                  | R² = **0.82** → modelo explica **82%** do preço                |
| **R² Ajustado**                      | Ajusta o R² pelo número de variáveis (evita falsa melhoria) | Via statsmodels: `results.rsquared_adj`        | Se R² aumenta mas o ajustado cai → variável inútil             |
| **MSE (Mean Squared Error)**         | Penaliza erros grandes V² → muito sensível a outliers       | `mean_squared_error(y_test, pred)`             | MSE = **625.000.000** (erros grandes puxaram pra cima)         |
| **RMSE (Root MSE)**                  | Erro médio na *mesma unidade do target*                     | `np.sqrt(MSE)`                                 | RMSE = **R$ 25.000** de erro médio                             |
| **MAE (Mean Absolute Error)**        | Erro médio real, sem quadrado                               | `mean_absolute_error(y_test, pred)`            | MAE = **R$ 15.000** (erro “normal” do modelo)                  |
| **MAPE (%)**                         | Erro em porcentagem                                         | `mean_absolute_percentage_error(y_test, pred)` | MAPE = **12%** → modelo erra 12% do valor                      |
| **RMSLE**                            | Reduz impacto de valores muito altos (log)                  | `mean_squared_log_error()`                     | Ideal para valores com grande variação (ex: preços 200k vs 2M) |
| **Bias**                             | Tendência do modelo a superestimar/subestimar               | `y_test.mean() - pred.mean()`                  | Se Bias = +10.000 → modelo está **superestimando** preços      |
| **Resíduos**                         | Diferença ponto a ponto (real − previsto)                   | `residuals = y_test - pred`                    | Residual = +8.000 → modelo errou para baixo                    |
| **Normalidade dos Resíduos**         | Verifica se o modelo linear é adequado                      | Plot: `sns.histplot(residuals)`                | Se os resíduos formam sino → modelo adequado                   |
| **Homoscedasticidade**               | Verifica se variância do erro é constante                   | Scatter: pred vs resíduos                      | Se o gráfico “abre” → erro cresce com o valor (ruim)           |
| **VIF (Variance Inflation Factor)**  | Detecta multicolinearidade                                  | `variance_inflation_factor()`                  | VIF > 5 → variáveis repetem a mesma informação                 |
| **Durbin-Watson**                    | Detecta autocorrelação dos resíduos                         | statsmodels: `results.durbin_watson`           | DW perto de 2 = sem autocorrelação                             |

**Configuração típica:**
```python
from sklearn.linear_model import LinearRegression
model = LinearRegression()
model.fit(X_train, y_train)  # Aprende coeficientes
pred = model.predict(X_test) # Prediz novos
```

**Como ajuda:** Prever demanda, otimizar preços, planejar estoque.

***

## 3. CLUSTERIZAÇÃO (**NÃO SUPERVISIONADO**)

### **O que é e Para que Serve**
**Clusterização** agrupa dados **sem rótulos** por similaridade natural. Descobre padrões ocultos.

**Aprendizado Não-Supervisionado:**
1. Sem target definido
2. Algoritmo encontra grupos automaticamente
3. Útil para exploração/segmentação

**Nas atividades:** Segmentação clientes, detecção anomalias. Dataset sem coluna target.

### **K-Means - Como Funciona**
```
Dataset: clientes.csv [idade, renda, compras]
1. Escolhe k=3 clusters
2. Inicializa 3 centróides aleatórios
3. Cada cliente → cluster mais próximo
4. Recalcula centróides (média)
5. Repete até estabilizar
```

| **Parâmetro** | **Serve Para** | **Configuração Atividades** | **Validação** |
|---------------|----------------|----------------------------|---------------|
| `n_clusters=k` | Quantos grupos | Cotovelo (k=3-5) | **CRÍTICO** |
| `init='k-means++'` | Melhores centróides iniciais | Sempre usar | Evita mínimos locais |
| `max_iter=300` | Limite iterações | Padrão OK | Se não converge, aumentar |
| `random_state=42` | Reprodutibilidade | Sempre usar | Resultados consistentes |

**Configuração típica:**
```python
from sklearn.cluster import KMeans
kmeans = KMeans(n_clusters=3, random_state=42)
clusters = kmeans.fit_predict(df)  # Gera grupos 0,1,2
```

**Silhueta nas atividades:** `silhouette_score(df, clusters)` > 0.5 = bom agrupamento.

**Como ajuda:** Segmentar clientes (jovem/rica, idoso/pobre), detectar fraudes (outliers).

***

## 4. CLASSIFICAÇÃO (**SUPERVISIONADO**)

### **O que é e Para que Serve**
**Classificação** prediz **categorias** (sim/não, spam/ham). Usa dados **com rótulos** para aprender regras de decisão.

**Aprendizado Supervisionado:**
1. Treina com (features, classe)
2. Aprende fronteiras de decisão
3. Classifica novos dados

**Nas atividades:** Churn, spam, aprovação crédito. Dataset tem target categórico.

### **Algoritmos Mais Usados**

| **Algoritmo** | **Aprendizado** | **Nas Atividades** | **Configuração Típica** |
|---------------|-----------------|-------------------|-------------------------|
| **Random Forest** | Ensemble árvores | **MAIS USADO** | `n_estimators=100, max_depth=10` |
| **Árvore Decisão** | Regras if-then | Interpretabilidade | `max_depth=5, min_samples_leaf=10` |
| **SVM** | Hiperplano ótimo | Dados pequenos | `C=1.0, kernel='rbf'` |
| **k-NN** | Vizinhos próximos | Prototipagem | `n_neighbors=5` |

**Random Forest nas atividades:**
```python
from sklearn.ensemble import RandomForestClassifier
rf = RandomForestClassifier(n_estimators=100, random_state=42)
rf.fit(X_train, y_train)  # y_train = [0,1,0,1...]
pred = rf.predict(X_test)
```

**Feature Importance:** `rf.feature_importances_` mostra quais variáveis importam mais.

**Como ajuda:** Prever quem vai cancelar, detectar spam, aprovar crédito automaticamente.

***

## 5. MÉTRICAS DE AVALIAÇÃO

### **O que é e Para que Serve**
**Métricas** quantificam se modelo funciona. Diferentes problemas → diferentes métricas.

**Nas atividades:** **Sempre** usa matriz confusão + F1/AUC para classificação, RMSE/R² para regressão.

### **Matriz de Confusão - Classificação Binária**
```
Exemplo real das atividades: Prever churn (1=cancela, 0=fica)
                Predito 1    Predito 0
Real 1 (Churn)    150(TP)      20(FN)
Real 0 (Fica)     15(FP)     9815(TN)
```

| **Métrica** | **Fórmula** | **Nas Atividades** | **Interpretação** |
|-------------|-------------|-------------------|-------------------|
| **Precisão** | TP/(TP+FP) | `precision_score(y_test, pred)` | 150/165=91% (confiável quando diz churn) |
| **Recall** | TP/(TP+FN) | `recall_score(y_test, pred)` | 150/170=88% (pega 88% dos churn reais) |
| **F1** | 2PR/(P+R) | `f1_score(y_test, pred)` | 0.89 (balanceado) |
| **AUC** | Área ROC | `roc_auc_score(y_test, prob)` | 0.92 (excelente ranking) |

**Configuração típica:**
```python
from sklearn.metrics import classification_report
print(classification_report(y_test, pred))
```

**Para Regressão nas atividades:**
```python
from sklearn.metrics import mean_squared_error, r2_score
rmse = np.sqrt(mean_squared_error(y_test, pred))
r2 = r2_score(y_test, pred)
```

**Como ajuda:** Escolher melhor modelo, comunicar performance para negócio.

***

## 6. AUTOML (**SUPERVISIONADO/NÃO SUPERVISIONADO**)

### **O que é e Para que Serve**
**AutoML** automatiza **todo pipeline ML**. Testa algoritmos, hiperparâmetros, features automaticamente.

**Nas atividades:** Usado para **baseline rápido** antes de modelagem manual.

### **Pipeline Automático**
```
1. Dá dataset → AutoML faz:
   - Limpa NaN/outliers
   - Testa 20+ algoritmos
   - Otimiza hiperparâmetros
   - Faz ensemble
2. Retorna: Melhor modelo + score
```

| **Ferramenta** | **Nas Atividades** | **Configuração** | **Tempo** |
|----------------|-------------------|------------------|-----------|
| **TPOT** | Gera código Python | `tpot = TPOTClassifier(generations=5)` | 30min |
| **H2O** | Enterprise | `h2o.automl(max_models=20)` | 15min |
| **AutoGluon** | **Tabular rápido** | `predictor = TabularPredictor().fit(train)` | 5min |

**Exemplo prático:**
```python
from autogluon.tabular import TabularPredictor
predictor = TabularPredictor(label='target').fit(train_data)
pred = predictor.predict(test_data)
```

**Como ajuda:** Economiza **dias** de trabalho, encontra modelos que você não conhecia.

***

## 7. REGRAS DE ASSOCIAÇÃO (**NÃO SUPERVISIONADO**)

### **O que é e Para que Serve**
Descobre **relacionamentos entre itens** em transações. "Se compra X, compra Y".

**Nas atividades:** Análise cestas de compra, recomendações.

### **Market Basket Analysis**
```
Dataset: transacoes.csv
Transação 1: [pao, leite, manteiga]
Transação 2: [pao, leite]
→ Regra: {pao,leite} → {manteiga}
```

| **Métrica** | **Exemplo Real** | **Nas Atividades** | **Decisão** |
|-------------|------------------|-------------------|-------------|
| **Suporte=0.05** | 5% transações | `min_support=0.01` | Frequente o suficiente |
| **Confiança=0.80** | 80% precisão | `min_confidence=0.5` | **Muito confiável** |
| **Lift=2.5** | 2.5x mais provável | `min_lift=1.2` | **Forte relação** |

**Configuração típica:**
```python
from mlxtend.frequent_patterns import apriori, association_rules
freq_items = apriori(df, min_support=0.01)
rules = association_rules(freq_items, min_confidence=0.5)
```

**Como ajuda:** Cross-sell ("comprou pão+leite? Leve manteiga!"), layout loja.

***

## 8. VALIDAÇÃO CRUZADA (**TODOS TIPOS**)

### **O que é e Para que Serve**
**K-Fold CV** testa modelo em **múltiplas divisões** para performance realista.

**Nas atividades:** **OBRIGATÓRIO** antes de confiar em resultado.

```
k=5 → Divide em 5 partes
Treina 4, testa 1 → Repete 5x
Score final: média ± desvio
Ex: 0.82 ± 0.03 = confiável
```

**Configuração:**
```python
from sklearn.model_selection import cross_val_score
scores = cross_val_score(model, X, y, cv=5, scoring='f1')
print(f"{scores.mean():.3f} ± {scores.std():.3f}")
```

***

## **CHECKLIST FINAL - PROVA A2**

### **Fluxo Completo (Sempre fazer nessa ordem)**
```
1. EXPLORAR: df.info(), df.describe(), df.isnull().sum()
2. LIMPAR: df.dropna(), df.fillna(), outliers
3. PREPARAR: StandardScaler(), OneHotEncoder()
4. DIVIDIR: train_test_split(test_size=0.3)
5. MODELAR: KMeans(), RandomForest(), etc.
6. VALIDAR: cross_val_score(cv=5)
7. AVALIAR: classification_report(), RMSE, silhouette
8. INTERPRETAR: feature_importance, regras lift>1.2
```

### **Configurações Padrão - Copie e Cole**
```python
# Regressão
LinearRegression().fit(X_train, y_train)

# Classificação
RandomForestClassifier(n_estimators=100, random_state=42)

# Clustering
KMeans(n_clusters=3, random_state=42)

# Validação
cross_val_score(model, X, y, cv=5, scoring='f1')
```

**Boa sorte na prova! Esta é a estrutura **exata** usada nas atividades.**[1][2][3][4][5]

[1](https://revistas.ufpr.br/atoz/article/download/41340/25333)
[2](https://learn.microsoft.com/pt-br/analysis-services/data-mining/mining-model-content-for-linear-regression-models-analysis-services-data-mining?view=asallproducts-allversions)
[3](https://www.datacamp.com/pt/tutorial/hierarchical-clustering)
[4](https://mariofilho.com/precisao-recall-e-f1-score-em-machine-learning/)
[5](https://developers.google.com/machine-learning/crash-course/classification/accuracy-precision-recall?hl=pt-br)

# O que é AutoML?

**AutoML (Automated Machine Learning)** é o processo de **automatizar todo o pipeline de machine learning**, desde a preparação dos dados até a criação do modelo final pronto para produção. Em vez de cientistas de dados passarem dias testando algoritmos manualmente, o AutoML testa centenas de combinações automaticamente e retorna o **melhor modelo**.[1][2]

**Para que serve:**  
- Democratizar ML para não-especialistas (analistas, gerentes).  
- Criar baselines rápidos para especialistas.  
- Encontrar combinações que humanos não testariam.  
- Reduzir tempo de semanas para horas.

**Nas atividades práticas:** Usado como **primeiro passo** para entender o potencial dos dados antes de modelagem manual detalhada.

***

## Como o Aprendizado Acontece no AutoML?

AutoML é **híbrido** (supervisionado/não-supervisionado dependendo do problema):

1. **Recebe dataset** com target (supervisionado) ou sem (não-supervisionado).  
2. **Testa automaticamente** 20-100+ algoritmos + hiperparâmetros em paralelo.  
3. **Avalia** com cross-validation e métricas apropriadas.  
4. **Seleciona** o melhor pipeline completo (pré-processamento + modelo + ensemble).  
5. **Retorna** modelo pronto + leaderboard de performance.

**Aprendizado Automático:** Usa meta-aprendizado (aprende de datasets anteriores) + otimização bayesiana para escolher próximas configurações.

***

## Pipeline Automatizado do AutoML

AutoML cobre **todas as etapas manuais**:

| **Etapa** | **O que Automatiza** | **Nas Atividades** | **Benefício** |
|-----------|---------------------|-------------------|---------------|
| **Pré-processamento** | NaN, encoding, scaling, outliers | `fillna()`, `OneHotEncoder()`, `StandardScaler()` | **Evita data leakage** |
| **Feature Engineering** | Cria novas features, remove irrelevantes | PCA, feature selection automática | Melhora performance 20-30% |
| **Algoritmo** | Testa 20+ modelos | RF, XGBoost, SVM, LightGBM, etc. | Encontra o melhor |
| **Hiperparâmetros** | GridSearch + Bayesian Opt | `n_estimators`, `max_depth`, `C`, etc. | Otimização automática |
| **Ensemble** | Stacking/Voting | Combina top 3-5 modelos | +5-10% performance |
| **Validação** | K-fold CV automática | `cv=5`, métricas F1/AUC/RMSE | Resultados confiáveis |

***

## Principais Ferramentas de AutoML

### **AutoGluon (Mais Usado nas Atividades)**
**Descrição:** Amazon, focado em dados tabulares. **Extremamente rápido** (5-10min).

**Configuração típica:**
```python
from autogluon.tabular import TabularPredictor
predictor = TabularPredictor(label='target').fit(train_data)
pred = predictor.predict(test_data)
leaderboard = predictor.leaderboard(test_data)  # Top modelos
```

| **Parâmetro** | **Serve Para** | **Configuração Atividades** |
|---------------|----------------|----------------------------|
| `label` | Coluna target | 'churn', 'preco', etc. |
| `time_limit` | Tempo máximo | 600s (10min) |
| `presets` | Modo | 'best_quality' ou 'medium_quality' |
| `eval_metric` | Métrica | 'f1', 'rmse', 'auc' |

**Vantagem nas atividades:** Dataset → leaderboard em 5min.

### **TPOT (Tree-based Pipeline Optimization Tool)**
**Descrição:** Usa programação genética para evoluir pipelines. Gera **código Python exportável**.

**Configuração:**
```python
from tpot import TPOTClassifier
tpot = TPOTClassifier(generations=5, population_size=20, verbosity=2)
tpot.fit(X_train, y_train)
tpot.export('melhor_pipeline.py')  # Código pronto!
```

### **H2O AutoML**
**Descrição:** Enterprise, escalável, interface web.

```python
import h2o
from h2o.automl import H2OAutoML
h2o.init()
train = h2o.import_file("train.csv")
aml = H2OAutoML(max_models=20, seed=1)
aml.train(x=features, y=target, training_frame=train)
```

***

## Configuração Típica nas Atividades

**Dataset exemplo:** `clientes.csv` [idade, renda, compras] → [churn]

```python
# 1. Preparar dados
train_data = pd.read_csv('clientes.csv')

# 2. AutoML (AutoGluon - 5 minutos)
from autogluon.tabular import TabularPredictor
predictor = TabularPredictor(label='churn', eval_metric='f1').fit(
    train_data, time_limit=600  # 10 minutos máximo
)

# 3. Resultados
results = predictor.leaderboard(train_data, silent=True)
print(results.head())
```

**Saída típica:**
```
model  score_val  score_test  pred_time_val
0  WeightedEnsemble_L2  0.847       0.842        0.023s
1  LightGBM_BAG_L1     0.835       0.831        0.015s
2  RandomForest_Entree 0.821       0.818        0.045s
```

***

## Interpretação dos Resultados AutoML

| **Indicador** | **O que Significa** | **Nas Atividades** | **Ação** |
|---------------|--------------------|-------------------|----------|
| **Score > 0.85** | Excelente para dados tabulares | F1=0.87 churn | **Produção** |
| **Score 0.70-0.85** | Bom baseline | RMSE=0.12 preco | Otimizar manual |
| **Score < 0.70** | Dados ruins ou problema difícil | Silhueta=0.3 | **Investigar dados** |
| **WeightedEnsemble** | Combinação top modelos | Sempre top 1 | **Mais confiável** |
| **pred_time baixo** | Rápido em produção | <0.05s | OK produção |

**Feature Importance automática:**
```python
predictor.feature_importance(test_data)
# idade: 0.35, renda: 0.28, compras: 0.22
```

***

## Vantagens e Limitações nas Atividades

| **Vantagem** | **Impacto Prático** | **Limitação** | **Solução** |
|--------------|--------------------|---------------|-------------|
| **Rápido** | 5min vs 2 dias | Dados muito grandes | `time_limit=1200` |
| **Baseline** | Comparar manual | Caixa-preta | Exportar pipeline |
| **Otimizado** | +15% vs manual | Não entende domínio | Interpretar features |
| **Acessível** | Não-especialistas | Dados sujos | Pré-limpeza básica |

***

## Checklist AutoML para Prova 

### **Antes de Rodar**
- [ ] Dataset limpo básico (sem NaN extremos)
- [ ] Target definido corretamente
- [ ] Métrica escolhida (F1 para desbalanceado, RMSE para regressão)

### **Durante Execução**
```
AutoGluon: 5-10min → Leaderboard pronto
TPOT: 20-60min → Código exportável
H2O: 15min → Interface web
```

### **Após Resultados**
- [ ] Score > 0.75? → Bom baseline
- [ ] Feature importance faz sentido?
- [ ] Ensemble no top 1-3? → Confiar
- [ ] Exportar pipeline para produção

***

## Resumo da Aplicação Prática

| **Aspecto** | **Detalhes AutoML** |
|-------------|---------------------|
| **Tipo Aprendizado** | Supervisionado (com target) |
| **Tempo típico** | 5-30 minutos |
| **Melhoria vs Manual** | +10-20% performance |
| **Saída** | Modelo pronto + leaderboard + feature importance |
| **Uso nas atividades** | **Primeiro passo** → Manual fine-tuning |
| **Ferramenta recomendada** | **AutoGluon** (mais rápida tabulares) |

**Como ajuda na prova:** AutoML é a **forma mais rápida** de mostrar domínio dos dados e obter baseline confiável para discutir interpretação e melhorias.[2][3][1]

***

[1](https://learn.microsoft.com/pt-br/dotnet/machine-learning/automated-machine-learning-mlnet)
[2](https://learn.microsoft.com/pt-br/azure/machine-learning/concept-automated-ml?view=azureml-api-2)
[3](https://www.ultralytics.com/pt/glossary/automated-machine-learning-automl)
[4](https://blog.dsbrigade.com/introducao-a-automl/)
[5](https://www.ibm.com/br-pt/think/topics/automl)
[6](https://www.eldorado.org.br/blog/o-que-e-automl-e-quais-sao-as-suas-vantagens/)
[7](https://www.fiveacts.com.br/automl-entenda-suas-vantagens)
[8](https://cloud.google.com/vertex-ai/docs/beginner/beginners-guide?hl=pt-br)
[9](https://docs.databricks.com/aws/pt/machine-learning/automl)
[10](https://www.youtube.com/watch?v=UyAp2L31aLU)
[11](https://periodicos.fclar.unesp.br/casa/article/view/18634)
[12](https://revistades.jur.puc-rio.br/index.php/revistades/article/view/215)
[13](https://www.semanticscholar.org/paper/814b033b9f5b8a1b20f8d762f9fd35973e1f8a44)
[14](https://www.semanticscholar.org/paper/e2f5412fe0792c3c2573efc7807ca8fb28111d)
[15](http://www.iec.pa.gov.br/template_doi_ess.php?doi=10.5123/S1679-49742016000100023&scielo=S2237-96222016000100205)
[16](https://www.bjrs.org.br/revista/index.php/REVISTA/article/view/1208)
[17](http://www.bibliotekevirtual.org/index.php/2013-02-07-03-02-35/2013-02-07-03-03-11/1748-reit-imed/v02n01/18365-computacao-ubiqua-definicao-e-exemplos.html)
[18](https://periodicos.utfpr.edu.br/recit/article/view/4330)
[19](https://revistas.ufrj.br/index.php/rce/article/view/3454)
[20](http://www.scielo.br/scielo.php?script=sci_arttext&pid=S1806-11172024000100464&tlng=pt)
[21](http://arxiv.org/pdf/2410.09596.pdf)
[22](https://arxiv.org/pdf/1810.13306.pdf)
[23](https://arxiv.org/pdf/2308.15647.pdf)
[24](http://arxiv.org/pdf/1811.03822.pdf)
[25](https://arxiv.org/pdf/2003.03384.pdf)
[26](http://arxiv.org/pdf/2111.05850v3.pdf)
[27](https://arxiv.org/pdf/2008.08516.pdf)
[28](https://pmc.ncbi.nlm.nih.gov/articles/PMC10603560/)

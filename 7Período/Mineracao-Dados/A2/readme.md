# Documentação Mineração de Dados - Prova A2

***

## 1. PROCESSO KDD - FLUXO COMPLETO

| **Etapa** | **Objetivo** | **Técnicas Principais** |
|-----------|--------------|-------------------------|
| **Seleção** | Escolher dados relevantes | Filtragem por domínio, amostragem |
| **Pré-processamento** | Limpar dados brutos | Remover duplicatas, tratar NaN, outliers |
| **Transformação** | Preparar para algoritmos | Normalização, one-hot encoding, feature engineering |
| **Mineração** | Extrair padrões | Regressão, Classificação, Clustering, Associação |
| **Avaliação** | Validar resultados | Métricas, cross-validation, interpretação |

***

## 2. REGRESSÃO

### **Conceito Base**
Prediz **valores contínuos** (preço, temperatura, quantidade)

**Equação Fundamental:**
```
y = β₀ + β₁x₁ + β₂x₂ + ... + ε
```

### **Parâmetros e Interpretação**

| **Parâmetro** | **Significado** | **Interpretação** |
|---------------|-----------------|-------------------|
| **β₀ (Intercepto)** | Valor base | Preço quando todas X=0 |
| **β₁ (Coeficiente)** | Impacto da variável | +$150 por m² adicional |
| **R²** | Variância explicada | 0.85 = 85% explicada |
| **Adjusted R²** | Penaliza variáveis extras | Prefira sempre ao R² |

### **Métricas de Avaliação**

| **Métrica** | **Fórmula** | **Quando Usar** | **Bom (>)** |
|-------------|-------------|-----------------|-------------|
| **RMSE** | √[Σ(y-ŷ)²/n] | Penaliza erros grandes | Depende da escala |
| **MAE** | Σ\|y-ŷ\|/n | Robusto a outliers | Depende da escala |
| **R²** | 1-[SS_res/SS_tot] | Proporção explicada | 0.70 |

### **Assunções Críticas (Verificar Sempre!)**
1. **Linearidade**: Gráfico resíduos vs preditos sem padrão
2. **Homocedasticidade**: Variância constante dos resíduos
3. **Normalidade**: Q-Q plot dos resíduos
4. **Não multicolinearidade**: VIF < 5

***

## 3. CLUSTERIZAÇÃO

### **Conceito Base**
Agrupa dados **sem rótulos** por similaridade

### **K-Means - Parâmetros Essenciais**

| **Parâmetro** | **Valor Típico** | **Impacto** |
|---------------|------------------|-------------|
| `n_clusters (k)` | Cotovelo/Silhueta | ❌ Crítico! |
| `init` | 'k-means++' | Melhor inicialização |
| `max_iter` | 300 | Limite iterações |
| `n_init` | 10 | Rodadas diferentes |

### **Escolha de K - Métodos**

| **Método** | **Como Funciona** | **Critério** |
|------------|-------------------|--------------|
| **Cotovelo** | Inércia vs k | Mudança de inclinação |
| **Silhueta** | Coesão vs separação | Máximo (>0.5 bom) |
| **BIC/AIC** | Penaliza complexidade | Menor valor |

### **Validação de Clusters**

| **Métrica** | **Intervalo** | **Bom** |
|-------------|---------------|---------|
| **Silhueta** | -1 a +1 | > 0.5 |
| **Davies-Bouldin** | 0 a ∞ | < 1.0 |
| **Calinski-Harabasz** | 0 a ∞ | Maior |

***

## 4. CLASSIFICAÇÃO

### **Conceito Base**
Prediz **categorias discretas** (sim/não, spam/ham)

### **Algoritmos - Comparação**

| **Algoritmo** | **Vantagens** | **Desvantagens** | **Parâmetros Chave** |
|---------------|---------------|------------------|---------------------|
| **Árvore Decisão** | Interpretável | Overfitting | max_depth, min_samples_split |
| **Random Forest** | Robusto | Menos interpretável | n_estimators=100, max_features='sqrt' |
| **SVM** | Alta dimensionalidade | Lento grandes dados | C=1.0, kernel='rbf', gamma='scale' |
| **Naive Bayes** | Rápido | Assunção naive | - |
| **k-NN** | Simples | Lento predição | k=5, metric='euclidean' |

### **Random Forest - Configuração Típica**
```python
RandomForestClassifier(
    n_estimators=100,      # Árvores
    max_depth=10,          # Evita overfitting
    min_samples_split=20,  # Nó mínimo
    max_features='sqrt'    # Features por nó
)
```

***

## 5. MATRIZ DE CONFUSÃO E MÉTRICAS

### **Matriz Binária**

| **Predito ↓ / Real →** | **Positivo** | **Negativo** |
|-------------------------|--------------|--------------|
| **Positivo** | **TP** | **FP** |
| **Negativo** | **FN** | **TN** |

### **Métricas Essenciais**

| **Métrica** | **Fórmula** | **Foco** | **Quando Usar** |
|-------------|-------------|----------|-----------------|
| **Acurácia** | (TP+TN)/Total | Geral | Dados balanceados |
| **Precisão** | TP/(TP+FP) | Falsos Positivos | FP custoso |
| **Recall** | TP/(TP+FN) | Falsos Negativos | FN custoso |
| **F1-Score** | 2×(P×R)/(P+R) | Balanceado | Desbalanceados |
| **AUC-ROC** | Área sob curva | Ranking | Probabilidades |

### **Interpretação Rápida**
```
Acurácia 95%, mas F1 0.6 → Dados desbalanceados!
Precisão 90%, Recall 30% → Muitos FN (perde positivos)
```

***

## 6. AUTOML

### **Pipeline Automatizado**

| **Etapa** | **Automação** | **Ferramentas** |
|-----------|---------------|-----------------|
| Pré-processamento | NaN, encoding, scaling | TPOT, H2O |
| Feature Selection | Remove irrelevantes | Auto-sklearn |
| Algoritmo | Testa múltiplos | AutoGluon |
| Hiperparâmetros | Grid/Random/Bayesian | PyCaret |
| Ensemble | Stacking/Voting | Todas |

### **Ferramentas - Comparação**

| **Ferramenta** | **Destaque** | **Linguagem** | **Tempo** |
|----------------|--------------|---------------|-----------|
| **TPOT** | Gera código | Python | Médio |
| **H2O** | Enterprise | R/Python/Java | Rápido |
| **AutoGluon** | Tabular | Python | Muito rápido |
| **PyCaret** | Low-code | Python | Rápido |

***

## 7. REGRAS DE ASSOCIAÇÃO

### **Métricas Fundamentais**

| **Métrica** | **Fórmula** | **Interpretação** | **Bom (>)** |
|-------------|-------------|-------------------|-------------|
| **Suporte** | P(X∪Y) | Frequência | 0.01 (1%) |
| **Confiança** | P(Y\|X) | Precisão | 0.50 (50%) |
| **Lift** | conf/sup(Y) | Força relação | > 1.0 |
| **Conviction** | [1-sup(Y)]/[1-conf] | Implicação | > 1.0 |

### **Apriori - Parâmetros**

| **Parâmetro** | **Típico** | **Efeito** |
|---------------|------------|------------|
| `min_support` | 0.01 | Filtra raras |
| `min_confidence` | 0.5 | Filtra fracas |
| `min_lift` | 1.0 | Só positivas |

**Exemplo Prático:**
```
{Chips, Refrigerante} → {Salsa}
sup=0.04, conf=0.80, lift=2.5
→ Colocar salsa perto de chips!
```

***

## 8. VALIDAÇÃO E DIAGNÓSTICO

### **Cross-Validation K-Fold**

```
k=5 → 5 divisões
Score final = média ± desvio padrão
Exemplo: 0.82 ± 0.03
```

### **Diagnóstico Modelos**

| **Treino** | **Teste** | **Gap** | **Diagnóstico** | **Solução** |
|------------|-----------|---------|-----------------|-------------|
| 95% | 70% | 25% | **Overfitting** | Regularização, ↓complexidade |
| 75% | 73% | 2% | **Normal** | ✅ OK |
| 50% | 52% | 2% | **Underfitting** | ↑complexidade, +features |

***

## 9. CHECKLIST PROVA A2

### **Antes de Treinar**
- [ ] Dados explorados? (shape, NaN, distribuição)
- [ ] Pré-processamento correto? (sem data leakage)
- [ ] Treino/teste divididos? (70/30 ou CV)

### **Durante Treinamento**
- [ ] Métrica apropriada? (F1 se desbalanceado)
- [ ] Cross-validation usada?
- [ ] Hiperparâmetros otimizados?
- [ ] Overfitting verificado?

### **Interpretação Final**
```
✅ Acurácia: 82% [web:39]
✅ F1: 0.78 → Balanceado [web:78]
✅ Recall: 75% → Não perde muitos positivos [web:81]
✅ Features importantes: Renda(35%), Idade(22%) [web:51]
```

**Ação de Negócio:** Contatar clientes de alto risco baseado em renda baixa + idade avançada.

***

**Documentação otimizada para prova: Tabelas rápidas, parâmetros essenciais, interpretação prática e citações diretas das métricas principais.**[1][2][3][4][5][6][7]

[1](https://revistas.ufpr.br/atoz/article/download/41340/25333)
[2](https://learn.microsoft.com/pt-br/analysis-services/data-mining/mining-model-content-for-linear-regression-models-analysis-services-data-mining?view=asallproducts-allversions)
[3](https://www.datacamp.com/pt/tutorial/hierarchical-clustering)
[4](https://www.ibm.com/br-pt/think/topics/random-forest)
[5](https://mariofilho.com/precisao-recall-e-f1-score-em-machine-learning/)
[6](https://developers.google.com/machine-learning/crash-course/classification/accuracy-precision-recall?hl=pt-br)
[7](https://docs.h2o.ai/h2o/latest-stable/h2o-docs/automl.html)

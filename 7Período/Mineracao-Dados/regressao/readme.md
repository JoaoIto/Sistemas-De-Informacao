# O que é Regressão?

A regressão é uma técnica de aprendizagem **supervisionada** usada para prever valores **contínuos** (numéricos) com base em um ou mais atributos preditores. Por exemplo, estimar o preço de uma casa a partir da metragem ou prever a demanda de um produto segundo o investimento em marketing.

**Para que serve:**  
- Modelar e entender a relação entre variáveis.  
- Prever novos valores para variáveis quantitativas.  
- Identificar a importância relativa dos preditores.

Nas atividades de mineração de dados, usa-se regressão para análise de dados tabulares onde o objetivo é uma variável numérica (target).

***

## Como Funciona o Aprendizado na Regressão?

1. Treina com dados rotulados, ou seja, entradas (features) e saída (target numérico).  
2. O algoritmo estima coeficientes \( \beta \) na equação que melhor prediz a saída minimizando o erro.  
3. Geralmente utiliza o **método dos mínimos quadrados** para minimizar a soma dos resíduos ao quadrado \(\sum_i (y_i - \hat{y_i})^2\).  
4. Após o treino, o modelo pode prever valores para dados novos.  

***

## Modelos Principais de Regressão

### Regressão Linear Simples

Relaciona uma variável dependente \( y \) a um único preditor \( x \):

\[
y = \beta_0 + \beta_1 x + \varepsilon
\]

- \(\beta_0\): intercepto (valor base quando \(x=0\))  
- \(\beta_1\): coeficiente angular (taxa de variação de \(y\) por unidade de \(x\))  
- \(\varepsilon\): termo de erro aleatório

### Regressão Linear Múltipla

Extensão para múltiplos preditores \( x_1, x_2, ..., x_p \):

\[
y = \beta_0 + \beta_1 x_1 + \beta_2 x_2 + \cdots + \beta_p x_p + \varepsilon
\]

Permite capturar influências combinadas de variáveis.

***

## Parâmetros e Métricas Importantes

| Parâmetro                  | O que Indica                                  | Exemplo de Uso nas Atividades                                     |
|----------------------------|----------------------------------------------|------------------------------------------------------------------|
| \(\beta_i\) (coeficiente)  | Impacto da variável independente \(x_i\)    | \(\beta_1 = 1500\): R$1500 por metro quadrado no preço da casa  |
| \(\beta_0\) (intercepto)   | Valor esperado quando todos \(x_i = 0\)     | Caso básico, preço base do imóvel sem considerar outras variáveis|
| **R² (Coeficiente de determinação)**  | Percentual da variância explicada pelo modelo | R² = 0,85 significa que 85% da variação do preço é explicada     |
| **RMSE (Root Mean Squared Error)**     | Erro médio quadrático na mesma unidade da variável alvo | RMSE = R$25.000 indica erro médio estimado no preço          |
| **MAE (Mean Absolute Error)**           | Erro médio absoluto, menos sensível a outliers | MAE = R$20.000                                                  |
| **p-valor dos coeficientes**            | Significância estatística do coeficiente       | P-valor < 0.05 indica relação significativa                     |

***

## Assunções do Modelo de Regressão

O modelo de regressão depende da observância dessas suposições para confiabilidade:

- **Linearidade:** Relação linear entre preditor e variável alvo.  
- **Independência dos resíduos:** Erros não são correlacionados.  
- **Homoscedasticidade:** Variância dos erros constante ao longo dos preditores.  
- **Normalidade dos resíduos:** Resíduos seguem distribuição normal.  
- **Não multicolinearidade entre preditores:** Variáveis não são altamente correlacionadas.

***

## Aplicação Prática nas Atividades

**Exemplo:** Prever preço de imóvel

```python
from sklearn.linear_model import LinearRegression
model = LinearRegression()
X = df[['tamanho', 'quartos', 'idade']]  # variáveis independentes
y = df['preco']                          # variável dependente

model.fit(X, y)     # ajusta os coeficientes
pred = model.predict(X)  # prediz preços

print("Coeficientes:", model.coef_)
print("Intercepto:", model.intercept_)
```

- Coeficientes indicam impacto de cada variável.  
- Avaliações com R² e RMSE indicam qualidade do ajuste.

***

## Como Interpretar Resultados de Regressão

Para interpretar um modelo:

- **Coeficientes:** Quanto a variável varia para cada unidade mudada em um preditor, mantendo os outros constantes.  
- **R² elevado:** Modelo explica boa parte da variação observada.  
- **RMSE baixo:** Pequenos erros médios no valor previsto.  
- **P-valores pequenos:** Coeficientes são estatisticamente confiáveis.  
- **Gráficos de resíduos:** Verificar supostos para validação.

***

## Resumo de Passos para uso efetivo

1. Explorar dados para entender as variáveis.  
2. Preparar dados: tratar NaN, normalizar se necessário.  
3. Ajustar regressão com pacote como `scikit-learn` ou `statsmodels`.  
4. Avaliar métricas de erro e significância.  
5. Interpretar coeficientes e validar supostos.  
6. Usar para previsões ou análise de impacto.

***

## Benefícios da Regressão

- Fácil de entender e explicar (interpretabilidade alta).  
- Útil para prever quantidades reais (ex.: preços, vendas).  
- Base para modelos mais complexos.

**Limitações:** não lida bem com relações não lineares complexas sem transformações.

***

## Documentação Didática de Regressão com PyCaret para Prova A2

***

## PyCaret para Regressão - **Low-Code Automatizado**

**PyCaret** é uma biblioteca **low-code** que automatiza o pipeline completo de regressão, similar ao AutoML mas com mais controle e visualizações integradas. É **extremamente popular nas atividades** por sua simplicidade e interpretação visual.

**Para que serve PyCaret em Regressão:**
- Setup automático (pré-processamento, splitting, scaling)
- Compara **todos** os algoritmos de regressão automaticamente
- Métricas visuais e leaderboards instantâneos
- Otimização de hiperparâmetros com 1 linha
- Plotagens automáticas (resíduos, importância, etc.)

***

## Instalação e Setup Básico

```python
# Instalação
pip install pycaret[full]

# Importação
from pycaret.regression import *
```

***

## Fluxo Completo PyCaret - **5 Linhas Essenciais**

```python
# 1. SETUP (automático - 80% do trabalho)
setup(data=df, target='preco', train_size=0.7, session_id=42)

# 2. COMPARAR TODOS ALGORITMOS (1 linha)
best = compare_models()  # Leaderboard automático!

# 3. CRIAR MODELO MELHOR (1 linha)
lr = create_model('lr')  # Linear Regression

# 4. OTIMIZAR HIPERPARÂMETROS (1 linha)
tuned_lr = tune_model(lr)

# 5. FINALIZAR E PREVER
final_lr = finalize_model(tuned_lr)
predictions = predict_model(final_lr, data=test_df)
```

***

## **Métricas Usadas pelo PyCaret em Regressão**

PyCaret mostra **todas** as métricas principais automaticamente:

| **Métrica** | **Fórmula** | **O que Significa** | **Bom (>)** |
|-------------|-------------|-------------------|-------------|
| **R2** | 1 - (SS_res/SS_tot) | % variância explicada | **0.80** |
| **RMSE** | √[Σ(y-ŷ)²/n] | Erro quadrático (penaliza outliers) | **Menor** |
| **MAE** | Σ\|y-ŷ\|/n | Erro absoluto médio | **Menor** |
| **MAPE** | [Σ\|(y-ŷ)/y\|/n]×100 | % erro relativo | **<10%** |
| **RMSLE** | √[Σ(ln(y+1)-ln(ŷ+1))²/n] | Bom para skew dados | **Menor** |

**Exemplo de Leaderboard PyCaret:**
```
Model              MAE    RMSE    R2     MAPE
Linear Regression  12000  25000   0.85   8.2%
Random Forest      11500  24000   0.87   7.9%
XGBoost            11000  23500   0.88   7.5%  ← MELHOR
```

***

## Configuração Completa nas Atividades

**Dataset exemplo:** `imoveis.csv` [tamanho, quartos, idade] → [preco]

```python
import pandas as pd
from pycaret.regression import *

# 1. Carregar e preparar
df = pd.read_csv('imoveis.csv')

# 2. SETUP AUTOMÁTICO (CRÍTICO!)
setup(
    data=df, 
    target='preco',
    train_size=0.7,
    session_id=42,
    normalize=True,      # Scaling automático
    remove_outliers=True, # Remove outliers
    outliers_method='iforest'
)

# 3. COMPARAR 15+ ALGORITMOS
best_model = compare_models(sort='R2')  # Ordena por R2

# 4. Criar e tunar Linear Regression
lr = create_model('lr')
tuned_lr = tune_model(lr, optimize='R2')  # Otimiza R2

# 5. Plotagens automáticas
plot_model(tuned_lr, plot='residuals')    # Resíduos
plot_model(tuned_lr, plot='feature')      # Importância
plot_model(tuned_lr, plot='prediction_error')  # Erro vs Real

# 6. Finalizar modelo
final_model = finalize_model(tuned_lr)
save_model(final_model, 'melhor_regressao')
```

***

## **Interpretação das Saídas PyCaret**

### Leaderboard Automático
```
              MAE     RMSE      R2    RMSLE    MAPE
Linear         18.5k   25.2k   0.847  0.245    12.3
Tree           17.8k   24.8k   0.862  0.238    11.8
Random Forest  17.2k   24.1k   **0.875** 0.231  **11.2** ← ESCOLHER
```

**Interpretação:** Random Forest melhor R2 (87.5%) e menor erro.

### Feature Importance Automática
```python
plot_model(best_model, plot='feature')
```
```
tamanho: 45%  ← MAIS IMPORTANTE
quartos: 32%
idade:   23%
```

### Resíduos (Diagnóstico Automático)
```python
plot_model(best_model, plot='residuals')
```
- **Padrão aleatório** = suposições OK
- **Padrão em funil** = heteroscedasticidade
- **Tendência linear** = não linearidade

***

## **Parâmetros Automatizados pelo PyCaret**

| **Algoritmo** | **Parâmetros Otimizados Automaticamente** | **Nas Atividades** |
|---------------|------------------------------------------|-------------------|
| **Linear (lr)** | Sem (interpretação pura) | **BASELINE** |
| **Tree** | max_depth, min_samples_split | 8-12, 20-50 |
| **Random Forest** | n_estimators=100, max_depth=10 | **MAIS USADO** |
| **XGBoost** | n_estimators=100, learning_rate=0.1 | **MELHOR PERFORMANCE** |
| **LightGBM** | num_leaves=31, learning_rate=0.1 | Rápido + preciso |

***

## **Validação Cruzada Integrada**

PyCaret faz **CV automático** em todas comparações:

```python
# CV 10-fold automático
validate_model(lr)  # Validação visual

# Resultado típico:
# R2: 0.847 ± 0.023 (média ± desvio)
```

***

## **Checklist PyCaret Regressão - Prova A2**

### **Setup Perfeito (Copie isso)**
```python
setup(data=df, target='target_col', 
      train_size=0.7, 
      normalize=True,
      remove_outliers=True,
      session_id=42)
```

### **Fluxo 5 Minutos**
```
1. setup()
2. compare_models(sort='R2')
3. best = create_model('et')  # Extra Trees (geralmente top 3)
4. tuned = tune_model(best)
5. plot_model(tuned, 'residuals')
6. final = finalize_model(tuned)
```

### **Interpretação para Prova**
```
✅ R2=0.87 → Excelente para tabulares [web:192]
✅ RMSE=24k → Erro aceitável escala R$300k
✅ Features: tamanho(45%) domina
✅ Resíduos aleatórios → Suposições OK
```

***

## **Vantagens PyCaret vs Manual**

| **Aspecto** | **Manual** | **PyCaret** | **Ganho** |
|-------------|------------|-------------|-----------|
| Tempo | 2-4 horas | **5 minutos** | 95% menos |
| Algoritmos testados | 2-3 | **15+** | Completo |
| Hiperparâmetros | Manual | **Otimizado** | +10-15% |
| Diagnósticos | Manual | **Automático** | Visual |
| CV | Manual | **10-fold** | Confiável |

***

[1](https://www.semanticscholar.org/paper/df3e0e9b1adb0d5c10365a68ce8d692df9117377)
[2](https://revista.rbc.org.br/index.php/rbc/article/view/1002)
[3](https://www.revistas.usp.br/rdg/article/view/220489)
[4](https://revistavalorem.com/index.php/home/article/view/27)
[5](https://periodicos.newsciencepubl.com/arace/article/view/8657)
[6](https://reunir.revistas.ufcg.edu.br/index.php/uacc/article/view/1163)
[7](https://www.semanticscholar.org/paper/41d03e4c1de678aeba7ea7016f75df7f966df4ab)
[8](https://www.semanticscholar.org/paper/cf4913b3ff999f4dd65fd1efe67311046a4d01df)
[9](https://asaa.anpcont.org.br/index.php/asaa/article/view/453/pdf)
[10](https://www.semanticscholar.org/paper/b1b7ead60f59e38bb95e950ae0af8f3bf74bbc67)
[11](https://seer.ufrgs.br/index.php/hcpa/article/download/98944/pdf)
[12](https://www.scielo.br/j/rsp/a/zvsxwWrsDN7yXp5WjLpc9LD/?format=pdf&lang=pt)
[13](http://pdf.blucher.com.br/physicsproceedings/vi-efa/019.pdf)
[14](http://www.scielo.br/pdf/pab/v51n9/0100-204X-pab-51-09-1428.pdf)
[15](https://periodicos.utfpr.edu.br/rbqv/article/download/3026/2210)
[16](http://www.scielo.br/pdf/jvb/v16n2/en_1677-5449-jvb-16-2-88.pdf)
[17](https://www.revistatransportes.org.br/anpet/article/download/65/54)
[18](https://periodicos.ufpe.br/revistas/index.php/rbgfe/article/download/258146/46315)
[19](https://aws.amazon.com/pt/what-is/linear-regression/)
[20](https://www.ibm.com/br-pt/think/topics/linear-regression)

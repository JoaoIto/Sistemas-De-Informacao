# Dataset covid-19 sintético

Para o entendimento da atividade com uma árvore de decisão, focado, (não passado por etapas de pré-processamento, e limpeza de dados), então foi feita um dataset de covid 19
sobre o vírus, e assim decisões e sintomas com pacientes e informações como idade deles, para que assim possa ser estudado esse tópico.

Este material acompanha o notebook **Arvore_Decisao_COVID.ipynb** e foi feito para estudar **como gerar, podar e interpretar** árvores de decisão de forma **simples**.

## 1) Dataset usado
- **Origem**: dataset **sintético** criado para fins didáticos.
- **Tarefa**: classificar `resultado` (`positivo`/`negativo`) a partir de atributos categóricos:
  - `faixa_etaria` (`0-17`, `18-39`, `40-59`, `60+`)
  - `vacinado` (`sim`, `nao`)
  - `febre`, `tosse`, `dor_garganta`, `falta_ar`, `fadiga` (`sim`, `nao`)
  - `contato_confirmado` (`sim`, `nao`)
- **Tamanho**: 600 linhas. O rótulo é gerado por uma regra probabilística simples com ruído (para simular mundo real).
- Arquivo: `covid_sintomas_exemplo.csv` (gerado automaticamente se não existir).

## 2) Fluxo no notebook (explicação → código → explicação)
1. **Entendimento dos dados**: leitura do CSV, prévia, checagem rápida da distribuição do alvo e cruzamentos simples (ex.: `febre x resultado`).
2. **Preparação**: separação `X`/`y`; `train_test_split` (com `stratify`); `OneHotEncoder` em `Pipeline` (todas as colunas são categóricas).
3. **Árvore baseline (sem poda)**: treino e métricas (acurácia, matriz de confusão, relatório de classificação).
4. **Pré-poda**: limita complexidade desde o início (`max_depth=4`, `min_samples_leaf=10`). Compara desempenho e tamanho.
5. **Pós-poda (CART)**: busca do melhor `ccp_alpha` via *cost-complexity pruning path*. Seleciona a árvore com melhor desempenho no teste (didático).
6. **Visualização & Regras**: treina uma **árvore pequena** para leitura humana e imprime as **regras** com `export_text`.
7. **Comparação final**: “sem poda” vs “pré” vs “pós” e a **regra de ouro**: equilíbrio entre **simplicidade** e **poder de decisão**.

## 3) Comandos principais (resumo)
- Importação/Pré-processamento:
  ```python
  from sklearn.preprocessing import OneHotEncoder
  from sklearn.compose import ColumnTransformer
  pre = ColumnTransformer([("cat", OneHotEncoder(handle_unknown="ignore", sparse_output=False), cat_cols)])
  ```
- Treino (baseline):
  ```python
  from sklearn.tree import DecisionTreeClassifier
  base = Pipeline([("pre", pre), ("clf", DecisionTreeClassifier(random_state=42))]).fit(X_tr, y_tr)
  ```
- Pré-poda:
  ```python
  DecisionTreeClassifier(max_depth=4, min_samples_leaf=10, random_state=42)
  ```
- Pós-poda (CART):
  ```python
  path = DecisionTreeClassifier().cost_complexity_pruning_path(Xt, y_tr)
  ccp_alphas = path.ccp_alphas
  ```
- Visualização & regras:
  ```python
  plot_tree(modelo, feature_names=pre.get_feature_names_out(), class_names=modelo.classes_, filled=True)
  export_text(modelo, feature_names=list(pre.get_feature_names_out()))
  ```

## 4) Respostas / Insights esperados
- **Sinais fortes** para `positivo`: presença de `contato_confirmado=sim` combinada com sintomas como `febre`, `tosse` e `falta_ar`.  
- **Sinais de proteção**: `vacinado=sim` tende a reduzir probabilidade de `positivo` no dataset sintético.
- Árvores **pré-podadas** costumam ficar **curtas** e fáceis de explicar, com acurácia próxima da sem poda.
- **Pós-poda** remove ramos pouco úteis, podendo manter ou até melhorar desempenho de teste.

## 5) Interpretação da árvore (roteiro)
1. Leia o **nó raiz** (teste mais informativo).
2. Converta cada nível em regra **SE... ENTÃO...** em linguagem natural.
3. Compare ramos que levam a **`positivo`** vs **`negativo`** e destaque as condições-chave.
4. Comente a **profundidade** (quantos níveis) e **número de folhas** (complexidade).

## 6) Problema: “a árvore virou um único nó/folha” (como corrigir)
Isso pode acontecer quando:
- A parametrização está **restritiva** (ex.: `min_samples_leaf` alto, `max_depth` muito baixo, `ccp_alpha` alto).
- Os dados ficaram **quase aleatórios** para os splits escolhidos.
- Treinou um modelo muito **podado** e plotou ele.

**Soluções** (adotadas no notebook):
- Usar `max_depth=3` ou `4`, `min_samples_leaf=5` ou `10`, `ccp_alpha=0.0` na árvore de **visualização**.
- Garantir dados com informação (dataset sintético já ajuda).
- Se ainda vier só 1 nó, afrouxar `min_impurity_decrease` (por exemplo `1e-4`) ou reduzir `min_samples_leaf`.

## 7) O que apresentar ao professor
- A **lógica** de geração da árvore (critério, divisão top-down).
- O **porquê da poda** (evitar overfitting, deixar explicável).
- A **comparação** simples dos três cenários (sem, pré e pós-poda) e uma **árvore curta** com regras legíveis.
- Conclusão: **equilíbrio** entre interpretabilidade e poder preditivo.

---


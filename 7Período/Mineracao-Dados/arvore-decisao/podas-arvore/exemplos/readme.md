# README – Exercício Completo de Classificação com **Árvore de Decisão**

1) **Limpeza e pré-processamento**  
2) **Treino da árvore (baseline)**  
3) **Pré-poda e Pós-poda (CART)**  
4) **Avaliação e interpretação** (inclusive o que significa `gini`, `samples`, `value`, `class`).

---

## 0) Setup do ambiente

**Por quê?** Importar bibliotecas, garantir reprodutibilidade e deixar o gráfico pronto.

```python
import numpy as np, pandas as pd, matplotlib.pyplot as plt

from sklearn.model_selection import train_test_split
from sklearn.preprocessing import OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.pipeline import Pipeline
from sklearn.tree import DecisionTreeClassifier, plot_tree, export_text
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix

np.random.seed(42)
```

---

## 1) Carregar dados e entender o problema

**Por quê?** Validar o formato, tamanho e objetivo (coluna alvo).

```python
df = pd.read_csv("seu_dataset.csv")  # ajuste o caminho/nome
print("Tamanho:", df.shape)
df.head()
```

**Explicação:**  
- Verifique a coluna **alvo** (ex.: `resultado`).  
- Identifique colunas **categóricas** (objeto/string) e **numéricas** (int/float).  
- Confirme se as classes estão presentes e a proporção não é extremamente desbalanceada.

---

## 2) Limpeza rápida (qualidade dos dados)

**Por quê?** Evitar ruído básico que atrapalha a árvore.

```python
# 2.1) Padronizar nomes de colunas (opcional, melhora legibilidade)
df.columns = [c.strip().lower().replace(" ", "_") for c in df.columns]

# 2.2) Duplicatas
df = df.drop_duplicates()

# 2.3) Tipos e ausentes
print(df.dtypes)
na_por_col = df.isna().mean().sort_values(ascending=False)
print(na_por_col.head(10))

# 2.4) Remover linhas muito vazias (opcional), senão vamos imputar
# df = df.dropna(thresh=int(df.shape[1]*0.6))
```

**Explicação:**  
- **Duplicatas** distorcem contagens e regras.  
- **Ausentes** serão tratados no pré-processamento.  
- Em árvores, **não é necessário padronizar/normalizar numéricos** (a divisão é por limiar).

---

## 3) Separar `X`/`y` e preparar o **pré-processamento**

**Por quê?** Deixar a entrada pronta: codificar categóricas e, se houver, imputar valores ausentes.

```python
alvo = "resultado"  # ajuste para o nome da sua coluna alvo
X = df.drop(columns=[alvo])
y = df[alvo]

cat_cols = X.select_dtypes(include=["object", "category"]).columns.tolist()
num_cols = X.select_dtypes(include=["int64","float64"]).columns.tolist()

# OneHot para categóricas; (opcional) imputação simples
from sklearn.impute import SimpleImputer

pre = ColumnTransformer([
    ("num", Pipeline([
        ("imputer", SimpleImputer(strategy="median"))
    ]), num_cols),
    ("cat", Pipeline([
        ("imputer", SimpleImputer(strategy="most_frequent")),
        ("oh", OneHotEncoder(handle_unknown="ignore", sparse_output=False))
    ]), cat_cols),
], remainder="drop")

X_tr, X_te, y_tr, y_te = train_test_split(
    X, y, test_size=0.25, stratify=y, random_state=42
)
```

**Explicação:**  
- `SimpleImputer` garante que **ausentes** não quebrem o treino.  
- `OneHotEncoder(handle_unknown="ignore")` evita erro com **categorias novas** no teste.  
- Guardamos tudo em um **`ColumnTransformer`** para rodar **dentro do Pipeline**.

---

## 4) **Árvore baseline** (sem poda)

**Por quê?** Ter um **referencial** para comparar podas (desempenho x simplicidade).

```python
base = Pipeline([
    ("pre", pre),
    ("clf", DecisionTreeClassifier(random_state=42))  # sem restrições
])
base.fit(X_tr, y_tr)
pred = base.predict(X_te)

print("Acurácia (sem poda):", round(accuracy_score(y_te, pred), 3))
print("Matriz de confusão:\n", confusion_matrix(y_te, pred))
print(classification_report(y_te, pred, digits=3))
```

**Explicação:**  
- Árvores sem limites tendem a **sobreajustar**.  
- Use as métricas para **comparar** depois com as versões podadas.

---

## 5) **Pré-poda** (controlar a complexidade desde o início)

**Por quê?** Deixar a árvore **curta e explicável**.

```python
prepodada = Pipeline([
    ("pre", pre),
    ("clf", DecisionTreeClassifier(
        random_state=42,
        max_depth=4,          # controla profundidade
        min_samples_leaf=10,  # mínimo de amostras por folha
        max_leaf_nodes=None,  # opcional: limite de folhas
        min_impurity_decrease=0.0,  # critérios mais estritos => árvores menores
        ccp_alpha=0.0
    ))
])
prepodada.fit(X_tr, y_tr)
pred2 = prepodada.predict(X_te)

print("Acurácia (pré-poda):", round(accuracy_score(y_te, pred2), 3))
```

**Explicação (parâmetros úteis):**  
- `max_depth`: **máximo de níveis**.  
- `min_samples_leaf`: evita folhas com pouquíssimos exemplos.  
- `max_leaf_nodes`: **limite de folhas** (opcional).  
- `min_impurity_decrease`: exige melhora mínima de pureza para dividir.  
- Use valores pequenos-médios para **clareza** sem matar o desempenho.

---

## 6) **Pós-poda (CART)** com `ccp_alpha`

**Por quê?** Crescer tudo e **podar depois**, removendo ramos pouco úteis.

```python
# Ajustar pré-processamento separado para obter matrizes
pre_fitted = pre.fit(X_tr, y_tr)
Xt = pre_fitted.transform(X_tr)
Xv = pre_fitted.transform(X_te)

tree0 = DecisionTreeClassifier(random_state=42)
path = tree0.cost_complexity_pruning_path(Xt, y_tr)
ccp_alphas = path.ccp_alphas

accs = []
models = []
for a in ccp_alphas:
    clf = DecisionTreeClassifier(random_state=42, ccp_alpha=a).fit(Xt, y_tr)
    accs.append(accuracy_score(y_te, clf.predict(Xv)))
    models.append(clf)

best_idx = int(np.argmax(accs))
best_alpha = float(ccp_alphas[best_idx])
best_tree = models[best_idx]

print("Melhor ccp_alpha:", round(best_alpha, 6))
print("Acurácia (pós-poda):", round(accs[best_idx], 3))
```

**Explicação:**  
- `ccp_alpha` penaliza árvores mais complexas.  
- Usamos uma busca simples para achar o **melhor compromisso** entre tamanho e acurácia.

---

## 7) **Interpretação**: gráfico e regras em texto

**Por quê?** Transformar a árvore em **regras humanas** (“SE … ENTÃO …”).

```python
# Árvore pequena para leitura (didática)
small = DecisionTreeClassifier(random_state=42, max_depth=3, min_samples_leaf=8, ccp_alpha=0.0)
small.fit(Xt, y_tr)

plt.figure(figsize=(14,8))
plot_tree(small, filled=True, class_names=small.classes_, feature_names=pre_fitted.get_feature_names_out())
plt.show()

print(export_text(small, feature_names=list(pre_fitted.get_feature_names_out())))
print("Profundidade:", small.get_depth(), "| Folhas:", small.get_n_leaves())
```

**Como ler o nó/folha (ex.: `gini=0.494, samples=9, value=[5,4], class=negativo`)**  
- **gini**: impureza (0 = puro, 0.5 ~ metade/metade). Aqui, **0.494** significa grupo bem misto.  
- **samples**: quantos exemplos chegaram neste nó (**9**).  
- **value**: contagem por classe, na ordem do `classes_` do modelo (**[5 negativos, 4 positivos]**).  
- **class**: rótulo majoritário no nó (**negativo**).

---

## 8) **Comparação final**

**Por quê?** Mostrar o **trade-off** “simplicidade vs desempenho”.

```python
def resumo(nome, modelo, Xtr, Xte, ytr, yte):
    print(f"{nome}: treino={accuracy_score(ytr, modelo.predict(Xtr)):.3f} | teste={accuracy_score(yte, modelo.predict(Xte)):.3f}")

tree_base = DecisionTreeClassifier(random_state=42).fit(Xt, y_tr)
tree_pre  = DecisionTreeClassifier(random_state=42, max_depth=4, min_samples_leaf=10).fit(Xt, y_tr)
tree_post = best_tree

resumo("Sem poda", tree_base, Xt, Xv, y_tr, y_te)
resumo("Pré-podada", tree_pre, Xt, Xv, y_tr, y_te)
resumo("Pós-podada", tree_post, Xt, Xv, y_tr, y_te)
```

**Conclusão:** Prefira a **árvore menor** que mantenha desempenho parecido. Ela é **mais explicável** e **mais robusta**.

---

## 9) Checklist do professor (o que você precisa explicar)
- **Problema** e **alvo**; o que cada coluna significa.  
- **Limpeza** (duplicatas, ausentes, tipos) e **pré-processamento** (OneHot + imputação).  
- **Por que** pré-poda/pós-poda e o que cada hiperparâmetro controla.  
- **Métricas** (acurácia, matriz de confusão, precision/recall/F1) e **comparação**.  
- **Interpretação** da árvore: leia **raiz → ramos → folhas** como regras SE/ENTÃO.  
- **Trade-off**: simplicidade x poder de decisão.

---

## 10) Se a árvore sair **com 1 só nó/folha** (como corrigir)
- Diminua `ccp_alpha`, aumente `max_depth`, reduza `min_samples_leaf`, e zere `min_impurity_decrease`.  
- Garanta que o dado tem **informação** (sem tudo constante).  
- Para fins didáticos, gere uma árvore **pequena mas com splits** (ex.: `max_depth=3`, `min_samples_leaf=5`).

---

> **Dica final**: mantenha as células curtas; para cada bloco de código, escreva **uma frase** dizendo *o objetivo* e **uma** dizendo *o que você observou*.

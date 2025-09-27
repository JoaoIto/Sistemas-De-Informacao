# Ávore de decisão

## O que é uma árvore de decisão (e como ela é gerada)

* É um **fluxograma**: nós internos testam atributos; ramos são resultados; folhas têm o **rótulo da classe**. A raiz é o primeiro teste. Isso torna o modelo fácil de ler e explicar. 
* Construção é **top-down**, estilo “dividir-e-conquistar”: escolhe-se o **melhor atributo** (critério de divisão) para separar as classes, cria-se os ramos, e repete nos subconjuntos até parar (pureza, sem atributos, ou partição vazia). 
* Medidas comuns para escolher a divisão: **Ganho de Informação** (entropia), **Gain Ratio** e **Índice Gini**. A ideia é gerar partições o mais “puras” possível. 

## Por que podar (pre-poda e pós-poda)

* Árvores muito profundas **sobreajustam** ruído. **Poda** remove ramos menos confiáveis: fica menor, mais interpretável e tende a generalizar melhor. 
* **Pré-poda**: parar cedo (ex.: limitar profundidade, tamanho mínimo de folha). Risco: parar cedo demais. **Pós-poda**: crescer tudo e **depois** substituir subárvores por folhas usando um critério (ex.: **cost-complexity** do CART). 

## Como avaliar (bem direto)

* **Acurácia** = (TP+TN)/(P+N); útil quando classes são balanceadas. Para dados desbalanceados, olhe **sensibilidade/recall** e **especificidade/precision/F1**. 

## Regras

> Equilíbrio entre **facilidade de entender** e **poder de decisão**
> Use uma árvore **curta** (pré-poda) e confirme com **pós-poda** se dá para simplificar mais mantendo (ou melhorando) a acurácia.

---

# Notebook — blocos simples (cole no Colab em células separadas)

> Obs.: estes blocos assumem que você **enviou** o `covid_sintomas_exemplo.csv` pro Colab ou usará o link acima para fazer upload.

## Bloco 1 — Importações e dados

```python
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.pipeline import Pipeline
from sklearn.tree import DecisionTreeClassifier, plot_tree, export_text
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
import matplotlib.pyplot as plt

df = pd.read_csv("covid_sintomas_exemplo.csv")  # envie o arquivo ou ajuste o caminho
df.head()
```

## Bloco 2 — Separar X, y e preparar o pré-processamento

```python
target = "resultado"
X = df.drop(columns=[target])
y = df[target]

cat_cols = X.columns.tolist()  # todas são categóricas ("sim"/"nao" ou faixas)
pre = ColumnTransformer([
    ("cat", OneHotEncoder(handle_unknown="ignore", sparse_output=False), cat_cols)
])
```

## Bloco 3 — Base line (sem poda) + avaliação

```python
X_tr, X_te, y_tr, y_te = train_test_split(X, y, test_size=0.25, stratify=y, random_state=42)

base = Pipeline([
    ("pre", pre),
    ("clf", DecisionTreeClassifier(random_state=42))  # sem restrições
])
base.fit(X_tr, y_tr)
pred = base.predict(X_te)

print("Acurácia (sem poda):", accuracy_score(y_te, pred).round(3))
print(confusion_matrix(y_te, pred))
print(classification_report(y_te, pred, digits=3))
```

## Bloco 4 — **Pré-poda** (árvore mais simples)

```python
prepodada = Pipeline([
    ("pre", pre),
    ("clf", DecisionTreeClassifier(
        random_state=42,
        max_depth=4,          # limita profundidade
        min_samples_leaf=10,  # folhas com pelo menos 10 exemplos
        ccp_alpha=0.0         # sem pós-poda aqui
    ))
])
prepodada.fit(X_tr, y_tr)
pred2 = prepodada.predict(X_te)
print("Acurácia (pré-poda):", accuracy_score(y_te, pred2).round(3))
print(confusion_matrix(y_te, pred2))
```

## Bloco 5 — **Pós-poda** (cost-complexity pruning do CART)

```python
# 1) gerar caminho de complexidade
prep = pre.fit(X_tr, y_tr)  # ajusta encoder uma vez
Xt = prep.transform(X_tr)
Xv = prep.transform(X_te)

tree0 = DecisionTreeClassifier(random_state=42)
path = tree0.cost_complexity_pruning_path(Xt, y_tr)
ccp_alphas = path.ccp_alphas

# 2) treinar várias árvores variando alpha e escolher a melhor por acurácia de validação
accs = []
models = []
for a in ccp_alphas:
    clf = DecisionTreeClassifier(random_state=42, ccp_alpha=a)
    clf.fit(Xt, y_tr)
    accs.append(accuracy_score(y_te, clf.predict(Xv)))
    models.append(clf)

best_idx = max(range(len(accs)), key=lambda i: accs[i])
best_alpha = ccp_alphas[best_idx]
best_tree = models[best_idx]
print("Melhor ccp_alpha:", round(best_alpha, 5), "| Acurácia (pós-poda):", round(accs[best_idx], 3))
```

## Bloco 6 — Visualização rápida (árvore pequena) + regras

```python
small = DecisionTreeClassifier(random_state=42, max_depth=3, min_samples_leaf=10)
small.fit(Xt, y_tr)

plt.figure(figsize=(14,8))
plot_tree(small, filled=True, class_names=small.classes_, feature_names=pre.get_feature_names_out())
plt.show()

print(export_text(small, feature_names=list(pre.get_feature_names_out())))
```

## Bloco 7 — Comparar “simplicidade vs. decisão”

```python
def resumo(nome, modelo, Xt, Xv, y_tr, y_te):
    print(f"{nome}:")
    print("  Acurácia treino:", round(accuracy_score(y_tr, modelo.predict(Xt)), 3))
    print("  Acurácia teste :", round(accuracy_score(y_te, modelo.predict(Xv)), 3))

# modelos comparáveis
tree_base = base.named_steps["clf"]
tree_pre  = prepodada.named_steps["clf"]

# precisa das matrizes transformadas (Xt/Xv) para comparar árvores isoladas
resumo("Sem poda", tree_base.fit(Xt, y_tr), Xt, Xv, y_tr, y_te)
resumo("Pré-podada", tree_pre.fit(Xt, y_tr), Xt, Xv, y_tr, y_te)
resumo("Pós-podada", best_tree, Xt, Xv, y_tr, y_te)
```

---

## Como “ler” sua árvore (roteiro de fala)

* Comece pelo nó raiz: qual teste aparece? (ex.: **contato_confirmado = sim**).
* Siga um ramo e explique em **português** a regra “SE … ENTÃO …” (o `export_text` ajuda).
* Mostre que **pré-poda** deixou a árvore curta (profundidade máx. 4), e que **pós-poda** com `ccp_alpha` removeu ramos que não ajudavam a acertar no teste.
* Conclua com o **trade-off**: uma árvore mais simples facilita a decisão estratégica (explicável para gestão) com desempenho parecido ao da árvore cheia.

---

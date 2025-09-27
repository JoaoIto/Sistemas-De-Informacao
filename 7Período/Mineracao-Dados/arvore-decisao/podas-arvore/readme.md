# Podas de árvore

# 0) Base (o que estamos usando)

* **Alvo**: `resultado` (`positivo`/`negativo`)
* **Atributos**: `faixa_etaria`, `vacinado`, `febre`, `tosse`, `dor_garganta`, `falta_ar`, `fadiga`, `contato_confirmado` (todos categóricos)

---

# 1) Pré-poda (parar cedo para manter a árvore simples)

## Explicação

A **pré-poda** coloca limites **antes** da árvore crescer demais. Ideia: “não deixe a árvore virar um **macarrão**”.
Parâmetros que controlam isso (os principais):

* `max_depth`: profundidade máxima (quantos níveis).
* `min_samples_leaf`: mínimo de amostras em **cada folha** (evita folhas frágeis).
* `max_leaf_nodes` (opcional): número máximo de folhas.
* `min_impurity_decrease` (opcional): exige um ganho mínimo de pureza para permitir um split.

Com esses limites, a árvore já nasce **curta e legível**, ótima para explicar para o professor/gestor.

## Código (pré-poda)

> cole em uma célula — simples e direto

```python
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.pipeline import Pipeline
from sklearn.tree import DecisionTreeClassifier, plot_tree, export_text
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report
import matplotlib.pyplot as plt

# 1) dados
df = pd.read_csv("covid_sintomas_exemplo.csv")
target = "resultado"
X = df.drop(columns=[target])
y = df[target]

# 2) pré-processamento (tudo categórico -> OneHot)
cat_cols = X.columns.tolist()
pre = ColumnTransformer([
    ("cat", OneHotEncoder(handle_unknown="ignore", sparse_output=False), cat_cols)
])

# 3) split
X_tr, X_te, y_tr, y_te = train_test_split(X, y, test_size=0.25, stratify=y, random_state=42)

# 4) Árvore com PRÉ-PODA
prepodada = Pipeline([
    ("pre", pre),
    ("clf", DecisionTreeClassifier(
        random_state=42,
        max_depth=4,          # limite de níveis
        min_samples_leaf=10,  # folhas estáveis
        ccp_alpha=0.0         # pós-poda desligada aqui
    ))
])
prepodada.fit(X_tr, y_tr)
pred_pre = prepodada.predict(X_te)

print("Acurácia (pré-poda):", round(accuracy_score(y_te, pred_pre), 3))
print(confusion_matrix(y_te, pred_pre))
print(classification_report(y_te, pred_pre, digits=3))

# 5) Árvore pequena para ler regras (treina fora do pipeline para plotar)
pre_fitted = pre.fit(X_tr, y_tr)
Xt = pre_fitted.transform(X_tr)
small = DecisionTreeClassifier(random_state=42, max_depth=3, min_samples_leaf=8).fit(Xt, y_tr)

plt.figure(figsize=(14,8))
plot_tree(small, filled=True, class_names=small.classes_, feature_names=pre_fitted.get_feature_names_out())
plt.show()

print(export_text(small, feature_names=list(pre_fitted.get_feature_names_out())))
print("Profundidade:", small.get_depth(), "| Folhas:", small.get_n_leaves())
```

## Como ler/explicar o resultado (pré-poda)

* Se a raiz vier com algo como `contato_confirmado=sim`, faz sentido: contato recente costuma **puxar para positivo**.
* Em seguida, ramos checam `febre`, `tosse`, `falta_ar`, etc.
* A árvore curta (ex.: depth=3~4) já produz regras tipo:

  * **SE** `contato_confirmado=sim` **E** `febre=sim` → **positivo**
  * **SE** `contato_confirmado=nao` **E** `vacinado=sim` → tende a **negativo**
* Vantagem: **muito explicável** e **pouco overfitting**. Se a acurácia estiver próxima da sem-poda, **é a melhor escolha para apresentar**.

---

# 2) Pós-poda (cresce tudo e podar depois com custo-complexidade)

## Explicação

Na **pós-poda**, você **deixa crescer** e depois **corta**. No CART (sklearn), isso é feito com `ccp_alpha` (**cost-complexity**):

* Pense em `ccp_alpha` como uma **multa** por complexidade.
* Para cada `alpha`, a árvore “aceita” um certo tamanho: **alpha maior → árvore menor**.
* A gente gera um **caminho de alphas** e escolhe o que dá melhor desempenho no teste/validação.

## Código (pós-poda com `ccp_alpha`)

```python
# 1) usar as matrizes já codificadas (Xt/Xv) e y_tr/y_te
Xv = pre_fitted.transform(X_te)

# 2) caminho de complexidade
from sklearn.tree import DecisionTreeClassifier
path = DecisionTreeClassifier(random_state=42).cost_complexity_pruning_path(Xt, y_tr)
ccp_alphas = path.ccp_alphas

# 3) testar vários alphas e escolher o melhor
from sklearn.metrics import accuracy_score
accs, models = [], []
for a in ccp_alphas:
    clf = DecisionTreeClassifier(random_state=42, ccp_alpha=a).fit(Xt, y_tr)
    accs.append(accuracy_score(y_te, clf.predict(Xv)))
    models.append(clf)

best_idx = max(range(len(accs)), key=lambda i: accs[i])
best_alpha = ccp_alphas[best_idx]
best_tree = models[best_idx]

print("Melhor ccp_alpha:", round(best_alpha, 6))
print("Acurácia (pós-poda):", round(accs[best_idx], 3))
print("Profundidade:", best_tree.get_depth(), "| Folhas:", best_tree.get_n_leaves())

# (opcional) visualizar a árvore pós-podada
import matplotlib.pyplot as plt
plt.figure(figsize=(14,8))
from sklearn.tree import plot_tree, export_text
plot_tree(best_tree, filled=True, class_names=best_tree.classes_, feature_names=pre_fitted.get_feature_names_out())
plt.show()

print(export_text(best_tree, feature_names=list(pre_fitted.get_feature_names_out())))
```

## Como ler/explicar o resultado (pós-poda)

* Você verá que, conforme `alpha` aumenta, **o número de folhas cai** e a árvore fica mais **curta**.
* A escolhida (melhor `alpha`) tende a **manter o desempenho** com uma árvore **mais simples** que a sem-poda.
* Use depth e nº de folhas na fala: “com `alpha=…`, ficamos com **X níveis** e **Y folhas**”.

---

# 3) Pré x Pós — quando usar qual?

* **Quer algo rápido e fácil de explicar?** Comece com **pré-poda** (`max_depth` 3–5, `min_samples_leaf` 5–15).
* **Quer extrair o máximo e depois simplificar?** Use **pós-poda** (busca por `ccp_alpha`).
* **Apresentação**: se **pré-poda ≈ sem-poda** em acurácia, **prefira pré-poda** (mais estável e didática). Se **pós-poda** achou uma árvore ainda menor **com mesma acurácia**, use a pós-podada.

---

# 4) Dicas práticas (com esse dataset de sintomas)

* Se a árvore sair **com 1 nó só** (sem splits):

  * Diminua restrição: `min_samples_leaf ↓`, `max_depth ↑`, `min_impurity_decrease=0.0`, `ccp_alpha=0.0`.
* Mantenha sempre uma **árvore pequena para leitura** (ex.: `max_depth=3`) e mostre as **regras** com `export_text`.
* Interprete cada regra como **SE/ENTÃO** e conecte com o domínio:

  * contato → febre/falta_ar → tosse/vacinação → resultado.

---

# 5) Mini-roteiro para explicar ao professor

1. **Problema e dados** (o que é cada coluna, alvo, proporções).
2. **Pré-poda**: mostre hiperparâmetros e a árvore curta + acurácia.
3. **Pós-poda**: explique `ccp_alpha`, mostre o “antes/depois” (tamanho x acurácia).
4. **Leitura das regras** (em português, 2–3 exemplos claros).
5. **Conclusão**: **equilíbrio** entre **simplicidade** (entender e decidir) e **poder preditivo** (acertar bem).

---

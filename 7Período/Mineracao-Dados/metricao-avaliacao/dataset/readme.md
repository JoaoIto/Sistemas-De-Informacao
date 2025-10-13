# Atividade 10 - Métricas e avaliação

---

# 1. Objetivo (1 frase)

Pipeline completo de Machine Learning para prever se estudantes irão
graduar, abandonar ou permanecer matriculados.

Prever `AcademicOutcome` (Graduate / Dropout / Enrolled) a partir de atributos acadêmicos e socioeconômicos, com fluxo reprodutível: EDA → limpeza mínima → pipeline (imputação + encoding) → Decision Tree otimizada → avaliação por várias métricas.

---

# 2. Contexto do dataset (o que é e por que importa)

* Dados: informações do aluno (curso, notas/avaliações, bolsas, ocupação dos pais, etc.).
* Uso prático: identificar alunos em risco, apoiar políticas de retenção.
* Atenção: `Enrolled` é a classe minoritária — não confie só em acurácia; usar métricas por classe e PR/AP.

---

# 3. Imports essenciais (trecho mínimo)

```python
import pandas as pd, numpy as np
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.pipeline import Pipeline
from sklearn.compose import ColumnTransformer
from sklearn.impute import SimpleImputer
from sklearn.preprocessing import StandardScaler, OrdinalEncoder
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import classification_report, confusion_matrix, roc_auc_score
```

> **Por quê:** apenas o mínimo necessário para reproduzir o pipeline, treino e avaliação.

---

# 4. Carregamento (trecho essencial com fallback)

```python
# Preferir scipy.io.arff quando disponível; fallback para parsing simples após @DATA
try:
    from scipy.io import arff
    data, _ = arff.loadarff('/mnt/data/dataset_')
    df = pd.DataFrame(data)
    # decodificar bytes -> str
    for c in df.select_dtypes([object]).columns:
        df[c] = df[c].apply(lambda v: v.decode('utf-8') if isinstance(v, bytes) else v)
except Exception:
    import csv, io, re
    text = open('/mnt/data/dataset_', encoding='utf-8', errors='replace').read()
    attrs = re.findall(r"@ATTRIBUTE\s+([^\s]+)", text, flags=re.IGNORECASE)
    data_part = text.split('@DATA',1)[1].strip()
    rows = list(csv.reader(io.StringIO(data_part), delimiter=',', quotechar="'", skipinitialspace=True))
    df = pd.DataFrame(rows, columns=[a.strip().strip("'\"") for a in attrs])
```

**Por quê:** garante leitura robusta de ARFF-like; converte tipos quando necessário.

---

# 5. Limpeza mínima (trecho essencial)

```python
# Remoções simples e garantia do target
df = df.drop_duplicates().reset_index(drop=True)
df = df[df['AcademicOutcome'].notna()].copy()
df['AcademicOutcome'] = df['AcademicOutcome'].astype(str)
```

**Por quê:** duplicatas e linhas sem alvo distorcem avaliação. Imputação fica dentro do pipeline (evita vazamento).

---

# 6. Pré-processamento (trecho essencial, explicação curta)

```python
num_cols = df.select_dtypes(include=['int64','float64']).columns.tolist()
cat_cols = [c for c in df.select_dtypes(include=['object']).columns if c!='AcademicOutcome']

numeric_pipeline = Pipeline([
    ('imputer', SimpleImputer(strategy='median')),
    ('scaler', StandardScaler())
])
categorical_pipeline = Pipeline([
    ('imputer', SimpleImputer(strategy='constant', fill_value='missing')),
    ('ord', OrdinalEncoder(handle_unknown='use_encoded_value', unknown_value=-1))
])
preprocessor = ColumnTransformer([
    ('num', numeric_pipeline, num_cols),
    ('cat', categorical_pipeline, cat_cols)
], remainder='drop')
```

**Por quê (resumo):**

* Mediana é robusta a outliers; scaler torna o pipeline reutilizável.
* `OrdinalEncoder` evita explosão dimensional (útil com Decision Trees); cuidado se usar modelos lineares.

---

# 7. Treino e busca de hiperparâmetros (trecho essencial)

```python
X = df.drop(columns=['AcademicOutcome']); y = df['AcademicOutcome']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25, stratify=y, random_state=42)

pipe = Pipeline([('pre', preprocessor), ('clf', DecisionTreeClassifier(random_state=42))])
param_grid = {'clf__max_depth': [5,8], 'clf__min_samples_leaf': [1,5,10]}
gs = GridSearchCV(pipe, param_grid, cv=3, scoring='roc_auc_ovr', n_jobs=1)
gs.fit(X_train, y_train)
best = gs.best_estimator_
```

**Por quê (resumo):**

* `stratify=y` preserva proporções de classes no split.
* Grid reduzido + `cv=3` é prático para demonstração; para análise final aumente `cv`/grid.

---

# 8. Avaliação: métricas essenciais (trecho mínimo)

```python
y_pred = best.predict(X_test)
y_proba = best.predict_proba(X_test)

print(classification_report(y_test, y_pred, digits=3))
print("Confusion matrix:\n", confusion_matrix(y_test, y_pred))

from sklearn.preprocessing import label_binarize
y_test_bin = label_binarize(y_test, classes=best.named_steps['clf'].classes_)
print("ROC AUC (macro OVR):", round(roc_auc_score(y_test_bin, y_proba, average='macro', multi_class='ovr'),3))
```

**Por quê (resumo):**

* `classification_report` traz precision/recall/f1 por classe (indispensável).
* Matriz de confusão mostra *quem é confundido com quem*.
* `ROC AUC` (macro OVR) avalia separabilidade probabilística global; combine com PR/AP para classes raras.

---

# 9. Interpretação rápida (texto didático curto)

* **Matriz de Confusão:** identifica erros concretos (ex.: muitos *Enrolled* previstos como *Graduate* → foco de melhoria).
* **Accuracy:** resumo geral (no seu caso ≈72%); não suficiente com desbalanceamento.
* **Precision:** confiabilidade de uma previsão (quando diz “Enrolled”, quão certo está).
* **Recall:** cobertura dos reais (quantos Enrolled reais foram detectados) — importante se custo de perda for alto.
* **F1:** balanço entre precision e recall.
* **ROC/AUC:** separabilidade probabilística; **PR/AP** é preferível quando a classe é minoritária (como *Enrolled*).

---

# 10. Recomendações práticas (prioritárias, sucintas)

1. **Foco em `Enrolled`:** usar `class_weight='balanced'` ou SMOTE; calibrar thresholds; priorizar AP/Recall nessa classe.
2. **Feature engineering:** agrupar cursos raros; criar indicadores a partir de `Curricular_units_*`.
3. **Modelos adicionais:** testar RandomForest / LightGBM com `class_weight`/oversampling.
4. **Ética:** anonimizar dados sensíveis e usar modelo como apoio à decisão humana.

---

# 11. Frases prontas para o slide final (3 bullets)

* “O modelo teve boa separabilidade para *Graduate* e *Dropout*, mas *Enrolled* apresenta baixa recall e AP — priorizar ações para essa classe.”
* “Não julgue por AUC isoladamente: apresentar matriz de confusão + precision/recall/F1 para decisões operacionais.”
* “Próximos passos: balanceamento, engenharia de features e testes com modelos ensemble.”

---

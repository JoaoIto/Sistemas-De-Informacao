## 🧩 **Dados da questão 1**

|                       | Fraude (real) | Não fraude (real) |
| --------------------- | ------------- | ----------------- |
| **Previu Fraude**     | 18            | 12                |
| **Previu Não fraude** | 2             | 68                |

---

### **a) Matriz de confusão (VP, FP, FN, VN)**

| Termo                        | Significado                                   | Valor |
| ---------------------------- | --------------------------------------------- | ----- |
| **VP (Verdadeiro Positivo)** | Fraudes que o modelo detectou corretamente    | 18    |
| **FP (Falso Positivo)**      | Transações normais marcadas como fraude       | 12    |
| **FN (Falso Negativo)**      | Fraudes que o modelo não detectou             | 2     |
| **VN (Verdadeiro Negativo)** | Transações normais identificadas corretamente | 68    |

---

### **b) Quantas previsões corretas o modelo fez?**

Corretas = **VP + VN = 18 + 68 = 86**

**O modelo acertou 86 das 100 transações.**

Basicamente o cálculo é feito baseado verdadeiramente no que ele aceitou.

---

## **2. Acurácia**

[
\text{Acurácia} = \frac{VP + VN}{Total}
]

[
\text{Acurácia} = \frac{18 + 68}{100} = \frac{86}{100} = 0.86
]

 **Acurácia = 86%**

Mantendo a acurácia alta.

---

## **3. Precisão (para a classe Fraude)**

[
\text{Precisão} = \frac{VP}{VP + FP}
]

[
\text{Precisão} = \frac{18}{18 + 12} = \frac{18}{30} = 0.6
]

 **Precisão = 60%**

*(Significa que, de todas as vezes que o modelo disse “fraude”, 60% eram realmente fraudes.)*

- Sendo assim mantendo baixa, com a precisão que não consegue aceitar com facilidade oque realmente precisa aceitar.

---

## **4. Recall (para a classe Fraude)**

[
\text{Recall} = \frac{VP}{VP + FN}
]

[
\text{Recall} = \frac{18}{18 + 2} = \frac{18}{20} = 0.9
]

**Recall = 90%**

*(Ou seja, o modelo encontrou 90% de todas as fraudes reais.)* 

O que conta com positivos e falsos corretos, com uma boa métrica de recall, por também 
ter uma boa acurácia no modelo

---

## **5. F1-Score**

[
F1 = 2 \times \frac{(Precisão \times Recall)}{(Precisão + Recall)}
]

[
F1 = 2 \times \frac{(0.6 \times 0.9)}{(0.6 + 0.9)} = 2 \times \frac{0.54}{1.5} = 0.72
]

**F1-score = 0.72 (ou 72%)**

*(Equilíbrio entre detectar fraudes e evitar falsos alarmes.)*


Um equilíbrio bem aceitável para isso, mantendo uma boa métrica de análise

---

## **6. Interpretação do segundo caso**

> “Um modelo teve **acurácia = 95%** e **F1-score = 50%**, e o conjunto está **muito desbalanceado**.”

**Interpretação:**

O modelo acerta quase tudo **porque a maioria das transações é "não fraude"**, então ele “acerta” muito apenas por repetir o padrão mais comum.
Mas o **F1-score baixo (50%)** mostra que ele **não identifica bem as fraudes** (baixa precisão ou recall).

Em resumo:

* O modelo **parece bom pela acurácia**, mas **é fraco para detectar a classe minoritária (fraude)**.
* É o típico caso em que a **acurácia engana** e métricas como **F1-score** e **Recall** são mais importantes.

---

## **Resumo final**

| Métrica      | Fórmula           | Resultado | Interpretação                                  |
| ------------ | ----------------- | --------- | ---------------------------------------------- |
| **Acurácia** | (VP + VN) / Total | 0.86      | 86% dos casos foram classificados corretamente |
| **Precisão** | VP / (VP + FP)    | 0.6       | 60% das previsões de fraude eram corretas      |
| **Recall**   | VP / (VP + FN)    | 0.9       | 90% das fraudes foram detectadas               |
| **F1-score** | 2 × (P×R)/(P+R)   | 0.72      | Equilíbrio entre precisão e recall             |

---


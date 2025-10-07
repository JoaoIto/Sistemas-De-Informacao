# **Métricas de Avaliação de Modelos**

Avaliar um modelo significa **medir o quanto ele acerta e o tipo de erro que comete**.
Usar apenas **acurácia** pode enganar, principalmente em **dados desbalanceados** (quando há muito mais exemplos de uma classe que de outra).

Por isso usamos métricas específicas: **Precisão**, **Revocação**, **F1-score**, e **gráficos** como a **Curva ROC** e **Curva Precisão x Revocação**.

---

## **1. Conceitos Principais**

| Métrica                        | O que mede                                           | Quando usar                               | Exemplo de aplicação                       | Tipo de dataset mais comum                 |
| ------------------------------ | ---------------------------------------------------- | ----------------------------------------- | ------------------------------------------ | ------------------------------------------ |
| **Acurácia**                   | Percentual total de acertos                          | Quando as classes são balanceadas         | Classificar flores, dígitos, animais       | Dados equilibrados (ex: 50% vs 50%)        |
| **Precisão (Precision)**       | Entre os positivos previstos, quantos estavam certos | Quando **falsos positivos** são graves    | Filtro de spam, fraude bancária            | Desbalanceado (ex: 95% normal / 5% fraude) |
| **Revocação (Recall)**         | Entre os positivos reais, quantos o modelo encontrou | Quando **falsos negativos** são graves    | Diagnóstico médico, detecção de doenças    | Desbalanceado                              |
| **F1-Score**                   | Combina precisão e revocação                         | Quando há **desequilíbrio** entre classes | Detecção de churn (clientes que vão sair)  | Desbalanceado                              |
| **Matriz de Confusão**         | Mostra acertos e erros por classe                    | Diagnóstico geral do modelo               | Qualquer tipo                              | Todos                                      |
| **AUC - ROC**                  | Mede capacidade de distinguir classes                | Quando se quer comparar classificadores   | Reconhecimento facial, detecção de crédito | Pode ser balanceado ou não                 |
| **Curva Precisão x Revocação** | Mostra equilíbrio entre as duas métricas             | Quando há **forte desbalanceamento**      | Fraudes, detecção de spam, doenças raras   | Desbalanceado (extremo)                    |

---

## **2. Exemplo didático simples**

Suponha que estamos detectando **fraudes bancárias**:

* 1000 transações → 980 legítimas, 20 fraudes (fortemente desbalanceado)

### **Modelo A (conservador)**

* Detecta 10 fraudes (8 verdadeiras e 2 erradas)
* Deixa 12 fraudes passarem

| Métrica   | Valor            | Interpretação                                  |
| --------- | ---------------- | ---------------------------------------------- |
| Precisão  | 8 / (8+2) = 0.8  | Quando diz que é fraude, geralmente está certo |
| Revocação | 8 / (8+12) = 0.4 | Perdeu muitas fraudes reais                    |
| F1-Score  | 0.53             | Médio equilíbrio                               |

➡️ **Usado quando FP custa caro** (ex: bloquear cliente inocente).

---

### **Modelo B (agressivo)**

* Detecta 18 fraudes (10 verdadeiras, 8 erradas)
* Deixa 10 fraudes passarem

| Métrica   | Valor              | Interpretação                                   |
| --------- | ------------------ | ----------------------------------------------- |
| Precisão  | 10 / (10+8) = 0.56 | Comete mais falsos positivos                    |
| Revocação | 10 / (10+10) = 0.5 | Encontra mais fraudes que o A                   |
| F1-Score  | 0.53               | Equilíbrio similar, mas com trade-off diferente |

➡️ **Usado quando FN custa caro** (ex: deixar fraude passar é pior do que alertar demais).

---

## **3. Resumo visual**

| Situação                   | Métrica mais relevante          | Exemplo de dataset              | Tipo de erro a evitar                              |
| -------------------------- | ------------------------------- | ------------------------------- | -------------------------------------------------- |
| Classes equilibradas       | **Acurácia**                    | Gatos vs cachorros (50/50)      | Ambos os erros importam igual                      |
| Classes desbalanceadas     | **F1-score, Precision, Recall** | 99% normal / 1% fraude          | Falso negativo ou positivo, dependendo do contexto |
| Diagnóstico médico         | **Revocação (Recall)**          | Pacientes saudáveis vs doentes  | Falso negativo (não detectar doente)               |
| Filtro de spam             | **Precisão (Precision)**        | 95% legítimo / 5% spam          | Falso positivo (bloquear e-mail certo)             |
| Modelos comparativos       | **ROC / AUC**                   | Reconhecimento de imagem        | Saber qual modelo distingue melhor                 |
| Classes extremamente raras | **Curva Precisão x Revocação**  | Fraude, detecção de câncer raro | Maximizar equilíbrio entre recall e precisão       |

---

## **4. Como interpretar curvas**

* **Curva ROC:**

  * Eixo X = Falsos positivos
  * Eixo Y = Verdadeiros positivos
  * Quanto mais a curva se aproxima do canto superior esquerdo, melhor.
  * AUC próximo de **1.0** → modelo excelente
  * AUC ≈ **0.5** → modelo aleatório

* **Curva Precisão x Revocação:**

  * Mostra como o aumento de recall reduz a precisão
  * Boa para **dados desbalanceados**
  * O ponto ideal é onde a precisão ainda é alta e o recall não cai muito.

---

## **5. Resumo final**

| Tipo de problema                | Melhor métrica | Justificativa                 |
| ------------------------------- | -------------- | ----------------------------- |
| Classificação simples           | Acurácia       | Classes equilibradas          |
| Fraudes, spam                   | Precisão       | Falsos positivos são graves   |
| Diagnóstico médico              | Revocação      | Falsos negativos são graves   |
| Problemas gerais desbalanceados | F1-score       | Equilíbrio entre ambos        |
| Comparação de modelos           | AUC/ROC        | Mede separação entre classes  |
| Classes muito raras             | Curva P-R      | Mostra melhor desempenho real |

---

Quer que eu monte agora um **gráfico simples em Python (matriz de confusão + curvas ROC e P-R)** com dois modelos (um mais conservador e outro mais agressivo) para você visualizar essas diferenças?
Ele ficaria bem leve — 20 linhas no máximo.

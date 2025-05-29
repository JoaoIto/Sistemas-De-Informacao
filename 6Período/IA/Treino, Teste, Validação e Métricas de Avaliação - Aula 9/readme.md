# Aula 09 – Treino, Teste, Validação e Métricas de Avaliação

Nesta aula abordamos **duas etapas fundamentais no processo de Aprendizado de Máquina**: a **divisão dos dados** e as **métricas para avaliação de modelos preditivos**.

---

### 🔹 1. Divisão de Dados: Treinamento, Validação e Teste

* Os dados utilizados no desenvolvimento de modelos de machine learning são geralmente divididos em três partes:

  * **Treinamento**: Usado para ajustar os parâmetros do modelo.
  * **Validação**: Usado para ajustar os hiperparâmetros e evitar overfitting.
  * **Teste**: Usado para avaliar o desempenho final do modelo em dados nunca vistos.

* **Importância**: Garante que o modelo aprenda padrões generalizáveis e que sua avaliação final seja confiável.

#### Ilustração:

![image](https://github.com/user-attachments/assets/f02b82f3-1aef-43ed-967c-e3eb8ffdce27)


---

### 🔹 2. Métricas de Avaliação: Matriz de Confusão e Derivadas

* Utilizamos a **matriz de confusão** para avaliar o desempenho de classificadores, especialmente em problemas binários.

#### Matriz de Confusão:

|                        | Condição Positiva        | Condição Negativa        |
| ---------------------- | ------------------------ | ------------------------ |
| **Resultado Positivo** | Verdadeiro Positivo (VP) | Falso Positivo (FP)      |
| **Resultado Negativo** | Falso Negativo (FN)      | Verdadeiro Negativo (VN) |

#### Métricas derivadas:

* **Acurácia**:

  $$
  \text{Acurácia} = \frac{VP + VN}{VP + VN + FP + FN}
  $$
* **Precisão (Precision)**:

  $$
  \text{Precisão} = \frac{VP}{VP + FP}
  $$
* **Revocação (Recall ou Sensibilidade)**:

  $$
  \text{Revocação} = \frac{VP}{VP + FN}
  $$
* **F1-Score**: Média harmônica entre precisão e revocação:

  $$
  F1 = 2 \cdot \frac{\text{Precisão} \cdot \text{Revocação}}{\text{Precisão} + \text{Revocação}}
  $$

---

### 📂 Scripts utilizados na aula:

* [`mlp_torch_iris.py`](https://github.com/sousamaf/AI-Lab/blob/main/algorithms/neural_networks/mlp/mlp_torch_iris.py)
  → Implementação de um MLP utilizando o conjunto de dados Iris.

* [`mlp_torch_avaliacao.py`](https://github.com/sousamaf/AI-Lab/blob/main/algorithms/neural_networks/mlp/mlp_torch_avaliacao.py)
  → Avaliação de desempenho do MLP com métricas como acurácia e F1-Score.

* [`mlp_simples_matriz_confusao.ipynb`](https://github.com/sousamaf/AI-Lab/blob/main/algorithms/neural_networks/mlp/mlp_simples_matriz_confusao.ipynb)
  → Notebook interativo que demonstra a geração e interpretação da matriz de confusão.

---

### 🎥 Gravações da Aula

* 📺 [Parte 1 – 05/04/2025](https://drive.google.com/file/d/1Cfh9wnTyrZ5NaSDW4eKLejopLXNSvNCI/view)
* 📺 [Parte 2 – 05/04/2025](https://drive.google.com/file/d/1EaGwMF9HvQaSRwfPXIZd2g4V7h1lsO12/view)

---


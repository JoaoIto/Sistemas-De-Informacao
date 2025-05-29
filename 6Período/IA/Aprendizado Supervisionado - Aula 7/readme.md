# Aula 07 – Introdução Prática ao Aprendizado Supervisionado

Nesta aula, aprofundamos o entendimento sobre **Aprendizado Supervisionado**, uma das abordagens mais utilizadas em problemas práticos de Inteligência Artificial e Ciência de Dados.

## Parte 1 – Fluxo Clássico do Aprendizado Supervisionado

Começamos discutindo o **fluxo básico** de um processo de aprendizado supervisionado:

1. **Coleta e preparação dos dados**: os dados precisam estar rotulados (isto é, cada entrada deve ter um valor de saída conhecido).
2. **Divisão dos dados** em conjuntos de treino e teste.
3. **Treinamento de um modelo** com base nos dados de treino.
4. **Avaliação** do modelo utilizando o conjunto de teste.
5. **Ajustes** e iteração no processo, se necessário.

### Algoritmos discutidos:

#### Regressão Linear

A **Regressão Linear** é um modelo estatístico simples, mas poderoso, que busca encontrar a melhor linha que se ajusta aos dados.

* O objetivo é modelar a relação entre uma variável dependente $y$ e uma ou mais variáveis independentes $x$.
* A equação é dada por:

  $$
  y = \alpha + \beta x + e
  $$

  onde:

  * $\alpha$ é o intercepto (bias),
  * $\beta$ é o coeficiente angular (peso),
  * $e$ é o erro (resíduo).

A [regressão linear](https://github.com/sousamaf/AI-Lab/blob/main/algorithms/linear_regression/regressao_linear.ipynb) é bastante utilizada quando queremos **prever valores contínuos**, como preços de casas, temperaturas, ou salários.

#### Máquina de Vetores de Suporte [(SVM)](https://github.com/sousamaf/AI-Lab/blob/main/algorithms/linear_regression/svm.ipynb)

A **SVM (Support Vector Machine)** é um algoritmo mais sofisticado, utilizado tanto para classificação quanto para regressão. Seu princípio é encontrar o **hiperplano** que **maximiza a margem** entre duas classes.

* Funciona bem em espaços de alta dimensionalidade.
* Pode ser estendida para resolver problemas não-lineares com o uso de **funções kernel**.
* Quando usada em **regressão (SVR)**, a ideia é encontrar uma função que desvie no máximo um valor ε dos dados reais, e ao mesmo tempo seja o mais plana possível.

A SVM é bastante eficaz em tarefas com **limiares claros entre classes**, como diagnósticos médicos, análise de crédito e reconhecimento de padrões.

## Parte 2 – O Perceptron

Na segunda parte da aula, exploramos o funcionamento do **Perceptron**, um dos modelos mais antigos e fundamentais para as redes neurais artificiais. Foi proposto por **Warren McCulloch e Walter Pitts** na década de 1940, e mais tarde aprimorado por Frank Rosenblatt.

### Estrutura do Perceptron

O perceptron é composto por:

* **Entradas (X1, X2, ..., Xm)**: correspondem às variáveis de entrada.
* **Pesos sinápticos (W1, W2, ..., Wm)**: cada entrada tem um peso que define sua importância.
* **Bias (b)**: valor fixo que ajusta o limiar de ativação.
* **Função de somatório (Σ)**: calcula a soma ponderada das entradas.
* **Função de ativação (φ)**: aplica uma transformação ao somatório. Pode ser, por exemplo, uma função degrau, sigmoide, ou ReLU.
* **Saída (y)**: o resultado final após a ativação.

Matematicamente, o perceptron realiza:

$$
y = \phi\left( \sum_{i=1}^{m} w_i x_i + b \right)
$$

Esse modelo é a base para redes neurais mais complexas e modernas, e representa uma ponte entre o aprendizado supervisionado e as técnicas de aprendizado profundo.

---

## Imagens:

![image](https://github.com/user-attachments/assets/a6672902-95c1-462d-8de6-3f85b8159ffc)


## Gravações da Aula

* **Parte 1 – 22/03/2025**:
  *Regressão Linear e Máquina de Vetores de Suporte (SVM)*
  *[link](https://drive.google.com/file/d/1crHPNV9Cja4APIaS3kwk__1Lm1_LpN8N/view)*

* **Parte 2 – 22/03/2025**:
  *Perceptron de Warren McCulloch e Walter Pitts*
  *[link](https://drive.google.com/file/d/1VEDUJAHc1BXhL08MH72JrRjSjdXFqKCE/view)*

---

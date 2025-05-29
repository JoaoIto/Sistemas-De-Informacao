# Aula 11 – Deep Learning

Nesta aula exploramos o conceito de **Deep Learning**, suas **aplicações**, **características**, **origens históricas**, e os **componentes principais das Redes Neurais Convolucionais (CNNs)**, uma das arquiteturas mais utilizadas em Visão Computacional.

---

### 🔹 1. O que é Deep Learning?

* É um subconjunto do Aprendizado de Máquina baseado em **redes neurais com múltiplas camadas** (deep = profundo).
* Busca **modelar representações complexas** dos dados através de arquiteturas sofisticadas.
* Popularizado a partir do artigo de **LeCun, Bengio e Hinton (2015)**:
  **“Deep Learning”, Nature 521(7553), 436–444. DOI: [10.1038/nature14539](https://doi.org/10.1038/nature14539)**

---

### 📌 Pontos Importantes do Deep Learning (Diagrama 1)

![image](https://github.com/user-attachments/assets/36cd048a-2fc8-4201-a8f9-c9eae5d394a4)


#### Aplicações:

* Visão Computacional
* Processamento de Linguagem Natural (NLP)
* Reconhecimento de Fala
* Assistentes Virtuais

#### Características:

* Base em arquiteturas profundas
* Muitas camadas de processamento
* Capacidade de aprender **representações complexas**
* Exige grande quantidade de **dados** e **poder computacional**

#### Arquiteturas comuns:

* **CNNs** (Redes Convolucionais) – usadas em imagens
* **RNNs** (Redes Recorrentes) – usadas em séries temporais/texto
* **LSTMs** – variação de RNNs para dependências longas

---

### 🔹 2. Componentes de uma CNN (Diagrama 2)

#### Aplicação: Visão Computacional

Uma **CNN típica** possui os seguintes componentes:

* **Camada Convolucional (Convolution Layer)**:

  * Aplica filtros que detectam padrões como bordas, texturas, formas.
* **Camada de Pooling (Max-Pool)**:

  * Reduz a dimensionalidade e retém os padrões mais importantes.
* **Flattening**:

  * Transformação da saída da rede convolucional em vetor para a camada densa.
* **Camada Densa (Fully Connected / Dense Layer)**:

  * Equivalente ao MLP tradicional, realiza a classificação baseada nos padrões extraídos.

![Componentes de uma CNN](attachment:/mnt/data/a4e7830c-009b-4746-94d5-a1e6fdd00908.png)

---

### 📂 Base Teórica

Artigo utilizado na aula:

> **LECUN, Yann; BENGIO, Yoshua; HINTON, Geoffrey.**
> *Deep learning*. **Nature**, 2015, v. 521, n. 7553, p. 436-444.
> [DOI: 10.1038/nature14539](https://doi.org/10.1038/nature14539)

---

### 🎥 Gravações da Aula

* 📺 [Aula 11 – Parte 1 – 26/04/2025](https://drive.google.com/file/d/1nEyw9o2kTfkX32a_eKNRxhQg7GtUFGgm/view)
* 📺 [Aula 11 – Parte 2 – 26/04/2025](https://drive.google.com/file/d/1Vo5MP7wn0SYKVCyAZ9fiH8Iz2isrYd7g/view)

---

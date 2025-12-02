# Prova Prática Mineração de Dados - A2

***

### Questão 1 - Regressão Linear (Interpretação de Parâmetros)  
Considere a seguinte saída de um modelo de regressão linear simples que estima o preço de imóveis com base na área (m²):

| Coeficiente     | Valor   | p-valor  |
|-----------------|---------|----------|
| Intercepto      | 50000   | 0.001    |
| Área (m²)       | 1500    | 0.00001  |

O R² do modelo foi 0,85 e o RMSE foi 25000.

Sobre este modelo, assinale a alternativa correta:  
a) O modelo explica 85% da variabilidade do preço dos imóveis.  
b) Cada metro quadrado adicional acrescenta, em média, R$ 1500 ao preço do imóvel.  
c) O p-valor baixo indica que os coeficientes são estatisticamente significativos.  
d) Todas as alternativas anteriores.  
e) Nenhuma das anteriores.

***

### Questão 2 - Clusterização (Método do Cotovelo)  

Observe o gráfico abaixo que mostra a inércia (soma das distâncias dos pontos aos centróides) para diferentes valores de k (número de clusters):

```
Inércia
|
|          *
|        *  *
|      *     *
|    *         *
|  *            *
|*_______________ _  k
  1 2 3 4 5 6 7 8
```

Considerando o método do cotovelo, qual o valor mais indicado para \(k\)?  
a) 1  
b) 2  
c) 3  
d) 7  

***

### Questão 3 - Matriz de Confusão e Métricas  

Dado o resultado a seguir da matriz de confusão para classificação binária:

|               | Predito Positivo | Predito Negativo |
|---------------|------------------|------------------|
| Real Positivo | 85               | 15               |
| Real Negativo | 20               | 80               |

Calcule a precisão (precision) do modelo.  
a) 0,81  
b) 0,85  
c) 0,73  
d) 0,68  

***

### Questão 4 - Verdadeiro ou Falso - Sobre AutoML  

O AutoML sempre substitui a necessidade do conhecimento especializado em mineração de dados, tornando desnecessário entender os dados ou as métricas do modelo.  
(V) Verdadeiro  
(F) Falso  

***

### Questão 5 - Regras de Associação (Interpretação)  

Uma regra de associação gerada tem os seguintes valores:

| Suporte | Confiança | Lift  |
|---------|-----------|-------|
| 0,04    | 0,75      | 1,8   |

Qual é a interpretação correta?  
a) A regra aparece em 4% das transações e compra Y 75% das vezes quando X ocorre, com uma forte associação positiva.  
b) A regra aparece em 75% das transações e tem suporte baixo.  
c) O lift indica que X e Y são independentes.  
d) A confiança indica que a regra é pouco confiável.

***

### Questão 6 - Código e Parâmetros - Random Forest  

Analise o código a seguir:

```python
from sklearn.ensemble import RandomForestClassifier

rf = RandomForestClassifier(n_estimators=200, max_depth=10, random_state=42)
rf.fit(X_train, y_train)
pred = rf.predict(X_test)
```

O que indica o parâmetro `max_depth=10`?  
a) Limita a profundidade máxima de cada árvore para evitar overfitting.  
b) Determina o número de árvores no ensemble.  
c) Controla a taxa de aprendizagem.  
d) Define o número mínimo de amostras para divisão.

***

### Questão 7 - Conhecimento Geral - Aprendizado Supervisionado vs Não Supervisionado  

Assinale a alternativa que mostra corretamente qual técnica é aplicada em aprendizado supervisionado e não supervisionado, respectivamente:  

a) Classificação e Regressão - ambos supervisionados  
b) Clusterização e Regressão  
c) Classificação e Clusterização  
d) Regras de Associação e AutoML  

***

### Questão 8 - Interpretação de Curva ROC e AUC (Diagrama)  

Considerando quatro modelos A, B, C e D, cujas curvas ROC e valores AUC são mostrados abaixo (valores fictícios):

| Modelo | AUC  |
|--------|------|
| A      | 0.95 |
| B      | 0.75 |
| C      | 0.60 |
| D      | 0.50 |

Qual afirmação é verdadeira?  
a) Modelo D é quase aleatório, A é o melhor.  
b) Modelo C é quase perfeito.  
c) Modelo B está abaixo da linha chance.  
d) AUC indica erro do modelo.

***

### Questão 9 - Verdadeiro ou Falso - Validação Cruzada  

A validação cruzada ajuda a reduzir o overfitting do modelo ao realizar múltiplas divisões do conjunto de dados para treino e teste.  
(V) Verdadeiro  
(F) Falso  

***

### Questão 10 - Parâmetros e Configurações na Clusterização  

Em uma atividade usando K-Means, o estudante configurou `n_clusters = 4` e `max_iter = 100`, mas observou que o algoritmo não convergia, sugeriu-se aumentar `max_iter`. Por que isso é importante?  

a) Para garantir que o algoritmo tenha iterações suficientes para os centróides estabilizarem.  
b) Para aumentar o número de clusters.  
c) Para diminuir a precisão do algoritmo.  
d) Não faz diferença no resultado.

***

# Instruções para Correção

- Questão 1: d  
- Questão 2: c  
- Questão 3: a  
- Questão 4: F  
- Questão 5: a  
- Questão 6: a  
- Questão 7: c  
- Questão 8: a  
- Questão 9: V  
- Questão 10: a

***

Esta prova cobre os principais conceitos e aplicações práticas de todos os temas, mesclando interpretação, cálculo, código, escolhas de parâmetros e conceitos fundamentais, usando diagramas e questões de verdadeiro ou falso para variar o formato e medir o entendimento amplo do aluno.

# A1 - TESTE 

## 📘 Banco de Questões – Mineração de Dados (Prova Escrita)
### 📘 Gabarito – Banco de Questões Mineração de Dados

## Parte 1 – Questões Objetivas

1. **b)** Dois ramos, representando uma condição lógica de separação.
   → Em árvores binárias cada teste divide o conjunto em 2.

2. **d)** Todas as alternativas estão corretas.
   → O índice de Gini mede pureza, menor valor indica mais pureza e é usado no CART.

3. **Verdadeiro ou Falso:**

   * (F) Pré-poda consiste em **parar cedo**, não em cortar depois.
   * (V) Pós-poda remove ramos fracos **após** construir a árvore completa.

4. **a)** Treino, teste e validação.

5. **b)** Precisão, recall e F1-score.
   → São mais adequadas em bases desbalanceadas que a acurácia.

6. **b)** Definição do problema → Pré-processamento → Transformação → Treinamento → Avaliação → Interpretação.

---

## Parte 2 – Questões Subjetivas

7. **Classificação supervisionada x Clustering:**

   * Classificação supervisionada: usa **dados rotulados** para aprender regras e prever classes futuras.
   * Clustering: é **não supervisionado**, agrupa dados semelhantes sem rótulos prévios.

8. **Pré-processamento:**

   * Importante para garantir qualidade do modelo.
   * Exemplos:

     * Tratar valores faltantes (ex.: substituir médias em atributos numéricos).
     * Normalizar variáveis para que fiquem na mesma escala.

9. **Pré-poda x Pós-poda:**

   * Pré-poda: impede crescimento excessivo (profundidade máxima, mínimo de registros por nó). Evita overfitting, mas pode parar cedo demais.
   * Pós-poda: cresce a árvore inteira e depois corta ramos de pouca relevância. Melhora generalização, mas é mais custoso.

10. **Interpretação da árvore (crédito):**

* Primeiro critério é renda: indica que a variável renda é mais determinante para aprovação.
* Depois tempo de emprego: mostra que estabilidade profissional também influencia.
* A árvore traduz a **lógica do negócio** em regras claras.

11. **F1-score:**

* Fórmula: 2·(Precisão·Recall)/(Precisão+Recall).
* Preferível quando as classes estão desbalanceadas, pois equilibra precisão e recall, diferente da acurácia que pode enganar.

12. **ROC/AUC:**

* Curva ROC: mostra trade-off entre sensibilidade (TPR) e taxa de falsos positivos (FPR).
* AUC: área sob a curva, mede poder discriminativo.
* AUC ≈ 0,5: modelo não é melhor que um chute aleatório.

13. **Validação cruzada (k-fold):**

* Divide o dataset em k partes. Cada parte é usada uma vez como teste e k-1 vezes como treino.
* Estratificada: garante que a proporção de classes seja mantida em cada fold, evitando distorções.

14. **Engenharia de atributos:**

* Inclui transformações como:

  * Codificação de categóricas (ex.: One-Hot).
  * Normalização (Min-Max, Z-score).
  * Criação de novas variáveis derivadas.
* Visa melhorar a capacidade preditiva do modelo.

15. **Matriz de confusão:**

* Representa acertos e erros do modelo em cada classe.
* Exemplo: ajuda a ver se há muitos falsos negativos (ex.: fraude classificada como normal), o que é crítico em aplicações de segurança.

---

## Parte 3 – Interpretação de Resultados

16. **Acurácia 95% e Recall 50%:**

* Modelo acerta muito no geral, mas falha em detectar a classe positiva (só encontra metade dos casos).
* Indica problema em base desbalanceada ou foco em acertos da classe majoritária.

17. **De 100 folhas para 15 folhas:**

* Foi aplicada **poda** (provavelmente pós-poda com cost-complexity).
* Impacto: modelo menos complexo, mais generalizável, menor risco de overfitting.

18. **Alto treino, baixo teste:**

* Problema de **overfitting** (modelo memorizou o treino).
* Medidas:

  * Poda (no caso de árvores).
  * Regularização ou ajuste de hiperparâmetros.
  * Mais dados ou validação cruzada.

---
---


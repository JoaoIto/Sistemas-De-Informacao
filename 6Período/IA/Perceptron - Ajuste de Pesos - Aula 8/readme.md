# Aula 08 – Perceptron: Ajuste de Pesos

Nesta aula, exploramos como ocorre o **ajuste de pesos em um perceptron**, um ponto fundamental no aprendizado supervisionado.

### Tópicos discutidos:

1. **Funcionamento do Perceptron Simples**:

   * Revisamos o modelo do perceptron proposto por McCulloch e Pitts.
   * Discutimos como as entradas, pesos e bias se combinam para produzir uma saída.
   * Vimos a implementação em **Python** de um perceptron simples, observando passo a passo o fluxo do algoritmo.

2. **Algoritmo de Ajuste de Pesos**:

   * Apresentamos o algoritmo que permite ao perceptron "aprender" a partir de exemplos.
   * O peso é ajustado usando a fórmula:

     $$
     w_i \leftarrow w_i + \eta (y - \hat{y}) x_i
     $$

     Onde:

     * $\eta$ é a taxa de aprendizado,
     * $y$ é a saída esperada,
     * $\hat{y}$ é a saída predita pelo perceptron,
     * $x_i$ é a entrada correspondente.

3. **Limitação do Perceptron com XOR**:

   * Mostramos que o perceptron simples **não consegue resolver o problema lógico XOR**, pois este **não é linearmente separável**.
   * Essa limitação foi o que motivou o avanço para redes neurais mais complexas.

4. **Solução com Múltiplos Perceptrons**:

   * Para resolver o XOR, apresentamos como usar **três perceptrons em conjunto**, formando uma **rede neural simples com uma camada oculta**.
   * Isso introduz a ideia do **Perceptron Multicamadas (MLP)**.

---

## Gravações da Aula

* 🔹 **Parte 1 – 29/03/2025**
  *Funcionamento do perceptron simples e algoritmo de ajuste de pesos*
  [link](https://drive.google.com/file/d/1746w8xr2ks3IGrrjuFDXdgf-9z-dDYOd/view)
* 🔹 **Parte 2 – 29/03/2025**
  *Limitações do perceptron simples e solução com múltiplos perceptrons*
  [link](https://drive.google.com/file/d/1gpl3CeYzil0fXICMNlUJ0dmfE_IVAhvV/view)

---

# Correlação entre Diagrama e Código Perceptron

Para reforçar a compreensão, foi apresentada uma tabela de correspondência entre os **elementos do diagrama clássico de McCulloch & Pitts** e o **código Python implementado em aula**:

| Elemento do Diagrama (McCulloch & Pitts) | Parte correspondente no código Python |
| ---------------------------------------- | ------------------------------------- |
| Entradas $x_1, x_2, ..., x_n$            | `self.X` (lista de entradas)          |
| Pesos $w_1, w_2, ..., w_n$               | `self.weights`                        |
| Bias (ou limiar θ)                       | `self.bias`                           |
| Função somadora (Σ)                      | `np.dot(self.X, self.weights)`        |
| Função de ativação                       | `step_function()`                     |
| Saída $y$                                | Resultado de `predict()`              |
| Atualização de pesos                     | Laço `for` com `self.weights += ...`  |

A imagem abaixo mostra a ligação entre o **diagrama visual**, a **tabela de correspondência** e o **código Python**:
![image](https://github.com/user-attachments/assets/2363e5c3-e8d2-497a-a4b1-9ab1c0042596)

![Imagem: Diagrama vs Código Perceptron](attachment:/mnt/data/f8cc312b-c784-4ea1-8a69-146bbb950b25.png)

---


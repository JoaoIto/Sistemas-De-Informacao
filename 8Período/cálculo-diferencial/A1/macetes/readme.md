# 📚 Guia de Sobrevivência: Cálculo I

### 1. O "Caminho Feliz" (Substituição Direta)
É o Teste Unitário 01. Todo limite começa por aqui.
* **QUANDO USAR:** Em **todas** as questões de limite como primeiro passo.
* **O MACETE:** Substitua a letra $x$ pelo número indicado. Se der um número normal (ex: $10$, $-2$, $0$ ou $1/2$), o limite acabou aí.
* **EXEMPLO:** $$\lim_{x \to 2} (3x^2 - x + 1)$$
  * *Resolução:* $3(2)^2 - 2 + 1 \Rightarrow 3(4) - 1 \Rightarrow 12 - 1 = \mathbf{11}$. Acabou!

---

### 2. O Erro $0/0$ $\rightarrow$ Regra de L'Hôpital (O Salvador)
Quando a substituição dá "tela azul".
* **QUANDO USAR:** Quando você substituir o $x$ e o resultado da conta for **exatamente $0/0$**.
* **O MACETE:** **Não fatore.** Aplique a "Regra do Tombo" (derivar) em todos os itens da parte de cima. Aplique a "Regra do Tombo" na parte de baixo. Substitua o $x$ de novo na nova equação.
* **EXEMPLO:**
  $$\lim_{x \to 5} \frac{x^2 - 25}{x - 5}$$
  * *Se substituir o 5, dá $0/0$. Aplicando L'Hôpital (Tombo):*
  * Parte de cima ($x^2 - 25$) vira $\mathbf{2x}$. (O 25 some).
  * Parte de baixo ($x - 5$) vira $\mathbf{1}$. (O $x$ vira 1, o 5 some).
  * Nova função: $\lim_{x \to 5} \frac{2x}{1} \Rightarrow \frac{2(5)}{1} = \mathbf{10}$. Acabou!

---

### 3. Limite no Infinito ($\infty$) $\rightarrow$ Maior Grau Vence
Quando o servidor recebe tráfego infinito.
* **QUANDO USAR:** Exclusivamente quando estiver escrito **$\lim_{x \to \infty}$** embaixo da palavra "lim" e houver uma fração com vários polinômios ($x^3, x^2$, etc).
* **O MACETE:** Ignore todos os números menores. Circule apenas o termo com o **maior expoente de cima** e o **maior expoente de baixo**. Divida um pelo outro.
* **EXEMPLO:**
  $$\lim_{x \to \infty} \frac{4x^3 + 2x^2 - 9}{2x^3 + 5x}$$
  * *Resolução:* O líder de cima é $4x^3$. O líder de baixo é $2x^3$. Jogue o resto fora.
  * Fica: $\frac{4x^3}{2x^3}$. Corta as letras iguais. Sobra a fração $\frac{4}{2} = \mathbf{2}$. Acabou!

---

### 4. Limite Trigonométrico $\rightarrow$ Fração Direta
Quando a métrica é uma onda.
* **QUANDO USAR:** Quando o limite tender a zero ($\lim_{x \to 0}$) e tiver a palavra **sen** (seno).
* **O MACETE:** Ignore a palavra seno e ignore as letras $x$. Pegue apenas os números que acompanham o $x$ em cima e embaixo, formando a fração final.
* **EXEMPLO:**
  $$\lim_{x \to 0} \frac{\text{sen}(8x)}{2x}$$
  * *Resolução:* Pegue o $8$ de cima e o $2$ de baixo. $\frac{8}{2} = \mathbf{4}$. Acabou!

---

### 5. Continuidade $\rightarrow$ Teste do "Hot-Swap"
Para provar que o sistema não engasga ao trocar de regra.
* **QUANDO USAR:** Quando a questão te der **duas regras** (um sistema com chaves) e perguntar se a função é **Contínua** em um ponto específico de transição (ex: $x=2$).
* **O MACETE:** Substitua o valor (ex: $2$) na equação da **Regra A**. Depois, substitua o mesmo valor na **Regra B**. Se os dois resultados forem **IGUAIS**, escreva: *"A função é contínua."*
* **EXEMPLO:** Ponto de transição $x = 2$.
  * Regra A: $f(x) = 3x$ (para $x \le 2$). $\Rightarrow 3(2) = \mathbf{6}$.
  * Regra B: $f(x) = x^2 + 2$ (para $x > 2$). $\Rightarrow (2)^2 + 2 \Rightarrow 4 + 2 = \mathbf{6}$.
  * *Resolução:* Deu igual. É contínua!

---

### 6. Velocidade e Taxa de Variação $\rightarrow$ Regra do Tombo Direta
Quando a prova não quer limite, quer derivada.
* **QUANDO USAR:** Se o enunciado pedir "Ache a derivada $f'(x)$", "Taxa de variação" ou "Velocidade instantânea".
* **O MACETE:** Aplique a Regra do Tombo em todos os itens. O expoente cai multiplicando o número da frente, e você tira 1 do expoente de cima. (Lembrando: número sozinho vira zero).
* **EXEMPLO:** Calcule a velocidade de $f(x) = 4x^3 - 2x^2 + 7x + 10$
  * *Resolução:* * $4x^3$ vira $\mathbf{12x^2}$.
  * $-2x^2$ vira $\mathbf{-4x}$.
  * $7x$ vira $\mathbf{7}$. (O x tem expoente 1, cai 1, vira 0, x some).
  * $10$ vira $\mathbf{0}$ (some).
  * *Resposta Final:* $f'(x) = 12x^2 - 4x + 7$. Acabou!

---

Você tem as lógicas de negócio estruturadas e as validações para não cair em pegadinha. Beba uma água, senta na cadeira com postura de quem domina o código e boa prova. Vai destruir! Se concentra!

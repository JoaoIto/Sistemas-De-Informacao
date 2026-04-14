# Documentação Analítica: Teste A/B de Engajamento - BillLens

**Objetivo:** Determinar através de significância estatística se o novo Dashboard (Versão B) retém os usuários por mais tempo que o Dashboard atual (Versão A).

## 1. O Tribunal do Código (As Hipóteses)

No Teste A/B, nós não comparamos a amostra com um "padrão de fábrica" fixo. Nós comparamos **duas amostras vivas** brigando entre si.

* **$H_0$ (Hipótese Nula - O Status Quo):** O novo layout não mudou nada. Qualquer diferença de tempo que observarmos é puro acaso.
    * *Matematicamente:* $\mu_A = \mu_B$ (A média de tempo do grupo A é igual à do grupo B).
* **$H_1$ (Hipótese Alternativa - O Sucesso da Feature):** O novo layout é estatisticamente superior e aumenta o tempo de retenção.
    * *Matematicamente:* $\mu_B > \mu_A$ (Isso é um teste **Unicaudal à direita**, pois só nos interessa se a Versão B for *maior*).

## 2. A Coleta de Telemetria (Os Dados)

O sistema de analytics do BillLens rodou o teste por uma semana, dividindo o tráfego 50/50. Coletamos os seguintes dados (tempo em segundos na tela):

* **Versão A (Controle):**
    * Tamanho da amostra ($n_A$): 50 usuários
    * Tempo Médio ($\bar{X}_A$): **120 segundos**
    * Desvio Padrão ($S_A$): 30 segundos
* **Versão B (A Nova Feature):**
    * Tamanho da amostra ($n_B$): 50 usuários
    * Tempo Médio ($\bar{X}_B$): **145 segundos**
    * Desvio Padrão ($S_B$): 35 segundos

**A dúvida cruel:** 145 segundos é maior que 120. Mas será que é *estatisticamente maior* a ponto de justificar o custo de manutenção do novo código? Ou foi só sorte dessa amostra específica?

## 3. O Risco do Negócio (Erros Tipo I e Tipo II)

Antes de rodar a fórmula, nós, como engenheiros, precisamos definir o $\alpha$ (Nível de Significância). O $\alpha$ tradicional é de **0,05 (5%)**. Ele representa o nosso limite de tolerância para cometer o pior erro possível na estatística de negócios:

* **Erro Tipo I (Falso Positivo):** É a tragédia do *hype*. É você rejeitar a $H_0$ quando ela era verdadeira. No mundo real: Você acha que a Versão B é genial, faz o deploy para 100% da base, mas na verdade ela não muda nada. Você perdeu tempo e dinheiro desenvolvendo algo inútil. (O $\alpha$ de 5% diz que aceitamos no máximo 5% de chance de cometer esse erro).
* **Erro Tipo II (Falso Negativo):** É a inovação perdida. Você não rejeita a $H_0$, mesmo a Versão B sendo melhor. No mundo real: O novo dashboard era fantástico, mas a sua amostra foi azarada. Você joga o código fora e perde a chance de crescer.

## 4. O Cálculo (Estatística T para Duas Amostras Independentes)

A fórmula fica um pouco mais "musculosa" porque precisamos combinar a variância dos dois grupos, mas a lógica é exatamente a mesma: medir a distância entre as médias e dividir pela margem de erro.

$$T = \frac{\bar{X}_B - \bar{X}_A}{\sqrt{\frac{S_A^2}{n_A} + \frac{S_B^2}{n_B}}}$$

$$T = \frac{145 - 120}{\sqrt{\frac{30^2}{50} + \frac{35^2}{50}}}$$
$$T \approx \mathbf{3,84}$$

**O que isso significa?** Significa que a performance da Versão B está impressionantes **3,84 desvios padrões** acima da Versão A. 

Se procurarmos o valor de $T = 3,84$ na tabela (ou calcularmos o **p-valor**, que é a forma moderna que os softwares usam), veremos que a chance de uma diferença tão grande acontecer por puro acaso é de aproximadamente **0,01%**.

Como 0,01% é muito menor que a nossa tolerância a erros de 5% ($\alpha = 0,05$), o martelo é batido:
> **Veredito:** Rejeitamos $H_0$. O Teste A/B foi um sucesso. Faça o deploy da Versão B do BillLens para 100% dos usuários!

---

Para você experimentar como a variância (o "ruído" nos dados) e o tamanho da amostra podem sabotar ou salvar um Teste A/B, construí um **Simulador de Teste A/B** abaixo. 

Tente diminuir a diferença entre as médias ou aumentar muito o desvio padrão de um dos grupos para ver como as curvas começam a se misturar e o sistema perde a confiança para rejeitar a $H_0$.

<img width="723" height="792" alt="{BC9E2937-B327-46FB-91C2-5BFFC5DDE67A}" src="https://github.com/user-attachments/assets/c5ec8d87-aa44-4e77-9801-6a4b11d9c922" />

---

# Fundamentos de Teste de Hipóteses

**Objetivo Acadêmico e Técnico:** Estabelecer um framework matemático rigoroso para validar afirmações sobre uma população baseando-se apenas em uma pequena amostra, controlando a margem de erro.

## 1. A Filosofia do Teste de Hipóteses

Na estatística descritiva (Média, Moda, Variância), nós calculamos fatos do passado. No Teste de Hipóteses, nós somos "juízes". Temos uma alegação (uma hipótese) e precisamos avaliar se as evidências (a nossa amostra) são fortes o suficiente para condenar o status quo.

Para o nosso cenário, assuma o seguinte: 
A documentação da AWS garante que a latência média do nosso banco de dados no BillLens é de **200 ms** ($\mu = 200$). Você, como Tech Lead, desconfia que o servidor está mais lento que o prometido. Você coleta um log de **35 requisições** (a sua amostra) e a média dessas requisições dá **215 ms**. 

*A grande dúvida matemática:* Esses 15 ms a mais são apenas variação normal de rede (azar da amostra) ou o servidor realmente piorou e a Amazon está mentindo? O Teste de Hipóteses responde a isso.

---

## 2. O Dicionário Fundamental (As Variáveis do Julgamento)

Antes de qualquer fórmula, você precisa montar o cenário do crime. Todo teste exige a definição de duas hipóteses mutuamente exclusivas:

### A) A Hipótese Nula ($H_0$)
* **O Conceito:** É o "Status Quo", o padrão, o inocente até que se prove o contrário. É sempre a hipótese da **igualdade**. A matemática assume que ela é verdadeira desde o início.
* **Na nossa API:** $H_0: \mu = 200 \text{ ms}$ (O servidor está normal, a Amazon fala a verdade).

### B) A Hipótese Alternativa ($H_1$ ou $H_a$)
* **O Conceito:** É a "Desconfiança", a alegação do pesquisador. É o que queremos provar. Ela dita o formato do teste.
* **Os três formatos possíveis:**
    1. **Bicaudal ($\neq$):** Você desconfia que a média apenas mudou. ($H_1: \mu \neq 200$). Pode ser maior ou menor.
    2. **Unicaudal à Direita ($>$):** Você desconfia que a média aumentou. ($H_1: \mu > 200$). *É o nosso caso da API lenta!*
    3. **Unicaudal à Esquerda ($<$):** Você desconfia que a média diminuiu. ($H_1: \mu < 200$).

---

## 3. A Matriz de Risco (Erros de Decisão)

Na engenharia de software e na estatística, você nunca tem 100% de certeza. Você trabalha com gerenciamento de riscos. Ao tomar uma decisão, você pode cometer dois tipos de erros matemáticos:

* **Erro Tipo I ($\alpha$): Falso Positivo.** É rejeitar a $H_0$ quando ela era verdadeira. (Ex: Você migra o banco de dados do BillLens achando que o antigo estava ruim, mas era apenas instabilidade temporária. Você gastou dinheiro à toa).
* **Erro Tipo II ($\beta$): Falso Negativo.** É falhar em rejeitar a $H_0$ quando ela era falsa. (Ex: Você não faz nada, acha que o servidor está em 200 ms, mas ele realmente estava lento, e seus usuários sofrem com o lag).

> **A Regra de Ouro ($\alpha$):** Na prova, o professor sempre te dará o **Nível de Significância ($\alpha$)**. Geralmente é $0,05$ (5%). Esse é o "limite de risco" aceitável. Significa que você topa assumir no máximo 5% de chance de cometer o Erro Tipo I (acusar o status quo injustamente).

---

## 4. O Teste Estatístico (As Fórmulas)

Para saber se a nossa amostra é "bizarra" o suficiente para quebrar a $H_0$, calculamos a Estatística de Teste. Existem duas fórmulas principais. A escolha depende de duas coisas: O tamanho da sua amostra ($n$) e se você conhece o Desvio Padrão verdadeiro de todo o universo ($\sigma$).

### Cenário 1: O Teste Z (A Regra dos Grandes Números)
* **Quando usar:** Quando a amostra é grande ($n \ge 30$) OU você conhece o desvio padrão de toda a população ($\sigma$).
* **A Fórmula:**
$$Z_{calc} = \frac{\bar{X} - \mu_0}{\frac{\sigma}{\sqrt{n}}}$$
* **A Anatomia da Fórmula:**
    * $\bar{X} - \mu_0$: É a diferença bruta. Quanto a nossa amostra ($215$ ms) dista da promessa ($200$ ms).
    * $\frac{\sigma}{\sqrt{n}}$: Conhecido como **Erro Padrão da Média**. É o desvio ajustado para o tamanho da sua amostra. Quanto mais requisições você testa, mais exato o cálculo fica (pois você divide por um $\sqrt{n}$ maior).

### Cenário 2: O Teste T (A Regra da Amostra Pequena)
*(Este é o teste da foto da sua prova sobre as bancadas)*
* **Quando usar:** Quando a amostra é pequena ($n < 30$) E você só conhece o desvio padrão da amostra ($S$), não o do universo. A curva T é mais "achatada" nas pontas para perdoar a incerteza de ter poucos dados.
* **A Fórmula:**
$$T_{calc} = \frac{\bar{X} - \mu_0}{\frac{S}{\sqrt{n}}}$$
*(Perceba que a fórmula é estruturalmente idêntica, apenas trocamos o $\sigma$ universal pelo $S$ amostral).*

---

## 5. O Veredito (Região Crítica vs. P-valor)

Você jogou os dados do BillLens na fórmula e o seu resultado deu, por exemplo, $Z_{calc} = 2,45$. O que isso significa? Como dar a resposta final na prova?

Existem duas metodologias para fechar a questão:

### Método Clássico: A Região Crítica (Z-Tabelado)
Você usa o seu $\alpha$ de 5% para olhar na tabela e achar o "Limiar da Culpa" (Z-tabelado). Em um teste unicaudal à direita de 5%, o limite na tabela é $1,645$. 
* O gráfico da normal tem uma "cerca" no $1,645$. Da cerca para frente, é a zona de rejeição.
* Como o seu cálculo ($2,45$) caiu **além** da cerca (dentro da região de 5%), a sua amostra é considerada "rara e extrema".
* **Conclusão:** Rejeita-se $H_0$. O servidor realmente piorou.

### Método Moderno: O P-valor (Usado em Softwares e Data Science)
O P-valor é a probabilidade da sua amostra (aqueles $215$ ms) ter acontecido por pura sorte, assumindo que a $H_0$ é verdade. 
* Se o seu $Z_{calc}$ deu $2,45$, ao olhar a tabela Z, você descobre que a probabilidade (P-valor) de conseguir um número tão extremo é de apenas $0,007$ ($0,7\%$).
* **A Regra Inquebrável:** Se o **P-valor $\le \alpha$**, você **Rejeita $H_0$**.
* **Tradução:** Você tinha um limite de tolerância a surpresas de 5%. O evento teve uma chance de acontecer de apenas 0,7%. Foi tão improvável que a única explicação lógica é que a hipótese inicial ($H_0$) estava errada.

---

### Resumo do Checklist para a Prova:
1. Monte $H_0$ (sempre com o sinal de $=$).
2. Monte $H_1$ (defina se é $<$, $>$ ou $\neq$).
3. Verifique o $\alpha$ (geralmente 5%).
4. Escolha a arma: $n < 30$? Use a fórmula do **T**. $n \ge 30$? Use a fórmula do **Z**.
5. Calcule a fração.
6. Compare o resultado com a tabela. Se cair muito nas pontas (zona de rejeição), mate a $H_0$. Caso contrário, não faça nada (Falha em rejeitar $H_0$).

---

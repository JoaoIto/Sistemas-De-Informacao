# Documentação Analítica: Performance da API BillLens

Esta documentação detalha a extração, o preparo e o cálculo das métricas de desempenho do microserviço BillLens (extração de dados de notas fiscais via LLM). O objetivo é fornecer dados limpos e modelados, prontos para consumo por ferramentas de Business Intelligence (BI).

A amostra analisada contém os logs de tempo de processamento de **40 requisições** disparadas para a API.

---

### A Base de Dados Bruta (O Log do Servidor)
Extraímos do servidor apenas as faixas de latência (Classes) e quantas requisições caíram em cada faixa ($f_i$).

| Tempo de Processamento (ms) | Requisições ($f_i$) |
| :--- | :--- |
| $100 \vdash 150$ | 4 |
| $150 \vdash 200$ | 12 |
| $200 \vdash 250$ | 16 |
| $250 \vdash 300$ | 6 |
| $300 \vdash 350$ | 2 |
| **Total** | **$n = 40$** |

---

### Passo 1: Calculando o Tempo Representativo ($x_i$)
* **O que é no contexto da API:** Como temos um intervalo (ex: 100 a 150ms), o banco de dados do BI precisa de um número único que represente o tempo médio daquelas requisições específicas.
* **O Cálculo:** Somamos os limites do intervalo e dividimos por 2.
    * Linha 1: $(100 + 150) / 2 = 125$ ms
    * Linha 2: $(150 + 200) / 2 = 175$ ms
    * Linha 3: $(200 + 250) / 2 = 225$ ms
    * Linha 4: $(250 + 300) / 2 = 275$ ms
    * Linha 5: $(300 + 350) / 2 = 325$ ms

**Tabela Atualizada:**

| Tempo de Processamento | Requisições ($f_i$) | **Tempo Representativo ($x_i$)** |
| :--- | :--- | :--- |
| $100 \vdash 150$ | 4 | **125** |
| $150 \vdash 200$ | 12 | **175** |
| $200 \vdash 250$ | 16 | **225** |
| $250 \vdash 300$ | 6 | **275** |
| $300 \vdash 350$ | 2 | **325** |

---

### Passo 2: Calculando a Carga de Processamento ($x_i \cdot f_i$) e a Média ($\bar{x}$)
* **O que é no contexto da API ($x_i \cdot f_i$):** É o tempo total gasto pela CPU para resolver todas as requisições daquela linha. Multiplicamos o tempo representativo pela quantidade de chamadas.
* **O Cálculo da Coluna:**
    * Linha 1: $125 \cdot 4 = 500$
    * Linha 2: $175 \cdot 12 = 2100$
    * Linha 3: $225 \cdot 16 = 3600$
    * Linha 4: $275 \cdot 6 = 1650$
    * Linha 5: $325 \cdot 2 = 650$
* **Soma Total da Carga:** $500 + 2100 + 3600 + 1650 + 650 = \textbf{8500 ms}$.

**Tabela Atualizada:**

| Tempo de Proc. | $f_i$ | $x_i$ | **Carga ($x_i \cdot f_i$)** |
| :--- | :--- | :--- | :--- |
| $100 \vdash 150$ | 4 | 125 | **500** |
| $150 \vdash 200$ | 12 | 175 | **2100** |
| $200 \vdash 250$ | 16 | 225 | **3600** |
| $250 \vdash 300$ | 6 | 275 | **1650** |
| $300 \vdash 350$ | 2 | 325 | **650** |
| **Total** | **40** | | **$\sum = 8500$** |

**Calculando o Indicador: Tempo Médio de Resposta ($\bar{x}$)**
Com a soma total em mãos, calculamos o SLA médio do nosso microserviço. Dividimos a carga total pelo número de requisições.
$$\bar{x} = \frac{8500}{40} = \textbf{212,5 ms}$$
*(Guarde este valor de 212,5, ele será o coração do cálculo do desvio padrão lá na frente).*

---

### Passo 3: Calculando a Fila de Execução ($F_{ac}$) e a Mediana ($Md$)
* **O que é no contexto da API ($F_{ac}$):** É a ordem acumulada das requisições, da mais rápida para a mais lenta. Serve para acharmos exatamente a requisição que está no meio da fila.
* **O Cálculo da Coluna:** Soma-se o valor da linha atual com o total acumulado até a linha anterior.
    * Linha 1: Inicia com a própria frequência $\rightarrow$ **4**
    * Linha 2: $4 + 12 = \textbf{16}$
    * Linha 3: $16 + 16 = \textbf{32}$
    * Linha 4: $32 + 6 = \textbf{38}$
    * Linha 5: $38 + 2 = \textbf{40}$ (Sempre tem que bater com o total de $n$).

**Tabela Atualizada:**

| Tempo de Proc. | $f_i$ | $x_i$ | $x_i \cdot f_i$ | **Fila ($F_{ac}$)** |
| :--- | :--- | :--- | :--- | :--- |
| $100 \vdash 150$ | 4 | 125 | 500 | **4** |
| $150 \vdash 200$ | 12 | 175 | 2100 | **16** |
| $200 \vdash 250$ | 16 | 225 | 3600 | **32** |
| $250 \vdash 300$ | 6 | 275 | 1650 | **38** |
| $300 \vdash 350$ | 2 | 325 | 650 | **40** |

**Calculando o Indicador: Mediana ($Md$)**
A posição do meio é $n/2 \rightarrow 40/2 = \textbf{20}$. Olhando o $F_{ac}$, a posição 20 cai na **Linha 3 ($200 \vdash 250$)**. Esta é a nossa classe mediana ($l = 200, f_{md} = 16, F_{ant} = 16, h = 50$).
$$Md = l_{md} + \left( \frac{\frac{n}{2} - F_{ant}}{f_{md}} \right) \cdot h$$
$$Md = 200 + \left( \frac{20 - 16}{16} \right) \cdot 50$$
$$Md = 200 + \left( \frac{4}{16} \right) \cdot 50 = 200 + (0,25 \cdot 50) = \textbf{212,5 ms}$$

---

### Passo 4: Calculando a Moda Operacional ($Mo$)
* **O que é no contexto da API:** Qual foi o tempo de extração mais frequente do servidor? Não precisamos de coluna nova, apenas olhamos a tabela atual.
* **Cálculo (Czuber):** A classe com mais requisições é a Linha 3 ($f_i = 16$).
    * $\Delta_1$ (diferença pra anterior): $16 - 12 = 4$
    * $\Delta_2$ (diferença pra posterior): $16 - 6 = 10$
$$Mo = l_{mo} + \left( \frac{\Delta_1}{\Delta_1 + \Delta_2} \right) \cdot h$$
$$Mo = 200 + \left( \frac{4}{4 + 10} \right) \cdot 50$$
$$Mo = 200 + \left( \frac{4}{14} \right) \cdot 50 = 200 + 14,28 = \textbf{214,28 ms}$$

---

### Passo 5: Calculando o Índice de Instabilidade $(x_i - \bar{x})^2 \cdot f_i$ e Desvio Padrão ($S$)
* **O que é no contexto da API:** Mede o peso das variações de tempo. Requisições muito rápidas ou muito lentas geram números grandes, indicando instabilidade no NestJS ou no LLM. Vamos usar a nossa média ($\bar{x} = 212,5$).
* **O Cálculo da Coluna:**
    * Linha 1: $(125 - 212,5)^2 \cdot 4 = (-87,5)^2 \cdot 4 = 7656,25 \cdot 4 = \textbf{30625}$
    * Linha 2: $(175 - 212,5)^2 \cdot 12 = (-37,5)^2 \cdot 12 = 1406,25 \cdot 12 = \textbf{16875}$
    * Linha 3: $(225 - 212,5)^2 \cdot 16 = (12,5)^2 \cdot 16 = 156,25 \cdot 16 = \textbf{2500}$
    * Linha 4: $(275 - 212,5)^2 \cdot 6 = (62,5)^2 \cdot 6 = 3906,25 \cdot 6 = \textbf{23437,5}$
    * Linha 5: $(325 - 212,5)^2 \cdot 2 = (112,5)^2 \cdot 2 = 12656,25 \cdot 2 = \textbf{25312,5}$
* **Soma Total de Instabilidade:** $30625 + 16875 + 2500 + 23437,5 + 25312,5 = \textbf{98750}$.


**Calculando o Indicador: Desvio Padrão ($S$)**
Avaliamos a consistência da API dividindo a instabilidade total pelo total de requisições menos 1 ($n - 1$).
$$S = \sqrt{\frac{\sum f_i(x_i - \bar{x})^2}{n - 1}}$$
$$S = \sqrt{\frac{98750}{39}}$$
$$S = \sqrt{2532,05}$$
**$S \approx 50,32 \text{ ms}$**

**Resumo do Diagnóstico do BillLens:** O servidor processa a leitura de PDFs em **212,5 ms** em média. O comportamento do sistema é previsível e estável, com a maioria das variações ficando na faixa de **$\pm 50,32$ ms**.

---

### Passo 6: Definindo os Marcos de SLA (Quartis e Percentis)
O cálculo destas métricas utiliza a exata mesma lógica da Mediana, apenas mudando a "posição" que estamos buscando na fila de execução ($F_{ac}$).

**A) Primeiro Quartil ($Q_1$): O Top 25%**
* Posição: $\frac{1 \cdot 40}{4} = 10$. A décima requisição mais rápida está na **Linha 2** ($150 \vdash 200$).
* Variáveis da classe: $l = 150$, $F_{ant} = 4$, $f_{q1} = 12$.
$$Q_1 = 150 + \left( \frac{10 - 4}{12} \right) \cdot 50 = 150 + \left(\frac{6}{12}\right) \cdot 50 = 150 + 25 = \textbf{175 ms}$$
* **Conclusão BI:** 25% das extrações do BillLens ocorrem de forma super otimizada, abaixo de 175 ms.

**B) Terceiro Quartil ($Q_3$): O Marco dos 75%**
* Posição: $\frac{3 \cdot 40}{4} = 30$. Cai na **Linha 3** ($200 \vdash 250$).
* Variáveis da classe: $l = 200$, $F_{ant} = 16$, $f_{q3} = 16$.
$$Q_3 = 200 + \left( \frac{30 - 16}{16} \right) \cdot 50 = 200 + \left(\frac{14}{16}\right) \cdot 50 = 200 + 43,75 = \textbf{243,75 ms}$$
* **Conclusão BI:** 75% do tráfego é processado até 243,75 ms. Os 25% restantes formam o grupo de lentidão do servidor.

**C) Percentil 10 ($P_{10}$): O Pico de Velocidade**
* Posição: $\frac{10 \cdot 40}{100} = 4$. Cai exatamente no limite da **Linha 1** ($100 \vdash 150$).
* Variáveis: $l = 100$, $F_{ant} = 0$, $f_{p10} = 4$.
$$P_{10} = 100 + \left( \frac{4 - 0}{4} \right) \cdot 50 = 100 + 1 \cdot 50 = \textbf{150 ms}$$

**D) Percentil 90 ($P_{90}$): O Limite de Tolerância**
* Posição: $\frac{90 \cdot 40}{100} = 36$. Cai na **Linha 4** ($250 \vdash 300$).
* Variáveis: $l = 250$, $F_{ant} = 32$, $f_{p90} = 6$.
$$P_{90} = 250 + \left( \frac{36 - 32}{6} \right) \cdot 50 = 250 + \left(\frac{4}{6}\right) \cdot 50 = 250 + 33,33 = \textbf{283,33 ms}$$
* **Conclusão BI:** Um alerta deve ser disparado se uma requisição demorar mais que 283,33 ms, pois ela entra nos piores 10% de performance da API.

---

### Passo 7: Análise de Forma da Curva (Assimetria e Curtose)

**A) Coeficiente de Assimetria de Pearson ($As$)**
Avalia para que lado o desempenho do LLM "pesa" mais.
$$As = \frac{3(\bar{x} - Md)}{S}$$
$$As = \frac{3(212,5 - 212,5)}{50,32} = \frac{0}{50,32} = \textbf{0}$$
* **Conclusão BI:** Uma assimetria exatamente igual a **zero** indica que a API do BillLens possui uma latência perfeitamente simétrica. Não há "gargalos fantasmas" repuxando a média para cima ou para baixo. A distribuição do tempo é perfeitamente balanceada em torno do tempo médio de 212,5 ms.

**B) Coeficiente de Curtose ($K$)**
Mede se as requisições estão padronizadas em um tempo específico (Leptocúrtica), muito variadas (Platicúrtica) ou equilibradas (Mesocúrtica = $0,263$).
$$K = \frac{Q_3 - Q_1}{2(P_{90} - P_{10})}$$
$$K = \frac{243,75 - 175}{2(283,33 - 150)} = \frac{68,75}{2 \cdot 133,33} = \frac{68,75}{266,66} \approx \textbf{0,2578}$$
* **Conclusão BI:** Como $0,2578 < 0,263$, a distribuição da API é levemente **Leptocúrtica**. Isso é um cenário positivo: significa que a maior parte dos processamentos de PDF estão muito concentrados próximos à faixa média de 212,5 ms, criando um "pico alto" de constância e previsibilidade no servidor.

---

## 3. Tabela de Fatos Completa

Com todos os passos concluídos, esta é a tabela final processada, cruzando a base bruta com os indicadores de carga e instabilidade.

| Clusters de Latência (ms) | Requisições ($f_i$) | Tempo Representativo ($x_i$) | Volume Acumulado ($F_{ac}$) | Carga de Processamento ($x_i \cdot f_i$) | Índice de Instabilidade ($(x_i - \bar{x})^2 \cdot f_i$) |
| :--- | :--- | :--- | :--- | :--- | :--- |
| $100 \vdash 150$ | 4 | 125 | 4 | $125 \cdot 4 = \textbf{500}$ | $(-87,5)^2 \cdot 4 = \textbf{30625}$ |
| $150 \vdash 200$ | 12 | 175 | 16 | $175 \cdot 12 = \textbf{2100}$ | $(-37,5)^2 \cdot 12 = \textbf{16875}$ |
| $200 \vdash 250$ | 16 | 225 | 32 | $225 \cdot 16 = \textbf{3600}$ | $(12,5)^2 \cdot 16 = \textbf{2500}$ |
| $250 \vdash 300$ | 6 | 275 | 38 | $275 \cdot 6 = \textbf{1650}$ | $(62,5)^2 \cdot 6 = \textbf{23437,5}$ |
| $300 \vdash 350$ | 2 | 325 | 40 | $325 \cdot 2 = \textbf{650}$ | $(112,5)^2 \cdot 2 = \textbf{25312,5}$ |
| **Totais** | **$n = 40$** | | | **$\sum = 8500$** | **$\sum = 98750$** |

**Resumo de Indicadores KPI - BillLens:**
* SLA Médio ($\bar{x}$): 212,5 ms
* Tempo Mediano ($Md$): 212,5 ms
* Moda Operacional ($Mo$): 214,28 ms
* Margem de Variação ($S$): $\pm 50,32$ ms
* Top 25% mais rápidos ($Q_1$): $< 175$ ms
* Cauda crítica 10% mais lentos ($P_{90}$): $> 283,33$ ms
* Viés Operacional ($As$): Simetria Perfeita (0)
* Concentração de Tráfego ($K$): Leptocúrtica (0,2578)

---
## 1. Dicionário de Variáveis (Contexto da API)

Para estruturar o banco de dados do BI, as variáveis estatísticas brutas foram traduzidas para as métricas de negócio do BillLens:

* **Classes ($i$)**: Os "clusters" ou faixas de latência da API. Agrupa as requisições em intervalos de tempo de processamento (em milissegundos).
* **$h$ (Amplitude)**: É o tamanho do intervalo de latência. Na nossa API, os clusters variam de 50 em 50 milissegundos ($h = 50$).
* **$f_i$ (Frequência Simples)**: O número exato de chamadas à API (requisições) que finalizaram a extração do JSON dentro daquela faixa de latência específica.
* **$x_i$ (Ponto Médio)**: O tempo de processamento representativo do cluster. Como o BI precisa de um número único para cruzar dados (e não de uma faixa de tempo), usamos o meio exato do intervalo para representar todas as requisições daquele grupo.
* **$F_{ac}$ (Frequência Acumulada)**: O volume acumulado de requisições resolvidas até um determinado teto de latência. É a "fila de execução" do servidor, da resposta mais rápida para a mais lenta.
* **$x_i \cdot f_i$**: O tempo total de processamento (carga) consumido pelo servidor para resolver todas as requisições de um cluster específico.
* **$(x_i - \bar{x})^2 \cdot f_i$**: O índice de instabilidade de cada cluster. Mede o peso da variação de tempo dessas requisições em relação ao tempo médio geral do servidor.
* **Quartis ($Q_1$ e $Q_3$)**: Os marcos de SLA fracionados. $Q_1$ define o teto de latência dos 25% usuários com a resposta mais rápida. $Q_3$ marca onde começam os 25% de requisições mais lentas.
* **Percentis ($P_{10}$ e $P_{90}$)**: As margens extremas. $P_{10}$ é a performance máxima (Top 10% mais rápidos). $P_{90}$ é o limite crítico que engloba 90% das requisições, isolando os 10% de chamadas mais problemáticas (a cauda de latência).
* **Assimetria ($As$)**: O viés do servidor. Mostra se a API tem uma tendência a processar notas fiscais mais rápido ou mais devagar do que a média esperada.
* **Curtose ($K$)**: O nível de aglomeração de dados. Mede se as requisições acontecem quase sempre no mesmo tempo (pico alto) ou se são totalmente aleatórias e dispersas (curva achatada).

---

## 2. Tabela de Fatos (Modelagem de Dados)

Esta é a tabela de trabalho completa, com todos os dados processados e prontos para alimentar as fórmulas e os painéis do BI.

| Clusters de Latência (ms) | Requisições ($f_i$) | Tempo Representativo ($x_i$) | Volume Acumulado ($F_{ac}$) | Carga de Processamento ($x_i \cdot f_i$) | Índice de Instabilidade ($(x_i - \bar{x})^2 \cdot f_i$) |
| :--- | :--- | :--- | :--- | :--- | :--- |
| $100 \vdash 150$ | 4 | 125 | 4 | $125 \cdot 4 = \textbf{500}$ | $(-87,5)^2 \cdot 4 = \textbf{30625}$ |
| $150 \vdash 200$ | 12 | 175 | 16 | $175 \cdot 12 = \textbf{2100}$ | $(-37,5)^2 \cdot 12 = \textbf{16875}$ |
| $200 \vdash 250$ | 16 | 225 | 32 | $225 \cdot 16 = \textbf{3600}$ | $(12,5)^2 \cdot 16 = \textbf{2500}$ |
| $250 \vdash 300$ | 6 | 275 | 38 | $275 \cdot 6 = \textbf{1650}$ | $(62,5)^2 \cdot 6 = \textbf{23437,5}$ |
| $300 \vdash 350$ | 2 | 325 | 40 | $325 \cdot 2 = \textbf{650}$ | $(112,5)^2 \cdot 2 = \textbf{25312,5}$ |
| **Totais** | **$n = 40$** | | | **$\sum = 8500$** | **$\sum = 98750$** |

*(Nota: O valor de $\bar{x} = 212,5$, necessário para calcular a última coluna, foi obtido no Passo 3.1).*

<img width="730" height="493" alt="{8161AF50-3F7B-4F68-8BE8-A708E3B427B2}" src="https://github.com/user-attachments/assets/bfd1fcb3-d680-4298-850b-fd1e013f9a93" />
<img width="659" height="660" alt="{906FAC96-89F2-4999-BEDF-6D0C62F0A6E9}" src="https://github.com/user-attachments/assets/9fdd9a8a-0d17-4403-8cb1-afe3a2165d1b" />


---

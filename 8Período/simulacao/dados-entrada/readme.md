# Dados de Entrada

A modelagem e o tratamento dos dados de entrada constituem a etapa empírica fundamental para assegurar a representatividade e a validade estatística de um modelo de Simulação de Eventos Discretos. O processo divide-se em três etapas canônicas: **Coleta**, **Tratamento** e **Inferência**.

---

## 1. Etapa 1: Coleta e Seleção das Variáveis de Estudo

### Diretrizes Metodológicas de Coleta

* **Escolha da Variável Correta:** Devem ser coletadas exclusivamente as variáveis primitivas e independentes que regem o comportamento do sistema (ex.: intervalos de tempo entre chegadas sucessivas de clientes e tempos de atendimento por posto de trabalho). Variáveis que representam saídas ou respostas do sistema (como tamanho da fila e tempo total de permanência) não devem ser coletadas como entradas.


* **Dimensionamento Amostral ($n$):** O tamanho recomendado da amostra situa-se entre $100$ e $200$ observações. Amostras com $n < 100$ comprometem a discriminação do modelo probabilístico correto, enquanto amostras com $n > 200$ agregam ganhos estatísticos marginais não justificáveis operacionalmente.


* **Preservação da Ordem Cronológica:** Os dados devem ser registrados exatamente na sequência temporal em que o fenômeno ocorre para permitir testes posteriores de autocorrelação e dependência serial.


* **Controle de Não-Estacionariedade:** Caso haja suspeita de que os parâmetros variem em função de faixas horárias, turnos ou dias da semana, a coleta deve ser estratificada e avaliada estatisticamente.



---

## 2. Etapa 2: Tratamento de Dados, Outliers e Autocorrelação

### Medidas Descritivas e Sensibilidade

* **Medidas de Posição:** Média ($\bar{X}$), Mediana ($Md$), Moda ($Mo$), Mínimo e Máximo.


* **Medidas de Dispersão:** Amplitude total ($A = \text{Máximo} - \text{Mínimo}$), Desvio-Padrão ($S$), Variância amostral ($S^2$), Coeficiente de Variação ($CV$) e Coeficiente de Assimetria.



### Tratamento de Outliers (Valores Discrepantes)

Outliers decorrem prioritariamente de erros humanos de coleta/digitação ou de ocorrências raras atípicas do processo operacional. Eles impactam severamente a média e a variância amostral, enquanto a mediana preserva sua robustez estrutural.

* **Identificação por Boxplot:**
Calcula-se o Intervalo Interquartil ($IQR = Q_3 - Q_1$). Os limites para expurgo ou retenção de valores são delimitados pelas cercas:



$$\text{Limite Inferior} = Q_1 - 1,5 \cdot IQR$$


$$\text{Limite Superior} = Q_3 + 1,5 \cdot IQR$$



Qualquer observação fora do intervalo $[Q_1 - 1,5 \cdot IQR, \; Q_3 + 1,5 \cdot IQR]$ é classificada como outlier.



### Análise de Autocorrelação (Independência Temporal)

Para validar o pressuposto de que os dados são variáveis aleatórias independentes e identicamente distribuídas (i.i.d.), constrói-se o diagrama de dispersão entre pares defasados ($x_k$ contra $x_{k+1}$):

* **Ausência de Correlação:** Pontos espalhados aleatoriamente sem padrão geométrico aparente.


* **Presença de Correlação:** Pontos alinhados em trajetórias lineares ou padrões direcionais, indicando dependência que exige modelagem via séries temporais ou submodelos autoregressivos.



---

## 3. Etapa 3: Inferência e Ajuste de Distribuições Teóricas

```
┌─────────────────────────────────────────────────────────┐
│              Amostra de Dados Coletados                 │
└────────────────────────────┬────────────────────────────┘
                             │
                             ▼
┌─────────────────────────────────────────────────────────┐
│     Histograma de Frequências (Regra de Sturges)        │
└────────────────────────────┬────────────────────────────┘
                             │
                             ▼
┌─────────────────────────────────────────────────────────┐
│    Seleção de Candidatas Teóricas (Exponencial,         │
│         Normal, Triangular, Weibull, etc.)              │
└────────────────────────────┬────────────────────────────┘
                             │
                             ▼
┌─────────────────────────────────────────────────────────┐
│   Testes de Aderência Não-Paramétricos (Qui-Quadrado,   │
│                 Kolmogorov-Smirnov)                     │
└─────────────────────────────────────────────────────────┘

```

### Construção do Histograma de Frequências

O histograma subsidia a identificação visual preliminar da curva de densidade:

1. **Número de Classes ($K$):** Determinado pela fórmula de Sturges ou pela raiz da amostra:



$$K = 1 + 3,3 \cdot \log_{10}(n) \quad \text{ou} \quad K = \sqrt{n}$$


2. **Largura de Classe ($h$):**

$$h = \frac{\text{Amplitude}}{K}$$



### Catálogo de Distribuições e Critérios de Modelagem

A seleção de uma distribuição teórica apoia-se nas propriedades matemáticas da variável ou no conhecimento prévio dos especialistas operacionais:

| Distribuição | Parâmetros | Características da Curva | Aplicabilidade Típica |
| --- | --- | --- | --- |
| **Exponencial** | Média ($\mu = 1/\lambda$) | | Variância alta, cauda longa à direita, sem memória. | Tempos entre chegadas sucessivas e tempos até falhas de equipamentos. |
| **Triangular** | Mínimo ($a$), Moda ($m$), Máximo ($b$) | Simétrica ou assimétrica, suporte estritamente finito $[a, b]$. |Cenários com ausência de dados históricos onde especialistas estimam limites e o valor mais frequente. |
| **Normal** | Média ($\mu$), Desvio-Padrão ($\sigma$) | Formato de sino perfeitamente simétrico, variação controlada por $\sigma$. | Processos manuais ou tarefas cujo tempo total corresponde à soma de subprocessos (Teorema Central do Limite).
| **Uniforme** | Mínimo ($a$), Máximo ($b$) | Densidade constante $f(x) = \frac{1}{b-a}$; todos os valores no intervalo são equiprováveis.| Total desconhecimento do comportamento interno além dos limites físicos (cenário de pior caso).|
| **Discreta** | Vetor de valores $\{x_i\}$ e probabilidades $\{p_i\}$<br> | Assume estritamente o conjunto finito de valores mapeados. | Atribuição de parâmetros a entidades e roteamento probabilístico (ex.: 30% balcão, 70% prateleiras). 
| **Outras (Erlang, Gama, Weibull, Lognormal, Poisson, Beta)** | Parâmetros de forma ($\alpha, k$), escala ($\beta, \lambda$) e localização | Flexibilidade em taxas de falhas monotônicas ou curvas assimétricas não exponenciais. | Tempos de reparo complexos, processos químicos e taxas de fluxo multietapas. |

---

## 4. Testes de Aderência e Decisão Estatística

Os testes não-paramétricos avaliam formalmente se a amostra empírica é estatisticamente consistente com a distribuição de probabilidade postulada.

### Formulação das Hipóteses

* **Hipótese Nula ($H_0$):** O modelo probabilístico teórico escolhido é adequado para representar os dados da população.


* **Hipótese Alternativa ($H_a$):** O modelo probabilístico teórico não é adequado para representar a população.



### O Teste do Qui-Quadrado ($\chi^2$)

Calcula o desvio quadrático padronizado entre as frequências observadas no histograma ($O_i$) e as frequências teóricas esperadas ($T_i$) sob a distribuição hipotetizada:


$$\chi^2_{\text{calc}} = \sum_{i=1}^{K} \frac{(O_i - T_i)^2}{T_i}$$

* **Regra de Decisão:** Rejeita-se $H_0$ ao nível de significância $\alpha$ se $\chi^2_{\text{calc}} > \chi^2_{\text{crítico}, \nu}$, onde $\nu = K - p - 1$ representa os graus de liberdade ($p$ sendo o número de parâmetros estimados).



### Critério de Decisão por $P\text{-value}$

O $p\text{-value}$ mensura a probabilidade de se obter uma estatística de teste tão ou mais extrema que a observada, sob a condição de $H_0$ ser verdadeira:

| Faixa do $p\text{-value}$ | Interpretação Estatística | Decisão sobre $H_0$ |
| --- | --- | --- |
| **$p\text{-value} < 0,01$** | Evidência forte contra a hipótese de aderência. | Rejeita-se $H_0$. |
| **$0,01 \le p\text{-value} < 0,05$** | Evidência moderada contra a hipótese de aderência. | Rejeita-se $H_0$ a $\alpha = 0,05$. |
| **$0,05 \le p\text{-value} < 0,10$** | Evidência potencial contra a hipótese de aderência. | Região marginal de incerteza.|
| **$p\text{-value} \ge 0,10$** | Evidência fraca ou inexistente contra a hipótese de aderência. | Não se rejeita $H_0$ (modelo aprovado).|

# Documentação Analítica: Previsão de Latência via Regressão Linear

Nesta documentação, vamos sair da estatística descritiva (que apenas olha para o passado) e entrar na estatística preditiva. O objetivo é criar um modelo matemático que nos permita **prever o comportamento futuro** de uma API.

**O Cenário (O Problema de Negócio):**
Você está otimizando o endpoint de upload de arquivos do microserviço BillLens. Você tem a hipótese de que o **Tamanho do Arquivo PDF ($X$, em KB)** está diretamente ligado ao **Tempo de Latência da API ($Y$, em milissegundos)**. 

Queremos provar se essa relação existe (Correlação) e criar uma fórmula para prever quanto tempo um arquivo gigante vai demorar para ser processado *antes* mesmo de o usuário fazer o upload (Regressão Linear).

Separamos uma pequena amostra de 5 requisições de teste para validar o modelo.

---

## 1. Dicionário de Variáveis (Contexto da API)

* **Variável Independente ($X$)**: O Tamanho do Payload (PDF) em KB. É a causa.
* **Variável Dependente ($Y$)**: A Latência em ms. É o efeito (o tempo depende do tamanho).
* **$X \cdot Y$ (Produto cruzado)**: O cruzamento do tamanho com o tempo, usado para achar a inclinação da reta.
* **$X^2$ e $Y^2$ (Quadrados)**: Penalizam valores muito altos nas fórmulas estatísticas, ajudando a traçar a linha perfeita no meio dos dados.
* **Coeficiente de Correlação ($r$)**: Mede a "força" da culpa. O tamanho do arquivo é realmente o culpado pela lentidão? (Varia de -1 a +1).
* **Coeficiente Angular ($a$)**: A taxa de degradação. Para cada 1 KB a mais no arquivo, quantos milissegundos a API perde?
* **Coeficiente Linear ($b$)**: O "Custo Fixo" da API. Quanto tempo a API demora para responder mesmo se o arquivo for quase vazio (Latência de rede + Autenticação)?

---

## 2. A Tabela de Trabalho (Preparando os Dados)

A regra de ouro da estatística bivariada: **nunca encoste na fórmula antes de fechar a tabela**. Vamos pegar as 5 requisições e calcular os quadrados e o produto.

| Requisição | Tamanho do PDF ($X$) | Latência da API ($Y$) | $X \cdot Y$ | $X^2$ | $Y^2$ |
| :--- | :--- | :--- | :--- | :--- | :--- |
| Req 1 | 10 KB | 120 ms | $10 \cdot 120 = \textbf{1200}$ | $10^2 = \textbf{100}$ | $120^2 = \textbf{14400}$ |
| Req 2 | 20 KB | 150 ms | $20 \cdot 150 = \textbf{3000}$ | $20^2 = \textbf{400}$ | $150^2 = \textbf{22500}$ |
| Req 3 | 30 KB | 210 ms | $30 \cdot 210 = \textbf{6300}$ | $30^2 = \textbf{900}$ | $210^2 = \textbf{44100}$ |
| Req 4 | 40 KB | 240 ms | $40 \cdot 240 = \textbf{9600}$ | $40^2 = \textbf{1600}$ | $240^2 = \textbf{57600}$ |
| Req 5 | 50 KB | 280 ms | $50 \cdot 280 = \textbf{14000}$ | $50^2 = \textbf{2500}$ | $280^2 = \textbf{78400}$ |
| **Totais ($n=5$)**| **$\sum X = 150$** | **$\sum Y = 1000$** | **$\sum XY = 34100$** | **$\sum X^2 = 5500$** | **$\sum Y^2 = 217000$** |

*(Dica: Calcule também as médias agora, pois vamos usar na Regressão: $\bar{X} = 150/5 = \textbf{30}$ e $\bar{Y} = 1000/5 = \textbf{200}$).*

---

## 3. Passo a Passo: Coeficiente de Correlação de Pearson ($r$)

**Objetivo:** Provar matematicamente que a lentidão tem relação com o tamanho do arquivo.

$$r = \frac{n \cdot \sum XY - (\sum X) \cdot (\sum Y)}{\sqrt{[n \cdot \sum X^2 - (\sum X)^2] \cdot [n \cdot \sum Y^2 - (\sum Y)^2]}}$$

**Substituindo os valores da nossa tabela:**
$$r = \frac{5 \cdot (34100) - (150) \cdot (1000)}{\sqrt{[5 \cdot (5500) - (150)^2] \cdot [5 \cdot (217000) - (1000)^2]}}$$

**Resolvendo a parte de cima (Numerador):**
$$5 \cdot 34100 = 170500$$
$$150 \cdot 1000 = 150000$$
$$\text{Numerador} = 170500 - 150000 = \textbf{20500}$$

**Resolvendo a parte de baixo (Raiz / Denominador):**
* *Parte do X:* $[27500 - 22500] = \textbf{5000}$
* *Parte do Y:* $[1085000 - 1000000] = \textbf{85000}$
$$\text{Raiz} = \sqrt{5000 \cdot 85000}$$
$$\text{Raiz} = \sqrt{425000000} \approx \textbf{20615,52}$$

**A Divisão Final:**
$$r = \frac{20500}{20615,52} \approx \textbf{0,994}$$

> **Conclusão BI:** Temos um $r = 0,994$. Isso indica uma **Correlação Positiva Quase Perfeita**. O tamanho do PDF é, de fato, o principal responsável pela latência da API. Podemos avançar com segurança para a criação do modelo preditivo.

---

## 4. Passo a Passo: O Modelo de Regressão Linear ($y = ax + b$)

Agora que sabemos que a relação é forte, vamos criar a fórmula que o servidor poderá usar para prever a latência. Precisamos achar a "taxa de degradação" ($a$) e o "custo fixo de rede" ($b$).

### A) Calculando a Taxa de Degradação ($a$)
A fórmula de $a$ é apenas a parte de cima do Pearson, dividida pela parte do $X$ do denominador (sem a raiz).
$$a = \frac{n \cdot \sum XY - (\sum X) \cdot (\sum Y)}{n \cdot \sum X^2 - (\sum X)^2}$$

Nós já resolvemos esses blocos no passo anterior!
$$a = \frac{20500}{5000} = \textbf{4,1}$$
> **O que isso significa:** Para cada **1 KB extra** no tamanho do PDF, o processamento da API fica **4,1 milissegundos mais lento**. Essa é a inclinação da sua reta.

### B) Calculando o Custo Fixo da API ($b$)
O coeficiente linear usa as médias que calculamos no final da tabela ($\bar{X} = 30$, $\bar{Y} = 200$) e o valor de $a$.
$$b = \bar{Y} - a \cdot \bar{X}$$
$$b = 200 - (4,1 \cdot 30)$$
$$b = 200 - 123 = \textbf{77}$$
> **O que isso significa:** O valor **77 ms** é o nosso intercepto. Isso significa que, mesmo que o PDF tenha 0 KB (teoricamente), a requisição levará 77 milissegundos só para bater na rota do NestJS, passar pelos middlewares e retornar.

### C) A Equação Preditiva Final
Substituindo $a$ e $b$ na equação geral da reta:
**$$Y = 4,1X + 77$$**

---

## 5. Aplicando o Modelo (A Previsão)

Você instalou um monitoramento e percebeu que um usuário está tentando fazer o upload de um arquivo pesado de **85 KB** ($X = 85$). 

Qual é a latência prevista ($Y$) que essa requisição vai gerar no servidor?

$$Y = 4,1 \cdot (85) + 77$$
$$Y = 348,5 + 77$$
**$$Y = 425,5 \text{ ms}$$**

> **Conclusão Operacional:** Antes mesmo do arquivo ser totalmente carregado na memória, o seu sistema já sabe estatisticamente que levará cerca de 425,5 ms para processá-lo. Você pode usar essa métrica para definir *timeouts* dinâmicos no Axios ou para exibir uma barra de progresso mais inteligente no frontend.


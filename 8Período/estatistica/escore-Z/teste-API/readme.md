# Documentação Analítica: Comportamento de Reservas - BookSports - ***escore-Z***

**Objetivo:** Analisar a antecedência com que os usuários reservam as quadras para prever horários ociosos e criar campanhas de precificação dinâmica (descontos de última hora).

## 1. O Cenário (A Distribuição Normal)

Após analisarmos milhares de reservas no sistema, descobrimos que o tempo de antecedência (em horas) com que um cliente agenda uma quadra forma uma **Curva Normal perfeita** (o famoso formato de sino). 

A maioria das pessoas reserva perto do tempo médio, e poucos reservam muito em cima da hora ou com meses de antecedência.

**Nossos Parâmetros do Sistema:**
* **Média ($\mu$):** **48 horas** (A média geral é reservar a quadra 2 dias antes).
* **Desvio Padrão ($\sigma$):** **12 horas** (A margem típica de variação do nosso público).

---

## 2. O Conceito: Escore Z (A Régua Universal)

Como você explica para a equipe técnica como medir se uma reserva é "normal" ou "fora da curva"?

* **O Conceito:** O Escore Z é uma ferramenta de conversão. Ele transforma qualquer número do mundo real (horas, reais, idades) em **"Desvios Padrões de distância da Média"**. Se o Escore Z for $0$, o comportamento é exatamente a média. Se for negativo, está abaixo; se positivo, está acima.
* **A Fórmula:** $$Z = \frac{X - \mu}{\sigma}$$
*(Onde $X$ é o valor que queremos investigar).*

---

## 3. Aplicação Prática (Decisões de Negócio)

### A) Risco de Quadra Vazia (Reservas de Última Hora)
* **A Pergunta de Negócio:** "Qual é a probabilidade de uma quadra só ser alugada com **menos de 24 horas** de antecedência? Precisamos saber isso para ativar o robô de descontos."
* **O Cálculo do Z:**
$$Z = \frac{24 - 48}{12} = \frac{-24}{12} = \mathbf{-2,0}$$
* **A Tradução:** "Uma reserva feita 24h antes está a exatamente 2 desvios padrões abaixo do nosso comportamento médio."
* **A Probabilidade (Tabela Z):** Olhando o Z de $-2,0$, encontramos $\approx \mathbf{2,28\%}$.

> **Decisão de Negócio:** Apenas 2,28% das reservas ocorrem com menos de 24 horas de antecedência de forma orgânica. Logo, se uma quadra estiver vazia faltando 24 horas para o jogo, a chance dela ser alugada naturalmente é minúscula. O sistema deve disparar automaticamente um alerta de "Promoção Relâmpago de 30% OFF" para salvar a receita desse horário.

### B) Previsibilidade Financeira (Reservas Antecipadas)
* **A Pergunta de Negócio:** "Queremos premiar os clientes mais previsíveis. Qual a porcentagem de reservas feitas com **mais de 66 horas** de antecedência?"
* **O Cálculo do Z:**
$$Z = \frac{66 - 48}{12} = \frac{18}{12} = \mathbf{1,5}$$
* **A Probabilidade (Tabela Z):** O valor acumulado para $1,5$ é $0,9332$ (93,32% estão abaixo disso). Como queremos quem reserva com *mais* tempo, calculamos o complemento: $100\% - 93,32\% = \mathbf{6,68\%}$.

> **Decisão de Negócio:** Apenas 6,68% das reservas são super antecipadas. Podemos criar o programa "Sócio Planejador", onde esse seleto grupo ganha pontos de fidelidade em dobro, garantindo fluxo de caixa adiantado para a empresa.

---

Para que você possa visualizar a dinâmica do Escore Z e da Curva Normal na prática, e até mesmo simular outros cenários do BookSports, gerei um **Simulador de Escore Z** abaixo. Você pode ajustar a média de horas, o desvio padrão e o tempo alvo da reserva para ver como a probabilidade se comporta graficamente.

<img width="719" height="536" alt="{282F13A4-B49B-456C-A9C9-37A69B10D2E8}" src="https://github.com/user-attachments/assets/0e111e59-bc30-4f5e-9f29-ecfceabb292c" />

---

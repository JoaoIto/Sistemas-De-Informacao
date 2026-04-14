# Padronização e Análise de Anomalias (Escore Z)

**Objetivo Técnico:** Utilizar a métrica de Escore Z ($Z$) para padronizar conjuntos de dados de naturezas diferentes, permitindo a comparação direta e a identificação estatística de valores atípicos (*outliers*) no sistema.

## 1. O Problema de Negócio (Comparando Maçãs com Laranjas)
Em um ambiente de tecnologia, frequentemente precisamos comparar métricas que possuem escalas totalmente diferentes. 
* **Exemplo:** Como um Tech Lead pode definir qual servidor está em estado mais crítico?
    * **Servidor A (Banco de Dados):** Consumo de CPU está em **85%**.
    * **Servidor B (Fila de Mensagens):** Consumo de Memória está em **12 GB**.

Não podemos comparar "85%" com "12 GB" diretamente. Precisamos de uma métrica que traduza ambas as grandezas para uma mesma linguagem. O Escore Z é essa ferramenta de tradução.

## 2. O Conceito Base: A Régua Universal
O Escore Z converte qualquer valor absoluto em uma métrica relativa chamada **"Distância em Desvios Padrões"**. 
Ele não mede mais "quantos GBs" ou "quantos milissegundos", ele mede exclusivamente **quantos passos aquele valor está distante da sua própria normalidade (média)**.

* Um Escore $Z = 0$ significa que o sistema está operando exatamente na média histórica.
* Um Escore $Z$ positivo significa que o valor está acima da média.
* Um Escore $Z$ negativo significa que o valor está abaixo da média.

## 3. Dissecando a Fórmula
A fórmula matemática para calcular o Escore Z possui apenas três variáveis.

$$Z = \frac{X - \mu}{\sigma}$$

* **$X$ (Valor Alvo / Amostra):** É o dado específico que você capturou agora e quer investigar (Ex: O pico de uso de memória de hoje).
* **$\mu$ (Média da População):** É o comportamento histórico normal daquele sistema. O centro da curva.
* **$\sigma$ (Desvio Padrão):** É o nível de instabilidade ou variação natural do sistema. É o que chamamos de "tamanho do passo".

## 4. Estudo de Caso (Passo a Passo)
Vamos aplicar a fórmula para resolver o problema dos servidores citado no tópico 1. Queremos descobrir qual deles está com a pior anomalia no momento.

### A) Análise do Servidor A (CPU do Banco de Dados)
* **Histórico do Servidor:** A Média ($\mu$) é de 65% de uso, com Desvio Padrão ($\sigma$) de 5%.
* **O Alerta Atual ($X$):** Bateu **85%** de uso.
* **O Cálculo:**
$$Z_A = \frac{85 - 65}{5} = \frac{20}{5} = \mathbf{+4,0}$$
> **Tradução:** O Servidor A está operando 4 desvios padrões acima do seu normal.

### B) Análise do Servidor B (Memória da Fila)
* **Histórico do Servidor:** A Média ($\mu$) é de 6 GB, com Desvio Padrão ($\sigma$) de 3 GB.
* **O Alerta Atual ($X$):** Bateu **12 GB** de uso.
* **O Cálculo:**
$$Z_B = \frac{12 - 6}{3} = \frac{6}{3} = \mathbf{+2,0}$$
> **Tradução:** O Servidor B está operando 2 desvios padrões acima do seu normal.

### C) A Decisão Técnica
Embora 12 GB pareça um número muito maior e mais assustador que 85%, a estatística prova o contrário. O Servidor A ($Z = +4,0$) está sofrendo uma anomalia muito mais grave e extrema do que o Servidor B ($Z = +2,0$). A equipe de infraestrutura deve priorizar o Servidor A imediatamente.

## 5. Regras de Interpretação (Tabela Z e Probabilidade)
O número final do Z também serve como um "endereço" para buscar a probabilidade daquele evento em uma Tabela de Distribuição Normal (Tabela Z). 

Na estatística de sistemas (Regra Empírica de Gauss), nós interpretamos o Z da seguinte forma para criar alertas automáticos no código:

* **De $-1,0$ a $+1,0$ (Zona Verde):** Normalidade absoluta. Cerca de 68% de todos os dados do sistema caem aqui. Não faça nada.
* **De $+1,0$ a $+2,0$ (Zona Amarela):** Atenção. O comportamento está começando a sair do padrão (acontece em 27% dos casos).
* **De $+2,0$ a $+3,0$ (Zona Laranja):** Alerta. Comportamento raro (acontece em menos de 5% dos casos). Pode indicar lentidão ou uso pesado.
* **Acima de $+3,0$ ou Abaixo de $-3,0$ (Zona Vermelha / *Outlier*):** Anomalia crítica (acontece em menos de 0,3% dos casos). É o caso do nosso Servidor A ($Z = 4,0$). No código, um limite de $Z > 3$ é frequentemente usado como gatilho matemático para acionar *Auto Scaling* (subir mais máquinas) ou bloquear transações suspeitas (antifraude).

---

# Análise Gráfica:

<img width="728" height="514" alt="{845D27A1-D764-4AAE-BF5E-CD7AC23C054B}" src="https://github.com/user-attachments/assets/60218f0c-d417-4a36-a0f6-40434b7637f0" />

---

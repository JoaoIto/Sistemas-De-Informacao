# 🛠️ **Engenharia da Qualidade: FMEA e FTA – Prevenção e Análise de Falhas**

## 📍 Introdução

Na busca contínua por **qualidade, confiabilidade e segurança**, a engenharia moderna adota ferramentas robustas para a **prevenção de falhas e análise de riscos**. Duas metodologias se destacam nesse contexto:

- **FMEA (Failure Mode and Effects Analysis)**: método proativo que antecipa modos de falha e seus efeitos  
- **FTA (Fault Tree Analysis)**: método reativo e lógico que busca entender as causas-raiz de uma falha já identificada

Ambas se complementam e são largamente utilizadas nas áreas automotiva, aeroespacial, manufatureira, médica e de software, onde a falha de um componente pode comprometer sistemas inteiros.

---

## 🔹 **FMEA – Análise dos Modos e Efeitos das Falhas**

### ✔️ Conceito

A FMEA é uma abordagem sistemática para **identificar, priorizar e eliminar potenciais falhas** em um produto, processo ou sistema, **antes** que elas ocorram. Avalia três fatores principais:

- **Gravidade (G)**: impacto da falha no cliente ou processo  
- **Ocorrência (O)**: probabilidade de a falha acontecer  
- **Detecção (D)**: chance de a falha ser detectada antes de afetar o cliente

Com esses três valores, calcula-se o **Número de Prioridade de Risco (RPN)**:  
📐 **RPN = G × O × D**

### 📋 Tipos de FMEA

- **FMEA de Projeto (DFMEA)** – aplicada ao design do produto  
- **FMEA de Processo (PFMEA)** – aplicada à produção e operações  
- **FMEA de Sistema (SFMEA)** – usada em sistemas complexos e integrados

### 📈 Benefícios

- Redução de custos por falhas evitadas  
- Aumento da segurança e confiabilidade  
- Identificação proativa de riscos  
- Melhoria contínua do produto e processo

---

## 🔹 **FTA – Análise da Árvore de Falhas**

### ✔️ Conceito

A FTA é uma técnica gráfica e lógica que **mapeia as possíveis causas de uma falha crítica (evento topo)**. A análise se dá em forma de **árvore invertida**, conectando causas com **portas lógicas (AND, OR)** para mostrar como combinações de eventos podem levar à falha principal.

### 🧠 Etapas

1. **Definir o evento topo (falha)**  
2. **Mapear causas imediatas**  
3. **Aplicar lógica (AND/OR)**  
4. **Identificar causas básicas**  
5. **Avaliar probabilidade e impacto**

### 🛡️ Vantagens

- Visualização clara das inter-relações causais  
- Identificação de falhas críticas no sistema  
- Suporte à tomada de decisão para mitigação de riscos  
- Complementar à FMEA em análises mais profundas

---

## 🧠 Estudo de Caso / Exemplo Integrado

### 🧪 **Produto**: Freio de estacionamento eletrônico em um automóvel

#### 📌 Etapa 1 – FMEA

Durante o desenvolvimento, a equipe identifica o **modo de falha**: o freio pode não acionar.

- **Gravidade (G)**: 10 – falha pode causar acidente grave  
- **Ocorrência (O)**: 4 – falha eventual  
- **Detecção (D)**: 6 – dificuldade em detectar o erro antes do uso  

**RPN = 10 × 4 × 6 = 240** → ALTO RISCO

**Ação recomendada**: adicionar redundância eletrônica e sensores de verificação.

#### 📌 Etapa 2 – FTA

Após o produto ir ao mercado, é relatada uma **falha em campo**. A FTA é usada para entender a causa.

**Evento Topo**: freio não acionou.

- **Causa 1 (porta OR)**: Falha no botão de ativação  
- **Causa 2 (porta OR)**: Curto-circuito no sistema elétrico  
- **Causa 3 (porta AND)**: Falha no sensor + falha na unidade de controle

Conclusão: a falha combinada do sensor e da unidade de controle exigiu revisão de projeto e recall.

---

## 🧩 Conclusão

FMEA e FTA são ferramentas **complementares**, utilizadas em momentos distintos do ciclo de vida de um produto:

- **FMEA** atua de forma **preventiva**, antecipando falhas  
- **FTA** é uma abordagem **investigativa**, que aprofunda a análise após a ocorrência de uma falha

Juntas, elas promovem a **excelência em qualidade**, **aumentam a segurança** e **reduzem custos operacionais**.

---

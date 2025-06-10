## 🏭 **Exemplo Aplicado de CEP: Fábrica de Garrafas – "PlastiQuali"**

### 📌 **Contexto da Empresa**

A *PlastiQuali* fabrica garrafas plásticas de 500 ml para indústrias de bebidas. A empresa busca garantir que todas as garrafas tenham o mesmo volume e espessura, evitando perdas por excesso de material ou reclamações por defeito de fabricação.

---

### 🎯 **Objetivo do CEP**

Garantir que a **espessura da parede da garrafa** esteja dentro do limite de tolerância de **1,5 mm ± 0,1 mm**.

---

### ⚙️ **Etapas do Controle Estatístico do Processo**

#### 1. **Coleta de Dados**

* A cada 30 minutos, 5 garrafas são medidas em pontos diferentes da linha de produção.
* Cada valor é registrado em uma planilha de controle.

#### 2. **Cálculo das Estatísticas**

* Média das espessuras coletadas (X̄)
* Amplitude das amostras (R)
* Limites de controle superior (LSC) e inferior (LIC) com base em ±3σ

#### 3. **Construção dos Gráficos**

* Gráfico de **X̄** (monitorar a média do processo)
* Gráfico de **R** (monitorar a variabilidade)

---

### 📊 **Exemplo de Registro de Dados**

| Amostra | 5 Medidas (mm)               | Média (X̄) | Amplitude (R) |
| ------- | ---------------------------- | ---------- | ------------- |
| 1       | 1.50, 1.52, 1.49, 1.51, 1.50 | 1.504      | 0.03          |
| 2       | 1.47, 1.53, 1.51, 1.48, 1.50 | 1.498      | 0.06          |
| 3       | 1.56, 1.54, 1.55, 1.57, 1.52 | 1.548      | 0.05          |

---

### 🚦 **Análise dos Gráficos de Controle**

#### 📈 Situação 1 – Processo sob controle:

* Todas as médias (X̄) estão entre o **LIC = 1.4 mm** e **LSC = 1.6 mm**
* Nenhuma tendência visível ou sequência de pontos no mesmo lado

✅ **A produção segue estável.**

---

#### ⚠️ Situação 2 – Processo fora de controle:

* Uma amostra apresenta X̄ = 1.63 mm (acima do LSC)
* Ou 6 amostras consecutivas estão subindo ou acima da média

🚨 **Indicação de problema! Pode ser desgaste do molde ou falha no aquecimento.**

---

### 🔄 **Ações Tomadas**

* Suspender temporariamente a produção
* Verificar calibragem da extrusora
* Corrigir falha no sensor de temperatura
* Retestar após ajuste

---

### 🧠 **Didaticamente, o que aprendemos?**

* O CEP **não espera o defeito acontecer**, ele **previne**.
* Ao monitorar as variações **naturais (causas comuns)** e **anormais (causas especiais)**, é possível:

  * Manter a qualidade
  * Reduzir desperdícios
  * Aumentar a confiabilidade do processo

---

### 🧰 Ferramentas Utilizadas

* **Gráfico de X̄ e R** (controle por variáveis)
* **Histograma** (distribuição dos dados)
* **Diagrama de causa e efeito** (para investigação de falhas)

---

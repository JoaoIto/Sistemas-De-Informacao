# 📌 **Algoritmo Genético: Guia Completo**  

## 🔹 **O que é um Algoritmo Genético?**  

Os **algoritmos genéticos (AGs)** são técnicas de otimização e busca inspiradas no processo de **seleção natural** da biologia. Eles imitam a evolução dos seres vivos para encontrar soluções eficientes para problemas complexos.  

Eles operam em **populações** de possíveis soluções, aplicando operadores genéticos como **seleção, cruzamento e mutação** para melhorar a qualidade das soluções ao longo de várias gerações.  

---

## ⚙️ **Como Funciona um Algoritmo Genético?**  

| **Etapa**        | **Descrição** |
|------------------|--------------|
| **1. Inicialização** | Criamos uma população inicial de indivíduos (soluções possíveis), geralmente gerados aleatoriamente. |
| **2. Avaliação** | Cada indivíduo recebe uma **pontuação (aptidão)** com base na sua qualidade como solução do problema. |
| **3. Seleção** | Os melhores indivíduos são selecionados para reprodução. |
| **4. Cruzamento** | Os indivíduos selecionados combinam seus genes para gerar novos indivíduos. |
| **5. Mutação** | Pequenas alterações aleatórias são feitas nos indivíduos para aumentar a diversidade. |
| **6. Substituição** | A nova geração substitui a antiga e o processo recomeça até atingir um critério de parada. |

---

## 🧬 **Principais Operadores Genéticos**  

### 🔸 **Seleção por Roleta**  
Os indivíduos são escolhidos proporcionalmente à sua aptidão. Quanto melhor a aptidão, maior a chance de ser selecionado.

### 🔹 **Cruzamento**  
Existem dois principais tipos de cruzamento:  

| **Tipo** | **Descrição** | **Exemplo** |
|----------|--------------|-------------|
| **Cruzamento Simples** | Divide os genes dos pais em um único ponto e troca partes para gerar filhos. | **Pai 1:** `110011`<br>**Pai 2:** `001100`<br>**Filho 1:** `110100`<br>**Filho 2:** `001011` |
| **Cruzamento Uniforme** | Cada gene do filho é escolhido aleatoriamente entre os genes dos pais. | **Pai 1:** `110011`<br>**Pai 2:** `001100`<br>**Filho:** `101110` |

### 🔸 **Mutação**  
Alterações aleatórias nos genes para introduzir diversidade e evitar estagnação da população.  
Exemplo:  
`110011` → **Mutação no 3º gene** → `111011`

---

## 📌 **Exemplo Prático: Problema da Mochila**  

### 🔹 **Problema**  
Temos 10 itens, cada um com um peso. O objetivo é escolher quais itens colocar na mochila sem ultrapassar um peso máximo.  

**Passos do Algoritmo Genético para resolver o problema:**  
1. **Codificação:** Representamos cada solução como um vetor binário (`1` = item incluído, `0` = item não incluído).  
2. **Avaliação:** Calculamos o peso total e a pontuação com base no valor dos itens.  
3. **Seleção, Cruzamento e Mutação:** Aplicamos os operadores para gerar novas combinações.  
4. **Iteração:** Repetimos o processo até encontrar a melhor combinação.  

| **Geração** | **Melhor Solução** | **Peso Total** | **Valor Total** |
|------------|------------------|---------------|---------------|
| 1          | `1001101010`     | 9.5kg         | $30          |
| 5          | `1101110110`     | 10kg          | $45          |
| 10         | `1111110010`     | 9.8kg         | **$50**      |

💡 **Resultado:** O algoritmo encontra a melhor combinação de itens para maximizar o valor sem ultrapassar o limite de peso.  

---

## 🎯 **Aplicações dos Algoritmos Genéticos**  

| **Área** | **Exemplo de Aplicação** |
|----------|--------------------------|
| **Otimização** | Planejamento de rotas para entregas eficientes (ex: Caminho do Caixeiro Viajante). |
| **Machine Learning** | Ajuste de hiperparâmetros em redes neurais. |
| **Engenharia** | Design de antenas otimizadas para melhor sinal. |
| **Finanças** | Otimização de carteiras de investimento. |
| **Jogos** | Criação de estratégias e inteligência artificial adaptativa. |

---

## 📊 **Vantagens e Desvantagens**  

| **Vantagens** | **Desvantagens** |
|--------------|----------------|
| Pode encontrar soluções ótimas para problemas complexos. | Pode ser computacionalmente caro. |
| Funciona bem em espaços de busca grandes. | Não garante encontrar a solução global ótima. |
| Adapta-se a mudanças no ambiente. | Pode precisar de ajustes finos nos parâmetros. |

---

## **Conclusão**  
Os **algoritmos genéticos** são ferramentas poderosas para encontrar soluções em problemas complexos. Eles funcionam de maneira inspirada na evolução biológica e têm diversas aplicações em otimização, IA, engenharia e mais.  

---

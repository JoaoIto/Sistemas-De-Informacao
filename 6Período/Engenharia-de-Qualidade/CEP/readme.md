# 🟦 **1. Introdução ao CEP**

O Controle Estatístico do Processo (CEP) é um conjunto de técnicas estatísticas usadas para entender, monitorar e controlar processos de produção ou prestação de serviços. Ele busca garantir a estabilidade e a capacidade do processo, reduzindo a variabilidade que compromete a qualidade. Por exemplo, em uma linha de produção de garrafas de água, o CEP ajuda a garantir que todas as garrafas tenham volumes iguais, mesmo com pequenas variações nos equipamentos.

---

## 🟦 **2. Breve Histórico do CEP**

O CEP surgiu como resposta à necessidade de melhorar a qualidade sem depender da inspeção total. Antes, na Era da Inspeção, todos os produtos eram verificados individualmente. Com a industrialização e a produção em massa, esse modelo se tornou inviável. Walter A. Shewhart propôs o uso de estatística como alternativa, desenvolvendo os primeiros gráficos de controle nos anos 1920. Durante a 2ª Guerra Mundial, o uso dessas ferramentas foi intensificado, com treinamentos em massa liderados por especialistas como W. Edwards Deming. Após um período de queda, o interesse pelo CEP ressurgiu nos anos 1970, sendo incorporado como parte da Qualidade Total e, mais tarde, da Gestão Estratégica da Qualidade.

---

## 🟦 **3. Conceito e Aplicabilidade**

O CEP é uma metodologia que permite medir e analisar variações nos processos para garantir que eles se mantenham dentro de padrões aceitáveis. É aplicável não apenas à indústria, mas também ao setor de serviços. Por exemplo, em uma clínica médica, pode-se usar o CEP para monitorar o tempo de espera dos pacientes e garantir consistência no atendimento. A aplicação do CEP permite detectar problemas antes que causem falhas no produto ou serviço final.

---

### 🟦 **4. Variabilidade**

A variabilidade é inevitável em qualquer processo, mas é essencial entendê-la. Pode ocorrer de forma gradual (como o desgaste de uma peça), súbita (como uma queda de energia), ou pequena e constante (como diferenças entre operadores). Um exemplo simples é a produção de cookies: pequenas diferenças no tempo de forno ou na quantidade de ingredientes podem afetar o tamanho e o sabor. O CEP ajuda a identificar e reduzir essas variações.

---

### 🟦 **5. Causas Comuns**

Causas comuns são pequenas variações naturais dentro do processo. Elas ocorrem constantemente, como flutuações normais de temperatura, vibração de máquinas ou pequenas diferenças na matéria-prima. Por exemplo, uma máquina que produz tampas plásticas pode ter pequenas variações no tamanho das tampas, mas ainda dentro do padrão. Quando apenas essas causas estão presentes, o processo está "sob controle".

---

### 🟦 **6. Causas Especiais**

Causas especiais são variações inesperadas, muitas vezes significativas, que podem comprometer o resultado final. Elas não são parte natural do processo e indicam algo fora do padrão. Por exemplo, um lote de matéria-prima com defeito ou uma máquina com falha elétrica podem causar uma série de produtos fora de especificação. Identificar e corrigir essas causas é essencial para manter o controle do processo.

---

### 🟦 **7. Ferramentas do CEP**

O CEP utiliza diversas ferramentas gráficas e estatísticas. Entre as principais estão:

* **Histograma**: mostra a distribuição de dados;
* **Diagrama de Pareto**: ajuda a identificar os principais problemas;
* **Diagrama de Causa e Efeito** (Ishikawa): analisa causas potenciais de falhas;
* **Gráficos de Controle**: mostram se o processo está estável ou não;
* **Folha de Verificação**: simples lista para coleta de dados.
  Por exemplo, uma fábrica pode usar um gráfico de Pareto para ver que 80% dos defeitos vêm de apenas 20% das causas.

---

### 🟦 **8. Softwares e Pacotes para CEP**

Existem pacotes estatísticos e linguagens de programação como R e Python que facilitam a aplicação do CEP. Por exemplo:

* `qcc`, `spc`, `SixSigma` no R;
* `pandas`, `matplotlib`, `spcchart` no Python.
  Essas ferramentas permitem criar gráficos e análises automatizadas, ajudando na visualização dos dados e tomada de decisão.

---

### 🟦 **9. Gráficos de Controle**

Os gráficos de controle, criados por Shewhart, são as ferramentas mais utilizadas no CEP. Eles monitoram se o processo está dentro dos limites esperados. Um gráfico típico tem uma linha central (LC), limite superior de controle (LSC) e limite inferior de controle (LIC). Se os dados ultrapassarem esses limites ou apresentarem padrões suspeitos, é um sinal de que há um problema. Por exemplo, se a espessura de papel produzido começa a cair progressivamente, o gráfico mostrará essa tendência.

---

### 🟦 **10. Fundamentos Estatísticos dos Gráficos**

Esses gráficos se baseiam na distribuição normal dos dados. Por isso, os limites de controle são definidos como a média ± 3 desvios padrão. Isso significa que, em um processo estável, 99,73% dos pontos devem estar entre LIC e LSC. Um ponto fora disso indica uma causa especial. Por exemplo, se em uma gráfica, a quantidade de tinta começa a variar muito, isso aparece no gráfico e exige investigação.

---

### 🟦 **11. Gráfico X̄ e R**

O gráfico X̄ controla a média das amostras, enquanto o gráfico R (amplitude) monitora a variabilidade. Eles são usados juntos para observar tanto a centralidade quanto a consistência dos dados. Exemplo: em uma linha de envase de garrafas de refrigerante, o X̄ mostra se a média de volume está correta (ex.: 2L), enquanto o R indica se a variação entre garrafas é aceitável.

---

### 🟦 **12. Limites Três Sigma**

Os limites de controle são definidos com base em ±3σ da média. Essa margem evita alarmes falsos e garante que apenas desvios reais sejam tratados. Um operador que tenta ajustar o processo sempre que há uma pequena variação pode acabar criando mais instabilidade – daí o lema de Shewhart: “evite ajustes desnecessários”.

---

### 🟦 **13. Exemplo Prático: Fotolitografia**

Na indústria de semicondutores, durante a etapa de fotolitografia, é preciso controlar a largura do fluxo do material fotorresistente. Um pequeno desvio pode comprometer todo o chip. Com o CEP, é possível monitorar a média e desvio padrão da largura e agir antes que o problema afete a produção.

---

### 🟦 **14. Importância do CEP**

Aplicar CEP evita desperdícios, melhora a qualidade e reduz retrabalho. Por exemplo, se em um envase de leite as embalagens estão com 510 ml em vez de 500 ml, isso representa perda financeira. O CEP permite identificar esse desvio cedo e corrigi-lo antes que milhares de embalagens estejam erradas.

---

### 🟦 **15. Quando Usar o CEP**

O CEP é ideal para momentos em que se busca:

* Verificar a estabilidade do processo;
* Identificar causas de falhas;
* Implementar melhorias;
* Obter previsibilidade nos resultados.

---

### 🟦 **16. Etapas para Acompanhamento**

1. Identificar processos problemáticos;
2. Determinar as características críticas;
3. Coletar dados com frequência definida;
4. Calcular limites com base histórica;
5. Gerar gráficos de controle;
6. Avaliar se o processo está dentro das especificações;
7. Monitorar constantemente;
8. Implementar ações corretivas quando necessário.

---

### 🟦 **17. Padrões de Instabilidade**

* **Ponto fora dos limites**: Ex.: erro de operação, equipamento sem calibração.
* **Periodicidade**: Ex.: variações sazonais ou trocas de turno.
* **Sequência**: Ex.: 7 pontos seguidos acima da média → mudança de matéria-prima.
* **Tendência**: Ex.: desgaste gradual de peças.
* **Aproximação dos limites**: Ex.: dois pontos muito próximos ao LSC podem indicar tentativa excessiva de ajuste por parte dos operadores.

---

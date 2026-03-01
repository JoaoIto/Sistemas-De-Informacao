# Medidas de Posição, Dispersão e Assimetria

Medidas de Posição, Dispersão e Assimetria. Este manual foi desenhado com uma estrutura lógica para processar dados brutos e transformá-los em indicadores estatísticos. O foco é fornecer a base matemática e analítica necessária para resolver questões de identificação tabular, cálculo de tendência central, análise de dispersão e simetria (conteúdos cobrados na sua Atividade de Fixação 4).

---

## 1. Dissecando a Tabela de Frequência (A Base de Dados)

Antes de realizar qualquer cálculo avançado, é preciso saber extrair as "variáveis" corretas de uma tabela estruturada em classes.

### Anatomia de uma Classe

Tome como exemplo a quarta linha da tabela da sua atividade: **2,90 $\vdash$ 2,95** com frequência **11**.

* **Limite Inferior ($L_i$):** É o número onde a classe começa. Neste caso, 2,90.


* **Limite Superior ($L_s$):** É o número onde a classe termina. Neste caso, 2,95.


* **Frequência Simples Absoluta ($f_i$):** É a quantidade exata de itens que caíram dentro deste intervalo. Aqui, $f_i = 11$.


* **Frequência Total ($n$ ou $\Sigma f_i$):** É a soma de todas as frequências simples da tabela. Representa o total de dados analisados.



### Parâmetros de Intervalo

* **Amplitude do Intervalo de Classe ($h$):** É o tamanho do "degrau" de uma única classe.
* **Como calcular:** $h = L_s - L_i$
* 
**Exemplo:** $2,95 - 2,90 = \mathbf{0,05}$. Todas as classes dessa tabela têm amplitude 0,05.




* **Amplitude Total ($AT$):** É o tamanho do cenário completo.
* **Como calcular:** Subtraia o Limite Inferior da *primeira* classe do Limite Superior da *última* classe.


* **Ponto Médio ($X_c$):** O representante numérico da classe para cálculos futuros.
* 
**Como calcular:** $X_c = \frac{L_i + L_s}{2}$.





---

## 2. Medidas de Posição (Tendência Central)

Estas medidas servem para encontrar onde os dados estão concentrados. Elas resumem a amostra a um único valor representativo.

### 2.1 Média Aritmética ($\bar{x}$)

* **O que é:** O ponto de equilíbrio ou "centro de gravidade" dos dados.
* **Dados Soltos (Rol):** Soma-se tudo e divide-se pela quantidade. Exemplo com $7, 8, 9, 12, 14$: $\frac{7+8+9+12+14}{5} = \mathbf{10}$.


* **Dados Tabelados (com Frequência):** Multiplica-se cada valor (ou Ponto Médio) pela sua frequência ($f_i$), soma-se todos os resultados e divide-se pelo total de dados ($n$).

### 2.2 Mediana ($Md$)

* **O que é:** O valor estritamente central. Exatamente **50% dos dados** situam-se abaixo da mediana e 50% situam-se acima dela.


* **Como calcular (Dados Soltos):**
1. Organize em ordem crescente (obrigatório).
2. Se a quantidade for ímpar, é o número do meio.
3. Se a quantidade for par (ex: $10, 20, 40, 50, 70, 80$), pegue os dois centrais (40 e 50) e tire a média: $\frac{40+50}{2} = \mathbf{45}$.





### 2.3 Moda ($Mo$)

* **O que é:** O valor de maior ocorrência (o que mais repete).
* **Dados Soltos:** Basta contar. Exemplo ($3, 4, 7, 7, 7, 8, 9, 10$): A moda é **7**.


* **Dados Tabelados:** Identifique a linha que possui o maior valor na coluna da frequência ($f_i$). A moda será o valor da variável (ou o Ponto Médio) dessa linha.



---

## 3. Medidas de Dispersão (Análise de Risco e Caos)

Enquanto as medidas de posição mostram o centro, as medidas de dispersão mostram o quão "espalhados" ou irregulares os dados estão ao redor desse centro.

### 3.1 A Regra de Ouro da Dispersão

Se todos os valores de uma distribuição forem exatamente iguais (ex: $5, 5, 5, 5, 5$), não existe variação. Portanto, a variância e o Desvio Padrão serão obrigatoriamente **zero**.

### 3.2 Variância ($S^2$ ou $\sigma^2$)

* **O que é:** A média dos quadrados das distâncias entre cada dado e a média geral.
* 
**Pré-requisito:** Para calcular a variância, **é obrigatório calcular a média primeiro**.


* 
**Relação Fundamental:** Se você tem o Desvio Padrão (ex: $9$), a variância é simplesmente esse número elevado ao quadrado ($9^2 = 81$).



### 3.3 Desvio Padrão ($S$ ou $\sigma$)

* **O que é:** A raiz quadrada da variância. Traz o valor de dispersão de volta para a unidade original dos dados.
* **Interpretação:** Quanto maior o desvio padrão, mais instáveis e irregulares são os dados.

### 3.4 Coeficiente de Variação ($CV$)

* 
**O que é:** Uma porcentagem que permite comparar a dispersão de grupos completamente diferentes (ex: comparar salários de homens e mulheres).


* **Por que usar:** Um desvio de R$ 1.000 é muito para quem ganha R$ 2.000, mas é irrelevante para quem ganha R$ 50.000. O CV normaliza isso.
* **Como calcular:** $CV = (\frac{\text{Desvio Padrão}}{\text{Média}}) \times 100$. O grupo que tiver a maior porcentagem apresenta a **maior dispersão**.



---

## 4. Assimetria (O Formato da Distribuição)

A relação entre a Média, a Mediana e a Moda define o formato visual do gráfico (histograma ou curva) da sua distribuição de dados.

Para classificar uma curva, analise o comportamento matemático dos três indicadores:

1. **Distribuição Simétrica (Curva Normal):**
* 
**Regra:** Média = Mediana = Moda.


* **Visual:** O gráfico é um "sino" perfeito. O lado direito é o espelho do esquerdo.


2. **Distribuição Assimétrica Positiva (Cauda à Direita):**
* 
**Regra:** Média > Mediana > Moda.


* **Visual:** A maioria dos dados concentra-se nos valores baixos, mas alguns poucos valores extremamente altos "puxam" a média para cima.


3. **Distribuição Assimétrica Negativa (Cauda à Esquerda):**
* 
**Regra:** Média < Mediana < Moda.


* **Visual:** A maioria dos dados concentra-se nos valores altos, mas alguns poucos valores extremamente baixos derrubam a média.



---

## Resumo Algorítmico para Resolução de Problemas

Se você se deparar com um problema pedindo para classificar dispersão ou assimetria, siga este fluxo de execução:

| Objetivo | Passo 1 | Passo 2 | Passo 3 |
| --- | --- | --- | --- |
| **Comparar Dispersão (Quem varia mais?)** | Extraia a Média e o Desvio Padrão de ambos os grupos. | Calcule o CV para o Grupo A e para o Grupo B: $CV = (\frac{S}{\bar{x}}) \cdot 100$. | Aquele que resultar no maior valor de CV tem a maior dispersão.

 |
| **Determinar a Simetria** | Identifique os valores de Média ($\bar{x}$), Mediana ($Md$) e Moda ($Mo$).

 | Compare os três valores usando operadores lógicos ($=, >, <$).

 | Aplique as regras: Iguais = Simétrica. Média Maior = Positiva. Média Menor = Negativa.

 |
| **Encontrar o Desvio Padrão pela Variância** | Localize o valor da Variância fornecido no problema. | Aplique a operação de raiz quadrada. | O resultado é o Desvio Padrão. (O inverso também é verdadeiro: elevando o Desvio ao quadrado, acha-se a Variância) .

 |

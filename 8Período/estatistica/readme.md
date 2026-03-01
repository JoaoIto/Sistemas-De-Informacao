# Estatística Computacional

## A Jornada da Estatística: Do Caos ao Diagnóstico

A estatística é uma ciência desenhada para resolver um problema específico: o cérebro humano não consegue interpretar milhares de números soltos ao mesmo tempo. Para tomar decisões, precisamos de resumos. A disciplina segue uma linha de produção lógica dividida em quatro grandes fases.

---

## FASE 1: A Fundação e a Coleta (A Base Teórica)

Antes de fazer qualquer conta, você precisa entender o que está medindo.

### 1. População vs. Amostra

* **População:** É o conjunto total de elementos que possuem pelo menos uma característica em comum. (Ex: Todos os estudantes universitários do Brasil).
* **Amostra:** É um subconjunto finito da população.
* **O Porquê:** Estudar a população inteira (Censo) é caro, demorado e muitas vezes impossível. A estatística coleta dados de uma Amostra representativa para "adivinhar" (inferir) o comportamento da População.

### 2. A Matéria-Prima: Tipos de Variáveis

A variável é aquilo que você está pesquisando. Saber o tipo de variável é vital porque você não pode calcular a "Média Aritmética" da cor do cabelo das pessoas.

* **Variáveis Qualitativas (Atributos e Qualidades):** Não são expressas por números.
* **Nominal:** Não existe hierarquia (ex: Sexo, Cor dos olhos, Estado Civil).
* **Ordinal:** Existe uma ordem natural (ex: Grau de instrução, Patente militar, Estágio de uma doença).


* **Variáveis Quantitativas (Números e Medidas):**
* **Discreta:** Resultam de uma **contagem**. São números inteiros (ex: Número de filhos, Quantidade de carros vendidos). Você não tem "2,5" filhos.
* **Contínua:** Resultam de uma **medição**. Podem assumir qualquer valor fracionário (ex: Altura, Peso, Salário, Tempo). Um objeto pode pesar 12,475 kg.



---

## FASE 2: Organização e Resumo Visuais (Distribuição de Frequência)

Você coletou os dados da sua amostra. Agora você tem uma planilha com 500 números misturados (Dados Brutos). O que fazer?

### 1. O Rol e o Agrupamento

* **O Rol:** É o primeiro ato de organização. Consiste em pegar os Dados Brutos e colocá-los em ordem crescente ou decrescente.
* **As Classes (Intervalos):** Se você tem muitos números diferentes (Variável Contínua), você não lista número por número. Você cria "caixas" de agrupamento chamadas Classes.

### 2. A Anatomia da Tabela

A tabela de distribuição resume os dados mostrando quantas vezes um evento ocorreu dentro de cada "caixa".

| Altura dos Alunos | Freq. Simples ($f_i$) | Freq. Acumulada ($F_i$) | Freq. Relativa ($fr$) |
| --- | --- | --- | --- |
| 1,60 $\vdash$ 1,70 | 10 | 10 | 25% |
| 1,70 $\vdash$ 1,80 | 25 | 35 | 62,5% |
| 1,80 $\vdash$ 1,90 | 5 | 40 | 12,5% |
| **Total ($n$)** | **40** | **-** | **100%** |

* **O Símbolo $\vdash$ :** Significa intervalo fechado à esquerda e aberto à direita. Na primeira classe, o aluno com 1,60m entra na contagem, mas o aluno com exatos 1,70m só entra na classe de baixo.
* **Freq. Simples ($f_i$):** É a contagem absoluta. 10 alunos têm entre 1,60m e 1,69m.
* **Freq. Acumulada ($F_i$):** Soma em cascata. Mostra o limite superior. Olhando o número 35, podemos afirmar: "Existem 35 alunos com altura *abaixo* de 1,80m".
* **Freq. Relativa ($fr$):** Transforma o número absoluto em porcentagem, facilitando a comparação de grupos de tamanhos diferentes.

---

## FASE 3: O Diagnóstico Central (Medidas de Posição e Separatrizes)

As tabelas são boas, mas gestores querem que você resuma a tabela inteira em um único número representativo.

### 1. Medidas de Tendência Central

Elas buscam encontrar o "centro de gravidade" da sua amostra.

* **Média Aritmética ($\bar{x}$):** É a distribuição igualitária. Soma-se tudo e divide-se pelo total. O problema da média é que ela é "puxada" por valores extremos (outliers). Se 9 pessoas ganham R$ 1.000 e 1 pessoa ganha R$ 91.000, a média será de R$ 10.000, o que não representa a realidade do grupo.
* **Mediana ($Md$):** É o valor estritamente central. Ela divide a amostra no meio (50% ganham mais, 50% ganham menos). É a melhor medida para cenários com extrema desigualdade (como renda no Brasil).
* **Moda ($Mo$):** É o valor mais frequente. O que mais se repete.

### 2. As Separatrizes (Fatiamento)

Se a mediana fatia os dados em 2 (50%), as separatrizes usam a mesma lógica matemática para fatiar em pedaços menores, dependendo do que você quer focar.

* **Quartis ($Q_1, Q_2, Q_3, Q_4$):** Dividem os dados em 4 partes de 25%. O $Q_2$ é a própria Mediana.
* **Percentis ($P_1$ a $P_{99}$):** Dividem os dados em 100 partes de 1%. Muito usado para aprovação em concursos (ex: "Estar no Percentil 95" significa que você foi melhor que 95% dos candidatos).

---

## FASE 4: O Termômetro do Caos (Medidas de Dispersão e Assimetria)

Nunca confie apenas na Média. Uma cidade que faz 40ºC de dia e 0ºC à noite tem uma média térmica confortável de 20ºC, mas você não conseguiria viver nela sem adoecer. A dispersão mede o caos.

### 1. Medidas de Dispersão

* **Variância ($S^2$):** Mede a distância média de cada dado em relação à média aritmética, elevada ao quadrado para evitar resultados negativos. É apenas um passo matemático.
* **Desvio Padrão ($S$):** É a raiz quadrada da Variância. Ele te diz a verdade em números reais: "Os valores desta amostra desviam da Média em tantos pontos para cima ou para baixo". Quanto maior o Desvio Padrão, maior o risco, a irregularidade e a desigualdade do cenário.

### 2. Assimetria (A Personalidade do Gráfico)

Se você desenhar um gráfico usando as frequências da sua tabela, ele formará uma curva. A relação entre a Média, a Mediana e a Moda dita o formato (a simetria) dessa curva.

* **Distribuição Simétrica (Média = Mediana = Moda):** O formato de um sino perfeito. Há total equilíbrio no cenário. A maioria dos dados está no centro e vai caindo igualmente para os lados.
* **Assimétrica Positiva (Média > Mediana > Moda):** A "cauda" do gráfico se alonga para a direita. Indica que a base concentra valores baixos, mas alguns poucos indivíduos com valores exorbitantes estão puxando a Média para cima artificialmente.
* **Assimétrica Negativa (Média < Mediana < Moda):** A "cauda" do gráfico se alonga para a esquerda. Indica que a grande maioria tem um desempenho alto, mas alguns poucos resultados zerados ou péssimos estão derrubando a Média geral.

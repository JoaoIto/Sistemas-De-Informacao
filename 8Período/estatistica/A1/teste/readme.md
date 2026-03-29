# Simulado: Estatística Aplicada

**Questão 1: Assimetria e o Comportamento do Usuário**
Você está analisando o tempo de uso diário de uma nova funcionalidade em um sistema SaaS. A maioria absoluta dos usuários acessa a ferramenta por cerca de 10 minutos, mas um pequeno grupo de usuários corporativos deixa o sistema aberto rodando painéis o dia inteiro (várias horas). 
Ao calcular o coeficiente de assimetria de Pearson ($As$), você encontra um valor $As > 0$. Com base nisso, qual é a relação estatística esperada entre as medidas de tendência central?
* A) Média = Mediana = Moda
* B) Média < Mediana < Moda
* C) Média > Mediana > Moda
* D) Moda > Mediana > Média

**Questão 2: Curtose em Dados Demográficos**
Ao analisar a distribuição de idade dos estudantes de Sistemas de Informação da UNITINS para um projeto acadêmico, você calcula o coeficiente de curtose e encontra o valor $K = 0,18$. Como essa distribuição é classificada estatisticamente e qual é o seu formato visual em comparação com uma curva normal?
* A) Platicúrtica; a curva é mais achatada e os dados são mais dispersos.
* B) Leptocúrtica; a curva é mais pontiaguda, com os dados mais concentrados em torno da média.
* C) Mesocúrtica; a curva tem o formato exato do sino de uma distribuição normal.
* D) Assintótica; a curva não possui um pico definido e desce constantemente.

**Questão 3: A Pegadinha do Coeficiente de Pearson**
Ao cruzar os dados de "Quantidade de commits no GitHub" ($X$) e "Quantidade de xícaras de café consumidas" ($Y$) pela sua equipe de desenvolvimento durante um mês, você aplica a fórmula de Pearson e encontra $r = 0$. Qual a conclusão estatística CORRETA que você deve colocar no seu relatório?
* A) O aumento de commits diminui proporcionalmente o consumo de café.
* B) Existe uma correlação linear perfeita e negativa.
* C) Não existe correlação **linear** entre as variáveis, o que significa que uma reta não serve para prever esses dados.
* D) O cálculo está incorreto, pois o coeficiente de Pearson nunca pode resultar em zero absoluto.

**Questão 4: Interpretando a Regressão Linear**
Você desenvolveu um modelo preditivo para o projeto FinancePro. A equação de regressão linear que prevê a economia financeira mensal do usuário em reais ($Y$) com base na quantidade de metas cadastradas na plataforma ($X$) resultou na seguinte reta: $Y = 50X + 15$. 
No contexto deste problema, o que o valor **15** (o coeficiente linear $b$) representa?
* A) O limite máximo de economia que um usuário pode alcançar no mês.
* B) A economia base estimada do usuário (em reais) mesmo que ele não cadastre nenhuma meta ($X = 0$).
* C) O valor em reais que a economia aumenta a cada nova meta que o usuário cadastra.
* D) A força da correlação entre o número de metas e o dinheiro economizado.

---

#### Questão 5: Distribuição de Frequência, Tendência Central e Dispersão
Você extraiu um log de desempenho da API do BillLens. Os dados representam o tempo de processamento (em milissegundos) para extrair dados de 40 notas fiscais em PDF, já agrupados na tabela de distribuição de frequência abaixo:

| Tempo de Processamento ($ms$) | Número de Requisições ($f_i$) |
| :--- | :--- |
| $100 \vdash 150$ | 4 |
| $150 \vdash 200$ | 12 |
| $200 \vdash 250$ | 16 |
| $250 \vdash 300$ | 6 |
| $300 \vdash 350$ | 2 |
| **Total** | **40** |

Com base na tabela acima, calcule:
**a)** A Média ($\bar{x}$) de tempo de processamento.
**b)** A Mediana ($Md$).
**c)** A Moda ($Mo$) utilizando a fórmula de Czuber.
**d)** O Desvio Padrão ($S$) dessa amostra.

---

#### Questão 6: Medidas de Posição, Assimetria e Curtose
Utilizando a mesma tabela de distribuição de frequência da Questão 1:

**a)** Calcule o primeiro e o terceiro quartis ($Q_1$ e $Q_3$).
**b)** Calcule o 10º e o 90º percentis ($P_{10}$ e $P_{90}$).
**c)** Calcule o Coeficiente de Assimetria de Pearson ($As$) e classifique a curva (Simétrica, Assimétrica Positiva ou Assimétrica Negativa).
**d)** Calcule o Coeficiente de Curtose ($K$) e classifique a distribuição (Mesocúrtica, Platicúrtica ou Leptocúrtica).

---

#### Questão 7: Correlação e Regressão Linear
Para validar uma proposta de negócio do PolitiRank, você analisou a relação entre o **Investimento em tráfego pago nas APIs do Meta ($X$, em milhares de reais)** e o **Crescimento de novos seguidores ($Y$, em milhares)** de 5 perfis monitorados. Os dados coletados foram:

| Perfil | Investimento ($X$) | Novos Seguidores ($Y$) |
| :--- | :--- | :--- |
| A | 2 | 4 |
| B | 3 | 5 |
| C | 5 | 8 |
| D | 6 | 9 |
| E | 9 | 14 |

**a)** Calcule o Coeficiente de Correlação Linear de Pearson ($r$) e classifique a força dessa relação.
**b)** Determine os coeficientes $a$ e $b$ para encontrar a equação da reta de regressão ($Y = aX + b$).
**c)** Utilizando a equação encontrada, preveja qual seria o crescimento esperado de novos seguidores ($Y$) caso um político decida investir R$ 12.000,00 ($X = 12$) na plataforma.

---

#### Questão 8: Conceitos Teóricos (Padrão Prova)
Marque a alternativa correta para cada afirmação, justificando brevemente sua escolha:

**I.** Média, Mediana e Moda são medidas de:
a) ( ) Dispersão
b) ( ) Posição / Tendência Central
c) ( ) Assimetria
d) ( ) Curtose

**II.** Variância, Desvio Padrão e Amplitude Total são medidas de:
a) ( ) Dispersão
b) ( ) Posição
c) ( ) Assimetria
d) ( ) Curtose

**III.** Na distribuição de valores estritamente iguais (ex: 5, 5, 5, 5, 5), o Desvio Padrão é:
a) ( ) Negativo
b) ( ) A unidade (1)
c) ( ) Zero
d) ( ) Positivo

**IV.** Se em uma distribuição a Média é maior que a Mediana, e a Mediana é maior que a Moda ($\bar{x} > Md > Mo$), essa curva apresenta:
a) ( ) Simetria perfeita.
b) ( ) Assimetria negativa (à esquerda).
c) ( ) Assimetria positiva (à direita).
d) ( ) Distribuição bimodal.

---

# Estudo de Caso: Aplicação do Diagrama de Pareto na Qualidade de Produção

## Contexto

Uma fábrica de componentes eletrônicos identificou que a taxa de defeitos nos produtos tem aumentado, resultando em reclamações de clientes e custos adicionais. Para entender as principais causas dos defeitos, a equipe de qualidade coletou dados de um mês de produção e registrou a quantidade de ocorrências para diferentes tipos de defeitos.


---

Passo 1: Coleta de Dados e Construção da Tabela

A equipe identificou seis principais tipos de defeitos e registrou o número de ocorrências de cada um:


---

Passo 2: Construção da Tabela para o Diagrama de Pareto

Agora organizamos os dados de forma decrescente, calculamos o percentual individual e o percentual acumulado.

Tabela de Análise


---

Passo 3: Construção do Gráfico de Pareto

O gráfico de Pareto é um gráfico de colunas onde:

O eixo X representa os tipos de defeitos (organizados do maior para o menor).

O eixo Y esquerdo representa a quantidade de ocorrências.

O eixo Y direito representa o percentual acumulado.

As barras mostram as quantidades de defeitos.

A linha mostra o percentual acumulado.


Passo 4: Interpretação dos Resultados

O Princípio de Pareto (80/20) indica que 80% dos problemas vêm de 20% das causas. Pela análise:

Os três primeiros defeitos (Falha na Soldagem, Componente com Defeito e Erro de Montagem) somam 73,47% das falhas.

Isso significa que se a empresa focar em corrigir essas três principais falhas, pode eliminar grande parte dos defeitos e melhorar a qualidade geral do produto.



---

Como Construir o Gráfico no Excel

1. Crie a tabela acima no Excel.


2. Selecione as colunas "Tipo de Defeito" e "Ocorrências" e insira um gráfico de colunas.


3. Adicione uma linha representando o percentual acumulado:

Clique no gráfico, selecione "Adicionar Série de Dados" e escolha os valores de "% Acumulado".

Mude essa série para um gráfico de linhas.



4. Adicione um eixo secundário para a linha (% acumulado).


Passo 1: Coletar e Organizar os Dados

Os dados foram coletados e organizados em ordem decrescente de ocorrência.


---

Passo 2: Cálculo do Percentual Individual

Cada percentual individual é calculado com a fórmula:

\text{Percentual Individual} = \left( \frac{\text{Ocorrências}}{\text{Total de Ocorrências}} \right) \times 100

Aplicando os cálculos:


---

Passo 3: Cálculo do Percentual Acumulado

O percentual acumulado é a soma dos percentuais individuais sucessivos.

\text{Percentual Acumulado} = \text{Percentual Anterior} + \text{Percentual Individual Atual}

Cálculo do Percentual Acumulado:


---

Passo 4: Análise da Tabela e Conclusão

A análise do percentual acumulado confirma o Princípio de Pareto (80/20):

Os três primeiros defeitos somam 73,47% dos problemas!

Isso significa que se resolvermos apenas essas três falhas principais (Falha na Soldagem, Componente com Defeito e Erro de Montagem), eliminamos a maioria dos defeitos da fábrica.


O próximo passo seria construir o Gráfico de Pareto, com as colunas representando a frequência dos defeitos e uma linha indicando o percentual acumulado.

--- 



# Documentação da Atividade: Regras de Associação e Detecção de Anomalias

Este documento detalha a atividade realizada no arquivo `regras_associacao.ipynb`, explicando o dataset, a metodologia, os códigos utilizados e a interpretação dos resultados.

## 1. O Dataset (Groceries)

O dataset utilizado contém dados transacionais de um supermercado.
- **Fonte**: [Groceries Dataset no Kaggle](https://www.kaggle.com/datasets/heeraldedhia/groceries-dataset).
- **Estrutura**: O arquivo CSV possui linhas representando itens comprados individualmente.
- **Colunas Principais**:
    - `Member_number`: Identificador único do cliente.
    - `Date`: Data da realização da compra.
    - `itemDescription`: Nome do produto comprado (ex: *whole milk*, *yogurt*).

### Definição de Transação
Como o dataset lista itens linha a linha, definimos uma **transação** (ou cesta de compras) como o conjunto de todos os itens comprados pelo mesmo membro (`Member_number`) na mesma data (`Date`).

---

## 2. Metodologia e Ferramentas

A atividade foi dividida em duas partes principais, conforme instruções e adaptações necessárias:

1.  **Regras de Associação (Association Rules)**: Utilizando a biblioteca `mlxtend`.
    - *Motivo*: O PyCaret descontinuou o módulo nativo de regras de associação em versões recentes, sendo o `mlxtend` a ferramenta padrão de mercado para esta tarefa em Python.
2.  **Detecção de Anomalias (Anomaly Detection)**: Utilizando a biblioteca `PyCaret`.
    - *Motivo*: Atender à solicitação de uso do PyCaret, identificando comportamentos de compra atípicos (outliers).

---

## 3. Explicação dos Códigos e Parâmetros

### A. Preparação dos Dados
Antes da análise, os dados foram transformados:
- **Agrupamento**: `df.groupby(['Member_number', 'Date'])` para juntar itens na mesma cesta.
- **One-Hot Encoding (`TransactionEncoder`)**: Transforma a lista de produtos em uma matriz gigante onde as colunas são os produtos e as linhas são as transações.
    - `1` (ou `True`): O produto estava na cesta.
    - `0` (ou `False`): O produto não estava.

### B. Regras de Associação (Algoritmo Apriori)
Código principal:
```python
frequent_itemsets = apriori(df_trans, min_support=0.001, use_colnames=True)
rules = association_rules(frequent_itemsets, metric="lift", min_threshold=1.0)
```

**Parâmetros Explicados:**
- **`min_support=0.001` (0.1%)**:
    - Define que um conjunto de itens deve aparecer em pelo menos 0.1% de todas as transações para ser considerado "frequente".
    - *Por que tão baixo?* Em supermercados, a variedade de produtos é enorme. A chance de uma combinação específica (ex: "Cerveja + Fralda + Amendoim") acontecer é naturalmente baixa em relação ao total de vendas. Valores altos (como 5% ou 10%) geralmente não retornam resultado nenhum em datasets esparsos como este.
- **`metric="lift"` e `min_threshold=1.0`**:
    - Filtramos apenas regras onde o **Lift** seja maior ou igual a 1.0.
    - **Lift > 1**: Indica uma associação positiva (quem compra A tem *mais* chance de comprar B do que uma pessoa aleatória).
    - **Lift = 1**: Independência (comprar A não muda a chance de comprar B).


## 4. Resultados e Gráficos Gerados

### Gráfico 1: Top 10 Produtos Mais Vendidos (Barras)
- **O que mostra**: Os itens mais populares individualmente.
- **Insight**: Produtos como *whole milk* (leite integral) e *vegetables* (vegetais) costumam ser a base das cestas, aparecendo em muitas regras.

![alt text](image.png)

### Gráfico 2: Scatter Plot (Suporte x Confiança x Lift)
- **Eixo X (Suporte)**: Quão frequente é a regra.
- **Eixo Y (Confiança)**: Quão forte é a regra (dado A, qual a chance de B?).
- **Cor/Tamanho (Lift)**: A qualidade da associação.
- **Interpretação**:
    - Pontos no **canto superior direito** são os melhores (frequentes e confiáveis).
    - Pontos **mais escuros/grandes** indicam associações muito fortes, onde um produto "puxa" a venda do outro.

### Tabela de Regras (DataFrame) - Detalhes Técnicos

A tabela gerada pelo `association_rules` contém diversas métricas estatísticas. Abaixo, explicamos o significado de cada coluna com base no exemplo: `(yogurt, whole milk) -> (sausage)`.

| Coluna | Significado | Exemplo (Linha 236) | Interpretação |
| :--- | :--- | :--- | :--- |
| **antecedents** | O item ou conjunto "Gatilho" (SE...). | `(yogurt, whole milk)` | "Se o cliente comprou Iogurte E Leite..." |
| **consequents** | O item "Alvo" (...ENTÃO). | `(sausage)` | "...ele também comprou Salsicha." |
| **antecedent support** | Frequência apenas do antecedente. | `0.011161` (1.11%) | 1.11% de todas as cestas tinham Iogurte + Leite. |
| **consequent support** | Frequência apenas do consequente. | `0.060349` (6.03%) | 6.03% de todas as cestas tinham Salsicha. |
| **support** | Frequência da regra completa (A + B). | `0.001470` (0.14%) | 0.14% das cestas tinham Iogurte + Leite + Salsicha JUNTOS. |
| **confidence** | Probabilidade de B dado A. | `0.131737` (13.17%) | Dos que compraram Iogurte+Leite, 13.17% levaram Salsicha. |
| **lift** | Força da associação (Fator de Multiplicação). | `2.182917` | Quem compra Iogurte+Leite tem **2.18x mais chances** de comprar Salsicha do que um cliente qualquer. (Lift > 1 é bom). |
| **leverage** | Diferença entre observado e esperado (independência). | `0.000797` | Valor positivo indica que A e B aparecem juntos mais do que o esperado pelo acaso. |
| **conviction** | Medida de dependência direcional. | `1.082219` | Quanto maior que 1, mais o consequente depende do antecedente. Se fosse infinito, seria uma implicação lógica perfeita. |

![alt text](image-1.png)

---

## 5. Como as Regras são Geradas (O Algoritmo)

O processo segue duas etapas principais usando o algoritmo **Apriori**:

### Passo 1: Encontrar Itemsets Frequentes
O algoritmo varre o banco de dados procurando itens (ou grupos de itens) que aparecem juntos com uma frequência mínima (`min_support`).
1. Conta todos os itens individuais (leite, pão, etc.). Elimina os raros (< 0.1%).
2. Combina os restantes em pares (leite+pão, leite+ovos). Conta novamente e elimina os raros.
3. Combina em trios, e assim por diante, até não conseguir mais formar grupos frequentes.

### Passo 2: Gerar Regras a partir dos Itemsets
Para cada grupo frequente encontrado (ex: {A, B, C}), o algoritmo testa todas as combinações de regras:
- Se {A, B, C} é frequente, testamos:
    - `A -> B, C`
    - `A, B -> C`
    - `C -> A, B`
    - etc.
- Uma regra é mantida apenas se atender ao critério de métrica escolhido (no nosso código, `lift >= 1.0` ou `confidence` mínima).

Isso garante que não estamos apenas "chutando" associações, mas sim encontrando padrões matematicamente relevantes dentro do histórico de compras.

### Detecção de Anomalias
- O PyCaret adiciona colunas `Anomaly` (1 = anômalo, 0 = normal) e `Anomaly_Score`.
- **Interpretação**: Transações marcadas como anômalas podem representar:
    - Compras de volume muito acima da média.
    - Combinações de produtos muito raras ou estranhas.
    - Erros de registro no sistema.


### C. Detecção de Anomalias (PyCaret)
Código principal:
```python
exp_ano = setup(df_trans, session_id=123)
iforest = create_model('iforest')
```

**Modelos e Configurações:**
- **`iforest` (Isolation Forest)**:
    - É um algoritmo eficiente para detecção de anomalias em grandes dimensões.
    - *Como funciona*: Ele isola observações selecionando aleatoriamente uma característica e um valor de corte. Pontos anômalos são isolados mais rapidamente (precisam de menos cortes) do que pontos normais.
- **`session_id=123`**: Garante que os resultados sejam reproduzíveis (sempre os mesmos resultados ao rodar de novo).

---


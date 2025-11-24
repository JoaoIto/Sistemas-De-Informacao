# Regras de Associação: Guia Didático

Este documento serve como um guia teórico e prático sobre **Regras de Associação**, explicando desde os conceitos básicos até a implementação técnica utilizada neste projeto.

---

## 1. O que são Regras de Associação?

Regras de Associação são uma técnica de mineração de dados (Machine Learning não supervisionado) usada para descobrir fatos interessantes ou relações ocultas em grandes bases de dados transacionais.

**A ideia central é:** "Quem compra X, também costuma comprar Y?"

### O Exemplo Clássico: Cerveja e Fraldas
Diz a lenda que um supermercado descobriu uma forte associação entre a venda de **fraldas** e **cerveja** nas sextas-feiras à tarde.
- **Motivo:** Pais jovens iam comprar fraldas para o bebê e aproveitavam para levar cerveja para o fim de semana.
- **Ação:** O mercado colocou as fraldas ao lado das cervejas e as vendas de ambos explodiram.

---

## 2. Conceitos Fundamentais (As Métricas)

Para saber se uma regra é "boa" ou apenas coincidência, usamos três métricas principais. Imagine a regra: `{Pão} -> {Manteiga}`.

| Métrica | Definição Didática | Fórmula Simplificada | Interpretação |
| :--- | :--- | :--- | :--- |
| **Suporte (Support)** | **Popularidade**. Quão frequente essa combinação aparece no total? | $\frac{\text{Transações com Pão e Manteiga}}{\text{Total de Transações}}$ | Se for muito baixo (ex: 0.0001), a regra é irrelevante estatisticamente (aconteceu 1 vez em 10 mil). |
| **Confiança (Confidence)** | **Fidelidade**. Dado que comprei Pão, qual a chance de levar Manteiga? | $\frac{\text{Transações com Pão e Manteiga}}{\text{Transações com Pão}}$ | Se for 0.8 (80%), é uma regra forte. "80% de quem compra pão, leva manteiga". |
| **Lift** | **Força da Conexão**. A compra de Pão *aumenta* a chance de comprar Manteiga? | $\frac{\text{Confiança}}{\text{Suporte da Manteiga}}$ | • **Lift > 1**: Associação Positiva (Um puxa o outro).<br>• **Lift = 1**: Independência (Coincidência).<br>• **Lift < 1**: Associação Negativa (Quem compra um, evita o outro). |

---

## 3. Como Funciona no Código?

Utilizamos a biblioteca `mlxtend` em Python. O processo segue 3 etapas:

### Passo A: Formatar os Dados (`TransactionEncoder`)
O algoritmo não entende texto ("Leite", "Pão"). Ele precisa de uma matriz de 0s e 1s.

**Entrada (Lista de Compras):**
1. [Leite, Pão]
2. [Leite, Fralda]
3. [Pão]

**Saída (One-Hot Encoding):**
| | Leite | Pão | Fralda |
| :--- | :---: | :---: | :---: |
| **Cesta 1** | 1 | 1 | 0 |
| **Cesta 2** | 1 | 0 | 1 |
| **Cesta 3** | 0 | 1 | 0 |

### Passo B: Encontrar Itemsets Frequentes (`apriori`)
O algoritmo varre a tabela acima procurando combinações que aparecem mais do que o `min_support` definido.

```python
# min_support=0.01 significa: "Ignore tudo que aparece em menos de 1% das compras"
frequent_itemsets = apriori(df_trans, min_support=0.01, use_colnames=True)
```
*Por que definir um suporte mínimo?* Para eliminar ruído e combinações raras que não geram lucro ou insight.

### Passo C: Gerar as Regras (`association_rules`)
Pega os itens frequentes e calcula Confiança e Lift.

```python
# metric="lift", min_threshold=1.0
# "Mostre-me apenas regras onde um produto AUMENTA a venda do outro"
rules = association_rules(frequent_itemsets, metric="lift", min_threshold=1.0)
```

---

## 4. Visualizando os Resultados

Geralmente usamos um **Scatter Plot** (Gráfico de Dispersão) para analisar centenas de regras de uma vez.

- **Eixo X (Suporte)**: Regras mais à direita são mais populares.
- **Eixo Y (Confiança)**: Regras mais ao topo são mais certeiras.
- **Cor/Tamanho (Lift)**: Regras mais escuras/grandes são as mais valiosas (associação mais forte).

### Exemplo de Interpretação Gráfica
> Se você ver um ponto no **canto superior direito** que é **grande e escuro**:
> - É um produto que sai muito (Suporte alto).
> - Quase sempre sai junto com o par (Confiança alta).
> - A relação é muito forte (Lift alto).
> **Ação:** Criar um combo promocional com esses itens!

---

## Resumo
1. **Prepare os dados**: Transforme listas de compras em tabela de 0/1.
2. **Filtre a frequência**: Use `apriori` com `min_support` para achar o que é comum.
3. **Crie as regras**: Use `association_rules` filtrando por `lift > 1`.
4. **Analise**: Procure regras com alta Confiança e alto Lift para tomar decisões de negócio.

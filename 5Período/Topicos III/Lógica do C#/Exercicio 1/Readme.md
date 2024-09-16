# Atividade de lógica com C#

- **Você deve criar um algoritmo em C# (console app) utilizando estruturas de condição e repetição, e aplicando funções para simular o seguinte cenário:**

### Cenário

Existe uma sociedade composta por 1.000 pessoas economicamente ativas, em que todo o dinheiro circula entre quatro entidades principais:

- **Prefeitura**
- **Comércio**
- **Indústria**
- **Serviços Sociais**


O ciclo de simulação será executado mensalmente, e cada execução do laço de repetição representará um mês. Ao completar 12 ciclos, será simulada a passagem de um ano. O processo continuará até que a **Indústria**  não tenha mais valores suficientes em caixa para operar ou que o **Comércio** não consiga mais adquirir materiais da **Indústria** .


### Dinâmica do ciclo mensal:

- **Pagamentos de salários e recolhimento de impostos:**
As entidades pagam os salários aos seus colaboradores, e os impostos sobre esses salários são recolhidos.


- **Compras no comércio:**
Todos os membros da sociedade gastam todo o seu salário comprando itens no Comércio.
O Comércio repõe seu estoque a cada ciclo, adquirindo produtos da Indústria.


- **Interrupção do ciclo:**
O ciclo é interrompido se a Indústria não tiver mais dinheiro em caixa para operar ou se o Comércio não puder adquirir produtos da Indústria.
Entidades e seus parâmetros iniciais

---

## Descrição de entidades: 

- **Prefeitura:**

1. Emprega: 125 pessoas
2. Salário de cada empregado: R$ 20.000,00
3. Caixa inicial: R$ 0,00
4. Assiste 55 pessoas com serviços sociais (paga uma bolsa de R$ 1.000,00 para cada uma).


- **Comércio:**

1. Emprega: 200 pessoas
2. Salário de cada empregado: R$ 7.500,00
3. Caixa inicial: R$ 10.000.000,00
4. Custo de reposição de estoque: R$ 75,00 por item adquirido da Indústria

5. Preço de venda de cada item no comércio: R$ 203,00

6. O Comércio precisa ter estoque suficiente para atender toda a população economicamente ativa. Se não conseguir repor o estoque, a simulação deve ser interrompida.


- **Indústria:**

1. Emprega todas as outras 675 pessoas
2. Salário de cada empregado: R$ 10.000,00
3. Caixa inicial: R$ 50.000.000,00
4. Custo de produção de cada item: R$ 42,75
5. Preço de venda de cada item para o Comércio: R$ 75,00


### Regras de impostos

- **Impostos sobre salários:**
1. Para cada colaborador, a empresa e o comércio pagam 61% de impostos sobre o salário bruto.

2. O colaborador tem 25% do seu salário descontado como imposto.


- **Impostos sobre vendas:**

1. Comércio: Recolhe 38% de impostos sobre cada item vendido. Ou seja, ao vender um item por R$ 100,00, o Comércio retém R$ 62,00.
2. Indústria: Recolhe 18% de impostos sobre cada item vendido ao Comércio.


### Regras para os beneficiários dos serviços sociais:

1. Não pagam impostos sobre os benefícios recebidos, mas pagam impostos sobre as compras que fazem no comércio.


### Tarefas

1. Simule os ciclos mensais, imprimindo ao final de cada ano a condição financeira de cada entidade.

2. Apresente o número total de ciclos (anos) até que uma das entidades não tenha mais dinheiro para continuar operando (se acontecer).

---

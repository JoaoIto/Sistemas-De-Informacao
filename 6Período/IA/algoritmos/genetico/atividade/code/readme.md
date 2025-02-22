# 📌 **Documentação: Algoritmo Genético com Corte**  

## 🔹 **Descrição**  

Este código implementa um **Algoritmo Genético (AG) com corte** no cruzamento. O corte define um ponto onde os genes dos pais são trocados para gerar os filhos.  

Ele resolve um problema de otimização, onde tentamos maximizar uma função de aptidão.  

---

## ⚙️ **Etapas do Algoritmo**  

1. **Inicialização**: Criamos uma população inicial aleatória.  
2. **Avaliação**: Calculamos a aptidão de cada indivíduo.  
3. **Seleção**: Selecionamos os melhores indivíduos para reprodução.  
4. **Cruzamento com Corte**: Geramos novos indivíduos a partir de um ponto de corte nos pais.  
5. **Mutação**: Aplicamos pequenas modificações aleatórias para manter a diversidade.  
6. **Iteração**: Repetimos o processo até atingir um critério de parada.  

---

## 📝 **Código em Python**  
A seguir, temos a implementação do Algoritmo Genético com corte no cruzamento.  

```python
import random

# Função de aptidão: maximizar a soma dos bits
def fitness(individuo):
    return sum(individuo)

# Criar um indivíduo aleatório
def criar_individuo(tamanho):
    return [random.randint(0, 1) for _ in range(tamanho)]

# Criar uma população inicial
def criar_populacao(tamanho_populacao, tamanho_individuo):
    return [criar_individuo(tamanho_individuo) for _ in range(tamanho_populacao)]

# Seleção por torneio (escolhe os melhores indivíduos)
def selecao(populacao):
    torneio = random.sample(populacao, 2)  # Seleciona 2 indivíduos aleatoriamente
    return max(torneio, key=fitness)  # Retorna o melhor indivíduo

# Cruzamento com corte em um ponto
def cruzamento(pai1, pai2):
    corte = random.randint(1, len(pai1) - 1)  # Define o ponto de corte
    filho1 = pai1[:corte] + pai2[corte:]
    filho2 = pai2[:corte] + pai1[corte:]
    return filho1, filho2

# Mutação: inverte um bit aleatoriamente
def mutacao(individuo, taxa_mutacao=0.1):
    for i in range(len(individuo)):
        if random.random() < taxa_mutacao:
            individuo[i] = 1 - individuo[i]  # Inverte o bit (0 ↔ 1)
    return individuo

# Algoritmo Genético Principal
def algoritmo_genetico(tamanho_populacao=10, tamanho_individuo=8, geracoes=20, taxa_mutacao=0.1):
    populacao = criar_populacao(tamanho_populacao, tamanho_individuo)

    for geracao in range(geracoes):
        nova_populacao = []

        for _ in range(tamanho_populacao // 2):
            pai1 = selecao(populacao)
            pai2 = selecao(populacao)
            filho1, filho2 = cruzamento(pai1, pai2)
            nova_populacao.append(mutacao(filho1, taxa_mutacao))
            nova_populacao.append(mutacao(filho2, taxa_mutacao))

        populacao = nova_populacao  # Atualiza a população

        melhor = max(populacao, key=fitness)
        print(f"Geração {geracao+1}: Melhor solução {melhor} com aptidão {fitness(melhor)}")

    return max(populacao, key=fitness)  # Retorna o melhor indivíduo encontrado

# Executando o Algoritmo Genético
melhor_solucao = algoritmo_genetico()
print(f"\nMelhor solução encontrada: {melhor_solucao} com aptidão {fitness(melhor_solucao)}")
```

---

## 📊 **Explicação do Código**  

| **Seção**        | **Descrição** |
|------------------|--------------|
| **fitness(individuo)** | Avalia a qualidade da solução, somando os bits do indivíduo. |
| **criar_individuo(tamanho)** | Gera um vetor binário aleatório. |
| **criar_populacao(tamanho_populacao, tamanho_individuo)** | Cria a população inicial de soluções. |
| **selecao(populacao)** | Escolhe os melhores indivíduos usando um torneio. |
| **cruzamento(pai1, pai2)** | Realiza o cruzamento com um ponto de corte aleatório. |
| **mutacao(individuo, taxa_mutacao)** | Altera bits aleatoriamente para evitar estagnação. |
| **algoritmo_genetico(...)** | Função principal que gerencia todas as etapas do AG. |

---

## 🎯 **Exemplo de Execução**  

Saída do programa:  

```
Geração 1: Melhor solução [1, 1, 0, 1, 1, 0, 0, 1] com aptidão 5
Geração 2: Melhor solução [1, 1, 1, 1, 1, 0, 1, 1] com aptidão 7
...
Geração 20: Melhor solução [1, 1, 1, 1, 1, 1, 1, 1] com aptidão 8

Melhor solução encontrada: [1, 1, 1, 1, 1, 1, 1, 1] com aptidão 8
```

💡 **O AG encontra a solução ótima (todos os bits `1`), maximizando a aptidão.**  

---

## 🔥 **Conclusão**  

Esse Algoritmo Genético com corte é eficiente para encontrar soluções ótimas, garantindo diversidade por meio de cruzamento e mutação.  

---

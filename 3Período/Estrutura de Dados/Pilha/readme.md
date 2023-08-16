# Pilha (Stack) em Java

Uma **pilha** é uma estrutura de dados linear que segue o princípio LIFO (*Last In, First Out*), o que significa que o último elemento inserido é o primeiro a ser removido. Isso se assemelha à maneira como objetos são empilhados e retirados de uma pilha do mundo real, como pratos em uma pilha ou livros em uma mesa.

## Conceito LIFO

- **Last In, First Out (LIFO)**: O último elemento inserido em uma pilha é o primeiro a ser removido. Em outras palavras, o elemento que é adicionado mais recentemente é o próximo a ser retirado.

## Métodos da Classe Pilha

### Construtor

```java
Pilha(int capacidade)
```

O construtor cria uma instância de uma pilha com a capacidade especificada.

### Push

```java
void push(int valor)
```

Adiciona um elemento no topo da pilha.

### Pop

```java
void pop()
```

Remove o elemento do topo da pilha.

### Imprime

```java
void imprime()
```

Exibe os elementos da pilha, do topo para a base.

### Tamanho

```java
int tamanho()
```

Retorna o número de elementos preenchidos na pilha.

### isEmpty

```java
boolean isEmpty()
```

Verifica se a pilha está vazia.

### isFull

```java
boolean isFull()
```

Verifica se a pilha está cheia.

## Exemplo de Uso

```java
Pilha pilha = new Pilha(5);

pilha.push(10);
pilha.push(20);
pilha.push(30);

pilha.imprime();
System.out.println("Tamanho da pilha: " + pilha.tamanho());

pilha.pop();
pilha.imprime();
System.out.println("Tamanho da pilha: " + pilha.tamanho());
```

---
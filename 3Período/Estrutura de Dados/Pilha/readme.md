# Pilha (Stack) em Java 

- Aluno: João Victor Póvoa França

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
public void push(int valor) {
        verificaCheia();
        array[tamanho] = valor;
        tamanho++;
        }
```

Adiciona um elemento no topo da pilha.

### Pop

```java
public void pop() {
        verificaVazio();
        tamanho--;
        System.out.println("Valor deletado é: " + array[tamanho]);
        array[tamanho] = 0;
        }
```

Remove o elemento do topo da pilha.

### Imprime

```java
public void imprime() {
        verificaVazio();
        System.out.println("Pilha: ");
        for (int i = tamanho - 1; i >= 0; i--) {
        System.out.print("" + array[i] + " ");
        }
        System.out.println("\n");
        }
```

Exibe os elementos da pilha, do topo para a base.

### Tamanho

```java
public void tamanho(){
        System.out.println("Tamanho da pilha: " + tamanho);
        }
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
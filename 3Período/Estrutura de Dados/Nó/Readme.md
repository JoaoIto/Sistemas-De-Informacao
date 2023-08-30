ListaEncadeada

A classe `ListaEncadeada` implementa uma lista encadeada simples em Java. A lista é composta por nós, onde cada nó contém um elemento e uma referência para o próximo nó na lista. Esta implementação inclui diversas funcionalidades para manipulação da lista.

## Construtor

```java
public ListaEncadeada()
```

O construtor inicializa uma lista encadeada vazia, configurando o primeiro nó e o último nó como `null` e o tamanho como zero.




## Métodos Principais

### Inserir Nó no Final da Lista

```java
public void inserirNoFinal(String elemento)
```

Este método insere um novo nó contendo o elemento fornecido no final da lista. Se a lista estiver vazia, o novo nó será o primeiro e o último nó. Caso contrário, o novo nó será anexado ao último nó existente.

### Obter Tamanho da Lista

```java
public int getTamanho()
```

Retorna a quantidade de nós na lista.

### Percorrer a Lista (Imprimir)

```java
public void percorrer()
```

Percorre a lista, imprimindo cada elemento dos nós.

### Limpar a Lista

```java
public void limpar()
```

Remove todos os elementos da lista, deixando-a vazia.

### Pesquisar Nó em Posição Específica

```java
public No pesquisar(int posicao)
```

Pesquisa e retorna o nó na posição especificada na lista. Retorna `null` se a posição for inválida.

### Inserir em Posição Específica

```java
public void inserirNaPosicao(String elemento, int posicao)
```

Insere um novo nó contendo o elemento fornecido na posição especificada da lista. Se a posição for inválida, uma exceção é lançada. Se a posição for igual ao tamanho da lista, o nó é inserido no final.

### Remover Nó no Início da Lista

```java
public void removerInicio()
```

Remove o primeiro nó da lista. Se a lista estiver vazia após a remoção, o último nó também é ajustado para `null`.

### Remover Nó no Final da Lista

```java
public void removerFinal()
```

Remove o último nó da lista. Se a lista tiver apenas um nó, ela é limpa. O último nó anterior ao removido é ajustado como o novo último nó.

### Remover de Qualquer Posição da Lista

```java
public void removerNaPosicao(int posicao)
```

Remove o nó na posição especificada da lista. Se a posição for inválida, uma exceção é lançada. Se a posição for o início ou o final da lista, os ajustes são feitos adequadamente.

### Inserir de Forma Ordenada na Lista

```java
public void inserirOrdenado(String elemento)
```

Insere um novo nó contendo o elemento fornecido de forma ordenada na lista. Se a lista estiver vazia ou o elemento for menor que o primeiro nó, o novo nó se torna o primeiro. Caso contrário, o elemento é inserido no local adequado mantendo a ordem.

## Autor

* Seu Nome

Esta documentação foi criada para explicar os métodos da classe `ListaEncadeada` e como eles foram implementados.
```

Lembre-se de substituir "Seu Nome" pelo seu nome ou identificação no autor. Certifique-se também de incluir o código fonte da classe `No` no seu repositório do GitHub para que os leitores da documentação possam entender todo o contexto.

---
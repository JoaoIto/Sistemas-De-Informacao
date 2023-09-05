# Documentação da Classe FilaDinamica

Este projeto contém uma implementação de Fila Dinâmica em Java, com métodos para manipulação dessa estrutura de dados.

## Classe FilaDinamica

A classe `FilaDinamica` representa uma fila dinâmica, onde os elementos são armazenados e recuperados em uma ordem "primeiro a entrar, primeiro a sair" (FIFO).

### Métodos

#### `FilaDinamica()`

Construtor da classe que cria uma fila vazia.

#### `tamanho()`

Retorna o número de elementos na fila.

#### `estaVazia()`

Verifica se a fila está vazia e retorna `true` se estiver vazia, `false` caso contrário.

#### `inserir(T elemento)`

Adiciona um elemento à fila.

- `elemento`: O elemento a ser adicionado à fila.

#### `retirar()`

Remove e retorna o elemento da frente da fila.

- Retorna: O elemento removido da frente da fila.

#### `listarItens()`

Exibe os elementos da fila na ordem em que foram inseridos.

## Exemplo de Uso

Aqui está um exemplo de uso da classe `FilaDinamica`:

```java
public class ExemploDeUso {
    public static void main(String[] args) {
        // Criar uma fila dinâmica
        FilaDinamica<Integer> fila = new FilaDinamica();

        // Inserir elementos
        fila.inserir(10);
        fila.inserir(20);

        // Retirar elementos
        int elementoFrente = fila.retirar();

        // Exibir tamanho e itens
        System.out.println("Tamanho da fila: " + fila.tamanho());
        System.out.println("A fila está vazia? " + fila.estaVazia());
        System.out.print("Itens da fila: ");
        fila.listarItens();
    }
}

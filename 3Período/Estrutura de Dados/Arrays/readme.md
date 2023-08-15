# Manipulador de Array em Java

Essa classe Java é um exemplo simples de como manipular um array utilizando métodos para inserção, alteração e listagem de informações.

## Como usar

1. Instancie a classe `Array`.
2. Escolha uma opção do menu para realizar uma ação no array.
3. Siga as instruções do menu para inserir, alterar ou listar informações no array.

## Métodos

### `inserirNoPrimeiroIndiceVazio(int valor)`

Esse método insere um valor no primeiro índice vazio do array.

Parâmetros:
- `valor` (int): O valor a ser inserido no array.

### `inserirNoIndice(int indice, int valor)`

Esse método insere um valor em um índice específico do array.

Parâmetros:
- `indice` (int): O índice onde o valor será inserido.
- `valor` (int): O valor a ser inserido no array.

### `alterarInformacao(int indice, int novoValor)`

Esse método altera um valor existente no array em um índice específico.

Parâmetros:
- `indice` (int): O índice do valor a ser alterado.
- `novoValor` (int): O novo valor que substituirá o valor atual no array.

### `listarInformacoes()`

Esse método lista todas as informações presentes no array.

### `main(String[] args)`

O método `main` é responsável por executar um loop do-while que exibe um menu interativo para o usuário escolher qual ação deseja realizar.

## Exemplo de Uso

```java
public static void main(String[] args) {
    Array manipulador = new Array(5);

    manipulador.inserirNoPrimeiroIndiceVazio(42);
    manipulador.inserirNoPrimeiroIndiceVazio(17);

    // Resto do código do menu
}
```

## Notas

- O array tem um tamanho fixo definido durante a criação da instância da classe.
- Certifique-se de que os índices passados como parâmetros estejam dentro dos limites do array.

---
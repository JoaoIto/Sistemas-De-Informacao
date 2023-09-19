# ListaDuplamenteEncadeada:

A principal diferença entre a classe ListaEncadeada original e a classe ListaDupla refatorada é que a segunda mantém uma referência para o nó anterior em cada nó, criando assim uma lista duplamente encadeada. Além disso, os métodos foram adaptados para refletir essa mudança na estrutura da lista.

Agora, você tem uma lista duplamente encadeada que pode ser percorrida nos dois sentidos, do primeiro ao último nó e do último ao primeiro nó, usando as referências proximo e anterior.

## Lista circular

É basicamente uma lista, na qual entendemos que sempre os nós são circulares, e apontam um para o outro
tanto ainda, que sempre quando os nós das pontas, seja o ultimo ou o primeiro, devem apontar para null sempre, e ainda sim
se conectar entre eles.

---

## Documentação:

O método padrão de inserção, é sempre no fim, considerando que existem outros elementosque já existem na lista de nós.
Para a criação do método ***``inserirNoFim()``***

### ***``inserirNoFim()``***
````java
public void inserirNoFim(int dado) {
        NoDuplo novoNo = new NoDuplo(dado);
        if (tamanho == 0) {
            // Se a lista estiver vazia, define o primeiro nó como o novo nó.
            primeiroNo = novoNo;
        } else {
            NoDuplo ultimo = primeiroNo;
            while (ultimo.proximo != null) {
                ultimo = ultimo.proximo;
            }
            novoNo.anterior = ultimo;
            ultimo.proximo = novoNo;
        }
        tamanho++;
    }
````

- Cria-se um novo nó, e depois isso, verificando sempre se já existem outros elementos, não existindo, a inserção é comum.
Porém já não existindo, a inserção é feita, basicamente considerando o ultimo elemento, que é um atributo comum da classe, e assim
- E assim, só precisamos considerar o novoNo como o ultimo, e assim o ultimo como próximo nó, que será executado posteriormente.

### ***``removerNoFim()``***

Do mesmo modo, é considerado o método de ***``inserirNoFim()``***, que só precisamos desconsiderar por índice, e como é comum, os atributos
da classe de ultimoNo, primeiroNo, etc... Basicamente refatoramos os valores em cada um deles.

````java
public void removerDoFim() {
        if (tamanho <= 1) {
            limpar();
        } else {
            NoDuplo noRemovido = ultimoNo;
            ultimoNo = noRemovido.anterior;
            ultimoNo.proximo = null;
            tamanho--;
        }
    }
````

---

### ***``imprimirDecrescente()``***

Um dos outros métodos, mais importantes, temos o de impressão dos nós, o que pode afetar diretamente a parte de posicionamento de índices para os 
valores da lista de nós. Entendendo seus valores inteiros e assim os gerenciando dependendo de cada valor.

````java
public void imprimirDecrescente() {
        NoDuplo atual = ultimoNo;
        System.out.print("null <-> ");
        while (atual != null) {
            System.out.print(atual.dado + " <-> ");
            atual = atual.anterior;
        }
        System.out.println("null");
    }
````

### ***``imprimirCrescente()``***

Da mesma forma, temos o método crescente, que vai se mostrar a posição também desses índices, de forma a mostrar eles dependendo também de seus valores inteiros, sendo diferenciados de menor para maior, como o próprio nome diz.

````java
public void imprimirCrescente() {
        NoDuplo atual = primeiroNo;
        System.out.print("null <-> ");
        while (atual != null) {
        System.out.print(atual.dado + " <-> ");
        atual = atual.proximo;
        }
        System.out.println("null");
        }
````

---
# Árvore AVL:

## Qual a diferença de Árvore AVL para a Árvore Binária comum?

A árvore binária AVL é o tipo de árvore que a diferença se dá pelo seu fator automático de balanceamento.
Em teoria se deve a isso, já que ela por si só para ser considerada uma árvore AVL, já deve estar
corretamente balanceada.

---

## Code: 

Para isso, como podemos entender as diferenças de formação de uma árvore binária, devido
a esse fator de balanceamento automático?

Começamos a partir definindo o que são as rotações que definem o balanceamento...

### Rotação a esquerda: 

A rotação à esquerda é aplicada quando há um desbalanceamento à esquerda em um nó, ou seja, o filho esquerdo tem uma altura maior que a altura do filho direito. Isso geralmente ocorre quando uma nova chave é inserida no subárvore à direita do filho esquerdo.

````java
private No rotacaoEsquerda(No y) {
        No x = y.direita;
        No esquerdaDoAtual = x.esquerda;

        x.esquerda = y;
        y.direita = esquerdaDoAtual;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
        }

````

- y: O nó desbalanceado que precisa ser rotacionado.
- x: O novo nó raiz após a rotação.
- esquerdaDoAtual: A subárvore que precisa ser movida da esquerda de x para a direita de y.


Essa rotação reorganiza os nós de forma a preservar a propriedade de árvore de busca binária e atualiza as alturas dos nós afetados.

#### Rotação a direita:

A rotação à direita é aplicada quando há um desbalanceamento à direita em um nó, ou seja, o filho direito tem uma altura maior que a altura do filho esquerdo. Isso geralmente ocorre quando uma nova chave é inserida no subárvore à esquerda do filho direito.

````java
private No rotacaoDireita(No x) {
        No y = x.esquerda;
        No direitaDoAtual = y.direita;

        y.direita = x;
        x.esquerda = direitaDoAtual;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }
````

- x: O nó desbalanceado que precisa ser rotacionado.
- y: O novo nó raiz após a rotação.
- direitaDoAtual: A subárvore que precisa ser movida da direita de y para a esquerda de x.

---

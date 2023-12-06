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
    No T2 = x.esquerda;

    // Realizar a rotação
    x.esquerda = y;
    y.direita = T2;

    // Atualizar alturas
    atualizarAltura(y);
    atualizarAltura(x);

    // Retorna a nova raiz
    return x;
}

````

- y: O nó desbalanceado que precisa ser rotacionado.
- x: O novo nó raiz após a rotação.
- T2: A subárvore que precisa ser movida da esquerda de x para a direita de y.


Essa rotação reorganiza os nós de forma a preservar a propriedade de árvore de busca binária e atualiza as alturas dos nós afetados.


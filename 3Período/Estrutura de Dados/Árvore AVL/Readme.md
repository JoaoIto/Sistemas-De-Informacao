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

### Balanceando:

E assim usando as rotações de direita e esquerda e assim a partir do fator de balanceamento, ele retorna
o que consegue balancear corretamente.

````java
public No balancear(No no) {
        if (no == null) {
            return null;
        }

        // Calcular o fator de balanceamento do nó
        int fatorBalanceamento = alturaNo(no.esquerda) - alturaNo(no.direita);

        // Caso do fator de balanceamento positivo (desbalanceamento à esquerda)
        if (fatorBalanceamento > 1) {
            // Caso LL: Rotação à direita
            if (alturaNo(no.esquerda.esquerda) >= alturaNo(no.esquerda.direita)) {
                return rotacaoDireita(no);
            } else { // Caso LR: Rotação à esquerda e depois à direita
                no.esquerda = rotacaoEsquerda(no.esquerda);
                return rotacaoDireita(no);
            }
        }
        // Caso do fator de balanceamento negativo (desbalanceamento à direita)
        else if (fatorBalanceamento < -1) {
            // Caso RR: Rotação à esquerda
            if (alturaNo(no.direita.direita) >= alturaNo(no.direita.esquerda)) {
                return rotacaoEsquerda(no);
            } else { // Caso RL: Rotação à direita e depois à esquerda
                no.direita = rotacaoDireita(no.direita);
                return rotacaoEsquerda(no);
            }
        }
        return no;
    }
````

- **Cálculo do Fator de Balanceamento:**

int fatorBalanceamento = alturaNo(no.esquerda) - alturaNo(no.direita);: Calcula o fator de balanceamento do nó atual subtraindo a altura da subárvore à esquerda pela altura da subárvore à direita.

- **Verificações e Rotações:**

Se fatorBalanceamento for maior que 1, há desbalanceamento à esquerda. São feitas verificações para determinar se é um caso de rotação simples à direita (LL) ou uma combinação de rotações à esquerda e à direita (LR). As rotações são realizadas pelos métodos rotacaoDireita e rotacaoEsquerda.

Se fatorBalanceamento for menor que -1, há desbalanceamento à direita. Novamente, são feitas verificações para determinar se é um caso de rotação simples à esquerda (RR) ou uma combinação de rotações à direita e à esquerda (RL). As rotações são realizadas pelos métodos rotacaoEsquerda e rotacaoDireita.

- **Retorno do Nó Balanceado:**

Se o nó não estiver desbalanceado ou após as rotações, retorna o nó atual. Isso é necessário para garantir que a árvore seja atualizada corretamente após as operações de balanceamento.


---

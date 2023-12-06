# Arvore Binaria

- Aluno: **João Victor Póvoa França**

Esse é um dos exercícios mais bem conhecidos pela matéria de estrutura de dados, 
e pra quem realmente quer estudar a fundo os códigos, sua complexidade, e como 
seu funcionamento realmente vai ser a partir das linhas.

- Método remove:

````java
 public void removerNo(int elemento) {
        this.noRaiz = remover(this.noRaiz, elemento);
    }

    private No remover(No raiz, int elemento) {
        if (raiz == null) {
            return raiz;
        }

        if (elemento < raiz.elemento) {
            raiz.esquerda = remover(raiz.esquerda, elemento);
        } else if (elemento > raiz.elemento) {
            raiz.direita = remover(raiz.direita, elemento);
        } else {
            // Nó com um único filho ou nenhum filho
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }

            // Nó com dois filhos: encontre o nó sucessor e substitua
            raiz.elemento = encontrarMinimo(raiz.direita);
            raiz.direita = remover(raiz.direita, raiz.elemento);
        }
        return raiz;
    }
````
**Parte sempre do princípio de remoção daquele elemento que é maior ou menor a partir de um
nó raiz, que tem seus nós folhas, ou seja, considere os dois, entenda qual é maior ou menor, percorrendo, 
e assim depois apenas remova o elemento que é necessário...**


- ``alturaArvore()``

````java
public int alturaArvore(No noArvore){
        if(noArvore == null){
            return -1;
        }
        else{
            int ae = alturaArvore(noArvore.esquerda);
            int ad = alturaArvore(noArvore.direita);

            if(ae < ad){
                return ad + 1;
            }else{
                return ae + 1;
            }
        }
    }
````

**A função que mede a altura inteira da árvore, é medida a partir do nó raiz, 
que consegue percorer todos os filhos desse nós raiz, e depois considerando este filho como mais 1, 
entendendo que o nó raiz sempre começa com 0.**

A função entende que ela começa a partir de 0, então entende-se que ele retorna como 1, pois 
se a árvore é nula, logo ela não existe, pois então, retornaria um valor que é impossível, sendo
"-1".



---

## Balanceamento da árvore binária:

Em uma árvore binária, muito utilizada para o cálculo de estabilidade de elementos, onde
é calculado a partir de seu fator de balanceamento, que seria:

```
Fator de balanceamento = altura esquerda - altura direita => (-1, 0, 1)
```

Para que uma árvore binária esteja balanceada, seu resultado do fator de balanceamento seria
aceitável quando seu resultado é entre (-1, 0, 1), a árvore está balanceada.



### Em code:

````java

````

---
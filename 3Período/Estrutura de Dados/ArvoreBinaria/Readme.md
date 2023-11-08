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


---
package classes;

public class ArvoreBinaria {
    public No noRaiz;
    public ArvoreBinaria(){
        this.noRaiz = null;
    }

    public void inserirNo( No noArvore,  int elemento){

        if(noArvore == null) {
            this.noRaiz = new No(elemento);
            System.out.println(this.noRaiz.elemento);
        }

        else if(elemento < noArvore.elemento) {
            if (noArvore.esquerda == null) {
                noArvore.esquerda = new No(elemento);
                System.out.println(elemento);
            }
            else
                inserirNo(noArvore.esquerda, elemento);
        }
        else if(elemento > noArvore.elemento){
            if(noArvore.direita == null) {
                noArvore.direita = new No(elemento);
                System.out.println(elemento);
            }
            else
                inserirNo(noArvore.direita, elemento);
        }
    }

    public void emOrdem(No noArvore){
        if(noArvore.esquerda != null){
            emOrdem(noArvore.esquerda);
        }
        System.out.print(" " + noArvore.elemento);
        if(noArvore.direita != null){
            emOrdem(noArvore.direita);
        }
    }


    public void preOrdem(No noArvore){
        System.out.print(" " + noArvore.elemento);
        if (noArvore.esquerda != null){
            preOrdem(noArvore.esquerda);
        }
        if (noArvore.direita != null){
            preOrdem(noArvore.direita);
        }
    }

    public void posOrdem(No noArvore){
        if(noArvore.esquerda != null){
            posOrdem(noArvore.esquerda);
        }
        if(noArvore.direita != null){
            posOrdem(noArvore.direita);
        }
        System.out.print(" " + noArvore.elemento);
    }

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

    private int encontrarMinimo(No raiz) {
        int minimo = raiz.elemento;
        while (raiz.esquerda != null) {
            minimo = raiz.esquerda.elemento;
            raiz = raiz.esquerda;
        }
        return minimo;
    }

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
}
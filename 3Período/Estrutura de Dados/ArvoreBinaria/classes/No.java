package classes;

public class No {
    public int elemento;
    public No esquerda;
    public No direita;
    public int altura;

    public No(int elemento) {
        this.elemento = elemento;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}

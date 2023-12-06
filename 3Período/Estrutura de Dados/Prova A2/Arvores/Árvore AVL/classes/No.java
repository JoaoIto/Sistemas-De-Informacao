package classes;

public class No {
    public int elemento;
    public No esquerda;
    public No direita;
    public int altura;

    public No(int elemento) {
        this.elemento = elemento;
        this.altura = 1;
    }
}

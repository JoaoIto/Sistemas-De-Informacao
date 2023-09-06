package src.classes;

public class No {
    int dado;
    No proximo;
    No anterior;

    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }
}

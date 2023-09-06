package src.classes;

public class NoDuplo {
    int dado;
    NoDuplo proximo;
    NoDuplo anterior;

    public NoDuplo(int dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }
}

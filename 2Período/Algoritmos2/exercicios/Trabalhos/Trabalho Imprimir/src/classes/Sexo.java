package src.classes;

public enum Sexo {
    MASCULINO(0),
    FEMININO(1);

    private final int valor;

    Sexo(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

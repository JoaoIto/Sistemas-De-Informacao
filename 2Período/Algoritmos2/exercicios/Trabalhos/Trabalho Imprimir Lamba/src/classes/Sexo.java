package src.classes;

public enum Sexo {
    MASCULINO(0,"Masculino"),
    FEMININO(1, "Femino");

    private final int valor;
    private final String label;

    Sexo(int valor, String label) {
        this.valor = valor;
        this.label = label;
    }

    public int getValor() {
        return valor;
    }

    public String getLabel() {
        return label;
    }
}

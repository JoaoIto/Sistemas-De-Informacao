package src.enums;

public enum Cor {
    BRANCA(1, "branca"),
    PRETA(2, "preta"),
    AZUL(3, "azul"),
    AMARELA(4,"amarela"),
    VERDE(5, "verde");

    private int id;
    private String label;

    private Cor(int id, String label){
        this.id = id;
        this.label = label;
    }
}
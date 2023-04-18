package src.enums;

public enum Cor {
    BRANCA(1, "branca", "#ffffff"),
    PRETA(2, "preta", "#000000"),
    AZUL(3, "azul", "#000fff"),
    AMARELA(4,"amarela", "#FFFF00"),
    VERDE(5, "verde", "#008000");

    private int id;
    private String label;
    private String hexa;

    private Cor(int id, String label, String hexa){
        this.id = id;
        this.label = label;
    }
}
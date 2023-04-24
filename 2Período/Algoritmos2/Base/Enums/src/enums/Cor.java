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
        this.hexa = hexa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHexa() {
        return hexa;
    }

    public void setHexa(String hexa) {
        this.hexa = hexa;
    }

    @Override
    public String toString() {
        return "Cor{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", hexa='" + hexa + '\'' +
                '}';
    }

    public static Cor valueOf(Integer id){
        if(id == null){
            return null;
        }
        for (Cor cor: Cor.values()) {
            if(cor.getId() == id){
                return cor;
            }
        }
        return null;
    }
}
package src.enums;

public enum Prioridade {
    COMUM(1, "comum"),
    IMPORTANTE(2, "importante"),
    PRIORITARIA(3, "prioritária");

    private int id;
    private String label;

    Prioridade(int id, String label) {
        this.id = id;
        this.label = label;
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
}

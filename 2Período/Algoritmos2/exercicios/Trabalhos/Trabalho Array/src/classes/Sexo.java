package src.classes;

public enum Sexo {
    MASCULINO(1, "MASCULINO"),
    FEMININO(2, "FEMININO");

    private String label;
    private int id;

    Sexo(int i, String string) {
        this.id =  id;
        this.label = string;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package src.enums;

public enum TipoUsuario {
    ALUNO(1, "aluno"),
    PROFESSOR(2, "professor"),
    ADMIN(3, "admin");

    private int id;
    private String label;

    TipoUsuario(int id, String label) {
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
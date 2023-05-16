package src.classes;

public enum Sexo {
    MASCULINO(0,"Masculino"),
    FEMININO(1, "Femino");

    private final Integer valor;
    private final String label;

    Sexo(int id, String label) {
        this.valor = id;
        this.label = label;
    }

    public Integer getId() {
        return valor;
    }

    public String getLabel() {
        return label;
    }

    public static Sexo valueOf(Integer id){
        if(id != null)
        for (Sexo sexo : Sexo.values()) {
            if(sexo.getId().equals(id))
                return sexo;
        }
        return null;
    }
}

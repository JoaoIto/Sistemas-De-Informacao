package src.classes;

import src.enums.Prioridade;

public class Etiqueta {
    private String tipo;
    private String descricao;

    public Etiqueta(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Descrição: " + descricao;
    }
}

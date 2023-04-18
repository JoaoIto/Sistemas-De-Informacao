package Classes.Associacao;

import java.util.List;

public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private List<Professor> professores;

    public Disciplina(String nome, int cargaHoraria, List<Professor> professores) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professores = professores;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessor(List<Professor> professores) {
        this.professores = professores;
    }
}

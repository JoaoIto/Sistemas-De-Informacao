package Classes.Associacao;
import java.util.List;

// Relação de associação;

/* Entendo que esta é a classe principal, já que
herda elementos de outra classe, que por ela mesma
já a herdar elemento de outra classe. E assim temos:

- Um objeto da classe Aluno tem uma referência para um
ou mais objetos da classe Disciplina, indicando que
o aluno está matriculado nessas disciplinas;

- Um objeto da classe Disciplina tem uma referência para um
objeto da classe Professor, indicando que o professor é responsável
por ministrar aquela disciplina.

 */
public class Aluno {
    private String nome;
    private int idade;
    private String matricula;
    private List<Disciplina> disciplinas;

    public Aluno(String nome, int idade, String matricula, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.disciplinas = disciplinas;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}

package src.Classes;

public class Funcionario {
    private String nome;
    private Funcionario chefeImediato;

    public Funcionario(String nome) {
        super();
        this.nome = nome;
    }

    public Funcionario getChefeImediato() {
        return chefeImediato;
    }

    public void setChefeImediato(Funcionario chefeImediato) {
        this.chefeImediato = chefeImediato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void imprimir(){
        System.out.println("Nome funcionario: " + getNome());
        if(getChefeImediato() == null){
            System.out.println("Chefe máximo!");
        }else
        System.out.println("Chefe Imediato: " + getChefeImediato().getNome());


    }
}

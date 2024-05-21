package src;

public class Processo {
    public int id;
    public int tamanho;

    public Processo(int id, int tamanho) {
        this.id = id;
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", tamanho=" + tamanho +
                '}';
    }
}
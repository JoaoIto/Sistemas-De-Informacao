package src;
public class Particao {
    public int tamanho;
    public int processoID;
    public int fragmentacao;

    public Particao(int tamanho) {
        this.tamanho = tamanho;
        this.processoID = -1;  // -1 indica que a partição está livre
        this.fragmentacao = 0;
    }

    @Override
    public String toString() {
        return "Partição{" +
                "tamanho=" + tamanho +
                ", processoID=" + processoID +
                ", fragmentacao=" + fragmentacao +
                '}';
    }
}
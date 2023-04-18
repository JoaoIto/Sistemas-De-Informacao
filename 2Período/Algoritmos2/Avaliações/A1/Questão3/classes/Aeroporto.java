package Questão3.classes;

public class Aeroporto {
    private String nome;
    private double tamanho;
    private int qntdPistas;
    private int qntdAvioes;

    public Aeroporto(){

    }

    public Aeroporto(String nome, double tamanho, int qntdPistas, int qntdAvioes){
        this.nome = nome;
        this.tamanho = tamanho;
        this.qntdPistas = qntdPistas;
        this.qntdAvioes = qntdAvioes;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public int getQntdPistas() {
        return qntdPistas;
    }

    public void setQntdPistas(int qntdPistas) {
        this.qntdPistas = qntdPistas;
    }

    public int getQntdAvioes() {
        return qntdAvioes;
    }

    public void setQntdAvioes(int qntdAvioes) {
        qntdAvioes = qntdAvioes;
    }
    @Override
    public String toString() {
        return "Aeroporto{" +
                "nome=" + nome +
                ", tamanho='" + tamanho + '\'' +
                ", quantidade aviões ='" + qntdAvioes + '\'' +
                ", quantidade pistas ='" + qntdPistas + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aeroporto)) return false;
        Aeroporto aeroporto = (Aeroporto) o;
        return getNome().equals(aeroporto.getNome()) &&
                getTamanho().equals(aeroporto.getTamanho()) &&
                getQntdAvioes().equals(aeroporto.getQntdAvioes()) &&
                getQntdPistas().equals(aeroporto.getQntdPistas());
    }
    
}

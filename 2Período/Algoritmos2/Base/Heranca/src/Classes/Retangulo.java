package Classes;

public class Retangulo {
    private int altura;

    public Retangulo(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    private int largura;

    public int getLargura() {
        return largura;
    }

    protected void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    protected void setAltura(int altura) {
        this.altura = altura;
    }

    public void imprimir(){
        System.out.println("A altura é de: " + getAltura());
        System.out.println("A largura é de: " + getLargura());
    }
}

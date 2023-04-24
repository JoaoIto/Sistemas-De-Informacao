package src.classes;
import src.enums.Cor;
public class Telefone {
    private String modelo;
    private Cor cor;

    public Cor getColors() {
        return cor;
}
    public void setColors(Cor cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

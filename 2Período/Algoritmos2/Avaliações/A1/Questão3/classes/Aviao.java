package Questão3.classes;

public class Aviao {
    private double peso;
    private String marca;
    private String modelo;
    private double potencia;

    public Aviao() {
    }

    public Aviao(double peso, String marca, String modelo, double potencia) {
        this.peso = peso;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Aviao{" +
                "modelo=" + modelo +
                ", marca='" + marca + '\'' +
                ", peso='" + peso + '\'' +
                ", potencia='" + potencia + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aviao)) return false;
        Aviao aviao = (Aviao) o;
        return getMarca().equals(aviao.getMarca()) &&
                getModelo().equals(aviao.getModelo()) &&
                getPeso().equals(aviao.getPeso()) &&
                getPotencia().equals(aviao.getPotencia());
    }
}

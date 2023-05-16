package src.classes;

public class Telefone implements Impressao {
    private String codigoArea;
    private String numero;

    public Telefone(String codigoArea, String numero) {
        this.codigoArea = codigoArea;
        this.numero = numero;
    }

    // Getters e Setters

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "codigoArea='" + codigoArea + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Código de Área: " + codigoArea);
        System.out.println("Número: " + numero);
    }
}
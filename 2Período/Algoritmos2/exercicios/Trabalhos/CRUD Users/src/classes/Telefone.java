package src.classes;

import java.util.Objects;
import java.util.Scanner;

public class Telefone {
    private String numero;
    private String codigoArea;

    public Telefone(){}

    public Telefone(String numero, String codigoArea) {
        this.numero = numero;
        this.codigoArea = codigoArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    @Override
    public String toString() {
        return "Telefone [codigoArea=" + codigoArea + ", numero=" + numero + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoArea, numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Telefone other = (Telefone) obj;
        return Objects.equals(codigoArea, other.codigoArea) && Objects.equals(numero, other.numero);
    }

    public static Telefone lerDados() {
        Scanner scan = new Scanner(System.in);
        Telefone telefone = new Telefone();

        System.out.println("Informe o codigo de area:");
        telefone.setCodigoArea(scan.next());
        System.out.println("Informe o numero do telefone:");
        telefone.setNumero(scan.next());

        return telefone;
    }
}
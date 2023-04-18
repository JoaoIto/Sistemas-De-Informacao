package src.classes;
import java.util.Scanner;

public class Telefone {
    private int codigoArea;
    public int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Telefone(int codigoArea, int numero) {
        this.codigoArea = codigoArea;
        this.numero = numero;
    }

    public int getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
    }
}

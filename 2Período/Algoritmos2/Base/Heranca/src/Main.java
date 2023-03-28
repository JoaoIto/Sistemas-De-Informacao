import Classes.Quadrado;
import Classes.Retangulo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Retangulo retangulo = new Retangulo(12, 10);
        retangulo.imprimir();

        Quadrado quadrado = new Quadrado(10);
        quadrado.imprimir();
    }
}
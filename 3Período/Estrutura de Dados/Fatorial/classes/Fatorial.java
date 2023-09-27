package classes;

public class Fatorial {
    private int numero;

    public Fatorial(int numero) {
        this.numero = numero;
    }

    public static int fatorar(int numero){
        if(numero == 0){
            return 1;
        }else{
            System.out.println(numero + " * " + (numero - 1));
            return numero * fatorar(numero - 1);
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

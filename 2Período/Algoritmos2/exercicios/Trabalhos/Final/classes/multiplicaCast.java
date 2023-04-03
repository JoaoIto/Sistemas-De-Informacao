package classes;
import classes.matematica;

public class multiplicaCast {
    // Criando classe para multiplicação, transformando valores para int
    // Usando int e double;
    public int multiplica(double n1, double n2){
        int result = (int)(n1 * n2);
        return result;
    }

    public int multiplica(int n1, int n2){
        return n1 * n2;
    }

    public int multiplica(double n1, int n2) {
        int result = (int)n1 + n2;
        return result;
    }

    public int multiplica(int n1, double n2){
        int result = n1 + (int)n2;
        return result;
    }

    public int multiplica(float n1, float n2){
        int result = (int)(n1 * n2);
        return result;
    }

    public int multiplica(float n1, int n2) {
        int result = (int) n1 * n2;
        return result;
    }

    public int multiplica(int n1, float n2){
        int result = n1 * (int)n2;
        return result;
    }
}

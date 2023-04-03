package classes;
import classes.matematica;

public class multiplicaCast {

    private matematica m = new matematica();

    public multiplicaCast(matematica m) {
    }

    public int multiplica(int n1, int n2) {
        return (int) m.multiplica(n1, n2);
    }

    public int multiplica(float n1, float n2) {
        return (int) m.multiplica( n1, (int) n2);
    }

    public int multiplica(double n1, double n2) {
        return (int) m.multiplica( n1, n2);
    }

    public int multiplica(long n1, long n2) {
        return (int) m.multiplica( n1, n2);
    }

    public int multiplica(Float n1, Float n2) {
        return (int) m.multiplica(n1.floatValue(), n2.floatValue());
    }

    public int multiplica(Double n1, Double n2) {
        return (int) m.multiplica( n1.doubleValue(), n2.doubleValue());
    }

    public int multiplica(int n1, float n2) {
        return (int) m.multiplica(n1, n2);
    }

    public int multiplica(float n1, int n2) {
        return (int) m.multiplica(n1, n2);
    }

    public int multiplica(int n1, double n2) {
        return (int) m.multiplica(n1, n2);
    }

    public int multiplica(double n1, int n2) {
        return (int) m.multiplica(n1, n2);
    }

    public int multiplica(int n1, long n2) {
        return (int) m.multiplica(n1, n2);
    }

    public int multiplica(long n1, int n2) {
        return (int) m.multiplica( n1, n2);
    }

    public int multiplica(int n1, Float n2) {
        return (int) m.multiplica(n1, n2.floatValue());
    }

    public int multiplica(Float n1, int n2) {
        return (int) m.multiplica( n1.floatValue(), n2);
    }

    public int multiplica(int n1, Double n2) {
        return (int) m.multiplica(n1, n2.doubleValue());
    }

    public int multiplica(Double n1, int n2) {
        return (int) m.multiplica( n1.doubleValue(), n2);
    }
}
